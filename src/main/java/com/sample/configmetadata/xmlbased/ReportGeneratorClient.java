package com.sample.configmetadata.xmlbased;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.configmetadata.xmlbased.services.GenericReportGeneratorService;
import com.sample.configmetadata.xmlbased.services.PDFReportGeneratorService;
import com.sample.configmetadata.xmlbased.services.XMLReportGeneratorService;

public class ReportGeneratorClient {
	static int recordsPerPage = 100;

	public static void main(String[] args) {
		
		//AbstractApplicationContext provides close methods, ApplicationContext doesn't have it
		AbstractApplicationContext context = null;
		try{
			context= new ClassPathXmlApplicationContext("configmetadata/xmlbased/context.xml");
			System.out.println("ApplicationContext Initialized !!");

			System.out.println("## Using the Constructor DI Concepts ##");
			PDFReportGeneratorService pdfreports = (PDFReportGeneratorService) context.getBean("pdfreports");
			pdfreports.generateReport();
			pdfreports.getAdditionalDetails();
			pdfreports.sendMail("Admin DL");
			
			System.out.println("## Using the Setter DI Concepts ##");
			XMLReportGeneratorService xmlreports = (XMLReportGeneratorService) context.getBean("xmlreports");
			xmlreports.generateReport();
			xmlreports.getAdditionalDetails();
			xmlreports.sendMail("Admin DL");
			
			
			System.out.println("## Using the Constructor autowiring Concepts ##");
			GenericReportGeneratorService generalreports = (GenericReportGeneratorService) context.getBean("generalreports");
			generalreports.getAdditionalDetails();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			context.close();
			//used to close if the JVM shuts down
			context.registerShutdownHook();
		}
	}
}
