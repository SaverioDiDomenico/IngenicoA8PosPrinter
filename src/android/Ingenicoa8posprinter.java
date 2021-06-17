package android;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import android.content.Context;
import android.widget.Toast;
import android.os.RemoteException;


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
			sheetNum = sheetNumList.get(0); //verificare se si può rimuovere

		} catch (Exception e) {
			callbackContext.error(e.toString());
		}


	}
	*/

	private void print(String json_list, CallbackContext callbackContext) {
		String result = "OK";
		try {
			

			callbackContext.success(result);

		} catch (Exception e) {
			callbackContext.error(e.toString());
		}


	}


}
