package com.app.student.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PACKAGE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.app.student.validator.NameValidator;

@Retention(RUNTIME)
@Target({ FIELD, PACKAGE })
@Constraint(validatedBy = NameValidator.class)
public @interface  NameStarts {
	
	String message() default "Name Should Start with Admin";
	Class<?> []groups() default {};
	Class<? extends Payload>[] payload() default{};
	
}
