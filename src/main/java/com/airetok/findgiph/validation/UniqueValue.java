package com.airetok.findgiph.validation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = UniqueValueValidator.class)
public @interface UniqueValue {
	String message() default "*username already exists";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
