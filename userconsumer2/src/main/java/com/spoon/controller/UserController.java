package com.spoon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spoon.feign.UserFeign;
import com.spoon.pojo.User;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserFeign userFeign;
	
	@RequestMapping("/findAll")	//必须路径写全
	public List<User> findAll(){
		return userFeign.findAll();
	}
	
	@RequestMapping("/find/{name}")
	public List<User> find(User user){
		return userFeign.find(user);
	}
	
	@RequestMapping("/insert")
	public String insert(@RequestBody User user){
		return userFeign.insert(user);
	}
	
	@RequestMapping("/update/{name}/{id}")
	public String update(User user){
		return userFeign.update(user);
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Integer id){
		return userFeign.delete(id);
	}
}




