package com.asingh.home.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class HomeServiceImpl implements HomeService {
	private static final Logger logger = Logger.getLogger(HomeServiceImpl.class);
	
	public String getStatus() {
		logger.debug(String.format("%s", "no connected device found!!"));
		String status = "undefined";
		return status;
	}
	

}
