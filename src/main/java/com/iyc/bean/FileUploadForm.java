/*
Revision History
-----------------------------------------------------------------
Ver. No       Date             Created By                Reason
1.0         04/09/2014        20064335            Initial Release
=================================================================

 **************************************************************************************************************
Author  :20064335
Purpose : This Bean class is used for uploading the files from web multipart.
 **************************************************************************************************************
 */

package com.iyc.bean;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadForm {

	private List<MultipartFile> files;

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
}
