---
Title: Set Wallpaper
Description: Set an image within the application cordova as wallpaper.
---

[![npm version][version-img]][version-url]

[![Code Climate][cc-img]][cc-url]
[![Issue Count][cc-issues-img]][cc-issues-url]

|Android|
|:-:|
|[![Build Status][android-img]][android-url]|

# cordova-plugin-wallpaper

This simple plugin gives you the ability of setting the systems wallpaper, either by using an image you brought with the application in its www-directory or by using a Base64-encoded string of an image. This lets you choose the image after the installation of the application and even change it afterwards, you just have to pass over a new Base64 encoded image.

## Table of Contents
1. [Installation](#installation)
2. [Usage](#usage)
3. [License](#license)
4. [Supported Platforms](#supported-platforms)

## Installation
```
cordova plugin add https://github.com/ragcsalo/cordova-plugin-wallpaper.git
```

## Usage
### Function(s)

#### saveWallpaper
Saves the current Homescreen wallpaper as a Base64 string to Shared Preferences:
```javascript
window.plugins.wallpaper.saveWallpaper();
```

##### Notes
 - Homescreen wallpaper is stored as a Base64 string
 - saved to Shared Preferences named "WallpaperPref", in a String named "original_wallpaper"
 - if you want to restore the saved wallpaper, you can use the SharedPreferences plugin to retrieve it:
 
```
cordova plugin add https://github.com/ragcsalo/SharedPreferences.git
```

##### Example: retrieve and restore the saved wallpaper
```javascript
sharedpreferences.getSharedPreferences("WallpaperPref", "MODE_PRIVATE", function() {
  sharedpreferences.getString("original_wallpaper", function(wp64){
    window.plugins.wallpaper.setImageBase64(wp64);
  }, function(err) {console.log('ERROR: '+err);});
}, function(err) {console.log('ERROR: '+err);});
```

---

#### setImage
Sets image under given path as Homescreen or Lockscreen background image:
```javascript
window.plugins.wallpaper.setImage(string [image path], string [type]);
```

##### Notes
 - path must not start with bar
 - path has not to start with backslash
 - add second parameter 'lock' if you want to set the Lockscreen wallpaper

##### Example
```javascript
window.plugins.wallpaper.setImage('img/mybackground.jpg'); // set Homescreen wallpaper
window.plugins.wallpaper.setImage('img/mybackground.jpg','lock'); // set Lockscreen wallpaper
```

---

#### setImageHttp
Sets image from URL as background image:
```javascript
window.plugins.wallpaper.setImageHttp(string [image URL], string [type]);
```

##### Example
```javascript
window.plugins.wallpaper.setImageHttp('https://example.com/image.jpg'); // set Homescreen wallpaper
window.plugins.wallpaper.setImageHttp('https://example.com/image.jpg','lock'); // set Lockscreen wallpaper
```

---

#### setImageBase64
Sets image contained in Base64 string as background image:
```javascript
window.plugins.wallpaper.setImageBase64(string [Base64 string], string [type]);
```

##### Example
```javascript
window.plugins.wallpaper.setImageBase64(base64); // set Homescreen wallpaper
window.plugins.wallpaper.setImageBase64(base64,'lock'); // set Lockscreen wallpaper
```

### Callbacks
Every function provides optional callbacks. The callback provides an error parameter in case there is an error. If there is no error, everything went well:
```javascript
window.plugins.wallpaper.setImage('path/to/image.png', function(error) {
  if (error) {
    console.error(error);
  }
  else {
    console.log('Success setting wallpaper.');
  }
});
```

## License
The plugin is licensed under Apache 2.0.
The Apache 2.0 license can be found in the root directory of this project as well as the projects NOTICE.

## Supported Platforms
- Android

[version-img]: https://img.shields.io/npm/v/cordova-plugin-wallpaper.svg?style=flat-square&colorA=999999&maxAge=10
[version-url]: https://www.npmjs.com/package/cordova-plugin-wallpaper
[cc-img]: https://img.shields.io/codeclimate/github/fbsanches/cordova-plugin-wallpaper.svg?style=flat-square&colorA=999999&maxAge=10
[cc-url]: https://codeclimate.com/github/fbsanches/cordova-plugin-wallpaper
[cc-issues-img]: https://img.shields.io/codeclimate/issues/github/fbsanches/cordova-plugin-wallpaper.svg?style=flat-square&colorA=999999&maxAge=10
[cc-issues-url]: https://codeclimate.com/github/fbsanches/cordova-plugin-wallpaper/issues
[android-img]: https://img.shields.io/circleci/project/github/fbsanches/cordova-plugin-wallpaper.svg?style=flat-square&colorA=999999&maxAge=10
[android-url]: https://circleci.com/gh/fbsanches/cordova-plugin-wallpaper
