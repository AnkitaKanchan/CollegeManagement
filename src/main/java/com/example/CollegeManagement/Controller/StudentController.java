package com.example.CollegeManagement.Controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.CollegeManagement.Dao.Login;
import com.example.CollegeManagement.Dao.Student;
import com.example.CollegeManagement.Repository.StudentRepository;



@Controller
@RequestMapping(path="/student")
public class StudentController {
	
	@Autowired
	private StudentRepository userRepository;
	
	@GetMapping("/slogin")
    
    public ModelAndView login() {
    	ModelAndView mav = new ModelAndView("DashBoard");
        mav.addObject("user", new Student());
        return mav;
    }

	@PostMapping("/add")
    public String addStudent(@Validated Student student, BindingResult result, Model model) {
       
        userRepository.save(student);
        return "redirect:/student/view";
    }
	
	@GetMapping("/view")
	public String showUserList(Model model) {
	    model.addAttribute("students", userRepository.findAll());
	    return "Sview";

}
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int id, Model model) {
	    Student user = userRepository.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    userRepository.delete(user);
	    return "redirect:/student/view";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
	    Student user = userRepository.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    
	    model.addAttribute("student", user);
	    return "Supdate";
	}
	 @PostMapping("update/{id}")
	    public String updateStudent(@PathVariable("id") long id, @Validated Student student, BindingResult result,
	        Model model) {
	       

		 userRepository.save(student);
	        model.addAttribute("students", userRepository.findAll());
	        return "Sview";
}
}

