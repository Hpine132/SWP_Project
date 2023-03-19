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
                    <h4 class="breadcrumb-title">Team List</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="../home.jsp"><i class="fa fa-home"></i>Home</a></li>
                        <li><a href="teamList"><i class="bi bi-gear"></i>Team List</a></li>
                    </ul>
                </div>	
                <h5>New Teams</h5>
                <nav class="nav nav-tabs justify-content-center">
                    <a class="nav-link ${requestScope.selected == null ?  "active":""}" id="random-tab" data-toggle="tab" href="#random">Random</a>
                    <a class="nav-link ${requestScope.selected == 'reuse' ?  "active":""}" id="reuse-tab" data-toggle="tab" href="#reuse">Reuse group</a>
                    <a class="nav-link" id="clone-tab" data-toggle="tab" href="#clone">Clone group</a>
                </nav>
                <div class="tab-content">
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
                    <div class="tab-pane fade ${requestScope.selected == null ?  "show active":""}" id="random">
                        <form action="teamsrandom" method="POST">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th style="text-align: center">Class size: ${requestScope.numberstudentsofcalss} Students</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th style="text-align: center">How many group do you want to create?</th>                                    
                                    </tr>
                                    <tr>
                                        <th style="">
                                            <input style="width: 100px;margin: auto" name="numbergroup" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" type="number" required min="2" max="${requestScope.numberstudentsofcalss}" value="${requestScope.numbergroup}">
                                        </th>                                   
                                    </tr>
                                </tbody>
                            </table>
                            <c:if test="${requestScope.ListTeam == null}">
                                <h4>Create group randomly</h3>
                                    <h6>Step1: The system will be display the number of students in a slot and ask you to type the number of group to create</h5>
                                        <h6>Step2: Click "Next step" to preview groups with random number.</h6>                        
                                        <h6>Step3: Click "Finish" to complete creating groups randomly</h6>
                                    </c:if>
                                    <div style="display: flex;justify-content: right">
                                        <c:if test="${sessionScope.ListTeam == null}">
                                            <div><button type="submit" class="btn btn-success">Next step</button></div>   
                                        </c:if>
                                        <c:if test="${sessionScope.ListTeam != null}">
                                            <div style="margin-right: 10px"><button type="submit" class="btn btn-success">Roll again</button></div>  
                                            <div><a href="/SWP391_G1/trainer/teamsrandom?save=true&groups=${requestScope.numbergroup}"><button type="Button" class="btn btn-success">Finish</button></div></a>   
                                        </c:if>
                                    </div>
                                    <br>
                                    <c:if test="${sessionScope.ListTeam != null}">
                                        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                                            <c:forEach var="i" items="${sessionScope.ListTeam}">
                                                <c:set var="teamid" value="${i.teamId}"></c:set>
                                                    <div class="col mb-5">                                               
                                                        <div>
                                                            <ul class="list-group">
                                                                <li class="list-group-item active">${i.teamCode}</li>
                                                                <c:forEach var="l" items="${sessionScope.listTeamMember}">
                                                                    <c:if test="${i.teamId == l.teamId.teamId}">
                                                                    <li class="list-group-item">${l.userId.name}
                                                                        <c:if test="${l.isLeadder == 1}">
                                                                            <i class="ti-user"></i>
                                                                        </c:if>
                                                                    </li>

                                                                </c:if>
                                                            </c:forEach>
                                                        </ul>
                                                    </div>                                            
                                                </div> 
                                            </c:forEach>

                                        </div>
                                    </c:if>
                                    </form>
                                    </div>
                                    <div class="tab-pane fade ${requestScope.selected == 'reuse' ?  "show active":""}" id="reuse">
                                        <form action="reuseteam" method="POST">
                                            <c:forEach var="i" items="${requestScope.listMilestoneSubmit}">
                                                <div class="input-group" style="margin-bottom: 5px;margin-top: 5px">
                                                    <div class="input-group-prepend">
                                                        <div class="input-group-text">
                                                            <input type="radio" aria-label="Radio button for following text input" name="milestoneid" value="${i.mileId}" ${requestScope.chose == i.mileId ? "checked":""}>
                                                        </div>
                                                    </div>
                                                    <input type="text" class="form-control" aria-label="Text input with radio button" value="${i.title}:${i.assBody}">
                                                </div>  
                                            </c:forEach>
                                            <div style="display: flex;justify-content: right;margin-bottom: 5px">
                                                <c:if test="${sessionScope.ListTeamRe == null}">
                                                    <div><button type="submit" class="btn btn-success">Next step</button></div>   
                                                </c:if>
                                                <c:if test="${sessionScope.ListTeamRe != null}">
                                                    <div style="margin-right: 10px"><button type="submit" class="btn btn-success">Chose again</button></div>  
                                                    <div><a href="/SWP391_G1/trainer/reuseteam?milId=${requestScope.chose}"><button type="Button" class="btn btn-success">Finish</button></div></a>   
                                                </c:if>
                                            </div>
                                        </form>
                                        <c:if test="${sessionScope.ListTeamRe != null}">
                                            <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                                                <c:forEach var="i" items="${sessionScope.ListTeamRe}">
                                                    <c:set var="teamid" value="${i.teamId}"></c:set>
                                                        <div class="col mb-5">                                               
                                                            <div>
                                                                <ul class="list-group">
                                                                    <li class="list-group-item active">${i.teamCode}</li>
                                                                    <c:forEach var="l" items="${sessionScope.listTeamMembeRe}">
                                                                        <c:if test="${i.teamId == l.teamId.teamId}">
                                                                        <li class="list-group-item">${l.userId.name}
                                                                            <c:if test="${l.isLeadder == 1}">
                                                                                <i class="ti-user"></i>
                                                                            </c:if>
                                                                        </li>

                                                                    </c:if>
                                                                </c:forEach>
                                                            </ul>
                                                        </div>                                            
                                                    </div> 
                                                </c:forEach>

                                            </div>
                                        </c:if>
                                    </div>
                                    <div class="tab-pane fade ${requestScope.selected == 'clone' ?  "show active":""}" id="clone">
                                        <form action="cloneteam" method="POST">
                                            <c:forEach var="i" items="${requestScope.listMilestoneSubmit}">
                                                <div class="input-group" style="margin-bottom: 5px;margin-top: 5px">
                                                    <div class="input-group-prepend">
                                                        <div class="input-group-text">
                                                            <input type="radio" aria-label="Radio button for following text input" name="milestoneid" value="${i.mileId}" ${requestScope.chose == i.mileId ? "checked":""}>
                                                        </div>
                                                    </div>
                                                    <input type="text" class="form-control" aria-label="Text input with radio button" value="${i.title}:${i.assBody}">
                                                </div>  
                                            </c:forEach>
                                            <div style="display: flex;justify-content: right;margin-bottom: 5px">
                                                <c:if test="${sessionScope.ListTeamCl == null}">
                                                    <div><button type="submit" class="btn btn-success">Next step</button></div>   
                                                </c:if>
                                                <c:if test="${sessionScope.ListTeamCl != null}">
                                                    <div style="margin-right: 10px"><button type="submit" class="btn btn-success">Choses again</button></div>  
                                                    <div><a href="/SWP391_G1/trainer/cloneteam"><button type="Button" class="btn btn-success">Finish</button></div></a>   
                                                </c:if>
                                            </div>
                                        </form>
                                        <c:if test="${sessionScope.ListTeamCl != null}">
                                            <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                                                <c:forEach var="i" items="${sessionScope.ListTeamCl}">
                                                    <c:set var="teamid" value="${i.teamId}"></c:set>
                                                        <div class="col mb-5">                                               
                                                            <div>
                                                                <ul class="list-group">
                                                                    <li class="list-group-item active">${i.teamCode}</li>
                                                                    <c:forEach var="l" items="${sessionScope.listTeamMembeCl}">
                                                                        <c:if test="${i.teamId == l.teamId.teamId}">
                                                                        <li class="list-group-item">${l.userId.name}
                                                                            <c:if test="${l.isLeadder == 1}">
                                                                                <i class="ti-user"></i>
                                                                            </c:if>
                                                                        </li>

                                                                    </c:if>
                                                                </c:forEach>
                                                            </ul>
                                                        </div>                                            
                                                    </div> 
                                                </c:forEach>

                                            </div>
                                        </c:if>
                                    </div>
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
