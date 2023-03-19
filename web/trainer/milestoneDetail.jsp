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
        <style>
            .popup {
                width: 40px;
                background: #fff;
                border-radius: 6px;
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-10%,-50%) scale(0.1);
                text-align: center;
                padding: 0 30px 30px;
                color:#333;
                visibility: hidden;
                transition: transform 0.4s, top 0.4s;
            }
            .open-popup {
                visibility: visible;
                top: 50%;
                transform: translate(-50%,-50%) scale(1);
            }
            .popup p {
                font-size: 20px;
                font-weight: 500;
                margin: 30px 0 10px;
                color: #333;
            }
            .popup but{
                width: 100%;
                margin-top: 50px;
                padding: 10px 0;
                background: #6fd649;
                color: #fff;
                border: 0;
                outline: none;
                font-size: 18px;
                border-radius: 4px;
                cursor: pointer;
                box-shadow: 0 5px 5px rgba(0,0,0,0.2);
            }
        </style>
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
                    <h4 class="breadcrumb-title">Milestone details</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="../home.jsp"><i class="fa fa-home"></i>Home</a></li>
                        <li><a href="MilestoneList">Milestone list</a></li>     
                        <li>Milestone details</li>  
                    </ul>
                </div>	
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>Milestone details</h4>
                            </div>
                            <div class="widget-inner">
                                <form class="edit-profile m-b30" action="MilestoneDetail" method="post">                      
                                    <c:if test="${requestScope.messs != null }">
                                        <div class="alert alert-success alert-dismissible d-flex align-items-center fade show">
                                            <i class="bi-check-circle-fill"></i>
                                            <strong class="mx-2">Update successfully!</strong>
                                            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                                        </div>                                
                                    </c:if>
                                    <div class="row">
                                        <div class="form-group col-6"hidden>
                                            <label class="col-form-label" style="font-weight: bold">Milestone ID</label>
                                            <div>
                                                <input class="form-control" type="text" value="${requestScope.milestoneById.mileId}" readonly name="mileId" >
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label" style="font-weight: bold">Subject</label>
                                            <div>
                                                <input class="form-control" type="text" value="${requestScope.ass}" readonly name="ass_id">
                                            </div>
                                        </div>
                                        <div class="form-group col-6" hidden>
                                            <label class="col-form-label" style="font-weight: bold">Class Id</label>
                                            <div>
                                                <input class="form-control" type="text" value="${requestScope.milestoneById.classId}" readonly name="class_id">
                                            </div>
                                        </div>
                                        <div class="form-group col-12">
                                            <label class="col-form-label" style="font-weight: bold">Tittle</label><label style="color: red">*</label>
                                            <div>
                                                <input class="form-control" name="tittle" value="${requestScope.milestoneById.title}  " required>                                                                                          
                                            </div>
                                        </div>
                                        <div class="form-group col-12">
                                            <label class="col-form-label" style="font-weight: bold">Start date</label><label style="color: red">*</label>
                                            <div>
                                                <input class="form-control" type="date" value="${requestScope.milestoneById.from_date}" name="from_date">
                                            </div>
                                        </div>
                                        <div class="form-group col-12">
                                            <label class="col-form-label" style="font-weight: bold">End date</label><label style="color: red">*</label>
                                            <div>
                                                <input class="form-control" type="date" value="${requestScope.milestoneById.to_date}" name="to_date">
                                            </div>
                                        </div>

                                        <div class="form-group col-12">
                                            <label class="col-form-label" style="font-weight: bold">Assignment Body</label>
                                            <div>
                                                <textarea class="form-control" name="assBody">${requestScope.milestoneById.assBody}</textarea>                                                                                                
                                            </div>
                                        </div>
                                        <div class="form-group col-12">
                                            <label class="col-form-label" style="font-weight: bold">Description</label>
                                            <div>
                                                <textarea class="form-control" name="description">${requestScope.milestoneById.description}</textarea>                                                                                                
                                            </div>
                                        </div>
                                        <div class="form-group col-12">
                                            <label class="col-form-label" style="font-weight: bold">Status</label><label style="color: red">*</label>
                                            <div>
                                                <c:if test="${requestScope.milestoneById.status eq 'Pending'}">
                                                    <input type="radio" name="status" value="Open" checked>Pending
                                                    <input type="radio" name="status" value="In progress">In progress
                                                    <input type="radio" name="status" value="Closed">Closed
                                                </c:if>
                                                <c:if test="${requestScope.milestoneById.status eq 'In progress'}">
                                                    <input type="radio" name="status" value="Open" >Pending
                                                    <input type="radio" name="status" value="In progress"checked>In progress
                                                    <input type="radio" name="status" value="Closed">Closed
                                                </c:if>
                                                <c:if test="${requestScope.milestoneById.status eq 'Closed'}">
                                                    <input type="radio" name="status" value="Open" >Pending
                                                    <input type="radio" name="status" value="In progress">In progress
                                                    <input type="radio" name="status" value="Closed"checked>Closed
                                                </c:if>
                                            </div>
                                        </div>
                                        <div class="col-12">
                                            <button type="submit" style="background-color: blue;color: white">Save changes</button>
                                        </div>

                                    </div>
                                </form>

                            </div>
                        </div>                                 
                    </div>
                    <!-- Your Profile Views Chart END-->
                </div>
            </div>
            <!-- Success Alert -->
        </main>
        <div class="ttr-overlay"></div>
        <script>
            let popup = document.getElementById("popup");
            function showMess() {
                popup.classList.add("open-popup");
            }
            function hideMess() {
                popup.classList.remove("open-popup");
            }
        </script>
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
