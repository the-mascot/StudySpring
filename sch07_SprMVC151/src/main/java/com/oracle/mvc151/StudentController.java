package com.oracle.mvc151;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@RequestMapping("/studentForm")
	public String studentForm() {
		logger.info("studentForm start...");
		
		return "createPage";
	}
	
	@RequestMapping("/student/create")
	public String studentCreate(Student stu1, BindingResult result, Model model) {
		
		String page="createDonePage";
		logger.info("/student/create start...");
		StudentValidator validator=new StudentValidator();
		validator.validate(stu1, result);
		logger.info("result Message->{}", result.toString());
		System.out.println("result Message getFieldError->"+result.getFieldErrors("name"));
		String name="";
		String id="";
		
		if(result.hasErrors()) {
			if(result.hasFieldErrors("name")) {
				FieldError fieldError1=result.getFieldError("name");
				name=fieldError1.getCode();
				System.out.println("StudentController validator name->"+name);
			}
			if(result.hasFieldErrors("id")) {
				FieldError fieldError2=result.getFieldError("id");
				System.out.println("fieldError.hasErrors2()->"+fieldError2.getCode());
				name=fieldError2.getCode();
				System.out.println("StudentController validator id->"+id);
				model.addAttribute("id", id);
			}
		}
		return page;
	}
	
}
