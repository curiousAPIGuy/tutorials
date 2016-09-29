package com.asingh.algorithms.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.springframework.util.StringUtils;

@WebService(serviceName="algorithmsService")
public class AlgorithmsWebService implements ServiceInterface {
	
	@WebMethod(operationName="getString")
	public String getString(String input) {
		String result = StringUtils.hasLength(input)? input: "there";
		return String.format("Hello %s !!", result);
	}

}
