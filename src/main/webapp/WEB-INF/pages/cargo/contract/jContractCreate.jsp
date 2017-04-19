<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>  
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
</head>
<script type="text/javascript" src="../../js/datepicker/WdatePicker.js"></script>
<body>
<form method="post">


	<input type="hidden" name="id" value="${obj.id}"/>


<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('insert.action','_self');">确定</a></li>
<li id="back"><a href="list.action">返回</a></li>
</ul>
    </div>
</div>
</div>
</div>
     
<div class="textbox" id="centerTextbox">
    
    <div class="textbox-header">
    <div class="textbox-inner-header">
    <div class="textbox-title">
		新增购销合同信息
    </div> 
    </div>
    </div>
<div>
 
 
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">客户名称：</td>
	            <td class="tableContent"><input type="text" name="customName" value=""/></td>
	            <td class="columnTitle_mustbe">收购方：</td>
	            <td class="tableContent"><input type="text" name="offeror" value="杰信商贸"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">合同号：</td>
	            <td class="tableContent"><input type="text" name="contractNo" value=""/></td>
	            <td class="columnTitle_mustbe">打印板式：</td>
	            <td class="tableContent">
	            	<input class="input" type="radio" name="printStyle" value="2" checked="checked"/>两款
	            	<input class="input" type="radio" name="printStyle" value="1" />一款
	            </td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">签单日期：</td>
	            <td class="tableContent">
	            	<input type="text" style="width: 90px" name="signingDate" value="" 
	            		onClick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
	            </td>
	            <td class="columnTitle_mustbe">重要程度：</td>
	            <td class="tableContent">
	            	<input class="input" type="radio" name="importNum" value="3" checked="checked"/>★★★
	            	<input class="input" type="radio" name="importNum" value="2" />★★
	            	<input class="input" type="radio" name="importNum" value="1" />★
	            </td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">交货期：</td> 
	            <td class="tableContent">										
	            <input type="text" style="width: 90px" name="deliveryPeriod" value=""
	            	onClick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
	            </td>
	            <td class="columnTitle_mustbe">船期：</td>
	            <td class="tableContent">												
					 <input type="text" style="width: 90px" name="shipTime" value=""
	            		onClick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
				</td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">贸易条款：</td>
	            <td class="tableContent"><input type="text" name="tradeTerms" value=""/></td>
	            <td class="columnTitle_mustbe">验货员：</td>
	            <td class="tableContent"><input type="text" name="inspector" value=""/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">制单人：</td>
	            <td class="tableContent"><input type="text" name="inputBy" value=""/></td>
	            <td class="columnTitle_mustbe">审单人：</td>
	            <td class="tableContent"><input type="text" name="checkBy" value=""/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">要求：</td>
	            <td class="tableContent"><input type="text" name="crequest" value="${obj.crequest}"/></td>
	            <td class="columnTitle_mustbe">说明：</td>
	            <td class="tableContent"><input type="text" name="remark" value="${obj.remark}"/></td>
	        </tr>
		</table>
	</div>
</div>
 
 
</form>
</body>
</html>

