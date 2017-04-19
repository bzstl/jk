package cn.itcast.jk.dao;

import java.io.Serializable;

import cn.itcast.jk.domain.ExtCProduct;

public interface ExtCProductDao extends BaseDao<ExtCProduct> {
	public String getContractIdBycontractProductId(Serializable id);
}
