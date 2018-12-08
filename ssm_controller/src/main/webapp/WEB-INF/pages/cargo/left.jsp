<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../baselist.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<shiro:hasRole name="user"></shiro:hasRole>
<head>
    <title></title>
    <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx}/skin/default/css/left.css" media="all"/>


	<style type="text/css">
		.cargo{
			margin-top: 10px;
		}
	</style>
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
           <!-- 当jsp页面碰到shiro标签时就执行AuthRealm中授权方法 -->
			<div class="cargo">
                    <shiro:hasPermission name="购销合同">
						<span id="topmenu" onclick="toModule('cargo/contractAction_list');">
					         <a href="${ctx}/cargo/contract_list" onclick="linkHighlighted(this)" target="main" id="aa_1">购销合同</a>
						</span>
					</shiro:hasPermission>
				</div>
			<div class="cargo">
                    <shiro:hasPermission name="出货表">
						<span id="topmenu" onclick="toModule('cargo/outProduct_toedit');">
					<a href="${ctx}/cargo/outProduct_toedit" onclick="linkHighlighted(this)" target="main" id="aa_1">出货表</a>
						</span>
                   </shiro:hasPermission>
				</div>
					<div class="cargo">
                   <shiro:hasPermission name="出口报运">
					   <span id="topmenu" onclick="toModule('cargo/export_List');">
					<a href="${ctx}/cargo/export_List" onclick="linkHighlighted(this)" target="main" id="aa_1">出口报运</a>
				       </span>
				   </shiro:hasPermission>
					</div>
			<div class="cargo">
                   <shiro:hasPermission name="合同管理">
	                   <span id="topmenu" onclick="toModule('cargo/export_contractlist');">
					<a href="${ctx}/cargo/export_contractlist" onclick="linkHighlighted(this)" target="main" id="aa_1">合同管理</a>
				       </span>
				   </shiro:hasPermission>
				</div>
			<div class="cargo">
                   <shiro:hasPermission name="装箱">
	                  <span id="topmenu" onclick="toModule('cargo/packinglist_packing_list');">
					<a href="${ctx}/cargo/packinglist_packing_list" onclick="linkHighlighted(this)" target="main" id="aa_1">装箱</a>
				      </span>
				   </shiro:hasPermission>
				</div>
			<div class="cargo">
                   <shiro:hasPermission name="委托">
	               <span id="topmenu" onclick="toModule('cargo/jshipping_list');">
					<a href="${ctx}/cargo/jshipping_list" onclick="linkHighlighted(this)" target="main" id="aa_1">委托</a>
				   </span>
				</shiro:hasPermission>
				</div>
			<div class="cargo">
                <shiro:hasPermission name="发票">
	            <span id="topmenu" onclick="toModule('cargo/invoice_list');">
					<a href="${ctx}/cargo/invoice_list" onclick="linkHighlighted(this)" target="main" id="aa_1">发票</a>
                    </span>
                </shiro:hasPermission>
				</div>
			<div class="cargo">
                <shiro:hasPermission name="财务">
	            <span id="topmenu" onclick="toModule('cargo/finance_list');">
					<a href="${ctx}/cargo/finance_list" onclick="linkHighlighted(this)" target="main" id="aa_1">财务</a>
				</span>
				</shiro:hasPermission>
				</div>
			<div class="cargo">
                <shiro:hasPermission name="历史购销合同">
	            <span id="topmenu" onclick="toModule('cargo/contracthis/list');">
					<a href="${ctx}/cargo/contracthis/list" onclick="linkHighlighted(this)" target="main" id="aa_1">历史购销合同</a>
				</span>
				</shiro:hasPermission>
				</div>
			<div class="cargo">
                <shiro:hasPermission name="WS出口报运单">
	            <span id="topmenu" onclick="toModule('cargo/export_toedit');">
					<a href="${ctx}/cargo/export_toedit" onclick="linkHighlighted(this)" target="main" id="aa_1">WS出口报运单</a>
				</span>
				</shiro:hasPermission>
				</div>
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
