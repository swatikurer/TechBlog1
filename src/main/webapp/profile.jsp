j
<%@page import="com.tech.blog.helper.ConnectionProvider"%>
<%@page import="com.tech.blog.entities.user"%>
<%@page import="com.tech.blog.dao.postDao"%>
<%@page errorPage="Error_page.jsp"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="com.tech.blog.entities.Category"%>

<%
user userr = (user) session.getAttribute("currentUser");
if (userr == null) {
	response.sendRedirect("login.jsp");
}
%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>profile page</title>

<!-- css -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="css/mystyle.css" rel="stylesheet" type="text/css" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- font-css -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.banner-background {
	clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 99%, 71% 90%, 30% 100%, 0 86%, 0 0);
}
</style>
</head>
<body>
	<!-- navbar starts -->
	<nav class="navbar navbar-expand-lg navbar-dark primary-background">
		<a class="navbar-brand" href="index.jsp">TechBlog</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp"><span class="fa fa-asterisk"></span>Home <span
						class="sr-only">(current)</span></a></li>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Events </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">College Events</a> <a
							class="dropdown-item" href="#">Hostel Events</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Something else here</a>
					</div></li>
				<li class="nav-item"><a class="nav-link" href="#"><span
						class="fa fa-address-card-o"></span>Contact</a></li>
				<li class="nav-item"><a class="nav-link" href="#"
					data-toggle="modal" data-target="#add-post-modal"><span
						class="fa fa-astrict"></span>Do Post</a></li>


			</ul>
			<ul class="navbar-nav mr-right">
				<li class="nav-item"><a class="nav-link" data-toggle="modal"
					href="#" data-target="#profile-modal"><span
						class=" fa fa-user-circle"></span><%=userr.getName()%></a></li>
				<li class="nav-item"><a class="nav-link" href="LogoutServlets"><span
						class=" fa fa-user-plus"></span>logout</a></li>
			</ul>
		</div>
	</nav>


	<!-- navbar ends -->

	<!-- profile modal -->

	<!-- Modal -->
	<div class="modal fade" id="profile-modal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header primary-background text-white text-center">
					<h5 class="modal-title" id="exampleModalLabel">TechBlog</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="container text-center ">
						<img src="pics/<%=userr.getProfile()%>" class="image-fluid"
							style="border-radius: 50%; max-width: 150%">
						<h5 class="modal-title mt-3" id="exampleModalLabel"><%=userr.getName()%></h5>
					</div>

					<!--details  -->
					<div id="profile-details">
						<table class="table">

							<tbody>
								<tr>
									<th scope="row">ID :</th>
									<td><%=userr.getId()%></td>

								</tr>
								<tr>
									<th scope="row">Email:</th>
									<td><%=userr.getEmail()%></td>

								</tr>
								<tr>
									<th scope="row">Gender :</th>
									<td><%=userr.getGender()%></td>

								</tr>
								<tr>
									<th scope="row">Status :</th>
									<td><%=userr.getAbout()%></td>

								</tr>
								<tr>
									<th scope="row">Registered On : :</th>
									<td><%=userr.getDateTime().toString()%></td>

								</tr>

							</tbody>
						</table>
					</div>
					<!--  profile edit -->
					<div id="profile-edit" style="display: none">
						<h3 class="mt-2  text-center">Edit your profile here</h3>

						<form action="EditServlets" method="post"
							enctype="multipart/form-data">
							<table class="table">
								<tr>
									<th scope="row">ID :</th>
									<td><%=userr.getId()%></td>

								</tr>
								<tr>
									<th scope="row">Email:</th>
									<td><input type="email" class="form-control"
										name="user_email" value="<%=userr.getEmail()%>"></td>

								</tr>
								<tr>
									<th scope="row">Name:</th>
									<td><input type="text" class="form-control"
										name="user_name" value="<%=userr.getName()%>"></td>

								</tr>
								<tr>
									<th scope="row">Password:</th>
									<td><input type="password" class="form-control"
										name="user_password" value="<%=userr.getPassword()%>"></td>

								</tr>
								<tr>
									<th scope="row">Gender :</th>
									<td><%=userr.getGender().toUpperCase()%></td>
								</tr>
								<tr>
									<th scope="row">About:</th>
									<td><textarea rows="3" class="form-control"
											name="user_about"><%=userr.getAbout()%></textarea>"</td>
								</tr>
								<tr>
									<th scope="row">New profile:</th>
									<td><input type="file" name="image" class="form-control"></td>
								</tr>
							</table>
							<div>
								<button type="submit" class="btn btn-primary btn-center ">Save</button>
							</div>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button id="edit-profile-button" type="button"
						class="btn btn-primary">Edit</button>
				</div>
			</div>
		</div>
	</div>
	<!--profile modal ends 
	

	add post modal -->

	<!-- Modal -->
	<div class="modal fade" id="add-post-modal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Provide post
						details</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="add-post-form" action="addPostServlet" method="post">
						<div class="form-group">
							<select class="form-control" name="cid">
								<option selected disabled>---Select Category---</option>
								<%
								postDao postD = new postDao(ConnectionProvider.getConnection());
								ArrayList<Category> list = postD.getAllCategories();
								for (Category c : list) {
								%>
								<option vlaue="<%=c.getCid()%>"><%=c.getName()%></option>
								<%
								}
								%>
							</select>
						</div>
						<div class="form-group">
							<input type="text" name="pTitle" placeholder="Enter post title"
								class="form-control">
						</div>
						<div class="form-group">
							<textarea name="pContent" style="height: 200px;"
								placeholder="Enter your content" class="form-control"></textarea>
						</div>
						<div class="form-group">
							<textarea name="pCode" style="height: 200px;"
								placeholder="Enter your program(if any)" class="form-control"></textarea>
						</div>
						<div class="form-group">
							<label>Choose your pic</label><br> <input name="pic"
								type="file">
						</div>
						<div class="container text-center">
						<button type="submit" class="btn btn-outline-primary" >Post
						</button>
						 
						</div>
					</form>
				</div>
				
			</div>
		</div>
	</div>

	<!--  end of add post modal-->

	<%
	session.removeAttribute("msg");
	%>


	<!--  java script-->
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"
		integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script src="js/myjs.js" type="text/javascript"></script>
	<script>
		$(document).ready(function() {
			let editStatus = false;
			$('#edit-profile-button').click(function() {
				if (editStatus == false) {
					$("#profile-details").hide();
					$("#profile-edit").show();
					editStatus = true;
					$(this).text("Back");

				} else {
					$("#profile-details").show();
					$("#profile-edit").hide();
					editStatus = false;
					$(this).text("Edit");
				}
			});
		});
	</script>

	<!-- NOw add post js -->
	<script>
		$(document).ready(function(e) {
			alert("loaded... ")
			$("#add-post-form").on("submit", function(event) {
				//this code get called when form is submitted
				event.preventDefault();
				console.log("you have submitted.... ")
				
				let form= new FormData(this);
				
				//now requesting to server
				$.ajax({
					url: "addPostServlet",
					type: 'post',
					data: form,
					success: function(data,textStatus,jqXHR){
						//success...
						console.log(data);
					},
				error: function(jqXHR,textStatus,errorThrown){
					
				},
				processData: false,
				contentType: false
				})

			})
		})
	</script>

</body>
</html>