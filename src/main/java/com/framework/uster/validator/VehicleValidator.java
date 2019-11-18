package com.framework.uster.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.framework.uster.entity.Vehicles;
import com.framework.uster.service.ServiceImpl;

public class VehicleValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Vehicles.class.equals( clazz );
	}

	public void validate(Object target, Errors errors) {		
		Vehicles vehiForm = (Vehicles) target;
		ServiceImpl service = new ServiceImpl();
		String strInv = "1234567890!@?¡´{].-|";
		String strInv2 = "!@?¡´{].-|";
		String strInv3 = "!@?¡´{].|";

		if (vehiForm.getBrand() == null || vehiForm.getBrand().isEmpty()) {
			errors.rejectValue("brand", "validator.required");
		} else if(vehiForm.getBrand().length() > 55) {
			errors.rejectValue("brand", "validator.max55");
		} else if(!service.validateCharacters(vehiForm.getBrand(), strInv)) {
			errors.rejectValue("brand", "validator.inv");
		}
		
		if (vehiForm.getModel() == null || vehiForm.getModel().isEmpty()) {
			errors.rejectValue("model", "validator.required");
		} else if(vehiForm.getModel().length() > 55) {
			errors.rejectValue("model", "validator.max55");
		} else if(!service.validateCharacters(vehiForm.getModel(), strInv2)) {
			errors.rejectValue("model", "validator.inv");
		}
		
		if (vehiForm.getPlate() == null || vehiForm.getPlate().isEmpty()) {
			errors.rejectValue("plate", "validator.required");
		} else if(vehiForm.getPlate().length() > 10) {
			errors.rejectValue("plate", "validator.max10");
		} else if(!service.validateCharacters(vehiForm.getPlate(), strInv3)) {
			errors.rejectValue("plate", "validator.inv");
		}
		
		if (vehiForm.getLicenseRequired() == null || vehiForm.getLicenseRequired().isEmpty()) {
			errors.rejectValue("licenseRequired", "validator.required");
		} else if(vehiForm.getLicenseRequired().length() > 1 || 
				!service.validateCharacters(vehiForm.getLicenseRequired(), strInv)) {
			errors.rejectValue("licenseRequired", "validator.max1");
		}
	}
}
