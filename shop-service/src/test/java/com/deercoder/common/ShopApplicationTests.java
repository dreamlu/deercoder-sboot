//package com.deercoder.shop;
//
//import com.deercoder.shop.model.Shop;
//import com.deercoder.shop.repository.ShopRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ShopApplicationTests {
//
//	@Autowired
//	private ShopRepository userRepository;
//
//	@Test
////	@Transactional
//	public void test() {
//		//测试 事务
//		// 创建10条记录
//		userRepository.save(new Shop("AAA", "123456"));
////		userRepository.save(new User("BBB", "123456"));
////		userRepository.save(new User("CCC", "123456"));
////		userRepository.save(new User("DDD", "123456"));
////		userRepository.save(new User("EEE", "123456"));
////		userRepository.save(new User("FFF", "123456"));
////		userRepository.save(new User("GGG", "123456"));
//		//name不能为空，会抛出异常，来测试事务是否会回滚
////		userRepository.save(new User("测试测试测试测试测试测试", "123456"));
////		userRepository.save(new User("III", "123456"));
////		userRepository.save(new User("JJJ", "123456"));
//
//		// 测试成功
//	}
//}
