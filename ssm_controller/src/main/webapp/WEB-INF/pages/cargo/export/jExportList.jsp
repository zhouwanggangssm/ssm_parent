<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
	<script type="text/javascript" src="${ctx }/js/jquery-1.4.4.js"></script>
	<script type="text/javascript">

        //验证复选框是否被选中
        function checks() {
            var check = $("input[type='checkbox']").is(':checked');
            if (check == true) {
                //查看
                formSubmit('/cargo/export_toview','_self');
            }else {
                alert("请先选择一项并且只能选择一项，再进行操作！");
            }
        }

        function des() {
            var ss = $("input[type='checkbox']").is(':checked');
            if (ss == true) {
                if(confirm("你确定要删除吗？")){
                    formSubmit('/cargo/export_delete','_self');
                }
            }else{
                alert("请先选择一项并且只能选择一项，再进行操作！");
            }
        }

        function aaa() {
            var aa = $("input[type='checkbox']").is(':checked');
            if (aa == true) {
                //修改
                formSubmit('/cargo/export_toupdate','_self');
            }else {
                alert("请先选择一项并且只能选择一项，再进行操作！");
            }
        }

        function bbb() {
            var bb = $("input[type='checkbox']").is(':checked');
            if (bb == true) {
                //提交
                formSubmit('/cargo/export_submit','_self');
            }else {
                alert("请先选择一项并且选择多项，再进行操作！");
            }
        }

        function ccc() {
            var cc = $("input[type='checkbox']").is(':checked');
            if (cc == true) {
                //取消
                formSubmit('/cargo/export_cancel','_self');
            }else {
                alert("请先选择一项并且选择多项，再进行操作！");
            }
        }

        function ddd() {
            var dd = $("input[type='checkbox']").is(':checked');
            if (dd == true) {
                //装箱
                formSubmit('${ctx}/cargo/packinglist_tocreate','_self');
            }else {
                alert("请先选择一项并且选择多项，再进行操作！");
            }
        }
	</script>
</head>

<body>
<form name="icform" method="post">
	<input type="hidden" name="_method" value="DELETE">
	<input type="hidden" name="pageIndex" value="1"/>
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="view"><a href="#" onclick="checks();this.blur();">查看</a></li>
	<li id="update"><a href="#" onclick="aaa();this.blur();">修改</a></li>
	<li id="delete"><a href="#" onclick="des();this.blur();">删除</a></li>
	<li id="submit"><a href="#" onclick="bbb();this.blur();">提交</a></li>
	<li id="new"><a href="#" onclick="ccc();this.blur();">取消</a></li>
	<li id="new"><a href="#" onclick="ddd();this.blur();">装箱</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
    出口报运列表
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('exportId',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">报运号</td>
		<td class="tableHeader">货物数/附件数</td>
		<td class="tableHeader">信用证号</td>
		<td class="tableHeader">收货人及地址</td>
		<td class="tableHeader">装运港</td>
		<td class="tableHeader">目的港</td>
		<td class="tableHeader">运输方式</td>
		<td class="tableHeader">价格条件</td>
		<td class="tableHeader">制单日期</td>
		<td class="tableHeader">状态</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
${links}
	
	<c:forEach items="${results}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="exportId" value="${o.exportId}"/></td>
		<td>${status.index+1}</td>
		<td>${o.customerContract}</td>
		<td align="center">
			${o.epnum}/${o.extnum}
		</td>		
		<td>${o.lcno}</td>
		<td>${o.consignee}</td>
		<td>${o.shipmentPort}</td>
		<td>${o.destinationPort}</td>
		<td>${o.transportMode}</td>
		<td>${o.priceCondition}</td>
		<td><fmt:formatDate value="${o.inputDate }" pattern="yyyy-MM-dd"/></td>
		<!-- 0-草稿 1-已上报 2-装箱 3-委托 4-发票 5-财务 -->
		<td><c:if test="${o.state == 0}">草稿</c:if>
			<c:if test="${o.state == 1}">已上报</c:if>
			<c:if test="${o.state == 2}">装箱</c:if>
			<c:if test="${o.state == 3}">委托</c:if>
			<c:if test="${o.state == 4}">发票</c:if>
			<c:if test="${o.state == 5}">财务</c:if>
		</td>
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

