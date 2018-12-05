<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
			<script type="text/javascript" src="${ctx }/js/datepicker/WdatePicker.js"></script>
</head>

<body>
<form name="icform" method="post">
	<input type="hidden" name="pageIndex" value="1"/>
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('/cargo/finance_insert','_self');this.blur();">保存</a></li>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
   新增财务报运
  </div> 
  

 
    <div>
		<table class="commonTable" cellspacing="1" >
	        <tr>
	            <td class="columnTitle">制单人：</td>
	            <td class="tableContent"><input type="text" name="inputBy" value=""/></td>
	       
	            <td class="columnTitle">制单日期：</td>
	              <td class="tableContent">
	             <input type="text" style="width:90px;" name="inputDate"
	            	 value=""
	             	onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
	            </td>
	        </tr>	

		</table>
			        <!-- 选择装箱单 -->
		
<div class="eXtremeTable" > 	
		<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr  >
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('financeId',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">发票号</td>
		<td class="tableHeader">提单号</td>
		<td class="tableHeader">贸易条款</td>
	
	
	</tr>
	</thead>

	<tbody class="tableBody" >
	<c:forEach items="${invoiceList}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'"  >
		<td align="center"><input type="radio" name="financeId" value="${o.invoiceId}"/></td>
		<td align="center">${status.index+1}</td>

		</td>	
		<td align="center">${o.scNo}</td>
		<td align="center">${o.blNo}</td>
		<td align="center">${o.tradeTerms}</td>

		
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

