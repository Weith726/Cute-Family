<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.emp.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
    EmpService empSvc = new EmpService();
    List<EmpVO> list = empSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>所有員工資料 - listAllEmp.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 90%;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<h4>此頁練習採用 EL 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>所有員工資料 - listAllEmp.jsp</h3>
		 <h4><a href="select_page.jsp">回首頁</a></h4>
	</td></tr>
</table>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<table>
	<tr>
		<th>員工編號</th>
		<th>員工姓名</th>
		<th>性別</th>
		<th>生日</th>
		<th>職位</th>
		<th>電話</th>
		<th>地址</th>
		<th>員工帳號</th>
		<th>員工密碼</th>
		<th>員工照片</th>
		<th>到職日</th>
		<th>離職日</th>
		<th>員工狀態</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="empVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
	
		<tr>
			<td>${empVO.empID}</td>
			<td>${empVO.empName}</td>
			<td>${empVO.empGender}</td>
			<%//<td>${empVO.hiredate}</td> 原本寫法， 下面改用JSTL%>
			<td><fmt:formatDate value="${empVO.empBirth}" pattern="yyyy/MM/dd"/></td>

			<td>${empVO.empJob}</td>
			<td>${empVO.empPhone}</td> 
			<td>${empVO.empAddress}</td>
			<td>${empVO.empAcc}</td>
			<td>${empVO.empPwd}</td> 
			<td>${empVO.empPic}</td>
			<td>${empVO.hiredate}</td>
			<td>${empVO.quitdate}</td> 
			<td>${empVO.empStatus}</td>
			
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>