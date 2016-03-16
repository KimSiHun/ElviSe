package com.elvis.myprecious;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RequestMapping(value = "/")
@Controller
public class IndexController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "index";
	}
	

	@RequestMapping(value = "/eventlist", method = RequestMethod.GET)
	public String event(Locale locale, Model model) {

		return "eventList";
	}
	
	@RequestMapping(value = "/itemregist", method = RequestMethod.GET)
	public String item(Locale locale, Model model) {

		return "itemRegist";
	}

}