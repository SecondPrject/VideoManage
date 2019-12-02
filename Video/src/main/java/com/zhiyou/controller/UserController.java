package com.zhiyou.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.model.User;
import com.zhiyou.service.UserService;

@Controller
public class UserController {

	@Autowired(required = true)
	UserService service;

	@RequestMapping("/show")
	public String show(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("list", service.selectAll());
		return "show";
	}

	@RequestMapping("/add")
	public String add(User user, HttpServletRequest request, HttpServletResponse response) {
		service.add(user);
		return "redirect:show";
	}

	@RequestMapping("/delete")
	public String delete(int id, HttpServletRequest request, HttpServletResponse response) {
		service.delete(id);
		return "redirect:show";
	}

	@RequestMapping("/selectById")
	public String selectById(int id, HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("user", service.selectById(id));
		return "update";
	}

	@RequestMapping("/update")
	public String update(User user, HttpServletRequest request, HttpServletResponse response) {
		service.update(user);
		return "redirect:show";
	}
}
