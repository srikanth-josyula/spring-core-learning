package com.sample.containers.services;

import com.sample.containers.services.impl.IReportGenerator;

public class PDFReportGeneratorImpl implements IReportGenerator {

	public String generateReport(int recordsPerPage) {
		return "Generated PDF Report with " + recordsPerPage + " records";
	}

}