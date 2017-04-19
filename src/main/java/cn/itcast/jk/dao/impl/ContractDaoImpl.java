package cn.itcast.jk.dao.impl;

import java.io.Serializable;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.itcast.jk.dao.ContractDao;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.vo.ContractVo;
@Repository
public class ContractDaoImpl extends BaseDaoImpl<Contract> implements ContractDao {
	
	
	public ContractDaoImpl(){
		super.setNs("cn.itcast.jk.dao.ContractMapper");
	}
	
	public void updateState(Map map) {
		super.getSqlSession().update(super.getNs()+".updateState", map);
		
	}

	@Override
	public void deleteByContractById(Serializable[] ids) {
		// TODO Auto-generated method stub
		super.getSqlSession().delete(super.getNs()+".deleteByContractById", ids);
	}

	@Override
	public void deleteExtByContractById(Serializable[] ids) {
		// TODO Auto-generated method stub
		super.getSqlSession().delete(super.getNs()+".deleteExtByContractById", ids);
	}

	@Override
	public ContractVo view(Serializable id) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectOne(super.getNs()+".view", id);
	}
}
