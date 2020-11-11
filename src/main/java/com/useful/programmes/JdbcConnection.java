package com.useful.programmes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public enum JdbcConnection {
	POOL;
	private static final String POOL_SIZE = "POOL_SIZE";
	//private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	//private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
	//private static final String DB_USER = "root";
	//private static final String DB_PASSWORD = "root";
	private static final String DRIVER_CLASS = "DRIVER_CLASS";
	private static final String DB_URL = "DB_URL";
	private static final String DB_USER = "DB_USER";
	private static final String DB_PASSWORD = "DB_PASSWORD";
	
	private final List<Connection> poolOfAvailableConnections;
	private final List<Connection> poolOfBusyConnections;
	private final int poolSize;

	private JdbcConnection() {
		poolSize = Integer.parseInt(System.getenv(POOL_SIZE));
		poolOfAvailableConnections = new ArrayList<>(poolSize);
		poolOfBusyConnections = new ArrayList<>(poolSize);
		registerDriver();
		initializePool();
	}

	private void initializePool() {
		Stream.generate(this::createConnection)
		      .limit(poolSize)
		      .filter(Objects::nonNull)
		      .forEach(poolOfAvailableConnections::add);
	}

	private Connection createConnection() {
		try {
			return DriverManager.getConnection(System.getenv(DB_URL), System.getenv(DB_USER), System.getenv(DB_PASSWORD));
		} catch (SQLException e) {
			return null;
		}
	}

	private void registerDriver() {
		try {
			Class.forName(System.getenv(DRIVER_CLASS))
				 .newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public synchronized Connection get() {
		if (poolOfAvailableConnections.isEmpty()) {
			throw new RuntimeException("Connection pool underflow...");
		}
		final Connection connection = poolOfAvailableConnections.remove(0);
		poolOfBusyConnections.add(connection);
		return connection;
	}

	public synchronized void release(final Connection connection) {
		if (poolOfAvailableConnections.size() == poolSize) {
			throw new RuntimeException("Connection pool overflow...");
		}
		if (poolOfBusyConnections.remove(connection)) {
			poolOfAvailableConnections.add(connection);
		}
	}

	public synchronized void shutDown() {
		poolOfBusyConnections.forEach(this::closeConnection);
		poolOfAvailableConnections.forEach(this::closeConnection);
		poolOfBusyConnections.clear();
		poolOfAvailableConnections.clear();
	}

	private void closeConnection(final Connection connection) {
		try {
			if (!connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public synchronized int size() {
		return poolOfAvailableConnections.size();
	}
}