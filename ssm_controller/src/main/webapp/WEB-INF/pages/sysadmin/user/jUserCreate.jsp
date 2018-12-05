<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
	<script type="text/javascript" src="${ctx }/js/datepicker/WdatePicker.js"></script>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('/user/addUserOraddUserInfo','_self');this.blur();">保存</a></li>
<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
</div>
</div>
</div>
   
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">
   新增用户
  </div> 
  </div>
  </div>
  

 
    <div>
		<table class="commonTable" cellspacing="1">
       		<tr>
	            <td class="columnTitle">所在部门：</td>
	            <td class="tableContent">
                    <select name="dept.deptId">
                        <option value="">-- 请选择 --</option>
                        <c:forEach items="${deptList}" var="dept">
                            <option value="${dept.deptId}">${dept.deptName}</option>
                        </c:forEach>
                    </select>
	            </td>
	        </tr>
        	<tr>
	            <td class="columnTitle">登录名：</td>
	            <td class="tableContent"><input type="text" name="userName" value=""/></td>
	            <td class="columnTitle">状态：</td>
	            <td class="tableContentAuto">
	            	<input type="radio" name="state" value="1" checked class="input"/>启用
	            	<input type="radio" name="state" value="0" class="input"/>停用
	            </td>
	        </tr>
        	<tr>
	            <td class="columnTitle">姓名：</td>
	            <td class="tableContent"><input type="text" name="name" value=""/></td>
	            <td class="columnTitle">直属领导：</td>
	            <td class="tableContent">
                    <select name="manager.userId">
                        <option value="">-- 请选择 --</option>
                        <c:forEach items="${userList}" var="userlist">
                            <option value="${userlist.userInfoId}">${userlist.name}</option>
                        </c:forEach>
                    </select>
	            </td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">入职时间：</td>
	            <td class="tableContent">
					<input type="text" style="width:90px;" name="joinDate"
	            	 value=""
	             	onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd HH'});"/>
				</td>
				<td class="columnTitle">薪水：</td>
	            <td class="tableContent"><input type="text" name="salary" value=""/></td>
	        </tr>		
	        <tr>
	            <td class="columnTitle">等级：</td>
	            <td class="tableContentAuto">
	            	<input type="radio" name="degree" value="0" class="input"/>超级管理员
	            	<input type="radio" name="degree" value="1" class="input"/>跨部门跨人员
	            	<input type="radio" name="degree" value="2" class="input"/>管理所有下属部门和人员
	            	<input type="radio" name="degree" value="3" class="input"/>管理本部门
	            	<input type="radio" name="degree" value="4" class="input"/>普通员工
	            </td>
				<td class="columnTitle">性别：</td>
	            <td class="tableContentAuto">
	            	<input type="radio" name="gender" value="1" class="input"/>男
	            	<input type="radio" name="gender" value="0" class="input"/>女
	            </td>
	        </tr>	
        	<tr>
	            <td class="columnTitle">岗位：</td>
	            <td class="tableContent"><input type="text" name="station" value=""/></td>
	            <td class="columnTitle">电话：</td>
	            <td class="tableContent"><input type="text" name="telephone" value=""/></td>
	        </tr>	
        	<tr>

	            <td class="columnTitle">出生年月：</td>
	            <td class="tableContent">
					<input type="text" style="width:90px;" name="birthday"
	            	 value=""
	             	onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
				</td>
	        </tr>	
        	<tr>
        	    <td class="columnTitle">排序号：</td>
	            <td class="tableContent"><input type="text" name="orderNo" value=""/></td>
	            <td class="columnTitle">说明：</td>
	            <td class="tableContent">
	            	<textarea name="remark" style="height:120px;"></textarea>
	            </td>
	        </tr>	
		</table>
	</div>
 
 
</form>
</body>
</html>

