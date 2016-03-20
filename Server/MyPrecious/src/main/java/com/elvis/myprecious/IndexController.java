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
	
	@RequestMapping(value = "/abcd", method = RequestMethod.GET)
	public String home2(Locale locale, Model model) {

		return "eventList";
	}
	

	@RequestMapping(value = "/golist", method = RequestMethod.GET)
	public String event(Locale locale, Model model) {

		return "eventList";
	}
	
	@RequestMapping(value = "/goitem", method = RequestMethod.GET)
	public String event2(Locale locale, Model model) {

		return "itemRegist";
	}
	
	@RequestMapping(value = "/itemregist", method = RequestMethod.GET)
	public String item(Locale locale, Model model) {

		return "itemRegist";
	}

}