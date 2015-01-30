package com.pnb.systematics.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.pnb.systematics.enterprise.SystematicsClient;

public class WebServiceUtil {
	
	private static Jaxb2Marshaller marshaller(){
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.pnb.systematics.schema");
		return marshaller;
	}
	
	public static SystematicsClient systematicsClient(){
		SystematicsClient client = new SystematicsClient();
		client.setDefaultUri("http://10.1.101.79:9080/AAFWebService/services/AAFWebService");
		client.setMarshaller(marshaller());
		client.setUnmarshaller(marshaller());
		return client;
	}
}
