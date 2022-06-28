![GitHub Workflow Status (branch)](https://img.shields.io/github/workflow/status/JustPyrrha/QTech/build/main?logo=GitHub%20Actions&logoColor=white&style=flat-square)
[![Maven metadata URL](https://img.shields.io/maven-metadata/v?logo=apache%20maven&metadataUrl=https%3A%2F%2Frepo.pyrrha.gay%2Frepository%2Fmaven%2Fgay%2Fpyrrha%2FQTech%2Fmaven-metadata.xml&style=flat-square)](https://repo.pyrrha.gay/#browse/browse:maven:gay%2Fpyrrha%2FQTech)
![GitHub repo size](https://img.shields.io/github/repo-size/JustPyrrha/QTech?logo=github&logoColor=white&style=flat-square)
[![GitHub Sponsors](https://img.shields.io/github/sponsors/JustPyrrha?logo=github%20sponsors&logoColor=white&style=flat-square)](https://github.com/sponsors/JustPyrrha)

# QTech
Modern tech with a mythical twist.


<!-- modrinth_exclude.start -->

### Developers
QTech is available on my maven repo:

<details open="open"><summary>Groovy DSL</summary>

```groovy
repositories {
    maven {
        url = "http://repo.pyrrha.gay/repository/maven/"
        name = "JustPyrrha"
    }
}

dependencies {
    modImplementation "gay.pyrrha:QTech:$version"
}
```
</details>
<details><summary>Kotlin DSL</summary>

```groovy
repositories {
    maven("http://repo.pyrrha.gay/repository/maven/") {
        name = "JustPyrrha"
    }
}

dependencies {
    modImplementation("gay.pyrrha:QTech:$version")
}
```
</details>

### Contributing

### License


<!-- modrinth_exclude.end -->