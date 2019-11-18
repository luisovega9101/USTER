package com.framework.uster.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.postgresql.ds.PGPoolingDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.framework.uster.entity.ConnectionDB;

public class CConnection {
	
	public Connection getConnection() {
		PGPoolingDataSource ds = null;
		Connection connect = null;
		try {
			ds = new PGPoolingDataSource();
			ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Datasource.xml");
			ConnectionDB cbd = (ConnectionDB) context.getBean("servicioPropiedades");
			ds.setServerName(cbd.getServername());
			ds.setPortNumber(cbd.getPort());
			ds.setDatabaseName(cbd.getDatabasename());
			ds.setUser(cbd.getUser());
			ds.setPassword(cbd.getPassword());
			connect = ds.getConnection();
		} catch (SQLException e) {
			System.out.println(e.toString());			
		}
		return connect;
	}
}
