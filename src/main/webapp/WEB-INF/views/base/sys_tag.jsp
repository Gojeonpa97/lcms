<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%--
<%@ page import="com.crsc.base.constant.ManagerConst" %>
--%>

<%@ page isELIgnored="false"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="basePath" value="${pageContext.request.contextPath}" />
<%--
<c:set var="adminPath" value="${basePath}/${ManagerConst.adminPath}" />
--%>
<c:set var="staticPath" value="${basePath}/static" />

<c:set var="currentTimeMillis" value="<%=System.currentTimeMillis()%>" />
