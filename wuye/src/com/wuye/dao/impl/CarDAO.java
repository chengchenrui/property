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

import com.wuye.dao.ICarDAO;
import com.wuye.model.Car;
import com.wuye.util.Tools;

/**
 * A data access object (DAO) providing persistence and search support for Car
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.wuye.model.Car
 * @author MyEclipse Persistence Tools
 */

public class CarDAO extends HibernateDaoSupport implements ICarDAO {
	private static final Logger log = LoggerFactory.getLogger(CarDAO.class);
	// property constants
	public static final String LOCATION = "location";
	public static final String CAR_NUM = "carNum";
	public static final String STATE = "state";
	public static final String USER_ID = "userId";
	public static final String DESCRIPTION = "description";

	protected void initDao() {
		// do nothing
	}

	public void save(Car transientInstance) {
		log.debug("saving Car instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Car persistentInstance) {
		log.debug("deleting Car instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Car findById(java.lang.Integer id) {
		log.debug("getting Car instance with id: " + id);
		try {
			Car instance = (Car) getHibernateTemplate().get(
					"com.wuye.model.Car", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Car instance) {
		log.debug("finding Car instance by example");
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

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Car instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Car as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByLocation(Object location) {
		return findByProperty(LOCATION, location);
	}

	public List findByCarNum(Object carNum) {
		return findByProperty(CAR_NUM, carNum);
	}

	public List findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findAll() {
		log.debug("finding all Car instances");
		try {
			String queryString = "from Car";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Car merge(Car detachedInstance) {
		log.debug("merging Car instance");
		try {
			Car result = (Car) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Car instance) {
		log.debug("attaching dirty Car instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Car instance) {
		log.debug("attaching clean Car instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CarDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CarDAO) ctx.getBean("CarDAO");
	}

	public int findByCount(String location, String carNum, int state,
			Date startDate, Date endDate) {
		List list = new ArrayList();
		int countNum = 0;
		try {
			Session session = this.getHibernateTemplate().getSessionFactory()
					.getCurrentSession();
			String queryHQL = "select count(c.id)"
					+ " from Car c left join c.user u where 1=1";
			if (Tools.isEmptyString(location) == false) {
				queryHQL += " and c.location =:location";
			}
			if (Tools.isEmptyString(carNum) == false) {
				queryHQL += " and c.carNum =:carNum";
			}
			if (state > -1) {
				queryHQL += " and c.state =:state";
			}
			if (startDate != null) {
				queryHQL += " and h.createTime >= :startDate";
			}
			if (endDate != null) {
				queryHQL += " and h.createTime <= :endDate";
			}
			queryHQL += " order by c.id asc";
			Query query = session.createQuery(queryHQL);
			if (Tools.isEmptyString(location) == false) {
				query.setParameter("location", location);
			}
			if (Tools.isEmptyString(carNum) == false) {
				query.setParameter("carNum", carNum);
			}
			if (state > -1) {
				query.setParameter("state", state);
			}
			if (startDate != null) {
				query.setParameter("startDate", startDate);
			}
			if (endDate != null) {
				query.setParameter("endDate", endDate);
			}

			list = query.list();
		} catch (Exception e) {
			log.error("按参数查询总记录数出错，原因:", e);
		}
		if (list != null && list.size() > 0) {
			countNum = Integer.parseInt(list.get(0).toString());
		}
		return countNum;
	}

	public List findByPrama(String location, String carNum, int state,
			Date startDate, Date endDate, int start, int size) {
		List list = new ArrayList();
		try {
			Session session = this.getHibernateTemplate().getSessionFactory()
					.getCurrentSession();
			String queryHQL = "select c.id,c.location,c.carNum,c.state,u.name,c.createTime"
					+ " from Car c left join c.user u where 1=1";
			if (Tools.isEmptyString(location) == false) {
				queryHQL += " and c.location =:location";
			}
			if (Tools.isEmptyString(carNum) == false) {
				queryHQL += " and c.carNum =:carNum";
			}
			if (state > -1) {
				queryHQL += " and c.state =:state";
			}
			if (startDate != null) {
				queryHQL += " and h.createTime >= :startDate";
			}
			if (endDate != null) {
				queryHQL += " and h.createTime <= :endDate";
			}
			queryHQL += " order by c.id asc";
			Query query = session.createQuery(queryHQL);
			if (Tools.isEmptyString(location) == false) {
				query.setParameter("location", location);
			}
			if (Tools.isEmptyString(carNum) == false) {
				query.setParameter("carNum", carNum);
			}
			if (state > -1) {
				query.setParameter("state", state);
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
			log.error("按参数查询出错，原因:", e);
		}
		return list;
	}
}