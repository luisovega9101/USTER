package com.framework.uster.service;

import com.framework.uster.entity.Drivers;
import com.framework.uster.entity.Vehicles;

public class ServiceImpl {
	
	public void cleanDriver(Drivers d) {
		d.setName(d.getName().trim());
		d.setSurname(d.getSurname().trim());
		d.setLicense(d.getLicense().trim());
	}
	
	public void cleanVehicle(Vehicles v) {
		v.setBrand(v.getBrand().trim());
		v.setModel(v.getModel().trim());
		v.setPlate(v.getPlate().trim());
		v.setLicenseRequired(v.getLicenseRequired().trim());
	}
	
	public boolean validateCharacters(String str, String strInv) {
		for (int i = 0; i < str.length(); i++)
			if (strInv.indexOf(str.charAt(i)) >= 0)
				return false;
		return true;
	}

}
