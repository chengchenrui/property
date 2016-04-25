package com.wuye.service.impl;

import java.util.Date;
import java.util.List;

import com.wuye.dao.IManagersDAO;
import com.wuye.model.Managers;
import com.wuye.service.IManagersService;

public class ManagersService implements IManagersService {
	
	private IManagersDAO managersDAO;

	public IManagersDAO getManagersDAO() {
		return managersDAO;
	}

	public void setManagersDAO(IManagersDAO managersDAO) {
		this.managersDAO = managersDAO;
	}

	public void attachClean(Managers instance) {
		// TODO Auto-generated method stub
		managersDAO.attachClean(instance);
	}

	public void attachDirty(Managers instance) {
		// TODO Auto-generated method stub
		managersDAO.attachDirty(instance);
	}

	public void delete(Managers persistentInstance) {
		// TODO Auto-generated method stub
		managersDAO.delete(persistentInstance);
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return managersDAO.findAll();
	}

	public List findByDescription(Object description) {
		// TODO Auto-generated method stub
		return managersDAO.findByDescription(description);
	}

	public List findByExample(Managers instance) {
		// TODO Auto-generated method stub
		return managersDAO.findByExample(instance);
	}

	public Managers findById(Integer id) {
		// TODO Auto-generated method stub
		return managersDAO.findById(id);
	}

	public List findByName(Object name) {
		// TODO Auto-generated method stub
		return managersDAO.findByName(name);
	}

	public List findByPassword(Object password) {
		// TODO Auto-generated method stub
		return managersDAO.findByPassword(password);
	}

	public List findByPhone(Object phone) {
		// TODO Auto-generated method stub
		return managersDAO.findByPhone(phone);
	}

	public List findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return managersDAO.findByProperty(propertyName, value);
	}

	public List findByUserName(Object userName) {
		// TODO Auto-generated method stub
		return managersDAO.findByUserName(userName);
	}

	public Managers merge(Managers detachedInstance) {
		// TODO Auto-generated method stub
		return managersDAO.merge(detachedInstance);
	}

	public void save(Managers transientInstance) {
		// TODO Auto-generated method stub
		managersDAO.save(transientInstance);
	}

	public List findByParam(String name, Date startDate, Date endDate,
			int start, int size) {
		// TODO Auto-generated method stub
		return managersDAO.findByParam(name, startDate, endDate, start, size);
	}

	public int findCount(String name, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return managersDAO.findCount(name, startDate, endDate);
	}

}
