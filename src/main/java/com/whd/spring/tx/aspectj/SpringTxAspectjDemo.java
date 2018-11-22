package com.whd.spring.tx.aspectj;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.whd.spring.tx.aspectj.service.AccountService;

/** 
 * @ClassName: SpringTxAspectjDemo 
 * @Description:基于AspectJ方式的声明式事务 
 * @author HongDa
 * @date 2018年11月22日 下午6:05:41 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-aspectj.xml")
public class SpringTxAspectjDemo {
	
	@Resource(name="accountService")
	private AccountService accountService;
	
	@Test
	public void demo(){
		accountService.transfer("aaa", "bbb", 200d);
	}
	
	@Test
	public void aspectjDemo(){
		accountService.transferByAspectJ("aaa", "bbb", 200d);
	}
}
