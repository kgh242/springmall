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
	
	@RequestMapping(value="/sample/loginSample", method=RequestMethod.GET)
	public String login(HttpSession session, @RequestParam(value="sampleId") String sampleId, @RequestParam(value="samplePw") String samplePw) {
		System.out.println("login Form 이동");
		Sample sample = sampleService.getLoginSample(sampleId, samplePw);
		session.setAttribute("sample",sample);
		return "/sample/login";
	}
	@RequestMapping(value="/sample/loginSample", method=RequestMethod.POST)
	public String login(HttpSession session, Sample sample) {
		//request.getHttpSession();
		System.out.println("login 체크");
		if(sampleService.loginSample(sample)==1) {
			session.getAttribute("sample");
			return "redirect:/sample/sampleList";
		}else {
			return "redirect:/sample/login";
		}
		
	}
	
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/Sample/sampleList";
	}
}
