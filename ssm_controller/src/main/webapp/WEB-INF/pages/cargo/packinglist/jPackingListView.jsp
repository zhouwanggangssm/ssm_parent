<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script type="text/javascript" src="${ctx }/js/datepicker/WdatePicker.js"></script>
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
<ul>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
   浏览装箱单
  </div>
  

 
    <div>
		<table class="commonTable" cellspacing="1">
	       
	        <tr>
	            <td class="columnTitle">卖方：</td>
	            <td class="tableContent">${packingList.seller}</td>
	       
	            <td class="columnTitle">买方：</td>
	            <td class="tableContent">${packingList.buyer}</td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">发票号：</td>
	            <td class="tableContent">${packingList.invoiceNo}</td>
	        
	            <td class="columnTitle">发票日期：</td>
	            <td class="tableContent">
					<fmt:formatDate value='${packingList.invoiceDate }' pattern='yyyy-MM-dd' />
				</td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">唛头：</td>
	            <td class="tableContent">${packingList.marks}</td>
	       
	            <td class="columnTitle">描述：</td>
	            <td class="tableContent">${packingList.descriptions}</td>
	        </tr>	
	        
	        <tr>
	            <td class="columnTitle">状态：</td>
	            <td class="tableContent">
	           		<c:if test="${packingList.state==0}">草稿</c:if>
					<c:if test="${packingList.state==1}"><b><font color="green">已上报</font></b></c:if>
					<c:if test="${packingList.state==2}"><b><font color="green">已委托</font></b></c:if>
	            </td>
	        </tr>	
	       
		</table>
	</div>
	<div class="textbox-header">
		<div class="textbox-inner-header">
			<div class="textbox-title">
				相关报运单
			</div>
		</div>
	</div>

	<div class="listTablew">
		<div style="float:left;padding:8px;">
			${divData}
		</div>
	</div>
 
</form>
</body>
</html>

