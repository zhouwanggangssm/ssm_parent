<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
	<script type="text/javascript" src="${ctx }/js/datepicker/WdatePicker.js"></script>
</head>

<body>
<form name="icform" method="post">
	<input type="hidden" name="_method" value="PUT">
	<input type="hidden" name="packingListId" value="${packingList.packingListId}"/>

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('/cargo/packingList_update','_self');this.blur();">保存</a></li>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
   修改装箱单
  </div>
	<div>
		<div>
			<table class="commonTable" cellspacing="1">
				<tr>
					<td class="columnTitle_mustbe">发票号 ：</td>
					<td class="tableContent"><input type="text" name="invoiceNo" value="${packingList.invoiceNo}"/></td>
					<td class="columnTitle_mustbe">发票时间：</td>
					<td class="tableContent">
						<input type="text" style="width:90px;" name="invoiceDate"
							   value="<fmt:formatDate value='${packingList.invoiceDate }' pattern='yyyy-MM-dd' />"
							   onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
					</td>
				</tr>
				<tr>
					<td class="columnTitle_mustbe">卖家：</td>
					<td class="tableContent"><textarea name="seller" style="height:80px;">${packingList.seller}</textarea></td>
					<td class="columnTitle_mustbe">买家：</td>
					<td class="tableContent"><textarea name="buyer" style="height:80px;">${packingList.buyer}</textarea></td>
				</tr>
				<tr>
					<td class="columnTitle_mustbe">唛头：</td>
					<td class="tableContent"><textarea name="marks" style="height:80px;">${packingList.marks}</textarea></td>
					<td class="columnTitle_mustbe">说明：</td>
					<td class="tableContent"><textarea name="descriptions" style="height:80px;">${packingList.descriptions}</textarea></td>
				</tr>
			</table>
		</div>
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

