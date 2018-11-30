package com.revature.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.revature.daos.ShoeDaoImp;

@Service
public class AmazonClient {

	private AmazonS3 s3Client;
	private ShoeDaoImp shoeDaoImp;
	
	private String endpointUrl = System.getenv("S3_URL");
	private String bucketName = System.getenv("S3_BUCKET");
	private String accessKey = System.getenv("IAM_ACCESSKEY");
	private String secretKey = System.getenv("IAM_SECRETKEY");
	
	@SuppressWarnings("deprecation")
	@PostConstruct
	private void initializeAmazon() {
		AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
		this.s3Client = new AmazonS3Client(credentials);
	}
	
	private File convertMultipartFileToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}
	
	private String generateFileName(MultipartFile multiPart, Integer shoeId) {
		return new Date().getTime() + "-" + shoeId + "-" + multiPart.getOriginalFilename().replace(" ", "_");
	}
	
	private void uploadFileTos3Bucket(String fileName, File file) {
		s3Client.
			putObject(new PutObjectRequest(bucketName, fileName, file).
					withCannedAcl(CannedAccessControlList.PublicRead));
	}
	
	public String uploadFile(MultipartFile multipartFile, Integer shoeId) {
		String fileUrl = "";
		
		try {
			File file = convertMultipartFileToFile(multipartFile);
			String fileName = generateFileName(multipartFile, shoeId);
			fileUrl = endpointUrl + "/" + bucketName + "/" + fileName;
			uploadFileTos3Bucket(fileName, file);
			file.delete();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return fileUrl;
	}
	
	public String deleteFileFroms3Bucket(String fileUrl) {
		String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
		s3Client.deleteObject(new DeleteObjectRequest(bucketName + "/", fileName));
		return "Successfully deleted" + fileUrl;
	}
}
