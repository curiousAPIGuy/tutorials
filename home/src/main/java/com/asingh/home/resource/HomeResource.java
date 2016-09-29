package com.asingh.home.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asingh.home.service.HomeService;
import com.asingh.home.service.HomeServiceImpl;
import com.sun.jersey.spi.resource.Singleton;


@Singleton
@Component
@Path("v1/home")
public class HomeResource {
	
	private HomeService homeService;
	
	private static final Logger logger = Logger.getLogger(HomeResource.class);
	
	
	@Autowired
	public void setHomeService(HomeService homeService) {
		this.homeService = homeService;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAutomationStatus(@Context UriInfo uriInfo){
		logger.info(String.format("%s", "retrieving status of connected devices.."));
		
		String status= homeService.getStatus();
		return Response.status(Response.Status.OK).entity(status).build();
	}

}
