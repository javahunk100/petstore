	package com.petstore.web.controller.model;
	
	import java.sql.Timestamp;
	import java.util.Arrays;

import javax.xml.bind.annotation.XmlRootElement;
	
	@XmlRootElement // we need this annotation for XML response
	public class DogProfileEntity {
		private long did;
		private String name;
		private String email;
		private String breed;
		private String color;
		private double price;
		private String description;
		private byte[] photo;
		private Timestamp doe;
	
		
		public String getDescription() {
			return description;
		}
	
		public void setDescription(String description) {
			this.description = description;
		}
	
		public long getDid() {
			return did;
		}
	
		public void setDid(long did) {
			this.did = did;
		}
	
		public String getName() {
			return name;
		}
	
		public void setName(String name) {
			this.name = name;
		}
	
		public String getEmail() {
			return email;
		}
	
		public void setEmail(String email) {
			this.email = email;
		}
	
		public String getBreed() {
			return breed;
		}
	
		public void setBreed(String breed) {
			this.breed = breed;
		}
	
		public String getColor() {
			return color;
		}
	
		public void setColor(String color) {
			this.color = color;
		}
	
		public double getPrice() {
			return price;
		}
	
		public void setPrice(double price) {
			this.price = price;
		}
	
		public byte[] getPhoto() {
			return photo;
		}
	
		public void setPhoto(byte[] photo) {
			this.photo = photo;
		}
	
		public Timestamp getDoe() {
			return doe;
		}
	
		public void setDoe(Timestamp doe) {
			this.doe = doe;
		}
	
		@Override
		public String toString() {
			return "DogProfileEntity [did=" + did + ", name=" + name + ", email=" + email + ", breed=" + breed + ", color="
					+ color + ", price=" + price + ", description=" + description + ", photo=" + Arrays.toString(photo)
					+ ", doe=" + doe + "]";
		}
	
		
	}
