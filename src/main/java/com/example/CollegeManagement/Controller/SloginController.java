package com.example.CollegeManagement.Controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import com.example.CollegeManagement.Dao.Student_Login;
import com.example.CollegeManagement.Service.SloginService;

@Controller
public class SloginController {
	@Autowired
    private SloginService userService;

                                   
    @GetMapping("/Student_Login")
           
    public ModelAndView login() {
    	ModelAndView mav = new ModelAndView("Student_Login");
        mav.addObject("user1", new Student_Login());
        return mav;
    }

    @PostMapping("/slogin")
    public String student_login(@ModelAttribute("user1") Student_Login user1 ) {
    	
    	Student_Login oauthUser = userService.slogin(user1.getUsername(), user1.getPassword());
    	
    	System.out.println(user1.getUsername()); 
    	System.out.print(oauthUser);
    	if(Objects.nonNull(oauthUser)) 
    	{	
  
    		return "Studentdb";
    	
    		
    	} else {
    		return "redirect:/Student_Login";
    		
    	
    	}


}
    
@GetMapping("/exam")

public ModelAndView Exams() {
ModelAndView mav = new ModelAndView("Exams");
return mav;
}
@GetMapping("/ml")

public ModelAndView Ml() {
ModelAndView mav = new ModelAndView("Ml");
return mav;
}

}
