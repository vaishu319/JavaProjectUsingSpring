package com.app.student.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<NameStarts, String> {

	@Override
	public void initialize(NameStarts arg0) {
		
		
	}

	@Override
	public boolean isValid(String firstName, ConstraintValidatorContext arg1) {
	
		return firstName.startsWith("Admin");
	}



}
