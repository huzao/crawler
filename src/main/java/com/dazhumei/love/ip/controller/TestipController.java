package com.dazhumei.love.ip.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dazhumei.love.ip.service.TestipService;
import com.dazhumei.love.utils.DBManageTest;

@Controller
@RequestMapping("/testip")
public class TestipController {
	
	@Autowired
	private TestipService testipService;
	
	
	@RequestMapping("/testOne")
	@ResponseBody
	public String testOne() throws SQLException{
		DBManageTest.testipBegain(testipService);
		return "MySQL开始.............";
	}

}
