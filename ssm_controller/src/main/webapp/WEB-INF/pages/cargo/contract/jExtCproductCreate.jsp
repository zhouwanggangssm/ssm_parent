<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
	<script type="text/javascript" src="../../js/datepicker/WdatePicker.js"></script>
	<script type="text/javascript">
		//设置厂家名称隐藏域，这样无需再次查询数据库
		function setFactoryName( val ){
			document.getElementById("factoryName").value = val; 
		}
	</script>
</head>

<body>
<form name="icform" method="post">
	<%--购销合同的id--%>
	<input type="hidden" name="contractProduct.contract.contractId" value="${sessionScope.contractId}"/>
	<input type="hidden" name="contractProductId" value="${contractProductId}"/>
	
	

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('/cargo/extCproduct_inserts','_self');this.blur();">保存</a></li>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
   新增附件
  </div> 
  

 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">生产厂家：</td>
	            <td class="tableContent">
					<select name="factoryId" onchange="setFactoryName(this.options[this.selectedIndex].text);">
						<option value="0">--请选择--</option>
						<c:forEach items="${factoryList}" var="factory">
							<option value="${factory.factoryId}">${factory.factoryName}</option>
						</c:forEach>
					</select>
	            	<%--<s:select name="factory.id" list="factoryList"
	            				onchange="setFactoryName(this.options[this.selectedIndex].text);"
	            				listKey="id" listValue="factoryName" 
	            				headerKey="" headerValue="--请选择--"/>--%>

	            	<input type="hidden" id="factoryName" name="factoryName" value=""/>
	            </td>
	            <td class="columnTitle">货号：</td>
	            <td class="tableContentAuto"><input type="text" name="productNo" value=""/></td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">货物照片：</td>
	            <td class="tableContent"><input type="text" name="productImage" value=""/></td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">数量：</td>
	            <td class="tableContent"><input type="text" name="cnumber" value=""/></td>
	            <td class="columnTitle">包装单位：</td>
	            <td class="tableContentAuto">
	            	<input type="radio" name="packingUnit" value="PCS" class="input">只
	            	<input type="radio" name="packingUnit" value="SETS" class="input" checked>套
	            </td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">单价：</td>
	            <td class="tableContent"><input type="text" name="price" value=""/></td>
	            <td class="columnTitle">排序号：</td>
	            <td class="tableContent"><input type="text" name="orderNo" value=""/></td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">货物描述：</td>
	            <td class="tableContent"><textarea name="productDesc" style="height:150px;"></textarea>
	            <td class="columnTitle">要求：</td>
	            <td class="tableContent"><textarea name="productRequest" style="height:150px;"></textarea>
	        </tr>		
		</table>
	</div>


<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">
    附件列表
  </div> 
  </div>
  </div>
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">厂家</td>
		<td class="tableHeader">货号</td>
		<td class="tableHeader">包装单位</td>
		<td class="tableHeader">数量</td>
		<td class="tableHeader">单价</td>
		<td class="tableHeader">总金额</td>
		<td class="tableHeader">操作</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	<%--${links }--%>
	<c:forEach items="${results}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="id" value="${o.extCproductId}"/></td>
		<td>${status.index+1}</td>
		<td>${o.factoryName}</td>
		<td>${o.productNo}</td>
		<td>${o.packingUnit}</td>
		<td>${o.cnumber}</td>
		<td>${o.price}</td>
		<td>${o.amount}</td>
		<td>
			<a href="/cargo/extCproduct_toupdates?extCproductId=${o.extCproductId}&contractId=${sessionScope.contractId}">[修改]</a>
			<a href="/cargo/extCproductAction_deletes?extCproductId=${o.extCproductId}&contractProductId=${o.contractProductId}&contractProduct.contract.contractId=${sessionScope.contractId}">[删除]</a>
		</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</div> 
 
</form>
</body>
</html>

