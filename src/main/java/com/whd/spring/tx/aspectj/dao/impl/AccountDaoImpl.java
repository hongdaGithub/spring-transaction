package com.whd.spring.tx.aspectj.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.whd.spring.tx.aspectj.dao.AccountDao;



/** 
 * @ClassName: AccountDaoImpl 
 * @Description: 数据访问层:基于JDBCTemplate实现
 * @author HongDa
 * @date 2018年11月22日 下午6:35:47 
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
	
	/**
	 * @Description 转出
	 * @author HongDa
	 * @date 2018年11月21日 下午6:10:36
	 * @param out 转出账户
	 * @param money 转出金额
	 * @throws
	 */
	@Override
	public void outMoney(String out, Double money) {
		
		String sql = "UPDATE account SET money = money - ? WHERE name = ?";
		this.getJdbcTemplate().update(sql, money, out);
	}

	/**
	 * @Description 转入
	 * @author HongDa
	 * @date 2018年11月21日 下午6:11:11
	 * @param in 转入账户
	 * @param money 转入金额
	 * @throws
	 */
	@Override
	public void inMoney(String in, Double money) {
		String sql = "UPDATE account SET money = money + ? WHERE name = ?";
		this.getJdbcTemplate().update(sql, money, in);
	}
}
