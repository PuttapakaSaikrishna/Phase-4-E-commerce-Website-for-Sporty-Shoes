package com.example.demo.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.productRepo.LoginRepo;

@Controller
public class LoginController {

//	@Autowired
//	LoginRepo rep;

	@GetMapping("/adminlogin")
	public String adminlogin() {
		return "adminlogin";
	}
	
	
	 @RequestMapping("/adminlogin")  
	   public ModelAndView login(HttpServletRequest request,
			   HttpServletResponse response) {
		  String userName=request.getParameter("userName");  
	      String password=request.getParameter("password");
	      System.out.println(userName+password);
	      
	      String message;
	      if( userName.equals("jai") && password.equals("123")){
	    	  message = "Welcome " +userName + ".";
		      return new ModelAndView("welcome", 
		    		  "message", message);  
	 
	      }else{
	    	  message = "Wrong username or password.";
	    	  return new ModelAndView("errorPage", 
	    			  "message", message);
	      }
	   }
	
	
	
//		@RequestMapping("/adminlogin")
//		public ModelAndView login(@RequestParam("username")String username,@RequestParam("password") String password) {
//			ModelAndView mv= new ModelAndView();
////			if(rep.getbyusername(username).equals(rep.getbypassword(password))) {
//			if(rep.getbyusername(username).equals(rep.getbypassword(password))) {
//			mv.setViewName("Changepassword.html");
//			}else
//			{
//				mv.setViewName("adminlogin");
//			}
//			return mv;
//		}
	 
	 
}


	
		
	 

