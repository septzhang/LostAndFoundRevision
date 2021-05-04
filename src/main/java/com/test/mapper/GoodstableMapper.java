package com.test.mapper;

import com.test.pojo.Goodstable;
import com.test.pojo.GoodstableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodstableMapper {
    int countByExample(GoodstableExample example);

    int deleteByExample(GoodstableExample example);

    int deleteByPrimaryKey(Integer goodsId);

    int insert(Goodstable record);

    int insertSelective(Goodstable record);

    List<Goodstable> selectByExample(GoodstableExample example);

    Goodstable selectByPrimaryKey(Integer goodsId);

    int updateByExampleSelective(@Param("record") Goodstable record, @Param("example") GoodstableExample example);

    int updateByExample(@Param("record") Goodstable record, @Param("example") GoodstableExample example);

    int updateByPrimaryKeySelective(Goodstable record);

    int updateByPrimaryKey(Goodstable record);
}