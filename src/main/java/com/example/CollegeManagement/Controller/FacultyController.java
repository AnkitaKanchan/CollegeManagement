package com.example.CollegeManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.CollegeManagement.Dao.Faculty;
import com.example.CollegeManagement.Repository.FacultyRepository;

@Controller
@RequestMapping(path="/faculty")

public class FacultyController {
	@Autowired
	private FacultyRepository userRepository;
	
	@GetMapping("/flogin")
    
    public ModelAndView login() {
    	ModelAndView mav = new ModelAndView("Fregister");
        mav.addObject("user", new Faculty());
        return mav;
    }

	@PostMapping("/add")
    public String addFaculty(@Validated Faculty faculty, BindingResult result, Model model) {
       
        userRepository.save(faculty);
        return "redirect:/faculty/fview";
    }
	
	@GetMapping("/fview")
	public String showUserList(Model model) {
	    model.addAttribute("facultys", userRepository.findAll());
	    return "Fview";

}
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int id,Model model) {
	    Faculty user = userRepository.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    userRepository.delete(user);
	    return "redirect:/faculty/fview";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id,Model model) {
	    Faculty user = userRepository.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    
	    model.addAttribute("faculty", user);
	    return "Fupdate";
	}
	 @PostMapping("update/{id}")
	    public String updateFaculty(@PathVariable("id") long id, @Validated Faculty faculty, BindingResult result,
	        Model model) {
	       

		 userRepository.save(faculty);
	        model.addAttribute("facultys", userRepository.findAll());
	        return "Fview";
}

}
