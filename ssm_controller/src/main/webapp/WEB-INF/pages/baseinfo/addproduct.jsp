<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--
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

    <div class="providerView" >
        <form action="/product/addprodct" method="post" enctype="multipart/form-data">
            <%--<p><span>编号:</span><span><input  type="text" name="productNo"></span></p>
            <p><span>照片：</span><span><input  type="text" name="productImage"></span></p>
            <p><span>描述：</span><span><input  type="text" name="description"></span></p>
            <p><span>厂家简称：</span><span><input  type="text" name="factoryName"></span></p>
            <p><span>市场价：</span><span><input  type="text" name="price"></span></p>
            <p><span>尺寸长：</span><span><input  type="text" name="sizeLenght"></span></p>
            <p><span>尺寸宽：</span><span><input  type="text" name="sizeWidth"></span></p>
            <p><span>尺寸高：</span><span><input  type="text" name="sizeHeight"></span></p>
            <p><span>颜色：</span><span><input  type="text" name="color"></span></p>
            <p><span>包装：</span><span><input  type="text" name="packing"></span></p>
            <p><span>包装单位：</span><span><input  type="text" name="packingUnit"></span></p>
            <p><span>集装箱类别20：</span><span><input  type="text" name="type20"></span></p>
            <p><span>集装箱类别40：</span><span><input  type="text" name="type40"></span></p>
            <p><span>集装箱类别40HC：</span><span><input  type="text" name="type40hc"></span></p>
            <p><span>数量：</span><span><input  type="text" name="qty"></span></p>
            <p><span>体积：</span><span><input  type="text" name="cbm"></span></p>
            <p><span>大箱尺寸长：</span><span><input  type="text" name="mpsizeLenght"></span></p>
            <p><span>大箱尺寸宽：</span><span><input  type="text" name="mpsizeWidth"></span></p>
            <p><span>大箱尺寸高：</span><span><input  type="text" name="mpsizeHeight"></span></p>
            <p><span>备注：</span><span><input  type="text" name="remark"></span></p>
          &lt;%&ndash;  <p><span>录入时间：</span><span><input  type="text" name="inputTime"></span></p>&ndash;%&gt;
            <input type=text style="display:none" name="inputTime"
                   value="<%=date%>"
            />
            <p><span>创 建 人：</span><span><input  type="text" name="createBy"></span></p>
            <p><span>创建部门：</span><span><input  type="text" name="createDept"></span></p>
            <p><span>创建日期：</span><span>
                    <input type="text" style="width:90px;" name="createTime"
                           onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
                </span></p>--%>



            <table>
                <tr>
                    <td>编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 号:<span> <input  type="text" name="productNo"></span></td>
                    <td>&nbsp;</td> <td>&nbsp;</td>
                    <td>照 片 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:
                      <%--  <span><input  type="text" name="productImage"></span>--%>

                            <input type="file" name="fileName" />
                        <%--    <input type="submit" value="上 传" />--%>


                    </td>
                    <td>&nbsp;</td> <td>&nbsp;</td>
                    <td>
                        厂家名称:
                        <select name="factoryName" style="width:130px;heigh:30px;" dataType="下拉列表" >
                            <option value='' selected>--请选择--</option>
                            <c:forEach items="${Factory}" var="Factory">
                                <option value='${Factory.factoryName}'>${Factory.factoryName}</option>
                            </c:forEach>

                        </select>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td> <td>&nbsp;</td>
                </tr>

                <tr>
                    <td>&nbsp;尺 寸 长 :<span style="background-color: #218c7e"><span><input  type="text" name="sizeLenght"></span></span></td>
                    <td>&nbsp;</td> <td>&nbsp;</td>
                    <td>&nbsp;尺 寸 宽 :</span><span><input  type="text" name="sizeWidth"></span></td>
                    <td>&nbsp;</td> <td>&nbsp;</td>
                    <td>&nbsp;尺 寸 高 :</span><span><input  type="text" name="sizeHeight"></span></td>
                </tr>

                <tr>
                    <td>&nbsp;</td> <td>&nbsp;</td>
                </tr>

                <tr>
                    <td>颜&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 色:<span><input  type="text" name="color"></span></td>
                    <td>&nbsp;</td> <td>&nbsp;</td>
                    <td>包&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 装:<span><input  type="text" name="packing"></span></td>
                </tr>

                <tr>
                    <td>&nbsp;</td> <td>&nbsp;</td>
                </tr>

                <tr>
                    <td>包装单位:<span><input  type="text" name="packingUnit"></span></td>
                    <td>&nbsp;</td> <td>&nbsp;</td>
                    <td>&nbsp;市 场 价 :<span><input  type="text" name="price"></span></td>
                </tr>

                <tr>
                    <td>&nbsp;</td> <td>&nbsp;</td>
                </tr>

                <tr>
                    <td>装箱类别20:<span><input  type="text" name="type20"></span></td>
                    <td>&nbsp;</td> <td>&nbsp;</td>
                    <td>装箱类别40:<span><input  type="text" name="type40"></span></td>
                    <td>&nbsp;</td> <td>&nbsp;</td>
                    <td>装箱类别40HC:<span><input  type="text" name="type40hc"></span></td>
                </tr>

                <tr>
                    <td>&nbsp;</td> <td>&nbsp;</td>
                </tr>
                <tr>
                    <td>数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 量:<span><input  type="text" name="qty"></span></td>
                    <td>&nbsp;</td> <td>&nbsp;</td>
                    <td>体&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 积:<span><input  type="text" name="cbm"></span></td>
                </tr>

                <tr>
                    <td>&nbsp;</td> <td>&nbsp;</td>
                </tr>

                <tr>
                    <td>大箱尺长:<span><input  type="text" name="mpsizeLenght"></span></td>
                    <td>&nbsp;</td> <td>&nbsp;</td>
                    <td>大箱尺宽:<span><input  type="text" name="mpsizeWidth"></span></td>
                    <td>&nbsp;</td> <td>&nbsp;</td>
                    <td>大箱尺高:<span><input  type="text" name="mpsizeHeight"></span></td>
                </tr>

                <tr>
                    <td>&nbsp;</td> <td>&nbsp;</td>
                </tr>

                <tr>
                    <td>&nbsp;创 建 人 :<span><input  type="text" name="createBy"></span></td>
                    <td>&nbsp;</td> <td>&nbsp;</td>
                    <td>创建部门:<span><input  type="text" name="createDept"></span></td>
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
                    <td>备 注:<textarea rows="7" cols="30"></textarea></td>
                    <td>&nbsp;</td> <td>&nbsp;</td>

                    <td>描 述:<textarea rows="7" cols="30"></textarea></td>
                </tr>



            </table>
                <hr/>

            <input  type="submit" value="确定"/>
        </form>

        <a href="/product/productList">
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