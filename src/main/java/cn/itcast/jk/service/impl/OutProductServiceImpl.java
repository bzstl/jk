package cn.itcast.jk.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.jk.dao.OutProductDao;
import cn.itcast.jk.service.OutProductService;
import cn.itcast.jk.vo.OutProductVo;
@Service
public class OutProductServiceImpl implements OutProductService{

	@Autowired
	private OutProductDao outProductDao;
	
	@Override
	public List<OutProductVo> find(String inputDate) {
		// TODO Auto-generated method stub
		Map paraMap=new HashMap();
		paraMap.put("inputDate", inputDate);  
		return outProductDao.find(paraMap);
	}

}
