<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
</head>

<body>
<form name="icform" method="post">
	<input type="hidden" name="roleId" value="${role.roleId}"/>
	<input type="hidden" id="moduleIds" name="moduleIds" value="" />
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('/role/addRoleModule','_self');this.blur();">保存</a></li>
<li id="back"><a href="#" onclick="formSubmit('/role/role_list','_self');this.blur();">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">
    配置 [${role.name}] 角色的模块
  </div> 
  </div>
  </div>
  
<div>


<div style="text-align:left">
	<c:forEach items="${moduleList}" var="o">
		<div style="padding:3px;">
		<input type="checkbox" name="moduleId" value="${o.moduleId}" class="input"
			<c:if test="${fn:contains(roleModuleStr,o.name)}">checked</c:if>
		>
		${o.name}
		</div>
	</c:forEach>
</div>
 
</div>

</div>
</form>
</body>
</html>

