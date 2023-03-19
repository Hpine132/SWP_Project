<%-- 
    Document   : assignmentlist
    Created on : Oct 5, 2022, 4:05:14 PM
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
                    <h4 class="breadcrumb-title">Milestone List</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="../home.jsp"><i class="fa fa-home"></i>Home</a></li>
                        <li><a href="MilestoneList"><i class="bi bi-gear"></i>Milestone List</a></li>
                    </ul>
                </div>
                <form action="newMilestone">
                    <div class="col-12">
                        <button  class="btn" type="submit" style="background-color: blue;color: white">New Milestone</button>
                    </div> 
                </form>
                <br>
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        
                        <div class="widget-box">
                            <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                                <tr>
                                    <th class="th-sm" style="text-align: center">ID     
                                        <a href="MilestoneList?page=${requestScope.page}&sort=ascId">
                                            <i class="bi bi-sort-alpha-up" style="background:${requestScope.sort == 'ascId' ? "gainsboro":""}"></i>
                                        </a>
                                        <a  href="MilestoneList?page=${requestScope.page}&sort=descId">                                                
                                            <i class="bi bi-sort-alpha-down-alt" style="background:${requestScope.sort == 'descId' ? "gainsboro":""}"></i>                                               
                                        </a>
                                    </th>
                                    <th class="th-sm" style="text-align: center">Title
                                    </th>
                                    <th class="th-sm" style="text-align: center">Start date
                                    </th>
                                    <th class="th-sm" style="text-align: center">End date
                                    </th>
                                    <th class="th-sm" style="text-align: center">Status
                                    </th>
                                    <th class="th-sm" style="text-align: center">Action
                                    </th>
                                </tr>

                                <c:if test="${sessionScope.listMilestone!= null}">
                                    <c:forEach var="m" items="${sessionScope.listMilestone}">
                                        <tr>
                                            <td style="text-align: center">${m.getMileId()}</td>
                                            <td style="text-align: left">${m.getTitle()}</td>
                                            <td style="text-align: center">${m.getFrom_date()}</td>
                                            <td style="text-align: center">${m.getTo_date()}</td>
                                            <td style="text-align: center">${m.getStatus()}</td>
                                            <td style="text-align: center">
                                                <a href="MilestoneDetail?id=${m.getMileId()}"><button style="height:40px;width:120px" type="button" class="btn btn-success">View</button></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:if>
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
                                        <li class="page-item"><a class="page-link" href="MilestoneList?page=${prePage}&sort=${requestScope.sort}">Previous</a></li>
                                            <c:forEach begin="1" end="${requestScope.numberPageHome}" var="i">
                                            <li class="page-item ${i==requestScope.page?"active":""}" ><a class="page-link" href="MilestoneList?page=${i}&sort=${requestScope.sort}">${i}</a></li>  
                                            </c:forEach>  
                                        <li class="page-item"><a class="page-link" href="MilestoneList?page=${nextPage}&sort=${requestScope.sort}">Next</a></li>
                                    </ul>
                                </nav>
                            </div>
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
