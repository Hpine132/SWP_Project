<%-- 
    Document   : attendancedetails
    Created on : Oct 23, 2022, 4:24:39 AM
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
                    <h3 class="breadcrumb-title">Attendance Details</h3>
                    <ul class="db-breadcrumb-list">
                        <li><a href="../home.jsp"><i class="fa fa-home"></i>Home</a></li>
                        <li><a href="attendancedetails"><i class="bi bi-gear"></i>Attendance Details</a></li>
                    </ul>
                </div>	

                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h3>Attendance Details ${requestScope.datasize}</h3>
                                <div class="dropdown">
                                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Choose Class
                                    </button>
                                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                        <c:forEach var="i" items="${requestScope.listClass}">
                                            <a class="dropdown_item" href="attendancedetails?class_id=${i.class_id}">${i.class_code}</a>
                                        </c:forEach>
                                    </div>
                                </div>                                
                            </div>

                            <c:if test="${requestScope.listSchedule!=null}">
                                <div class="wc-title">                                
                                    <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                                        <thead>
                                            <tr>
                                                <th class="th-sm" style="text-align: center">Training date</th>
                                                <th class="th-sm" style="text-align: center">From time</th>
                                                <th class="th-sm" style="text-align: center">To time</th>
                                                <th class="th-sm" style="text-align: center">Action</th>
                                            </tr>                                            
                                        </thead>
                                        <tbody>
                                            <c:forEach var="i" items="${requestScope.listSchedule}">
                                                <tr>
                                                    <td style="text-align: center">${i.training_date}</td>
                                                    <td style="text-align: center">${i.from_time}</td>
                                                    <td style="text-align: center">${i.to_time}</td>
                                                    <td style="text-align: center">
                                                        <a  href="attendancedetails?schedule_id=${i.schedule_id}"><button style="height:40px;width:120px" type="button" class="btn btn-primary">Edit</button></a>                                                                                                 
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </c:if>
                           
                            <c:if test="${sessionScope.data!=null and sessionScope.data.size()!=0}">
                                <div class="wc-title">
                                    <h5 class="breadcrumb-title">Attendance for ${sessionScope.data.get(0).class_id.trainer_id.name} on ${sessionScope.data.get(0).schedule_id.training_date} slot from ${sessionScope.data.get(0).schedule_id.from_time} to ${sessionScope.data.get(0).schedule_id.to_time}</h5>
                                    <form action="takeattendance" method="POST">
                                        <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
                                            <thead>
                                                <tr>
                                                    <th class="th-sm" style="text-align: center">Class</th>
                                                    <th class="th-sm" style="text-align: center">Trainee ID</th>
                                                    <th class="th-sm" style="text-align: center">Full name</th>
                                                    <th class="th-sm" style="text-align: center">Absent</th>
                                                    <th class="th-sm" style="text-align: center">Late</th>
                                                    <th class="th-sm" style="text-align: center">Present</th>
                                                    <th class="th-sm" style="text-align: center">Comment</th>
                                                    <th class="th-sm" style="text-align: center">Image</th>                                                
                                                </tr>                                            
                                            </thead>
                                            <tbody>
                                                <c:forEach var="i" items="${sessionScope.data}">
                                                    <tr>
                                                        <td style="text-align: center">${i.class_id.class_code}</td>
                                                        <td style="text-align: center">${i.trainee_id.id}</td>
                                                        <td style="text-align: center">${i.trainee_id.name}</td>
                                                        <td style="text-align: center"> <input type="radio" name="${i.trainee_id.id}" value="absent" ${(i.status.equals("absent"))? "checked":""}/>Absent</td>
                                                        <td style="text-align: center"> <input type="radio" name="${i.trainee_id.id}" value="late" ${(i.status.equals("late"))? "checked":""} />Late</td>
                                                        <td style="text-align: center"> <input type="radio" name="${i.trainee_id.id}" value="present" ${(i.status.equals("present"))? "checked":""}/>Present</td>
                                                        <td style="text-align: center"><input type="text" name="${i.trainee_id.id}comment" value="${i.comment}" class="form-control"/></td>
                                                        <td style="text-align: center"><img style="width: 150px"src="${i.trainee_id.avatar}"></td>                                                    
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                        <button type="submit" class="btn btn-outline-primary">Submit</button>
                                    </form>
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
