# s&box Utilities
* VFX ( Valve Shading Language ) Syntax Support & Icons
* Rider force save
* Source code available for everything

Supports
* VS Code
* Rider

## Features
Well the header says it all. Icons are only set on Rider by importing a plugin in this repo.<br>
The Force Save works by setting the currently open file's last write time to the file's last write time.<br>
Force save basically just loops back the last edited time. It shouldn't actually affect the timestamp.<br>
There is also a macro included, it's a Rider user xml file. You can also add a keybinding see [Rider Setup](#rider-setup).<br>
The macro instantly saves all files and calls the [Rider/TouchForRider.exe](TouchForRider.exe) to trigger a file change.

## Setup
For VS Code it's just a simple install. You can either git clone or search for "VFX Syntax Highlighter" on the Marketplace.

## Rider Setup
* **Saving** | Rider -> Settings -> File | Settings | Tools | External Tools. Add an entry named "Touch"<br>
For reference see [File | Settings | Tools | External Tools](#Reference pictures). Otherwise.<br>
The name matters. Set the program to [Rider/TouchForRider.exe](Rider/TouchForRider.exe).<br>
Set "Arguments" to "$FilePath$" and you're done. You can set a keybinding for the tool or use the provided macro.
<br>
<br>
* **Macro Install** | For the macro start by opening "%appdata%\JetBrains\YOUR_RIDER_VERSION\options"<br>
Open the macros.xml and add the entry from [Rider/Macros.xml](Rider/Macros.xml). Save the file and restart Rider.<br>
You'll be able to bind a key to the Macro. Remember, the Macro is set to silently run Save All and run TouchForRider.exe
<br> Click on the "+" button and add the downloaded content.
<br>
<br>
* **Syntax Highlighting** | Download the contents of [Rider/vfx-textmate.zip](Rider/vfx-textmate.zip) open Rider -> Settings -> File | Settings | Editor | TextMate Bundles.<br>
<br>**VFX and HLSL Icons** | First you need to download the plugin from [Rider/VFX Icons.zip](Rider/VFX Icons-2022.1.7.zip) or [plugins.jetbrains.com/plugin/19567-vfx-support](https://plugins.jetbrains.com/plugin/19567-vfx-support) if the plugin has been approved yet.
<br>Otherwise download it locally and go into Rider -> Settings -> File | Settings | Plugins. Right click on the cog which is next to the *Installed* tab.
[Reference Image](#file--settings--plugins--install-plugin-from-disk)
<br>Choose "Install Plugin from Disk..." choose the downloaded zip file from [Rider/VFX Icons.zip](Rider/VFX Icons-2022.1.7.zip).
<br>
<br>
**Now you are all setup. Enjoy!**

# Reference pictures
### File | Settings | Tools | External Tools
<img src="https://share.willswebsite.net/rider64_iD3RtNcrdU.png" width="50%">

### File | Settings | Plugins | Install Plugin from Disk...
<img src="https://share.willswebsite.net/rider64_ky8gnH6d2Q.png" width="75%">