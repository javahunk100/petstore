package com.petstore.web.rest.api;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.petstore.web.controller.model.DogProfileEntity;
import com.petstore.web.dao.ProfileDao;
import com.petstore.web.rest.api.exception.PetStoreException;

@Controller
@Scope("request")
@RequestMapping("/v1")
public class FrogStoreRestController {
	
	private ApplicationContext applicationContext;
	
	/**
	 * 
	 */
	public FrogStoreRestController(){
		//Creating spring container which is responsible for creating bean for the
		//dao layer...............................
		applicationContext=new ClassPathXmlApplicationContext("dog-profile-dao.xml");
	}
	
	//Raw data means ...I am talking about XML/JSON
	@RequestMapping(value="/temp/data",method=RequestMethod.GET)
	@ResponseBody public DogProfileEntity  findTestData(){
		DogProfileEntity dogProfileEntity=new DogProfileEntity();
		dogProfileEntity.setBreed("PEOEIE");
		dogProfileEntity.setColor("red");
		dogProfileEntity.setDescription("Rest Web service");
		dogProfileEntity.setDid(1020);
		dogProfileEntity.setEmail("hetyeyey@gmail.com");
		dogProfileEntity.setName("OIEEU");
		dogProfileEntity.setPrice(1222);
		//@ResponseBody == when you return string normally it goes to view resolver
		//now it would not go to that
		return dogProfileEntity;
	}
	
		//Raw data means ...I am talking about XML/JSON
		//http://localhost:7272/dog-petstore/rest/v1/dogdata/100
		@RequestMapping(value="/dogdata/{did}",method=RequestMethod.GET)
		@ResponseBody public  DogProfileEntity frogdataByDid(@PathVariable("did") long did) throws PetStoreException{
			if(did==420){
				PetStoreException exception=new PetStoreException("Sorry this "+did+" is not valid for petstore app.");
				throw exception;
			}
			ProfileDao profileDao=(ProfileDao)applicationContext.getBean("ProfileDaoImpl");
			DogProfileEntity dogProfileEntity=profileDao.findDogByDid(did);
			return dogProfileEntity;
		}
		
		
		@RequestMapping(value="/dogdata",method=RequestMethod.POST)
		@ResponseBody public  ApplicationMessageResponse uploadDog(@RequestBody DogProfileEntity dogProfileEntity){
			ProfileDao profileDao=(ProfileDao)applicationContext.getBean("ProfileDaoImpl");
			profileDao.addProfile(dogProfileEntity);
			ApplicationMessageResponse applicationMessageResponse=new ApplicationMessageResponse();
			applicationMessageResponse.setMessage("Dog is uploaded successfully to the dog petstore");
			return applicationMessageResponse;
		}
		

}
