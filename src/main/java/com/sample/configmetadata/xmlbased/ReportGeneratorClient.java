package com.sample.configmetadata.xmlbased;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.configmetadata.xmlbased.services.PDFReportGeneratorService;

public class ReportGeneratorClient {
	static int recordsPerPage = 100;

	public static void main(String[] args) {
		
		//AbstractApplicationContext provides close methods, ApplicationContext doesn't have it
		AbstractApplicationContext context = null;
		try{
			context= new ClassPathXmlApplicationContext("configmetadata/xmlbased/context.xml");
			System.out.println("ApplicationContext Initialized !!");

			PDFReportGeneratorService appMaster = (PDFReportGeneratorService) context.getBean("pdfreports");

			//System.out.println(beanMaster.generateReport(recordsPerPage));
			appMaster.generateReport();
			appMaster.getAdditionalDetails();
			appMaster.sendMail("Admin DL");;
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			context.close();
			//used to close if the JVM shuts down
			context.registerShutdownHook();
		}
	}
}
