<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2018/11/20
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title></title>
        <script type="text/javascript" src="${ctx }/js/datepicker/WdatePicker.js"></script>
    </head>


 <%
SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
String date= format.format(new Date());
%>
<body>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>管理页面 >> 信息添加页面</span>
    </div>

    <div class="providerView" >
            <form action="/basicinfo/FactoryAdd" method="post">
               <%-- <p><span>状    态：</span><span><input  type="text" name="state"></span></p>
                <p><span>类    型：</span><span><input  type="text" name="ctype"></span></p>
                <p><span>厂家全称：</span><span><input  type="text" name="fullName"></span></p>
                <p><span>名称缩写：</span><span><input  type="text" name="factoryName"></span></p>
                <p><span>联 系 人：</span><span><input  type="text" name="contacts"></span></p>
                <p><span>电    话：</span><span><input  type="text" name="phone"></span></p>
                <p><span>手    机：</span><span><input  type="text" name="mobile"></span></p>
                <p><span>传    真：</span><span><input  type="text" name="fax"></span></p>
                <p><span>说    明：</span><span><input  type="text" name="address"></span></p>
                <p><span>验 货 员：</span><span><input  type="text" name="inspector"></span></p>
                <p><span>排 序 号：</span><span><input  type="text" name="orderNo"></span></p>
                <p><span>创 建 人：</span><span><input  type="text" name="createBy"></span></p>
                <p><span>创建部门：</span><span><input  type="text" name="createDept"></span></p>
                <p><span>创建日期：</span><span>
                    <input type="text" style="width:90px;" name="createTime"
                           onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
                </span></p>--%>

                <table>
                    <tr>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>状 态：<span><input  type="text" name="state"></span></td>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>类 型：</span><span><input  type="text" name="ctype"></span></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>厂 家 全 称：<span><input  type="text" name="fullName"></span></td>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>名 称 缩 写：</span><span><input  type="text" name="factoryName"></span></td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>联系人：<span><input  type="text" name="contacts"></span></td>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>电话：<span><input  type="text" name="phone"></span></td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>手 机：<span><input  type="text" name="mobile"></span></td>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>传 真：<span><input  type="text" name="fax"></span></td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>创 建 部 门：<span><input  type="text" name="createDept"></span></td>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>验 货 员：<span><input  type="text" name="inspector"></span></td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>排 序 号：<span><input  type="text" name="orderNo"></span></td>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>创 建 人：</span><span><input  type="text" name="createBy"></span></td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>创 建 日 期：<span>
                    <input type="text" style="width:90px;" name="createTime"
                           onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
                </span></td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        说明:<td> <textarea rows="7" cols="30"  name="address"></textarea></td>
                    </tr>


                </table>
                <hr/>
                <input type=text style="display:none" name="updateTime"
                    value="<%=date%>"
                />
                <input  type="submit" value="确定"/>
            </form>

            <a href="/basicinfo/factoryActionlist_list">
            <button>返回</button>
        </a>

    </div>
</div>


</body>
</html>
</head>
<body>

</body>
</html>
