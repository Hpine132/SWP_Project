<%-- 
    Document   : subjectdetails
    Created on : Oct 9, 2022, 11:12:56 AM
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
                    <h3 class="breadcrumb-title">Subject details</h3>
                    <ul class="db-breadcrumb-list">
                        <li><a href="../home.jsp"><i class="fa fa-home"></i>Home</a></li>
                        <li><a href="subjectlist">Subject list</a></li> 
                        <li><a href="subjectdetails">Subject details</a></li>
                    </ul>
                </div>	
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <c:if test="${requestScope.mess==null}"> 
                                <div class="wc-title">
                                    <h4>Subject details</h4>
                                </div>
                                <div class="widget-inner">
                                    <form class="edit-profile m-b30" action="subjectdetails" method="post">                                    
                                        <div class="row">                                        
                                            <div class="col-12">
                                                <div class="ml-auto">
                                                    <c:set var="idNow" value="${requestScope.data.subject_id}"/>                                                    
                                                    <h3>Subject ID</h3> 
                                                    <input class="form-control" type="text" placeholder="${idNow}" readonly=""name="subject_id" value="${idNow}">
                                                </div>
                                            </div>

                                            <div class="form-group col-6">
                                                <label class="col-form-label">Subject Code</label>
                                                <div>
                                                    <input class="form-control" type="text" placeholder="${requestScope.data.subject_code}" name="subject_code" value="${requestScope.data.subject_code}">
                                                </div>
                                            </div>

                                            <div class="form-group col-6">
                                                <label class="col-form-label">Subject Name</label>
                                                <div>
                                                    <input class="form-control" type="text" placeholder="${requestScope.data.subject_name}" name="subject_name" value="${requestScope.data.subject_name}">
                                                </div>
                                            </div>

                                            <div class="form-group col-6">
                                                <label class="col-form-label">Manager</label>
                                                <div>
                                                    <select name="manager_id">
                                                        <c:forEach begin="0" end="${requestScope.manager.size()-1}" var="i">
                                                            <option ${requestScope.manager.get(i).id==requestScope.data.manager_id? "selected":""} value="${requestScope.manager.get(i).id}"  >${requestScope.manager.get(i).name}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>

                                            <div class="form-group col-6">
                                                <label class="col-form-label">Expert</label>
                                                <div>
                                                    <select name="expert_id">
                                                        <c:forEach begin="0" end="${requestScope.expert.size()-1}" var="i">
                                                            <option ${requestScope.expert.get(i).id==requestScope.data.expert_id? "selected":""} value="${requestScope.expert.get(i).id}"  >${requestScope.expert.get(i).name}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>

                                            <div class="form-group col-6">
                                                <label class="col-form-label">Status</label>
                                                <div>
                                                    <select name="status">
                                                        <option ${requestScope.data.status.equals("Active")? "selected":""} value="Active">Active</option>
                                                        <option ${requestScope.data.status.equals("Deactive")? "selected":""} value="Deactive">Deactive</option>
                                                    </select>
                                                </div>
                                            </div>      
                                            <div class="form-group col-12">
                                                <label class="col-form-label">Description</label>
                                                <div>
                                                    <textarea class="form-control" name="description" maxlength="45">${requestScope.data.description}</textarea>                                                                                                
                                                </div>
                                            </div>
                                            <div class="col-12">
                                                <button  class="btn" type="submit">Save changes</button>
                                            </div>                                        
                                        </div>
                                    </form>
                                </div>
                            </div>  
                        </c:if>          
                        <c:if test="${requestScope.mess!=null}"> 
                            <div class="wc-title">
                                <h6>${requestScope.mess}</h6>
                            </div>                            
                            <div class="col-12">
                                <a href="classlist"><button class="btn">Back to class list</button></a>                                
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
</html>
