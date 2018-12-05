<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
	             <input type="hidden" name="pageIndex" value="1"/>
<ul>
<li id="view"><a href="#" onclick="formSubmit('/module/findmodulebyid','_self');this.blur();">查看</a></li>
<li id="new"><a href="#" onclick="formSubmit('/module/addmoduleUI','_self');this.blur();">新增</a></li>
<li id="update"><a href="#" onclick="formSubmit('/module/updateModuleUI','_self');this.blur();">修改</a></li>
<li id="delete"><a href="#" onclick="formSubmit('/module/deleteModule','_self');this.blur();">删除</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">
    模块列表
  </div> 
  </div>
  </div>
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">模块名</td>
		<td class="tableHeader">层数</td>
		<td class="tableHeader">权限标识</td>
		<td class="tableHeader">链接</td>
		<td class="tableHeader">类型</td>
		<td class="tableHeader">从属</td>
		<td class="tableHeader">状态</td>
	</tr>
	</thead>
	<tbody class="tableBody" >

	<c:forEach items="${moduleList}" var="m" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" align="left">
		<td><input type="checkbox" name="id" value="${m.moduleId}"/></td>
		<td>${(currentPageNo-1)*pageSize+status.count}</td>
		<td><a href="/module/findmodulebyid?id=${m.moduleId}">${m.parentName}</a></td>
		<td>${m.layerNum}</td>
		<td>${m.cpermission}</td>
		<td>${m.curl}</td>
		<td>${m.ctype}</td>
		<td>${m.belong}</td>
		<td>${m.state}</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
	<input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
	<c:import url="../../rollpage.jsp">
		<c:param name="totalCount" value="${totalCount}"/>
		<c:param name="currentPageNo" value="${currentPageNo}"/>
		<c:param name="totalPageCount" value="${totalPageCount}"/>
	</c:import>
</div>
 
</div>
 
</div>
</form>
</body>
</html>

