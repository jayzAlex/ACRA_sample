package org.acra.sender;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.acra.ACRA;
import org.acra.ACRAConstants;
import org.acra.ReportField;
import org.acra.collector.CrashReportData;

import android.content.Context;
import android.util.Log;

public class LocalReportSender implements ReportSender {

	private FileWriter crashReport = null;

	public LocalReportSender(Context ctx, File logFile) {
		try {
			crashReport = new FileWriter(logFile, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void send(CrashReportData report) throws ReportSenderException {
		final String body = buildBody(report);
		try {
			BufferedWriter buf = new BufferedWriter(crashReport);
			buf.append(body);
			buf.flush();
			buf.close();
		} catch (IOException e) {
			Log.e("TAG", "IO ERROR", e);
		}
	}

	private String buildBody(CrashReportData errorContent) {
		ReportField[] fields = ACRA.getConfig().customReportContent();
		if (fields.length == 0) {
			fields = ACRAConstants.DEFAULT_MAIL_REPORT_FIELDS;
		}

		final StringBuilder builder = new StringBuilder();
		for (ReportField field : fields) {
			builder.append(field.toString()).append("=");
			builder.append(errorContent.get(field));
			builder.append('\n');
		}
		return builder.toString();
	}

}