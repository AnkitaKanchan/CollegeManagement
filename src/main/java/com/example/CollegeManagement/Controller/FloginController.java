package com.example.CollegeManagement.Controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.CollegeManagement.Dao.Faculty_Login;
import com.example.CollegeManagement.Service.FloginService;

@Controller
public class FloginController {
	
	@Autowired
    private FloginService userService;

                                   
    @GetMapping("/Faculty_Login")
           
    public ModelAndView login() {
    	ModelAndView mav = new ModelAndView("Faculty_login");
        mav.addObject("user2", new Faculty_Login());
        return mav;
    }

    @PostMapping("/f_login")
    public String faculty_login(@ModelAttribute("user2") Faculty_Login user2 ) {
    	
    	Faculty_Login oauthUser = userService.f_login(user2.getUsername(), user2.getPassword());
    	
    	System.out.println(user2.getUsername()); 
 //   	System.out.println(user2.getPassword()); 

    	System.out.print(oauthUser);
    	if(Objects.nonNull(oauthUser)) 
    	{	
  
    		return "Facultydb";
    	
    		
    	} else {
    		return "redirect:/Faculty_Login";
    		
    	
    	}

}
    
@GetMapping("/timetable")

public ModelAndView timetable() {
ModelAndView mav = new ModelAndView("Timetable");

return mav;
}
@GetMapping("/cse")

public ModelAndView Cse() {
ModelAndView mav = new ModelAndView("Cse");

return mav;
}
@GetMapping("/ece")

public ModelAndView Ece() {
ModelAndView mav = new ModelAndView("Ece");

return mav;
}
@GetMapping("/contact")

public ModelAndView contact() {
ModelAndView mav = new ModelAndView("Contact");

return mav;
}
@GetMapping("/ee")

public ModelAndView EE() {
ModelAndView mav = new ModelAndView("Ee");

return mav;
}
@GetMapping("/me")

public ModelAndView Me() {
ModelAndView mav = new ModelAndView("Me");
return mav;
}
@GetMapping("/cc")

public ModelAndView Cc() {
ModelAndView mav = new ModelAndView("Cc");
return mav;
}
@GetMapping("/ai")

public ModelAndView Ai() {
ModelAndView mav = new ModelAndView("Ai");
return mav;
}
@GetMapping("/iot")

public ModelAndView Iot() {
ModelAndView mav = new ModelAndView("Iot");
return mav;
}
}
