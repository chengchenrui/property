package com.wuye.dao.impl;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wuye.dao.IPermissionsDAO;
import com.wuye.model.Permissions;

/**
 * A data access object (DAO) providing persistence and search support for
 * Permissions entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.wuye.model.Permissions
 * @author MyEclipse Persistence Tools
 */

public class PermissionsDAO extends HibernateDaoSupport implements IPermissionsDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PermissionsDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String URL = "url";
	public static final String SORT_NUM = "sortNum";

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * @see com.wuye.dao.IPermissionsDAO#save(com.wuye.model.Permissions)
	 */
	public void save(Permissions transientInstance) {
		log.debug("saving Permissions instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.wuye.dao.IPermissionsDAO#delete(com.wuye.model.Permissions)
	 */
	public void delete(Permissions persistentInstance) {
		log.debug("deleting Permissions instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.wuye.dao.IPermissionsDAO#findById(java.lang.Integer)
	 */
	public Permissions findById(java.lang.Integer id) {
		log.debug("getting Permissions instance with id: " + id);
		try {
			Permissions instance = (Permissions) getHibernateTemplate().get(
					"com.wuye.model.Permissions", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.wuye.dao.IPermissionsDAO#findByExample(com.wuye.model.Permissions)
	 */
	public List findByExample(Permissions instance) {
		log.debug("finding Permissions instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.wuye.dao.IPermissionsDAO#findByProperty(java.lang.String, java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Permissions instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Permissions as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.wuye.dao.IPermissionsDAO#findByName(java.lang.Object)
	 */
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/*
	 * (non-Javadoc)
	 * @see com.wuye.dao.IPermissionsDAO#findByUrl(java.lang.Object)
	 */
	public List findByUrl(Object url) {
		return findByProperty(URL, url);
	}

	/*
	 * (non-Javadoc)
	 * @see com.wuye.dao.IPermissionsDAO#findBySortNum(java.lang.Object)
	 */
	public List findBySortNum(Object sortNum) {
		return findByProperty(SORT_NUM, sortNum);
	}

	/*
	 * (non-Javadoc)
	 * @see com.wuye.dao.IPermissionsDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all Permissions instances");
		try {
			String queryString = "from Permissions";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.wuye.dao.IPermissionsDAO#merge(com.wuye.model.Permissions)
	 */
	public Permissions merge(Permissions detachedInstance) {
		log.debug("merging Permissions instance");
		try {
			Permissions result = (Permissions) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.wuye.dao.IPermissionsDAO#attachDirty(com.wuye.model.Permissions)
	 */
	public void attachDirty(Permissions instance) {
		log.debug("attaching dirty Permissions instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.wuye.dao.IPermissionsDAO#attachClean(com.wuye.model.Permissions)
	 */
	public void attachClean(Permissions instance) {
		log.debug("attaching clean Permissions instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PermissionsDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (PermissionsDAO) ctx.getBean("PermissionsDAO");
	}
}