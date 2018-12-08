package cn.xt.dao;

import cn.xt.domain.ContractProduct;
import cn.xt.domain.OnlineInfo;

import java.util.List;

public interface StatMapper {
	//厂家销量
	public List<ContractProduct> execChangjia();
	//产品销量
	public List<ContractProduct> execChanPing();
	//统计在线人数
	public List<OnlineInfo> execonline();
}
