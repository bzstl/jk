package cn.itcast.jk.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import cn.itcast.jk.domain.SysCode;
@Service
public interface SysCodeService {
	 public List<SysCode> find(Map paraMap);   //查询  
}
