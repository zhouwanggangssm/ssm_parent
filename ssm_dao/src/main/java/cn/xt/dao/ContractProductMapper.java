package cn.xt.dao;

import cn.xt.domain.Contract;
import cn.xt.domain.ContractProduct;
import cn.xt.domain.ContractProductExample;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ContractProductMapper {
    long countByExample(ContractProductExample example);

    int deleteByExample(ContractProductExample example);

    int deleteByPrimaryKey(String contractProductId);

    /*级联删除*/
    int deleteByContactProductById(List<String> ids);

    int insert(ContractProduct record);

    int insertSelective(ContractProduct record);

    List<ContractProduct> selectByExample(ContractProductExample example);

    /*查询所有*/
    List<ContractProduct> find(ContractProduct contractProduct);

    /**
     * 根据id查询
     * @param contractProductId
     * @return
     */
    ContractProduct get(String contractProductId);

    int inserts(ContractProduct contractProduct);

    /*根据id In查询*/
    List<ContractProduct> selectByExamplewithIn(ContractProductExample example);

    /*查询厂家名称，附件*/
    List<ContractProduct> selectByExamplewithcp(@Param("contractId") String contractId);

    /*根据购销合同船期，查询货物，购销合同。打印*/
    List<ContractProduct> selectByExamplewithShipTime(@Param("shipTime") String shipTime);

    /*根据货物id查询附件id信息子查询*/
    ContractProduct selectByPrimaryKeywithcp(@Param("contractProductId") String contractProductId);

    /*根据货物id查询附件id信息*/
    ContractProduct selectByPrimaryKeywithExport(@Param("contractProductId") String contractProductId);

    ContractProduct selectByPrimaryKey(String contractProductId);

    int updateByExampleSelective(@Param("record") ContractProduct record, @Param("example") ContractProductExample example);

    int updateByExample(@Param("record") ContractProduct record, @Param("example") ContractProductExample example);

    int updateByPrimaryKeySelective(ContractProduct record);

    int updateByPrimaryKey(ContractProduct record);
}