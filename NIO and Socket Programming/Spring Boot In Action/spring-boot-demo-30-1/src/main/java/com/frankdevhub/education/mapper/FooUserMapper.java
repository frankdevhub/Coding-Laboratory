package com.frankdevhub.education.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.frankdevhub.education.bean.FooUser;
import com.frankdevhub.education.bean.FooUserExample;

@Mapper
public interface FooUserMapper {
	int countByExample(FooUserExample example);

	int deleteByExample(FooUserExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(FooUser record);

	int insertSelective(FooUser record);

	List<FooUser> selectByExample(FooUserExample example);

	FooUser selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") FooUser record, @Param("example") FooUserExample example);

	int updateByExample(@Param("record") FooUser record, @Param("example") FooUserExample example);

	int updateByPrimaryKeySelective(FooUser record);

	int updateByPrimaryKey(FooUser record);
}