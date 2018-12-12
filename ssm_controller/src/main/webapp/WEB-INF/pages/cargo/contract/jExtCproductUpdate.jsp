<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
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
	<input type="hidden" name="_method" value="PUT">
	<input type="hidden" name="extCproductId" value="${extCproduct.extCproductId}"/>
	<input type="hidden" name="contractProduct.contract.contractId" value="${sessionScope.contractId}"/>
	<input type="hidden" name="contractProductId" value="${extCproduct.contractProductId}"/>
	
	<input type="hidden" name="amount" value="${extCproduct.amount }"/>
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('/cargo/extCproductAction_updates','_self');this.blur();">保存</a></li>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
   修改附件
  </div> 
  

 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">生产厂家：</td>
	            <td class="tableContent">
					<select name="factoryId" onchange="setFactoryName(this.options[this.selectedIndex].text);">
						<option value="0">--请选择--</option>
						<c:forEach items="${factoryList}" var="factory">
							<option value="${factory.factoryId}" <c:if test="${factory.factoryName == extCproduct.factoryName}">selected </c:if> >${factory.factoryName}</option>
						</c:forEach>
					</select>
	            	<%--<s:select name="factory.id" list="factoryList"
	            				listKey="id" listValue="factoryName" 
	            				onchange="setFactoryName(this.options[this.selectedIndex].text);"
	            				headerKey="" headerValue="--请选择--"/>--%>
	            	<input type="hidden" id="factoryName" name="factoryName" value="${extCproduct.factoryName}"/>
	            </td>
	            <td class="columnTitle">货号：</td>
	            <td class="tableContentAuto"><input type="text" name="productNo" value="${extCproduct.productNo}"/></td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">货物照片：</td>
	            <td class="tableContent"><input type="text" name="productImage" value="${extCproduct.productImage}"/></td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">数量：</td>
	            <td class="tableContent"><input type="text" name="cnumber" value="${extCproduct.cnumber}" onkeyup="value=value.replace(/[^(\d)]/g,'')"/></td>
	            <td class="columnTitle">包装单位：</td>
	            <td class="tableContentAuto">
	            	<input type="radio" name="packingUnit" value="PCS" <c:if test="${extCproduct.packingUnit=='PCS'}">checked</c:if> class="input">只
	            	<input type="radio" name="packingUnit" value="SETS" <c:if test="${extCproduct.packingUnit=='SETS'}">checked</c:if> class="input">套
	            </td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">单价：</td>
	            <td class="tableContent"><input type="text" name="price" value="${extCproduct.price}" onkeyup="value=value.replace(/[^(\d)]/g,'')"/></td>
	            <td class="columnTitle">排序号：</td>
	            <td class="tableContent"><input type="text" name="orderNo" value="${extCproduct.orderNo}" onkeyup="value=value.replace(/[^(\d)]/g,'')"/></td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">货物描述：</td>
	            <td class="tableContent"><textarea name="productDesc" style="height:150px;">${extCproduct.productDesc}</textarea>
	            <td class="columnTitle">要求：</td>
	            <td class="tableContent"><textarea name="productRequest" style="height:150px;">${extCproduct.productRequest}</textarea>
	        </tr>		
		</table>
	</div>

 
</form>
</body>
</html>

