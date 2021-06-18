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

To Print a QrCode
Json must contain these fields:
- type = qr
- data = INFORMATION YOU WANT TO PRINT (for example a web link)
- qrAlign = center | left | right
- qrHeight = height in px (for example 240)

To Print a BarCode
Json must contain these fields:
- type = barcode
- data = INFORMATION YOU WANT TO PRINT (for example a code of a product)
- barcodeAlign = center | left | right
- barcodeHeight = height in this interval [1-320]
- barcodeWidth = width in this interval [1-8]

To Print an Image
Json must contain these fields:
- type = image
- data = Base64 BMP Image(must be BMP max width 384Pix)
- imageOffset = right offset for example 0 px

To Print a Text
Json must contain these fields:
- type = text
- data = text you want to print
- textAlign = center | left | right
- textAscScale = possible values 1x1, 1x2, 1x3, 2x1, 2x2, 2x3, 3x1, 3x2, 3x3
- textAscSize = possible values 16x8, 24x2, 24x8, 32x12, 5x7, 7x7
- textHzScale = possible values 1x1, 1x2, 1x3, 2x1, 2x2, 2x3, 3x1, 3x2, 3x3
- textHzSize = possible values 16x16, 24x16, 24x24, 32x24


# Credits

Company: 
Dynamic ID Srl - Web: www.dynamic-id.it - Email: info@dynamic-id.it

Developers: 
Saverio Di Domenico (didomenico@dynamic-id.it) - Luigi Casiello (casiello@dynamic-id.it)
