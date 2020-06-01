package com.cg.inventorymanagementsystem.service;

import java.util.List;

import com.cg.inventorymanagementsystem.exceptions.IMSException;
import com.cg.inventorymanagementsystem.model.Manufacturer;
import com.cg.inventorymanagementsystem.model.Suppliers;

public interface IManufacturerService {
	
	public boolean validateName(String name) throws IMSException;
	
	public boolean validateCost(double salary)throws IMSException;
	
	public int addOrders(Manufacturer order)throws IMSException;
	
	public boolean validateUnits(int units) throws IMSException;
	
	public List<Manufacturer> getAllOrders() throws IMSException;
	
	public List<Suppliers> showSupplierDetails() throws IMSException;

	public boolean validateId(int id) throws IMSException;
	
	public boolean updateOrders(int order) throws IMSException;

	//public  boolean isNumber(String num)throws IMSException;
		
	


	

}
