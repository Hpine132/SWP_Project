<%-- 
    Document   : listevalcriteria
    Created on : Oct 8, 2022, 9:10:45 AM
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
        <link href="assets/css/toastr.css" rel="stylesheet" type="text/css"/>

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
                    <h4 class="breadcrumb-title">Eval Criteria List</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="../home.jsp"><i class="fa fa-home"></i>Home</a></li>
                        <li><a href="assignmentlist"><i class="bi bi-gear"></i>Eval Criteria</a></li>
                    </ul>
                </div>	
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>Eval Criteria</h4>
                                <div style="display: flex;margin-top: 10px">
                                    <form action="listaevalcriterialbyfilter" method="POST">                               
                                        <div style=" float: left;width: 400px;margin-bottom: 5px; " >
                                            <div style="display: flex">
                                                <label for="Status" style="margin: 5px">Assignment</label>
                                                <select name="assid" id="cars">
                                                    <option value="">All</option>
                                                    <c:forEach var="i" items="${requestScope.listAssignmentForId}">
                                                        <option value="${i.assId}" ${i.assId == requestScope.assid ?"selected":""}>${i.tittle}</option>
                                                    </c:forEach>  
                                                </select>
                                            </div>

                                        </div>
                                        <div style=" float: left;width: 400px;margin-bottom: 5px; " >
                                            <div style="display: flex">
                                                <label for="Status" style="margin: 5px">Status</label>
                                                <select name="Status" id="cars">
                                                    <option value="">All</option>
                                                    <option value="1" ${requestScope.Status == 1 ?"selected":""}>Activate</option>
                                                    <option value="0" ${requestScope.Status == 0 ?"selected":""}>Deactivate</option>
                                                </select>
                                            </div>

                                        </div>
                                        <div style=" float: left;width: 100px;margin-bottom: 5px" >
                                            <button style="width: 88px" type="submit" class="btn btn-primary">Filter</button>
                                        </div>                            
                                    </form>
                                    <form action="evalcriteriallistbysearch" method="GET">
                                        <div class="input-group">
                                            <input type="search" class="form-control rounded" name="searchTittle" placeholder="Search by name Eval Criteria" value="${requestScope.searchTittle}" aria-label="Search" aria-describedby="search-addon"/>
                                            <button type="submit" class="btn btn-outline-primary">Search</button>
                                        </div>
                                    </form>         
                                </div>
                                <div style="display: flex;justify-content: flex-end;">
                                    <a href="/SWP391_G1/admin/addnewevalcritaria"><button type="button" class="btn btn-outline-primary">Add new +</button></a>
                                </div> 
                            </div>
                            <c:if test="${requestScope.mess != null }">
                                <div class="alert alert-success alert-dismissible d-flex align-items-center fade show">
                                    <i class="bi-check-circle-fill"></i>
                                    <strong class="mx-2">Success!</strong> Your action has been sent successfully.
                                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                                </div>
                            </c:if>

                            <c:if test="${requestScope.listEvalCriteriaFilter !=null}">
                                <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                                    <thead>
                                        <tr>
                                            <th class="th-sm">Id

                                            </th>
                                            <th class="th-sm">Assignment 

                                            </th>                                           
                                            <th class="th-sm" style="text-align: center">Criteria name

                                            </th>
                                            <th class="th-sm" style="text-align: center">Team eval

                                            </th>
                                            <th class="th-sm" style="text-align: center">Eval weight

                                            </th>
                                            <th class="th-sm" style="text-align: center">Max loc

                                            </th>                                         
                                            <th class="th-sm" style="text-align: center">Status

                                            </th>
                                            <th class="th-sm" style="text-align: center">Action

                                            </th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:if test="${requestScope.listEvalCriteriaFilter!=null}">
                                            <c:forEach var="i" items="${requestScope.listEvalCriteriaFilter}">
                                                <tr>
                                                <tr>
                                                    <td>${i.criteria_id}</td>
                                                    <td>${i.ass_id.tittle}</td>
                                                    <td>${i.criteria_name}</td>
                                                    <td>
                                                        <c:if test="${i.is_team_eval == 1}">Yes</c:if>
                                                        <c:if test="${i.is_team_eval == 0}">No</c:if>
                                                        </td>

                                                        <td style="text-align: center">${i.eval_weight}</td>
                                                    <td>${i.max_loc}</td>
                                                    <td>
                                                        <c:if test="${i.status == 1}">Active</c:if>
                                                        <c:if test="${i.status == 0}">Inactive</c:if>
                                                        </td>
                                                        <td style="text-align: center">
                                                            <a href="assignmentdetails?id=${i.criteria_id}"><button style="height:40px;width:120px" type="button" class="btn btn-success">View</button></a>
                                                        <a  href="assignmentdetails?id=${i.criteria_id}"><button style="height:40px;width:120px" type="button" class="btn btn-primary">Edit</button></a>                                               
                                                        <c:if test="${i.status == 0}">
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
                                                                            Activate ${i.criteria_name}
                                                                        </div>
                                                                        <div class="modal-footer">
                                                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                                            <a href="/SWP391_G1/admin/activeevalcriteria?id=${i.criteria_id}"><button type="button" class="btn btn-primary">Save changes</button></a>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </c:if>
                                                        <c:if test="${i.status == 1}">
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
                                                                            Deactivate ${i.criteria_name}
                                                                        </div>
                                                                        <div class="modal-footer">
                                                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                                            <a href="/SWP391_G1/admin/deactivateevalcriteria?id=${i.criteria_id}"><button type="submit" class="btn btn-primary">Save changes</button></a>
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
                            </c:if>

                            <c:if test="${requestScope.listevalcriteriasearchbyname !=null}">
                                <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                                    <thead>
                                        <tr>
                                            <th class="th-sm">
                                                <c:if test="${requestScope.sort == null || (requestScope.sort != 'ascId' && requestScope.sort != 'descId')}">
                                                    <a  href="evalcriteriallistbysearch?page=${requestScope.page}&sort=ascId&searchTittle=${requestScope.searchTittle}">Id</a>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'ascId'}">
                                                    <a href="evalcriteriallistbysearch?page=${requestScope.page}&sort=descId&searchTittle=${requestScope.searchTittle}">Id</a>
                                                    <i class="bi bi-sort-alpha-down-alt"></i>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'descId'}">
                                                    <a  href="evalcriteriallistbysearch?page=${requestScope.page}&sort=ascId&searchTittle=${requestScope.searchTittle}">Id</a>
                                                    <i class="bi bi-sort-alpha-up "></i>
                                                </c:if>
                                            </th>
                                            <th class="th-sm">
                                                <c:if test="${requestScope.sort == null || (requestScope.sort != 'descAssignmentId' && requestScope.sort != 'ascAssignmentId')}">
                                                    <a href="evalcriteriallistbysearch?page=${requestScope.page}&sort=descAssignmentId&searchTittle=${requestScope.searchTittle}">Assignment</a>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'ascAssignmentId'}">
                                                    <a href="evalcriteriallistbysearch?page=${requestScope.page}&sort=descAssignmentId&searchTittle=${requestScope.searchTittle}">Assignment</a>
                                                    <i class="bi bi-sort-alpha-down-alt"></i>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'descAssignmentId'}">
                                                    <a href="evalcriteriallistbysearch?page=${requestScope.page}&sort=ascAssignmentId&searchTittle=${requestScope.searchTittle}">Assignment</a>
                                                    <i class="bi bi-sort-alpha-up"></i></a>
                                                </c:if>
                                            </th>                                           
                                            <th class="th-sm" style="text-align: center">
                                                <c:if test="${requestScope.sort == null || (requestScope.sort != 'ascCriterianame' && requestScope.sort != 'descCriterianame')}">
                                                    <a  href="evalcriteriallistbysearch?page=${requestScope.page}&sort=ascCriterianame&searchTittle=${requestScope.searchTittle}">Criteria name</a>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'ascCriterianame'}">
                                                    <a href="evalcriteriallistbysearch?page=${requestScope.page}&sort=descCriterianame&searchTittle=${requestScope.searchTittle}">Criteria name</a>
                                                    <i class="bi bi-sort-alpha-down-alt"></i>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'descCriterianame'}">
                                                    <a  href="evalcriteriallistbysearch?page=${requestScope.page}&sort=ascCriterianame&searchTittle=${requestScope.searchTittle}">Criteria name</a>
                                                    <i class="bi bi-sort-alpha-up"></i>
                                                </c:if>
                                            </th>
                                            <th class="th-sm" style="text-align: center">
                                                <c:if test="${requestScope.sort == null || (requestScope.sort != 'ascTeameval' && requestScope.sort != 'descTeameval')}">
                                                    <a  href="evalcriteriallistbysearch?page=${requestScope.page}&sort=ascTeameval&searchTittle=${requestScope.searchTittle}">Team eval</a>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'ascTeameval'}">
                                                    <a href="evalcriteriallistbysearch?page=${requestScope.page}&sort=descTeameval&searchTittle=${requestScope.searchTittle}">Team eval</a>
                                                    <i class="bi bi-sort-alpha-up"></i>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'descTeameval'}">
                                                    <a  href="evalcriteriallistbysearch?page=${requestScope.page}&sort=ascTeameval&searchTittle=${requestScope.searchTittle}">Team eval</a>
                                                    <i class="bi bi-sort-alpha-down-alt"></i>
                                                </c:if>
                                            </th>
                                            <th class="th-sm" style="text-align: center">
                                                <c:if test="${requestScope.sort == null || (requestScope.sort != 'ascEvalWeight' && requestScope.sort != 'descEvalWeight')}">
                                                    <a  href="evalcriteriallistbysearch?page=${requestScope.page}&sort=ascEvalWeight&searchTittle=${requestScope.searchTittle}">Eval weight</a>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'ascEvalWeight'}">
                                                    <a href="evalcriteriallistbysearch?page=${requestScope.page}&sort=descEvalWeight&searchTittle=${requestScope.searchTittle}">Eval weight</a>
                                                    <i class="bi bi-sort-alpha-up"></i>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'descEvalWeight'}">
                                                    <a  href="evalcriteriallistbysearch?page=${requestScope.page}&sort=ascEvalWeight&searchTittle=${requestScope.searchTittle}">Eval weight</a>
                                                    <i class="bi bi-sort-alpha-down-alt"></i>
                                                </c:if>
                                            </th>
                                            <th class="th-sm" style="text-align: center">
                                                <c:if test="${requestScope.sort == null || (requestScope.sort != 'ascMaxloc' && requestScope.sort != 'descMaxloc')}">
                                                    <a  href="evalcriteriallistbysearch?page=${requestScope.page}&sort=ascMaxloc&searchTittle=${requestScope.searchTittle}">Max loc</a>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'ascMaxloc'}">
                                                    <a href="evalcriteriallistbysearch?page=${requestScope.page}&sort=descMaxloc&searchTittle=${requestScope.searchTittle}">Max loc</a>
                                                    <i class="bi bi-sort-alpha-up"></i>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'descMaxloc'}">
                                                    <a  href="evalcriteriallistbysearch?page=${requestScope.page}&sort=ascMaxloc&searchTittle=${requestScope.searchTittle}">Max loc</a>
                                                    <i class="bi bi-sort-alpha-down-alt"></i>
                                                </c:if>
                                            </th>                                         
                                            <th class="th-sm" style="text-align: center">Status

                                            </th>
                                            <th class="th-sm" style="text-align: center">Action

                                            </th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach var="i" items="${requestScope.listevalcriteriasearchbyname}">
                                            <tr>
                                                <td>${i.criteria_id}</td>
                                                <td>${i.ass_id.tittle}</td>
                                                <td>${i.criteria_name}</td>
                                                <td>
                                                    <c:if test="${i.is_team_eval == 1}">Yes</c:if>
                                                    <c:if test="${i.is_team_eval == 0}">No</c:if>
                                                    </td>

                                                    <td>${i.eval_weight}</td>
                                                <td>${i.max_loc}</td>
                                                <td>
                                                    <c:if test="${i.status == 1}">Active</c:if>
                                                    <c:if test="${i.status == 0}">Inactive</c:if>
                                                    </td>
                                                    <td style="text-align: center">
                                                        <a href="assignmentdetails?id=${i.criteria_id}"><button style="height:40px;width:120px" type="button" class="btn btn-success">View/Edit</button></a>                                              
                                                    <c:if test="${i.status == 0}">
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
                                                                        Activate ${i.criteria_name}
                                                                    </div>
                                                                    <div class="modal-footer">
                                                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                                        <a href="/SWP391_G1/admin/activeevalcriteria?id=${i.criteria_id}"><button type="button" class="btn btn-primary">Save changes</button></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </c:if>
                                                    <c:if test="${i.status == 1}">
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
                                                                        Deactivate ${i.criteria_name}
                                                                    </div>
                                                                    <div class="modal-footer">
                                                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                                        <a href="/SWP391_G1/admin/deactivateevalcriteria?id=${i.criteria_id}"><button type="submit" class="btn btn-primary">Save changes</button></a>
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
                                            <li class="page-item"><a class="page-link" href="evalcriteriallistbysearch?page=${prePage}&sort=${requestScope.sort}&searchTittle=${requestScope.searchTittle}">Previous</a></li>
                                                <c:forEach begin="1" end="${requestScope.numberPageHome}" var="i">
                                                <li class="page-item ${i==requestScope.page?"active":""}" ><a class="page-link" href="evalcriteriallistbysearch?page=${i}&sort=${requestScope.sort}&searchTittle=${requestScope.searchTittle}">${i}</a></li>  
                                                </c:forEach>  
                                            <li class="page-item"><a class="page-link" href="evalcriteriallistbysearch?page=${nextPage}&sort=${requestScope.sort}&searchTittle=${requestScope.searchTittle}">Next</a></li>
                                        </ul>
                                    </nav>
                                </div>
                            </c:if>

                            <c:if test="${requestScope.listevalcriteria !=null}">
                                <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                                    <thead>
                                        <tr>
                                            <th class="th-sm" style="text-align: center">                                           
                                                <c:if test="${requestScope.sort == null || (requestScope.sort != 'ascId' && requestScope.sort != 'descId')}">
                                                    <a  href="evalcriterialist?page=${requestScope.page}&sort=ascId">Id</a>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'ascId'}">
                                                    <a href="evalcriterialist?page=${requestScope.page}&sort=descId">Id</a>
                                                    <i class="bi bi-sort-alpha-up"></i>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'descId'}">
                                                    <a  href="evalcriterialist?page=${requestScope.page}&sort=ascId">Id</a>
                                                    <i class="bi bi-sort-alpha-down-alt"></i>
                                                </c:if>
                                            </th>
                                            <th class="th-sm" style="text-align: center">
                                                <c:if test="${requestScope.sort == null || (requestScope.sort != 'descAssignmentId' && requestScope.sort != 'ascAssignmentId')}">
                                                    <a href="evalcriterialist?page=${requestScope.page}&sort=descAssignmentId">Assignment</a>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'descAssignmentId'}">
                                                    <a href="evalcriterialist?page=${requestScope.page}&sort=ascAssignmentId">Assignment</a>
                                                    <i class="bi bi-sort-alpha-up"></i>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'ascAssignmentId'}">
                                                    <a href="evalcriterialist?page=${requestScope.page}&sort=descAssignmentId">Assignment</a>
                                                    <i class="bi bi-sort-alpha-down-alt"></i>
                                                </c:if>
                                            </th>                                           
                                            <th class="th-sm" style="text-align: center">
                                                <c:if test="${requestScope.sort == null || (requestScope.sort != 'ascCriterianame' && requestScope.sort != 'descCriterianame')}">
                                                    <a  href="evalcriterialist?page=${requestScope.page}&sort=ascCriterianame">Criteria name</a>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'ascCriterianame'}">
                                                    <a href="evalcriterialist?page=${requestScope.page}&sort=descCriterianame">Criteria name</a>
                                                    <i class="bi bi-sort-alpha-up"></i>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'descCriterianame'}">
                                                    <a  href="evalcriterialist?page=${requestScope.page}&sort=ascCriterianame">Criteria name</a>
                                                    <i class="bi bi-sort-alpha-down-alt"></i>
                                                </c:if>
                                            </th>
                                            <th class="th-sm" style="text-align: center">
                                                <c:if test="${requestScope.sort == null || (requestScope.sort != 'ascTeameval' && requestScope.sort != 'descTeameval')}">
                                                    <a  href="evalcriterialist?page=${requestScope.page}&sort=ascTeameval">Team eval</a>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'ascTeameval'}">
                                                    <a href="evalcriterialist?page=${requestScope.page}&sort=descTeameval">Team eval</a>
                                                    <i class="bi bi-sort-alpha-up"></i>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'descTeameval'}">
                                                    <a  href="evalcriterialist?page=${requestScope.page}&sort=ascTeameval">Team eval</a>
                                                    <i class="bi bi-sort-alpha-down-alt"></i>
                                                </c:if>
                                            </th>
                                            <th class="th-sm" style="text-align: center">
                                                <c:if test="${requestScope.sort == null || (requestScope.sort != 'ascEvalWeight' && requestScope.sort != 'descEvalWeight')}">
                                                    <a  href="evalcriterialist?page=${requestScope.page}&sort=ascEvalWeight">Eval weight</a>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'ascEvalWeight'}">
                                                    <a href="evalcriterialist?page=${requestScope.page}&sort=descEvalWeight">Eval weight</a>
                                                    <i class="bi bi-sort-alpha-up"></i>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'descEvalWeight'}">
                                                    <a  href="evalcriterialist?page=${requestScope.page}&sort=ascEvalWeight">Eval weight</a>
                                                    <i class="bi bi-sort-alpha-down-alt"></i>
                                                </c:if>
                                            </th>
                                            <th class="th-sm" style="text-align: center">
                                                <c:if test="${requestScope.sort == null || (requestScope.sort != 'ascMaxloc' && requestScope.sort != 'descMaxloc')}">
                                                    <a  href="evalcriterialist?page=${requestScope.page}&sort=ascMaxloc">Max loc</a>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'ascMaxloc'}">
                                                    <a href="evalcriterialist?page=${requestScope.page}&sort=descMaxloc">Max loc</a>
                                                    <i class="bi bi-sort-alpha-up"></i>
                                                </c:if>
                                                <c:if test="${requestScope.sort == 'descMaxloc'}">
                                                    <a  href="evalcriterialist?page=${requestScope.page}&sort=ascMaxloc">Max loc</a>
                                                    <i class="bi bi-sort-alpha-down-alt"></i>
                                                </c:if>
                                            </th>                                         
                                            <th class="th-sm" style="text-align: center">Status

                                            </th>
                                            <th class="th-sm" style="text-align: center">Action

                                            </th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:if test="${requestScope.listevalcriteria !=null}">
                                            <c:forEach var="i" items="${requestScope.listevalcriteria}">
                                                <tr>
                                                    <td>${i.criteria_id}</td>
                                                    <td>${i.ass_id.tittle}</td>
                                                    <td>${i.criteria_name}</td>
                                                    <td>
                                                        <c:if test="${i.is_team_eval == 1}">Yes</c:if>
                                                        <c:if test="${i.is_team_eval == 0}">No</c:if>
                                                        </td>

                                                        <td>${i.eval_weight}</td>
                                                    <td>${i.max_loc}</td>
                                                    <td>
                                                        <c:if test="${i.status == 1}">Active</c:if>
                                                        <c:if test="${i.status == 0}">Inactive</c:if>
                                                        </td>
                                                        <td>
                                                            <a href="assignmentdetails?id=${i.criteria_id}"><button style="height:40px;width:120px" type="button" class="btn btn-success">View/Edit</button></a>
                                                        <c:if test="${i.status == 0}">
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
                                                                            Activate ${i.criteria_name}
                                                                        </div>
                                                                        <div class="modal-footer">
                                                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                                            <a href="/SWP391_G1/admin/activeevalcriteria?id=${i.criteria_id}"><button type="button" class="btn btn-primary">Save changes</button></a>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </c:if>
                                                        <c:if test="${i.status == 1}">
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
                                                                            Deactivate ${i.criteria_name}
                                                                        </div>
                                                                        <div class="modal-footer">
                                                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                                            <a href="/SWP391_G1/admin/deactivateevalcriteria?id=${i.criteria_id}"><button type="submit" class="btn btn-primary">Save changes</button></a>
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
                                            <li class="page-item"><a class="page-link" href="evalcriterialist?page=${prePage}&sort=${requestScope.sort}">Previous</a></li>
                                                <c:forEach begin="1" end="${requestScope.numberPageHome}" var="i">
                                                <li class="page-item ${i==requestScope.page?"active":""}" ><a class="page-link" href="evalcriterialist?page=${i}&sort=${requestScope.sort}">${i}</a></li>  
                                                </c:forEach>  
                                            <li class="page-item"><a class="page-link" href="evalcriterialist?page=${nextPage}&sort=${requestScope.sort}">Next</a></li>
                                        </ul>
                                    </nav>
                                </div>
                            </c:if>

                        </div>
                    </div>
                    <!-- Your Profile Views Chart END-->
                </div>
            </div>
            <input id="toast" value="${requestScope.sussces}" hidden="">
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
