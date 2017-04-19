package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.jk.dao.ContractProductDao;
import cn.itcast.jk.domain.ContractProduct;
import cn.itcast.jk.pagination.Page;
import cn.itcast.jk.service.ContractProductService;
import cn.itcast.util.UtilFuns;
@Service
public class ContractProductServiceImpl implements ContractProductService {
	@Autowired
	private  ContractProductDao contractProductDao;
	
	@Override
	public List<ContractProduct> findPage(Page page) {
		// TODO Auto-generated method stub
		List<ContractProduct> findPage = contractProductDao.findPage(page);
		return findPage;
	}

	@Override
	public List<ContractProduct> find(Map paraMap) {
		// TODO Auto-generated method stub
		return contractProductDao.find(paraMap);
	}

	@Override
	public ContractProduct get(Serializable id) {
		// TODO Auto-generated method stub
		return contractProductDao.get(id);
	}

	@Override
	public void insert(ContractProduct contractProduct) {
		// TODO Auto-generated method stub
		contractProduct.setId(UUID.randomUUID().toString());
		if (UtilFuns.isNotEmpty(contractProduct.getCnumber())&&UtilFuns.isNotEmpty(contractProduct.getPrice())) {
			//计算总金额 :数量*单价
			double  amount=contractProduct.getCnumber()*contractProduct.getPrice();
			contractProduct.setAmount(amount);
		}
		contractProductDao.insert(contractProduct);
	}

	@Override
	public void update(ContractProduct contractProduct) {
		// TODO Auto-generated method stub
		contractProductDao.update(contractProduct);
	}

	@Override
	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		Serializable[] ids={id}; 
		
		try {//先删除所有货物下的附件 
			contractProductDao.deleteByContractProductById(ids);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		contractProductDao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		// TODO Auto-generated method stub
		try {//先删除所有货物下的附件 
			contractProductDao.deleteByContractProductById(ids);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contractProductDao.delete(ids);
	}

}
