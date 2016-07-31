---
Title: Set Wallpaper
Description: Set an image within the application cordova as wallpaper.
---

[![Code Climate](https://codeclimate.com/github/fbsanches/cordova-plugin-wallpaper/badges/gpa.svg)](https://codeclimate.com/github/fbsanches/cordova-plugin-wallpaper)
[![Issue Count](https://codeclimate.com/github/fbsanches/cordova-plugin-wallpaper/badges/issue_count.svg)](https://codeclimate.com/github/fbsanches/cordova-plugin-wallpaper)

# cordova-plugin-wallpaper

This simple plugin gives you the ability of setting the systems wallpaper, either by using an image you brought with the application in its www-directory or by using a Base64-encoded string of an image. This lets you choose the image after the installation of the application and even change it afterwards, you just have to pass over a new Base64 encoded image.

##Table of Contents
1. [Installation](#installation)
2. [Usage](#usage)
3. [License](#license)
4. [Supported Platforms](#supported-platforms)

## Installation
```
cordova plugin add cordova-plugin-wallpaper
```

##Usage
###Function(s)
####setImage
Sets image under given path or image contained in Base64 string as systems background image:
```javascript
window.plugins.wallpaper.setImage(string /*image path or Base64 string*/, boolean /*flag for using Base64*/);
```
#####Notes
 - path must not start with bar
 - path has not to start with backslash

#####Example
with image from www-directory:

```javascript
window.plugins.wallpaper.setImage("img/mybackground.jpg");
```

with Base64 string:

```javascript
window.plugins.wallpaper.setImage(base64, true);
```

##License
The plugin is licensed under Apache 2.0.
The Apache 2.0 license can be found in the root directory of this project as well as the projects NOTICE.

##Supported Platforms
- Android
