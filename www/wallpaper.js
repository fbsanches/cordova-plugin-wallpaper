function wallpaper() {}

wallpaper.prototype.setImage = function(image, callback) {
    var services = "wallpaper";
    var dependentProperties = [];
    dependentProperties.push(image, false);

    var successCallback = function() {
      typeof callback === 'function' && callback();
    };

    var errorCallback = function(error) {
      var errorBack = error || 'unknown cordova error when setting wallpaper';
      typeof callback === 'function' && callback(errorBack);
    };

    var action = "start"; //future actions new entries. Fixed.
    if (image) {
        cordova.exec(successCallback, errorCallback, services, action, dependentProperties);
    }
};

function setBase64(base64, callback) {
    var services = "wallpaper";
    var dependentProperties = [];
    dependentProperties.push(base64, true);

    var successCallback = function() {
      typeof callback === 'function' && callback();
    };

    var errorCallback = function(error) {
      var errorBack = error || 'unknown cordova error when setting wallpaper';
      typeof callback === 'function' && callback(errorBack);
    };

    var action = "start"; //future actions new entries. Fixed.
    if(base64) {
        cordova.exec(successCallback, errorCallback, services, action, dependentProperties);
    }
}

wallpaper.prototype.setImageBase64 = function(base64, callback) {
    setBase64(base64, callback);
};

wallpaper.prototype.setImageHttp = function(url, callback) {
    var request = null;
    if(window.XMLHttpRequest) {
        request = new XMLHttpRequest();
    }
    else if(window.ActiveXObject) {
        try {
            request = new ActiveXObject("Msxml2.XMLHTTP.6.0") || new ActiveXObject("Msxml2.XMLHTTP.3.0");
        }
        catch(e) {
            typeof callback === 'function' && callback('XMLHttpRequest is not supported.');
        }
    }
    if(request == null) {
        typeof callback === 'function' && callback('XMLHttpRequest is not supported.');
    }
    else {
        function XHRload() {
            var array = new Uint8Array(request.response);
            var raw = '';
            var chunk = 5000;
            for (i = 0; i < array.length; i += chunk) {
                var subArray = array.subarray(i, i + chunk);
                raw += String.fromCharCode.apply(null, subArray);
            }
            var base64 = btoa(raw);
            setBase64(base64, callback);
        }
        function XHRerror(error) {
            typeof callback === 'function' && callback(error);
        }
        function XHRabort(error) {
            typeof callback === 'function' && callback(error);
        }
        request.responseType = "arraybuffer";
        request.addEventListener("load", XHRload);
        request.addEventListener("error", XHRerror);
        request.addEventListener("abort", XHRabort);
        request.open("GET", url, true);
        request.send();
    }
};

wallpaper.install = function() {
    if (!window.plugins) {
        window.plugins = {};
    }

    window.plugins.wallpaper = new wallpaper();
    return window.plugins.wallpaper;
};

cordova.addConstructor(wallpaper.install);
