package com.test;

import com.test.mapper.UsertableMapper;
import com.test.pojo.Usertable;
import com.test.pojo.UsertableExample;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LostAndFoundApplicationRevisionTests {

	@Autowired
	UsertableMapper uMapper;
	@Test
	void contextLoads() {
		//UsertableExample uExample = new UsertableExample();
		//uExample.createCriteria().andUserIdEqualTo(12222l);
		////System.out.println(uMapper);
		//List<Usertable> list = uMapper.selectByExample(uExample);
		//System.out.println(list.size());
	}

}
