package com.yedam.pettopia.common;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	
	@Value("${file.upload}")
	private String uploadPath;
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public String uploadFile(@RequestParam("uploadfile") MultipartFile uploadfile) {
		
		String filename;
		try {
			filename = uploadfile.getOriginalFilename();
			String directory = uploadPath;
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
	
	
	 @GetMapping("/downloadFile")
	    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        try {
	            String path = request.getParameter("filepath");
	            File file = new File("C:\\upload", path);
	            
	            String fileName = new String(file.getName().getBytes("UTF-8"), "iso-8859-1");

	            response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName +"\"");
	            response.setContentType("application/octet-stream");
	            
	            FileInputStream fileInputStream = new FileInputStream(file);
	            OutputStream out = response.getOutputStream();

	            int read = 0;
	            byte[] buffer = new byte[1024];
	            while ((read = fileInputStream.read(buffer)) != -1) {
	                out.write(buffer, 0, read);
	            }

	        } catch (Exception e) {
	        	e.printStackTrace();
	            throw new Exception("download error");
	        }
	    }
}
