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
    .baseinfo{
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
        <div class="panel_icon"><img src="${ctx}/skin/default/images/icon/document_into.png" /></div>
        <div class="panel-header">
        <div class="panel-title">基础代码管理</div>
        <div class="panel-content">
			<div class="baseinfo">
           <!-- 当jsp页面碰到shiro标签时就执行AuthRealm中授权方法 -->
           <shiro:hasPermission name="商品信息">
	         <span id="topmenu" onclick="toModule('product/productList');">
					<a href="${pageContext.request.contextPath}/product/productList" id="aa_1"onclick="linkHighlighted(this)" target="main">商品信息</a>
	         </span>
           </shiro:hasPermission>
            </div>
            <div class="baseinfo">
           <shiro:hasPermission name="厂家信息">
	         <span id="topmenu" onclick="toModule('basicinfo/factoryActionlist_list');">
				<a href="${pageContext.request.contextPath}/basicinfo/factoryActionlist_list" onclick="linkHighlighted(this)" target="main" id="aa_2">厂家信息</a>
	         </span>
           </shiro:hasPermission>
            </div>
			 <%@include file="../leftmenu.jsp" %> 
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
