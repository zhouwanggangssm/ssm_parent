package cn.xt.service;

import cn.xt.dao.ContractHisMapper;
import cn.xt.dao.springDao.SqlDao;
import cn.xt.domain.Contract;
import cn.xt.utils.UtilFuns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContractHisService {
    @Autowired
    private SqlDao sqlDao;
    @Autowired
    private ContractHisMapper contractHisMapper;

    /**
     * 查询所有历史信息
     * @return
     */
    public List<Contract> findPage(){
        return contractHisMapper.find(null);
    }

    /**
     * 查看
     * @return
     */
    public Contract view(String contractId){
        return contractHisMapper.view(contractId);
    }

    /**
     * 归档
     * @param contractIds
     */
    public void pigeinhole(String[] contractIds){
        //调用方法
        sqlDao.batchSQL(this.doData(contractIds,"","_his")); //批量执行
    }

    /**
     * 取消归档
     * @param contractIds
     */
    public void pigeouthole(String[] contractIds){
        //调用方法
        sqlDao.batchSQL(this.doData(contractIds,"_his","")); //批量执行
    }

    /**
     * 相同的东西提取出来
     * @param contractIds
     * @param source
     * @param target
     * @return
     */
    private String[] doData(String[] contractIds,String source, String target){
        StringBuffer buffer = new StringBuffer();
        //将当前的数据插入到历史表中
        String inStr = UtilFuns.joinStr(contractIds,"'","'",",");//合同的id串 x,y 构成成in子查询串x,y
        //处理历史购销合同新增
        buffer.append("insert into contract").append(target).append("_c (select * FROM contract").append(source).append("_c where contract_id in(").append(inStr).append("));");
        //处理历史货物新增
        buffer.append("insert into contract_product").append(target).append("_c (SELECT * from contract_product").append(source).append("_c WHERE CONTRACT_ID in(").append(inStr).append("));");
        //处理附件新增
        buffer.append("insert into ext_cproduct").append(target).append("_c (\n" +
                "SELECT * FROM ext_cproduct").append(source).append("_c WHERE CONTRACT_PRODUCT_ID in (\n" +
                "select CONTRACT_PRODUCT_ID from contract_product").append(source).append("_c WHERE contract_id in(").append(inStr).append(")));");

        //删除当前表的数据
        buffer.append("delete FROM ext_cproduct").append(source).append("_c WHERE CONTRACT_PRODUCT_ID in (select CONTRACT_PRODUCT_ID from contract_product").append(source).append("_c WHERE contract_id in(").append(inStr).append("));");
        buffer.append("delete FROM contract_product").append(source).append("_c WHERE CONTRACT_ID in(").append(inStr).append(");");
        buffer.append("delete FROM contract").append(source).append("_c where contract_id in(").append(inStr).append(");");

        return buffer.toString().split(";");
    }
}


















