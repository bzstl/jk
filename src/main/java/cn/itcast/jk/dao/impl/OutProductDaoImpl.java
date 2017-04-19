package cn.itcast.jk.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.itcast.jk.dao.OutProductDao;
import cn.itcast.jk.vo.OutProductVo;
@Repository
public class OutProductDaoImpl  extends SqlSessionDaoSupport implements OutProductDao{
	@Autowired
	//mybatis-spring 1.0无需此方法；mybatis-spring1.2必须注入。
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	private String ns;		//命名空间
	public String getNs() {
		return ns;
	}
	public void setNs(String ns) {
		this.ns = ns;
	}
	
	public OutProductDaoImpl(){
		this.setNs("cn.itcast.jk.dao.OutProductMapper");
	}
	@Override
	public List<OutProductVo> find(Map map) {
		// TODO Auto-generated method stub
		List<OutProductVo> oList = this.getSqlSession().selectList(ns + ".find", map);
		return oList;
	}
}
