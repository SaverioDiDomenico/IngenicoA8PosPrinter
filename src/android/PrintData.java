package android;

import com.google.gson.Gson;

public class PrintData {
	
	private String type;			//text, qr, barcode, image
	private String data;			//text or base64 image
		
	//Text Properties
	private String textAlign;		//center, left, right
	private String textAscScale;	//1x1, 1x2, 1x3, 2x1, 2x2, 2x3, 3x1, 3x2, 3x3
	private String textAscSize;		//16x8, 24x2, 24x8, 32x12, 5x7, 7x7
	private String textHzScale;		//1x1, 1x2, 1x3, 2x1, 2x2, 2x3, 3x1, 3x2, 3x3
	private String textHzSize;		//16x16, 24x16, 24x24, 32x24
	
	//QR Properties
	private String qrAlign;			//center, left, right
	private String qrHeight;		//240
	
	//Barcode Properties
	private String barcodeAlign;	//center, left, right
	private String barcodeHeight;	//[1-320]
	private String barcodeWith;		//[1-8]
	
	
	//Image Properties (must be BMP max width 384Pix)
	private String imageOffset;		//0


	



	public PrintData(String type, String data, String textAlign, String textAscScale, String textAscSize,
			String textHzScale, String textHzSize, String qrAlign, String qrHeight, String barcodeAlign,
			String barcodeHeight, String barcodeWith, String imageOffset) {
		super();
		this.type = type;
		this.data = data;
		this.textAlign = textAlign;
		this.textAscScale = textAscScale;
		this.textAscSize = textAscSize;
		this.textHzScale = textHzScale;
		this.textHzSize = textHzSize;
		this.qrAlign = qrAlign;
		this.qrHeight = qrHeight;
		this.barcodeAlign = barcodeAlign;
		this.barcodeHeight = barcodeHeight;
		this.barcodeWith = barcodeWith;
		this.imageOffset = imageOffset;
	}


	public String getTextAlign() {
		return textAlign;
	}


	public void setTextAlign(String textAlign) {
		this.textAlign = textAlign;
	}


	public String getTextAscScale() {
		return textAscScale;
	}


	public void setTextAscScale(String textAscScale) {
		this.textAscScale = textAscScale;
	}


	public String getTextAscSize() {
		return textAscSize;
	}


	public void setTextAscSize(String textAscSize) {
		this.textAscSize = textAscSize;
	}


	public String getTextHzScale() {
		return textHzScale;
	}


	public void setTextHzScale(String textHzScale) {
		this.textHzScale = textHzScale;
	}


	public String getTextHzSize() {
		return textHzSize;
	}


	public void setTextHzSize(String textHzSize) {
		this.textHzSize = textHzSize;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public String getQrAlign() {
		return qrAlign;
	}


	public void setQrAlign(String qrAlign) {
		this.qrAlign = qrAlign;
	}


	public String getQrHeight() {
		return qrHeight;
	}


	public void setQrHeight(String qrHeight) {
		this.qrHeight = qrHeight;
	}


	public String getBarcodeAlign() {
		return barcodeAlign;
	}


	public void setBarcodeAlign(String barcodeAlign) {
		this.barcodeAlign = barcodeAlign;
	}


	public String getBarcodeHeight() {
		return barcodeHeight;
	}


	public void setBarcodeHeight(String barcodeHeight) {
		this.barcodeHeight = barcodeHeight;
	}


	public String getBarcodeWith() {
		return barcodeWith;
	}


	public void setBarcodeWith(String barcodeWith) {
		this.barcodeWith = barcodeWith;
	}


	public String getImageOffset() {
		return imageOffset;
	}


	public void setImageOffset(String imageOffset) {
		this.imageOffset = imageOffset;
	}
	
	
	public static PrintData ElaborateJson(String json) {
		

		Gson gson = new Gson();
		PrintData pd = gson.fromJson(json, PrintData.class);		
		return pd;		
	}

	
}
