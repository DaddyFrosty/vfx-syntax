# s&box Utilities

* VFX ( Valve Shading Language ) Syntax Support & Icons
* Rider force save
* Source code available for everything

Supports

* VS Code
* Rider
* Fleet (ish)

## Features

Well the header says it all. Icons are only set on Rider by importing a plugin in this repo.  
The Force Save works by setting the currently open file's last write time to the file's last write time.  
Force save basically just loops back the last edited time. It shouldn't actually affect the timestamp.  
There is also a macro included, it's a Rider user xml file. You can also add a keybinding
see [Rider Setup](#rider-setup).  
The macro instantly saves all files and calls the [TouchForRider.exe](Rider/TouchForRider.exe) to trigger a file change.

## Setup

For VS Code it's just a simple install. You can either git clone or search for "VFX Syntax Highlighter" or grab it [here](https://marketplace.visualstudio.com/items?itemName=DaddyFrosty.vfx) from the marketplace.

## Fleet
For fleet you just download the [Rider/vfx-textmate.zip](Rider/vfx-textmate.zip) and extract the folder into '%UserProfile%\.fleet\textmate'. And it will automatically detect .vfx and .hlsl files.

## Rider Setup

* <b>Saving</b> | Rider -> Settings -> File | Settings | Tools | External Tools. Add an entry named "Touch"  
  For reference see [Reference pictures](#file--settings--plugins--install-plugin-from-disk). Otherwise.  
  The name matters. Set the program to [Rider/TouchForRider.exe](Rider/TouchForRider.exe).  
  Set "Arguments" to the value below. Now you can set a keybinding for the tool or use the provided macro.
  <pre>&dollar;FilePath&dollar;</pre>
  
  
* <b>Macro Install</b> | For the macro start by opening "%appdata%\JetBrains\YOUR_RIDER_VERSION\options"  
Open the macros.xml and add the entry from [Rider/macros.xml](Rider/macros.xml). Save the file and restart Rider.  
You'll be able to bind a key to the Macro. Remember, the Macro is set to silently run Save All and run TouchForRider.exe
   Click on the "+" button and add the downloaded content.
  
  
* <b>Syntax Highlighting</b> | Download the contents of [Rider/vfx-textmate.zip](Rider/vfx-textmate.zip) open Rider -> Settings -> File | Settings | Editor | TextMate Bundles.  
  <b>VFX and HLSL Icons</b> | First you need to download the plugin from [Rider/VFX-Plugin.zip](Rider/VFX-Plugin.zip) or [plugins.jetbrains.com/plugin/19567-vfx-support](https://plugins.jetbrains.com/plugin/19567-vfx-support) if the plugin has been approved yet.
  Otherwise download it locally and go into Rider -> Settings -> File | Settings | Plugins. Right click on the cog which is next to the *Installed* tab.  
[Reference Image](#file--settings--plugins--install-plugin-from-disk)
  Choose "Install Plugin from Disk..." choose the downloaded zip file from [Rider/VFX-Plugin.zip](Rider/VFX-Plugin.zip).
  
  
<b>Now you are all setup. Enjoy!</b>

# Reference pictures

### File | Settings | Tools | External Tools

<img src="https://share.willswebsite.net/rider64_iD3RtNcrdU.png" width="50%">

### File | Settings | Plugins | Install Plugin from Disk

<img src="https://share.willswebsite.net/rider64_ky8gnH6d2Q.png" width="75%">

# Note
* The syntax definition is based on the open source HLSL definition for VS code.  
I have added a lot of stuff and made it comply with VFX's rules.
* The Rider plugin for icons is a based on https://github.com/jonathanlermitage/intellij-extra-icons-plugin.
* Any improvements or bugs feel free to contact me DaddyFrosty#4200 or make a PR. There is also a .jsonc file and .json for the syntax defintions.  
This is because Rider was reading .jsonc fine, but then when I wanted to use it in VS Code it couldn't read .jsonc. If you do make changes please do so in .jsonc.  
* I might end up writing a proper language parser soon tho, but writing VFX is very difficult sometimes, having pixel.input open and like three other files is very common and annoying.
* Also the performance of the TextMate syntaxer is suboptimal. It will be changed at some point but it's a issue create a issue or PR.
