<h1 style="display: flex; align-items: center; justify-content: center"><img src="src/main/resources/assets/qtech/icon.png" width="64" height="64" style="margin-right: 18px" alt="QTech Logo">QTech</h1>
<p style="text-align: center">
    <strong>Modern tech with a mythical twist.</strong>
    <br>
    <img alt="GitHub Workflow Status (branch)" src="https://img.shields.io/github/workflow/status/JustPyrrha/QTech/build/main?logo=GitHub%20Actions&amp;logoColor=white&amp;style=flat-square"/>
    <a target="_blank" rel="noreferrer" href="https://repo.pyrrha.gay/#browse/browse:maven:gay%2Fpyrrha%2FQTech"><img alt="Maven metadata URL" src="https://img.shields.io/maven-metadata/v?logo=apache%20maven&amp;metadataUrl=https%3A%2F%2Frepo.pyrrha.gay%2Frepository%2Fmaven%2Fgay%2Fpyrrha%2FQTech%2Fmaven-metadata.xml&amp;style=flat-square"/></a>
    <img alt="GitHub repo size" src="https://img.shields.io/github/repo-size/JustPyrrha/QTech?logo=github&amp;logoColor=white&amp;style=flat-square"/>
    <a target="_blank" rel="noreferrer" href="https://github.com/sponsors/JustPyrrha"><img alt="GitHub Sponsors" src="https://img.shields.io/github/sponsors/JustPyrrha?logo=github%20sponsors&amp;logoColor=white&amp;style=flat-square"/></a>
</p>

QTech puts a mythical spin on the classic tech mods of old. Every bit of energy transfer requires the use of a crystal to facilitate the procedure.
You can find one of these crystals below Y level -32 by chance when breaking amethyst crystals in geodes, and you'll be able to figure it out from there 
by unlocking recipes etc. (But if you do get stuck there is a wiki available [here](https://github.com/JustPyrrha/QTech/wiki).)

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
Community contributions are always welcome as long as you follow the guidelines laid out in the 
`.github/contributing.md` file available with the source code of this project.

### License
QTech is licensed under GNU General Public License v3, the full license text is available in the
LICENSE file located in the root of this project along with a short header included with every source file.
```
Copyright (C) 2022 JustPyrrha

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.
```