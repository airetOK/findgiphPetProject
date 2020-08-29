package com.airetok.findgiph.services;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.airetok.findgiph.entity.UserGif;

@Repository
public interface GiphUserRepository extends CrudRepository<UserGif, Integer>{
	
	UserGif findByUsername(String username);
	
}
