package cn.itcast.jk.dao;

import java.util.List;
import java.util.Map;

import cn.itcast.jk.vo.OutProductVo;

public interface OutProductDao {
	public List<OutProductVo> find(Map paraMap);
}
