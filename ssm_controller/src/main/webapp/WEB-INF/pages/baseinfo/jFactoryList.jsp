
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="../../skin/default/css/default.css" media="all" />
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="../../css/extreme/extremecomponents.css" />
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="../../css/extreme/extremesite.css" />
    <script type="text/javascript" src="../../js/common.js"></script>
</head>
<style type="text/css">
    #new1{
        border: solid 1px #000;
        background-color: #a6caf0;
        margin-bottom: 10px;
        height: 15px;
        width: 30px;
    }
    #new2{
        border: solid 1px #000;
        background-color: #a6caf0;
    }

</style>

<body>
<%--+++++++--%>

    <div id="menubar">
        <div id="middleMenubar">
            <div id="innerMenubar">
                <div id="navMenubar">
                    <ul>
                        <li id="view"><a href="#"   methods="post" onclick="formSubmit('/basicinfo/selectFactoryId','_self');this.blur();">查看</a></li>
                        <li id="new"><a href="/basicinfo/goadd">新建</a></li>
                        <li id="update"><a href="#" methods="post" onclick="formSubmit('/basicinfo/upFactoryId','_self');this.blur();">修改</a></li>
                        <li id="delete"><a href="#" onclick="formSubmit('/basicinfo/deleFactryID','_self');this.blur();">删除${outt}</a></li>
                        <li id="new1"><a href="#" onclick="formSubmit('/basicinfo/upType?state=1','_self');this.blur();">启用</a></li>
                        <li id="new2"><a href="#" onclick="formSubmit('/basicinfo/upType?state=0','_self');this.blur();">停止</a></li>

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
                    <h2>厂家列表</h2>
                </div>
            </div>
        </div>

 <form action="/basicinfo/factoryActionlist_list" method="post">
     <input type="hidden" name="pageIndex" value="1"/>
<span class="noprint">

<div id="find_div" style="width:98%;">


        </fieldset>
        <legend><font color="000">查询条件&nbsp;</font></legend>
        <div style="width:98%;padding-top:7px;text-align:left;">

            联系人内容：
            <input type="text" name="text" value="" size="20"

            />
           厂家内容：
           <input type="text" name="f_type" value="" size="20"

           />
            <input id="btnFind" type="submit" name="查询" value="查询">

            <input type="button" name="清空" value="清空" onclick="findReset();this.blur();">

        </div>
        </fieldset>

</div>
</span>
            <div>
                <div>
                    <input type="hidden"  name="ec_i"  value="ec" />
                    <input type="hidden"  name="ec_eti" />
                    <input type="hidden"  name="ec_ev" />
                    <input type="hidden"  name="ec_efn" />
                    <input type="hidden"  name="ec_crd"  value="10" />
                    <input type="hidden"  name="ec_p"  value="1" />
                </div>
                <div class="eXtremeTable" >
                    <table id="ec_table"  border="0"  cellspacing="0"  cellpadding="0"  class="tableRegion"  width="98%" >
                        <thead>
                        <tr style="padding: 0px;" >
                            <td colspan="10" >
                                <table border="0"  cellpadding="0"  cellspacing="0"  width="100%" >
                                    <tr>

                                        <td class="compactToolbar"  align="right" >
                                            <table border="0"  cellpadding="1"  cellspacing="2" >
                                                <tr>

                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>

                        <tr>
                            <td class="tableHeader" ><input type="checkbox"  id="id_selector"  name="id_selector"  title="(Un)Select All"  onclick="for(i = 0; i < document.getElementsByName('id').length; i++)document.getElementsByName('id').item(i).checked=document.getElementById('id_selector').checked;" ></td>
                            <td class="tableHeader"  style="text-align: center" >状态</td>
                            <td class="tableHeader" >类型</td>
                            <td class="tableHeader" >厂家全称</td>
                            <td class="tableHeader" >简称</td>
                            <td class="tableHeader" >联系人</td>
                            <td class="tableHeader" >联系电话</td>
                            <td class="tableHeader" >手机</td>
                            <td class="tableHeader" >传真</td>
                            <td class="tableHeader" >验货员</td>
                        </tr>
                        </thead>
                        <tbody class="tableBody" >

                            <c:forEach var="list" items="${list}" >
                                <tr class="odd"  onmouseover="this.className='highlight'"  onmouseout="this.className='odd'" >
                                    <td>
                                        <input type="checkbox" name="factoryId" dataType="复选框" dispName="厂家管理" minSelect="1"  value="${list.factoryId}"/>

                                    </td>
                                    <td style="text-align: center" >${list.state}</td>
                                    <td>${list.ctype }</td>
                                    <td>
                                            ${list.fullName}
                                    </td>
                                    <td>${list.factoryName}</td>
                                    <td>${list.contacts}</td>
                                    <td>${list.phone}</td>
                                    <td>${list.mobile}</td>
                                    <td>${list.fax}</td>
                                    <td>${list.inspector}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

            </div>

     <input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
     <c:import url="../../pages/rollpage.jsp">
         <c:param name="totalCount" value="${totalCount}"/>
         <c:param name="currentPageNo" value="${currentPageNo}"/>
         <c:param name="totalPageCount" value="${totalPageCount}"/>
     </c:import>

 </form>
</div>

</body>
</html>
