ACRA Sample
============

This is ACRA sample For ACRA. 
Find out more about ACRA at [website](https://github.com/ACRA/acra).

<b>init Acra</b>

		@Override
		public void onCreate() {
			super.onCreate();		
			ACRA.init(this);
			File logFile = new File(Environment.getExternalStorageDirectory(),
					"hslog.txt");
			ACRA.getErrorReporter().setReportSender(new LocalReportSender(this, logFile));
		}
		
<b>custom report fileds</b>

		@ReportsCrashes(formKey = "", // will not be used
			customReportContent = { ReportField.USER_CRASH_DATE,
			ReportField.ANDROID_VERSION, 
			ReportField.PHONE_MODEL, 
			ReportField.BRAND, 
			ReportField.PRODUCT, 
			ReportField.DEVICE_ID,
			ReportField.APP_VERSION_CODE, 
			ReportField.APP_VERSION_NAME, 
			ReportField.STACK_TRACE,
			ReportField.PACKAGE_NAME,
			ReportField.TOTAL_MEM_SIZE,
			ReportField.AVAILABLE_MEM_SIZE
			}
		)

<b>Sending reports to your own self-hosted script</b>

		@ReportsCrashes(formKey = "", // will not be used
			customReportContent = { ReportField.USER_CRASH_DATE,
			ReportField.ANDROID_VERSION, 
			ReportField.PHONE_MODEL, 
			ReportField.BRAND, 
			ReportField.PRODUCT, 
			ReportField.DEVICE_ID,
			ReportField.APP_VERSION_CODE, 
			ReportField.APP_VERSION_NAME, 
			ReportField.STACK_TRACE,
			ReportField.PACKAGE_NAME,
			ReportField.TOTAL_MEM_SIZE,
			ReportField.AVAILABLE_MEM_SIZE},
			formUriBasicAuthLogin = "user", 
			formUriBasicAuthPassword = "password", 
			formUri = "http://192.168.1.114:8080/TestAcra3/CrashServerlet",
			httpMethod = org.acra.sender.HttpSender.Method.POST
		)

<b>Sending reports by email</b>

		@ReportsCrashes(formKey = "", // will not be used
			customReportContent = { ReportField.USER_CRASH_DATE,
			ReportField.ANDROID_VERSION, 
			ReportField.PHONE_MODEL, 
			ReportField.BRAND, 
			ReportField.PRODUCT, 
			ReportField.DEVICE_ID,
			ReportField.APP_VERSION_CODE, 
			ReportField.APP_VERSION_NAME, 
			ReportField.STACK_TRACE,
			ReportField.PACKAGE_NAME,
			ReportField.TOTAL_MEM_SIZE,
			ReportField.AVAILABLE_MEM_SIZE},			
			mailTo = "794076772@qq.com",
			mode = ReportingInteractionMode.TOAST,
			resToastText = R.string.crash_toast_text
		)

		
<b>save log to SD card</b>

		@Override
		public void onCreate() {
			super.onCreate();		
			ACRA.init(this);
			File logFile = new File(Environment.getExternalStorageDirectory(),
					"hslog.txt");
			ACRA.getErrorReporter().setReportSender(new LocalReportSender(this, logFile));
		}
		
		
permission required:
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
		


