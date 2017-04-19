package cn.itcast.jk.dao;

import java.io.Serializable;
import java.util.Map;

import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.vo.ContractVo;

public interface ContractDao extends BaseDao<Contract> {
	public void updateState (Map map);					//修改，用实体作为参数
	
	public void deleteByContractById(Serializable[] ids)throws Exception;
	public void deleteExtByContractById(Serializable[] ids)throws Exception;
	public ContractVo view(Serializable id);
}
