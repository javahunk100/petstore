package com.petstore.web.controller;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.petstore.web.controller.model.DogProfileEntity;
import com.petstore.web.dao.ProfileDao;

/**
 * 
 * @author Nagendra
 *
 */
@Controller
public class DogProfileController {
	
	private ApplicationContext applicationContext;
	
	/**
	 * 
	 */
	public DogProfileController(){
		//Creating spring container which is responsible for creating bean for the
		//dao layer...............................
		applicationContext=new ClassPathXmlApplicationContext("dog-profile-dao.xml");
	}
	
	/**
	 * 
	 * @param dogProfileEntity
	 * @param model
	 * @return
	 */
	@RequestMapping(value="uploadDog.do",method=RequestMethod.POST)
	public String uploadProfile(@ModelAttribute DogProfileEntity dogProfileEntity,Model model){
		
		ProfileDao profileDao=(ProfileDao)applicationContext.getBean("ProfileDaoImpl");
		profileDao.addProfile(dogProfileEntity);
		System.out.println("__#)#)#(dogProfileEntity#(#( = "+dogProfileEntity);
		//write logic to save data into the database
		model.addAttribute("message", "Your profile has been uploaded successfully...............");
		return "uploadProfile";
	}

	
	/**
	 * 
	 * @param dogProfileEntity
	 * @param model
	 * @return
	 */
	@RequestMapping(value="showDogProfile.do",method=RequestMethod.GET)
	public String showDogProfiles(Model model){
		
		ProfileDao profileDao=(ProfileDao)applicationContext.getBean("ProfileDaoImpl");
		List<DogProfileEntity> dogProfileList=profileDao.showProfiles();
		System.out.println("__#)#)#(dogProfileEntity#(#( = "+dogProfileList);
		//write logic to save data into the database
		//adding list of the profile..........................
		model.addAttribute("dogProfileList",dogProfileList);
		return "showProfiles";
	}
	
	
	/**
	 *  This is special code to render the image on the UI
	 * @param req
	 * @param resp
	 */
	@RequestMapping(value="findDogImageByDid",method=RequestMethod.GET)
	public void findDogImageByDid(HttpServletRequest req,HttpServletResponse resp) {
		 String did=req.getParameter("did");
		 ProfileDao profileDao=(ProfileDao)applicationContext.getBean("ProfileDaoImpl");
		 byte[] image=profileDao.findDogImageByDid(Long.parseLong(did));
		 //I am going to send image into the response
		 resp.setContentType("image/jpg");
		 try {
		 ServletOutputStream outputStream=resp.getOutputStream();
		 if(image!=null) {
			 outputStream.write(image);
			 outputStream.flush();
		 }
		 }catch(Exception ex){
			 ex.printStackTrace();
		 }
	}
	

	
	
}
