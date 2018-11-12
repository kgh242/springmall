package com.example.springmall.sample.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springmall.sample.service.SampleService;
import com.example.springmall.sample.vo.Sample;

@Controller
public class LoginController {
	@Autowired
	private SampleService sampleService;

	@RequestMapping(value="/sample/loginSample", method=RequestMethod.POST)
	public String login(HttpSession session, Sample sample) {
		//request.getHttpSession();
		System.out.println("login 체크");
		if(sampleService.loginSample(sample)==1) {
			System.out.println("로그인 성공");
			session.setAttribute("LoginId",sample.getSampleId());
			return "redirect:/sample/sampleList";
		}else {
			System.out.println("로그인 실패");
			return "redirect:/sample/sampleList";
		}
		
	}
	
	@RequestMapping(value="/sample/logoutSample", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/Sample/sampleList";
	}
}
