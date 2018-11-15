package com.spoon.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.spoon.mapper.UserMapper;
import com.spoon.pojo.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	//查询所有
	public List<User> findAll()
	{
		return userMapper.selectList(null);
	}
	//带条件查询EntityWrapper
	public List<User> find(User user) {
		//封装where条件
		EntityWrapper<User> wrapper=new EntityWrapper<User>();
		//封装对象里面写的都是数据库的字段的名称
		//QBC面向对象
		wrapper.like("name", user.getName()); //name like '%tony%'
		return userMapper.selectList(wrapper);
	}
	//新增
	public void insert(User user){
		userMapper.insert(user);
	}
	//修改
	public void update(User user) {
		userMapper.updateById(user);
	}
	//删除
	public void delete(Integer id){
		List<Integer> idList=new ArrayList<Integer>();
		idList.add(id);
		//批量删除
		userMapper.deleteBatchIds(idList);
	}
}
