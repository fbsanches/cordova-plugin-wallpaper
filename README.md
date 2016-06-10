---
Title: Set Wallpaper
Description: Set an image within the application cordova as wallpaper.
---

<!--
# license: Licensed to the Apache Software Foundation (ASF) under one
#         or more contributor license agreements.  See the NOTICE file
#         distributed with this work for additional information
#         regarding copyright ownership.  The ASF licenses this file
#         to you under the Apache License, Version 2.0 (the
#         "License"); you may not use this file except in compliance
#         with the License.  You may obtain a copy of the License at
#
#           http://www.apache.org/licenses/LICENSE-2.0
#
#         Unless required by applicable law or agreed to in writing,
#         software distributed under the License is distributed on an
#         "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
#         KIND, either express or implied.  See the License for the
#         specific language governing permissions and limitations
#         under the License.
-->


# cordova-plugin-wallpaper

This plugin is simple. It helps make it easier to use Operation System wallpapers, defining and direct by setting their cordova application, phonegap or Ionic.
PS: It is not to set a background of your activity, but defines an image that is in the www folder as operating system wallpaper.

## Installation

    cordova plugin add cordova-plugin-wallpaper

### Example

    window.plugins.wallpaper.setImagePath("img/mybackground.jpg");

### Parameter

	1. Image path. It must be in the www folder. The specified path must not start with bar. You do not start with backslash but generates an error. Follow example.

### Supported Platforms

- Android

### Use Tip Example

- Create a picture gallery application on the cordova/phonegap that has option to set the image as wallpaper.