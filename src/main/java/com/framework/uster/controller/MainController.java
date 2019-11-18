package com.framework.uster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
		
	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public String show_inicio() {
		return "start_tiles";
	}
	
}
