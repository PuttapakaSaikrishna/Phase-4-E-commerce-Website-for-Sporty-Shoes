package com.example.demo.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Register;
import com.example.demo.productRepo.RegisterRepo;

@Controller
public class RegisterController {
	@Autowired
	RegisterRepo repo;
	
	@GetMapping("/list_form")
	public String home(Model m) {
		List<Register> list = repo.findAll();
		m.addAttribute("all_users", list);
		return "listusers";
	}
	
	  @GetMapping("/register")
	  public String processRegister() {
	      return "register";
	  }
	  
	  
	@PostMapping("/register_user")
	public String registeruser(@ModelAttribute Register register, HttpSession session) {
		repo.save(register);
		session.setAttribute("msg", "Register Sucessfully.....");
		return "redirect:/register";
	}
	 
	@GetMapping("/delet/{id}")
	public String deleteuser(@PathVariable(value = "id") long id, HttpSession session) {
		repo.deleteById(id);
		session.setAttribute("msg", "Product deleted Sucessfully...");
		return "redirect:/list_form";
	}

}
	