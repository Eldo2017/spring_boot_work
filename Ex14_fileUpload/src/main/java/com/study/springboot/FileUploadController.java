package com.study.springboot;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

@Controller
public class FileUploadController {
	
	@RequestMapping("/")
	public String root() {
		return "fileForm";
	}
	
	@PostMapping("/upload")
	public @ResponseBody String upload(HttpServletRequest request) {
		JSONObject obj = new JSONObject();
		try {
			// upload폴더
			/*
			String filePath = ResourceUtils.getFile("classpath:static/upload")
											.toPath()
											.toString();
			*/
			String filePath = new File("src/main/resources/static/upload").getAbsolutePath();
			System.out.println(filePath);
			
			// request.getParts() : 요청에서 전송된 모든 파일 파트를 가져옴
			List<Part> fileParts = request.getParts()
											.stream()
											.filter(part -> "files".equals(part.getName()) && part.getSize() > 0) 
											.collect(Collectors.toList());
			
			// 파일이 여러개 일 때
			for(Part filePart : fileParts) {
				// 업로드한 파일 이름 가져오기
				String fileName = Paths.get(filePart.getSubmittedFileName())
										.getFileName()
										.toString();
				// 파일을 저장할 전체 경로 설정
				String dst = filePath + "\\" + fileName;
				try(BufferedInputStream fin = new BufferedInputStream(filePart.getInputStream());
					BufferedOutputStream fout = new BufferedOutputStream(new FileOutputStream(dst));	
					) {
					int data;
					while(true) {
						data = fin.read();
						if(data == -1)
							break;
						fout.write(data);
					}
				} catch(IOException e) {
					e.printStackTrace();
				}
				System.out.println("upload fileName : " + dst);
			}
			obj.put("success", "1");
			obj.put("msg", "업로드 성공");
		} catch (Exception e) {
			e.printStackTrace();
			obj.put("success", "0");
			obj.put("msg", "업로드 실패");
		}
		return obj.toJSONString();
	}
}