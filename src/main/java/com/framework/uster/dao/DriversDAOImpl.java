package com.framework.uster.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.framework.uster.entity.Drivers;

public class DriversDAOImpl{

	private CConnection cc = new CConnection();
	private Connection cn = null;
	
	public ArrayList<Drivers> getDrivers() {
		ArrayList<Drivers> drivers = new ArrayList<Drivers>();		
		try {
			String query = "select * from drivers";
			cn = cc.getConnection();
			PreparedStatement ps = cn.prepareStatement(query);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Drivers d = new Drivers();
				d.setId(resultSet.getLong("id"));
				d.setName(resultSet.getString("name"));
				d.setSurname(resultSet.getString("surname"));
				d.setLicense(resultSet.getString("license"));
				drivers.add(d);			
			}
		} catch (Exception error) {
			System.out.println(error.toString());
		} finally {
			try {
				cn.close();
			} catch (SQLException error) {
				System.out.println("Error Connect :" + error.toString());
			}
		}
		return drivers;
	}
	
	public boolean existDriver(Drivers d) {
		boolean exist = false;
		try {			  				
			String query = "Select * from drivers where name='"+d.getName()+"' and surname='"+d.getSurname()
							+"' and license='"+d.getLicense()+"'";
			cn = cc.getConnection();
			PreparedStatement ps = cn.prepareStatement(query);			
			ResultSet resultSet = ps.executeQuery();
			
			if (resultSet.next() == false) {
				exist = false;
			} else {
				exist = true;				
			}
		} catch (Exception error) {
			System.out.println(error.toString());
		} finally {
			try {
				cn.close();
			} catch (SQLException error) {
				System.out.println("Error Connect :" + error.toString());
			}
		}
		return exist;
	}
	
	public boolean existDriver(Drivers d, int id) {
		boolean exist = false;
		try {			  				
			String query = "Select * from drivers where name='"+d.getName()+"' and surname='"+d.getSurname()
							+"' and license='"+d.getLicense()+"' and id !="+id;
			cn = cc.getConnection();
			PreparedStatement ps = cn.prepareStatement(query);			
			ResultSet resultSet = ps.executeQuery();
			
			if (resultSet.next() == false) {
				exist = false;
			} else {
				exist = true;				
			}
		} catch (Exception error) {
			System.out.println(error.toString());
		} finally {
			try {
				cn.close();
			} catch (SQLException error) {
				System.out.println("Error Connect :" + error.toString());
			}
		}
		return exist;
	}

	public void insertDrivers(Drivers d) {
		try {			  				
			String query = "INSERT INTO drivers(name, surname, license)"
					+ " VALUES (?, ?, ?)";
			cn = cc.getConnection();
			PreparedStatement stmt = cn.prepareStatement(query);
			stmt.setString(1,d.getName());
			stmt.setString(2,d.getSurname());
			stmt.setString(3,d.getLicense());
						
			stmt.executeUpdate();
		} catch (Exception error) {
			System.out.println(error.toString());
		} finally {
			try {
				cn.close();
			} catch (SQLException error) {
				System.out.println("Error Connect :" + error.toString());
			}
		}
	}

	public Drivers getDriverID(int id) {
		Drivers d = new Drivers();
		try {
			String query = "select * from drivers where id="+id;
			cn = cc.getConnection();
			PreparedStatement ps = cn.prepareStatement(query);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {				
				d.setId(resultSet.getLong("id"));
				d.setName(resultSet.getString("name"));
				d.setSurname(resultSet.getString("surname"));
				d.setLicense(resultSet.getString("license"));					
			}
		} catch (Exception error) {
			System.out.println(error.toString());
		} finally {
			try {
				cn.close();
			} catch (SQLException error) {
				System.out.println("Error Connect :" + error.toString());
			}
		}
		return d;
	}

	public void updateDrivers(Drivers d, int id) {
		try {			  				
			String query = "UPDATE drivers set name=?, surname=?, license=? Where id="+id;
			cn = cc.getConnection();
			PreparedStatement stmt = cn.prepareStatement(query);
			stmt.setString(1,d.getName());
			stmt.setString(2,d.getSurname());
			stmt.setString(3,d.getLicense());
			
			stmt.executeUpdate();
		} catch (Exception error) {
			System.out.println(error.toString());
		} finally {
			try {
				cn.close();
			} catch (SQLException error) {
				System.out.println("Error Connect :" + error.toString());
			}
		}
	}
	
	public void deleteDrivers(int id) {
		try {			
			String query = "DELETE from trip where driversid="+id;
			cn = cc.getConnection();
			PreparedStatement stmt = cn.prepareStatement(query);			
			stmt.executeUpdate();
			
			query = "DELETE from drivers Where id="+id;
			stmt = cn.prepareStatement(query);			
			stmt.executeUpdate();
		} catch (Exception error) {
			System.out.println(error.toString());
		} finally {
			try {
				cn.close();
			} catch (SQLException error) {
				System.out.println("Error Connect :" + error.toString());
			}
		}
	}
}
