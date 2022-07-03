<p align="center" style="margin-bottom: 0px !important;">
    <img src="src/main/resources/assets/qtech/icon.png" width="64" alt="QTech logo">
</p>
<h1 align="center" style="margin-top: 0px;">QTech</h1>
<p align="center"><strong>Modern tech with a mythical twist.</strong>

<div align="center">

![GitHub Workflow Status (branch)](https://img.shields.io/github/workflow/status/JustPyrrha/QTech/build/main?logo=GitHub%20Actions&amp;logoColor=white&amp;style=flat-square)
[![Maven metadata URL](https://img.shields.io/maven-metadata/v?logo=apache%20maven&amp;metadataUrl=https%3A%2F%2Frepo.pyrrha.gay%2Frepository%2Fmaven%2Fgay%2Fpyrrha%2FQTech%2Fmaven-metadata.xml&amp;style=flat-square)](https://repo.pyrrha.gay/#browse/browse:maven:gay%2Fpyrrha%2FQTech)
![GitHub repo size](https://img.shields.io/github/repo-size/JustPyrrha/QTech?logo=github&amp;logoColor=white&amp;style=flat-square)
[![GitHub Sponsors](https://img.shields.io/github/sponsors/JustPyrrha?logo=github%20sponsors&amp;logoColor=white&amp;style=flat-square)](https://github.com/sponsors/JustPyrrha)

</div>

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

## == We're Using GitHub Under Protest ==

This project is currently hosted on GitHub.  This is not ideal; GitHub is a
proprietary, trade-secret system that is not Free and Open Source Software
(FOSS).  We are deeply concerned about using a proprietary system like GitHub
to develop our FOSS project. 

We urge you to read about the
[Give up GitHub](https://GiveUpGitHub.org) campaign from
[the Software Freedom Conservancy](https://sfconservancy.org) to understand
some reasons why GitHub is not a good place to host FOSS projects.

Any use of this project's code by GitHub Copilot, past or present, is done
without our permission.  We do not consent to GitHub's use of this project's
code in Copilot.

![Logo of the GiveUpGitHub campaign](https://sfconservancy.org/img/GiveUpGitHub.png)