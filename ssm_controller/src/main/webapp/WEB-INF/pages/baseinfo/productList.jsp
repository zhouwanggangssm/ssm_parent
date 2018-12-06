<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;" charset="utf-8">
    <title></title>
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="../../skin/default/css/default.css" media="all" />
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="../../css/extreme/extremecomponents.css" />
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="../../css/extreme/extremesite.css" />

    <script type="text/javascript" src="../../js/common.js"></script>
</head>
<style>

</style>
<body >
        <div id="menubar">
            <div id="middleMenubar">
                <div id="innerMenubar">
                    <div id="navMenubar">
                        <ul>
                            <li id="view"><a href="#"   methods="post" onclick="formSubmit('/product/listProductId','_self');this.blur();">查看</a></li>
                            <li id="new"><a href="/product/tzadd">新建</a></li>
                            <li id="update"><a href="#" methods="post" onclick="formSubmit('/product/selectp','_self');this.blur();">修改</a></li>
                            <li id="delete"><a href="#" methods="post" onclick="formSubmit('/product/detproduct','_self');this.blur();">删除</a></li>

                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <!-- 页面主体部分（列表等） -->
        <div class="textbox" id="centerTextbox">
            <div class="textbox-header">
                <div class="textbox-inner-header">
                    <div class="textbox-title">
                        <h2>商品列表</h2>
                    </div>
                </div>
            </div>


            <form action="/product/productList" method="post">
                <input type="hidden" name="_method" value="delete" />
         <input type="hidden" name="pageIndex" value="1"/>
<span class="noprint">

<div id="find_div" style="width:98%;">


    </fieldset>
    <legend><font color="000">查询条件&nbsp;</font></legend>
    <div style="width:98%;padding-top:7px;text-align:left;">

        编号：
        <input type="text" name="id" value="" size="20"
        />
        厂家名称：
        <input type="text" name="factoryName" value="" size="20"
        />
        <input id="btnFind" type="submit" name="查询" value="查询">

        <input type="button" name="清空" value="清空" onclick="findReset();this.blur();">

    </div>
    </fieldset>

</div>
</span>
                <div>

                    <div class="eXtremeTable" >
                        <table id="ec_table"  border="0"  cellspacing="0"  cellpadding="0"  class="tableRegion"  width="98%" >

                            <tr>
                                <td class="tableHeader" >
                                    <input type="checkbox"  id="productId"  name="productId"  onclick="checkAll('productId',this)" ></td>
                                <td class="tableHeader" >编号</td>
                                <td class="tableHeader" >描述</td>
                                <td class="tableHeader" >厂家简称</td>
                                <td class="tableHeader" >市场价</td>
                                <td class="tableHeader" >颜色</td>
                                <td class="tableHeader" >数量</td>
                                <td class="tableHeader" >体积</td>
                                <td class="tableHeader" >描述</td>
                                <td class="tableHeader" >创建人</td>
                                <td class="tableHeader">操作</td>
                            </tr>

                            <c:forEach var="listpro" items="${listpro}" >
                                <tr class="odd"  onmouseover="this.className='highlight'"  onmouseout="this.className='odd'" >
                                    <td>
                                        <input type="checkbox"  name="productId" value="${listpro.productId}"/>
                                    </td>
                                    <td>${listpro.productNo}</td>
                                    <td>${listpro.description}</td>
                                    <td>${listpro.factoryName}</td>
                                    <td>${listpro.price}</td>
                                    <td>${listpro.color}</td>
                                    <td>${listpro.qty}</td>
                                    <td>${listpro.cbm}</td>
                                    <td>${listpro.remark}</td>
                                    <td>${listpro.createBy}</td>

                                </tr>
                            </c:forEach>
                        </table>
                    </div>

                </div>

                <input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
                <c:import url="../../pages/rollpage.jsp">
                    <c:param name="totalCount" value="${totalCount}"/>
                    <c:param name="currentPageNo" value="${currentPageNo}"/>
                    <c:param name="totalPageCount" value="${totalPageCount}"/>
                </c:import>

        </div>
    </form>
</div>

</body>
</html>


