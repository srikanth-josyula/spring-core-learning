package com.sample.containers.services;

import com.sample.containers.services.impl.IReportGenerator;

public class XMLReportGeneratorImpl implements IReportGenerator {

	public String generateReport(int recordsPerPage) {
		return "Generated XML Report with " + recordsPerPage + " records";
	}

}