package com.philips.carShop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.philips.carShop.beans.Car;

public interface CarRepo extends JpaRepository<Car, Integer>{
	
	public List<Car> findByType(String type);
	
	public List<Car> findByPriceBetween(double lowerPrice, double higherPrice);
	
	public List<Car> findByYearOfProdBetween(int lowerYear, int higherYear);

	public List<Car> findByKilometerBetween(double lowerKilometer, double higherKilometer);

	public List<Car> findByColor(String color);

	public List<Car> findByOwners(int owners);

}
