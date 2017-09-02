package com.petstore.web.dao;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;

import com.petstore.web.controller.model.DogProfileEntity;

@Repository("ProfileDaoImpl")
@Scope("singleton")
public class ProfileDaoImpl implements  ProfileDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public String addProfile(DogProfileEntity dogProfileEntity){
		
		String sql="insert into dog_profile_tbl(name,email,breed,color,price,description,doe) values(?,?,?,?,?,?,?)";
		Timestamp doe=new Timestamp(new Date().getTime());
		Object data[]=new Object[]{dogProfileEntity.getName(),dogProfileEntity.getEmail(),dogProfileEntity.getBreed(),
				dogProfileEntity.getColor(),dogProfileEntity.getPrice(),dogProfileEntity.getDescription(),doe};
		jdbcTemplate.update(sql,data);
		return "success";
		
	}
	
	
	@Override
	public List<DogProfileEntity> showProfiles(){
		String sql="select did,name,email,breed,color,price,description,doe from dog_profile_tbl";
		List<DogProfileEntity> dogProfileEntityList=jdbcTemplate.query(sql, new BeanPropertyRowMapper(DogProfileEntity.class));
		return dogProfileEntityList;
	}
	
	@Override
	public byte[] findDogImageByDid(long did){
		  String sql = "select photo from dog_profile_tbl where did="+did;
	        byte[] photo = jdbcTemplate.queryForObject(
	                sql, byte[].class);
	    
		/*String sql="select photo from dog_profile_tbl where did="+did;
		DogProfileEntity dogProfileEntity=(DogProfileEntity)jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(DogProfileEntity.class));
	*/	return photo;
	}


	@Override
	public DogProfileEntity findDogByDid(long did) {
		String sql="select did,name,email,breed,color,price,description,doe from dog_profile_tbl where did="+did;
		DogProfileEntity dogProfileEntity=(DogProfileEntity)jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(DogProfileEntity.class));
		return dogProfileEntity;
	}

}
