package com.dazhumei.love.postbar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dazhumei.love.crawler.GetOnePostBar;
import com.dazhumei.love.postbar.entity.Post;
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
	public String beginSelect() {
		String baseurl1 = "http://tieba.baidu.com";
		String baseurl2 = "https://tieba.baidu.com";

		String name1 = "武汉纺织大学";
		String url1 = "http://tieba.baidu.com/f?kw=" + name1;
		GetOnePostBar thread1 = new GetOnePostBar(postBarService, postService, commentService, userService, name1, url1,baseurl1);
		thread1.start();
		System.out.println("线程一开启...");
		String name2 = "武汉纺织大学外经贸学院";
		String url2 = "http://tieba.baidu.com/f?kw=" + name2;
		GetOnePostBar thread2 = new GetOnePostBar(postBarService, postService, commentService, userService, name2, url2,baseurl1);
		thread2.start();
		System.out.println("线程二开启...");
		String name3 = "武汉纺织大学阳光校区";
		String url3 = "http://tieba.baidu.com/f?kw=" + name3;
		GetOnePostBar thread3 = new GetOnePostBar(postBarService, postService, commentService, userService, name3, url3,baseurl1);
		thread3.start();
		System.out.println("线程三开启...");
		String name4 = "武汉纺织大学职业技术学院";
		String url4 = "http://tieba.baidu.com/f?kw=" + name4;
		GetOnePostBar thread4 = new GetOnePostBar(postBarService, postService, commentService, userService, name4, url4,baseurl1);
		thread4.start();
		System.out.println("线程四开启...");
		String name5 = "武汉纺织大学南湖校区";
		String url5 = "https://tieba.baidu.com/f?kw=" + name5;
		GetOnePostBar thread5 = new GetOnePostBar(postBarService, postService, commentService, userService, name5, url5,baseurl2);
		thread5.start();
		System.out.println("线程五开启...");
		String name6 = "武汉纺织大学东湖校区";
		String url6 = "https://tieba.baidu.com/f?kw=" + name6;
		GetOnePostBar thread6 = new GetOnePostBar(postBarService, postService, commentService, userService, name6, url6,baseurl2);
		thread6.start();
		System.out.println("线程六开启...");
		String name7 = "武汉纺织大学贴吧";
		String url7 = "https://tieba.baidu.com/f?kw=" + name7;
		GetOnePostBar thread7 = new GetOnePostBar(postBarService, postService, commentService, userService, name7, url7,baseurl2);
		thread7.start();
		System.out.println("线程七开启...");
		return "start.............";
	}

}
