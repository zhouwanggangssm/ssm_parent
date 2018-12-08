<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../baselist.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<shiro:hasRole name="user"></shiro:hasRole>
<head>
    <title></title>
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx}/skin/default/css/left.css" media="all"/>
</head>
<style type="text/css">
	.sysadmin{
		margin-top: 10px;
	}
</style>

<body id="left_frame">
<div class="PositionFrame_black" id="PositionFrame"></div>
 
 
<!-- begin1  -->
<div id="sidebar" class="sidebar">
	<div class="sidebar_t">
		<div class="sidebar_t_l"></div>
		<div class="sidebar_t_c"></div>
		<div class="sidebar_t_r"></div>
	</div>
        <div class="panel">
        <div class="panel_icon"><img src="${ctx}/skin/default/images/icon/user1_lock.png"/></div>
        <div class="panel-header">
        <div class="panel-title">权限管理</div>
        <div class="panel-content">
			<div class="sysadmin">
             <!-- 当jsp页面碰到shiro标签时就执行AuthRealm中授权方法 -->
             <shiro:hasPermission name="部门管理">
	             <span id="topmenu" onclick="toModule('dept/dept_list');">
					<a href="${ctx}/dept/dept_list" onclick="linkHighlighted(this)" target="main" id="aa_1">部门管理</a>
	             </span>
             </shiro:hasPermission>
			</div>
			<div class="sysadmin">
             <shiro:hasPermission name="用户管理">
	            <span id="topmenu" onclick="toModule('user/user_list');">
					<a href="${ctx}/user/user_list" onclick="linkHighlighted(this)" target="main" id="aa_1">用户管理</a>
	            </span>
             </shiro:hasPermission>
			</div>
			 <div class="sysadmin">
             <shiro:hasPermission name="角色管理">
	            <span id="topmenu" onclick="toModule('role/role_list');">
					<a href="${ctx}/role/role_list" onclick="linkHighlighted(this)" target="main" id="aa_1">角色管理</a>
	            </span>
             </shiro:hasPermission>
			 </div>
			 <div class="sysadmin">
             <shiro:hasPermission name="模块管理">
	             <span id="topmenu" onclick="toModule('module/module_list');">
	                <a href="${ctx}/module/module_list" onclick="linkHighlighted(this)" target="main" id="aa_1">模块管理</a>
		         </span>
             </shiro:hasPermission>
			 </div>
			<!-- 引入动态的菜单生成 -->
			<%-- <%@include file="../leftmenu.jsp" %>   --%>
        </div>
        </div>
    </div>
    <div class="sidebar_t">
		<div class="sidebar_b_l"></div>
		<div class="sidebar_t_c"></div>
		<div class="sidebar_b_r"></div>
	</div>  
</div>	


</body>
</html>
