<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../baselist.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx}/skin/default/css/left.css" media="all"/>
</head>
 
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
        <div class="panel_icon"><img src="${ctx}/skin/default/images/icon/components.png"/></div>
        <div class="panel-header">
        <div class="panel-title">货运管理</div>
        <div class="panel-content">
			<ul>
				<li><a href="${ctx}/cargo/contract_list" onclick="linkHighlighted(this)" target="main" id="aa_1">购销合同</a></li>
				<li><a href="${ctx}/cargo/outProduct_toedit" onclick="linkHighlighted(this)" target="main" id="aa_1">出货表</a></li>
				<li><a href="${ctx}/cargo/export_List" onclick="linkHighlighted(this)" target="main" id="aa_1">出口报运</a></li>
				<li><a href="${ctx}/cargo/export_contractlist" onclick="linkHighlighted(this)" target="main" id="aa_1">合同管理</a></li>
				<li><a href="${ctx}/cargo/packinglist_packing_list" onclick="linkHighlighted(this)" target="main" id="aa_1">装箱</a></li>
				<li><a href="${ctx}/cargo/jshipping_list" onclick="linkHighlighted(this)" target="main" id="aa_1">委托</a></li>
				<li><a href="${ctx}/cargo/invoice_list" onclick="linkHighlighted(this)" target="main" id="aa_1">发票</a></li>
				<li><a href="${ctx}/cargo/finance_list" onclick="linkHighlighted(this)" target="main" id="aa_1">财务</a></li>
				<li><a href="${ctx}/cargo/contracthis/list" onclick="linkHighlighted(this)" target="main" id="aa_1">历史购销合同</a></li>
				<li><a href="${ctx}/cargo/export_toedit" onclick="linkHighlighted(this)" target="main" id="aa_1">WS出口报运单</a></li>
			</ul>
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


</body>
</html>
