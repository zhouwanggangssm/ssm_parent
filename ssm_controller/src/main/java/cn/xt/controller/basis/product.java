package cn.xt.controller.basis;


import cn.xt.domain.Factory;
import cn.xt.domain.Product;
import cn.xt.service.PrductSercice;
import cn.xt.utils.SysConstant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;


/**
 * Created by PC on 2018/11/23.
 */
@Controller
@RequestMapping(value = "product")
public class product {
    @Autowired
    public PrductSercice prductSercice;


    /**
     * 分页查询
     * @param id
     * @param factoryName
     * @param pageIndex
     * @param model
     * @return
     */
    @RequestMapping(value = "/productList")
    public String productList(@RequestParam(value ="id", required = false) String id,
                              @RequestParam(value = "factoryName",required = false) String factoryName,
                              @RequestParam(value = "pageIndex",required = false,defaultValue = "1") int pageIndex,
                              Model model){
        PageHelper.startPage(pageIndex, SysConstant.PAGE_SIZE);
        //传入当前页，每页显示10条
        List<Product> list=prductSercice.selectProdList(id,factoryName);
        //把查出来的数据放进pageInfo
        PageInfo pageInfo = new PageInfo(list);

        model.addAttribute("listpro",pageInfo.getList());//数据
        model.addAttribute("totalPageCount",pageInfo.getPages());//总页数
        model.addAttribute("totalCount",pageInfo.getTotal()); //总记录数
        model.addAttribute("currentPageNo",pageIndex);//当前页
        return "/baseinfo/productList";
    }

    //查询厂家信息到添加页面
    @RequestMapping(value ="tzadd")
    public String tzadd(Model model){
        List<Factory> list=prductSercice.Factory();

        model.addAttribute("Factory",list);
        return "/baseinfo/addproduct";
    }

    /**
     * 添加 获得原始文件名
     * @param product
     * @param request
     * @param fileName
     * @return
     */
    @RequestMapping(value = "/addprodct")
    public String addprodct(Product product, HttpServletRequest request
            , @RequestParam(value = "fileName") MultipartFile fileName
                           ){
        // 获得原始文件名
        String productImage = fileName.getOriginalFilename();
        ServletContext sc = request.getSession().getServletContext();
        // 上传位置
        String path = sc.getRealPath("/images") + "/"; // 设定文件保存的目录
        File f = new File(path);
        if (!f.exists()) {
            f.mkdirs();
        }
        if (!fileName.isEmpty()) {
            try {
                FileOutputStream fos = new FileOutputStream(path + productImage);
                InputStream in = fileName.getInputStream();
                int b = 0;
                while ((b = in.read()) != -1) {
                    fos.write(b);
                }
                fos.close();
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
         System.out.println("上传图片到:" + path + productImage);
        product.setProductImage(productImage);
        int i=prductSercice.addproduct(product);
            return "redirect:/product/productList";

    }

    /**
     * 删除
     * @param productId
     * @return
     */
    @RequestMapping(value = "/detproduct",method = RequestMethod.DELETE)
    public String detproduct(@RequestParam(value = "productId",required = false)String productId) {

        if (productId !=null) {
            prductSercice.detproduct(productId);
            return "redirect:/product/productList";
        } else {
            return "";
        }


    }

    /**
     * 根据id查询修改
     * @param productId
     * @param model
     * @return
     */
    @RequestMapping(value = "/selectp")
    public String selectproduct(@RequestParam(value = "productId",required = false)String productId,
                                Model model){
        if (productId!=null){
            //根据id查询方法
            Product product=prductSercice.productsList(productId);
            //查询厂家信息
            List<Factory> list =prductSercice.Factory();
            model.addAttribute("list",product);
            model.addAttribute("list2",list);
            return "/baseinfo/UPproduct";
        }else{
            return "";
        }

    }
    @RequestMapping(value = "/upProduct")
    public String upProduct(Product product){
        int i=prductSercice.upProduct(product);
        if(i>0) {
            return "redirect:/product/productList";
        }else{
            return "";
        }
    }


    /**
     * 根据id查询
     * @param productId
     * @param model
     * @return
     */
    @RequestMapping(value = "/listProductId")
    public  String listProductId(@RequestParam(value = "productId",required = false)String productId,
                                 Model model){

        if(productId!=null){
            Product product=prductSercice.productsList(productId);

            model.addAttribute("fileUrl",product.getProductImage());
            model.addAttribute("list1",product);
            return "/baseinfo/ProductID";
        }else {
            return "";
        }

    }





}
