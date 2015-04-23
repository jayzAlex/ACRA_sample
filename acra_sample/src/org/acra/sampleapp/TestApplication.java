package org.acra.sampleapp;

import java.io.File;

import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.annotation.ReportsCrashes;
import org.acra.sender.LocalReportSender;

import android.app.Application;
import android.os.Environment;

@ReportsCrashes(formKey = "", // will not be used
	customReportContent = { ReportField.USER_CRASH_DATE,ReportField.ANDROID_VERSION, 
	ReportField.PHONE_MODEL, ReportField.BRAND, ReportField.PRODUCT, ReportField.DEVICE_ID,
	ReportField.APP_VERSION_CODE, ReportField.APP_VERSION_NAME, ReportField.STACK_TRACE,
	ReportField.PACKAGE_NAME,ReportField.TOTAL_MEM_SIZE,ReportField.AVAILABLE_MEM_SIZE
//// 1.Sending reports to your own self-hosted script
//formUriBasicAuthLogin = "user", 
//formUriBasicAuthPassword = "password", 
//formUri = "http://192.168.1.114:8080/TestAcra3/CrashServerlet",
//httpMethod = org.acra.sender.HttpSender.Method.POST
	
//// 2.Sending reports by email
//mailTo = "zhengja13438@hundsun.com",
//mode = ReportingInteractionMode.TOAST,
//resToastText = R.string.crash_toast_text
	}
)

public class TestApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();		
		ACRA.init(this);
		File logFile = new File(Environment.getExternalStorageDirectory(),
				"hslog.txt");
		ACRA.getErrorReporter().setReportSender(new LocalReportSender(this, logFile));
	}
}