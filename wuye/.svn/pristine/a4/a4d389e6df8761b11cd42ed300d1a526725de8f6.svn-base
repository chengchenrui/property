package com.wuye.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.wuye.dao.IHouseDAO;
import com.wuye.model.House;
import com.wuye.service.IHouseService;

public class HouseService implements IHouseService {
	
	private static final Logger logger = Logger.getLogger(HouseService.class);
	
	private IHouseDAO houseDAO;
	
	public IHouseDAO getHouseDAO() {
		return houseDAO;
	}

	public void setHouseDAO(IHouseDAO houseDAO) {
		this.houseDAO = houseDAO;
	}

	public void attachClean(House instance) {
		// TODO Auto-generated method stub
		houseDAO.attachClean(instance);
	}

	public void attachDirty(House instance) {
		// TODO Auto-generated method stub
		houseDAO.attachDirty(instance);
	}

	public void delete(House persistentInstance) {
		// TODO Auto-generated method stub
		houseDAO.delete(persistentInstance);
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return houseDAO.findAll();
	}

	public List findByBuild(Object build) {
		// TODO Auto-generated method stub
		return houseDAO.findByBuild(build);
	}

	public List findByDescription(Object description) {
		// TODO Auto-generated method stub
		return houseDAO.findByDescription(description);
	}

	public List findByDoor(Object door) {
		// TODO Auto-generated method stub
		return houseDAO.findByDoor(door);
	}

	public List findByExample(House instance) {
		// TODO Auto-generated method stub
		return houseDAO.findByExample(instance);
	}

	public List findByFloor(Object floor) {
		// TODO Auto-generated method stub
		return houseDAO.findByFloor(floor);
	}

	public House findById(Integer id) {
		// TODO Auto-generated method stub
		return houseDAO.findById(id);
	}

	public List findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return houseDAO.findByProperty(propertyName, value);
	}

	public House merge(House detachedInstance) {
		// TODO Auto-generated method stub
		return houseDAO.merge(detachedInstance);
	}

	public void save(House transientInstance) {
		// TODO Auto-generated method stub
		houseDAO.save(transientInstance);
	}

}
