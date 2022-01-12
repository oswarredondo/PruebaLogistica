package com.innovargia.autodoc.dto;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileBean {

    public FileBean() {
	// TODO Auto-generated constructor stub
    }

    private CommonsMultipartFile file_upload;

    public CommonsMultipartFile getFileData() {
	return file_upload;
    }

    public void setFileData(CommonsMultipartFile fileData) {
	this.file_upload = fileData;
    }

}
