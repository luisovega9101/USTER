package com.framework.uster.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.framework.uster.dao.DriversDAOImpl;
import com.framework.uster.entity.Drivers;
import com.framework.uster.service.ServiceImpl;
import com.framework.uster.validator.DriverValidator;

@Controller
public class DriversController {
	
	private DriversDAOImpl driversDAO = new DriversDAOImpl();
	private DriverValidator validator = new DriverValidator();
	private ServiceImpl service = new ServiceImpl();
	private int id;
	
	@RequestMapping(value = "/list_driver", method = RequestMethod.GET)
	public String list_driver(ModelMap model) {
		ArrayList<Drivers> Adrivers = driversDAO.getDrivers();
		model.addAttribute("Adrivers", Adrivers);
		return "list_driver_tiles";
	}
	
	@RequestMapping(value = "/add_driver", method = RequestMethod.GET)
	public String add_driver(ModelMap model) {
		model.addAttribute("exist", false);
		Drivers drivers = new Drivers(); 
		model.addAttribute("drivers", drivers);
		return "add_driver_tiles";
	}
	
	@RequestMapping(value = "/add_driver", method = RequestMethod.POST)
	public String add_driver(ModelMap model, @ModelAttribute("drivers") Drivers drivers, BindingResult result) {		
		service.cleanDriver(drivers);
		validator.validate(drivers, result);
		if (result.hasErrors()) {			
			model.addAttribute("exist", false);
			model.addAttribute("drivers", drivers);
			return "add_driver_tiles";
		}
		if (driversDAO.existDriver(drivers)) {
			model.addAttribute("exist", true);
			model.addAttribute("drivers", drivers);
			return "add_driver_tiles";
		}
		
		driversDAO.insertDrivers(drivers);
		ArrayList<Drivers> Adrivers = driversDAO.getDrivers();
		model.addAttribute("Adrivers", Adrivers);
		return "list_driver_tiles";
	}

	@RequestMapping(value = "/edit_driver", method = RequestMethod.GET)
	public String edit_driver(ModelMap model, HttpServletRequest request) {
		id = Integer.parseInt(request.getParameter("id"));
		Drivers drivers = driversDAO.getDriverID(id);
		model.addAttribute("exist", false);
		model.addAttribute("drivers", drivers);
		return "edit_driver_tiles";
	}
	
	@RequestMapping(value = "/edit_driver", method = RequestMethod.POST)
	public String edit_driver(ModelMap model, @ModelAttribute("drivers") Drivers drivers, BindingResult result) {
		service.cleanDriver(drivers);
		validator.validate(drivers, result);
		if (result.hasErrors()) {			
			model.addAttribute("exist", false);
			model.addAttribute("drivers", drivers);
			return "edit_driver_tiles";
		}		
		if (driversDAO.existDriver(drivers, id)) {
			model.addAttribute("exist", true);
			model.addAttribute("drivers", drivers);
			return "edit_driver_tiles";
		}
		
		driversDAO.updateDrivers(drivers, id);		
		ArrayList<Drivers> Adrivers = driversDAO.getDrivers();
		model.addAttribute("Adrivers", Adrivers);
		return "list_driver_tiles";
	}
	
	@RequestMapping(value = "/delete_driver", method = RequestMethod.GET)
	public String delete_driver(ModelMap model, HttpServletRequest request) {
		id = Integer.parseInt(request.getParameter("id"));
		driversDAO.deleteDrivers(id);
		ArrayList<Drivers> Adrivers = driversDAO.getDrivers();
		model.addAttribute("Adrivers", Adrivers);
		return "list_driver_tiles";
	}
}
