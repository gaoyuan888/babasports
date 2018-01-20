package gaoyuan.core.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import gaoyuan.common.web.Constants;
import gaoyuan.core.service.product.UploadService;

@Controller
public class UploadController {
	
	@Autowired
	private UploadService uploadService;
	@RequestMapping(value="/upload/uploadPic.do")
	public void uploadPic(@RequestParam(required =false) MultipartFile pic,
			HttpServletResponse response){
		String url="";
		try {
			String path = uploadService.uploadPic(pic.getBytes(), pic.getOriginalFilename(), pic.getSize());
			url=Constants.img_url+path;
			JSONObject jo=new JSONObject();
			jo.put("url", url);
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(jo.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
