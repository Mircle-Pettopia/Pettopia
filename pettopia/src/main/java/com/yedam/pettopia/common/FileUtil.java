package com.yedam.pettopia.common;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	public static String fileupload(MultipartFile file){
		String filename="";  
		try {
			filename = file.getOriginalFilename();
			String directory = "C:\\upload";
			String filepath = Paths.get(directory, filename).toString();

			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			stream.write(file.getBytes());
			stream.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return filename;
	}
}
