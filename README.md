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
stable npm package:
```
cordova plugin add cordova-plugin-wallpaper
```

maybe unstable GitHub-repository:
```
cordova plugin add https://github.com/fbsanches/cordova-plugin-wallpaper.git
```

## Usage
### Function(s)
#### setImage
Sets image under given path as systems background image:
```javascript
window.plugins.wallpaper.setImage(string /* image path */);
```

##### Notes
 - path must not start with bar
 - path has not to start with backslash

##### Example
```javascript
window.plugins.wallpaper.setImage('img/mybackground.jpg');
```

---

#### setImageHttp
Sets image from url as background image:
```javascript
window.plugins.wallpaper.setImageHttp(string /* url */);
```

##### Example
```javascript
window.plugins.wallpaper.setImageHttp('https://example.com/image.jpg');
```

---

#### setImageBase64
Sets image contained in Base64 string as systems background image:
```javascript
window.plugins.wallpaper.setImageBase64(string /* Base64 string */);
```

##### Example
```javascript
window.plugins.wallpaper.setImageBase64(base64);
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
