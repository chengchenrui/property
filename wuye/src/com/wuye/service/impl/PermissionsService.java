package com.wuye.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.wuye.dao.IPermissionsDAO;
import com.wuye.model.Permissions;
import com.wuye.service.IPermissionsService;

public class PermissionsService implements IPermissionsService {
	
	private static final Logger logger = Logger.getLogger(PermissionsService.class);
	
	private IPermissionsDAO permissionsDAO;
	
	public IPermissionsDAO getPermissionsDAO() {
		return permissionsDAO;
	}

	public void setPermissionsDAO(IPermissionsDAO permissionsDAO) {
		this.permissionsDAO = permissionsDAO;
	}

	public void attachClean(Permissions instance) {
		// TODO Auto-generated method stub
		permissionsDAO.attachClean(instance);
	}

	public void attachDirty(Permissions instance) {
		// TODO Auto-generated method stub
		permissionsDAO.attachDirty(instance);
	}

	public void delete(Permissions persistentInstance) {
		// TODO Auto-generated method stub
		permissionsDAO.delete(persistentInstance);
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return permissionsDAO.findAll();
	}

	public List findByExample(Permissions instance) {
		// TODO Auto-generated method stub
		return permissionsDAO.findByExample(instance);
	}

	public Permissions findById(Integer id) {
		// TODO Auto-generated method stub
		return permissionsDAO.findById(id);
	}

	public List findByName(Object name) {
		// TODO Auto-generated method stub
		return permissionsDAO.findByName(name);
	}

	public List findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return permissionsDAO.findByProperty(propertyName, value);
	}

	public List findBySortNum(Object sortNum) {
		// TODO Auto-generated method stub
		return permissionsDAO.findBySortNum(sortNum);
	}

	public List findByUrl(Object url) {
		// TODO Auto-generated method stub
		return permissionsDAO.findByUrl(url);
	}

	public Permissions merge(Permissions detachedInstance) {
		// TODO Auto-generated method stub
		return permissionsDAO.merge(detachedInstance);
	}

	public void save(Permissions transientInstance) {
		// TODO Auto-generated method stub
		permissionsDAO.save(transientInstance);
	}
	
}
