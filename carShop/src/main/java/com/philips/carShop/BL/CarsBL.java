package com.philips.carShop.BL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.philips.carShop.beans.Car;
import com.philips.carShop.repositories.CarRepo;

@Service
public class CarsBL {
	
	@Autowired
	CarRepo repo;
	
	@Autowired
	RestTemplate httpClient;
	
	public void addCar(Car car) throws Exception
	{
		repo.save(car);
	}
	
	public List<Car> getAllCars()
	{
		return repo.findAll();
	}
	
	public List<Car> getPriceCars(double lowerPrice, double higherPrice)
	{
		return repo.findByPriceBetween(lowerPrice, higherPrice);
	}
	
	public List<Car> getYearCars(int lowerYear, int higherYear)
	{
		return repo.findByYearOfProdBetween(lowerYear, higherYear);
	}

	public List<Car> getKilometerCars(double lowerKilometer, double higherKilometer) {
		return repo.findByKilometerBetween(lowerKilometer, higherKilometer);
	}

	public List<Car> getColor(String color) {
		return repo.findByColor(color);
	}

	public List<Car> getOwners(int owners) {
		return repo.findByOwners(owners);
	}

}
