package com.wuye.dao;

import java.util.Date;
import java.util.List;

import com.wuye.model.User;

public interface IUserDAO {
	public abstract void save(User transientInstance);

	public abstract void delete(User persistentInstance);

	public abstract User findById(java.lang.Integer id);

	public abstract List findByExample(User instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);
	
	public abstract List findByUserName(Object userName);

	public abstract List findByPassword(Object password);

	public abstract List findByPhone(Object phone);

	public abstract List findByMial(Object mial);

	public abstract List findByHouseId(Object houseId);

	public abstract List findByDescription(Object description);

	public abstract List findAll();

	public abstract User merge(User detachedInstance);

	public abstract void attachDirty(User instance);

	public abstract void attachClean(User instance);

	/**
	 * 按参数查询用户
	 * 
	 * @param name
	 * @param houseId
	 * @param startDate
	 * @param endDate
	 * @param start
	 * @param size
	 * @return
	 */
	public abstract List findByParam(String name, Integer houseId,
			Date startDate, Date endDate, int start, int size);
	/**
	 * 按参数查询用户总记录数
	 * @param name
	 * @param houseId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public abstract int findByCount(String name, Integer houseId,
			Date startDate, Date endDate);
}
