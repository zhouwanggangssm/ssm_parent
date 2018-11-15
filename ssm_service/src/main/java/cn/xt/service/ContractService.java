package cn.xt.service;


import cn.xt.dao.ContractMapper;
import cn.xt.domain.Contract;
import cn.xt.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {
    @Autowired
    ContractMapper contractMapper;
    public List<Contract> findpage(){
         List<Contract> list = contractMapper.findPage();
        return list;
    }
}
