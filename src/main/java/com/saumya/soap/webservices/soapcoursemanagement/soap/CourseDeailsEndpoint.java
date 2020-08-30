package com.saumya.soap.webservices.soapcoursemanagement.soap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.saumya.courses.CourseDetails;
import com.saumya.courses.GetCourseDetailsRequest;
import com.saumya.courses.GetCourseDetailsResponse;

@Endpoint
public class CourseDeailsEndpoint {
	
	@PayloadRoot(namespace="http://saumya.com/courses", localPart="GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) 
	{
		GetCourseDetailsResponse response=new GetCourseDetailsResponse();
		CourseDetails csd=new CourseDetails();
		csd.setId(request.getId());
		csd.setName("Microservices Course");
		csd.setDescription("Wonderful learning!");
		
		response.setCourseDetails(csd);
		return response;
	}

}
