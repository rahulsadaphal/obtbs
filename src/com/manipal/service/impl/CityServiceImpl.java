package com.manipal.service.impl;

import java.util.List;

import com.manipal.DAO.CityDAO;
import com.manipal.DAO.jdbc.CityDAOImpl;
import com.manipal.model.Bus;
import com.manipal.model.City;
import com.manipal.service.CityService;

public class CityServiceImpl implements CityService{

	CityDAO cityDAO;
	
	public CityServiceImpl() {
		cityDAO = new CityDAOImpl();
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public List<City> retrieveCityList() {
		// TODO Auto-generated method stub
		return cityDAO.retrieveCityList();
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public List<City> retrieveActiveCityList() {
		// TODO Auto-generated method stub
		return cityDAO.retrieveActiveCityList();
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public City retrieveCity(String cityId) {
		// TODO Auto-generated method stub
		return cityDAO.retrieveCity(cityId);
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public String doEditCity(String cityId, City updatedCity) {
		List<City> cityList = cityDAO.retrieveCityList();
		for (City dbCity : cityList) {
			if (!(dbCity.getCityId().equals(cityId))) {
				if (updatedCity.getCityName().equals(dbCity.getCityName())) {
					return "Cityname already exists";
				}
			}
		}
		return cityDAO.doEditCity(cityId, updatedCity);
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public String doAddCity(City city) {
		List<City> cityList = cityDAO.retrieveCityList();
		if (cityList.size() != 0) 
		{
			for (City dbCity : cityList) 
			{
				if (city.getCityName().equals(dbCity.getCityName())) {
					return "Cityname already exists";
				}
			}
			return cityDAO.doAddCity(city);
		}
		else
		{
			return cityDAO.doAddCity(city);
		}
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public String doDeleteCity(String cityId) {
		List<Bus> cityBusList = new BusServiceImpl().retrieveCityBusList(cityId);
		
		if(cityBusList.size()==0)
		{
			return cityDAO.doDeleteCity(cityId);
		}
		else
		{
			return "has "+ cityBusList.size()+" Buses Operating ";
		}
	}
	@Override
	public String doActiveCity(String cityId) {
		// TODO Auto-generated method stub
		return cityDAO.doActiveCity(cityId);
	}
	
	@Override
	public City retrieveCityByName(String cityName) {
		// TODO Auto-generated method stub
		return cityDAO.retrieveCityByName(cityName);
	}

}
