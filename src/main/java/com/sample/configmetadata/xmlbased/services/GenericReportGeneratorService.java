package com.sample.configmetadata.xmlbased.services;

import com.sample.configmetadata.xmlbased.utils.MailUtils;
import com.sample.configmetadata.xmlbased.utils.ReportPathUtil;

public class GenericReportGeneratorService {

	MailUtils mailUtils = null;
	ReportPathUtil reportPathUtils = null;

	public GenericReportGeneratorService(MailUtils mailUtils, ReportPathUtil reportPathUtils) {
		super();
		this.mailUtils = mailUtils;
		this.reportPathUtils = reportPathUtils;
	}

	public String getAdditionalDetails() {
		System.out.println();
		System.out.println(mailUtils.sendMail("No Mail Receps Found"));
		System.out.println(reportPathUtils.CheckReportsUnderPath("No Path Found"));
		return "";
	}

}