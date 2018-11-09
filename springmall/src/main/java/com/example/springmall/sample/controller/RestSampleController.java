package com.example.springmall.sample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springmall.sample.vo.Sample;

@RestController //기본이 json리턴 
public class RestSampleController {	//REST API -> Ajax로 api공유,xml/json 리턴  View가 필요없다
	@RequestMapping(value="/sample/getRestSample")
	public Sample getSample() {
		return new Sample(1, "guest","1234"); //{"sampleNo":1,
	}
}
