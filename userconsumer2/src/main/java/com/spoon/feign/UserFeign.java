package com.spoon.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spoon.pojo.User;

@FeignClient("user-provider")
public interface UserFeign {
	@RequestMapping("/user/findAll")	//必须路径写全
	public List<User> findAll();		//POJO中的日期的处理
	
	@RequestMapping("/user/find")
	public List<User> find(@RequestBody User user);
	
	@RequestMapping("/user/insert")		//对象传参，内部走的是json提交
	public String insert(@RequestBody User user);
	
	@RequestMapping("/user/update")		//转换成json方式，接参
	public String update(@RequestBody User user);
	
	@RequestMapping("/user/delete/{id}")
	public String delete(@PathVariable("id") Integer id);
}
