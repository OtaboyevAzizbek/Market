<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/all.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/app.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link href="https://cdn.datatables.net/v/bs5/dt-1.13.8/datatables.min.css" rel="stylesheet">
    <title>Market</title>
</head>

<body>
<div class="wrapper">
    <nav id="sidebar" class="sidebar js-sidebar">
        <div class="sidebar-content js-simplebar">
            <a class="sidebar-brand" href="index.html">
                <span class="align-middle">Market</span>
            </a>
            <ul class="sidebar-nav">
                <li class="sidebar-header">
                    Pages
                </li>
                <li class="sidebar-item active">
                    <a class="sidebar-link" href="<%=request.getContextPath()%>/market/main">
                        <i class="fa-solid fa-house mx-sm-1"></i> <span class="align-middle">Menu</span>
                    </a>
                </li>
                <li class="sidebar-item active">
                    <a class="sidebar-link" href="<%=request.getContextPath()%>/market/settings">
                        <i class="fa-solid fa-gear mx-sm-1"></i> <span class="align-middle">Sozlamalar</span>
                    </a>
                </li>
            </ul>
        </div>
    </nav>
    <div class="main">
        <nav class="navbar navbar-expand navbar-light navbar-bg">
            <a class="sidebar-toggle js-sidebar-toggle">
                <i class="hamburger align-self-center"></i>
            </a>
        </nav>

        <main class="content">
            <div class="container-fluid">