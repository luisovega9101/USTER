package com.framework.uster.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.framework.uster.entity.Drivers;
import com.framework.uster.entity.Vehicles;

public class TripDAOImpl{

	private CConnection cc = new CConnection();
	private Connection cn = null;
	private DriversDAOImpl driversDAO = new DriversDAOImpl();
	private VehiclesDAOImpl vehicleDAO = new VehiclesDAOImpl();
	
	public String[][] getTripsMade(){
		String[][] trips = null; 
		try {
			String query = "select * from trip where date < current_date order by date DESC";
			cn = cc.getConnection();			
			PreparedStatement ps = cn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//https://stackoverflow.com/questions/6367737/resultset-exception-set-type-is-type-forward-only-why
			ResultSet resultSet = ps.executeQuery();
			
			int rowcount = 0;
			if(resultSet.next()) {				
				resultSet.last();
				rowcount = resultSet.getRow();
				resultSet.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
				trips = new String[rowcount][3]; 
				
				int i = 0;
				while (resultSet.next()) {									
					Vehicles v = vehicleDAO.getVehicleID(resultSet.getInt("vehiclesid"));
					Drivers d = driversDAO.getDriverID(resultSet.getInt("driversid"));
					trips[i][0] = resultSet.getString("date");	
					trips[i][1] = v.toString();
					trips[i][2] = d.toString();
					i++;						
				}								
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
		return trips;
	}
	
	public String[][] getTripsBeMade(){
		String[][] trips = null; 
		try {
			String query = "select * from trip where date >= current_date order by date ASC";
			cn = cc.getConnection();			
			PreparedStatement ps = cn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//https://stackoverflow.com/questions/6367737/resultset-exception-set-type-is-type-forward-only-why
			ResultSet resultSet = ps.executeQuery();
			
			int rowcount = 0;
			if(resultSet.next()) {				
				resultSet.last();
				rowcount = resultSet.getRow();
				resultSet.beforeFirst(); // not rs.first() because the rs.next() below will move on, missing the first element
				trips = new String[rowcount][3]; 
				
				int i = 0;
				while (resultSet.next()) {									
					Vehicles v = vehicleDAO.getVehicleID(resultSet.getInt("vehiclesid"));
					Drivers d = driversDAO.getDriverID(resultSet.getInt("driversid"));
					trips[i][0] = resultSet.getString("date");	
					trips[i][1] = v.toString();
					trips[i][2] = d.toString();
					i++;						
				}								
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
		return trips;
	}
	
	
	public String[][] getVehiclePhase2(String time){
		String[][] vehicles = null;
		try {
			String query = "Select * from trip where date = '"+time+"'";
			cn = cc.getConnection();
			PreparedStatement ps = cn.prepareStatement(query);
			ResultSet resultSet = ps.executeQuery();
			query = "Select * from vehicles";
			if(resultSet.next()) {
				boolean first = true;
				while (resultSet.next()) {
					if(first) {
						query += " where id != " + resultSet.getInt("vehiclesid");
						first = false;
					}
					else {
						query += " AND id != " + resultSet.getInt("vehiclesid");
					}					
				}
			}
			ps = cn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultSet = ps.executeQuery();
			
			int rowcount = 0;
			if(resultSet.next()) {				
				resultSet.last();
				rowcount = resultSet.getRow();
				resultSet.beforeFirst(); 
				vehicles = new String[rowcount+1][2]; 
				
				int i = 0;
				vehicles[i][0]="0";
				vehicles[i][1]="Selecciona...";
				
				while (resultSet.next()) {	
					i++;
					vehicles[i][0]= String.valueOf(resultSet.getInt("id"));
					vehicles[i][1]= resultSet.getString("brand")+" "+resultSet.getString("model")+" ["+resultSet.getString("plate")+"]";
				}								
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
		return vehicles;
	}
	

	public String[][] getDriverPhase3(String time, String v_s){
		String[][] drivers = null;
		try {
			String query = "Select * from vehicles where id = "+v_s;
			cn = cc.getConnection();
			PreparedStatement ps = cn.prepareStatement(query);
			ResultSet resultSet = ps.executeQuery();
			String license = "";
			while (resultSet.next()) {	
				license = resultSet.getString("licenserequired");
			}			
			query = "Select * from trip where date = '"+time+"'";
			ps = cn.prepareStatement(query);
			resultSet = ps.executeQuery();			
			query = "Select * from drivers where license = '"+license+"'";
			if(resultSet.next()) {
				while (resultSet.next()) {
					query+=" AND id != " + resultSet.getInt("driversid");						
				}
			}			
			ps = cn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultSet = ps.executeQuery();			
			int rowcount = 0;
			if(resultSet.next()) {				
				resultSet.last();
				rowcount = resultSet.getRow();
				resultSet.beforeFirst(); 
				drivers = new String[rowcount+1][2]; 
				
				int i = 0;
				drivers[i][0]="0";
				drivers[i][1]="Selecciona...";
				while (resultSet.next()) {	
					i++;
					drivers[i][0]= String.valueOf(resultSet.getInt("id"));
					drivers[i][1]= resultSet.getString("name")+" "+resultSet.getString("surname");
				}								
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
	
	public void insertTrip(String idVehicle, String idDriver, String time) {
		try {			  				
			String query = "INSERT INTO trip(vehiclesid, driversid, date) VALUES (?, ?, ?)";
			cn = cc.getConnection();
			PreparedStatement stmt = cn.prepareStatement(query);
			stmt.setLong(1,Long.parseLong(idVehicle));
			stmt.setLong(2,Long.parseLong(idDriver));
			stmt.setDate(3,Date.valueOf(time));			
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
