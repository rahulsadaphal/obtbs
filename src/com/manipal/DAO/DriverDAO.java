package com.manipal.DAO;

import java.util.List;

import com.manipal.model.Driver;

public interface DriverDAO 
{
	public List<Driver> retrieveActiveDriverList();
	
	public List<Driver> retrieveDriverList();
	
	public List<Driver> retrieveAvailableDriverList();
	
	public String doActiveDriver(String driverId);
	
	public Driver retrieveDriver(String driverId);
	
	public String doEditDriver(String driverId,Driver updatedDriver);
	
	public String doAddDriver(Driver driver);
	
	public String doDeleteDriver(String driverId);

}
