package com.framework.uster.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.framework.uster.entity.Drivers;
import com.framework.uster.service.ServiceImpl;

public class DriverValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Drivers.class.equals( clazz );
	}

	public void validate(Object target, Errors errors) {
		Drivers drivForm = (Drivers) target;
		ServiceImpl service = new ServiceImpl();
		String strInv = "1234567890!@?¡´{].-|";

		if (drivForm.getName() == null || drivForm.getName().isEmpty()) {
			errors.rejectValue("name", "validator.required");
		} else if(drivForm.getName().length() > 55) {
			errors.rejectValue("name", "validator.max55");
		} else if(!service.validateCharacters(drivForm.getName(), strInv)) {
			errors.rejectValue("name", "validator.inv");
		}
		
		if (drivForm.getSurname() == null || drivForm.getSurname().isEmpty()) {
			errors.rejectValue("surname", "validator.required");
		} else if(drivForm.getSurname().length() > 55) {
			errors.rejectValue("surname", "validator.max55");
		} else if(!service.validateCharacters(drivForm.getSurname(), strInv)) {
			errors.rejectValue("surname", "validator.inv");
		}
		
		if (drivForm.getLicense() == null || drivForm.getLicense().isEmpty()) {
			errors.rejectValue("license", "validator.required");
		} else if(drivForm.getLicense().length() > 1 || 
				!service.validateCharacters(drivForm.getLicense(), strInv)) {
			errors.rejectValue("license", "validator.max1");
		}		
	}
	
}
