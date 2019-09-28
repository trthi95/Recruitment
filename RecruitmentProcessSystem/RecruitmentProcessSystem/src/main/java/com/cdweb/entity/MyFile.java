package com.cdweb.entity;

import org.springframework.web.multipart.MultipartFile;

public class MyFile {
	private MultipartFile multipartFile;
	private String description;

	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
