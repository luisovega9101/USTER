package com.framework.uster.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.framework.uster.dao.VehiclesDAOImpl;
import com.framework.uster.entity.Vehicles;
import com.framework.uster.service.ServiceImpl;
import com.framework.uster.validator.VehicleValidator;

@Controller
public class VehiclesController {
	
	private VehiclesDAOImpl vehicleDAO = new VehiclesDAOImpl();
	private VehicleValidator validator = new VehicleValidator();
	private ServiceImpl service = new ServiceImpl();
	private int id;
	
	@RequestMapping(value = "/list_vehicle", method = RequestMethod.GET)
	public String list_vehicle(ModelMap model) {
		ArrayList<Vehicles> Avehicles = vehicleDAO.getVehicles();
		model.addAttribute("Avehicles", Avehicles);
		return "list_vehicle_tiles";
	}
	
	@RequestMapping(value = "/add_vehicle", method = RequestMethod.GET)
	public String add_vehicle(ModelMap model) {
		model.addAttribute("exist", false);
		model.addAttribute("vehicles", new Vehicles());
		return "add_vehicle_tiles";
	}
	
	@RequestMapping(value = "/add_vehicle", method = RequestMethod.POST)
	public String add_vehicle(ModelMap model, @ModelAttribute("vehicles") Vehicles vehicles, BindingResult result) {
		service.cleanVehicle(vehicles);
		validator.validate(vehicles, result);
		if (result.hasErrors()) {
			model.addAttribute("exist", false);
			model.addAttribute("vehicles", vehicles);
			return "add_vehicle_tiles";
		}		
		if (vehicleDAO.existVehicle(vehicles)) {
			model.addAttribute("exist", true);
			model.addAttribute("vehicles", vehicles);
			return "add_vehicle_tiles";
		}		
		
		vehicleDAO.insertVehicles(vehicles);		
		ArrayList<Vehicles> Avehicles = vehicleDAO.getVehicles();
		model.addAttribute("Avehicles", Avehicles);
		return "list_vehicle_tiles";
	}

	@RequestMapping(value = "/edit_vehicle", method = RequestMethod.GET)
	public String edit_vehicle(ModelMap model, HttpServletRequest request) {
		id = Integer.parseInt(request.getParameter("id"));
		Vehicles vehicles = vehicleDAO.getVehicleID(id);
		model.addAttribute("exist", false);
		model.addAttribute("vehicles", vehicles);
		return "edit_vehicle_tiles";
	}
	
	@RequestMapping(value = "/edit_vehicle", method = RequestMethod.POST)
	public String edit_vehicle(ModelMap model, @ModelAttribute("vehicles") Vehicles vehicles, BindingResult result) {
		service.cleanVehicle(vehicles);
		validator.validate(vehicles, result);
		if (result.hasErrors()) {
			model.addAttribute("exist", false);
			model.addAttribute("vehicles", vehicles);
			return "edit_vehicle_tiles";
		}		
		if (vehicleDAO.existVehicle(vehicles,id)) {
			model.addAttribute("exist", true);
			model.addAttribute("vehicles", vehicles);
			return "edit_vehicle_tiles";
		}
		
		vehicleDAO.updateVehicles(vehicles, id);		
		ArrayList<Vehicles> Avehicles = vehicleDAO.getVehicles();
		model.addAttribute("Avehicles", Avehicles);
		return "list_vehicle_tiles";
	}
	
	@RequestMapping(value = "/delete_vehicle", method = RequestMethod.GET)
	public String delete_vehicle(ModelMap model, HttpServletRequest request) {
		id = Integer.parseInt(request.getParameter("id"));
		vehicleDAO.deleteVehicles(id);
		ArrayList<Vehicles> Avehicles = vehicleDAO.getVehicles();
		model.addAttribute("Avehicles", Avehicles);
		return "list_vehicle_tiles";
	}
}
