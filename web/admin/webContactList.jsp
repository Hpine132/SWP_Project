<%-- 
    Document   : webContactList
    Created on : Sep 22, 2022, 3:21:02 PM
    Author     : User
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
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
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
        <!-- JavaScript Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>

    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">
         <%@include file = "../components/headerstartadmin.jsp"%>                        
        <!-- header end -->
        <!-- Left sidebar menu start -->
        <%@include file = "../components/Leftsidebarmenustart.jsp" %>
        <!-- Left sidebar menu end -->

        <!--Main container start -->
        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">Web Contacts List</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>Web Contacts List</li>
                    </ul>
                </div>	
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>Web Contacts List</h4>

                            </div>
                            <div class="widget-inner">
                                <div class="row">
                                    <div class="col-sm-12 wrap-sort-by">
                                        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
                                        <div class="row">
                                            <div class="col-xs-6 col-md-4 mt-3 mb-3">
                                                <form action="webcontactlist" method="get">
                                                    <h4>Search by:</h4>
                                                    <input type="radio" name="searchBy" value="category_id" checked="true" /> Category ID
                                                    <input type="radio" name="searchBy" value="Supporter_id" /> Supporter ID
                                                    <div class="input-group">
                                                        <input type="number" class="form-control" name="searchValue"placeholder="Value" id="txtSearch" value="" required/>
                                                        <div class="input-group-btn">
                                                            <button type= submit class="btn btn-primary" >
                                                                <span class="glyphicon glyphicon-search"></span>
                                                            </button>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                                    <thead>
                                        <tr>
                                            <th class="th-sm">Id
                                                <a href="webcontactlist?page=${requestScope.page}&sortBy=contact_id&sortValue=asc&searchBy=${requestScope.searchBy}&searchValue=${requestScope.searchValue}"><i class="bi bi-sort-alpha-down-alt"></i></a>
                                                <a href="webcontactlist?page=${requestScope.page}&sortBy=contact_id&sortValue=desc&searchBy=${requestScope.searchBy}&searchValue=${requestScope.searchValue}"><i class="bi bi-sort-alpha-up "></i></a>
                                            </th>
                                            <th class="th-sm">Category ID
                                                <a href="webcontactlist?page=${requestScope.page}&sortBy=category_id&sortValue=asc&searchBy=${requestScope.searchBy}&searchValue=${requestScope.searchValue}"><i class="bi bi-sort-alpha-down-alt"></i></a>
                                                <a href="webcontactlist?page=${requestScope.page}&sortBy=category_id&sortValue=desc&searchBy=${requestScope.searchBy}&searchValue=${requestScope.searchValue}"><i class="bi bi-sort-alpha-up "></i></a>
                                            </th>
                                            <th class="th-sm">Supporter ID
                                                <a href="webcontactlist?page=${requestScope.page}&sortBy=supporter_id&sortValue=asc&searchBy=${requestScope.searchBy}&searchValue=${requestScope.searchValue}"><i class="bi bi-sort-alpha-down-alt"></i></a>
                                                <a href="webcontactlist?page=${requestScope.page}&sortBy=supporter_id&sortValue=desc&searchBy=${requestScope.searchBy}&searchValue=${requestScope.searchValue}"><i class="bi bi-sort-alpha-up "></i></a>
                                            </th>
                                            <th class="th-sm">Email
                                            </th>                                           
                                            <th class="th-sm">Response</th>
                                            <th class="th-sm">Action
                                            </th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:if test="${requestScope.contacts.size()!=0}">
                                            <c:forEach var="i" items="${requestScope.contacts}">
                                                <tr>
                                                    <td>${i.contact_id}</td>
                                                    <td>${i.category_id}</td>                                                   </td>
                                                    <td>${i.supporter_id}</td>
                                                    <td>${i.email}</td> 
                                                    <td><c:if test="${i.response != null}">
                                                            Yet
                                                        </c:if>
                                                        <c:if test="${i.response == null}">
                                                            Not yet
                                                        </c:if>
                                                    </td>                                         
                                                    <td>
                                                        <a href="webcontactdetails?contact_id=${i.contact_id}"><button type="button" class="btn btn-success">View</button></a>
                                                    </td>
                                                </tr>    
                                            </c:forEach>                                                            
                                        </c:if>
                                    </tbody>                               
                                </table>
                                
                                <c:if test="${requestScope.pageMax == 1}">
                                    <c:set var="prePage" value="1"/>
                                    <c:set var="nextPage" value="1"/>
                                </c:if>            
                                <c:if test="${requestScope.page == 1&&requestScope.pageMax != 1}">
                                    <c:set var="prePage" value="1"/>
                                    <c:set var="nextPage" value="2"/>
                                </c:if>
                                <c:if test="${requestScope.page == requestScope.pageMax&&requestScope.page != 1}">
                                    <c:set var="nextPage" value="${requestScope.pageMax}"/>
                                    <c:set var="prePage" value="${requestScope.pageMax-1}"/>
                                </c:if>
                                <c:if test="${requestScope.page != 1 && requestScope.page != requestScope.pageMax}">
                                    <c:set var="prePage" value="${requestScope.page-1}"/>
                                    <c:set var="nextPage" value="${requestScope.page+1}"/>
                                </c:if>
                                <div class="d-flex justify-content-center">
                                    <nav aria-label="Page navigation example ">
                                        <ul class="pagination">
                                            <li class="page-item"><a class="page-link" href="webcontactlist?page=${prePage}&sortBy=${requestScope.sortBy}&sortValue=${requestScope.sortValue}&searchBy=${requestScope.searchBy}&searchValue=${requestScope.searchValue}">Previous</a></li>
                                                <c:forEach begin="1" end="${requestScope.pageMax}" var="i">
                                                <li class="page-item ${i==requestScope.page?"active":""}" ><a class="page-link" href="webcontactlist?page=${i}&sortBy=${requestScope.sortBy}&sortValue=${requestScope.sortValue}&searchBy=${requestScope.searchBy}&searchValue=${requestScope.searchValue}">${i}</a></li>  
                                                </c:forEach>  
                                            <li class="page-item"><a class="page-link" href="webcontactlist?page=${nextPage}&sortBy=${requestScope.sortBy}&sortValue=${requestScope.sortValue}&searchBy=${requestScope.searchBy}&searchValue=${requestScope.searchValue}">Next</a></li>
                                        </ul>
                                    </nav>
                                </div>


                            </div>
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
        <script src='assets/vendors/calendar/moment.min.js'></script>
        <script src='assets/vendors/calendar/fullcalendar.js'></script>
        <script src='assets/vendors/switcher/switcher.js'></script>

    </body>
</html>
