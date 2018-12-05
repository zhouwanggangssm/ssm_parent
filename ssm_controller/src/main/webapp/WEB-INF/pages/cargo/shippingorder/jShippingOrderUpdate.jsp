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
	<input type="hidden" name="shippingOrderId" value="${sOd.shippingOrderId}"/>
	<input type="hidden" name="_method" value="PUT">
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('/cargo/shippingOrder_update','_self');this.blur();">保存</a></li>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
   修改部门
  </div> 
  

 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">海运/空运：</td>
	            <td class="tableContent"><input type="text" name="orderType" value="${sOd.orderType }"/></td>
	       
	            <td class="columnTitle">货主：</td>
	            <td class="tableContent"><input type="text" name="shipper" value="${sOd.shipper }"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">提单抬头：</td>
	            <td class="tableContent"><input type="text" name="consignee" value="${sOd.consignee }"/></td>
	            <td class="columnTitle">正本通知人：</td>
	            <td class="tableContent"><input type="text" name="notifyParty" value="${sOd.notifyParty }"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">信用证：</td>
	            <td class="tableContent"><input type="text" name="lcNo" value="${sOd.lcNo }"/></td>
	            <td class="columnTitle">装运港：</td>
	            <td class="tableContent"><input type="text" name="portOfLoading" value="${sOd.portOfLoading }"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">转船港：</td>
	            <td class="tableContent"><input type="text" name="portOfTrans" value="${sOd.portOfTrans }"/></td>
	            <td class="columnTitle">卸货港：</td>
	            <td class="tableContent"><input type="text" name="portOfDischarge" value="${sOd.portOfDischarge }"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">装期：</td>
	            <td class="tableContent">
					<input type="text" style="width:90px;" name="loadingDate"
						   value="<fmt:formatDate value='${sOd.loadingDate }' pattern='yyyy-MM-dd' />"
						   onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
				</td>
	            <td class="columnTitle">效期：</td>
	            <td class="tableContent">
					<input type="text" style="width:90px;" name="limitDate"
						   value="<fmt:formatDate value='${sOd.limitDate }' pattern='yyyy-MM-dd' />"
						   onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
				</td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">是否分批：</td>
	            <td class="tableContentAuto">
	            <input type="radio" name="isBatch" value="1" ${sOd.isBatch==1?'checked':'' } class="input"/>是
	            <input type="radio" name="isBatch" value="0" ${sOd.isBatch==0?'checked':'' } class="input"/>否
	            </td>
	            <td class="columnTitle">是否转船：</td>
	            <td class="tableContentAuto">
	            <input type="radio" name="isTrans" value="1" ${sOd.isBatch==1?'checked':'' } class="input"/>是
	            <input type="radio" name="isTrans" value="0" ${sOd.isBatch==0?'checked':'' } class="input"/>否
	            </td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">份数：</td>
	            <td class="tableContent"><input type="text" name="copyNum" value="${sOd.copyNum }"/></td>
	            <td class="columnTitle">扼要说明：</td>
	            <td class="tableContent"><input type="text" name="remark" value="${sOd.remark }"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">运输要求：</td>
	            <td class="tableContent"><input type="text" name="specialCondition" value="${sOd.specialCondition }"/></td>
	            <td class="columnTitle">运费说明：</td>
	            <td class="tableContent"><input type="text" name="freight" value="${sOd.freight }"/></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">复核人：</td>
	            <td class="tableContent"><input type="text" name="checkBy" value="${sOd.checkBy }"/></td>
	        </tr>	
		</table>
	</div>
 
 
</form>
</body>
</html>

