

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
    <form action="/product/upProduct" method="post">
        <input type=text style="display:none" name="productId"  value="${list.productId}"/>
        <%--<p><span>编号:</span><span><input  type="text" name="productNo" value="${list.productNo}"></span></p>
        <p><span>照片：</span><span><input  type="text" name="productImage" value="${list.productImage}"></span></p>
        <p><span>描述：</span><span><input  type="text" name="description" value="${list.description}"></span></p>
        <p><span>厂家简称：</span><span><input  type="text" name="factoryName"  value="${list.factoryName}"></span></p>
        <p><span>市场价：</span><span><input  type="text" name="price"  value="${list.price}"></span></p>
        <p><span>尺寸长：</span><span><input  type="text" name="sizeLenght"  value="${list.sizeLenght}"></span></p>
        <p><span>尺寸宽：</span><span><input  type="text" name="sizeWidth"  value="${list.sizeWidth}"></span></p>
        <p><span>尺寸高：</span><span><input  type="text" name="sizeHeight"  value="${list.sizeHeight}"></span></p>
        <p><span>颜色：</span><span><input  type="text" name="color"  value="${list.color}"></span></p>
        <p><span>包装：</span><span><input  type="text" name="packing"  value="${list.packing}"></span></p>
        <p><span>包装单位：</span><span><input  type="text" name="packingUnit"  value="${list.packingUnit}"></span></p>
        <p><span>集装箱类别20：</span><span><input  type="text" name="type20"  value="${list.type20}"></span></p>
        <p><span>集装箱类别40：</span><span><input  type="text" name="type40"  value="${list.type40}"></span></p>
        <p><span>集装箱类别40HC：</span><span><input  type="text" name="type40hc"  value="${list.type40hc}"></span></p>
        <p><span>数量：</span><span><input  type="text" name="qty" value="${list.qty}"></span></p>
        <p><span>体积：</span><span><input  type="text" name="cbm" value="${list.cbm}"></span></p>
        <p><span>大箱尺寸长：</span><span><input  type="text" name="mpsizeLenght" value="${list.mpsizeLenght}"></span></p>
        <p><span>大箱尺寸宽：</span><span><input  type="text" name="mpsizeWidth" value="${list.mpsizeWidth}"></span></p>
        <p><span>大箱尺寸高：</span><span><input  type="text" name="mpsizeHeight" value="${list.mpsizeHeight}"></span></p>
        <p><span>备注：</span><span><input  type="text" name="remark" value="${list.remark}"></span></p>
        <p><span>创 建 人：</span><span><input  type="text" name="createBy" value="${list.createBy}"></span></p>
        <p><span>创建部门：</span><span><input  type="text" name="createDept" value="${list.createDept}"></span></p>--%>


        <table>
            <tr>
                <td>编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 号:<span> <input  type="text" name="productNo" value="${list.productNo}"> </span></td>
                <td>&nbsp;</td> <td>&nbsp;</td>
                <td>照 片 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:<span><input  type="text" name="productImage" value="${list.productImage}"></span></td>
                <td>&nbsp;</td> <td>&nbsp;</td>
                <td>
                    厂家名称:
                    <select name="factoryName" style="width:130px;heigh:30px;" dataType="下拉列表" >
                        <option value="" selected>${list.factoryName}</option>
                        <c:forEach items="${list2}" var="list2">
                            <option value='${list2.factoryName}'>${list2.factoryName}</option>
                        </c:forEach>

                    </select>
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td> <td>&nbsp;</td>
            </tr>

            <tr>
                <td>&nbsp;尺 寸 长 :<span style="background-color: #218c7e"><span><input  type="text" name="sizeLenght" value="${list.sizeLenght}"></span></span></td>
                <td>&nbsp;</td> <td>&nbsp;</td>
                <td>&nbsp;尺 寸 宽 :</span><span><input  type="text" name="sizeWidth" value="${list.sizeWidth}"></span></td>
                <td>&nbsp;</td> <td>&nbsp;</td>
                <td>&nbsp;尺 寸 高 :</span><span><input  type="text" name="sizeHeight" value="${list.sizeHeight}"></span></td>
            </tr>

            <tr>
                <td>&nbsp;</td> <td>&nbsp;</td>
            </tr>

            <tr>
                <td>颜&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 色:<span><input  type="text" name="color" value="${list.color}"></span></td>
                <td>&nbsp;</td> <td>&nbsp;</td>
                <td>包&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 装:<span><input  type="text" name="packing" value="${list.packing}"></span></td>
            </tr>

            <tr>
                <td>&nbsp;</td> <td>&nbsp;</td>
            </tr>

            <tr>
                <td>包装单位:<span><input  type="text" name="packingUnit" value="${list.packingUnit}"></span></td>
                <td>&nbsp;</td> <td>&nbsp;</td>
                <td>&nbsp;市 场 价 :<span><input  type="text" name="price" value="${list.price}"></span></td>
            </tr>

            <tr>
                <td>&nbsp;</td> <td>&nbsp;</td>
            </tr>

            <tr>
                <td>装箱类别20:<span><input  type="text" name="type20" value="${list.type20}"></span></td>
                <td>&nbsp;</td> <td>&nbsp;</td>
                <td>装箱类别40:<span><input  type="text" name="type40" value="${list.type40}"></span></td>
                <td>&nbsp;</td> <td>&nbsp;</td>
                <td>装箱类别40HC:<span><input  type="text" name="type40hc" value="${list.type40hc}"></span></td>
            </tr>

            <tr>
                <td>&nbsp;</td> <td>&nbsp;</td>
            </tr>
            <tr>
                <td>数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 量:<span><input  type="text" name="qty" value="${list.qty}"></span></td>
                <td>&nbsp;</td> <td>&nbsp;</td>
                <td>体&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 积:<span><input  type="text" name="cbm" value="${list.cbm}"></span></td>
            </tr>

            <tr>
                <td>&nbsp;</td> <td>&nbsp;</td>
            </tr>

            <tr>
                <td>大箱尺长:<span><input  type="text" name="mpsizeLenght" value="${list.mpsizeLenght}"></span></td>
                <td>&nbsp;</td> <td>&nbsp;</td>
                <td>大箱尺宽:<span><input  type="text" name="mpsizeWidth" value="${list.mpsizeWidth}"></span></td>
                <td>&nbsp;</td> <td>&nbsp;</td>
                <td>大箱尺高:<span><input  type="text" name="mpsizeHeight" value="${list.mpsizeHeight}"></span></td>
            </tr>

            <tr>
                <td>&nbsp;</td> <td>&nbsp;</td>
            </tr>

            <tr>
                <td>&nbsp;创 建 人 :<span><input  type="text" name="createBy" value="${list.createBy}"></span></td>
                <td>&nbsp;</td> <td>&nbsp;</td>
                <td>创建部门:<span><input  type="text" name="createDept" value="${list.createDept}"></span></td>
            </tr>

            <tr>
                <td>&nbsp;</td> <td>&nbsp;</td>
            </tr>

            <tr>
                <td>创建日期 ：
                    <input type=text style="display:none" name="createTime"
                           value="<%=date%>"
                    />
                </td>
                <td>&nbsp;</td> <td>&nbsp;</td>
                <td>录入日期：
                    <input type=text style="display:none" name="inputTime"
                           value="<%=date%>"
                    />
                </td>
            </tr>

            <tr>
                <td>&nbsp;</td> <td>&nbsp;</td>
            </tr>

            <tr>
                <td>备 注:<textarea rows="7" cols="30" name="remark">${list.remark}</textarea></td>
                <td>&nbsp;</td> <td>&nbsp;</td>

                <td>描 述:<textarea rows="7" cols="30" name="description">${list.description}</textarea></td>
            </tr>



        </table>




    <input  type="submit" value="确定"/>
</form>
</div>
</body>
</html>
