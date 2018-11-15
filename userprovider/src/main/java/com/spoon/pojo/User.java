package com.spoon.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
@TableName("user")
public class User implements Serializable{
	/**
	 * 表和类映射
	 * select 字段* from @TableName
	 */
	private static final long serialVersionUID = 1L;
	//主键,自增主键策略
	@TableId(type=IdType.AUTO)
	private Integer id;
	//映射，全局配置驼峰规则，MyBatisPlus自动修改
	private String name;
	//@DateTimeFormat(pattern="yyyy-MM-dd")//此注解亚洲多加8小时
	@JsonFormat(pattern="yyyy-MM-dd",timezone="Asia/Shanghai")
	private Date birthday;
	private String address;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthday=" + birthday + ", address=" + address + "]";
	}
	
}
