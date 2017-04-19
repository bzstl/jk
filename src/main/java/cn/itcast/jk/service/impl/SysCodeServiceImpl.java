package cn.itcast.jk.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.jk.dao.SysCodeDao;
import cn.itcast.jk.domain.SysCode;
import cn.itcast.jk.service.SysCodeService;

public class SysCodeServiceImpl implements SysCodeService {

	
	@Autowired
	private SysCodeDao  sysCodeDao;
	@Override
	public List<SysCode> find(Map paraMap) {
		// TODO Auto-generated method stub
		
		
		return sysCodeDao.find(paraMap);
	}

}
