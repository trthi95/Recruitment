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

<link href='<c:url value="../resources/css/bootstrap.min.css"></c:url>'
	rel="stylesheet">
<link href='<c:url value="../resources/css/font-awesome.css"></c:url>'
	rel="stylesheet">
<link href='<c:url value="../resources/css/animate.css"></c:url>'
	rel="stylesheet">
<link href='<c:url value="../resources/css/style.css"></c:url>'
	rel="stylesheet">
</head>
<body>
	<%-- <form name='' action="" method='POST'>
		<table>
			<tr>
				<td>Old Password:</td>
				<td><input type='password' name='oldPassword'></td>
			</tr>
			<tr>
				<td>New Password:</td>
				<td><input type='password' name='newPassword' /></td>
			</tr>
			<tr>
				<td>Confirm New Password:</td>
				<td><input type='password' name='confirmNewPassword' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="" type="submit" value="save" /></td>
			</tr>
		</table>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	${noticed } --%>

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

					<li><a href="admin"><i class="fa fa-diamond"></i> <span
							class="nav-label">Profile</span></a></li>
					<li><a href="listUser"><i class="fa fa-diamond"></i> <span
							class="nav-label">List User</span></a></li>
					<li><a href="changePassword"><i class="fa fa-diamond"></i>
							<span class="nav-label">Change Password</span></a></li>

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
								action="<c:url value="/admin/j_spring_security_logout" />"
								method="post">
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" /> <input type="submit" value="Logout" />
							</form>
					</ul>

				</nav>
			</div>
			<div class="row wrapper border-bottom white-bg page-heading">
				<div class="col-lg-10">
					<h2>Change Password</h2>
				</div>
				<div class="col-lg-2"></div>
			</div>
			<div class="wrapper wrapper-content  animated fadeInRight">
				<div class="row">
					<div class="col-lg-6">
						<div class="ibox ">
							<div class="ibox-title">
								<h5>Change Password</h5>
							</div>
							<div class="ibox-content">
								<label>Old Password</label><input type="password"
									id="oldPassword" name="oldPassword" placeholder="Old Password"
									class="form-control form-group" required="required"> <label>New
									Password</label> <input type="password" id="newPassword"
									name="newPassword" placeholder="New Password"
									class="form-control form-group" required> <label>Confirm
									New Password</label> <input type="password" id="confirmNewPassword"
									name="confirmNewPassword" placeholder="Confirm New Password"
									class="form-control form-group" required><span
									id="error-new-password"></span><br>
								<br> <input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
								<button class="btn btn-sm btn-primary m-t-n-xs" type="submit"
									id="btn-change-password-admin">
									<strong>Submit</strong>
								</button>
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
		src='<c:url value="../resources/js/jquery-3.1.1.min.js"></c:url>'></script>
	<script src="../resources/js/bootstrap.js"></script>
	<script src="../resources/js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script
		src="../resources/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<!-- Custom and plugin javascript -->
	<script src="../resources/js/inspinia.js"></script>
	<script src="../resources/js/plugins/pace/pace.min.js"></script>

	<script src="../resources/js/plugins/jquery-ui/jquery-ui.min.js"></script>

	<!-- Sparkline -->
	<script src="../resources/js/plugins/sparkline/jquery.sparkline.min.js"></script>

	<!-- Jquery Validate -->
	<script src="../resources/js/plugins/validate/jquery.validate.min.js"></script>


	<script src="../resources/js/custom.js"></script>



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