package com.airetok.findgiph.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.airetok.findgiph.entity.UserGif;
import com.airetok.findgiph.services.GiphUserRepository;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, UserGif> {
	
	@Autowired
	private GiphUserRepository giphUserRepository;

	@Override
	public boolean isValid(UserGif value, ConstraintValidatorContext context) {
		try {
		UserGif userGif = giphUserRepository.findByUsername(value.getUsername());
		System.out.println(userGif.getUsername());
		} catch(NullPointerException e) {
			return true;
		}
		return false;
	}
}
