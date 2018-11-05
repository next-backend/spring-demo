package com.example.demo.test;

import com.alibaba.fastjson.JSON;
import com.example.demo.bean.Account;
import com.example.demo.cache.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Resource
	private CacheService cacheService ;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testRedisA() {
		Account account = new Account(1L,"lily",200L,10L) ;
		String json = JSON.toJSONString(account);
		log.debug("result before -> {}",json);
		cacheService.set("account_1", json,100);
		log.debug("result after-> {}",cacheService.get("account_1"));
	}

}
