package com.framework.uster.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.framework.uster.dao.TripDAOImpl;

@Controller
public class TripController {
	
	private TripDAOImpl tripDAO = new TripDAOImpl();
	private String[] value; // time, vehi_selec, driv_selec, vehi_disable, driv_disable, button_disable
	private String[][] vehicles;
	private String[][] drivers;
	String select_element;
	
	@RequestMapping(value = "/list_trip", method = RequestMethod.GET)
	public String list_trip(ModelMap model, HttpServletRequest request) {
		if(request.getParameterMap().containsKey("list_element")) {
			select_element = request.getParameter("list_element"); 
		}
		else {
			select_element = "list_made";
		}
		
		String[][] trips_list = null;
		if(select_element.equals("list_made")) {
			trips_list = tripDAO.getTripsMade();
		}
		else if(select_element.equals("list_make")) {
			trips_list = tripDAO.getTripsBeMade();
		}
		model.addAttribute("select_element", select_element);
		model.addAttribute("trips_list", trips_list);
		return "list_trips_tiles";
	}
	
	@RequestMapping(value = "/add_trip", method = RequestMethod.GET)
	public String add_trip(ModelMap model) {
		value = new String[6];
		value[0]=""; value[1]="0"; value[2]="0"; 
		value[3]="disabled"; value[4]="disabled"; value[5]="disabled";
				
		model.addAttribute("vehicles", null);
		model.addAttribute("drivers", null);
		model.addAttribute("value", value);
		return "add_trip_tiles";
	}
	
	@RequestMapping(value = "/select_date", method = RequestMethod.GET)
	public String add_trip_select_date(ModelMap model, HttpServletRequest request) {
		value[0]=request.getParameter("datefield"); 
		value[1]="0"; value[2]="0"; 
		value[4]="disabled"; value[5]="disabled";
		
		vehicles = tripDAO.getVehiclePhase2(value[0]);
		if(vehicles != null)
			value[3]="";
		else
			value[3]="disabled";
		
		model.addAttribute("vehicles", vehicles);
		model.addAttribute("drivers", null);
		model.addAttribute("value", value);
		return "add_trip_tiles";
	}
	
	@RequestMapping(value = "/select_vehicle", method = RequestMethod.GET)
	public String add_trip_select_vehicle(ModelMap model, HttpServletRequest request) {
		value[1]=request.getParameter("vehicle_select"); 
		value[2]="0"; value[5]="disabled";
		
		drivers = tripDAO.getDriverPhase3(value[0], value[1]);
		if(drivers != null)
			value[4]="";
		else
			value[4]="disabled";

		model.addAttribute("vehicles", vehicles);
		model.addAttribute("drivers", drivers);
		model.addAttribute("value", value);
		return "add_trip_tiles";
	}
	
	@RequestMapping(value = "/select_driver", method = RequestMethod.GET)
	public String add_trip_select_driver(ModelMap model, HttpServletRequest request) {
		value[2]=request.getParameter("driver_select");
		if(value[2].equals("0"))
			value[5]="disabled";
		else
			value[5]="";
		
		model.addAttribute("vehicles", vehicles);
		model.addAttribute("drivers", drivers);
		model.addAttribute("value", value);
		return "add_trip_tiles";
	}
	
	@RequestMapping(value = "/add_trip", method = RequestMethod.POST)
	public String add_trip(ModelMap model, HttpServletRequest request) {
		tripDAO.insertTrip(value[1], value[2], value[0]);
		String[][] tripsMade = tripDAO.getTripsMade();
		String[][] tripsBeMade = tripDAO.getTripsBeMade();
		model.addAttribute("tripsMade", tripsMade);
		model.addAttribute("tripsBeMade", tripsBeMade);
		return "list_trips_tiles";
	}

}
