<%-- 
    Document   : Leftsidebarmenustart
    Created on : Sep 25, 2022, 3:41:23 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="ttr-sidebar">
    <div class="ttr-sidebar-wrapper content-scroll">
        <!-- side menu logo start -->
        <div class="ttr-sidebar-logo">
            <a href="#"><img alt="" src="assets/images/logo.png" width="122" height="27"></a>
            <!-- <div class="ttr-sidebar-pin-button" title="Pin/Unpin Menu">
                    <i class="material-icons ttr-fixed-icon">gps_fixed</i>
                    <i class="material-icons ttr-not-fixed-icon">gps_not_fixed</i>
            </div> -->
            <div class="ttr-sidebar-toggle-button">
                <i class="ti-arrow-left"></i>
            </div>
        </div>
        <!-- side menu logo end -->
        <!-- sidebar menu start -->
        <nav class="ttr-sidebar-navi">
            <ul>
                <li>
                    <a href="index.html" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-home"></i></span>
                        <span class="ttr-label">Dashborad</span>
                    </a>
                </li>
                <li>
                    <a href="courses.html" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-book"></i></span>
                        <span class="ttr-label">Courses</span>
                    </a>
                <li>
                    <a style="background: ${requestScope.isSettingList != null? "gainsboro":""}" href="/SWP391_G1/admin/settinglist" class="ttr-material-button">
                        <span class="ttr-icon"><i class="bi bi-gear"></i></span>
                        <span class="ttr-label">Setting List</span>
                    </a>
                </li>
                  <li>
                    <a style="background: ${requestScope.isAssignmentList != null? "gainsboro":""}" href="/SWP391_G1/admin/assignmentlist" class="ttr-material-button">
                        <span class="ttr-icon"><i class="bi bi-book"></i></i></span>
                        <span class="ttr-label">Assignment List</span>
                    </a>
                </li>
                <li>
                    <a style="background: ${requestScope.isEvalCriteriaList != null? "gainsboro":""}" href="/SWP391_G1/admin/evalcriterialist" class="ttr-material-button">
                        <span class="ttr-icon"><i class="bi bi-bookmark-check"></i></span>
                        <span class="ttr-label">Eval Criteria List</span>
                    </a>
                </li>
                <li>
                    <a style="background: ${requestScope.isMilestoneList != null? "gainsboro":""}" href="http://localhost:9999/SWP391_G1/trainer/MilestoneList" class="ttr-material-button">
                        <span class="ttr-icon"><i class="bi bi-bookmark-check"></i></span>
                        <span class="ttr-label">Milestone List</span>
                    </a>
                </li>      
                <li>
                    <a style="background: ${requestScope.isScheduleList != null? "gainsboro":""}" href="http://localhost:9999/SWP391_G1/supporter/ScheduleList" class="ttr-material-button">
                        <span class="ttr-icon"><i class="bi bi-bookmark-check"></i></span>
                        <span class="ttr-label">Schedule List</span>
                    </a>
                </li>
                <li>
                    <a style="background: ${requestScope.isTeamList != null? "gainsboro":""}" href="http://localhost:9999/SWP391_G1/trainer/teamList" class="ttr-material-button">
                        <span class="ttr-icon"><i class="bi bi-bookmark-check"></i></span>
                        <span class="ttr-label">Team List</span>
                    </a>
                </li>
                <li>
                    <a href="webcontactlist" class="ttr-material-button">
                        <span class="ttr-icon"><i class="bi bi-person-lines-fill"></i></span>
                        <span class="ttr-label">Web contact List</span>
                    </a>
                </li>
                
                <li>
                    <a href="classlist" class="ttr-material-button">
                        <span class="ttr-icon"><i class="bi bi-person-lines-fill"></i></span>
                        <span class="ttr-label">Class List</span>
                    </a>
                </li>
                
                <li>
                    <a href="classsettinglist" class="ttr-material-button">
                        <span class="ttr-icon"><i class="bi bi-person-lines-fill"></i></span>
                        <span class="ttr-label">Class Setting List</span>
                    </a>
                </li>
                
                <li>
                    <a href="scheduleattendance" class="ttr-material-button">
                        <span class="ttr-icon"><i class="bi bi-person-lines-fill"></i></span>
                        <span class="ttr-label">Schedule Attendance</span>
                    </a>
                </li>
                
                <li>
                    <a href="attendancedetails" class="ttr-material-button">
                        <span class="ttr-icon"><i class="bi bi-person-lines-fill"></i></span>
                        <span class="ttr-label">Attendance Details</span>
                    </a>
                </li>
                
                <li>
                    <a href="attendancetracking" class="ttr-material-button">
                        <span class="ttr-icon"><i class="bi bi-person-lines-fill"></i></span>
                        <span class="ttr-label">Attendance Tracking</span>
                    </a>
                </li>
                
                <li>
                    <a href="#" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-email"></i></span>
                        <span class="ttr-label">Mailbox</span>
                        <span class="ttr-arrow-icon"><i class="fa fa-angle-down"></i></span>
                    </a>
                    <ul>
                        <li>
                            <a href="mailbox.html" class="ttr-material-button"><span class="ttr-label">Mail Box</span></a>
                        </li>
                        <li>
                            <a href="mailbox-compose.html" class="ttr-material-button"><span class="ttr-label">Compose</span></a>
                        </li>
                        <li>
                            <a href="mailbox-read.html" class="ttr-material-button"><span class="ttr-label">Mail Read</span></a>
                        </li>
                    </ul>
                </li>               
                <li>
                    <a href="bookmark.html" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-bookmark-alt"></i></span>
                        <span class="ttr-label">Bookmarks</span>
                    </a>
                </li>                
                <li>
                    <a href="review.html" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-comments"></i></span>
                        <span class="ttr-label">Review</span>
                    </a>
                </li>
                <li>
                    <a href="add-listing.html" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-layout-accordion-list"></i></span>
                        <span class="ttr-label">Add listing</span>
                    </a>
                </li>
                <li>
                    <a href="#" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-user"></i></span>
                        <span class="ttr-label">My Profile</span>
                        <span class="ttr-arrow-icon"><i class="fa fa-angle-down"></i></span>
                    </a>
                    <ul>
                        <li>
                            <a href="user-profile.html" class="ttr-material-button"><span class="ttr-label">User Profile</span></a>
                        </li>
                        <li>
                            <a href="teacher-profile.html" class="ttr-material-button"><span class="ttr-label">Teacher Profile</span></a>
                        </li>
                    </ul>
                </li>
                <li class="ttr-seperate"></li>
            </ul>
            <!-- sidebar menu end -->
        </nav>
        <!-- sidebar menu end -->
    </div>
</div>
