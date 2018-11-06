package com.example.springmall;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
	@RequestMapping("/hi")
	public void hi() {
		System.out.println("Hi Spring boot!");
	}
}
