<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../base.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<shiro:hasRole name="user"></shiro:hasRole>
<head>
    <title></title>
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx}/skin/default/css/left.css" media="all"/>

	<script language="javascript" src="${ctx}js/common.js"></script>
	<script language="javascript" src="${ctx}/js/ajax/setFastMenu.js"></script>
	<script language="javascript" src="${ctx}/js/pngfix_map.js"></script>
	<script type="text/javascript" src="${ctx}/components/jquery-ui/jquery-1.2.6.js"></script>
	<script type="text/javascript" src="${ctx}/skin/default/js/toggle.js"></script>
</head>

<style type="text/css">
    .stat{
        margin-top: 10px;
    }
</style>
 
<body id="left_frame">
 
 
<!-- begin1  -->
<div id="sidebar" class="sidebar">
	<div class="sidebar_t">
		<div class="sidebar_t_l"></div>
		<div class="sidebar_t_c"></div>
		<div class="sidebar_t_r"></div>
	</div>
    <div class="panel">
    	<div class="panel_icon"><img src="${ctx}/skin/default/images/icon/document_chart.png" /></div>
        <div class="panel-header">
        <div class="panel-title">
		统计查询
        </div>
        
        <div class="panel-content">
			<!-- 当jsp页面碰到shiro标签时就执行AuthRealm中授权方法 -->
                <div class="stat">
					<shiro:hasPermission name="生产厂家销售情况">
					<span id="topmenu" onclick="toModule('stat/factorysale');">
					<a href="${ctx}/stat/factorysale" onclick="linkHighlighted(this)" target="main" id="aa_1">生产厂家销售情况</a>
					</span>
					</shiro:hasPermission>
                </div>
                <div class="stat">
					<shiro:hasPermission name="产品销售排行">
					<span id="topmenu" onclick="toModule('stat/productsale');">
					<a href="${ctx}/stat/productsale" onclick="linkHighlighted(this)" target="main" id="aa_1">产品销售排行</a>
				    </span>
					</shiro:hasPermission>
                </div>
                <div class="stat">
					<shiro:hasPermission name="系统访问压力图">
					<span id="topmenu" onclick="toModule('stat/onlineinfo');">
					<a href="${ctx}/stat/onlineinfo" onclick="linkHighlighted(this)" target="main" id="aa_1">系统访问压力图</a>
				    </span>
					</shiro:hasPermission>
                </div>
			<%-- <%@include file="../leftmenu.jsp" %> --%>
        </div>
    </div>
    </div>
    <div class="sidebar_t">
		<div class="sidebar_b_l"></div>
		<div class="sidebar_t_c"></div>
		<div class="sidebar_b_r"></div>
	</div>
</div>
<!-- end1 -->
 
</body>
</html>