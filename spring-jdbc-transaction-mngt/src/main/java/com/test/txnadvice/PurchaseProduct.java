package com.test.txnadvice;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.test.domain.Account;
import com.test.domain.Product;

public class PurchaseProduct {
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void buyProduct(String username, int productId) {
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
			jdbcTemplate.update("UPDATE PRODUCTS SET STOCK =STOCK - 1 WHERE ID = ?",
					new Object[] { new Integer(productId) });
			jdbcTemplate.update("UPDATE ACCOUNT SET AMOUNT =AMOUNT - ? WHERE USERNAME = ?",
					new Object[] { price, username });
		} catch (Exception e) {
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