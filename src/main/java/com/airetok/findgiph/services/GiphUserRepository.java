package com.airetok.findgiph.services;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.airetok.findgiph.entity.UserGif;

@Repository
public interface GiphUserRepository extends CrudRepository<UserGif, Integer>{
	
	UserGif findByUsername(String username);
	
	@Query( value = "select * from user_gif"
			+ " where extract(DAY from date_of_birth)=extract(DAY from (select current_date())) and"
			+ " extract(MONTH from date_of_birth)=extract(MONTH from (select current_date()))",nativeQuery = true)
	List<UserGif> findAllActiveUsersNative();
	
}
