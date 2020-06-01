package com.cg.inventorymanagementsystem.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.cg.inventorymanagementsystem.exceptions.IMSException;
import com.cg.inventorymanagementsystem.model.Manufacturer;
import com.cg.inventorymanagementsystem.model.Suppliers;
import com.cg.inventorymanagementsystem.ui.ManufacturerMain;
import com.cg.inventorymanagementsystem.utility.JPAUtility;

public class ManufacturerDao implements IManufacturerDao {

	private Logger logger = Logger.getLogger(ManufacturerDao.class);
	Scanner sc = new Scanner(System.in);
	EntityManagerFactory factory = null;
	EntityManager manager = null;
	EntityTransaction transaction = null;

	@Override
	public int addOrders(Manufacturer order) {

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			int orderId1=0;
			try {
				transaction.begin();
				manager.persist(order);
				System.out.println("Record Inserted Successfully......");
				transaction.commit();
				orderId1=order.getOrderId();
				logger.info("id generated "+orderId1);
				
			} catch (PersistenceException e) {
				System.out.println("order id already present in the list.......");
			}
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		return 0;
	}

	@Override
	public List<Manufacturer> getAllOrders() throws IMSException {
		logger.info("in get all orders method");
		factory = JPAUtility.getEntityManagerFactory();
		logger.info("factory created");
		manager = factory.createEntityManager();
		logger.info("manager created");
		Query query = manager.createQuery(QueryConstants.GET_ORDERS);
		return query.getResultList();
	}

	
	public boolean updateOrders(int orderId) {

		try {
			Manufacturer manufacturer=new Manufacturer();
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();

			try {
				Manufacturer record = manager.find(Manufacturer.class, orderId);
			     record.setOrderId(orderId);
			     transaction.commit();
				System.out.println("Contract Details updated Successfully........");
			} catch (Exception e) {
				System.out.println("Contract id is not present in the list");
			}

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		
		return true;

	}
 

	@Override
	
	public List<Suppliers> showSupplierDetails() throws IMSException {
		logger.info("in get all orders method");
		factory = JPAUtility.getEntityManagerFactory();
		logger.info("factory created");
		manager = factory.createEntityManager();
		logger.info("manager created");
		Query query = manager.createQuery(QueryConstants.GET_SUPPLIERS);
		return query.getResultList();
	}

}
