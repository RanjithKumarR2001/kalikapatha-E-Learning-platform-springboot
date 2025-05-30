package com.jsp.kalikapatha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jsp.kalikapatha.dto.UserDto;
import com.jsp.kalikapatha.repository.LearnerRepository;
import com.jsp.kalikapatha.repository.TutorRepository;

import jakarta.validation.Valid;

@Controller
public class GeneralController{
	
	@Autowired
	LearnerRepository learnerRepository;
	
	@Autowired
	TutorRepository tutorRepository;
	
	@GetMapping("/")
	public String loadhome() {
		return "home.html";
	}
	
	@GetMapping("/register")
	public String loadRegister(UserDto userDto,Model model) {
		model.addAttribute("userDto", userDto);
		return "register.html";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute @Valid UserDto userDto ,BindingResult result) {
		if(!userDto.getConfirmPassword().equals(userDto.getPassword()))
			result.rejectValue("confirmPassword", "error.confirmPassword", "* Password and ConfirmPassword not matching");
		
		if(learnerRepository.existsByMobile(userDto.getMobile()) || tutorRepository.existsByMobile(userDto.getMobile()))
			result.rejectValue("mobile", "error.mobile","* Mobile Number Already in Use");
		
		if(learnerRepository.existsByEmail(userDto.getEmail()) || tutorRepository.existsByEmail(userDto.getEmail()))
			result.rejectValue("email", "error.email", "* Email Adress Already in use");
		
		if(!result.hasErrors()) {
			return "otp.html";
		}
		return "register.html";
	}
	
	

}
