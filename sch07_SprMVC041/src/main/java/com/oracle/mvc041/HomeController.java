package com.oracle.mvc041;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/index")
	public String goIndex() {
		logger.info("HomController index Start...");
		
		return "index";
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String studentGet(HttpServletRequest request, Model model) {
		System.out.println("RequestMethod.GET start..");
		String id=request.getParameter("id");
		System.out.println("GET id->"+id);
		
		model.addAttribute("studentId", id);
		
		return "student/studentId";
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public String studentPost(HttpServletRequest request, Model model) {
		System.out.println("RequestMethod.POST start..");
		String id=request.getParameter("id");
		System.out.println("POST id->"+id);
		
		model.addAttribute("studentId", id);
		
		return "student/studentId";
	}
	
	@RequestMapping(value = "/student1", method = RequestMethod.POST)
	public ModelAndView student1Post(HttpServletRequest request, Model model) {
		System.out.println("MODEL AND VIEW RequestMethod.POST start..");
		ModelAndView mv=new ModelAndView();
		String id=request.getParameter("id");
		System.out.println("POST id->"+id);
		mv.addObject("studentId", id);
		mv.setViewName("student/studentId");
		
		return mv;
	}
	
	
}
