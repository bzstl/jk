package cn.itcast.jk.service;

import java.util.List;

import cn.itcast.jk.vo.OutProductVo;

public interface OutProductService {
	public List<OutProductVo> find(String inputDate);
}
