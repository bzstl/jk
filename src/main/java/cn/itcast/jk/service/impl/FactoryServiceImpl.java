package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.jk.dao.FactoryDao;
import cn.itcast.jk.dao.impl.FactroyDaoImpl;
import cn.itcast.jk.domain.Factory;
import cn.itcast.jk.pagination.Page;
import cn.itcast.jk.service.FactoryService;
@Service
public class FactoryServiceImpl implements FactoryService{

	@Autowired
	FactoryDao factoryDao; 
	
	@Override
	public List<Factory> findPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Factory> find(Map paraMap) {
		// TODO Auto-generated method stub
		return factoryDao.find(paraMap);
	}

	@Override
	public Factory get(Serializable id) {
		
		return factoryDao.get(id);
	}

	@Override
	public void insert(Factory factry) {
		//设置主键
		factry.setId(UUID.randomUUID().toString());
		//设置厂家状态为启用
		factry.setState("1");
		factoryDao.insert(factry);
	}

	@Override
	public void update(Factory factry) {
		// TODO Auto-generated method stub
		factoryDao.update(factry);
	}

	@Override
	public void deleteById(Serializable id) {
		factoryDao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		// TODO Auto-generated method stub
		factoryDao.delete(ids);
	}

	@Override
	public void start(Serializable[] ids) {
		Map map = new HashMap();
		map.put("state", "1");//1启用
		map.put("ids", ids);
		factoryDao.updateState(map);
	}

	@Override
	public void stop(Serializable[] ids) {
		Map map = new HashMap();
		map.put("state", "0");//0停用
		map.put("ids", ids);
		factoryDao.updateState(map);
		
	}

	@Override
	public List<Factory> getFactoryList() {
		// TODO Auto-generated method stub
		Map paraMap =new HashMap();
		paraMap.put("state", "1");
		
		return factoryDao.find(paraMap);
	}

}
