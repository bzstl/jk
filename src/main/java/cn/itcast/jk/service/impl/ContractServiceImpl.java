package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.jk.dao.ContractDao;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.pagination.Page;
import cn.itcast.jk.service.ContractService;
import cn.itcast.jk.vo.ContractVo;
@Service
public class ContractServiceImpl implements ContractService{

	@Autowired
	ContractDao contractDao; 
	
	@Override
	public List<Contract> findPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contract> find(Map paraMap) {
		// TODO Auto-generated method stub
		return contractDao.find(paraMap);
	}

	@Override
	public Contract get(Serializable id) {
		
		return contractDao.get(id);
	}

	@Override
	public void insert(Contract contract) {
		//设置主键
		contract.setId(UUID.randomUUID().toString());
		//设置状态为草稿
		contract.setState("0");
		contractDao.insert(contract);
	}

	@Override
	public void update(Contract contract) {
		// TODO Auto-generated method stub
		contractDao.update(contract);
	}

	@Override
	public void deleteById(Serializable id) {
		Serializable[] ids={id};  
		try {
			contractDao.deleteExtByContractById(ids);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			contractDao.deleteByContractById(ids);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		contractDao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		// TODO Auto-generated method stub
		
		try {//删除合同时删除合同货物下的所有附件  
			contractDao.deleteExtByContractById(ids);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {//删除合同时同时删除合同下的货物  
			contractDao.deleteByContractById(ids);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		contractDao.delete(ids);
	}

	@Override
	public void submit(Serializable[] ids) {
		Map map = new HashMap();
		map.put("state", "1");//1上报
		map.put("ids", ids);
		contractDao.updateState(map);
	}

	@Override
	public void cancle(Serializable[] ids) {
		Map map = new HashMap();
		map.put("state", "0");//0草稿
		map.put("ids", ids);
		contractDao.updateState(map);
		
	}

	@Override
	public ContractVo view(Serializable id) {
		// TODO Auto-generated method stub
		return contractDao.view(id);
	}

}
