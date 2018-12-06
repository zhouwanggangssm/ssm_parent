

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
     <%--   <input type=text style="display:none" name="productId"  value="${list1.productId}"/>
        <p><span>编号:</span><span><input  type="text" name="productNo" value="${list1.productNo}"></span></p>
        <p><span>照片：</span><span><input  type="text" name="productImage" value="${list1.productImage}"></span></p>
        <p><span>描述：</span><span><input  type="text" name="description" value="${list1.description}"></span></p>
        <p><span>厂家简称：</span><span><input  type="text" name="factoryName"  value="${list1.factoryName}"></span></p>
        <p><span>市场价：</span><span><input  type="text" name="price"  value="${list1.price}"></span></p>
        <p><span>尺寸长：</span><span><input  type="text" name="sizeLenght"  value="${list1.sizeLenght}"></span></p>
        <p><span>尺寸宽：</span><span><input  type="text" name="sizeWidth"  value="${list1.sizeWidth}"></span></p>
        <p><span>尺寸高：</span><span><input  type="text" name="sizeHeight"  value="${list1.sizeHeight}"></span></p>
        <p><span>颜色：</span><span><input  type="text" name="color"  value="${list1.color}"></span></p>
        <p><span>包装：</span><span><input  type="text" name="packing"  value="${list1.packing}"></span></p>
        <p><span>包装单位：</span><span><input  type="text" name="packingUnit"  value="${list1.packingUnit}"></span></p>
        <p><span>集装箱类别20：</span><span><input  type="text" name="type20"  value="${list1.type20}"></span></p>
        <p><span>集装箱类别40：</span><span><input  type="text" name="type40"  value="${list1.type40}"></span></p>
        <p><span>集装箱类别40HC：</span><span><input  type="text" name="type40hc"  value="${list1.type40hc}"></span></p>
        <p><span>数量：</span><span><input  type="text" name="qty" value="${list1.qty}"></span></p>
        <p><span>体积：</span><span><input  type="text" name="cbm" value="${list1.cbm}"></span></p>
        <p><span>大箱尺寸长：</span><span><input  type="text" name="mpsizeLenght" value="${list1.mpsizeLenght}"></span></p>
        <p><span>大箱尺寸宽：</span><span><input  type="text" name="mpsizeWidth" value="${list1.mpsizeWidth}"></span></p>
        <p><span>大箱尺寸高：</span><span><input  type="text" name="mpsizeHeight" value="${list1.mpsizeHeight}"></span></p>
        <p><span>备注：</span><span><input  type="text" name="remark" value="${list1.remark}"></span></p>
        <p><span>创 建 人：</span><span><input  type="text" name="createBy" value="${list1.createBy}"></span></p>
        <p><span>创建部门：</span><span><input  type="text" name="createDept" value="${list1.createDept}"></span></p>--%>

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
