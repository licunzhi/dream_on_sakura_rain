package com.meimei;

import com.google.common.cache.LoadingCache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoadingcacheApplicationTests {

	@Autowired
	private LoadingCache<String, String> dataCacheStorage;

	@Test
	public void dataCacheGetValueTest() throws ExecutionException {
		// 首次取值不存在
		System.out.println("'首次取值：" + dataCacheStorage.get("not exist"));
		// 再次取值已经存在  不加载load方法
		dataCacheStorage.get("not exist");
		System.out.println("'再次取值：" + dataCacheStorage.get("not exist"));
		// 首次取值不存在
		dataCacheStorage.get("not exist one");
		System.out.println("'首次取值：" + dataCacheStorage.get("not exist one"));
	}

}
