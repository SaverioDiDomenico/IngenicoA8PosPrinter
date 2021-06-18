# IngenicoA8PosPrinter
Whit this plugin it's possible to Print whit Ingenico POS A8 model.


## Supported Platforms
* Android (only)

## Installing

### Cordova

    $ cordova plugin add https://github.com/SaverioDiDomenico/cordova-plugin-ingenicoa8posprinter

### PhoneGap

    $ phonegap plugin add https://github.com/SaverioDiDomenico/cordova-plugin-ingenicoa8posprinter

## Uninstall

### Cordova

    $ cordova plugin remove cordova-plugin-ingenicoa8posprinter

### PhoneGap

    $ phonegap plugin remove cordova-plugin-ingenicoa8posprinter
    


## Methods
- print

## print

Can print a List of json objects that are separated by "~~~", see example below or DemoCall.js file.

    var json_list = "{\"type\":\"qr\", \"data\": \"www.dynamic-id.it\", \"qrAlign\": \"center\", \"qrHeight\": \"240\" }";
    json_list += "~~~";
    json_list += "{\"type\":\"barcode\", \"data\": \"1234567890ABCDEF\", \"barcodeAlign\": \"center\", \"barcodeHeight\": \"64\", \"barcodeWith\": \"2\" }";
    json_list += "~~~";
    json_list += "{\"type\":\"image\", \"data\": \"BASE64IMAGE", \"imageOffset\": \"0\" }";
    json_list += "~~~";
    json_list += "{\"type\":\"text\", \"data\": \"www.dynamic-id.it\", \"textAlign\": \"center\", \"textAscScale\": \"2x2\", \"textHzScale\": \"2x2\", \"textAscSize\": \"24x12\", \"textHzSize\": \"24x24\" }";




# Credits

Company: 
Dynamic ID Srl - Web: www.dynamic-id.it - Email: info@dynamic-id.it

Developers: 
Saverio Di Domenico (didomenico@dynamic-id.it) - Luigi Casiello (casiello@dynamic-id.it)
