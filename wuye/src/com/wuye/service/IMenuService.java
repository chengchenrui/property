package com.wuye.service;

import java.util.List;

import com.wuye.model.Menu;

public interface IMenuService {
	public abstract void save(Menu transientInstance);

	public abstract void delete(Menu persistentInstance);

	public abstract Menu findById(java.lang.String id);

	public abstract List findByExample(Menu instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByMName(Object MName);

	public abstract List findByParentId(Object parentId);

	public abstract List findByUrl(Object url);

	public abstract List findBySortNum(Object sortNum);

	public abstract List findAll();

	public abstract Menu merge(Menu detachedInstance);

	public abstract void attachDirty(Menu instance);

	public abstract void attachClean(Menu instance);
	
	/**
	 * 按类型查询菜单
	 * @param type
	 * @return
	 */
	public abstract List findByType(String type);

}
