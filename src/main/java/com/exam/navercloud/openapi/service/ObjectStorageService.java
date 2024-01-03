package com.exam.navercloud.openapi.service;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;

/* 본래 네이버 오브젝트 스토리지의 서비스였으나 AWS 버킷으로 교체함*/

@Service
public class ObjectStorageService {
  
  /**
   * 고유 url 포맷
   * https://kr.object.ncloudstorage.com/[버킷명]/[폴더명]/[파일명]
   */
  
  // S3 생성을 위해 필요한 데이터 
  final String endPoint = "https://kr.object.ncloudstorage.com";
  final String regionName = "kr-standard";
  @Value("${open.api.access.key}")
  protected String accessKey;
  @Value("${open.api.secret.key}")
  protected String secretKey;
  
  private final String BUCKET_NAME = "team1-bucket"; // bucket 이름

  
  // AmazoneS3 얻기
  private AmazonS3 getAmazoneS3(final String endPoint, 
                                final String regionName, 
                                final String accessKey, 
                                final String secretKey) {
    return AmazonS3ClientBuilder.standard()
        .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endPoint, regionName))
        .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
        .build();
}
  
  
  /**
   * 
   * @param OBJECT_NAME 오브젝트 이름(업로드 혹은 다운로드 할 파일명)
   * @param DOWNLOAD_FILE_PATH 다운받을 파일 절대경로
   */
  // Object 다운로드
  public void download(final String OBJECT_NAME, final String DOWNLOAD_FILE_PATH) {
    
    final AmazonS3 s3 = getAmazoneS3(endPoint, regionName, accessKey, secretKey);


    // download object
    try {
        S3Object s3Object = s3.getObject(BUCKET_NAME, OBJECT_NAME);
        S3ObjectInputStream s3ObjectInputStream = s3Object.getObjectContent();

        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(DOWNLOAD_FILE_PATH));
        byte[] bytesArray = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = s3ObjectInputStream.read(bytesArray)) != -1) {
            outputStream.write(bytesArray, 0, bytesRead);
        }

        outputStream.close();
        s3ObjectInputStream.close();
        System.out.format("Object %s has been downloaded.\n", OBJECT_NAME);
    } catch (AmazonS3Exception e) {
        e.printStackTrace();
    } catch(SdkClientException e) {
        e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  
  /**
   * 
   * @param OBJECT_NAME 오브젝트 이름(업로드 혹은 다운로드 할 파일명)
   * @param UPLOAD_FILE_PATH 업로드할 파일의 절대경로
   */
  // 오브젝트 업로드
  public void upload(final String OBJECT_NAME, final String UPLOAD_FILE_PATH) {
    
    final AmazonS3 s3 = getAmazoneS3(endPoint, regionName, accessKey, secretKey);
 
    try {
      s3.putObject(new PutObjectRequest(BUCKET_NAME, OBJECT_NAME, new File(UPLOAD_FILE_PATH))
          .withCannedAcl(CannedAccessControlList.PublicRead));
      System.out.format("Object %s has been created.\n", OBJECT_NAME);
    } catch (AmazonS3Exception e) {
      e.printStackTrace();
    } catch (SdkClientException e) {
      e.printStackTrace();
    }

  }

}

