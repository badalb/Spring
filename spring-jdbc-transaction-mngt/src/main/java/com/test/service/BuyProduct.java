package com.test.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.test.domain.Account;
import com.test.domain.Product;

public class BuyProduct {
	
	private JdbcTemplate jdbcTemplate;
	
	private PlatformTransactionManager transactionManager;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	public void buyProduct(String username, int productId) {
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		
		try {
			Integer price = ((JdbcTemplate) jdbcTemplate).queryForObject("SELECT PRICE FROM PRODUCTS WHERE Id = ?",
					new Object[] { new Integer(productId) },new RowMapper<Integer>() {
						@Override
						public Integer mapRow(ResultSet rs, int row) throws SQLException {
							Integer price = rs.getInt("price");
							return price;
						}
					}
					
					
					);
			jdbcTemplate.update("UPDATE PRODUCTS SET STOCK = STOCK - 1 WHERE ID = ?",
					new Object[] { new Integer(productId) });
			jdbcTemplate.update("UPDATE ACCOUNT SET AMOUNT = AMOUNT - ? WHERE USERNAME = ?",
					new Object[] { price, username });
			transactionManager.commit(status);
			
		} catch (DataAccessException e) {
			transactionManager.rollback(status);
			throw e;
		}
	}

	public void displayState(String username, int productId) {
		System.out.println("Database state after purchase ");
		Product product = jdbcTemplate.queryForObject("SELECT * FROM PRODUCTS WHERE ID = ? ",
				new Object[] { new Integer(productId) }, new RowMapper<Product>() {
					@Override
					public Product mapRow(ResultSet rs, int row) throws SQLException {
						Product product = new Product();
						product.setPrice(rs.getInt("price"));
						product.setProductId(rs.getInt("id"));
						product.setProductName(rs.getString("name"));
						product.setStock(rs.getInt("stock"));
						return product;
					}
				});
		System.out.println(product);
		Account account = jdbcTemplate.queryForObject("SELECT * FROM ACCOUNT WHERE USERNAME = ? ",
				new Object[] { username }, new RowMapper<Account>() {
					@Override
					public Account mapRow(ResultSet rs, int row) throws SQLException {
						Account account = new Account();
						account.setBalance(rs.getInt("amount"));
						account.setUsername(rs.getString("username"));
						return account;
					}
				});
		System.out.println(account);
	}
}