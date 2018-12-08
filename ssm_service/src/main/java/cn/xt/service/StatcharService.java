package cn.xt.service;

import cn.xt.dao.StatMapper;
import cn.xt.domain.ContractProduct;
import cn.xt.domain.OnlineInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatcharService {
    @Autowired
    StatMapper stat;
    /*厂家销量*/
    public List<ContractProduct> execChangjia(){
        List<ContractProduct> list= stat.execChangjia();
        return list;
    }
    /*产品销量*/
    public List<ContractProduct> execChanPing(){
        List<ContractProduct> list= stat.execChanPing();
        return list;
    }
    /* 统计人数*/
    public List<OnlineInfo> execonline(){
        List<OnlineInfo> list=stat.execonline();
        return list;
    }
}

