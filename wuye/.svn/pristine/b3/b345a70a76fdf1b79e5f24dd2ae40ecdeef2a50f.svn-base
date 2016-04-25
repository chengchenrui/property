package com.wuye.service;

import java.util.Date;
import java.util.List;

import com.wuye.model.House;

public interface IHouseService {
	public abstract void save(House transientInstance);

	public abstract void delete(House persistentInstance);

	public abstract House findById(java.lang.Integer id);

	public abstract List findByExample(House instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByName(Object name);
	
	public abstract List findByHouseNum(Object houseNum);

	public abstract List findByRidgepole(Object ridgepole);

	public abstract List findByFloor(Object floor);

	public abstract List findByNumber(Object number);

	public abstract List findByUserId(Object userId);

	public abstract List findByDescription(Object description);

	public abstract List findAll();

	public abstract House merge(House detachedInstance);

	public abstract void attachDirty(House instance);

	public abstract void attachClean(House instance);
	/**
	 * 按参数查询房间信息
	 * 
	 * @param userName
	 * @param userHouse
	 * @param startDate
	 * @param endDate
	 * @param start
	 * @param size
	 * @return
	 */
	public abstract List findByPrama(String userName, String userHouse,
			Date startDate, Date endDate, int start, int size);

	/**
	 * 按参数查总计录数
	 * 
	 * @param userName
	 * @param userHouse
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public abstract int findCount(String userName, String userHouse,
			Date startDate, Date endDate);
}
