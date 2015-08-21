package com.sven.servlet;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 文件上传功能（单文件）
 * @author Sven
 *
 */

@Controller
@RequestMapping("uploadFile")
public class UploadFileServlet {
	
	private static Logger log = LoggerFactory.getLogger(UploadFileServlet.class);
	@RequestMapping("upload")
	public String upload(){
		
		return "front/file";
	}
	@RequestMapping(value="doUpload",method=RequestMethod.POST)
	public String doUpload(@RequestParam("file")MultipartFile file) throws IOException{
		if(!file.isEmpty()){
			log.debug("Process file:{}",file.getOriginalFilename());
			FileUtils.copyInputStreamToFile(file.getInputStream(), 
			new File("E:\\work\\appDownload",System.currentTimeMillis()+file.getOriginalFilename()));
			return "success";
		}else{
			return "failure";
		}
		
		
	}

}
