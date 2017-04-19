package com.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.jk.dao.ExtCProductDao;
import cn.itcast.jk.dao.OutProductDao;
import cn.itcast.jk.dao.impl.ContractDaoImpl;
import cn.itcast.jk.dao.impl.FactroyDaoImpl;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.domain.Factory;
import cn.itcast.jk.domain.SysCode;
import cn.itcast.jk.service.ExtCProductService;
import cn.itcast.jk.service.FactoryService;
import cn.itcast.jk.service.OutProductService;
import cn.itcast.jk.vo.ContractVo;
import cn.itcast.jk.vo.OutProductVo;
import junit.framework.Test;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/beans.xml","classpath*:/springmvc-servlet.xml"})
public class BaseJunitTest {
	@Autowired
	private ContractDaoImpl cdi;
	@Autowired
	private FactoryService fs;
	@Autowired
	private ExtCProductService es;
	@Autowired
	private ExtCProductDao ed;
	@Autowired
	private OutProductService ops;
	
	@org.junit.Test
	public void Test(){
		List<OutProductVo> find = ops.find("2017-02");
		System.out.println("o");
	}
}
