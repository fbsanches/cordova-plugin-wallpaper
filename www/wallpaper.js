function wallpaper() {}

wallpaper.prototype.setImage = function(image)
{
    var successCallback = null;
    var errorCallback = null;
    var services = "wallpaper";
    var dependentProperties = [];
    dependentProperties.push(image, false);

    var action = "start"; //future actions new entries. Fixed.
    if(image)
    {
        cordova.exec(successCallback, errorCallback, services, action, dependentProperties);
    }
};

function setBase64(base64)
{
    var successCallback = null;
    var errorCallback = null;
    var services = "wallpaper";
    var dependentProperties = [];
    dependentProperties.push(base64, true);

    var action = "start"; //future actions new entries. Fixed.
    if(base64)
    {
        cordova.exec(successCallback, errorCallback, services, action, dependentProperties);
    }
}

wallpaper.prototype.setImageBase64 = function(base64)
{
    setBase64(base64);
};

wallpaper.prototype.setImageHttp = function(url)
{
    var request = null;
    if(window.XMLHttpRequest)
    {
        request = new XMLHttpRequest();
    }
    else if(window.ActiveXObject)
    {
        try
        {
            request = new ActiveXObject("Msxml2.XMLHTTP.6.0") || new ActiveXObject("Msxml2.XMLHTTP.3.0");
        }
        catch(e)
        {
            console.warn("XMLHttpRequest not supported");
        }
    }
    if(request == null)
    {
        console.warn("XMLHttpRequest not supported");
    }
    else
    {
        function XHRload()
        {
            var array = new Uint8Array(request.response);
            var raw = "";
            var chunk = 5000;
            for (i = 0; i < array.length; i += chunk)
            {
                var subArray = array.subarray(i, i + chunk);
                raw += String.fromCharCode.apply(null, subArray);
            }
            var base64 = btoa(raw);
            setBase64(base64);
        }
        function XHRerror(error)
        {
            console.error(error);
        }
        function XHRabort(error)
        {
            console.warn(error);
        }
        request.responseType = "arraybuffer";
        request.addEventListener("load", XHRload);
        request.addEventListener("error", XHRerror);
        request.addEventListener("abort", XHRabort);
        request.open("GET", url, true);
        request.send();
    }
};

wallpaper.install = function()
{
    if (!window.plugins)
    {
        window.plugins = {};
    }

    window.plugins.wallpaper = new wallpaper();
    return window.plugins.wallpaper;
};

cordova.addConstructor(wallpaper.install);
