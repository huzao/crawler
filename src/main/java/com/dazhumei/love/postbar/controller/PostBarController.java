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
		String postbarname="武汉纺织大学";
		GetOnePostBar thread1=new GetOnePostBar(postBarService, postService, commentService, userService, postbarname);
		thread1.start();
		return "start.............";
	}

}
