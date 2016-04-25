package com.wuye.dao.impl;

import java.sql.Timestamp;
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

import com.wuye.dao.IHouseDAO;
import com.wuye.model.House;
import com.wuye.util.Tools;

/**
 * A data access object (DAO) providing persistence and search support for House
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.wuye.model.House
 * @author MyEclipse Persistence Tools
 */

public class HouseDAO extends HibernateDaoSupport implements IHouseDAO {
	private static final Logger log = LoggerFactory.getLogger(HouseDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String HOUSE_NUM = "houseNum";
	public static final String RIDGEPOLE = "ridgepole";
	public static final String FLOOR = "floor";
	public static final String NUMBER = "number";
	public static final String USER_ID = "userId";
	public static final String DESCRIPTION = "description";

	protected void initDao() {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wuye.dao.IHouse#save(com.wuye.model.House)
	 */
	public void save(House transientInstance) {
		log.debug("saving House instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(House persistentInstance) {
		log.debug("deleting House instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public House findById(java.lang.Integer id) {
		log.debug("getting House instance with id: " + id);
		try {
			House instance = (House) getHibernateTemplate().get(
					"com.wuye.model.House", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(House instance) {
		log.debug("finding House instance by example");
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
		log.debug("finding House instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from House as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}
	
	public List findByHouseNum(Object houseNum) {
		return findByProperty(HOUSE_NUM, houseNum);
	}

	public List findByRidgepole(Object ridgepole) {
		return findByProperty(RIDGEPOLE, ridgepole);
	}

	public List findByFloor(Object floor) {
		return findByProperty(FLOOR, floor);
	}

	public List findByNumber(Object number) {
		return findByProperty(NUMBER, number);
	}

	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findAll() {
		log.debug("finding all House instances");
		try {
			String queryString = "from House";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public House merge(House detachedInstance) {
		log.debug("merging House instance");
		try {
			House result = (House) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(House instance) {
		log.debug("attaching dirty House instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(House instance) {
		log.debug("attaching clean House instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static HouseDAO getFromApplicationContext(ApplicationContext ctx) {
		return (HouseDAO) ctx.getBean("HouseDAO");
	}

	/**
	 * 按参数查询房屋信息
	 */
	public List findByPrama(String userName, String houseNum, Date startDate,
			Date endDate, int start, int size) {
		List list = new ArrayList();
		try {
			Session session = this.getHibernateTemplate().getSessionFactory()
					.getCurrentSession();
			String queryHQL = "select h.id,u.name,h.houseNum,h.ridgepole,h.floor,h.number,h.description,h.createTime"
					+ " from House h left join h.user u where 1=1";
			if (Tools.isEmptyString(userName) == false) {
				queryHQL += " and u.name like :userName";
			}
			if (Tools.isEmptyString(houseNum) == false) {
				queryHQL += " and h.houseNum like :houseNum";
			}
			if (startDate != null) {
				queryHQL += " and h.createTime >= :startDate";
			}
			if (endDate != null) {
				queryHQL += " and h.createTime <= :endDate";
			}
			queryHQL += " order by h.id asc";
			Query query = session.createQuery(queryHQL);
			if (Tools.isEmptyString(userName) == false) {
				query.setParameter("userName", "%" + userName + "%");
			}
			if (Tools.isEmptyString(houseNum) == false) {
				query.setParameter("houseNum", "%" + houseNum + "%");
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
			logger.error("按参数查询房间信息失败，原因:", e);
		}
		return list;
	}

	/**
	 * 按参数查询总计录数
	 */
	public int findCount(String userName, String houseNum, Date startDate,
			Date endDate) {
		int countNum = 0;
		List list = new ArrayList();
		try {
			Session session = this.getHibernateTemplate().getSessionFactory()
					.getCurrentSession();
			String queryHQL = "select count(h.id) from House h left join h.user u where 1=1";
			if (Tools.isEmptyString(userName) == false) {
				queryHQL += " and u.name like :userName";
			}
			if (Tools.isEmptyString(houseNum) == false) {
				queryHQL += " and h.houseNum like :houseNum";
			}
			if (startDate != null) {
				queryHQL += " and h.createTime >= :startDate";
			}
			if (endDate != null) {
				queryHQL += " and h.createTime <= :endDate";
			}
			Query query = session.createQuery(queryHQL);
			if (Tools.isEmptyString(userName) == false) {
				query.setParameter("userName", "%" + userName + "%");
			}
			if (Tools.isEmptyString(houseNum) == false) {
				query.setParameter("houseNum", "%" + houseNum + "%");
			}
			if (startDate != null) {
				query.setParameter("startDate", startDate);
			}
			if (endDate != null) {
				query.setParameter("endDate", endDate);
			}
			list = query.list();
		} catch (Exception e) {
			logger.error("按参数查询总计录数失败，原因:", e);
		}
		if (list != null && list.size() > 0) {
			countNum = Integer.parseInt(list.get(0).toString());
		}
		return countNum;
	}
}