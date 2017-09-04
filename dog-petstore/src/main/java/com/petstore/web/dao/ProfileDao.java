package com.petstore.web.dao;

import java.util.List;

import com.petstore.web.controller.model.DogProfileEntity;

public interface ProfileDao {

	public String addProfile(DogProfileEntity dogProfileEntity);

	public List<DogProfileEntity> showProfiles();

	public byte[] findDogImageByDid(long did);

	public DogProfileEntity findDogByDid(long did);

	public String deleteDogByEmail(String email);
}
