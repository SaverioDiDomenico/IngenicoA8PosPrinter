var exec = cordova.require('cordova/exec');

var Ingenicoa8posprinter = function() {
    console.log('Ingenicoa8posprinter instanced');
};

Ingenicoa8posprinter.prototype.print = function(json_list, onSuccess, onError) {
    var errorCallback = function(obj) {
        onError(obj);
    };

    var successCallback = function(obj) {
        onSuccess(obj);
    };

    exec(successCallback, errorCallback, 'Ingenicoa8posprinter', 'print', [json_list]);
};

if (typeof module != 'undefined' && module.exports) {
    module.exports = Ingenicoa8posprinter;
}
