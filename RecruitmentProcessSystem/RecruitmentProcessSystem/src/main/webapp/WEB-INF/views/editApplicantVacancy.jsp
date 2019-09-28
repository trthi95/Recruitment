<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<link
	href='<c:url value="../../../resources/css/bootstrap.min.css"></c:url>'
	rel="stylesheet">
<link
	href='<c:url value="../../../resources/css/font-awesome.css"></c:url>'
	rel="stylesheet">
<link href='<c:url value="../../../resources/css/animate.css"></c:url>'
	rel="stylesheet">
<link href='<c:url value="../../../resources/css/style.css"></c:url>'
	rel="stylesheet">
</head>
<body>
	<%-- <form name='' action="${applicantVacancy.getApplicantNumber() }"
		method='POST'>
		<table>
			<tr>
				<td>Applicant Number:</td>
				<td colspan="10">${applicantVacancy.getApplicantNumber() }</td>
			</tr>
			<tr>
				<td>Applicant Vacancy Name</td>
				<td><input name="applicantVacancyName" type="text"
					value="${applicantVacancy.getApplicantVacancyName() }" /></td>
			</tr>
			<tr>
				<td>Email Applicant:</td>
				<td><input name="emailApplicant" type="text"
					value="${applicantVacancy.getEmailApplicant() }" /></td>
			</tr>
			<tr>
				<td>Vacancy:</td>
				<td>${vacancy.getDescription() }</td>
			</tr>
			<tr>
				<td>Date On Applicant Vacancy:</td>
				<td><input name="dateOnApplicantVacancy" type="date"
					value="${applicantVacancy.getDateOnApplicantVacancy() }" /></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><input name="state" type="text"
					value="${applicantVacancy.getState() }"></td>
			</tr>
			<tr>
				<td>CV:</td>
				<td><input name="cv" type="text"
					value="${applicantVacancy.getCv() }" /></td>
			</tr>
			<tr>
				<td>Date Of The Schedule Interview:</td>
				<td><input name="dateOfTheScheduleInterview" type="datetime"
					value="${applicantVacancy.getScheduleInterviewDetails().getDateOfTheScheduleInterview()}" /></td>
			</tr>
			<tr>
				<td>Start Time:</td>
				<td><input name="startTime" type="time"
					value="${applicantVacancy.getScheduleInterviewDetails().getStartTime()}" /></td>
			</tr>
			<tr>
				<td>End Time:</td>
				<td><input name="endTime" type="time"
					value="${applicantVacancy.getScheduleInterviewDetails().getEndTime()}" /></td>
			</tr>

			<tr>
				<td colspan='2'><input name="" type="submit" value="save" /></td>
			</tr>
		</table>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>

	<form name='' action="${applicantVacancy.getApplicantNumber() }"
		method='POST'>
		<input name="emailApplicant" type="hidden"
			value="${applicantVacancy.getEmailApplicant() }" /> <input
			name="dateOnApplicantVacancy" type="hidden"
			value="${applicantVacancy.getDateOnApplicantVacancy() }" /> <input
			name="state" type="hidden" value="${applicantVacancy.getState() }">
		<input name="dateOfTheScheduleInterview" type="hidden"
			value="${applicantVacancy.getScheduleInterviewDetails().getDateOfTheScheduleInterview()}" />
		<input name="startTime" type="hidden"
			value="${applicantVacancy.getScheduleInterviewDetails().getStartTime()}" />
		<input name="endTime" type="hidden"
			value="${applicantVacancy.getScheduleInterviewDetails().getEndTime()}" />

		<input name="" type="submit" value="Send Mail" /> <input
			type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form> --%>

	<div id="wrapper">

		<nav class="navbar-default navbar-static-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav metismenu" id="side-menu">
					<li class="nav-header">
						<div class="dropdown profile-element">
							<span> <img alt="image" class="img-circle"
								src="../resources/img/profile_small.jpg" />
							</span> <a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<span class="clear"> <span class="block m-t-xs"> <strong
										class="font-bold">${user.getFullName()}</strong>
								</span>
							</span>
							</a>
						</div>
						<div class="logo-element">IN+</div>
					</li>
					<li><a href="../../hr"><i class="fa fa-diamond"></i> <span
							class="nav-label">Profile</span></a></li>
					<li><a href="../../vacancy"><i class="fa fa-diamond"></i>
							<span class="nav-label">Vacancy</span></a></li>
					<li><a href="../../applicantVacancy/${vacancyNumber }"><i
							class="fa fa-diamond"></i> <span class="nav-label">Applicant
								Vacancy</span></a></li>
				</ul>

			</div>
		</nav>

		<div id="page-wrapper" class="gray-bg">
			<div class="row border-bottom">
				<nav class="navbar navbar-static-top" role="navigation"
					style="margin-bottom: 0">
					<div class="navbar-header">
						<a class="navbar-minimalize minimalize-styl-2 btn btn-primary "
							href="#"><i class="fa fa-bars"></i> </a>
						<form role="search" class="navbar-form-custom"
							action="search_results.html">
							<div class="form-group">
								<input type="text" placeholder="Search for something..."
									class="form-control" name="top-search" id="top-search">
							</div>
						</form>
					</div>
					<ul class="nav navbar-top-links navbar-right">
						<li><span class="m-r-sm text-muted welcome-message">Welcome
								to Reruitment Process System.</span></li>
						<li class="dropdown"><a class="dropdown-toggle count-info"
							data-toggle="dropdown" href="#"> <i class="fa fa-envelope"></i>
								<span class="label label-warning">16</span>
						</a>
							<ul class="dropdown-menu dropdown-messages">
								<li>
									<div class="dropdown-messages-box">
										<a href="profile.html" class="pull-left"> <img alt="image"
											class="img-circle" src="img/a7.jpg">
										</a>
										<div class="media-body">
											<small class="pull-right">46h ago</small> <strong>Mike
												Loreipsum</strong> started following <strong>Monica Smith</strong>. <br>
											<small class="text-muted">3 days ago at 7:58 pm -
												10.06.2014</small>
										</div>
									</div>
								</li>
								<li class="divider"></li>
								<li>
									<div class="dropdown-messages-box">
										<a href="profile.html" class="pull-left"> <img alt="image"
											class="img-circle" src="img/a4.jpg">
										</a>
										<div class="media-body ">
											<small class="pull-right text-navy">5h ago</small> <strong>Chris
												Johnatan Overtunk</strong> started following <strong>Monica
												Smith</strong>. <br> <small class="text-muted">Yesterday
												1:21 pm - 11.06.2014</small>
										</div>
									</div>
								</li>
								<li class="divider"></li>
								<li>
									<div class="dropdown-messages-box">
										<a href="profile.html" class="pull-left"> <img alt="image"
											class="img-circle" src="img/profile.jpg">
										</a>
										<div class="media-body ">
											<small class="pull-right">23h ago</small> <strong>Monica
												Smith</strong> love <strong>Kim Smith</strong>. <br> <small
												class="text-muted">2 days ago at 2:30 am -
												11.06.2014</small>
										</div>
									</div>
								</li>
								<li class="divider"></li>
								<li>
									<div class="text-center link-block">
										<a href="mailbox.html"> <i class="fa fa-envelope"></i> <strong>Read
												All Messages</strong>
										</a>
									</div>
								</li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle count-info"
							data-toggle="dropdown" href="#"> <i class="fa fa-bell"></i> <span
								class="label label-primary">8</span>
						</a>
							<ul class="dropdown-menu dropdown-alerts">
								<li><a href="mailbox.html">
										<div>
											<i class="fa fa-envelope fa-fw"></i> You have 16 messages <span
												class="pull-right text-muted small">4 minutes ago</span>
										</div>
								</a></li>
								<li class="divider"></li>
								<li><a href="profile.html">
										<div>
											<i class="fa fa-twitter fa-fw"></i> 3 New Followers <span
												class="pull-right text-muted small">12 minutes ago</span>
										</div>
								</a></li>
								<li class="divider"></li>
								<li><a href="grid_options.html">
										<div>
											<i class="fa fa-upload fa-fw"></i> Server Rebooted <span
												class="pull-right text-muted small">4 minutes ago</span>
										</div>
								</a></li>
								<li class="divider"></li>
								<li>
									<div class="text-center link-block">
										<a href="notifications.html"> <strong>See All
												Alerts</strong> <i class="fa fa-angle-right"></i>
										</a>
									</div>
								</li>
							</ul></li>


						<li><form
								action="<c:url value="/hr/j_spring_security_logout" />"
								method="post">
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" /> <input type="submit" value="Logout" />
							</form>
					</ul>

				</nav>
			</div>
			<div class="row wrapper border-bottom white-bg page-heading">
				<div class="col-lg-10">
					<h2>Profile</h2>
				</div>
				<div class="col-lg-2"></div>
			</div>
			<div class="wrapper wrapper-content  animated fadeInRight">
				<div class="row">
					<div class="col-lg-6">
						<div class="ibox ">
							<div class="ibox-title">
								<h5>
									<a href="../${vacancyNumber }">List Applicant</a>
								</h5>
							</div>
							<div class="ibox-content">
								<form action="" method="post">
									<div class="form-group">
										<label>Applicant Number</label><br>
										${applicantVacancy.getApplicantNumber() }
									</div>
									<div class="form-group">
										<label>Applicant Vacancy Name</label><input type="text"
											value="${applicantVacancy.getApplicantVacancyName() }"
											name="applicantVacancyName"
											placeholder="Applicant Vacancy Name" class="form-control"
											required>
									</div>
									<div class="form-group">
										<label>Email Applicant</label> <input type="text"
											value="${applicantVacancy.getEmailApplicant() }"
											name="emailApplicant" placeholder="Email Applicant"
											class="form-control" required>
									</div>
									<div class="form-group">
										<label>Vacancy</label><br>${vacancy.getDescription() }
									</div>
									<div class="form-group">
										<label>Date On Applicant Vacancy</label> <input type="date"
											value="${applicantVacancy.getDateOnApplicantVacancy() }"
											name="dateOnApplicantVacancy" class="form-control">
									</div>

									<div class="form-group">
										<label>State</label><br> ${applicantVacancy.getState() }
										<select name="state" value="${applicantVacancy.getState() }"
											class="form-control">
											<option>Notin process</option>
											<option>Inprocess</option>
											<option>Hired</option>
											<option>Banned</option>
										</select>
										<%-- 	 <input type="tel" name="state"
										value="${applicantVacancy.getState() }"
											placeholder="State" class="form-control"> --%>
									</div>
									<div class="form-group">
										<label>Date Of The Schedule Interview</label> <input
											type="date" name="dateOfTheScheduleInterview"
											value="${applicantVacancy.getScheduleInterviewDetails().getDateOfTheScheduleInterview()}"
											class="form-control">
									</div>
									<div class="form-group">
										<label>Start Time</label> <input type="time" name="startTime"
											value="${applicantVacancy.getScheduleInterviewDetails().getStartTime() }"
											class="form-control">
									</div>
									<div class="form-group">
										<label>End Time</label> <input type="time" name="endTime"
											value="${applicantVacancy.getScheduleInterviewDetails().getEndTime() }"
											class="form-control">
									</div>
									<%-- 	<div class="form-group">
										<label>Interviewer</label> <select name="listIdUser"
											multiple="multiple">
											<c:forEach var="user" items="${listUser }">
												<option value="${user.getIdUser() }">${user.getFullName()}
											</c:forEach>
										</select>
									</div> --%>

									<div class="form-group">
										<button class="btn btn-sm btn-primary m-t-n-xs" type="submit">
											<strong>Submit</strong>
										</button>
									</div>
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" />
								</form>



								<div class="form-group">
									<input type="hidden" id="vacancyNumber"
										value="${vacancyNumber }" name="vacancyNumber"> <input
										type="hidden" id="applicantNumber"
										value="${applicantVacancy.getApplicantNumber() }"
										name="applicantNumber"> <input type="hidden"
										id="applicantVacancyName"
										value="${applicantVacancy.getApplicantVacancyName() }"
										name="applicantVacancyName"> <input type="hidden"
										id="emailApplicant"
										value="${applicantVacancy.getEmailApplicant() }"
										name="emailApplicant"> <input type="hidden" id="state"
										value="${applicantVacancy.getState() }" name="state">
									<input type="hidden" name="dateOfTheScheduleInterview"
										id="dateOfTheScheduleInterview"
										value="${applicantVacancy.getScheduleInterviewDetails().getDateOfTheScheduleInterview()}">
									<input type="hidden" name="startTime" id="startTime"
										value="${applicantVacancy.getScheduleInterviewDetails().getStartTime() }">
									<input type="hidden" name="endTime" id="endTime"
										value="${applicantVacancy.getScheduleInterviewDetails().getEndTime() }">
									<button id="sendMail" class="btn btn-sm btn-primary m-t-n-xs"
										type="submit">
										<strong>Send Mail</strong>
									</button>
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" />
								</div>
								<p id="noticed">
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="footer">
				<div class="pull-right">
					10GB of <strong>250GB</strong> Free.
				</div>
				<div>
					<strong>Copyright</strong> Example Company &copy; 2014-2017
				</div>
			</div>

		</div>
	</div>




	<!-- Mainly scripts -->
	<script
		src='<c:url value="../../../resources/js/jquery-3.1.1.min.js"></c:url>'></script>
	<script src="../../../resources/js/bootstrap.js"></script>
	<script src="../../../resources/js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script
		src="../../../resources/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<!-- Custom and plugin javascript -->
	<script src="../../../resources/js/inspinia.js"></script>
	<script src="../../../resources/js/plugins/pace/pace.min.js"></script>

	<script src="../../../resources/js/plugins/jquery-ui/jquery-ui.min.js"></script>

	<!-- Sparkline -->
	<script src="../../../resources/js/plugins/sparkline/jquery.sparkline.min.js"></script>

	<!-- Jquery Validate -->
	<script src="../../../resources/js/plugins/validate/jquery.validate.min.js"></script>


	<script src="../../../resources/js/custom.js"></script>
	
	<!-- <script>
		$(document).ready(function() {

			$("#sparkline1").sparkline([ 34, 43, 43, 35, 44, 32, 44, 48 ], {
				type : 'line',
				width : '100%',
				height : '50',
				lineColor : '#1ab394',
				fillColor : "transparent"
			});

		});
	</script> -->
</body>
</html>