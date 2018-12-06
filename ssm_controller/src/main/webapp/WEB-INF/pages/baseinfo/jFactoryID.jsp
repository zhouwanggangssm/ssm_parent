<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2018/11/20
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

</head>

<body>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>管理页面 >> 信息查看页面</span>
    </div>
    <div class="providerView">
        <table>
            <tr>
                <td>状 态：<span style="background-color: #218c7e">${factory.state }</span></td>
                <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                <td>类 型：<span style="background-color: #218c7e">${factory.ctype }</span></td>
            </tr>
            <tr>
                <td>&nbsp;</td> <td>&nbsp;</td>
            </tr>
            <tr>
                <td>厂 家 全 称：<span style="background-color: #218c7e">${factory.fullName}</span></td>
                <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                <td>名 称 缩 写：<span style="background-color: #218c7e">${factory.factoryName }</span></td>
            </tr>

            <tr>
                <td>&nbsp;</td> <td>&nbsp;</td>
            </tr>

            <tr>
                <td>联系人：<span style="background-color: #218c7e">${factory.contacts }</span></td>
                <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                <td>电话：<span style="background-color: #218c7e">${factory.phone }</span></td>
            </tr>

            <tr>
                <td>&nbsp;</td> <td>&nbsp;</td>
            </tr>

            <tr>
                <td>手 机：<span style="background-color: #218c7e">${factory.mobile}</span></td>
                <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                <td>传 真：<span style="background-color: #218c7e">${factory.fax}</span></td>
            </tr>

            <tr>
                <td>&nbsp;</td> <td>&nbsp;</td>
            </tr>

            <tr>
                <td>创 建 部 门：<span style="background-color: #218c7e">${factory.createDept}</span></td>
                <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                <td>验 货 员：<span style="background-color: #218c7e">${factory.inspector}</span></td>
            </tr>

            <tr>
                <td>&nbsp;</td> <td>&nbsp;</td>
            </tr>

            <tr>
                <td>排 序 号：<span style="background-color: #218c7e">${factory.orderNo}</span></td>
                <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                <td>创 建 人：<span style="background-color: #218c7e">${factory.createBy}</span></td>
            </tr>

            <tr>
                <td>&nbsp;</td> <td>&nbsp;</td>
            </tr>

            <tr>
                <td>创 建 日 期：<span style="background-color: #218c7e"><fmt:formatDate value="${factory.createTime}" pattern="yyyy-MM-dd"/></span></td>
            </tr>

            <tr>
                <td>&nbsp;</td> <td>&nbsp;</td>
            </tr>

            <tr>
                <td> <textarea rows="7" cols="30">${factory.address}</textarea></td>
            </tr>

        </table>
        <hr/>
        <a href="/basicinfo/factoryActionlist_list">
            <button>返回</button>
        </a>

    </div>
</div>


</body>
</html>

