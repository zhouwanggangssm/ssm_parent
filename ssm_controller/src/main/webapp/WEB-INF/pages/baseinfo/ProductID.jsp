
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2018/11/29
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<title></title>

</head>
<%
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    String date= format.format(new Date());
%>
<body>
<div>
    <form action="/product/productList" method="post">


        <table>
            <tr>
                <td>编 号:<span style="background-color: #218c7e">${list1.productId}</span></td>

                <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                <td>厂 家 简 称:<span style="background-color: #218c7e">${list1.factoryName}</span></td>
            </tr>
            <tr>
                <td>&nbsp;</td> <td>&nbsp;</td>
            </tr>

            <tr>


            </tr>

            <tr>
                <td>&nbsp;</td> <td>&nbsp;</td>
            </tr>

            <tr>
                <td>尺 寸 长:<span style="background-color: #218c7e">${list1.sizeLenght}</span></td>
                <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                <td>尺 寸 宽:<span style="background-color: #218c7e">${list1.sizeWidth}</span></td>
                <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                <td>尺 寸 高:<span style="background-color: #218c7e">${list1.sizeHeight}</span></td>
            </tr>

            <tr>
                <td>&nbsp;</td> <td>&nbsp;</td>
            </tr>

            <tr>
                <td>颜 色:<span style="background-color: #218c7e">${list1.color}</span></td>
                <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                <td>包装:<span style="background-color: #218c7e">${list1.packing}</span></td>
            </tr>

            <tr>
                <td>&nbsp;</td> <td>&nbsp;</td>
            </tr>

            <tr>
                <td>包 装 单 位:<span style="background-color: #218c7e">${list1.packingUnit}</span></td>
                <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                <td>市 场 价:<span style="background-color: #218c7e">${list1.price}</span></td>
            </tr>

            <tr>
                <td>&nbsp;</td> <td>&nbsp;</td>
            </tr>

            <tr>
                <td>集装箱 类别 20:<span style="background-color: #218c7e">${list1.type20}</span></td>
                <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                <td>集装箱 类别 40:<span style="background-color: #218c7e">${list1.type40}</span></td>
                <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                <td>集装箱 类别 40HC:<span style="background-color: #218c7e">${list1.type40hc}</span></td>
            </tr>

            <tr>
                <td>&nbsp;</td> <td>&nbsp;</td>
            </tr>

            <tr>
                <td>数 量:<span style="background-color: #218c7e">${list1.qty}</span></td>
                <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                <td>体 积:<span style="background-color: #218c7e">${list1.cbm}</span></td>
            </tr>

            <tr>
                <td>&nbsp;</td> <td>&nbsp;</td>
            </tr>

            <tr>
                <td>大箱 尺寸 长:<span style="background-color: #218c7e">${list1.mpsizeLenght}</span></td>
                <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                <td>大箱 尺寸 宽:<span style="background-color: #218c7e">${list1.mpsizeWidth}</span></td>
                <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                <td>大箱 尺寸 高:<span style="background-color: #218c7e">${list1.mpsizeHeight}</span></td>
            </tr>

            <tr>
                <td>&nbsp;</td> <td>&nbsp;</td>
            </tr>

            <tr>
                <td>创 建 人:<span style="background-color: #218c7e">${list1.createBy}</span></td>
                <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                <td>创 建 部 门:<span style="background-color: #218c7e">${list1.createDept}</span></td>
            </tr>

            <tr>
                <td>&nbsp;</td> <td>&nbsp;</td>
            </tr>

            <tr>
                <td>创 建 日 期：<span style="background-color: #218c7e"><fmt:formatDate value="${list1.createTime}" pattern="yyyy-MM-dd"/></span></td>
                <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                <td>录 入 日 期：<span style="background-color: #218c7e"><fmt:formatDate value="${list1.inputTime}" pattern="yyyy-MM-dd"/></span></td>
            </tr>

            <tr>
                <td>&nbsp;</td> <td>&nbsp;</td>
            </tr>

            <tr>
                <td> 备注:<textarea rows="7" cols="30">${list1.remark}</textarea></td>
                <td>&nbsp;</td> <td>&nbsp;</td>

                <td>描 述:<textarea rows="7" cols="30">${list1.description}</textarea></td>

            </tr>
            <tr>
                <td>&nbsp;</td> <td>&nbsp;</td>
            </tr>

            <tr>

                <td>&nbsp;</td> <td>&nbsp;</td> <td>&nbsp;</td>
                <td>照 片:<%--<span style="background-color: #218c7e">${list1.productImage}</span>--%>
                    <img src="/images/${fileUrl}" height="150" width="200" />

            </td>
            </tr>



        </table>
        <input  type="submit" value="返回"/>
    </form>
</div>
</body>
</html>
