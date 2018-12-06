<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2018/11/21
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <script type="text/javascript" src="${ctx }/js/datepicker/WdatePicker.js"></script>
    <title></title>

</head>
<%
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    String date= format.format(new Date());
%>
<body>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>管理页面 >> 信息修改页面</span>
    </div>
    <div class="providerView">
            <form action="/basicinfo/upFactory" method="post">
                <input type=text style="display:none" name="factoryId"
                       value="${factory1.factoryId}"
                />
             <%--   <p><span> 状   态：</span><span><input  type="text" name="state" value="${factory1.state }"></span></p>
                <p><span> 类   型：</span><span><input  type="text" name="ctype" value="${factory1.ctype }" ></span></p>
                <p><span>厂家全称：</span><span><input  type="text" name="fullName" value="${factory1.fullName }"></span></p>
                <p><span>名称缩写：</span><span><input  type="text" name="factoryName" value="${factory1.factoryName }"></span></p>
                <p><span>联 系 人：</span><span><input  type="text" name="contacts" value="${factory1.contacts }"></span></p>
                <p><span>电    话：</span><span><input  type="text" name="phone" value="${factory1.phone }"></span></p>
                <p><span>手    机：</span><span><input  type="text" name="mobile" value="${factory1.mobile }"></span></p>
                <p><span>传    真：</span><span><input  type="text" name="fax"  value="${factory1.fax }"></span></p>
                <p><span>说    明：</span><span><input  type="text" name="address"  value="${factory1.address }"></span></p>
                <p><span>验 货 员：</span><span><input  type="text" name="inspector"  value="${factory1.inspector }"></span></p>
                <p><span>排 序 号：</span><span><input  type="text" name="orderNo"  value="${factory1.orderNo }"></span></p>
                <p><span>创 建 人：</span><span><input  type="text" name="createBy"  value="${factory1.createBy }"></span></p>
                <p><span>创建部门：</span><span><input  type="text" name="createDept"  value="${factory1.createDept }"></span></p>
                <p><span>创建日期：</span><span>
                    <input type="text" style="width:90px;" name="createTime"
                           onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
                </span></p>--%>

                <table>
                    <tr>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>状 态：<span><input  type="text" name="state"  value="${factory1.state }"></span></td>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>类 型：</span><span><input  type="text" name="ctype"  value="${factory1.ctype }"></span></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>厂 家 全 称：<span><input  type="text" name="fullName" value="${factory1.fullName }"></span></td>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>名 称 缩 写：</span><span><input  type="text" name="factoryName"  value="${factory1.factoryName }"></span></td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>联系人：<span><input  type="text" name="contacts" value="${factory1.contacts }"></span></td>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>电话：<span><input  type="text" name="phone" value="${factory1.phone }"></span></td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>手 机：<span><input  type="text" name="mobile" value="${factory1.mobile }"></span></td>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>传 真：<span><input  type="text" name="fax"  value="${factory1.fax }"></span></td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>创 建 部 门：<span><input  type="text" name="createDept" value="${factory1.createDept }"></span></td>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>验 货 员：<span><input  type="text" name="inspector"  value="${factory1.inspector }"></span></td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>排 序 号：<span><input  type="text" name="orderNo" value="${factory1.orderNo }"></span></td>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>创 建 人：</span><span><input  type="text" name="createBy" value="${factory1.createBy }"></span></td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        <td>创 建 日 期：<span>
                    <input type="text" style="" name="createTime"
                           value="<fmt:formatDate value='${factory.createTime}' pattern='yyyy-MM-dd' />"
                           onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
                </span></td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                    </tr>

                    <tr>
                        <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                        说明:<td> <textarea rows="7" cols="30"  name="address">${factory1.address }</textarea></td>
                    </tr>


                </table>




                <input type=text style="display:none" name="updateTime"
                       value="<%=date%>"
                />
                <input  type="submit" value="确定"/>
        </form>
        <hr/>
        <a href="/basicinfo/factoryActionlist_list">
            <button>返回</button>
        </a>

    </div>
</div>


</body>
</html>

