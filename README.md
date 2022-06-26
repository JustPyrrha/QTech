![]()
![]()

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