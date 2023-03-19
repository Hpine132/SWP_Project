<%-- 
    Document   : webcontactdetail
    Created on : Sep 24, 2022, 2:49:02 PM
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
                    <h4 class="breadcrumb-title">Web contact details</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li><a href="webcontactlist">Web contact list</a></li>     
                        <li>Web contact details</li>  
                    </ul>
                </div>	
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <c:if test="${requestScope.mess==null}"> 
                                <div class="wc-title">
                                    <h4>Web contact details</h4>
                                </div>
                                <div class="widget-inner">
                                    <form class="edit-profile m-b30" action="webcontactdetails" method="post">                                    
                                        <div class="row">                                        
                                            <div class="col-12">
                                                <div class="ml-auto">
                                                    <c:set var="idNow" value="${requestScope.contact.contact_id}"/>                                                    
                                                    <h3>Contact ID</h3> 
                                                    <input class="form-control" type="text" placeholder="${idNow}" readonly=""name="contact_id" value="${idNow}">
                                                </div>
                                            </div>
                                            
                                            <div class="form-group col-6">
                                                <label class="col-form-label">Category ID</label>
                                                <div>
                                                    <select name="category_id">
                                                        <c:forEach begin="0" end="${requestScope.categoryIds.size()-1}" var="i">
                                                            <option ${requestScope.categoryIds.get(i)==requestScope.contact.category_id? "selected":""}  >${requestScope.categoryIds.get(i)}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group col-6">
                                                <label class="col-form-label">Supporter ID</label>
                                                <div>
                                                    <select name="supporter_id">
                                                        <c:forEach begin="0" end="${requestScope.supporterIds.size()-1}" var="i">
                                                            <option ${requestScope.supporterIds.get(i)==requestScope.contact.supporter_id? "selected":""}  >${requestScope.supporterIds.get(i)}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group col-6">
                                                <label class="col-form-label">Full name</label>
                                                <div>
                                                    <input class="form-control" type="text" placeholder="${requestScope.contact.full_name}" readonly=""name="full_name">
                                                </div>
                                            </div>
                                            <div class="form-group col-6">
                                                <label class="col-form-label">Email</label>
                                                <div>
                                                    <input class="form-control" type="text" placeholder="${requestScope.contact.email}" readonly="" name="email">
                                                </div>
                                            </div>
                                            <div class="form-group col-6">
                                                <label class="col-form-label">Mobile</label>
                                                <div>
                                                    <input class="form-control" type="text" placeholder="${requestScope.contact.mobile}" readonly="" name="mobile">
                                                </div>
                                            </div>
                                            <div class="form-group col-6">
                                                <label class="col-form-label">Message</label>
                                                <div>
                                                    <input class="form-control" type="text" placeholder="${requestScope.contact.message}" readonly="" name="message">
                                                </div>
                                            </div>                                     
                                            <div class="form-group col-12">
                                                <label class="col-form-label">Response</label>
                                                <div>
                                                    <textarea class="form-control" name="response">${requestScope.contact.response}</textarea>                                                                                                
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
                                <a href="webcontactlist"><button class="btn">Back to web contact list</button></a>                                
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
        <script>
            // Pricing add
            function newMenuItem() {
                var newElem = $('tr.list-item').first().clone();
                newElem.find('input').val('');
                newElem.appendTo('table#item-add');
            }
            if ($("table#item-add").is('*')) {
                $('.add-item').on('click', function (e) {
                    e.preventDefault();
                    newMenuItem();
                });
                $(document).on("click", "#item-add .delete", function (e) {
                    e.preventDefault();
                    $(this).parent().parent().parent().parent().remove();
                });
            }
        </script>
    </body>
</html>
