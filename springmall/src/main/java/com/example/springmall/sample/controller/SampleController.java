package com.example.springmall.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springmall.sample.service.SampleService;
import com.example.springmall.sample.vo.Sample;

@Controller
public class SampleController {
	@Autowired
	private SampleService sampleService;
	
	//1. 샘플 목록
	@RequestMapping(value="/sample/sampleList", method=RequestMethod.GET)
	public String sampleList(Model model,@RequestParam(value="startRow",required=false,defaultValue="0") int startRow) {	//Model model = new Model();
		System.out.println("Controller.sampleList");
		List<Sample> sampleList = sampleService.getSampleAll(startRow);
		int totalCount=sampleService.getSampleCount();
		model.addAttribute("sampleList", sampleList);
		model.addAttribute("startRow",startRow);
		model.addAttribute("totalCount", totalCount);
		return "/sample/sampleList";
	}
	
	//2. 삭제
	@RequestMapping(value="/sample/removeSample", method=RequestMethod.GET)
	public String removeSample(@RequestParam(value="sampleNo") int sampleNo) { //참조타입String에서 참조타입Integer로 래핑, Integer을 언박싱해서 int로 자동변환
		if(sampleService.removeSample(sampleNo)==1) {
			System.out.println(sampleNo+"번 데이터 삭제 성공");
		}
		return "redirect:/sample/sampleList"; //spring은 redirect를 먼저인식
	}
	
	//3-1 입력 폼
	@RequestMapping(value="/sample/addSample", method=RequestMethod.GET)
	public String addSample() {
		System.out.println("Controller.addSample 폼 이동");
		return "/sample/addSample";
		// jqeury, bootstrap, Sample command객체 
	}
	//3-2 입력 액션
	@RequestMapping(value="/sample/addSample", method=RequestMethod.POST)
	public String addSample(Sample sample) { 
		//sample친구들 (도메인객체, 커맨드객체등등)
		//command 객체의 멤버변수 == input태그 name속성, 표준 setter필요 
		System.out.println("Controller.addSample 액션");
		int row = sampleService.addSample(sample);
		return "redirect:/sample/sampleList";
	}
	
	//4-1 수정 폼
	@RequestMapping(value="/sample/modifySample", method=RequestMethod.GET)
	public String modifySample(Model model,@RequestParam(value="sampleNo") int sampleNo) {
		System.out.println("Controller.modifySample 폼 이동");
		Sample sample = sampleService.getSample(sampleNo);
		model.addAttribute("sample",sample);
		return "/sample/modifySample";
	}
	//4-2 수정 액션
	@RequestMapping(value="/sample/modifySample", method=RequestMethod.POST)
	public String modifySample(Sample sample) {
		System.out.println("Controller.modifySample 액션");
		sampleService.modifySample(sample);
		return "redirect:/sample/sampleList";
	}
}
