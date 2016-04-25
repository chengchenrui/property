package com.wuye.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wuye.dao.IManagersDAO;
import com.wuye.model.Managers;
import com.wuye.util.Tools;

/**
 * A data access object (DAO) providing persistence and search support for
 * Managers entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.wuye.dao.impl.Managers
 * @author MyEclipse Persistence Tools
 */

public class ManagersDAO extends HibernateDaoSupport implements IManagersDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ManagersDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String USER_NAME = "userName";
	public static final String PASSWORD = "password";
	public static final String PHONE = "phone";
	public static final String DESCRIPTION = "description";

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wuye.dao.IManagersDAO#save(com.wuye.model.Managers)
	 */
	public void save(Managers transientInstance) {
		log.debug("saving Managers instance");
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
	 * @see com.wuye.dao.IManagersDAO#delete(com.wuye.model.Managers)
	 */
	public void delete(Managers persistentInstance) {
		log.debug("deleting Managers instance");
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
	 * @see com.wuye.dao.IManagersDAO#findById(java.lang.Integer)
	 */
	public Managers findById(java.lang.Integer id) {
		log.debug("getting Managers instance with id: " + id);
		try {
			Managers instance = (Managers) getHibernateTemplate().get(
					"com.wuye.model.Managers", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wuye.dao.IManagersDAO#findByExample(com.wuye.model.Managers)
	 */
	public List findByExample(Managers instance) {
		log.debug("finding Managers instance by example");
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
	 * @see com.wuye.dao.IManagersDAO#findByProperty(java.lang.String,
	 * java.lang.Object)
	 */
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Managers instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Managers as model where model."
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
	 * @see com.wuye.dao.IManagersDAO#findByName(java.lang.Object)
	 */
	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wuye.dao.IManagersDAO#findByUserName(java.lang.Object)
	 */
	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wuye.dao.IManagersDAO#findByPassword(java.lang.Object)
	 */
	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wuye.dao.IManagersDAO#findByPhone(java.lang.Object)
	 */
	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wuye.dao.IManagersDAO#findByDescription(java.lang.Object)
	 */
	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wuye.dao.IManagersDAO#findAll()
	 */
	public List findAll() {
		log.debug("finding all Managers instances");
		try {
			String queryString = "from Managers";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wuye.dao.IManagersDAO#merge(com.wuye.model.Managers)
	 */
	public Managers merge(Managers detachedInstance) {
		log.debug("merging Managers instance");
		try {
			Managers result = (Managers) getHibernateTemplate().merge(
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
	 * 
	 * @see com.wuye.dao.IManagersDAO#attachDirty(com.wuye.model.Managers)
	 */
	public void attachDirty(Managers instance) {
		log.debug("attaching dirty Managers instance");
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
	 * @see com.wuye.dao.IManagersDAO#attachClean(com.wuye.model.Managers)
	 */
	public void attachClean(Managers instance) {
		log.debug("attaching clean Managers instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ManagersDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ManagersDAO) ctx.getBean("ManagersDAO");
	}

	/*
	 * 按参数查询(non-Javadoc)
	 * 
	 * @see com.wuye.dao.IManagersDAO#findByParam(java.lang.String,
	 * java.util.Date, java.util.Date, int, int)
	 */
	public List findByParam(String name, Date startDate, Date endDate,
			int start, int size) {
		List list = new ArrayList();
		try {
			Session session = this.getHibernateTemplate().getSessionFactory()
					.getCurrentSession();
			String queryHQL = "from Managers m where 1=1";
			if (Tools.isEmptyString(name) == false) {
				queryHQL += " and m.name like :name";
			}
			if (startDate != null) {
				queryHQL += " and m.createTime >= :startDate";
			}
			if (endDate != null) {
				queryHQL += " and m.createTime <= :endDate";
			}
			queryHQL += " order by m.id asc";

			Query query = session.createQuery(queryHQL);

			if (Tools.isEmptyString(name) == false) {
				query.setParameter("name", "%" + name + "%");
			}
			if (startDate != null) {
				query.setParameter("startDate", startDate);
			}
			if (endDate != null) {
				query.setParameter("endDate", endDate);
			}
			query.setFirstResult(start);
			query.setMaxResults(size);
			list = query.list();
		} catch (Exception e) {
			log.error("按参数查询管理员失败，原因:", e);
		}
		return list;
	}

	public int findCount(String name, Date startDate, Date endDate) {
		int countNum = 0;
		List list = new ArrayList();
		try {
			Session session = this.getHibernateTemplate().getSessionFactory()
					.getCurrentSession();
			String queryHQL = "select count(m.id) from Managers m where 1=1";
			if (Tools.isEmptyString(name) == false) {
				queryHQL += " and m.name like :name";
			}
			if (startDate != null) {
				queryHQL += " and m.createTime >= :startDate";
			}
			if (endDate != null) {
				queryHQL += " and m.createTime <= :endDate";
			}

			Query query = session.createQuery(queryHQL);

			if (Tools.isEmptyString(name) == false) {
				query.setParameter("name", "%" + name + "%");
			}
			if (startDate != null) {
				query.setParameter("startDate", startDate);
			}
			if (endDate != null) {
				query.setParameter("endDate", endDate);
			}
			list = query.list();

		} catch (Exception e) {
			log.error("按参数查询总记录数失败，原因:", e);
		}
		if (list != null && list.size() > 0) {
			countNum = Integer.parseInt(list.get(0).toString());
		}

		return countNum;
	}

}