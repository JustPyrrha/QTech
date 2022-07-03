import java.time.Year

plugins {
    java
    id("org.quiltmc.loom") version "0.12.+"
    id("io.github.juuxel.loom-quiltflower") version "1.7.+"
    id("com.modrinth.minotaur") version "2.+"
    id("org.cadixdev.licenser") version "0.6.+"
    `maven-publish`
}

var buildNumber = "local"
if (System.getenv().containsKey("GITHUB_RUN_NUMBER")) {
    buildNumber = System.getenv("GITHUB_RUN_NUMBER")
}

group = "gay.pyrrha"
version = "0.0.0-beta+1.19-b.${buildNumber}"
base.archivesName.set("QTech")

repositories {
    mavenCentral()
}

loom {
    runtimeOnlyLog4j.set(true)
    accessWidenerPath.set(project.file("src/main/resources/qtech.aw"))
    mixin {
        add(sourceSets.main.get(), "${project.name}.refmap.json")
    }
}

dependencies {
    minecraft("com.mojang:minecraft:1.19")
    mappings(loom.layered {
        addLayer(quiltMappings.mappings("org.quiltmc:quilt-mappings:1.19+build.1:v2"))
    })

    modImplementation("org.quiltmc:quilt-loader:0.17.1-beta.4")
    modImplementation("org.quiltmc:qsl:2.0.0-beta.9+1.19")
}

tasks.processResources {
    inputs.property("version", version)

    filesMatching("quilt.mod.json") {
        expand("version" to version)
    }
}

tasks.jar {
    from("LICENSE") {
        rename { "${it}_${base.archivesName}" }
    }
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
    withSourcesJar()
    withJavadocJar()
}

modrinth {
    version = project.version
    versionType.set(
            if (project.version.toString().contains("-alpha")) "alpha"
            else if (project.version.toString().contains("-beta")) "beta"
            else "release"
    )
}

license {
    header(project.file("HEADER"))
    include("**/gay/pyrrha/qtech/**/*.java")
    properties {
        set("year", Year.now())
        set("author", "Pyrrha \"JustPyrrha\" Wills")
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components.getByName("java"))
            pom {
                name.set("QTech")

                licenses {
                    license {
                        name.set("GNU General Public License v3.0 or later")
                        url.set("https://www.gnu.org/licenses/gpl-3.0-standalone.html")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/JustPyrrha/QTech.git")
                    developerConnection.set("scm:git:ssh://github.com/JustPyrrha/QTech.git")
                    url.set("https://github.com/JustPyrrha/QTech")
                }
            }
        }
    }
    repositories {
        if (project.version.toString().contains("-b.local")) {
            mavenLocal()
        } else {
            val repoType = if (project.version.toString().contains("-beta")
                    || project.version.toString().contains("-alpha")
            ) "snapshots" else "releases"
            maven("https://repo.pyrrha.gay/repository/maven-$repoType/") {
                credentials(PasswordCredentials::class)
            }
        }
    }
}
