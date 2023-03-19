
<%-- 
    Document   : settinglist
    Created on : Sep 22, 2022, 2:55:10 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/bookmark.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:09:05 GMT -->
    <head>

        <!-- META ============================================= -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="keywords" content="" />
        <meta name="author" content="" />
        <meta name="robots" content="" />

        <!-- DESCRIPTION -->
        <meta name="description" content="EduChamp : Education HTML Template" />

        <!-- OG -->
        <meta property="og:title" content="EduChamp : Education HTML Template" />
        <meta property="og:description" content="EduChamp : Education HTML Template" />
        <meta property="og:image" content="" />
        <meta name="format-detection" content="telephone=no">

        <!-- FAVICONS ICON ============================================= -->
        <link rel="icon" href="../error-404.html" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link href="assets/css/toastr.css" rel="stylesheet" type="text/css"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
        <!-- PAGE TITLE HERE ============================================= -->
        <title>EduChamp : Education HTML Template </title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
        <script src="assets/js/html5shiv.min.js"></script>
        <script src="assets/js/respond.min.js"></script>
        <![endif]-->

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/assets.css">
        <link rel="stylesheet" type="text/css" href="assets/vendors/calendar/fullcalendar.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link rel="stylesheet" type="text/css" href="assets/css/dashboard.css">
        <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">
        <link href="../assets/css/toastr.css" rel="stylesheet" type="text/css"/>        
    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <!-- header start -->
        <%@include file = "../components/headerstartadmin.jsp"%>
        <!-- header end -->
        <!-- Left sidebar menu start -->
        <%@include file = "../components/Leftsidebarmenustart.jsp" %>
        <!-- Left sidebar menu end -->

        <!--Main container start -->
        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">Setting List</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="../home.jsp"><i class="fa fa-home"></i>Home</a></li>
                        <li><a href="settinglist"><i class="bi bi-gear"></i>Setting List</a></li>
                    </ul>
                </div>	
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>Setting List</h4>
                                <div style="display: flex;margin-top: 10px">
                                    <form action="filterstatus">
                                        <div style=" float: left;width: 400px;padding-left: 30px" >
                                            <div style="display: flex">
                                                <label for="subjectId"style="margin: 5px">Type</label>
                                                <select name="typeId" id="cars">
                                                    <option value="-1" ${requestScope.Status == -1 ?"selected":""}>All</option>
                                                    <c:forEach var="i" items="${requestScope.listSettingType}">
                                                        <option value="${i.settingId}" ${i.settingId == requestScope.typeId ?"selected":""}>${i.settingTitle}</option>
                                                    </c:forEach>                                                                               
                                                </select>
                                            </div>
                                        </div>                                      
                                        <div style=" float: left;width: 400px;margin-bottom: 5px; margin-left: 5px " >
                                            <div style="display: flex">
                                                <label for="Status" style="margin: 5px">Status</label>
                                                <select name="Status" id="cars">
                                                    <option value="-1" ${requestScope.Status == -1 ?"selected":""}>All</option>
                                                    <option value="1" ${requestScope.Status == 1 ?"selected":""}>Activate</option>
                                                    <option value="0" ${requestScope.Status == 0 ?"selected":""}>Deactivate</option>
                                                </select>
                                            </div>

                                        </div>                
                                        <div style=" float: left;width: 100px;margin-left:5px;margin-right:5px" >
                                            <button style="width: 88px" type="submit" class="btn btn-primary">Filter</button>
                                        </div>
                                    </form>
                                    <form action="settingtistsearchbytittle" method="GET">
                                        <div class="input-group">
                                            <input type="search" value="${requestScope.searchTittle}" class="form-control rounded" name="searchTittle" placeholder="Search by tittle" aria-label="Search" aria-describedby="search-addon"/>
                                            <button type="submit" class="btn btn-outline-primary">Search</button>
                                        </div>
                                    </form>        
                                </div>                                        
                                <div style="display: flex;justify-content: flex-end;">
                                    <a href="/SWP391_G1/admin/addnewsetting"><button type="button" class="btn btn-outline-primary">Add new +</button></a>
                                </div> 
                            </div>
                            <c:if test="${requestScope.mess != null }">
                                <div class="alert alert-success alert-dismissible d-flex align-items-center fade show">
                                    <i class="bi-check-circle-fill"></i>
                                    <strong class="mx-2">Success!</strong> Your action has been sent successfully.
                                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                                </div>
                            </c:if>                    
                            <c:if test="${requestScope.listSettingByFilter !=null}">
                                <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                                    <thead>
                                        <tr>
                                            <th class="th-sm">Id
                                            </th>
                                            <th class="th-sm">Type
                                            </th>
                                            <th class="th-sm">Tittle
                                            </th>
                                            <th class="th-sm">Value
                                            </th>
                                            <th class="th-sm">Display order
                                            </th>
                                            <th class="th-sm">Status                                      
                                            </th>
                                            <th class="th-sm">Action
                                            </th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach var="i" items="${requestScope.listSettingByFilter}">
                                            <tr>
                                                <td>${i.settingId}</td>
                                                <td>${i.typeName}
                                                </td>
                                                <td>${i.settingTitle}</td>
                                                <td>${i.settingValue}</td>
                                                <td>${i.display_order}</td>
                                                <td>${i.status}</td>                                               
                                                <td>
                                                    <a href="settingdetails?id=${i.settingId}"><button type="button" class="btn btn-success">View/Edit</button></a>
                                                    <c:if test="${i.status == 'Deactive'}">
                                                        <button style="height:40px;width:120px" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                                            Activate
                                                        </button>

                                                        <!-- Modal -->
                                                        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                            <div class="modal-dialog">
                                                                <div class="modal-content">
                                                                    <div class="modal-header">
                                                                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                    </div>
                                                                    <div class="modal-body">
                                                                        Activate ${i.settingTitle}
                                                                    </div>
                                                                    <div class="modal-footer">
                                                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                                        <a href="/SWP391_G1/admin/updatestatusactivate?id=${i.settingId}"><button type="button" class="btn btn-primary">Save changes</button></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </c:if>
                                                    <c:if test="${i.status == 'Active'}">
                                                        <button style="height:40px;width:120px" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                                            Deactivate
                                                        </button>

                                                        <!-- Modal -->
                                                        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                            <div class="modal-dialog">
                                                                <div class="modal-content">
                                                                    <div class="modal-header">
                                                                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                    </div>
                                                                    <div class="modal-body">
                                                                        Deactivate ${i.settingTitle}
                                                                    </div>
                                                                    <div class="modal-footer">
                                                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                                        <a href="/SWP391_G1/admin/updatestatusdeactivate?id=${i.settingId}"><button type="submit" class="btn btn-primary">Save changes</button></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </c:if>
                                                </td>
                                            </tr>    
                                        </c:forEach>                                                            

                                    </tbody>                               
                                </table>                                
                            </c:if>

                            <c:if test="${requestScope.settingtistsearchbytittle !=null}">
                                <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                                    <thead>
                                        <tr>
                                            <th class="th-sm">
                                                <c:if test="${requestScope.sort == null || (requestScope.sort != 'ascId' && requestScope.sort != 'descId')}">
                                                    <a  href="settingtistsearchbytittle?page=${requestScope.page}&sort=ascId&searchTittle=${requestScope.searchTittle}">Id</a>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'ascId'}">
                                                    <a href="settingtistsearchbytittle?page=${requestScope.page}&sort=descId&searchTittle=${requestScope.searchTittle}">Id</a>
                                                    <i class="bi bi-sort-alpha-down-alt"></i>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'descId'}">
                                                    <a  href="settingtistsearchbytittle?page=${requestScope.page}&sort=ascId&searchTittle=${requestScope.searchTittle}">Id</a>
                                                    <i class="bi bi-sort-alpha-up "></i>
                                                </c:if>
                                            </th>
                                            <th class="th-sm">
                                                <c:if test="${requestScope.sort == null || (requestScope.sort != 'ascType' && requestScope.sort != 'descType')}">
                                                    <a href="settingtistsearchbytittle?page=${requestScope.page}&sort=ascType&searchTittle=${requestScope.searchTittle}">Type</a>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'ascType'}">
                                                    <a href="settingtistsearchbytittle?page=${requestScope.page}&sort=descType&searchTittle=${requestScope.searchTittle}">Type</a>
                                                    <i class="bi bi-sort-alpha-up"></i>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'descType'}">
                                                    <a href="settingtistsearchbytittle?page=${requestScope.page}&sort=ascType&searchTittle=${requestScope.searchTittle}">Type</a>
                                                    <i class="bi bi-sort-alpha-down-alt"></i>
                                                </c:if>
                                            </th>
                                            <th class="th-sm">
                                                <c:if test="${requestScope.sort == null || (requestScope.sort != 'ascTittle' && requestScope.sort != 'descTittle')}">
                                                    <a  href="settingtistsearchbytittle?page=${requestScope.page}&sort=ascTittle&searchTittle=${requestScope.searchTittle}">Tittle</a> 
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'ascTittle'}">
                                                    <a href="settingtistsearchbytittle?page=${requestScope.page}&sort=descTittle&searchTittle=${requestScope.searchTittle}">Tittle</a>
                                                    <i class="bi bi-sort-alpha-up"></i>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'descTittle'}">
                                                    <a  href="settingtistsearchbytittle?page=${requestScope.page}&sort=ascTittle&searchTittle=${requestScope.searchTittle}">Tittle</a> 
                                                    <i class="bi bi-sort-alpha-down-alt"></i>
                                                </c:if>
                                            </th>
                                            <th class="th-sm">
                                                <c:if test="${requestScope.sort == null || (requestScope.sort != 'ascValue' && requestScope.sort != 'descValue')}">
                                                    <a  href="settingtistsearchbytittle?page=${requestScope.page}&sort=ascValue&searchTittle=${requestScope.searchTittle}">Value</a>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'ascValue'}">
                                                    <a href="settingtistsearchbytittle?page=${requestScope.page}&sort=descValue&searchTittle=${requestScope.searchTittle}">Value</a>
                                                    <i class="bi bi-sort-alpha-up text-right"></i>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'descValue'}">
                                                    <a  href="settingtistsearchbytittle?page=${requestScope.page}&sort=ascValue&searchTittle=${requestScope.searchTittle}">Value</a>
                                                    <i class="bi bi-sort-alpha-down-alt text-right"></i>
                                                </c:if>
                                            </th>
                                            <th class="th-sm">Display order

                                            </th>
                                            <th class="th-sm">Status

                                            </th>                                       
                                            <th class="th-sm">Action

                                            </th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach var="i" items="${requestScope.settingtistsearchbytittle}">
                                            <tr>
                                                <td>${i.settingId}</td>
                                                <td>${i.typeName}</td>
                                                <td>${i.settingTitle}</td>
                                                <td>${i.settingValue}</td>
                                                <td>${i.display_order}</td>
                                                <td>${i.status}</td>

                                                <td>
                                                    <a href="settingdetails?id=${i.settingId}"><button type="button" class="btn btn-success">View/Edit</button></a>
                                                    <c:if test="${i.status == 'Deactive'}">
                                                        <button style="height:40px;width:120px" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                                            Activate
                                                        </button>

                                                        <!-- Modal -->
                                                        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                            <div class="modal-dialog">
                                                                <div class="modal-content">
                                                                    <div class="modal-header">
                                                                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                    </div>
                                                                    <div class="modal-body">
                                                                        Activate ${i.settingTitle}
                                                                    </div>
                                                                    <div class="modal-footer">
                                                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                                        <a href="/SWP391_G1/admin/updatestatusactivate?id=${i.settingId}"><button type="button" class="btn btn-primary">Save changes</button></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </c:if>
                                                    <c:if test="${i.status == 'Active'}">
                                                        <button style="height:40px;width:120px" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                                            Deactivate
                                                        </button>

                                                        <!-- Modal -->
                                                        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                            <div class="modal-dialog">
                                                                <div class="modal-content">
                                                                    <div class="modal-header">
                                                                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                    </div>
                                                                    <div class="modal-body">
                                                                        Deactivate ${i.settingTitle}
                                                                    </div>
                                                                    <div class="modal-footer">
                                                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                                        <a href="/SWP391_G1/admin/updatestatusdeactivate?id=${i.settingId}"><button type="submit" class="btn btn-primary">Save changes</button></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </c:if>
                                                </td>
                                            </tr>    
                                        </c:forEach>                                                            

                                    </tbody>                               
                                </table>
                                <c:if test="${requestScope.page == 1}">
                                    <c:set var="prePage" value="1"/>
                                    <c:set var="nextPage" value="2"/>
                                </c:if>
                                <c:if test="${requestScope.page == requestScope.numberPageHome}">
                                    <c:set var="nextPage" value="${requestScope.numberPageHome}"/>
                                    <c:set var="prePage" value="${requestScope.numberPageHome-1}"/>
                                </c:if>
                                <c:if test="${requestScope.page != 1 && requestScope.page != requestScope.numberPageHome}">
                                    <c:set var="prePage" value="${requestScope.page-1}"/>
                                    <c:set var="nextPage" value="${requestScope.page+1}"/>
                                </c:if>
                                <div class="d-flex justify-content-center ">
                                    <nav aria-label="Page navigation example ">
                                        <ul class="pagination">
                                            <li class="page-item"><a class="page-link" href="settingtistsearchbytittle?page=${prePage}&sort=${requestScope.sort}&searchTittle=${requestScope.searchTittle}">Previous</a></li>
                                                <c:forEach begin="1" end="${requestScope.numberPageHome}" var="i">
                                                <li class="page-item ${i==requestScope.page?"active":""}" ><a class="page-link" href="settingtistsearchbytittle?page=${i}&sort=${requestScope.sort}&searchTittle=${requestScope.searchTittle}">${i}</a></li>  
                                                </c:forEach>  
                                            <li class="page-item"><a class="page-link" href="settingtistsearchbytittle?page=${nextPage}&sort=${requestScope.sort}&searchTittle=${requestScope.searchTittle}">Next</a></li>
                                        </ul>
                                    </nav>
                                </div>
                            </c:if>

                            <c:if test="${requestScope.listSetting !=null}">
                                <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                                    <thead>
                                        <tr>
                                            <th class="th-sm">
                                                <c:if test="${requestScope.sort == null || (requestScope.sort != 'ascId' && requestScope.sort != 'descId')}">
                                                    <a  href="settinglist?page=${requestScope.page}&sort=ascId">Id</a>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'ascId'}">
                                                    <a href="settinglist?page=${requestScope.page}&sort=descId">Id</a>
                                                    <i class="bi bi-sort-alpha-up "></i>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'descId'}">
                                                    <a  href="settinglist?page=${requestScope.page}&sort=ascId">Id</a>
                                                    <i class="bi bi-sort-alpha-down-alt"></i>
                                                </c:if>
                                            </th>
                                            <th class="th-sm">
                                                <c:if test="${requestScope.sort == null || (requestScope.sort != 'ascType' && requestScope.sort != 'descType')}">
                                                    <a href="settinglist?page=${requestScope.page}&sort=ascType">Type</a>

                                                </c:if>
                                                <c:if test="${requestScope.sort == 'ascType'}">
                                                    <a href="settinglist?page=${requestScope.page}&sort=descType">Type</a>
                                                    <i class="bi bi-sort-alpha-up"></i>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'descType'}">
                                                    <a href="settinglist?page=${requestScope.page}&sort=ascType">Type</a>
                                                    <i class="bi bi-sort-alpha-down-alt"></i>
                                                </c:if>


                                            </th>
                                            <th class="th-sm">
                                                <c:if test="${requestScope.sort == null || (requestScope.sort != 'ascTittle' && requestScope.sort != 'descTittle')}">
                                                    <a  href="settinglist?page=${requestScope.page}&sort=ascTittle">Tittle</a>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'ascTittle'}">
                                                    <a href="settinglist?page=${requestScope.page}&sort=descTittle">Tittle</a>
                                                    <i class="bi bi-sort-alpha-up"></i>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'descTittle'}">
                                                    <a  href="settinglist?page=${requestScope.page}&sort=ascTittle">Tittle</a>
                                                    <i class="bi bi-sort-alpha-down-alt"></i>
                                                </c:if>


                                            </th>
                                            <th class="th-sm">
                                                <c:if test="${requestScope.sort == null || (requestScope.sort != 'ascValue' && requestScope.sort != 'descValue')}">
                                                    <a  href="settinglist?page=${requestScope.page}&sort=ascValue">Value</a>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'ascValue'}">
                                                    <a href="settinglist?page=${requestScope.page}&sort=descValue">Value</a>
                                                    <i class="bi bi-sort-alpha-up text-right"></i>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'descValue'}">
                                                    <a  href="settinglist?page=${requestScope.page}&sort=ascValue">Value</a>
                                                    <i class="bi bi-sort-alpha-down-alt text-right"></i>
                                                </c:if>


                                            </th>
                                            <th class="th-sm">Display order

                                            </th>
                                            <th class="th-sm">Status

                                            </th>                                       
                                            <th class="th-sm">Action

                                            </th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:if test="${requestScope.listSetting!=null}">
                                            <c:forEach var="i" items="${requestScope.listSetting}">
                                                <tr>
                                                    <td>${i.settingId}</td>
                                                    <td>${i.typeName}
                                                    </td>
                                                    <td>${i.settingTitle}</td>
                                                    <td>${i.settingValue}</td>
                                                    <td>${i.display_order}</td>
                                                    <td>${i.status}</td>
                                                    <td>
                                                        <a href="settingdetails?id=${i.settingId}"><button type="button" class="btn btn-success">View/Edit</button></a>
                                                        <c:if test="${i.status == 'Deactive'}">
                                                            <button style="height:40px;width:120px" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                                                Activate
                                                            </button>

                                                            <!-- Modal -->
                                                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                                <div class="modal-dialog">
                                                                    <div class="modal-content">
                                                                        <div class="modal-header">
                                                                            <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                        </div>
                                                                        <div class="modal-body">
                                                                            Activate ${i.settingTitle}
                                                                        </div>
                                                                        <div class="modal-footer">
                                                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                                            <a href="/SWP391_G1/admin/updatestatusactivate?id=${i.settingId}"><button type="button" class="btn btn-primary">Save changes</button></a>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </c:if>
                                                        <c:if test="${i.status == 'Active'}">
                                                            <button style="height:40px;width:120px" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                                                Deactivate
                                                            </button>

                                                            <!-- Modal -->
                                                            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                                <div class="modal-dialog">
                                                                    <div class="modal-content">
                                                                        <div class="modal-header">
                                                                            <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                        </div>
                                                                        <div class="modal-body">
                                                                            Deactivate ${i.settingTitle}
                                                                        </div>
                                                                        <div class="modal-footer">
                                                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                                            <a href="/SWP391_G1/admin/updatestatusdeactivate?id=${i.settingId}"><button type="submit" class="btn btn-primary">Save changes</button></a>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </c:if>
                                                    </td>
                                                </tr>    
                                            </c:forEach>                                                            
                                        </c:if>

                                    </tbody>                               
                                </table>
                                <c:if test="${requestScope.page == 1}">
                                    <c:set var="prePage" value="1"/>
                                    <c:set var="nextPage" value="2"/>
                                </c:if>
                                <c:if test="${requestScope.page == requestScope.numberPageHome}">
                                    <c:set var="nextPage" value="${requestScope.numberPageHome}"/>
                                    <c:set var="prePage" value="${requestScope.numberPageHome-1}"/>
                                </c:if>
                                <c:if test="${requestScope.page != 1 && requestScope.page != requestScope.numberPageHome}">
                                    <c:set var="prePage" value="${requestScope.page-1}"/>
                                    <c:set var="nextPage" value="${requestScope.page+1}"/>
                                </c:if>
                                <div class="d-flex justify-content-center">
                                    <nav aria-label="Page navigation example ">
                                        <ul class="pagination">
                                            <li class="page-item"><a class="page-link" href="settinglist?page=${prePage}&sort=${requestScope.sort}">Previous</a></li>
                                                <c:forEach begin="1" end="${requestScope.numberPageHome}" var="i">
                                                <li class="page-item ${i==requestScope.page?"active":""}" ><a class="page-link" href="settinglist?page=${i}&sort=${requestScope.sort}">${i}</a></li>  
                                                </c:forEach>  
                                            <li class="page-item"><a class="page-link" href="settinglist?page=${nextPage}&sort=${requestScope.sort}">Next</a></li>
                                        </ul>
                                    </nav>
                                </div>
                            </c:if>
                            <input id="toast" value="${requestScope.sussces}" hidden="">
                        </div>
                    </div>
                    <!-- Your Profile Views Chart END-->
                </div>
            </div>
        </main>
        <div class="ttr-overlay"></div>

        <!-- External JavaScripts -->
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/vendors/bootstrap/js/popper.min.js"></script>
        <script src="assets/vendors/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/vendors/bootstrap-select/bootstrap-select.min.js"></script>
        <script src="assets/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
        <script src="assets/vendors/magnific-popup/magnific-popup.js"></script>
        <script src="assets/vendors/counter/waypoints-min.js"></script>
        <script src="assets/vendors/counter/counterup.min.js"></script>
        <script src="assets/vendors/imagesloaded/imagesloaded.js"></script>
        <script src="assets/vendors/masonry/masonry.js"></script>
        <script src="assets/vendors/masonry/filter.js"></script>
        <script src="assets/vendors/owl-carousel/owl.carousel.js"></script>
        <script src='assets/vendors/scroll/scrollbar.min.js'></script>
        <script src="assets/js/functions.js"></script>
        <script src="assets/vendors/chart/chart.min.js"></script>
        <script src="assets/js/admin.js"></script>
        <script src='assets/vendors/switcher/switcher.js'></script>
        <script src="assets/js/toastr.min.js" type="text/javascript"></script>
        <script>
            if (document.getElementById("toast").value == 1) {
                toastr["success"]("Change susscesfully");
            }
            toastr.options = {
                "closeButton": false,
                "debug": false,
                "newestOnTop": false,
                "progressBar": false,
                "positionClass": "toast-bottom-right",
                "preventDuplicates": false,
                "onclick": null,
                "showDuration": "300",
                "hideDuration": "1000",
                "timeOut": "5000",
                "extendedTimeOut": "1000",
                "showEasing": "swing",
                "hideEasing": "linear",
                "showMethod": "fadeIn",
                "hideMethod": "fadeOut"
            };


        </script>
    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/bookmark.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:10:19 GMT -->
</html>
