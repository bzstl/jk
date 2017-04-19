package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.jk.dao.ExtCProductDao;
import cn.itcast.jk.dao.SysCodeDao;
import cn.itcast.jk.domain.ExtCProduct;
import cn.itcast.jk.domain.SysCode;
import cn.itcast.jk.pagination.Page;
import cn.itcast.jk.service.ExtCProductService;
import cn.itcast.util.UtilFuns;

@Service
public class ExtCProductServiceImpl implements ExtCProductService {
	
	@Autowired
	private ExtCProductDao extCProductDao;
	@Autowired
	private SysCodeDao sysCodeDao;

	@Override
	public List<ExtCProduct> findPage(Page page) {
		List<ExtCProduct> findPage = extCProductDao.findPage(page);
		return findPage;
	}

	@Override
	public List<ExtCProduct> find(Map paraMap) {
		// TODO Auto-generated method stub
		return extCProductDao.find(paraMap);
	}

	@Override
	public ExtCProduct get(Serializable id) {
		// TODO Auto-generated method stub
		return extCProductDao.get(id);
	}

	@Override
	public void insert(ExtCProduct extCProduct) {
		// TODO Auto-generated method stub
		
		extCProduct.setId(UUID.randomUUID().toString());
		if (UtilFuns.isNotEmpty(extCProduct.getCnumber())&&UtilFuns.isNotEmpty(extCProduct.getPrice())) {
			//计算总金额 :数量*单价
			double  amount=extCProduct.getCnumber()*extCProduct.getPrice();
			extCProduct.setAmount(amount);
		}
		extCProductDao.insert(extCProduct);
	}

	@Override
	public void update(ExtCProduct extCProduct) {
		// TODO Auto-generated method stub
		
		if (UtilFuns.isNotEmpty(extCProduct.getCnumber())&&UtilFuns.isNotEmpty(extCProduct.getPrice())) {
			//计算总金额 :数量*单价
			double  amount=extCProduct.getCnumber()*extCProduct.getPrice();
			extCProduct.setAmount(amount);
		}
		extCProductDao.update(extCProduct);
	}

	@Override
	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		extCProductDao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		// TODO Auto-generated method stub
		extCProductDao.delete(ids);
	}

	@Override
	public List<SysCode> getCtypeList() {
		// TODO Auto-generated method stub
		
		Map paraMap= new HashMap();
		paraMap.put("parentId", "0104");
		return sysCodeDao.find(paraMap);
	}

	@Override
	public String getContractIdBycontractProductId(Serializable id) {
		// TODO Auto-generated method stub
		return extCProductDao.getContractIdBycontractProductId(id);
	}

}
