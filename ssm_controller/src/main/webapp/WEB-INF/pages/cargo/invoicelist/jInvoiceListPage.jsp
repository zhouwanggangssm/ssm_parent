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
                formSubmit('/cargo/invoice_toview','_self');
            }else {
                alert("请先选择一项并且只能选择一项，再进行操作！");
            }
        }

        function des() {
            var ss = $("input[type='checkbox']").is(':checked');
            if (ss == true) {
                if(confirm("你确定要删除吗？")){
                    formSubmit('/cargo/invoice_delete','_self');
                }
            }else{
                alert("请先选择一项并且只能选择一项，再进行操作！");
            }
        }

        function aaa() {
            var aa = $("input[type='checkbox']").is(':checked');
            if (aa == true) {
                //修改
                formSubmit('/cargo/invoice_toupdate','_self');
            }else {
                alert("请先选择一项并且只能选择一项，再进行操作！");
            }
        }

        function bbb() {
            var bb = $("input[type='checkbox']").is(':checked');
            if (bb == true) {
                //提交
                formSubmit('/cargo/invoice_submit','_self');
            }else {
                alert("请先选择一项并且选择多项，再进行操作！");
            }
        }

        function ccc() {
            var cc = $("input[type='checkbox']").is(':checked');
            if (cc == true) {
                //取消
                formSubmit('/cargo/invoice_cancel','_self');
            }else {
                alert("请先选择一项并且选择多项，再进行操作！");
            }
        }

        function ddd() {
            var dd = $("input[type='checkbox']").is(':checked');
            if (dd == true) {
                //打印
                formSubmit('/cargo/invoice_print','_self');
            }else {
                alert("请先选择一项并且只能选择一项，再进行操作！");
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
	 <li id="new"><a href="#" onclick="formSubmit('/cargo/invoice_tocreate','_self');this.blur();">新增</a></li>
	 <li id="view"><a href="#" onclick="checks();this.blur();">查看</a></li>
	 <li id="update"><a href="#" onclick="aaa();this.blur();">修改</a></li>
	 <li id="delete"><a href="#" onclick="des();this.blur();">删除</a></li>
	 <li id="submit"><a href="#" onclick="bbb();this.blur();">提交</a></li>
	 <li id="delete"><a href="#" onclick="ccc();this.blur();">取消</a></li>
	 <li id="print"><a href="#" onclick="ddd();this.blur();" >打印</a></li>
</ul>
	<%--<%@include file="/WEB-INF/pages/button.jsp" %> --%>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
    发票列表
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr align="left">
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('invoiceId',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">编号</td>
		<td class="tableHeader">发票号</td>
		<td class="tableHeader">提单号</td>
		<td class="tableHeader">交易条款</td>
	<!-- 	<td class="tableHeader">createBy</td>
		<td class="tableHeader">createDept</td>
		<td class="tableHeader">createTime</td>
		<td class="tableHeader">updateBy</td>
		<td class="tableHeader">updateTime</td> -->
		<td class="tableHeader">状态</td>
		<td class="tableHeader">操作</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${results}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" align="left">
		<td><input type="checkbox" name="invoiceId" value="${o.invoiceId}"/></td>
		<td>${status.index+1}</td>
		<td>${o.invoiceId}</td>
		
		<td>${o.scNo}</td>
		<td>${o.blNo}</td>
		<td>${o.tradeTerms}</td>
		<td>
			<c:if test="${o.state==0}"><font color="grey">草稿</font></c:if>
			<c:if test="${o.state==1}"><font color="green">已提交</font></c:if>
			<c:if test="${o.state==2}"><font color="green">已发票</font></c:if>
			<c:if test="${o.state==3}"><font color="green">已财务</font></c:if>
		</td>
		<td>
			<div id="navMenubar">
				<ul>
					<c:if test="${o.state==1 }"><li id="back"><a href="#" onclick="formSubmit('/cargo/invoice_changes?invoiceId=${o.invoiceId}','_self');this.blur();">财务</a></li></c:if>
				</ul>
			</div>
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

