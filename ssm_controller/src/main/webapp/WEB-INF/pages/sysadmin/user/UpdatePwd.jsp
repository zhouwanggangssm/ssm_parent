<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/1
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>修改密码</title>
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
                        <li id="save"><a href="#" onclick="formSubmit('/cargo/contract_toview','_self');this.blur();">保存</a></li>
                        <li id="rset"><a href="#" onclick="formSubmit('/cargo/contract_toview','_self');this.blur();">返回</a></li>

                        <div>
                            旧密码：<input name="username" type="text"></br>
                            新密码：<input name="password" type="text"></br>
                            确认新密码：<input name="newpassword" type="text"></br>
                        </div>

     </ul>
    </div>
   </div>
  </div>
 </div>
</form>
</body>
</html>