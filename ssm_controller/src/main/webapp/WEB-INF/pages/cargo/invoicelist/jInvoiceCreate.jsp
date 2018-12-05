<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>发票管理</title>
		
</head>

<body>
<form name="icform" method="post">
	<input type="hidden" name="pageIndex" value="1"/>
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('/cargo/invoice_insert','_self');this.blur();">保存</a></li>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
   新增发票
  </div>
    <div>
    
    <table class="commonTable" cellspacing="1">
	        <tr>
	             <td class="columnTitle">发票号：</td>
	            <td class="tableContent"><input type="text" name="blNo" value=""/></td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">贸易条款：</td>
	            <td class="tableContent"><input type="text" name="tradeTerms" value=""/></td>
	        </tr>		

		</table>
		<div>
		<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"></td>
		<td class="tableHeader">序号</td>
		<!-- <td class="tableHeader">报运号</td>
		<td class="tableHeader">货物数/附件数</td>
		<td class="tableHeader">信用证号</td>
		<td class="tableHeader">收货人及地址</td>
		<td class="tableHeader">装运港</td>
		<td class="tableHeader">目的港</td>
		<td class="tableHeader">运输方式</td> -->
		<td class="tableHeader">正本通知人</td>
		<td class="tableHeader">货主</td>
		<td class="tableHeader">信用号</td>
	</tr>
	</thead>
	<tbody class="tableBody" >

	
	<c:forEach items="${invoiceList}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="radio" name="invoiceId" value="${o.shippingOrderId}"/></td>
		<td>${status.index+1}</td>
		<td>${o.notifyParty}</td>
		<td>${o.shipper}</td>
		<td>${o.lcNo}</td>
	
	</tr>
	</c:forEach>
	
	</tbody>
</table>
		</div>
		<input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
		<c:import url="../../rollpage.jsp">
			<c:param name="totalCount" value="${totalCount}"/>
			<c:param name="currentPageNo" value="${currentPageNo}"/>
			<c:param name="totalPageCount" value="${totalPageCount}"/>
		</c:import>
	</div>

</form>
</body>
</html>

