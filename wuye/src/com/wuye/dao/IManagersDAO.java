package com.wuye.dao;

import java.util.List;

import com.wuye.model.Managers;

public interface IManagersDAO {

	public void save(Managers transientInstance);

	public void delete(Managers persistentInstance);

	public Managers findById(java.lang.Integer id);

	public List findByExample(Managers instance);

	public List findByProperty(String propertyName, Object value);

	public List findByName(Object name);

	public List findByUserName(Object userName);

	public List findByPassword(Object password);

	public List findByPhone(Object phone);

	public List findByDescription(Object description);

	public List findAll();

	public Managers merge(Managers detachedInstance);

	public void attachDirty(Managers instance);

	public void attachClean(Managers instance);

}
