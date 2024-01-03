package com.exam.navercloud.openapi.service;

import com.amazonaws.services.s3.AmazonS3;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.exam.dto.UploadDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import lombok.RequiredArgsConstructor;

//@Service
//@RequiredArgsConstructor
//public class S3UploadTest {
//	 private final AmazonS3 amazonS3;
//
//	    @Value("${cloud.aws.s3.bucket}")
//	    private String bucket;
//
//	    public String saveFile(UploadDTO dto) throws IOException {
//	    	
//	    	
//	    	
//	    	String theText = dto.getTheText();
//	    	MultipartFile theFile = dto.getTheFile();
//
//	        ObjectMetadata metadata = new ObjectMetadata();
//	        metadata.setContentLength(theFile.getSize());
//	        metadata.setContentType(theFile.getContentType());
//
//	        amazonS3.putObject(bucket, theText, theFile.getInputStream(), metadata);
//	        return amazonS3.getUrl(bucket, theText).toString();
//	    }
//}
