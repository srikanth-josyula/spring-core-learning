package com.sample.configmetadata.xmlbased.services;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.sample.configmetadata.xmlbased.utils.MailUtils;

public class PDFReportGeneratorService {

	int recordsPerPage;
	String recordStartDate;
	String recordEndDate;

	List<String> reportDetails;
	Map<String, String> reportAdditionalDetails;

	MailUtils mailUtils = null;

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

		return "";
	}

	public void sendMail(String recepients) {
		System.out.println(mailUtils.sendMail(recepients));
	}

}