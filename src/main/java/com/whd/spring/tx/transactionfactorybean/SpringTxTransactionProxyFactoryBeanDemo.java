package com.whd.spring.tx.transactionfactorybean;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.whd.spring.tx.transactionfactorybean.service.AccountService;

/** 
 * @ClassName: SpringTxTransactionProxyFactoryBeanDemo 
 * @Description: 基于TransactionProxyFactoryBean的声明式事务管理
 * @author HongDa
 * @date 2018年11月22日 下午6:07:01 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-transactionProxyFactoryBean.xml")
public class SpringTxTransactionProxyFactoryBeanDemo {
	
	@Resource(name="accountService")
	private AccountService accountService;
	
	@Resource(name="accountServiceProxy")
	private AccountService accountServiceProxy;
	
	@Test
	public void demo(){
		accountService.transfer("aaa", "bbb", 200d);
	}
	
	@Test
	public void transactionProxyFactoryBeanDemo(){
		accountServiceProxy.transferByTransactionProxyFactoryBean("aaa", "bbb", 200d);
	}
}
