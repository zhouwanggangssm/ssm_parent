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
   浏览财务报运单
  </div>
  

 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">海运/空运：</td>
	            <td class="tableContent">${sOd.orderType }</td>
	  
	            <td class="columnTitle">货主：</td>
	            <td class="tableContent">${sOd.shipper }</td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">提单抬头：</td>
	            <td class="tableContent">${sOd.consignee }</td>
	           
	            <td class="columnTitle">正本通知人：</td>
	            <td class="tableContent">${sOd.notifyParty }</td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">信用证：</td>
	            <td class="tableContent">${sOd.lcNo }</td>
	            <td class="columnTitle">装运港：</td>
	            <td class="tableContent">${sOd.portOfLoading }</td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">转船港：</td>
	            <td class="tableContent">${sOd.portOfTrans }</td>
	            <td class="columnTitle">卸货港：</td>
	            <td class="tableContent">${sOd.portOfDischarge }</td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">装期：</td>
	            <td class="tableContent">
					<fmt:formatDate value='${sOd.loadingDate }' pattern='yyyy-MM-dd' /></td>
	            <td class="columnTitle">效期：</td>
	            <td class="tableContent">
					<fmt:formatDate value='${sOd.limitDate }' pattern='yyyy-MM-dd' /></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">是否分批：</td>
	            <td class="tableContentAuto">
	           ${sOd.isBatch==1?'是':'否' }
	            </td>
	            <td class="columnTitle">是否转船：</td>
	            <td class="tableContentAuto">${sOd.isTrans==1?'是':'否' }
	            </td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">份数：</td>
	            <td class="tableContent">${sOd.copyNum }</td>
	            <td class="columnTitle">扼要说明：</td>
	            <td class="tableContent">${sOd.remark }</td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">运输要求：</td>
	            <td class="tableContent">${sOd.specialCondition }</td>
	            <td class="columnTitle">运费说明：</td>
	            <td class="tableContent">${sOd.freight }</td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">复核人：</td>
	            <td class="tableContent">${sOd.checkBy }</td>
	        </tr>	
		</table>
	</div>
 
 
</form>
</body>
</html>

