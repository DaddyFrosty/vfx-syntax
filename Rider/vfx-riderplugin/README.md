<h1 align="center">
      <img src="./src/main/resources/META-INF/pluginIcon.png" width="84" height="84" alt="logo"/>
    </a><br/>
    Extra Icons
</h1>

# VFX Support

## Creators
* This is a copy and paste of [https://github.com/jonathanlermitage/intellij-extra-icons-plugin/](https://github.com/jonathanlermitage/intellij-extra-icons-plugin/)
* It is used as a base for just Icons.
## License

MIT License. In other words, you can do what you want: this project is entirely OpenSource, Free and Gratis.  
You only have to pay a subscription if you want to support my work by using the version that is published to the JetBrains marketplace. If you don't want to (or can't) support my work, you can still use old releases (up to 1.69), or package and install your own release for free. If you have any question, please see the [license FAQ](docs/LICENSE_FAQ.md).


## Contributors

* (author) Jonathan Lermitage (<jonathan.lermitage@gmail.com>)
* Edoardo Luppi (<lp.edoardo@gmail.com>)
* Matthias Kunnen ([github.com/MatthiasKunnen](https://github.com/MatthiasKunnen))
* Florian Böhm ([github.com/Sheigutn](https://github.com/Sheigutn))
* Mateusz Bajorek (<mateusz.bajorek@gmail.com>)
* Bouteiller Alan ([github.com/bouteillerAlan](https://github.com/bouteillerAlan))
* Gaëtan Maisse ([github.com/gaetanmaisse](https://github.com/gaetanmaisse))
* [Other contributors list](https://github.com/jonathanlermitage/intellij-extra-icons-plugin/graphs/contributors)
## Download

Download plugin from the [JetBrains marketplace](https://plugins.jetbrains.com/plugin/11058-extra-icons) or via your IDE: <kbd>File</kbd>, <kbd>Settings...</kbd>, <kbd>Plugins</kbd>, <kbd>Marketplace</kbd>.

## Build

Install JDK11+. You should be able to start Gradle Wrapper (`gradlew`). See Gradle commands below.

### Gradle commands

```bash
$ ./gradlew buildPlugin        # build plugin to build/distributions/*.zip
$ ./gradlew runIde             # try plugin in a standalone IDE
$ ./gradlew ~~dependencyUpdates~~  # check for dependencies updates
$ ./gradlew verifyPlugin       # validate plugin.xml descriptors as well as plugin's archive structure
$ ./gradlew runPluginVerifier  # check for compatibility issues with IDE
$ ./gradlew test               # run tests
```

Additionally, take a look at the `Makefile` script: it contains useful commands to build, run and test the plugin, check for dependencies updates and some maintenance tasks. Show available commands by running `make help`.

### Optimizations

Optionally, you may want to install SVGO in order to optimize SVG icons. Install SVGO with `npm install -g svgo`, then optimize SVG files by running `make svgo`.
