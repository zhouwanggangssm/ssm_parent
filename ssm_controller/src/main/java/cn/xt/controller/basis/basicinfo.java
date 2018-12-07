package cn.xt.controller.basis;

import cn.xt.domain.Factory;
import cn.xt.service.FactorySercice;
import cn.xt.utils.SysConstant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by PC on 2018/11/15.
 */
@Controller
@RequestMapping(value = "/basicinfo")
public class   basicinfo{
     @Autowired
     private FactorySercice factorySercice;


    //分页条件查询
    @RequestMapping(value = "/factoryActionlist_list")
    public String fyFactory(
            @RequestParam(value = "text",required = false)String text,
            @RequestParam(value="pageIndex",required = false,defaultValue = "1")int  pageIndex,
            @RequestParam(value = "f_type",required = false)String f_type,

            Model model
    ){
        //调用pagehelper.startpage的方法  传pageindex和sysconstant
        PageHelper.startPage(pageIndex, SysConstant.PAGE_SIZE);
        //调用sercice的方法serviceFactpry
        List<Factory> list=factorySercice.serviceFactory(text, f_type);
        //实例化Pageinfo
        PageInfo pageInfo = new PageInfo(list);
        //用model返回分页数据
        //list接
        model.addAttribute("list",pageInfo.getList());  //返回数据  pageinfo.getList
        //totalPageCount接
        model.addAttribute("totalPageCount",pageInfo.getPages());//总页数 pageinfo.getPages
        //totalCount
        model.addAttribute("totalCount",pageInfo.getTotal()); //总记录数 pageinfo.getTotal
        //currentPageNo
        model.addAttribute("currentPageNo",pageIndex);//当前页 pageindex
        return "baseinfo/jFactoryList";
    }

    //根据ID查询
    @RequestMapping(value = "/selectFactoryId")
    public String selectFactoryId(
            @RequestParam(value = "factoryId")String factoryId,
            Model model
    ){
        //selectFactory方法
            Factory factory=factorySercice.selectFactoryId(factoryId);
            model.addAttribute("factory",factory);
        return  "baseinfo/jFactoryID";
    }
    @RequestMapping(value = "/goadd")
    public String goadd(){
        return  "baseinfo/addFactory";
    }

    //添加厂家信息
    @RequestMapping(value = "/FactoryAdd",method = RequestMethod.POST)
    public String factoryAdd(Factory factory){

        int i=factorySercice.addFactory(factory);
        //判断返回值 i是否null
        if(i>0){
            //redirect到查询方法
            return "redirect:/basicinfo/factoryActionlist_list";
        }else {
            return "";
        }
    }

    //根据id删除
    @RequestMapping(value = "/deleFactryID")
    public String deleFactryID(@RequestParam(value = "factoryId")String factoryId){
        int i=factorySercice.delFactory(factoryId);
        //判断返回值 i是否null
        if(i>0){
            //redirect到查询方法
            return "redirect:/basicinfo/factoryActionlist_list";
        }else {
            return "";
        }
    }

    //根据id查询修改
    //获得factoryId
    @RequestMapping(value = "/upFactoryId")
    public String upFactoryId( @RequestParam(value = "factoryId")String factoryId,
                               Model model){
        //先跳查询页面

        Factory factory=factorySercice.selectFactoryId(factoryId);

        model.addAttribute("factory1",factory);

        return "baseinfo/upFactoryID";
    }
    //修改方法upFactory 获得factory
    @RequestMapping(value = "/upFactory")
    public String upFactory(Factory factory){
        //在修改

        int i=factorySercice.upFactory(factory);
        if(i>0){

            //重定向到查询方法
            return  "redirect:/basicinfo/factoryActionlist_list";

        }else{

            return "";
        }

    }

    //根据id修改状态upType

    //获得factoryId state
    @RequestMapping(value = "/upType")
    public String upType(
            @RequestParam(value = "factoryId")String factoryId,
            @RequestParam(value = "state")String state
    ){
        int i=factorySercice.upstate(factoryId,state);

        //返回查询方法

        return "redirect:/basicinfo/factoryActionlist_list";
    }

}
