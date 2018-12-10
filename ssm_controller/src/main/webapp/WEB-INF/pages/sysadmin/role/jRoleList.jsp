<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
	<script type="text/javascript" src="${ctx }/js/jquery-1.4.4.js"></script>
	<script>
        function isOnlyChecked(){
            var checkBoxArray = document.getElementsByName('id');
            var count=0;
            for(var index=0; index<checkBoxArray.length; index++) {
                if (checkBoxArray[index].checked) {
                    count++;
                }
            }
            //jquery
            //var count = $("[input name='id']:checked").size();
            if(count==1)
                return true;
            else
                return false;
        }
        function toView(){
            if(isOnlyChecked()){
                formSubmit('/role/findRoleById','_self');
            }else{
                alert("请先选择一项并且只能选择一项，再进行操作！");
            }
        }
        //实现更新
        function toUpdate(){
            if(isOnlyChecked()){
                formSubmit('/role/updateRoleUI','_self');
            }else{
                alert("请先选择一项并且只能选择一项，再进行操作！");
            }
        }
        //实现分配角色
        function toRoleModule(){
            if(isOnlyChecked()){
                formSubmit('/role/rolemoduleUI','_self');
            }else{
                alert("请先选择一项并且只能选择一项，再进行操作！");
            }
        }
        //实现删除
        function toDelete(){
            if(isOnlyChecked()){
                formSubmit('/role/deleteRole','_self');
            }else{
                alert("请先选择一项或者多项，再进行操作！");
            }
        }
	</script>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">

	         <input type="hidden" name="pageIndex" value="1"/>
<ul>
<li id="view"><a href="#" onclick="javascript:toView()">查看</a></li>
<li id="new"><a href="#" onclick="formSubmit('/role/addRoleUI','_self');this.blur();">新增</a></li>
<li id="update"><a href="#" onclick="javascript:toUpdate()">修改</a></li>
<li id="delete"><a href="#" onclick="javascript:toDelete()">删除</a></li>
<li id="new"><a href="#" onclick="javascript:toRoleModule()" title="分配权限">权限</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">
    角色列表
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
		<td class="tableHeader">编号</td>
		<td class="tableHeader">名称</td>
		<td class="tableHeader">说明</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	<c:forEach items="${roleList}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" align="left">
		<td><input type="checkbox" name="id" value="${o.roleId}"/></td>
		<td>${(currentPageNo-1)*pageSize+status.count}</td>
		<td>${o.roleId}</td>
		<td><a href="roleAction_toview?id=${o.roleId}">${o.name}</a></td>
		<td>${o.remark}</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
	<input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
	<c:import url="../../rollpage.jsp">
		<c:param name="totalCount" value="${totalCount}"/>
		<c:param name="currentPageNo" value="${currentPageNo}"/>
		<c:param name="totalPageCount" value="${totalPageCount}"/>
	</c:import>
</div>
 
</div>

</div>
</form>
</body>
</html>

