<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSTL fmt ���̺귯��</title>
</head>
<body>
	<h1>1. ���� ���</h1>
	<c:set var="number" value="12345678"/>
	<fmt:formatNumber value="${number}"/>
	
	<h3>Type</h3>
	<%-- number Ÿ�� --%>
	���� : <fmt:formatNumber value="${number}" type="number"/> <br>
	���� 3�ڸ����� �޸� ���� : <fmt:formatNumber value="${number}" type="number" groupingUsed="false"/><br>
	<%-- percent Ÿ�� --%>
	100%: <fmt:formatNumber type="percent" value="1"/><br>
	40%: <fmt:formatNumber type="percent" value="0.4"/><br>
	<%-- ��ȭ(currency) Ÿ�� --%>
	��ȭ(��) : <fmt:formatNumber type="currency" value="${number}"/><br>
	��ȭ(�޷�) : <fmt:formatNumber type="currency" value="${number}" currencySymbol="$"/><br>
	
	<h3>Pattern</h3>
	3.14: <fmt:formatNumber value="3.14"/><br>
	3.14: <fmt:formatNumber value="3.14" pattern="0.0000"/><br>
	3.14(#.####): <fmt:formatNumber value="3.14" pattern="#.####"/><br>
	3.141592653(#.####): <fmt:formatNumber value="3.141592653" pattern="#.####"/><br>
	<hr>
	
	<h1>Date ��ü�� String ���·� ���(fmt:formatDate)</h1>
	Date: ${now}<br>
	<fmt:formatDate value="${now}" pattern="yyyy�� MM�� dd�� HH�� mm�� ss��"/> <br>
	<fmt:formatDate value="${now}" pattern="yyyy/MM/dd HH:mm:ss" var="pattern2"/><br>
	pattern2: ${pattern2}
	
	<h1>String �� Date ��ü�� ��ȯ(fmt:parseDate)</h1>
	<fmt:parseDate value="${pattern2}" pattern="yyyy/MM/dd HH:mm:ss"/>
</body>
</html>