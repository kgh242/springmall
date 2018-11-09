package com.example.springmall.sample.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.springmall.sample.vo.Sample;

@Mapper
public interface SampleMapper { //인터페이스는 무조건 public 
	//1.select all
	List<Sample> selectSampleAll(int startRow, int rowPerPage);
	int selectSampleCount();
	//2.insert
	int insertSample(Sample sample);
	//3.delete
	int deleteSample(int sampleNo);
	//4.update
	int updateSample(Sample sample);
	//5.select one
	Sample selectOne(int sampleNo);
	//6.login
	int loginSample(Sample sample);
	//7.loginSelect
	Sample loginSelectSample(String sampleId, String samplePw);
}
