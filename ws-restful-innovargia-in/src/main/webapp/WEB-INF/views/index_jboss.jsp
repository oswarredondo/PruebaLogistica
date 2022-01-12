<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<style>
/* Core styles for the page */
body {
  margin: 0;
  padding: 0;
  background-color: #F1F1F1;
  font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif;
  font-size: 0.8em;
  color:#363636;
}

#container {
  margin: 0 auto;
  padding: 0 20px 10px 20px;
  border-top: 5px solid #000000;
  border-left: 5px solid #8c8f91;
  border-right: 5px solid #8c8f91;
  border-bottom: 25px solid #8c8f91;
  width: 865px; /* subtract 40px from banner width for padding */
  background: #FFFFFF;
  background-image: url(../gfx/headerbkg.png);
  background-repeat: repeat-x;
  padding-top: 30px;
  box-shadow: 3px 3px 15px #d5d5d5;
}
#content {
  float: left;
  width: 500px;
  margin: 20px;
}
#aside {
  font-size: 0.9em;
  width: 275px;
  float: left;
  margin: 20px 0px;
  border: 1px solid #D5D5D5;
  background: #F1F1F1;
  background-image: url(../gfx/asidebkg.png);
  background-repeat: repeat-x;
  padding: 20px;
}

#aside ul {
  padding-left: 30px;
}
.dualbrand {
  float: right;
  padding-right: 10px;
}
#footer {
  clear: both;
  text-align: center;
  color: #666666;
  font-size: 0.85em;
}
code {
  font-size: 1.1em;
}
a {
  color: #4a5d75;
  text-decoration: none;
}
a:hover {
  color: #369;
  text-decoration: underline;
}
h1 {
  color:#243446;
  font-size: 2.25em;
}
h2 {
  font-size: 1em;
}
h3 {
  color:#243446;
}
h4 {
}
h5 {
}
h6 {
}
/* Member registration styles */
span.invalid {
  padding-left: 3px;
  color: red;
  font: 65%/1 sans-serif;
}
form {
  padding: 1em;
  font: 80%/1 sans-serif;
  width: 375px;
  border: 1px solid #D5D5D5;
}
label {
    color: #363636;
    float: left;
    font: 65%/1 sans-serif;
    font-weight: bold;
    margin-left: 20px;
    margin-right: 0.5em;
    padding-top: 0.2em;
    text-align: right;
    width: 15%;
}
input {
  margin-bottom: 8px;
}
.register {
  float: left;
  margin-left: 85px;
}

/*  -----  table style  -------  */


/*  = Simple Table style (black header, grey/white stripes  */

.simpletablestyle {
  background-color:#E6E7E8;
  clear:both;
  width: 550px;
}

.simpletablestyle img {
  border:0px;
}

.simpletablestyle td {
  height:2em;
  padding-left: 6px;
  font-size:11px;
  padding:5px 5px;
}

.simpletablestyle th {
	background: url(../gfx/bkg-blkheader.png) black repeat-x top left;
  font-size:12px;
  font-weight:normal;
  padding:0 10px 0 5px;
  border-bottom:#999999 dotted 1px;
}

.simpletablestyle thead {
  background: url(../gfx/bkg-blkheader.png) black repeat-x top left;
  height:31px;
  font-size:10px;
  font-weight:bold;
  color:#FFFFFF;
  text-align:left;
}

.simpletablestyle .header a {
  color:#94aebd;
}

.simpletablestype tfoot {
	height: 20px;
  font-size: 10px;
  font-weight: bold;
  background-color: #EAECEE;
  text-align: center;
}

.simpletablestyle tr.header td {
  padding: 0px 10px 0px 5px;
}


.simpletablestyle .subheader {
  background-color: #e6e7e8;
  font-size:10px;
  font-weight:bold;
  color:#000000;
  text-align:left;
}

/* Using new CSS3 selectors for styling*/
.simpletablestyle tr:nth-child(odd) {
  background: #f4f3f3;
}
.simpletablestyle tr:nth-child(even) {
  background: #ffffff;
}

.simpletablestyle td a:hover {
  color:#3883ce;
  text-decoration:none; 
}

</style>
	<head>
		<title>Spring MVC Starter Application</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="<c:url value="resources/css/screen.css"/>"/>
	</head>

	<body>
		<div id="container">
			<div class="dualbrand">
				<img src="<c:url value="/static/resources/gfx/dualbrand_logo.png"/>"/>
			</div>
			<div id="content">
				<h1>Welcome to JBoss!</h1>

				<div>
					<p>You have successfully deployed a Spring MVC web application.</p>
					<h3>Your application can run on:</h3>
					<img src="<c:url value="/static/resources/gfx/dualbrand_as7eap.png"/>"/>
				</div>

				<form:form commandName="newMember" id="reg">
					<h2>Member Registration</h2>
					<p>Enforces annotation-based constraints defined on the model class.</p>
					<table>
						<tbody>
							<tr>
								<td><form:label path="name">Name:</form:label></td>
								<td><form:input path="name"/></td>
								<td><form:errors class="invalid" path="name"/></td>
							</tr>
							<tr>
								<td><form:label path="email">Email:</form:label></td>
								<td><form:input path="email"/></td>
								<td><form:errors class="invalid" path="email"/></td>
							</tr>
							<tr>
								<td><form:label path="phoneNumber">Phone #:</form:label>
								<td><form:input path="phoneNumber"/></td>
								<td><form:errors class="invalid" path="phoneNumber"/></td>
							</tr>
	
						</tbody>
					</table>
					<table>
						<tr>
							<td>
								<input type="submit" value="Register" class="register"/>
							</td>
						</tr>
					</table>
				</form:form>
				<h2>Members</h2>
				<c:choose>
					<c:when test="${members.size()==0}">
						<em>No registered members.</em>
					</c:when>
					<c:otherwise>
						<table class="simpletablestyle">
							<thead>
								<tr>
									<th>Id</th>
									<th>Name</th>
									<th>Email</th>
									<th>Phone #</th>
									<th>REST URL</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${members}" var="member">
									<tr>
										<td>${member.id}</td>
										<td>${member.name}</td>
										<td>${member.email}</td>
										<td>${member.phoneNumber}</td>
										<td><a href="<c:url value="/rest/members/${member.id}"/>">/rest/members/${member.id}</a></td>
								</c:forEach>
							</tbody>
						</table>
						<table class="simpletablestyle">
							<tr>
								<td>
									REST URL for all members: <a href="<c:url value="/rest/members"/>">/rest/members</a>
								</td>
							</tr>
						</table>
					</c:otherwise>
				</c:choose>
			</div>
			<div id="aside">
				<p>Learn more about JBoss Enterprise Application Platform 6.</p>
				<ul>
					<li><a
						href="http://red.ht/jbeap-6-docs">Documentation</a></li>
					<li><a href="http://red.ht/jbeap-6">Product Information</a></li>
				</ul>
				<p>Learn more about JBoss AS 7.</p>
				<ul>
					<li><a
						href="https://docs.jboss.org/author/display/AS7/Getting+Started+Developing+Applications+Guide">Getting Started Developing Applications Guide</a></li>
					<li><a href="http://jboss.org/jbossas">Community Project Information</a></li>
				</ul>
			</div>
			<div id="footer">
			    <p>
					This project was generated from a Maven archetype from
			        	JBoss.<br />
			    </p>
			</div>
		</div>
	</body>
</html>
