<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.emp.model.*"%>
<%-- �����m�߱ĥ� EL ���g�k���� --%>

<%
    EmpService empSvc = new EmpService();
    List<EmpVO> list = empSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>�Ҧ����u��� - listAllEmp.jsp</title>

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

<h4>�����m�߱ĥ� EL ���g�k����:</h4>
<table id="table-1">
	<tr><td>
		 <h3>�Ҧ����u��� - listAllEmp.jsp</h3>
		 <h4><a href="select_page.jsp">�^����</a></h4>
	</td></tr>
</table>

<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<table>
	<tr>
		<th>���u�s��</th>
		<th>���u�m�W</th>
		<th>�ʧO</th>
		<th>�ͤ�</th>
		<th>¾��</th>
		<th>�q��</th>
		<th>�a�}</th>
		<th>���u�b��</th>
		<th>���u�K�X</th>
		<th>���u�Ӥ�</th>
		<th>��¾��</th>
		<th>��¾��</th>
		<th>���u���A</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="empVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
	
		<tr>
			<td>${empVO.empID}</td>
			<td>${empVO.empName}</td>
			<td>${empVO.empGender}</td>
			<%//<td>${empVO.hiredate}</td> �쥻�g�k�A �U�����JSTL%>
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