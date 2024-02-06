package com.sample.configmetadata.xmlbased.services;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.sample.configmetadata.xmlbased.utils.MailUtils;
import com.sample.configmetadata.xmlbased.utils.ReportPathUtil;

public class XMLReportGeneratorService {

	int recordsPerPage;
	String recordStartDate;
	String recordEndDate;

	List<String> reportDetails;
	Map<String, String> reportAdditionalDetails;

	MailUtils mailUtils = null;
	
	//Injecting using auto-wiring if give by Name, The name considered to be same the bean name
	//If we change the variable name here it fails 
	ReportPathUtil reportPathUtils = null;

	public void setReportPathUtils(ReportPathUtil reportPathUtils) {
		this.reportPathUtils = reportPathUtils;
	}

	public String generateReport() {
		System.out.println("Generated XML Report with " + recordsPerPage);
		System.out.println("Record Start Date " + recordStartDate);
		System.out.println("Record End Date " + recordEndDate);

		return "";
	}

	public String getAdditionalDetails() {
		System.out.println();
		System.out.println("Printing Additional Report Details");
		System.out.println("ReportDetails " + reportDetails);
		for (Entry<String, String> map : reportAdditionalDetails.entrySet()) {
			System.out.println(map.getKey() + "=" + map.getValue());
		}
		System.out.println(reportPathUtils.CheckReportsUnderPath("/u01/xmlpath"));
		return "";
	}

	public void sendMail(String recepients) {
		System.out.println(mailUtils.sendMail(recepients));
	}

	// Provide Setters
	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public void setRecordStartDate(String recordStartDate) {
		this.recordStartDate = recordStartDate;
	}

	public void setRecordEndDate(String recordEndDate) {
		this.recordEndDate = recordEndDate;
	}

	public void setReportDetails(List<String> reportDetails) {
		this.reportDetails = reportDetails;
	}

	public void setReportAdditionalDetails(Map<String, String> reportAdditionalDetails) {
		this.reportAdditionalDetails = reportAdditionalDetails;
	}

	public void setMailUtils(MailUtils mailUtils) {
		this.mailUtils = mailUtils;
	}

}