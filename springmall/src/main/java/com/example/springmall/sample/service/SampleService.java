package com.example.springmall.sample.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.springmall.sample.mapper.SampleFileMapper;
import com.example.springmall.sample.mapper.SampleMapper;
import com.example.springmall.sample.vo.Sample;
import com.example.springmall.sample.vo.SampleFile;
import com.example.springmall.sample.vo.SampleRequest;

@Service
@Transactional
public class SampleService {
	@Autowired
	private SampleMapper sampleMapper;
	@Autowired
	private SampleFileMapper sampleFileMapper;
	
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
		SampleFile sampleFile = sampleFileMapper.selectSampleFileName(sampleNo);
		if(sampleFile != null) {
			sampleFileMapper.deleteSampleFile(sampleNo);
		}
		File file = new File(sampleFile.getSamplefilePath()+"/"+sampleFile.getSamplefileName()+"."+sampleFile.getSamplefileExt());
		if(file.exists()) {
			if(file.delete()) {
				System.out.println("파일삭제완료");
			}else {
				System.out.println("파일삭제실패");
			}
		} else {
			System.out.println("삭제불가능");
		}
		return sampleMapper.deleteSample(sampleNo);
	}
	
	//3
	public int addSample(SampleRequest sampleRequest) {
		/*
		 * SampleRequest --> Sample
		 * 1. multipartfile 파일 데이터 저장
		 * 2. multipartfile 정보 -> 새로운 정보 추가-> SampleFile
		 */
		//1)
		Sample sample = new Sample();
		sample.setSampleId(sampleRequest.getSampleId());
		sample.setSamplePw(sampleRequest.getSamplePw());
		sampleMapper.insertSample(sample); //sampleNo가 부여 -> mybatis 자동생성 키값채우기실시
		//2)
		SampleFile sampleFile = new SampleFile();
		MultipartFile multipartFile = sampleRequest.getMultipartFile();
				
		//1.SampleFileNo : AutoIncrement
		//2. sampleNo
		sampleFile.setSampleNo(sample.getSampleNo()); //insertSample(sample)후에PK값이 sample에 채워진다
		//3.SampleFilePath
		String path = "c:\\uploads"; //복잡한 루틴을 통해서 경로설정을 할수있도록
		sampleFile.setSamplefilePath(path);
		//4.SampleFileExt
		System.out.println(multipartFile.getOriginalFilename());
		String originalFileName = multipartFile.getOriginalFilename();
		// .확장자
		String ext = originalFileName.substring(0);
		sampleFile.setSamplefileExt(ext);
		//5.SampleFileName
		String filename = UUID.randomUUID().toString();
		sampleFile.setSamplefileName(filename);
		//6.SampleFileType
		sampleFile.setSamplefileType(multipartFile.getContentType());
		//7.SampleFileSize
		sampleFile.setSamplefileSize(multipartFile.getSize());
		//내가 원하는 이름의 빈파일 만들기
		File f = new File(path+"\\"+filename+"."+ext);
		try {
			multipartFile.transferTo(f);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		return sampleFileMapper.insertSampleFile(sampleFile);
	}
	
	//4-1
	public Sample getSample(int sampleNo) {
		return sampleMapper.selectOne(sampleNo);
	}
	
	//4-2
	public int modifySample(Sample sample) {
		return sampleMapper.updateSample(sample);
	}

	//5-2
	public int loginSample(Sample sample) {
		return sampleMapper.loginSample(sample);
	}
}
