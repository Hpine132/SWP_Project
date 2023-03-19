<%-- 
    Document   : headertop
    Created on : Sep 25, 2022, 3:47:29 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header class="header rs-nav header-transparent">
    <div class="top-bar">
        <div class="container">
            <div class="row d-flex justify-content-between">
                <div class="topbar-left">
                    <ul>
                        <li><a href="faq-1.html"><i class="fa fa-question-circle"></i>Ask a Question</a></li>
                        <li><a href="javascript:;"><i class="fa fa-envelope-o"></i>Support@website.com</a></li>
                    </ul>
                </div>
                <div class="topbar-right">

                    <ul>
                        <!-- comment -->
                        <c:if test="${sessionScope.account==null}">
                            <li><a href="login.jsp">Login</a></li>
                            <li><a href="register.jsp">Register</a></li>
                        </c:if>
                        <!-- comment -->
                        <!-- comment -->
                        <c:if test="${sessionScope.account!=null}">

                            <a href="userProfile" class="ttr-material-button ttr-submenu-toggle"><span class="ttr-user-avatar"><img alt="" src="${account.getAvatar()}" width="32" height="32"></span></a>
                            <li><a href="userProfile">Profile</a></li>
                            <li><a href="changePassword.jsp">Change Password</a></li>
                            <li><a href="Logout">Logout</a></li>
                        </c:if>
                        <!-- comment -->
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="sticky-header navbar-expand-lg">
        <div class="menu-bar clearfix">
            <div class="container clearfix">
                <!-- Header Logo ==== -->
                <div class="menu-logo">
                    <a href="home.jsp"><img src="assets/images/logo-white.png" alt=""></a>
                </div>
                <!-- Mobile Nav Button ==== -->
                <button class="navbar-toggler collapsed menuicon justify-content-end" type="button" data-toggle="collapse" data-target="#menuDropdown" aria-controls="menuDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span></span>
                    <span></span>
                    <span></span>
                </button>
                <!-- Author Nav ==== -->
                <div class="secondary-menu">
                    <div class="secondary-inner">
                        <ul>
                            <li><a href="https://vi-vn.facebook.com/" class="btn-link"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="https://www.google.com.vn/?hl=vi" class="btn-link"><i class="fa fa-google-plus"></i></a></li>

                            <!-- Search Button ==== -->
                            <li class="search-btn"><button id="quik-search-btn" type="button" class="btn-link"><i class="fa fa-search"></i></button></li>
                        </ul>
                    </div>
                </div>
                <!-- Search Box ==== -->
                <div class="nav-search-bar">
                    <form action="#">
                        <input name="search" value="" type="text" class="form-control" placeholder="Type to search">
                        <span><i class="ti-search"></i></span>
                    </form>
                    <span id="search-remove"><i class="ti-close"></i></span>
                </div>
                <!-- Navigation Menu ==== -->
                <div class="menu-links navbar-collapse collapse justify-content-start" id="menuDropdown">
                    <div class="menu-logo">
                        <a href="home.jsp"><img src="assets/images/logo.png" alt=""></a>
                    </div>
                    <ul class="nav navbar-nav">	
                        <li class="active"><a href="javascript:;">Home </a>

                        </li>
                        <li><a href="javascript:;">Pages <i class="fa fa-chevron-down"></i></a>
                            <ul class="sub-menu">
                                <li><a href="javascript:;">About<i class="fa fa-angle-right"></i></a>
                                    <ul class="sub-menu">
                                        <li><a href="about-1.html">About 1</a></li>
                                        <li><a href="about-2.html">About 2</a></li>
                                    </ul>
                                </li>
                                <li><a href="javascript:;">Event<i class="fa fa-angle-right"></i></a>
                                    <ul class="sub-menu">
                                        <li><a href="event.html">Event</a></li>
                                        <li><a href="events-details.html">Events Details</a></li>
                                    </ul>
                                </li>
                                <li><a href="javascript:;">FAQ's<i class="fa fa-angle-right"></i></a>
                                    <ul class="sub-menu">
                                        <li><a href="faq-1.html">FAQ's 1</a></li>
                                        <li><a href="faq-2.html">FAQ's 2</a></li>
                                    </ul>
                                </li>
                                <li><a href="javascript:;">Contact Us<i class="fa fa-angle-right"></i></a>
                                    <ul class="sub-menu">
                                        <li><a href="contact-1.html">Contact Us 1</a></li>
                                        <li><a href="contact-2.html">Contact Us 2</a></li>
                                    </ul>
                                </li>
                                <li><a href="portfolio.html">Portfolio</a></li>
                                <li><a href="profile.jsp">Profile</a></li>
                                <li><a href="membership.html">Membership</a></li>
                                <li><a href="error-404.html">404 Page</a></li>
                            </ul>
                        </li>
                        <li class="add-mega-menu"><a href="javascript:;">Our Courses <i class="fa fa-chevron-down"></i></a>
                            <ul class="sub-menu add-menu">
                                <li class="add-menu-left">
                                    <h5 class="menu-adv-title">Our Courses</h5>
                                    <ul>
                                        <li><a href="courses.html">Courses </a></li>                                                 
                                        <li><a href="courses-details.html">Courses Details</a></li>
                                        <li><a href="profile.html">Instructor Profile</a></li>
                                        <li><a href="event.html">Upcoming Event</a></li>
                                        <li><a href="membership.html">Membership</a></li>
                                    </ul>
                                </li>
                                <li class="add-menu-right">
                                    <img src="assets/images/adv/adv.jpg" alt=""/>
                                </li>
                            </ul>
                        </li>
                        <li><a href="javascript:;">Blog <i class="fa fa-chevron-down"></i></a>
                            <ul class="sub-menu">
                                <li><a href="blog-classic-grid.html">Blog Classic</a></li>
                                <li><a href="blog-classic-sidebar.html">Blog Classic Sidebar</a></li>
                                <li><a href="blog-list-sidebar.html">Blog List Sidebar</a></li>
                                <li><a href="blog-standard-sidebar.html">Blog Standard Sidebar</a></li>
                                <li><a href="blog-details.html">Blog Details</a></li>
                            </ul>
                        </li>
                        <c:if test="${sessionScope.account!=null}">
                            <li class="nav-dashboard"><a href="javascript:;">Dashboard <i class="fa fa-chevron-down"></i></a>
                                <ul class="sub-menu">
                                    <li><a href="admin/dashboard.jsp">Dashboard</a></li>
                                    <li><a href="/SWP391_G1/admin/settinglist">Setting list </a></li>
                                    <li><a href="/SWP391_G1/admin/assignmentlist">Assignment list </a></li>
                                    <li><a href="/SWP391_G1/admin/evalcriterialist">Eval criteria list </a></li>
                                    <li><a href="/SWP391_G1/admin/webcontactlist">Web contact list </a></li>
                                    <li><a href="/SWP391_G1/admin/attendancetracking">Attendance tracking </a></li>
                                    <li><a href="/SWP391_G1/admin/attendancedetails">Attendance Details </a></li>
                                    <li><a href="/SWP391_G1/admin/scheduleattendance">Schedule Attendance </a></li>
                                    <li><a href="/SWP391_G1/admin/classlist">Class list </a></li>
                                    <li><a href="/SWP391_G1/admin/classsettinglist">Class setting list </a></li>
                                    <li><a href="admin/add-listing.html">Add Listing</a></li>
                                    <li><a href="http://localhost:9999/SWP391_G1/trainer/MilestoneList">Milestone List</a></li>
                                    <li><a href="http://localhost:9999/SWP391_G1/supporter/ScheduleList">Schedule List</a></li>
                                    <li><a href="http://localhost:9999/SWP391_G1/trainer/teamList">Team List</a></li>
                                    <li><a href="admin/bookmark.html">Bookmark</a></li>
                                    <li><a href="admin/courses.html">Courses</a></li>
                                    <li><a href="admin/review.html">Review</a></li>
                                    <li><a href="admin/teacher-profile.html">Teacher Profile</a></li>
                                    <li><a href="admin/user-profile.html">User Profile</a></li>
                                    <li><a href="javascript:;">Calendar<i class="fa fa-angle-right"></i></a>
                                        <ul class="sub-menu">
                                            <li><a href="admin/basic-calendar.html">Basic Calendar</a></li>
                                            <li><a href="admin/list-view-calendar.html">List View Calendar</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="javascript:;">Mailbox<i class="fa fa-angle-right"></i></a>
                                        <ul class="sub-menu">
                                            <li><a href="admin/mailbox.html">Mailbox</a></li>
                                            <li><a href="admin/mailbox-compose.html">Compose</a></li>
                                            <li><a href="admin/mailbox-read.html">Mail Read</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                        </c:if>

                    </ul>
                    <div class="nav-social-link">
                        <a href="javascript:;"><i class="fa fa-facebook"></i></a>
                        <a href="javascript:;"><i class="fa fa-google-plus"></i></a>
                        <a href="javascript:;"><i class="fa fa-linkedin"></i></a>
                    </div>
                </div>
                <!-- Navigation Menu END ==== -->
            </div>
        </div>
    </div>
</header>