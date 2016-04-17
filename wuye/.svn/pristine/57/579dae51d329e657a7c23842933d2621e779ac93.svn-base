package com.wuye.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.wuye.dao.IMenuDAO;
import com.wuye.model.Menu;
import com.wuye.service.IMenuService;

public class MenuService implements IMenuService {

	private static final Logger logger = Logger.getLogger(MenuService.class);
	
	private IMenuDAO menuDAO;

	public IMenuDAO getMenuDAO() {
		return menuDAO;
	}

	public void setMenuDAO(IMenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}

	public void attachClean(Menu instance) {
		// TODO Auto-generated method stub
		menuDAO.attachClean(instance);
	}

	public void attachDirty(Menu instance) {
		// TODO Auto-generated method stub
		menuDAO.attachDirty(instance);
	}

	public void delete(Menu persistentInstance) {
		// TODO Auto-generated method stub
		menuDAO.delete(persistentInstance);
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return menuDAO.findAll();
	}

	public List findByExample(Menu instance) {
		// TODO Auto-generated method stub
		return menuDAO.findByExample(instance);
	}

	public Menu findById(String id) {
		// TODO Auto-generated method stub
		return menuDAO.findById(id);
	}

	public List findByMName(Object MName) {
		// TODO Auto-generated method stub
		return menuDAO.findByMName(MName);
	}

	public List findByParentId(Object parentId) {
		// TODO Auto-generated method stub
		return menuDAO.findByParentId(parentId);
	}

	public List findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return menuDAO.findByProperty(propertyName, value);
	}

	public List findBySortNum(Object sortNum) {
		// TODO Auto-generated method stub
		return menuDAO.findBySortNum(sortNum);
	}

	public List findByUrl(Object url) {
		// TODO Auto-generated method stub
		return menuDAO.findByUrl(url);
	}

	public Menu merge(Menu detachedInstance) {
		// TODO Auto-generated method stub
		return menuDAO.merge(detachedInstance);
	}

	public void save(Menu transientInstance) {
		// TODO Auto-generated method stub
		menuDAO.save(transientInstance);
	}

	public List findByType(String type) {
		// TODO Auto-generated method stub
		return menuDAO.findByType(type);
	}

}
