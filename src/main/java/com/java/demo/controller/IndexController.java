package com.java.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.demo.model.entity.User;
import com.java.demo.model.utils.ResponseWrapper;
import com.java.demo.service.UserService;

@RestController
public class IndexController {
	
	@Autowired
	private UserService userService;
	
	
	/*
	 浏览器打开任意网站，f12，切到console页面，输入以下代码（对于/login/UserLogin请求）测试是否跨域成功

	
	------code------
	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'http://127.0.0.1:8080/login/UserLogin?email=admin&password=123456');
	xhr.send(null);
	xhr.onload = function(e) {
    var xhr = e.target;
    console.log(xhr.responseText);
    }
    ------code------
    
	-------跨域失败的输出------
	 
	 Access to XMLHttpRequest at 'http://127.0.0.1:8080/login/UserLogin?email=admin&password=123456' 
	 from origin 'https://www.cnblogs.com' has been blocked by CORS policy: 
	 No 'Access-Control-Allow-Origin' header is present on the requested resource.
	 
	 ------跨域成功的输出（前提是建好数据库）------
	 
	 {"code":"1010","message":"success","data":{"id":1,"name":"主人","account":"admin","password":"123"}}
	 
	 */
	//加@CrossOrigin注解实现跨域
	@CrossOrigin
	@RequestMapping("/login/UserLogin")
	public ResponseWrapper getEntity(@RequestParam("email") String email,
									@RequestParam("password") String password) {
		
		User user = userService.getUserByUsername(email);
		
		System.out.println(user);
		
		System.out.println(new ResponseWrapper<>(user));
		
		return new ResponseWrapper<>(user);
	}
	
}
