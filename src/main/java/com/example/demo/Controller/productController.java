package com.example.demo.Controller;


import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.product;
import com.example.demo.productRepo.LoginRepo;
import com.example.demo.productRepo.productRepo;



@Controller
public class productController {

	@Autowired
	productRepo repo;
	
	
   
	Logger log = Logger.getAnonymousLogger();
	
	// pages
	
	@RequestMapping("/Home")
	public String welcome() {

		return "Home";
	}
	

	
	@RequestMapping("/index")
	public String index() {

		return "index";
	}
	@RequestMapping("/Userlogin")
	public String Userlogin() {

		return "Userlogin";
	}
	
	
	
	
	
	
	
	@GetMapping("details")
	public String home(Model m) {
		List<product> list = repo.findAll();
		m.addAttribute("all_products", list);
		return "tables";
	}

	@GetMapping("/load_form")
	public String loadform() {
		return "add";
	}
	
	@GetMapping("/edit_form/{id}")
	public String editform(@PathVariable(value = "id") long id, Model m) {
		Optional<product> products = repo.findById(id);
		product pro = products.get();
		m.addAttribute("products", pro);
		return "edit";
	}

	@PostMapping("/save_products")
	public String saveProducts(@ModelAttribute product products, HttpSession session) {
		repo.save(products);
		session.setAttribute("msg", "Product Added Sucessfully...");
		return "redirect:/load_form";
	}

	@PostMapping("/update_products")
	public String updateProducts(@ModelAttribute product products, HttpSession session) {
		repo.save(products);
		session.setAttribute("msg", "Product updated Sucessfully...");
		return "redirect:/details";
	}

	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(value = "id") long id, HttpSession session) {

		repo.deleteById(id);
		session.setAttribute("msg", "Product deleted Sucessfully...");

		return "redirect:/details";
	}
	
	

}
