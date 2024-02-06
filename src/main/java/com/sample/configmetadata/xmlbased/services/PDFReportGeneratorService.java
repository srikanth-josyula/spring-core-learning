package com.sample.configmetadata.xmlbased.services;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.sample.configmetadata.xmlbased.utils.MailUtils;
import com.sample.configmetadata.xmlbased.utils.ReportPathUtil;

public class PDFReportGeneratorService {

	int recordsPerPage;
	String recordStartDate;
	String recordEndDate;

	List<String> reportDetails;
	Map<String, String> reportAdditionalDetails;

	MailUtils mailUtils = null;

	//Injecting using auto-wiring if give by Type only the TYPE is considered the name here is different from the bean name
	// Bean name is not autowirebytype, but still it works
	ReportPathUtil autowirebytype = null;
	
	public void setReportPathUtils(ReportPathUtil autowirebytype) {
		this.autowirebytype = autowirebytype;
	}


	// IF we are injecting normal object, we dont need default constructor

	public PDFReportGeneratorService(int recordsPerPage, String recordStartDate, String recordEndDate,
			List<String> reportDetails, Map<String, String> reportAdditionalDetails, MailUtils mailUtils) {
		this.recordsPerPage = recordsPerPage;
		this.recordStartDate = recordStartDate;
		this.recordEndDate = recordEndDate;
		this.reportDetails = reportDetails;
		this.reportAdditionalDetails = reportAdditionalDetails;
		this.mailUtils = mailUtils;
	}

	public String generateReport() {
		System.out.println("Generated PDF Report with " + recordsPerPage);
		System.out.println("Record Start Date " + recordStartDate);
		System.out.println("Record End Date " + recordEndDate);

		return "";
	}

	public String getAdditionalDetails() {
		System.out.println();
		System.out.println("Printing Additional Report Details");
		System.out.println("ReportDetails "+reportDetails);
		for(Entry<String, String> map:reportAdditionalDetails.entrySet()) {
			System.out.println(map.getKey()+"="+map.getValue());
		}
		System.out.println(autowirebytype.CheckReportsUnderPath("/u01/path"));

		return "";
	}

	public void sendMail(String recepients) {
		System.out.println(mailUtils.sendMail(recepients));
	}

}