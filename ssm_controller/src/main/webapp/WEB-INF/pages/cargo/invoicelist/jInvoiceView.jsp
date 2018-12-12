<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<script type="text/javascript" src="${ctx }/js/datepicker/WdatePicker.js"></script>
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
   浏览发票
  </div>
  

 
    <div>
		<table class="commonTable" cellspacing="1">
	      	
	        <tr>
	            <td class="columnTitle">发票号：</td>
	            <td class="tableContent">${invoice.scNo}</td>
	        
	            <td class="columnTitle">提单号：</td>
	            <td class="tableContent">${invoice.blNo}</td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">交易条款：</td>
	            <td class="tableContent">${invoice.tradeTerms}</td>
	       
	            <td class="columnTitle">发票时间：</td>
	            <td class="tableContent"><fmt:formatDate value="${invoice.createTime}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
	        </tr>
	        <tr>
	            <td class="columnTitle">委托单号：</td>
	            <td class="tableContent">${invoice.invoiceId}</td>
	       
	       		<td class="columnTitle">状态：</td>
				<td>
					<c:if test="${invoice.state==0}"><font color="grey">草稿</font></c:if>
					<c:if test="${invoice.state==1}"><font color="green">已提交</font></c:if>
				</td>
			</tr>
		</table>
	</div>
 
 
</form>
</body>
</html>

