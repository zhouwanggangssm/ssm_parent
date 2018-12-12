package cn.xt.controller.basis;

import cn.xt.domain.Factory;
import cn.xt.service.FactorySercice;
import cn.xt.utils.SysConstant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
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


    /**
     * 分页条件查询
     * @param text
     * @param pageIndex
     * @param f_type
     * @param model
     * @return
     */
    @RequestMapping(value = "/factoryActionlist_list")
    public String fyFactory(
            @RequestParam(value = "text",required = false)String text,
            @RequestParam(value="pageIndex",required = false,defaultValue = "1")int  pageIndex,
            @RequestParam(value = "f_type",required = false)String f_type,
            Model model
    ){
        //调用PageHelper.startPage的方法  传pageIndex和SysConstant
        PageHelper.startPage(pageIndex,SysConstant.PAGE_SIZE);
        //调用sercice的方法serviceFactpry
        List<Factory> factoryList = factorySercice.serviceFactory(text, f_type);
        //实例化Pageinfo
        PageInfo pageInfo = new PageInfo(factoryList);
        //用model返回分页数据
        model.addAttribute("list",pageInfo.getList());
        //list接
          //返回数据  pageinfo.getList
        //totalPageCount接
        //总页数 pageinfo.getPages
        model.addAttribute("totalPageCount", pageInfo.getPages());
        //totalCount
         //总记录数 pageinfo.getTotal
        model.addAttribute("totalCount", pageInfo.getTotal());
        model.addAttribute("currentPageNo", pageInfo.getPageNum());
        //currentPageNo
        //当前页 pageIndex
        return "baseinfo/jFactoryList";
    }

    /**
     * 根据ID查询
     * @param factoryId
     * @param model
     * @return
     */
    @RequestMapping(value = "/selectFactoryId")
    public String selectFactoryId(
            @RequestParam(value = "factoryId",required = false)String factoryId,
            Model model
    ){
        //selectFactory方法
        if(factoryId!=null){
            Factory factory=factorySercice.selectFactoryId(factoryId);
            model.addAttribute("factory",factory);
            return  "baseinfo/jFactoryID";
        }else {
            return "redirect:/basicinfo/factoryActionlist_list";
        }

    }

    /**
     * 跳转添加页面
     * @return
     */
    @RequestMapping(value = "/goadd")
    public String goadd(){
        return  "baseinfo/addFactory";
    }


    /**
     * 添加厂家信息
     * @param factory
     * @return
     */
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


    /**
     * 根据id删除
     * @param factoryId
     * @param model
     * @return
     */
    @RequestMapping(value = "/deleFactryID")
    public String deleFactryID(@RequestParam(value = "factoryId",required = false)String factoryId,Model model){

        if(factoryId!=null){
            int i=factorySercice.delFactory(factoryId);
            return "redirect:/basicinfo/factoryActionlist_list";
        }else {
            String aeixnhgg="删除错误，请选择ID";
            model.addAttribute("outt",aeixnhgg);
            return "redirect:/basicinfo/factoryActionlist_list";
        }
    }


    /**
     * 根据id查询修改 获得factoryId
     * @param factoryId
     * @param model
     * @return
     */
    @RequestMapping(value = "/upFactoryId")
    public String upFactoryId( @RequestParam(value = "factoryId",required = false)String factoryId,
                               Model model){
        //先跳查询页面
        if(factoryId!=null){
            Factory factory=factorySercice.selectFactoryId(factoryId);

            model.addAttribute("factory1",factory);

            return "baseinfo/upFactoryID";
        }else{
            return "redirect:/basicinfo/factoryActionlist_list";
        }

    }

    /**
     * 修改方法upFactory 获得factory
     * @param factory
     * @return
     */
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

    /**
     *  //根据id修改状态upType 获得factoryId state
     * @param factoryId
     * @param state
     * @return
     */
    @RequestMapping(value = "/upType")
    public String upType(
            @RequestParam(value = "factoryId",required = false)String factoryId,
            @RequestParam(value = "state")String state
    ){
        if(factoryId!=null){
            int i=factorySercice.upstate(factoryId,state);

            //返回查询方法

            return "redirect:/basicinfo/factoryActionlist_list";
        }else {
             return "redirect:/basicinfo/factoryActionlist_list";
        }

    }

}
