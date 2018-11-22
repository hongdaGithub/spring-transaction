package com.whd.spring.tx.transactional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.whd.spring.tx.transactional.service.AccountService;

/** 
 * @ClassName: SpringTxTransactionalDemo 
 * @Description: 基于@Transactional注解方式的声明式事务管理
 * @author HongDa
 * @date 2018年11月22日 下午6:07:40 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-transactional.xml")
public class SpringTxTransactionalDemo {
	
	@Resource(name="accountService")
	private AccountService accountService;
	
	@Test
	public void demo(){
		accountService.transfer("aaa", "bbb", 200d);
	}
	
	@Test
	public void transactionalDemo(){
		accountService.transferByTransactional("aaa", "bbb", 200d);
	}
}
