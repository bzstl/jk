package cn.itcast.jk.dao.impl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import cn.itcast.jk.dao.ContractProductDao;
import cn.itcast.jk.domain.ContractProduct;
@Repository
public class ContractProductDaoImpl extends BaseDaoImpl<ContractProduct> implements ContractProductDao {

	public ContractProductDaoImpl(){
		super.setNs("cn.itcast.jk.dao.ContractProductMapper");
	}

	@Override
	public void deleteByContractProductById(Serializable[] ids) {
		// TODO Auto-generated method stub
		this.getSqlSession().delete(super.getNs() + ".deleteByContractProductById", ids);
	}


}
