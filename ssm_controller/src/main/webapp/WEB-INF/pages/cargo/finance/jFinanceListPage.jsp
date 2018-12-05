<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
</head>

<body>
<form name="icform" method="post">
	<input type="hidden" name="pageIndex" value="1"/>
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">

<ul>
<li id="view"><a href="#" onclick="formSubmit('/cargo/finance_toview','_self');this.blur();">查看</a></li>
<li id="new"><a href="#" onclick="formSubmit('/cargo/finance_tocreate','_self');this.blur();">新增</a></li>
<li id="update"><a href="#" onclick="formSubmit('/cargo/finance_toupdate','_self');this.blur();">修改</a></li>
<li id="delete"><a href="#" onclick="formSubmit('/cargo/finance_delete','_self');this.blur();">删除</a></li>
<li id="submit"><a href="#" onclick="formSubmit('/cargo/finance_submit','_self');this.blur();">提交</a></li>
<li id="new"><a href="#" onclick="formSubmit('/cargo/finance_cancel','_self');this.blur();">取消</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
    财务报运列表
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr align="left">
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('financeId',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">制单人</td>
		<td class="tableHeader">制单日期</td>
		<td class="tableHeader">状态</td>
		
	</tr>
	</thead>
	<tbody class="tableBody" align="left" >
${links}
	
	<c:forEach items="${results}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" align="center">
		<td><input type="checkbox" name="financeId" value="${o.financeId}"/></td>
		<td>${status.index+1}</td>
		<td>${o.inputBy}</td>
		<td>
			<fmt:formatDate value='${o.inputDate}' pattern='yyyy-MM-dd' />
		</td>
		<td><c:if test="${o.state==0}">草稿</c:if>
		<c:if test="${o.state==1}"><b><font color="green">已上报</font></b></c:if>
		</td>
		
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</div>
	<input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
	<c:import url="../../rollpage.jsp">
		<c:param name="totalCount" value="${totalCount}"/>
		<c:param name="currentPageNo" value="${currentPageNo}"/>
		<c:param name="totalPageCount" value="${totalPageCount}"/>
	</c:import>
</div>

</form>
</body>
</html>

