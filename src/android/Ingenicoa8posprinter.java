package it.dynamicid;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import android.content.Context;
import android.widget.Toast;
import android.os.RemoteException;
import android.app.Application;
import android.os.Build;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;


import com.usdk.apiservice.aidl.digled.Align;
import com.usdk.apiservice.aidl.printer.ASCScale;
import com.usdk.apiservice.aidl.printer.ASCSize;
import com.usdk.apiservice.aidl.printer.AlignMode;
import com.usdk.apiservice.aidl.printer.ECLevel;
import com.usdk.apiservice.aidl.printer.FactorMode;
import com.usdk.apiservice.aidl.printer.HZScale;
import com.usdk.apiservice.aidl.printer.HZSize;
import com.usdk.apiservice.aidl.printer.OnPrintListener;
import com.usdk.apiservice.aidl.printer.PrintFormat;
import com.usdk.apiservice.aidl.printer.PrinterData;
import com.usdk.apiservice.aidl.printer.PrinterError;
import com.usdk.apiservice.aidl.printer.UPrinter;

import com.usdk.apiservice.aidl.constants.RFDeviceName;
import com.usdk.apiservice.aidl.pinpad.DeviceName;


public class Ingenicoa8posprinter extends CordovaPlugin {
	
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if ("print".equals(action)) {
			print(args.getString(0), callbackContext);
			return true;
		}

		return false;
	}

	/*
	private static final List<Integer> sheetNumList = new LinkedList<>(Arrays.asList(1, 2, 3));
	private UPrinter printer;
	private int sheetNum;
	private int validWidth;
	*/

	/*
	private void inizializzazione(CallbackContext callbackContext) {
		try {
			Context context = this.cordova.getActivity().getApplicationContext();							
			this.printer = DeviceHelper.me().getPrinter();
			this.validWidth = this.printer.getValidWidth();
			sheetNum = sheetNumList.get(0); //verificare se si puÃ² rimuovere

		} catch (Exception e) {
			callbackContext.error(e.toString());
		}


	}
	*/

	private void print(String json_list, CallbackContext callbackContext) {
		String result = "OK";
		try {
		if (Build.MODEL.startsWith("AECR")) {
			DemoConfig.PINPAD_DEVICE_NAME = DeviceName.COM_EPP;
			DemoConfig.RF_DEVICE_NAME = RFDeviceName.EXTERNAL;
		} else {
			DemoConfig.PINPAD_DEVICE_NAME = DeviceName.IPP;
			DemoConfig.RF_DEVICE_NAME = RFDeviceName.INNER;
		}
			
			Toast.makeText(webView.getContext(), "0", Toast.LENGTH_LONG).show();
			Context context = this.cordova.getActivity().getApplicationContext();
			Toast.makeText(webView.getContext(), "1", Toast.LENGTH_LONG).show();
			
			DeviceHelper.me().init(this.cordova.getActivity().getApplication());
			DeviceHelper.me().bindService();
			
			
			UPrinter printer = DeviceHelper.me().getPrinter();
			Toast.makeText(webView.getContext(), "2", Toast.LENGTH_LONG).show();

			//int validWidth = printer.getValidWidth();
			//List<Integer> sheetNumList = new LinkedList<>(Arrays.asList(1, 2, 3));
			//int sheetNum = sheetNumList.get(0); //verificare se si puÃ² rimuovere

			json_list = json_list.replaceAll("\\[", "").replaceAll("\\]", "");
			String jl[] = json_list.split("~~~");

			for(int i=0; i<jl.length; i++) {

				String json = jl[i];
				//System.out.println(json);
				Toast.makeText(webView.getContext(), json, Toast.LENGTH_LONG).show();
				

				PrintData pd = PrintData.ElaborateJson(json);			 
				String type = pd.getType();	
				String data = pd.getData();

				if(type.equalsIgnoreCase("qr")) {

					int align = AlignMode.CENTER;
					if(pd.getQrAlign().equalsIgnoreCase("left")) {
						align = AlignMode.LEFT;
					}else if(pd.getQrAlign().equalsIgnoreCase("right")) {
						align = AlignMode.RIGHT;
					}

					int size = Integer.parseInt(pd.getQrHeight());				 

					printer.addQrCode(align, size, ECLevel.ECLEVEL_H, data);

				}else if(type.equalsIgnoreCase("barcode")) {

					int align = AlignMode.CENTER;
					if(pd.getBarcodeAlign().equalsIgnoreCase("left")) {
						align = AlignMode.LEFT;
					}else if(pd.getBarcodeAlign().equalsIgnoreCase("right")) {
						align = AlignMode.RIGHT;
					}

					int size1 = Integer.parseInt(pd.getBarcodeWith());
					int size2 = Integer.parseInt(pd.getBarcodeHeight());

					if(size1>8) {
						size1=8;
					}
					if(size2>320) {
						size2=320;
					}

					printer.addBarCode(align, 2, 48,  data);

				}else if(type.equalsIgnoreCase("image")) {

					try {
						int offset = Integer.parseInt(pd.getImageOffset());				 
						byte[] image = MyBase64.decode(data);
						//System.out.println("TEST");

						printer.addBmpImage(offset, FactorMode.BMP1X1, image);
					}catch (Exception e) {
						//System.out.println(e);
					}
				}else if(type.equalsIgnoreCase("text")) {

					int align = AlignMode.CENTER;
					if(pd.getTextAlign().equalsIgnoreCase("left")) {
						align = AlignMode.LEFT;
					}else if(pd.getTextAlign().equalsIgnoreCase("right")) {
						align = AlignMode.RIGHT;
					}

					int ascscale = ASCScale.SC1x1;
					if(pd.getTextAscScale().equalsIgnoreCase("1x2")) {
						ascscale = ASCScale.SC1x2;
					}
					if(pd.getTextAscScale().equalsIgnoreCase("1x3")) {
						ascscale = ASCScale.SC1x3;
					}
					if(pd.getTextAscScale().equalsIgnoreCase("2x1")) {
						ascscale = ASCScale.SC2x1;
					}
					if(pd.getTextAscScale().equalsIgnoreCase("2x2")) {
						ascscale = ASCScale.SC2x2;
					}
					if(pd.getTextAscScale().equalsIgnoreCase("2x3")) {
						ascscale = ASCScale.SC2x3;
					}
					if(pd.getTextAscScale().equalsIgnoreCase("3x1")) {
						ascscale = ASCScale.SC3x1;
					}
					if(pd.getTextAscScale().equalsIgnoreCase("3x2")) {
						ascscale = ASCScale.SC3x2;
					}
					if(pd.getTextAscScale().equalsIgnoreCase("3x3")) {
						ascscale = ASCScale.SC3x3;
					}				
					printer.setAscScale(ascscale);

					int ascsize = ASCSize.DOT16x8;
					if(pd.getTextAscSize().equalsIgnoreCase("24x2")) {
						ascsize = ASCSize.DOT24x12;
					}
					if(pd.getTextAscSize().equalsIgnoreCase("24x8")) {
						ascsize = ASCSize.DOT24x8;
					}
					if(pd.getTextAscSize().equalsIgnoreCase("32x12")) {
						ascsize = ASCSize.DOT32x12;
					}
					if(pd.getTextAscSize().equalsIgnoreCase("5x7")) {
						ascsize = ASCSize.DOT5x7;
					}
					if(pd.getTextAscSize().equalsIgnoreCase("7x7")) {
						ascsize = ASCSize.DOT7x7;
					}				
					printer.setAscSize(ascsize);

					int hzscale = HZScale.SC1x1;
					if(pd.getTextHzScale().equalsIgnoreCase("1x2")) {
						ascsize = HZScale.SC1x2;
					}	
					if(pd.getTextHzScale().equalsIgnoreCase("1x3")) {
						ascsize = HZScale.SC1x3;
					}
					if(pd.getTextHzScale().equalsIgnoreCase("2x1")) {
						ascsize = HZScale.SC2x1;
					}
					if(pd.getTextHzScale().equalsIgnoreCase("2x2")) {
						ascsize = HZScale.SC2x2;
					}
					if(pd.getTextHzScale().equalsIgnoreCase("2x3")) {
						ascsize = HZScale.SC2x3;
					}
					if(pd.getTextHzScale().equalsIgnoreCase("3x1")) {
						ascsize = HZScale.SC3x1;
					}
					if(pd.getTextHzScale().equalsIgnoreCase("3x2")) {
						ascsize = HZScale.SC3x2;
					}
					if(pd.getTextHzScale().equalsIgnoreCase("3x3")) {
						ascsize = HZScale.SC3x3;
					}		        
					printer.setHzScale(hzscale);

					int hzsize = HZSize.DOT16x16;
					if(pd.getTextHzSize().equalsIgnoreCase("24x16")) {
						hzsize = HZSize.DOT24x16;
					}
					if(pd.getTextHzSize().equalsIgnoreCase("24x24")) {
						hzsize = HZSize.DOT24x24;
					}
					if(pd.getTextHzSize().equalsIgnoreCase("32x24")) {
						hzsize = HZSize.DOT32x24;
					}		        
					printer.setHzSize(hzsize);


					printer.addText(align, data);

				}

			}

			printer.startPrint(new OnPrintListener.Stub() {
				@Override
				public void onFinish() throws RemoteException {
					//result = "OK";
				}

				@Override
				public void onError(int error) throws RemoteException {
					//result = "Errore: " + error;
				}
			});
			
			DeviceHelper.me().unbindService();

			callbackContext.success(result);

		} catch (Exception e) {
			callbackContext.error(e.toString());
		}


	}


}
