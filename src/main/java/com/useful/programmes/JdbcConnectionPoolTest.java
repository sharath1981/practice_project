package com.useful.programmes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcConnectionPoolTest {

	public static void main(String[] args) throws Exception {
		final Connection connection = JdbcConnection.POOL.get();
		System.out.println("current pool size = "+JdbcConnection.POOL.size());
		try(final Statement statement = connection.createStatement();
				final ResultSet resultSet = statement.executeQuery("select * from coupon");) {
			while(resultSet.next()) {
				System.out.println(resultSet.getString("id"));
				System.out.println(resultSet.getString("code"));
				System.out.println(resultSet.getString("discount"));
				System.out.println(resultSet.getString("exp_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JdbcConnection.POOL.release(connection);
			JdbcConnection.POOL.shutDown();
		}
		System.out.println("current pool size = "+JdbcConnection.POOL.size());
		System.out.println(JdbcConnection.POOL.get());
	}
	
}