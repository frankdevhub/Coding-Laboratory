package com.frankdevhub.education.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

import com.frankdevhub.education.bean.FooUser;
import com.frankdevhub.education.mapper.FooUserMapper;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private FooUserMapper fooUserMapper;

	@ApiOperation(value = "search user" ,notes = "search user via id")
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public FooUser get(@RequestParam(defaultValue = "1") Integer id) {
		return fooUserMapper.selectByPrimaryKey(id);
	}

	@ApiIgnore
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public int delete(@RequestParam(defaultValue = "1") Integer id) {
		return fooUserMapper.deleteByPrimaryKey(id);
	}
}
