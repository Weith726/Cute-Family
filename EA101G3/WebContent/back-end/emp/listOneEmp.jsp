<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.emp.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
	EmpVO empVO = (EmpVO) request.getAttribute("empVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
<title>員工資料 - listOneEmp.jsp</title>

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
	width: 600px;
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

	<h4>此頁暫練習採用 Script 的寫法取值:</h4>
	<table id="table-1">
		<tr>
			<td>
				<h3>員工資料 - ListOneEmp.jsp</h3>
				<h4>
					<a href="select_page.jsp"><img src="images/back1.gif"
						width="100" height="32" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

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
		<tr>
			<td>${empVO.empID}</td>
			<td>${empVO.empName}</td>
			<td>${empVO.empGender}</td>
			<%
				//<td>${empVO.hiredate}</td> 原本寫法， 下面改用JSTL
			%>
			<td><fmt:formatDate value="${empVO.empBirth}"
					pattern="yyyy/MM/dd" /></td>

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
	</table>

</body>
</html>