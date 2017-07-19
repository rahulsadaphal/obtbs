package com.manipal.service.impl;

import java.util.List;

import com.manipal.DAO.DriverDAO;
import com.manipal.DAO.jdbc.DriverDAOImpl;
import com.manipal.model.Bus;
import com.manipal.model.Driver;
import com.manipal.service.DriverService;

public class DriverServiceImpl implements DriverService
{
	DriverDAO driverDAO;
	
	public DriverServiceImpl() {
		driverDAO = new DriverDAOImpl();
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public List<Driver> retrieveActiveDriverList() {
		// TODO Auto-generated method stub
		return driverDAO.retrieveActiveDriverList();
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public List<Driver> retrieveDriverList() {
		// TODO Auto-generated method stub
		return driverDAO.retrieveDriverList();
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public List<Driver> retrieveAvailableDriverList() {
		// TODO Auto-generated method stub
		return driverDAO.retrieveAvailableDriverList();
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public Driver retrieveDriver(String driverId) {
		// TODO Auto-generated method stub
		return driverDAO.retrieveDriver(driverId);
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public String doEditDriver(String driverId, Driver updatedDriver) {
		List<Driver> driverList = retrieveDriverList();
		for (Driver dbDriver : driverList) 
		{
			if (!(dbDriver.getDriverId().equals(driverId))) 
			{
				if (updatedDriver.getDriverEmail().equals(
						dbDriver.getDriverEmail())) {
					return "This email address already used";
				} else if (updatedDriver.getDriverContact() == dbDriver
						.getDriverContact()) {
					return "This contact Number already used";
				} else if (updatedDriver.getDriverLicenceNumber().equals(
						dbDriver.getDriverLicenceNumber())) {
					return "This Licence Number already used";
				}
			}
		}
		return driverDAO.doEditDriver(driverId, updatedDriver);
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public String doAddDriver(Driver driver) {
		List<Driver> driverList = retrieveDriverList();
		if (driverList.size() != 0) 
		{
			for (Driver dbDriver : driverList) {
					if (driver.getDriverEmail().equals(
							dbDriver.getDriverEmail())) {
						return "This email address already used";
					} else if (driver.getDriverContact() == dbDriver
							.getDriverContact()) {
						return "This contact Number already used";
					} else if (driver.getDriverLicenceNumber().equals(
							dbDriver.getDriverLicenceNumber())) {
						return "This Licence Number already used";
					}

			}
			return driverDAO.doAddDriver(driver);
		}
		else
		{
			return driverDAO.doAddDriver(driver);
		}
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public String doDeleteDriver(String driverId) {
		int driverVal = new BusServiceImpl().retrieveDriverBus(driverId);
		
		if(driverVal==0)
		{
			return driverDAO.doDeleteDriver(driverId);
		}
		else
		{
			return "is assign to a Bus";
		}
	}
	
	
	@Override
	public String doActiveDriver(String driverId) {
		// TODO Auto-generated method stub
		return driverDAO.doActiveDriver(driverId);
	}

}
