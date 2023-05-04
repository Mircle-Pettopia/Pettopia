package com.yedam.pettopia.common;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public String uploadFile(@RequestParam("uploadfile") MultipartFile uploadfile) {
		
		String filename;
		try {
			filename = uploadfile.getOriginalFilename();
			String directory = "C:\\upload";
			String filepath = Paths.get(directory, filename).toString();

			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			stream.write(uploadfile.getBytes());
			stream.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "error";
		}

		return "/download/" + filename;
	}
}
