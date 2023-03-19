<%-- 
    Document   : classlist
    Created on : Oct 9, 2022, 5:32:20 AM
    Author     : User
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
                    <h3 class="breadcrumb-title">Class List</h3>
                    <ul class="db-breadcrumb-list">
                        <li><a href="../home.jsp"><i class="fa fa-home"></i>Home</a></li>
                        <li><a href="classlist"><i class="bi bi-gear"></i>Class List</a></li>
                    </ul>
                </div>	

                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h3>Class List</h3>
                                <form action="classlist" method="GET">                                    
                                    <div class="input-group mt-2 mb-2">
                                        <input type="searchValue" class="form-control rounded" name="searchValue" placeholder="Enter code" value="${requestScope.searchValue}" aria-label="Search" aria-describedby="search-addon" required/>
                                        <button type="submit" class="btn btn-outline-primary">Search</button>
                                    </div>
                                </form>
                            </div> 
                            <div class="wc-title">                                
                                <div style=" float: left;width: 400px;height: 180px;">
                                    <form action="classlist" method="get">
                                        <label for="Type">Term</label>
                                        <input type="hidden" name="filterBy" value="term" />
                                        <select name="filterValue" id="cars">
                                            <c:forEach var="i" items="${requestScope.terms}">
                                                <option value="${i.settingId}">${i.settingTitle}</option>
                                            </c:forEach>                                                                               
                                        </select>
                                        <button type="submit" class="btn btn-primary">Filter</button>
                                    </form>
                                </div>     

                                <div style=" float: left;width: 400px;height: 180px;">
                                    <form action="classlist" method="get">
                                        <label for="Type">Trainer</label>                                        
                                        <input type="hidden" name="filterBy" value="trainer" />
                                        <select name="filterValue" id="cars">
                                            <c:forEach var="i" items="${requestScope.trainers}">
                                                <option value="${i.id}">${i.name}</option>
                                            </c:forEach>                                                                               
                                        </select>
                                        <button type="submit" class="btn btn-primary">Filter</button>                                   
                                    </form>
                                </div> 

                                <div style=" float: left;width: 400px;height: 80px; margin-bottom: 5px; margin-left: 5px">
                                    <form action="classlist" method="get">
                                        <label for="Status">Status</label>               
                                        <input type="hidden" name="filterBy" value="status" />
                                        <select name="filterValue" id="cars">
                                            <option value="Active">Active</option>
                                            <option value="Deactive">Deactivate</option>
                                        </select>
                                        <button type="submit" class="btn btn-primary">Filter</button>  
                                    </form>
                                </div>
                            </div>
                            <c:if test="${requestScope.mess != null }">
                                <div class="alert alert-success alert-dismissible d-flex align-items-center fade show">
                                    <i class="bi-check-circle-fill"></i>
                                    <strong class="mx-2">Update successfully!</strong>
                                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                                </div>                                
                            </c:if>


                            <c:if test="${requestScope.list !=null}">
                                <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                                    <thead>
                                        <tr>
                                            <th class="th-sm" style="text-align: center">ID
                                            </th>
                                            <th class="th-sm" style="text-align: center">
                                                <c:if test="${requestScope.sortById!=1}">
                                                    <a href="classlist?page=1&sortBy=code&sortValue=asc&searchBy=${requestScope.searchBy}&searchValue=${requestScope.searchValue}&filterBy=${requestScope.filterBy}&filterValue=${requestScope.filterValue}">Code</a>
                                                </c:if>
                                                <c:if test="${requestScope.sortById==1}">
                                                    <c:if test="${requestScope.sortValueId==1}">
                                                        <a href="classlist?page=1&sortBy=code&sortValue=desc&searchBy=${requestScope.searchBy}&searchValue=${requestScope.searchValue}&filterBy=${requestScope.filterBy}&filterValue=${requestScope.filterValue}">Code <i class="bi bi-sort-alpha-down"></i></a>
                                                        </c:if>
                                                        <c:if test="${requestScope.sortValueId==2}">
                                                        <a href="classlist?page=1&sortBy=code&sortValue=asc&searchBy=${requestScope.searchBy}&searchValue=${requestScope.searchValue}&filterBy=${requestScope.filterBy}&filterValue=${requestScope.filterValue}">Code <i class="bi bi-sort-alpha-up"></i></a>
                                                        </c:if>
                                                    </c:if>

                                            </th>
                                            <th class="th-sm" style="text-align: center">
                                                <c:if test="${requestScope.sortById!=2}">
                                                    <a href="classlist?page=1&sortBy=term&sortValue=asc&searchBy=${requestScope.searchBy}&searchValue=${requestScope.searchValue}&filterBy=${requestScope.filterBy}&filterValue=${requestScope.filterValue}">Term</a>
                                                </c:if>
                                                <c:if test="${requestScope.sortById==2}">
                                                    <c:if test="${requestScope.sortValueId==1}">
                                                        <a href="classlist?page=1&sortBy=term&sortValue=desc&searchBy=${requestScope.searchBy}&searchValue=${requestScope.searchValue}&filterBy=${requestScope.filterBy}&filterValue=${requestScope.filterValue}">Term <i class="bi bi-sort-alpha-down"></i></a>
                                                        </c:if>
                                                        <c:if test="${requestScope.sortValueId==2}">
                                                        <a href="classlist?page=1&sortBy=term&sortValue=asc&searchBy=${requestScope.searchBy}&searchValue=${requestScope.searchValue}&filterBy=${requestScope.filterBy}&filterValue=${requestScope.filterValue}">Term <i class="bi bi-sort-alpha-up"></i></a>
                                                        </c:if>
                                                    </c:if>
                                            </th>
                                            <th class="th-sm" style="text-align: center">
                                                <c:if test="${requestScope.sortById!=3}">
                                                    <a href="classlist?page=1&sortBy=trainer&sortValue=asc&searchBy=${requestScope.searchBy}&searchValue=${requestScope.searchValue}&filterBy=${requestScope.filterBy}&filterValue=${requestScope.filterValue}">Trainer</a>
                                                </c:if>
                                                <c:if test="${requestScope.sortById==3}">
                                                    <c:if test="${requestScope.sortValueId==1}">
                                                        <a href="classlist?page=1&sortBy=trainer&sortValue=desc&searchBy=${requestScope.searchBy}&searchValue=${requestScope.searchValue}&filterBy=${requestScope.filterBy}&filterValue=${requestScope.filterValue}">Trainer <i class="bi bi-sort-alpha-down"></i></a>
                                                        </c:if>
                                                        <c:if test="${requestScope.sortValueId==2}">
                                                        <a href="classlist?page=1&sortBy=trainer&sortValue=asc&searchBy=${requestScope.searchBy}&searchValue=${requestScope.searchValue}&filterBy=${requestScope.filterBy}&filterValue=${requestScope.filterValue}">Trainer <i class="bi bi-sort-alpha-up"></i></a>
                                                        </c:if>
                                                    </c:if>
                                            </th>
                                            <th class="th-sm" style="text-align: center">
                                                <c:if test="${requestScope.sortById!=4}">
                                                    <a href="classlist?page=1&sortBy=status&sortValue=asc&searchBy=${requestScope.searchBy}&searchValue=${requestScope.searchValue}&filterBy=${requestScope.filterBy}&filterValue=${requestScope.filterValue}">Status</a>
                                                </c:if>
                                                <c:if test="${requestScope.sortById==4}">
                                                    <c:if test="${requestScope.sortValueId==1}">
                                                        <a href="classlist?page=1&sortBy=status&sortValue=desc&searchBy=${requestScope.searchBy}&searchValue=${requestScope.searchValue}&filterBy=${requestScope.filterBy}&filterValue=${requestScope.filterValue}">Status <i class="bi bi-sort-alpha-down"></i></a>
                                                        </c:if>
                                                        <c:if test="${requestScope.sortValueId==2}">
                                                        <a href="classlist?page=1&sortBy=status&sortValue=asc&searchBy=${requestScope.searchBy}&searchValue=${requestScope.searchValue}&filterBy=${requestScope.filterBy}&filterValue=${requestScope.filterValue}">Status <i class="bi bi-sort-alpha-up"></i></a>
                                                        </c:if>
                                                    </c:if>
                                            </th>
                                            <th class="th-sm" style="text-align: center">Action
                                            </th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach var="i" items="${requestScope.list}">
                                            <tr>
                                                <td style="text-align: center"></td>
                                                <td style="text-align: center">${i.class_code}</td>
                                                <td style="text-align: center">${i.term_id.settingTitle}</td>
                                                <td style="text-align: center">${i.trainer_id.name}</td>
                                                <td style="text-align: center">
                                                    <a  href="statusclass?status=${i.status}&id=${i.class_id}"><button style="height:40px;width:120px" type="button" class="btn btn-primary">${i.status.equals("Active")? "Active":"Deactive"}</button></a>  
                                                <td style="text-align: center">
                                                    <a  href="classdetails?id=${i.class_id}"><button style="height:40px;width:120px" type="button" class="btn btn-primary">Edit</button></a>                                                                                                 
                                                </td>
                                            </tr>    
                                        </c:forEach>                                            
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
                                            <li class="page-item"><a class="page-link" href="classlist?page=${prePage}&sortBy=${requestScope.sortBy}&sortValue=${requestScope.sortValue}&searchBy=${requestScope.searchBy}&searchValue=${requestScope.searchValue}&filterBy=${requestScope.filterBy}&filterValue=${requestScope.filterValue}">Previous</a></li>
                                                <c:forEach begin="1" end="${requestScope.pageMax}" var="i">
                                                <li class="page-item ${i==requestScope.page?"active":""}" ><a class="page-link" href="classlist?page=${i}&sortBy=${requestScope.sortBy}&sortValue=${requestScope.sortValue}&searchBy=${requestScope.searchBy}&searchValue=${requestScope.searchValue}&filterBy=${requestScope.filterBy}&filterValue=${requestScope.filterValue}">${i}</a></li>  
                                                </c:forEach>  
                                            <li class="page-item"><a class="page-link" href="classlist?page=${nextPage}&sortBy=${requestScope.sortBy}&sortValue=${requestScope.sortValue}&searchBy=${requestScope.searchBy}&searchValue=${requestScope.searchValue}&filterBy=${requestScope.filterBy}&filterValue=${requestScope.filterValue}">Next</a></li>
                                        </ul>
                                    </nav>
                                </div>
                            </c:if>      
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
    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/bookmark.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:10:19 GMT -->
</html>
