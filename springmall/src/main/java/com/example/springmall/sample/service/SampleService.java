package com.example.springmall.sample.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springmall.sample.mapper.SampleMapper;
import com.example.springmall.sample.vo.Sample;

@Service
@Transactional
public class SampleService {
	@Autowired
	private SampleMapper sampleMapper;
	int startRow=0;
	int rowPerPage=10;
	int totalCount;
	//1
	public int getSampleCount() {
		return totalCount=sampleMapper.selectSampleCount(); 
	}
	public List<Sample> getSampleAll(int startRow){
		return sampleMapper.selectSampleAll(startRow,rowPerPage);
	}
	
	//2
	public int removeSample(int sampleNo) {
		int result = sampleMapper.deleteSample(sampleNo);
		if(result == 1) {
			System.out.println("삭제완료");
		} else {
			System.out.println("삭제실패");
		}
		return result;
	}
	
	//3
	public int addSample(Sample sample) {
		return sampleMapper.insertSample(sample);
	}
	
	//4-1
	public Sample getSample(int sampleNo) {
		return sampleMapper.selectOne(sampleNo);
	}
	
	//4-2
	public int modifySample(Sample sample) {
		return sampleMapper.updateSample(sample);
	}
	
	//5-1
	public Sample getLoginSample(String sampleId, String samplePw) {
		return sampleMapper.loginSelectSample(sampleId, samplePw);
	}
	//5-2
	public int loginSample(Sample sample) {
		return sampleMapper.loginSample(sample);
	}
}
