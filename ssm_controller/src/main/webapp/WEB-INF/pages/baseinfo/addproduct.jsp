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

    <script>
        $(document).ready(function () {
            var time = new Date();
            var day = ("0" + time.getDate()).slice(-2);
            var month = ("0" + (time.getMonth() + 1)).slice(-2);
            var today = time.getFullYear() + "-" + (month) + "-" + (day);
            $('#date_info').val(today);
        })

    </script>


<body>
<div class="right">

    <div class="providerView" >
        <form action="/product/addprodct" method="post" enctype="multipart/form-data">


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
                        <input type="date" id="date_info2" style="display:none" name="createTime" />
                    </td>
                    <td>&nbsp;</td> <td>&nbsp;</td>
                    <td>录入日期：
                        <input type=text style="display:none" name="inputTime"
                               value="<%=date%>"
                        />
                        <input type="date" id="date_info" style="display:none" name="inputTime" />
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
<script>
    Date.prototype.format = function(format){
        var o = {
            "M+": this.getMonth() + 1, //month
            "d+": this.getDate(),
    //day
        </script>

</body>
</html>
</head>
<body>

</body>
</html>