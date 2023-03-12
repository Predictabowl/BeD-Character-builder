package org.predictabowl.bed.commons.validation;

import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class AutoValidatingInputModel<T> {

	@SuppressWarnings("unchecked")
	protected void validateSelf() {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<T>> violations = validator.validate((T)this);
		if(!violations.isEmpty())
			throw new ConstraintViolationException(violations);
	}
}
