package com.whd.spring.tx.programmatic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.whd.spring.tx.programmatic.dao.AccountDao;
import com.whd.spring.tx.programmatic.service.AccountService;

/** 
 * @ClassName: AccountServiceImpl 
 * @Description: 账户业务实现类
 * @author HongDa
 * @date 2018年11月21日 下午6:05:13 
 */
public class AccountServiceImpl implements AccountService {
	
	private AccountDao accountDao;
	
	@Autowired
	private TransactionTemplate transactionTemplate;
	
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	
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
	 * @Description 转账业务(实现编程式事务控制)
	 * @author HongDa
	 * @date 2018年11月21日 下午5:56:04
	 * @param out 转出账户
	 * @param in  转入账户
	 * @param money 转账金额
	 * @throws
	 */
	@Override
	public void transferByProgrammaticTransaction(String out, String in, Double money){
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				accountDao.outMoney(out, money);
				
				System.out.println(1/0);
				
				accountDao.inMoney(in, money);
			}
		});
	}
}
