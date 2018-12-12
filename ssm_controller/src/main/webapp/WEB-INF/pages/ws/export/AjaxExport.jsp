<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
</head>
<script type="text/javascript" src="${ctx }/js/datepicker/WdatePicker.js"></script>
<script type="text/javascript">

	//创建对象 兼容各浏览器
    var xmlHttp;
    if(window.ActiveXObject)
    {
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    else if(window.XMLHttpRequest)
    {
        xmlHttp=new XMLHttpRequest();
    }

    //alert(xmlHttp);
	//点击查看按钮
	function sendMsg() {
		var exportId = document.getElementById("exportId").value;

		var url = "http://localhost:8888/cxf/ExportService"; //webservice访问链接

		var requestBody = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:q0=\"http://service.xt.cn/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><soapenv:Body><q0:get><arg0>"+exportId+"</arg0></q0:get></soapenv:Body></soapenv:Envelope>";

		xmlHttp.open("POST",url,true);//打开链接

		xmlHttp.setRequestHeader("Content-Type","text/xml;charset=utf-8");//请求头

		xmlHttp.send(requestBody);

		xmlHttp.onreadystatechange = _back; //绑定事件

    }
	//回调函数
	function _back() {
		if(xmlHttp.readyState == 4){
			if(xmlHttp.status == 200){
			  /!* alert(xmlHttp.responseXML);*!/
                var retXml = xmlHttp.responseXML;
               // alert(retXml);

                var ret = retXml.getElementsByTagName("return")[0];	//获取return节点信息

                //alert(ret);

                if(ret != null){

                    var customerContract =  ret.getElementsByTagName("customerContract")[0].innerHTML;	//获取到报运号

                    document.getElementById("customerContract").innerHTML = customerContract;

                    var inputDate =  ret.getElementsByTagName("inputDate")[0].innerHTML;	//获取到报运号
                    document.getElementById("inputDate").innerHTML = inputDate.substring(0,10);

                    var lcno =  ret.getElementsByTagName("lcno")[0].innerHTML;
                    document.getElementById("lcno").innerHTML = lcno;

                    var consignee =  ret.getElementsByTagName("consignee")[0].innerHTML;
                    document.getElementById("consignee").innerHTML = consignee;

                    var shipmentPort =  ret.getElementsByTagName("shipmentPort")[0].innerHTML;
                    document.getElementById("shipmentPort").innerHTML = shipmentPort;

                    var destinationPort =  ret.getElementsByTagName("destinationPort")[0].innerHTML;
                    document.getElementById("destinationPort").innerHTML = destinationPort;

                    var transportMode =  ret.getElementsByTagName("transportMode")[0].innerHTML;
                    document.getElementById("transportMode").innerHTML = transportMode;

                    var priceCondition =  ret.getElementsByTagName("priceCondition")[0].innerHTML;
                    document.getElementById("priceCondition").innerHTML = priceCondition;

                    var marks =  ret.getElementsByTagName("marks")[0].innerHTML;
                    document.getElementById("marks").innerHTML = marks;

                    var remark =  ret.getElementsByTagName("remark")[0].innerHTML;
                    document.getElementById("remark").innerHTML = remark;

                    var state =  ret.getElementsByTagName("state")[0].innerHTML;
                   // 0-草稿 1-已上报 2-装箱 3-委托 4-发票 5-财务
					if(state=='1'){
                        state = "已上报，待装箱";
                    }else if(state=='2'){
                        state = "已装箱，待委托";
                    }else if(state=='3'){
                        state = "已委托，待发票通知";
                    }else if(state=='4'){
                        state = "已发票，流程顺利完成!";
                    }else{
                        state = "流程顺利完成";
					}
                    document.getElementById("state").innerHTML = "<font color='orange'>"+state+"</font>";
                }else{
                    //清空所有框中数据
                    alert("没有查询到数据!");
                }
			}else{
                alert("异常，请联系管理员！");
			}
		}
    }

</script>
<body>
<form name="icform" method="post">
   <!-- 保存的是购销合同的id,用逗号空格进行分隔 -->
   <input type="hidden" name="contractIds" value="${contractId }" />
<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="view"><a href="#" onclick="sendMsg();">查看</a></li>
	<li id="back"><a href="#" onclick="history.go(-1);">返回</a></li>
</ul>
  </div>
	<div class="textbox-title">
		状态：<span id="state"></span>
	</div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="${ctx }/skin/default/images/icon/currency_yen.png"/>
   出口报运跟踪信息
  </div> 
  
    <div>
		<table class="commonTable" cellspacing="1">
			<tr>
				<td class="columnTitle_mustbe">报运编号：</td>
				<td class="tableContent"><input type="text" name="exportId" id="exportId" value="f3d3d19ac8ff4037b0820c5611659d8e"/></td>
			</tr>
	        <tr>
	            <td class="columnTitle">报运号：</td>
	            <td class="tableContent" id="customerContract"></td>
	       
	            <td class="columnTitle">制单日期：</td>
	            <td class="tableContent" id="inputDate"></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">信用证号：</td>
	            <td class="tableContent" id="lcno"></td>
	       
	            <td class="columnTitle">收货人及地址：</td>
	            <td class="tableContent" id="consignee"></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">装运港：</td>
	            <td class="tableContent" id="shipmentPort"></td>
	       
	            <td class="columnTitle">目的港：</td>
	            <td class="tableContent" id="destinationPort"></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">运输方式：</td>
	            <td class="tableContent" id="transportMode"></td>
	      
	            <td class="columnTitle">价格条件：</td>
	            <td class="tableContent" id="priceCondition"></td>
	        </tr>	
	        <tr>
	            <td class="columnTitle">唛头：</td>
	            <td class="tableContent" id="marks"></td>
	       
	            <td class="columnTitle">备注：</td>
	            <td class="tableContent" id="remark"></td>
	        </tr>
		</table>
	</div>
 
 
</form>
</body>
</html>

