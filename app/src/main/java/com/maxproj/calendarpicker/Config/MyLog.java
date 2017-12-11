package com.maxproj.calendarpicker.Config;


//import android.widget.Toast;


/**
 * http://stackoverflow.com/questions/2018263/android-logging
 * 
 * improved by Max You
 *
 */
public class MyLog {

	public static final String LIFECYCLE = "lifecycle";
	
	
	public static int LEVEL = android.util.Log.DEBUG;

	/**
	 *	switch:
	 *		outputSwitch = 0
	 *			no output
	 * 		outputSwitch = 1
	 * 			admit output by tagFilter
	 * 		outputSwitch = 2
	 * 			ban output by tagFilter
	 * 		outputSwitch = 3
	 * 			output all
	 */
	public static int outputSwitch = 3;
	public static String tagFilter = LIFECYCLE;
	public static int log2FileSwitch = 0;


	
	static public void d(String tag, String msgFormat, Object... args) {

//		if (MyConfig.compile_type_release){
//			return;
//		}

		if(outputSwitch == 0)
			return;
		
		if(outputSwitch == 1){//admit
			if(!tagFilter.equals(tag)){
				return;
			}
		}
		if(outputSwitch == 2){//ban
			if(tagFilter.equals(tag)){
				return;
			}
		}
		
		if (LEVEL <= android.util.Log.DEBUG) {
			android.util.Log.d(tag, String.format(msgFormat, args));
			
		}
	}

	static public void d(String tag, String msg) {

		if(msg == null){
			return;
		}

//		if(MyConfig.compile_type_release){
//			return;
//		}

		if(outputSwitch == 0)
			return;

		if(outputSwitch == 1){//admit
			if(!tagFilter.equals(tag)){
				return;
			}
		}
		if(outputSwitch == 2){//ban
			if(tagFilter.equals(tag)){
				return;
			}
		}

		if (LEVEL <= android.util.Log.DEBUG) {
//			android.util.Log.d(tag, msg);
			printStr(tag, msg);


		}
	}

	static public void printStr(String tag, String msg){

		int maxLogSize = 1000;

		for(int i = 0; i <= msg.length() / maxLogSize; i++) {
			int start = i * maxLogSize;
			int end = (i+1) * maxLogSize;
			end = end > msg.length() ? msg.length() : end;
			android.util.Log.d(tag, msg.substring(start, end));
		}
	}

//	static public void d(String tag, Throwable t, String msgFormat,
//			Object... args) {
//		
//		if(output != 1)
//			return;
//		
//		if (LEVEL <= android.util.Log.DEBUG) {
//			android.util.Log.d(tag, String.format(msgFormat, args), t);
//		}
//	}

}
