package cn.itcast.jk.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.itcast.jk.dao.FactoryDao;
import cn.itcast.jk.domain.Factory;
import cn.itcast.jk.pagination.Page;


@Repository
public class FactroyDaoImpl extends BaseDaoImpl<Factory> implements FactoryDao {
	
	public FactroyDaoImpl() {
		// TODO Auto-generated constructor stub
		super.setNs("cn.itcast.jk.dao.FactoryMapper");
	}

	
	public void updateState(Map map) {
		super.getSqlSession().update(super.getNs()+".updateState", map);
		
	}
}
 