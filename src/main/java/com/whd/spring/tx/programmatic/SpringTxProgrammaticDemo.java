package com.whd.spring.tx.programmatic;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.whd.spring.tx.programmatic.service.AccountService;

/** 
 * @ClassName: SpringTransactionDemo 
 * @Description: Spring编程式事务控制测试DEMO 
 * 使用Spring提供的TransactionTemplate模板实现
 * @author HongDa
 * @date 2018年11月22日 下午2:58:15 
 */
/** 
 * @ClassName: SpringTxProgrammaticDemo 
 * @Description: 基于TransactionTemplate的编程式事务管理 
 * @author HongDa
 * @date 2018年11月22日 下午6:06:16 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-programmatic.xml")
public class SpringTxProgrammaticDemo {
	
	@Resource(name="accountService")
	private AccountService accountService;
	
	@Test
	public void demo(){
		accountService.transfer("aaa", "bbb", 200d);
	}
	
	@Test
	public void programmingTransactionDemo(){
		accountService.transferByProgrammaticTransaction("aaa", "bbb", 200d);
	}
}
