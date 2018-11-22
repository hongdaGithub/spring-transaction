package com.whd.spring.tx.transactionfactorybean.service.impl;

import com.whd.spring.tx.transactionfactorybean.dao.AccountDao;
import com.whd.spring.tx.transactionfactorybean.service.AccountService;

/** 
 * @ClassName: AccountServiceImpl 
 * @Description: 账户业务实现类
 * @author HongDa
 * @date 2018年11月21日 下午6:05:13 
 */
public class AccountServiceImpl implements AccountService {
	
	private AccountDao accountDao;
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	/**
	 * @Description 转账业务
	 * @author HongDa
	 * @date 2018年11月21日 下午5:56:04
	 * @param out 转出账户
	 * @param in  转入账户
	 * @param money 转账金额
	 * @throws
	 */
	@Override
	public void transfer(String out, String in, Double money) {
		
		accountDao.outMoney(out, money);
		
		System.out.println(1/0);
		
		accountDao.inMoney(in, money);
	}
	
	/**
	 * @Description 转账业务(基于TransactionProxyFactoryBean实现声明式事务控制)
	 * @author HongDa
	 * @date 2018年11月22日 下午2:51:11
	 * @param out 转出账户
	 * @param in  转入账户
	 * @param money 转账金额
	 * @throws
	 */
	@Override
	public void transferByTransactionProxyFactoryBean(String out, String in, Double money){
		
		accountDao.outMoney(out, money);
		
		System.out.println(1/0);
		
		accountDao.inMoney(in, money);
	}
}
