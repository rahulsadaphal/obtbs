package com.manipal.model;

public class City 
{
	private String cityId;
	private String cityName;
	private String cityState;
	private String status;
	
	public City(){}
	
	
	public City(String cityName, String cityState, String status) {
		super();
		this.cityName = cityName;
		this.cityState = cityState;
		this.status = status;
	}


	public City(String cityId, String cityName, String cityState, String status) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
		this.cityState = cityState;
		this.status = status;
	}

	public City(String cityName, String cityState) {
		super();
		this.cityName = cityName;
		this.cityState = cityState;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityState() {
		return cityState;
	}
	public void setCityState(String cityState) {
		this.cityState = cityState;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	
	
	
	
	

}
