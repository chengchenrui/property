package com.wuye.service;

import java.util.Date;
import java.util.List;

import com.wuye.model.Car;

public interface ICarService {
	public abstract void save(Car transientInstance);

	public abstract void delete(Car persistentInstance);

	public abstract Car findById(java.lang.Integer id);

	public abstract List findByExample(Car instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByLocation(Object location);

	public abstract List findByCarNum(Object carNum);

	public abstract List findByState(Object state);

	public abstract List findByUserId(Object userId);

	public abstract List findByDescription(Object description);

	public abstract List findAll();

	public abstract Car merge(Car detachedInstance);

	public abstract void attachDirty(Car instance);

	public abstract void attachClean(Car instance);
	/**
	 * 按参数查询
	 * @param location
	 * @param carNum
	 * @param state
	 * @param startDate
	 * @param endDate
	 * @param start
	 * @param size
	 * @return
	 */
	public abstract List findByPrama(String location, String carNum, int state,
			Date startDate, Date endDate, int start, int size);
	/**
	 * 按参数查询总计录数
	 * @param location
	 * @param carNum
	 * @param state
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public abstract int findByCount(String location, String carNum, int state,
			Date startDate, Date endDate);
}
