<%-- 
    Document   : assignmentdetails
    Created on : Oct 6, 2022, 10:42:00 AM
    Author     : Admin
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

        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
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
                    <h4 class="breadcrumb-title">Team details</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="../home.jsp"><i class="fa fa-home"></i>Home</a></li>
                        <li><a href="assignmentlist">Team list</a></li>     
                        <li>Team details</li>  
                    </ul>
                </div>	
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>Team details</h4>
                            </div>
                            <form class="edit-profile m-b30" action="teamdetail" method="POST">                                    
                                <div class="row">                                        
                                    <input name="teamid" value="${requestScope.team.teamId}" hidden readonly>
                                    <div class="form-group col-6">
                                        <label class="col-form-label">Class</label>
                                        <div>
                                            <input class="form-control" type="text" value="${requestScope.team.classId.class_code}" readonly name="classid">
                                        </div>
                                    </div>
                                    <div class="form-group col-6">
                                        <label class="col-form-label">Team Code*</label>
                                        <div>
                                            <input class="form-control" type="text" value="${requestScope.team.teamCode}" name="TeamCode">
                                        </div>
                                    </div>
                                    <div class="form-group col-6">
                                        <label class="col-form-label">Topic name*</label>
                                        <div>
                                            <input class="form-control" type="text" value="${requestScope.team.topicName}" name="topicName">
                                        </div>
                                    </div>
                                    <div class="form-group col-6">
                                        <label class="col-form-label">Status</label>
                                        <div>
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="status" value="1" ${requestScope.team.status == 1 ?"checked":""}>
                                                <label class="form-check-label" for="flexRadioDefault1">
                                                    Activate
                                                </label>    
                                            </div>
                                            
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="status" value="0" ${requestScope.team.status == 0 ?"checked":""}>
                                                <label class="form-check-label" for="flexRadioDefault2">
                                                    Deactivate
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group col-6">
                                                <div style="display: flex;">
                                                    <label class="col-form-label">Team Member</label>
                                                    <c:forEach var="i" items="${requestScope.listmember}">
                                                        <div style="margin: 10px">
                                                        <button type="button" class="btn btn-secondary">${i.userId.name}
                                                        <c:if test="${i.isLeadder == 1}">
                                                                            <i class="ti-user"></i>
                                                        </c:if>
                                                                            <br>
                                                                            ID:${i.userId.id}
                                                        </button>
                                                    </div>
                                                    </c:forEach>
                                                    

                                                </div>

                                            </div>
                                    <div class="form-group col-12">
                                        <label class="col-form-label">Description</label>
                                        <div>
                                            <textarea class="form-control" name="description" required>${requestScope.team.description}</textarea>                                                                                                
                                        </div>
                                    </div>           
                                    <div class="col-12">
                                        <button  class="btn" type="submit" style="background-color: blue;color: white">Save changes</button>
                                    </div>  
                                </div> 
                            </form>
                        </div>
                        <!-- Your Profile Views Chart END-->
                    </div>
                </div>
                <!-- Success Alert -->
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
</html>
