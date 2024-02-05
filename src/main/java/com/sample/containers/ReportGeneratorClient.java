package com.sample.containers;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.sample.containers.services.PDFReportGeneratorImpl;
import com.sample.containers.services.XMLReportGeneratorImpl;
import com.sample.containers.services.impl.IReportGenerator;

public class ReportGeneratorClient {
	static int recordsPerPage = 100;

	public static void main(String[] args) {

		/**
		 *  Tightly coupled, code change is required for any changes to the dependencies 
		 *  
		 **/
		// IReportGenerator master = new PDFReportGeneratorImpl();

		// Using BeanFactory
		Resource res = new FileSystemResource("src/main/resources/containers/xmlbean-container-context.xml");
	//	ClassPathResource res = new ClassPathResource("containers/xmlbean-container-context.xml");
		BeanFactory beanContext = new XmlBeanFactory(res);
		System.out.println("BeanFactory Initialized !!");

		// Using ApplicationContext
		//ApplicationContext appContext = new FileSystemXmlApplicationContext("src/main/resources/containers/app-container-context.xml");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("containers/app-container-context.xml");
		System.out.println("ApplicationContext Initialized !!");

		IReportGenerator beanMaster = (XMLReportGeneratorImpl) beanContext.getBean("xmlreports");
		IReportGenerator appMaster = (PDFReportGeneratorImpl) appContext.getBean("pdfreports");

		System.out.println(beanMaster.generateReport(recordsPerPage));
		System.out.println(appMaster.generateReport(recordsPerPage));

	}
}
