package com.frankdevhub.education;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.frankdevhub.education.bean.FooUser;
import com.frankdevhub.education.mapper.FooUserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemo301ApplicationTests {

	@Autowired
	private FooUserMapper mapper;

	@Test
	public void insert() {
		FooUser fooUser = new FooUser();
		fooUser.setName("test");
		fooUser.setCreateTime(new Date());
		int result = mapper.insert(fooUser);
		System.out.println(result);
	}

	@Test
	public void select() {
		FooUser result = mapper.selectByPrimaryKey(2);
		System.out.println(result);
	}

}
