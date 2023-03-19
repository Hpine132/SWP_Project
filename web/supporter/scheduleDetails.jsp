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
                    <h4 class="breadcrumb-title">Schedule details</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="../home.jsp"><i class="fa fa-home"></i>Home</a></li>
                        <li><a href="ScheduleList">Schedule list</a></li>     
                        <li>Schedule details</li>  
                    </ul>
                </div>	
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>Schedule details</h4>
                            </div>
                            <div class="widget-inner">
                                <form class="edit-profile m-b30" action="ScheduleDetails" method="post">                                    
                                    <div class="row">
                                        <div class="form-group col-3" >
                                            <label class="col-form-label" style="font-weight: bold">Class</label>
                                            <input name="classList" type="text" value="${requestScope.classList.getClass_code()}" readonly>
                                        </div>
                                        <div hidden><input name="id" value="${requestScope.schedule.getSchedule_id()}">${requestScope.schedule.getSchedule_id()}</div>
                                        <div class="form-group col-3" >
                                            <label class="col-form-label" style="font-weight: bold">Slot</label>
                                            <select name="slotList">
                                                <c:forEach var="item" items="${requestScope.slotList}">
                                                    <c:if test="${item.getSetting_value() eq 'Slot 1'}">
                                                        <option class="form-control" value="${item.getSetting_id()}"<c:if test="${requestScope.schedule.getSlot()==item.getSetting_value()}"> selected</c:if>>${item.getSetting_value()}</option>  
                                                    </c:if>
                                                    <c:if test="${item.getSetting_value() eq 'Slot 2'}">
                                                        <option class="form-control" value="${item.getSetting_id()}"<c:if test="${requestScope.schedule.getSlot()==item.getSetting_value()}"> selected</c:if>>${item.getSetting_value()}</option>  
                                                    </c:if>
                                                    <c:if test="${item.getSetting_value() eq 'Slot 3'}">
                                                        <option class="form-control" value="${item.getSetting_id()}"<c:if test="${requestScope.schedule.getSlot()==item.getSetting_value()}"> selected</c:if>>${item.getSetting_value()}</option>  
                                                    </c:if>
                                                    <c:if test="${item.getSetting_value() eq 'Slot 4'}">
                                                        <option class="form-control" value="${item.getSetting_id()}"<c:if test="${requestScope.schedule.getSlot()==item.getSetting_value()}"> selected</c:if>>${item.getSetting_value()}</option>  
                                                    </c:if>
                                                    <c:if test="${item.getSetting_value() eq 'Slot 5'}">
                                                        <option class="form-control" value="${item.getSetting_id()}"<c:if test="${requestScope.schedule.getSlot()==item.getSetting_value()}"> selected</c:if>>${item.getSetting_value()}</option>  
                                                    </c:if>
                                                    <c:if test="${item.getSetting_value() eq 'Slot 6'}">
                                                        <option class="form-control" value="${item.getSetting_id()}"<c:if test="${requestScope.schedule.getSlot()==item.getSetting_value()}"> selected</c:if>>${item.getSetting_value()}</option>  
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group col-3" >
                                            <label class="col-form-label" style="font-weight: bold">Room</label>
                                            <select name="roomList">
                                                <c:forEach var="item" items="${requestScope.roomList}">
                                                    <option class="form-control" value="${item.getSetting_id()}"<c:if test="${requestScope.schedule.getRoom()==item.getSetting_value()}"> selected</c:if>>${item.getSetting_value()}</option> 
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group col-6" id="content"></div>
                                        <div class="form-group col-12">
                                            <label class="col-form-label" style="font-weight: bold">Training date</label>
                                            <div>
                                                <input class="form-control" type="date" name="training_date" value="${requestScope.schedule.getTraining_date1()}"required>
                                            </div>
                                        </div>
                                        <div class="form-group col-3" >
                                            <label class="col-form-label" style="font-weight: bold">Start time</label>
                                            <input type="time" name="from_time" value="${requestScope.from_time}" readonly>
                                        </div>
                                        <div class="form-group col-3" >
                                            <label class="col-form-label" style="font-weight: bold">End time</label>
                                            <input type="time" name="to_time" value="${requestScope.to_time}"readonly>
                                        </div>
                                        <div class="form-group col-12">
                                            <label class="col-form-label" style="font-weight: bold">Status</label>
                                            <div>
                                                <c:if test="${requestScope.schedule.getStatus()==1 }">
                                                    <input type="radio" name="status" value="Pending" checked>Pending
                                                    <input type="radio" name="status" value="Taken">Taken
                                                </c:if>
                                                <c:if test="${requestScope.schedule.getStatus()==0}">
                                                    <input type="radio" name="status" value="Pending" >Pending
                                                    <input type="radio" name="status" value="Taken"checked>Taken
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
