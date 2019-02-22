package com.example.demo;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 2032911390858080147L;

	private String name;

	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}

	public User(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

}
