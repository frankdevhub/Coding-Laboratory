package com.frankdevhub.education.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.frankdevhub.education.bean.FooUserLog;
import com.frankdevhub.education.bean.FooUserLogExample;

@Mapper
public interface FooUserLogMapper {
    int countByExample(FooUserLogExample example);

    int deleteByExample(FooUserLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FooUserLog record);

    int insertSelective(FooUserLog record);

    List<FooUserLog> selectByExample(FooUserLogExample example);

    FooUserLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FooUserLog record, @Param("example") FooUserLogExample example);

    int updateByExample(@Param("record") FooUserLog record, @Param("example") FooUserLogExample example);

    int updateByPrimaryKeySelective(FooUserLog record);

    int updateByPrimaryKey(FooUserLog record);
}