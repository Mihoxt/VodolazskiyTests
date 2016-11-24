package com.mycompany.test2.home;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Principal principal) {
            return "home/homeSignedIn";
//		return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
	}
        
}
