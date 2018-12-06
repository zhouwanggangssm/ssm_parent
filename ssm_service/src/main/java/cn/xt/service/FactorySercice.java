package cn.xt.service;

import cn.xt.dao.FactoryMapper;
import cn.xt.domain.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by PC on 2018/11/16.
 */
@Service
public class FactorySercice {

    @Autowired
    private FactoryMapper factoryMapper;

    //查询所有
    public List<Factory> serviceFactory(String text, String f_type) {
        List<Factory> list = factoryMapper.selectFactoryList(text,f_type);
        return list;
    }
    //根据id查询
    public Factory selectFactoryId(String factoryId) {
        Factory factory = factoryMapper.selectFactoryId(factoryId);
        return factory;
    }

    //添加
    public int addFactory(Factory factory) {
        // UUID生成id
        String s = UUID.randomUUID().toString();
        s = s.replace("-", "");
        factory.setFactoryId(s);
        int i=factoryMapper.insertSelective(factory);
        return i;
    }

    //根据id删除
    public int delFactory(String factoryId) {
        int i=factoryMapper.deleteByPrimaryKey(factoryId);
        return i;
    }

    //修改
    public int upFactory(Factory factory) {
        int i=factoryMapper.updateByPrimaryKeySelective(factory);
        return i;
    }

    //根据id改变状态
    public int upstate(String factoryId, String state) {
        int i=factoryMapper.upstate(factoryId,state);
        return i;
    }

    //查询条件分页
    public List<Factory> fyFactory(String text, int  currentPageNo, String f_type) {
        List<Factory> list=factoryMapper.fyFactory(text,currentPageNo,f_type);

        return list;
    }
    public int listC(String text,String f_type){
        int i=factoryMapper.listC(text,f_type);
        return  i;
    }


}
