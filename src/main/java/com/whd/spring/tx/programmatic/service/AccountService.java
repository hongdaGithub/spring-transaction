package com.whd.spring.tx.programmatic.service;

public interface AccountService {
	
	/**
	 * @Description 转账业务
	 * @author HongDa
	 * @date 2018年11月21日 下午5:56:04
	 * @param out 转出账户
	 * @param in  转入账户
	 * @param money 转账金额
	 * @throws
	 */
	public void transfer(String out,String in,Double money);
	
	/**
	 * @Description 转账业务(实现编程式事务控制)
	 * @author HongDa
	 * @date 2018年11月22日 下午2:51:11
	 * @param out
	 * @param in
	 * @param money
	 * @throws
	 */
	public void transferByProgrammaticTransaction(String out,String in,Double money);
}
