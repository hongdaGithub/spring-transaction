package com.whd.spring.tx.transactionfactorybean.dao;

public interface AccountDao {
	
	/**
	 * @Description 转出
	 * @author HongDa
	 * @date 2018年11月21日 下午6:10:36
	 * @param out 转出账户
	 * @param money 转出金额
	 * @throws
	 */
	public void outMoney(String out,Double money);
	
	/**
	 * @Description 转入
	 * @author HongDa
	 * @date 2018年11月21日 下午6:11:11
	 * @param in 转入账户
	 * @param money 转入金额
	 * @throws
	 */
	public void inMoney(String in,Double money);
}
