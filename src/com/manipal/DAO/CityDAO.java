package com.manipal.DAO;

import java.util.List;

import com.manipal.model.City;

public interface CityDAO 
{
	public List<City> retrieveActiveCityList();
	
	public List<City> retrieveCityList();
	
	public City retrieveCity(String cityId);
	
	public City retrieveCityByName(String cityName);
	
	public String doEditCity(String cityId,City updatedCity);
	
	public String doAddCity(City city);
	
	public String doDeleteCity(String cityId);
	
	public String doActiveCity(String cityId);

}
