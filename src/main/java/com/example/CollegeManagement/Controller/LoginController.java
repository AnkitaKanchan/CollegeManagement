package com.example.CollegeManagement.Controller;



import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.CollegeManagement.Dao.Login;
import com.example.CollegeManagement.Service.LoginService;





@Controller
public class LoginController {
	
	@Autowired
    private LoginService userService;

	@GetMapping("/mainlogin")
    
    public ModelAndView mainlogin() {
    	ModelAndView mav = new ModelAndView("MainLoginPage");
       
        return mav;
    }
	
    @GetMapping("/login")
           
    public ModelAndView login() {
    	ModelAndView mav = new ModelAndView("Login");
        mav.addObject("user", new Login());
        return mav;
    }

    @PostMapping("/login1")
    public String login(@ModelAttribute("user") Login user ) {
    	
    	Login oauthUser = userService.login(user.getUsername(), user.getPassword());
    	
    	System.out.println(user.getUsername()); 
    	System.out.print(oauthUser);
    	if(Objects.nonNull(oauthUser)) 
    	{	
  
    		return "LoginSuccess";
    	
    		
    	} else {
    		return "redirect:/login";
    		
    	
    	}

}
}