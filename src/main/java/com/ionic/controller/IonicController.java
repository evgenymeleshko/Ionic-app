package com.ionic.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class IonicController {
	
	private static final String SERVLETURL = "http://api.openweathermap.org/data/2.5/weather?lat={latitude}&lon={longitude}&appid={appId}";
	
	@RequestMapping(value = "forecast/weather", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getStackTrace(
			@RequestParam(value = "lat", required = true) String lat,
			@RequestParam(value = "lon", required = true) String lon) {
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> params = new HashMap<String, String>();
		params.put("latitude", lat);
		params.put("longitude", lon);
		params.put("appId", "91d7df08b08df0a51f2456a7447517c9");
		ResponseEntity<String> result = restTemplate.getForEntity(SERVLETURL, String.class, params);

		return result;
	}

}
