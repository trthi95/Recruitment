$(document).ready(function(){
		var username = $("#username").val();
		$.ajax({
		url: "http://localhost:8080/RecruitmentProcessSystem/admin/checkUser",
		type: "GET",
		data:{username : username},
		success: function(value){
			if (value == "0") {
				$("#noticed-admin").text("username da co nguoi dung")
			}else {
				$("#noticed-admin").text("username dung duoc")
			}
			}
		});
	
	$("#sendMail").click(function(){
		var vacancyNumber = $("#vacancyNumber").val();
		var applicantNumber = $("#applicantNumber").val();
		var applicantVacancyName = $("#applicantVacancyName").val();
		var emailApplicant = $("#emailApplicant").val();
		var state = $("#state").val();
		var dateOfTheScheduleInterview = $("#dateOfTheScheduleInterview").val();
		var startTime = $("#startTime").val();
		var endTime = $("#endTime").val();
		$.ajax({
			url: "http://localhost:8080/RecruitmentProcessSystem/hr/applicantVacancy/" + vacancyNumber +"/"+applicantNumber+"/sendMail",
			type: "GET",
			data: {
				vacancyNumber : vacancyNumber,
				applicantNumber : applicantNumber,
				applicantVacancyName : applicantVacancyName,
				emailApplicant : emailApplicant,
				state : state,
				dateOfTheScheduleInterview : dateOfTheScheduleInterview,
				startTime : startTime,
				endTime : endTime
			},
			success: function(value){
				if (value == "true") {
					$("#noticed").text("send success")
				}else if(value == "false"){
					$("#noticed").text("send mail failed")
				}
			}
		})
	});
	
	$("#btn-change-password").click(function(){
		var oldPassword = $("#oldPassword").val();
		var newPassword = $("#newPassword").val();
		var confirmNewPassword = $("#confirmNewPassword").val();
		var flag = true;
		if (newPassword.length < 6 || confirmNewPassword.length <6) {
			$("#error-new-password").text("Password and Confirm Password should longer than 6 words")
			flag = false
		}else if (newPassword != (confirmNewPassword)) {
			$("#error-new-password").text("Password and Confirm Password are not same")
			flag = false
		}else if(newPassword.length > 6 && confirmNewPassword.length >6 && (newPassword == confirmNewPassword)){
			$("#error-new-password").text("")
			flag = true
		}
		if (flag == true) {
			
			$.ajax({
				url: "http://localhost:8080/RecruitmentProcessSystem/hr/changePasswordHR",
				type: "GET",
				data:{
					oldPassword : oldPassword,
					newPassword : newPassword,
					confirmNewPassword : confirmNewPassword
				} ,
				success: function(value){
					if (value=="false") {
						$("#error-new-password").text("Password not correct")
					}else{
						$("#error-new-password").text("Change password successful")
						$("#oldPassword").text("")
						$("#newPassword").text("")
						$("#confirmNewPassword").text("")
					}
				}
			})
		}
	})
	
	$("#btn-change-password-admin").click(function(){
		var oldPassword = $("#oldPassword").val();
		var newPassword = $("#newPassword").val();
		var confirmNewPassword = $("#confirmNewPassword").val();
		var flag = true;
		if (newPassword.length < 6 || confirmNewPassword.length <6) {
			$("#error-new-password").text("Password and Confirm Password should longer than 6 words")
			flag = false
		}else if (newPassword != (confirmNewPassword)) {
			$("#error-new-password").text("Password and Confirm Password are not same")
			flag = false
		}else if(newPassword.length > 6 && confirmNewPassword.length >6 && (newPassword == confirmNewPassword)){
			$("#error-new-password").text("")
			flag = true
		}
		if (flag == true) {
			
			$.ajax({
				url: "http://localhost:8080/RecruitmentProcessSystem/admin/changePasswordAdmin",
				type: "GET",
				data:{
					oldPassword : oldPassword,
					newPassword : newPassword,
					confirmNewPassword : confirmNewPassword
				} ,
				success: function(value){
					if (value=="false") {
						$("#error-new-password").text("Password not correct")
					}else{
						$("#error-new-password").text("Change password successful")
						$("#oldPassword").text("")
						$("#newPassword").text("")
						$("#confirmNewPassword").text("")
					}
				}
			})
		}
	});
	
	
// $("#btn-create-user").click(function(){
// var username = $("#username").val()
// var password = $("#password").val()
// var email = $("#email").val()
// var positionName = $("#positionName").val()
// var gender = $("#gender").val()
// var departmentName = $("#departmentName").val()
// var roleName = $("#roleName").val()
// $.ajax({
// url: "http://localhost:8080/RecruitmentProcessSystem/admin/createUsers",
// type: "GET",
// data:{
// username : username,
// password : password,
// email : email,
// positionName : positionName,
// gender : gender,
// departmentName : departmentName,
// roleName : roleName
// } ,
// success: function(value){
// if (value == "1") {
// $("#noticed-admin").text("username da co nguoi dung")
// }else if (value == "2") {
// $("#noticed-admin").text("email da co nguoi dung")
// }else{
// $("#noticed-admin").text("tao tai khoan thanh cong")
// }
// }
// })
// })
})