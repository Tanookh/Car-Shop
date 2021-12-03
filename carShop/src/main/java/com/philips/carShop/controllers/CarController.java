package com.philips.carShop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.philips.carShop.BL.CarsBL;
import com.philips.carShop.beans.Car;

@RestController
@RequestMapping("cars")
public class CarController {
	
	@Autowired
	CarsBL carsBL;
	
	@Autowired
	RestTemplate httpClient;
	
	@PostMapping("add")
	public ResponseEntity<Void> addCar(String type, String color, int kilometer, int yearOfProd, int owners, double price)
	{
		Car car = new Car();
		car.setType(type);
		car.setColor(color);
		car.setKilometer(kilometer);
		car.setYearOfProd(yearOfProd);
		car.setOwners(owners);
		car.setPrice(price);
		try
		{
			carsBL.addCar(car);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} 
		catch (Exception e) 
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping("get")
	public ResponseEntity<List<Car>> getAll()
	{
		return new ResponseEntity<List<Car>>(carsBL.getAllCars(), HttpStatus.OK);		
	}
	
	@GetMapping("getPrice")
	public ResponseEntity<List<Car>> getPrice(double lowerPrice, double higherPrice)
	{
		return new ResponseEntity<List<Car>>(carsBL.getPriceCars(lowerPrice, higherPrice), HttpStatus.OK);		
	}
	
	@GetMapping("getYear")
	public ResponseEntity<List<Car>> getYear(int lowerYear, int higherYear)
	{
		return new ResponseEntity<List<Car>>(carsBL.getYearCars(lowerYear, higherYear), HttpStatus.OK);		
	}
	
	@GetMapping("getKilometer")
	public ResponseEntity<List<Car>> getKilometer(double lowerKilometer, double higherKilometer)
	{
		return new ResponseEntity<List<Car>>(carsBL.getKilometerCars(lowerKilometer, higherKilometer), HttpStatus.OK);		
	}
	
	@GetMapping("getColor")
	public ResponseEntity<List<Car>> getColor(String color)
	{
		return new ResponseEntity<List<Car>>(carsBL.getColor(color), HttpStatus.OK);		
	}
	
	@GetMapping("getOwners")
	public ResponseEntity<List<Car>> getOwners(int owners)
	{
		return new ResponseEntity<List<Car>>(carsBL.getOwners(owners), HttpStatus.OK);		
	}

}
