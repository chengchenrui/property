package com.wuye.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wuye.dao.IMenuDAO;
import com.wuye.model.Menu;

/**
 * A data access object (DAO) providing persistence and search support for Menu
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.wuye.model.Menu
 * @author MyEclipse Persistence Tools
 */

public class MenuDAO extends HibernateDaoSupport implements IMenuDAO {
	private static final Logger log = Logger.getLogger(MenuDAO.class);
	// property constants
	public static final String _MNAME = "MName";
	public static final String PARENT_ID = "parentId";
	public static final String URL = "url";
	public static final String SORT_NUM = "sortNum";

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wuye.dao.IMeunDAO#save(com.wuye.model.Menu)
	 */
	public void save(Menu transientInstance) {
		log.debug("saving Menu instance");
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
	 * 
	 * @see com.wuye.dao.IMeunDAO#delete(com.wuye.model.Menu)
	 */
	public void delete(Menu persistentInstance) {
		log.debug("deleting Menu instance");
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
	 * 
	 * @see com.wuye.dao.IMeunDAO#findById(java.lang.String)
	 */
	public Menu findById(java.lang.String id) {
		log.debug("getting Menu instance with id: " + id);
		try {
			Menu instance = (Menu) getHibernateTemplate().get(
					"com.wuye.model.Menu", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wuye.dao.IMeunDAO#findByExample(com.wuye.model.Menu)
	 */
	public List findByExample(Menu instance) {
		log.debug("finding Menu instance by example");
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
	 * 
	 * @see com.wuye.dao.IMeunDAO#findByProperty(java.lang.String,
	 * java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Menu instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Menu as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wuye.dao.IMeunDAO#findByMName(java.lang.Object)
	 */
	public List findByMName(Object MName) {
		return findByProperty(_MNAME, MName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wuye.dao.IMeunDAO#findByParentId(java.lang.Object)
	 */
	public List findByParentId(Object parentId) {
		return findByProperty(PARENT_ID, parentId);
	}

	public List findByUrl(Object url) {
		return findByProperty(URL, url);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wuye.dao.IMeunDAO#findBySortNum(java.lang.Object)
	 */
	public List findBySortNum(Object sortNum) {
		return findByProperty(SORT_NUM, sortNum);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wuye.dao.IMeunDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all Menu instances");
		try {
			String queryString = "from Menu";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wuye.dao.IMeunDAO#merge(com.wuye.model.Menu)
	 */
	public Menu merge(Menu detachedInstance) {
		log.debug("merging Menu instance");
		try {
			Menu result = (Menu) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wuye.dao.IMeunDAO#attachDirty(com.wuye.model.Menu)
	 */
	public void attachDirty(Menu instance) {
		log.debug("attaching dirty Menu instance");
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
	 * 
	 * @see com.wuye.dao.IMeunDAO#attachClean(com.wuye.model.Menu)
	 */
	public void attachClean(Menu instance) {
		log.debug("attaching clean Menu instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MenuDAO getFromApplicationContext(ApplicationContext ctx) {
		return (MenuDAO) ctx.getBean("MenuDAO");
	}

	/**
	 * 按类型查询菜单
	 */
	public List findByType(String type) {
		// TODO Auto-generated method stub
		List list = null;
		try {
			String queryHQL = "from Menu m where m.type =:type order by sortNum asc";
			Query query = getHibernateTemplate().getSessionFactory()
					.getCurrentSession().createQuery(queryHQL);
			query.setParameter("type", type);
			list = query.list();
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("按类型查询菜单失败", e);
		}
		return list;
	}
}