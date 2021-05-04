package com.test.mapper;

import com.test.pojo.Emailtable;
import com.test.pojo.EmailtableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmailtableMapper {
    int countByExample(EmailtableExample example);

    int deleteByExample(EmailtableExample example);

    int deleteByPrimaryKey(Integer emailId);

    int insert(Emailtable record);

    int insertSelective(Emailtable record);

    List<Emailtable> selectByExample(EmailtableExample example);

    Emailtable selectByPrimaryKey(Integer emailId);

    int updateByExampleSelective(@Param("record") Emailtable record, @Param("example") EmailtableExample example);

    int updateByExample(@Param("record") Emailtable record, @Param("example") EmailtableExample example);

    int updateByPrimaryKeySelective(Emailtable record);

    int updateByPrimaryKey(Emailtable record);
}