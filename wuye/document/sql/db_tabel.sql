/** 创建数据库***创建数据库时，一定要记得设置默认编码 和排序规则  **/
CREATE DATABASE wuye DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
/* 管理员表*/
CREATE TABLE managers (
  id int(10) NOT NULL AUTO_INCREMENT,
  name varchar(20) DEFAULT NULL COMMENT '管理员姓名',
  user_name varchar(20) DEFAULT NULL COMMENT '登录名',
  password varchar(32) DEFAULT NULL COMMENT '密码',
  phone varchar(30) DEFAULT NULL COMMENT '电话',
  description varchar(100) DEFAULT NULL COMMENT '描述',
  create_time datetime DEFAULT NULL COMMENT '创建时间',
  update_time datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*用户表*/
CREATE TABLE user (
  id int(10) NOT NULL AUTO_INCREMENT,
  name varchar(20) DEFAULT NULL,
  password varchar(32) DEFAULT NULL,
  phone varchar(20) DEFAULT NULL,
  mial varchar(50) DEFAULT NULL,
  house_id int(10) DEFAULT NULL,
  description varchar(100) DEFAULT NULL,
  create_time datetime DEFAULT NULL,
  update_time datetime DEFAULT NULL,
  user_icon varchar(200) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*菜单表*/
CREATE TABLE menu (
  id varchar(32) NOT NULL,
  m_name varchar(50) DEFAULT NULL,
  parent_id varchar(323) DEFAULT NULL,
  url varchar(200) DEFAULT NULL,
  sort_num int(11) DEFAULT NULL,
  create_time datetime DEFAULT NULL,
  update_time datetime DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE manger_menu (
  manager_id int(11) NOT NULL DEFAULT '0',
  menu_id varchar(32) NOT NULL DEFAULT '',
  PRIMARY KEY (manager_id,menu_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/*权限表*/
CREATE TABLE permissions (
  id int(11) NOT NULL,
  name varchar(50) DEFAULT NULL,
  url varchar(50) DEFAULT NULL,
  sort_num int(11) DEFAULT NULL,
  create_time datetime DEFAULT NULL,
  update_time datetime DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE manager_premission (
  manager_id int(11) NOT NULL DEFAULT '0',
  premission_id int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (manager_id,premission_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;