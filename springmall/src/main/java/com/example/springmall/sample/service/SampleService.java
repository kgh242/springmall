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
		// 페이징 관련 코드
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
}
