package cn.itcast.jk.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import cn.itcast.jk.dao.ExtCProductDao;
import cn.itcast.jk.domain.ExtCProduct;
@Repository
public class ExtCProductDaoImpl extends BaseDaoImpl<ExtCProduct> implements ExtCProductDao {
	public ExtCProductDaoImpl(){
		super.setNs("cn.itcast.jk.dao.ExtCProductMapper");
	}

	@Override
	public String getContractIdBycontractProductId(Serializable id) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne(super.getNs() + ".getContractIdBycontractProductId", id);
	}
}
