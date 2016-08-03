---
Title: Set Wallpaper
Description: Set an image within the application cordova as wallpaper.
---

[![npm version](https://badge.fury.io/js/cordova-plugin-wallpaper.svg)](https://badge.fury.io/js/cordova-plugin-wallpaper)

[![Code Climate](https://codeclimate.com/github/fbsanches/cordova-plugin-wallpaper/badges/gpa.svg)](https://codeclimate.com/github/fbsanches/cordova-plugin-wallpaper)
[![Issue Count](https://codeclimate.com/github/fbsanches/cordova-plugin-wallpaper/badges/issue_count.svg)](https://codeclimate.com/github/fbsanches/cordova-plugin-wallpaper)

|Android|
|:-:|
|[![Build Status](https://travis-ci.org/flyingPotat0e/cordova-plugin-wallpaper.svg?branch=master)](https://travis-ci.org/flyingPotat0e/cordova-plugin-wallpaper)|

# cordova-plugin-wallpaper

This simple plugin gives you the ability of setting the systems wallpaper, either by using an image you brought with the application in its www-directory or by using a Base64-encoded string of an image. This lets you choose the image after the installation of the application and even change it afterwards, you just have to pass over a new Base64 encoded image.

##Table of Contents
1. [Installation](#installation)
2. [Usage](#usage)
3. [License](#license)
4. [Supported Platforms](#supported-platforms)

## Installation
stable npm package:
```
cordova plugin add cordova-plugin-wallpaper
```

maybe unstable GitHub-repository:
```
cordova plugin add https://github.com/fbsanches/cordova-plugin-wallpaper.git
```

##Usage
###Function(s)
####setImage
Sets image under given path as systems background image:
```javascript
window.plugins.wallpaper.setImage(string /* image path */);
```

#####Notes
 - path must not start with bar
 - path has not to start with backslash

#####Example
```javascript
window.plugins.wallpaper.setImage("img/mybackground.jpg");
```

---

####setImageBase64
Sets image contained in Base64 string as systems background image:
```javascript
window.plugins.wallpaper.setImageBase64(string /* Base64 string */);
```

#####Example
```javascript
window.plugins.wallpaper.setImageBase64(base64);
```

##License
The plugin is licensed under Apache 2.0.
The Apache 2.0 license can be found in the root directory of this project as well as the projects NOTICE.

##Supported Platforms
- Android
