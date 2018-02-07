package com.dazhumei.love.postbar.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dazhumei.love.crawler.GetOnePostBar;
import com.dazhumei.love.postbar.service.CommentService;
import com.dazhumei.love.postbar.service.PostBarService;
import com.dazhumei.love.postbar.service.PostService;
import com.dazhumei.love.postbar.service.UserService;

@Controller
@RequestMapping("/controller")
public class PostBarController {
	
	@Autowired
	private PostBarService postBarService;
	@Autowired
	private PostService postService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/beginSelect")
	@ResponseBody
	public String beginSelect(){
		String name1="武汉纺织大学";
		GetOnePostBar thread1=new GetOnePostBar(postBarService, postService, commentService, userService, name1);
		thread1.start();
		String name2="武汉纺织大学外经贸学院";
		GetOnePostBar thread2=new GetOnePostBar(postBarService, postService, commentService, userService, name2);
		thread1.start();
		String name3="武汉纺织大学阳光校区";
		GetOnePostBar thread3=new GetOnePostBar(postBarService, postService, commentService, userService, name3);
		thread1.start();
		String name4="武汉纺织大学职业技术学院";
		GetOnePostBar thread4=new GetOnePostBar(postBarService, postService, commentService, userService, name4);
		thread1.start();
		String name5="武汉纺织大学南湖校区";
		GetOnePostBar thread5=new GetOnePostBar(postBarService, postService, commentService, userService, name5);
		thread1.start();
		String name6="武汉纺织大学东湖校区";
		GetOnePostBar thread6=new GetOnePostBar(postBarService, postService, commentService, userService, name6);
		thread1.start();
		String name7="武汉纺织大学贴吧";
		GetOnePostBar thread7=new GetOnePostBar(postBarService, postService, commentService, userService, name7);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
		thread7.start();
		return "start.............";
	}

}
