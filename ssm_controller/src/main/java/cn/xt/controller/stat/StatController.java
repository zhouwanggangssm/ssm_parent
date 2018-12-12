package cn.xt.controller.stat;

import cn.xt.domain.ContractProduct;
import cn.xt.domain.OnlineInfo;
import cn.xt.file.FileUtil;
import cn.xt.service.StatcharService;
import org.apache.commons.fileupload.util.LimitedInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/stat")
public class StatController {
    @Autowired
    private StatcharService statcharService;
    /**
     *厂家销量排名
     * */
    @RequestMapping("/factorysale")
    public String factorysales(Model model, HttpServletRequest request) throws  Exception{
        //sql语句
        List<ContractProduct> lists=statcharService.execChangjia();
        List<String> list=new ArrayList<>();
        //for 循环添加到list集合中
        for(ContractProduct c:lists){
            list.add(c.getFactoryName());
            //DecimalFormat 转型
            DecimalFormat df=new DecimalFormat("#.##");
            double a=c.getAmount();
            String str=df.format(a);
            list.add(str);
        }
        // 创建一个StringBuilder对象
        StringBuilder sb=new StringBuilder();
        //组织符合要求的json数据
        sb.append("[");
        String color[]={"#FF0F00","#FF6600","#FF9E01","#FCD202","#F8FF01","#B0DE09","#04D215","#0D8ECF" };
        int j=0;
        for(int i=0;i<list.size();i++){
            sb.append("{").append("\"factory\":\"").append(list.get(i)).append("\",")
                    .append("\"amount\":\"").append(list.get((++i))).append("\",")
                    .append("\"color\":\"").append(color[j++]).append("\"")
                    .append("}").append(",");
            if(j>=color.length){
                j=0;
            }
        }
        //删除循环的sb.length()-1,sb.length()最后一个
        sb.delete(sb.length()-1,sb.length());
        sb.append("]");
        //将json数据放入值栈中
        model.addAttribute("result",sb.toString());
        return "stat/chart/column3D";
    }

    /**
     * 产品销量排名前15
     * */
    @RequestMapping("/productsale")
    public String productsale(HttpServletRequest request) throws Exception{
        String dir="productsale";
        //sql语句
       List<ContractProduct> lists= statcharService.execChanPing();
       List<String> list =new ArrayList<>();
        //将getProductNo，Cnumber() 循环添加到list集合中
       for(ContractProduct c:lists){
           list.add(c.getProductNo());
           list .add(c.getCnumber().toString());
       }

        //将sql存入到柱状图数据中
        String content=genBarDateSet(list);
        //将字符串写入date.xml文件中
        writeXML("stat\\chart\\productsale\\data.xml",content,request);
        request.setAttribute("forward",dir);
        return "stat/chart/jStat";
    }

    /**
     * 系统访问压力图
     */
    @RequestMapping("/onlineinfo")
    private String onlineinfo(HttpServletRequest request) throws Exception{
        String dir="onlineinfo";
        //sql语句
        List<OnlineInfo> lists=statcharService.execonline();
        List<String> list=new ArrayList<>();
        //for 循环添加到list 中
        for(OnlineInfo info:lists){
            //判断如果A2的值为空时就给它赋值为0
            if(info.getA2()==null){
                info.setA2(0);
            }
            list.add(info.getA1());
            list.add(info.getA2().toString());
        }
        //将SQL语句添加到genBarDatSet中
        String content=genBarDateSet(list);
        //将字符串写入到dao.xml
        writeXML("stat\\chart\\onlineinfo\\data.xml",content,request);
        request.setAttribute("forward",dir);
        return "stat/chart/jStat";
    }

    /**
     * 生成柱状数据
     */
    private String genBarDateSet(List<String> list) {
        StringBuilder sb=new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sb.append("<chart>\n" +
                "\t<series>");
        int j=0;
        for(int i=0;i<list.size();){
            sb.append("<value xid=\""+(j++)+"\">"+list.get(i)+"</value>");
            i=i+2;
        }
        sb.append("</series>\n" +
                "\t<graphs>\n" +
                "\t\t<graph gid=\"30\" color=\"#FFCC00\" gradient_fill_colors=\"#111111, #1A897C\">");
        j=0;
        for(int i=0;i<list.size();){
            i++;
            if (i==list.size()){
                break;
            }else{
                sb.append("<value xid=\""+(j++)+"\" description=\"\" url=\"\">"+list.get(i)+"</value>");
            }
            i++;
        }
        sb.append("</graph>\n"+
                "\t</graphs>");
        sb.append("<labels><label lid=\"0\"><x>0</x><y>20</y><rotate></rotate><width></width><align>center</align><text_color></text_color><text_size></text_size><text><![CDATA[<b> </b>]]></text></label></labels>");
        sb.append("</chart>");
        return sb.toString();
    }
    /**
     * 写入xml文件
     */
    public void writeXML(String fileName, String content,HttpServletRequest request) throws FileNotFoundException {
        FileUtil fileUtil=new FileUtil();
        String path=request.getSession().getServletContext().getRealPath("/");
        fileUtil.createTxt(path,fileName,content,"utf-8");
    }
}
