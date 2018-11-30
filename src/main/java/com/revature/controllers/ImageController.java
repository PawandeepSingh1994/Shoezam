package com.revature.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.revature.services.AmazonClient;

@RestController
@RequestMapping("/storage/")
public class ImageController {

	private AmazonClient amazonClient;
	
	ImageController(AmazonClient amazonClient) {
		this.amazonClient = amazonClient;
	}
	
	@PostMapping("/uploadFile")
	public String uploadFile(@RequestPart(value="file") MultipartFile file, Integer id) {
		return this.amazonClient.uploadFile(file, id);
	}
	
	@DeleteMapping("/deleteFile")
	public String deleteFile(@RequestPart(value="url") String fileUrl) {
		return this.amazonClient.deleteFileFroms3Bucket(fileUrl);
	}
}
