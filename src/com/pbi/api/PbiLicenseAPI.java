package com.pbi.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.pbi.bean.User;
import com.pbi.resources.AppConfig;
import com.pbi.resources.Factory;
import com.pbi.resources.JSONParser;

@Path("PbiLicense")
public class PbiLicenseAPI {
	
	@Path("ProvideLicese")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public  Response sendUserDetails(String dataReceived) throws Exception {
		Response response=null;
		String string=dataReceived;
		try {
			User user=JSONParser.fromJson(string, User.class);
			Factory factory=new Factory();
			factory.getPbiLicenseService().provideLicense(user);
		} catch (Exception e) {
			String erroMessage=AppConfig.PROPERTIES.getProperty(e.getMessage());
			User user=new User();
			user.setMessage(erroMessage);
			String returnString=JSONParser.toJson(user);
			response=Response.status(Status.SERVICE_UNAVAILABLE).entity(returnString).build();
		}
		return response;
		}
}
