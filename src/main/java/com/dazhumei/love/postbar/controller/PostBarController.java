package com.dazhumei.love.postbar.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dazhumei.love.crawler.GetOnePostBar;
import com.dazhumei.love.postbar.service.CommentService;
import com.dazhumei.love.postbar.service.PostBarService;
import com.dazhumei.love.postbar.service.PostService;

@Controller
@RequestMapping("/controller")
public class PostBarController {
	
	@Autowired
	private PostBarService postBarService;
	@Autowired
	private PostService postService;
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/beginSelect")
	@ResponseBody
	public void beginSelect(){
		String name="武汉纺织大学";
		GetOnePostBar.GetAllPagePost("http://tieba.baidu.com/f?kw="+name, "/html/"+name+".html",name,postBarService,postService,commentService);
		
	}

}
