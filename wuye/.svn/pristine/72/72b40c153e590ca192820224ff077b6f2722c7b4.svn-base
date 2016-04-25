package com.wuye.dao;

import java.util.Date;
import java.util.List;

import com.wuye.model.Managers;

public interface IManagersDAO {

	public abstract void save(Managers transientInstance);

	public abstract void delete(Managers persistentInstance);

	public abstract Managers findById(java.lang.Integer id);

	public abstract List findByExample(Managers instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);

	public abstract List findByUserName(Object userName);

	public abstract List findByPassword(Object password);

	public abstract List findByPhone(Object phone);

	public abstract List findByDescription(Object description);

	public abstract List findAll();

	public abstract Managers merge(Managers detachedInstance);

	public abstract void attachDirty(Managers instance);

	public abstract void attachClean(Managers instance);
	/**
	 * 按参数查询
	 * @param name
	 * @param startDate
	 * @param endDate
	 * @param start
	 * @param size
	 * @return
	 */
	public abstract List findByParam(String name,Date startDate, Date endDate, int start, int size);
	/**
	 * 按参数查询总记录数
	 * @param name
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public abstract int findCount(String name,Date startDate, Date endDate);
}
