package com.ionic.controller;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
@PropertySources({ @PropertySource(value = "classpath:application.properties") })
public class FacebookController {
	
	private Facebook facebook;

    @Inject
    public FacebookController(Facebook facebook) {
        this.facebook = facebook;
    }
	
	@RequestMapping(method=RequestMethod.GET)
	public String facebook(Model model) {
		if (!facebook.isAuthorized()) {
			return "redirect:/connect/facebook";
		}
		
		return "hello";
	}
	
	

}
