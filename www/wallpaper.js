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

wallpaper.prototype.setImageBase64 = function(base64)
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
