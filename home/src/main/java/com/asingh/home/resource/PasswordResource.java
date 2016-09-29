package com.asingh.home.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asingh.home.model.PasswordRequest;
import com.asingh.home.service.PasswordService;
import com.sun.jersey.spi.resource.Singleton;


@Singleton
@Component
@Path("v1/password")
public class PasswordResource {
	
	private PasswordService passwordService;
	private static final Logger logger = Logger.getLogger(PasswordResource.class);
	
	
	@Autowired
	public void setHomeService(PasswordService passwordService) {
		this.passwordService = passwordService;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response generatePassword(@Context UriInfo uriInfo){
		logger.info(String.format("%s", "retrieving input to generate password.."));
		
		StringBuilder input = new StringBuilder();
	    String password = "";
		
	    String arg1 = uriInfo.getQueryParameters().getFirst("string1");
		String arg2 = uriInfo.getQueryParameters().getFirst("string2");;
		String arg3 = uriInfo.getQueryParameters().getFirst("string3");;
		
		logger.debug(String.format("%s%s","input param 1 ", arg1));
		logger.debug(String.format("%s%s","input param 2 ", arg2));
		logger.debug(String.format("%s%s","input param 3 ", arg3));
		
		
		if (arg1 != null)
			input.append(arg1);
		if (arg2 != null)
			input.append(arg2);
		if (arg3 != null)
			input.append(arg3);
		
		password= passwordService.generatePass(input.toString());
		return Response.status(Response.Status.OK).entity(password).build();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response generatePassword2(PasswordRequest request)  {

		StringBuilder input = new StringBuilder();
		String password = "";
		//PasswordRequest pojo;
		try {
			if(request != null) {
				logger.info(String.format("%s %s", "retrieving input to generate password..", request));
				//ObjectMapper mapper = new ObjectMapper();
				//pojo = mapper.readValue(request, PasswordRequest.class);


				logger.debug(String.format("%s%s","input param 1 ", request.getString1()));
				logger.debug(String.format("%s%s","input param 2 ", request.getString2()));
				logger.debug(String.format("%s%s","input param 3 ", request.getString3()));

				if (request.getString1() != null)
					input.append(request.getString1());
				if (request.getString2() != null)
					input.append(request.getString2());
				if (request.getString3() != null)
					input.append(request.getString3());

			}
			password= passwordService.generatePass(input.toString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(Response.Status.OK).entity(password).build();

	}

}
