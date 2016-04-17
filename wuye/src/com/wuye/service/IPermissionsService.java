package com.wuye.service;

import java.util.List;

import com.wuye.model.Permissions;

public interface IPermissionsService {
	public abstract void save(Permissions transientInstance);

	public abstract void delete(Permissions persistentInstance);

	public abstract Permissions findById(java.lang.Integer id);

	public abstract List findByExample(Permissions instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findByUrl(Object url);

	public abstract List findBySortNum(Object sortNum);

	public abstract List findAll();

	public abstract Permissions merge(Permissions detachedInstance);

	public abstract void attachDirty(Permissions instance);

	public abstract void attachClean(Permissions instance);

}
