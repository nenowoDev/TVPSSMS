<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View All videos</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
  <div class="row">
    <!-- Sidebar -->
    <div class="col-md-2 bg-primary text-white min-vh-100">
      <div class="p-3">
        <h5>Teacher Avatar</h5>
        <p>Teacher<br>teacher@moe-dl.edu.my</p>
        <ul class="nav flex-column">
          <li class="nav-item"><a href="#" class="nav-link text-white">Home</a></li>
          <li class="nav-item"><a href="registration" class="nav-link text-white">Crew Registration List</a></li>
          <li class="nav-item"><a href="task" class="nav-link text-white">Manage Crew Task</a></li>
          <li class="nav-item"><a href="#" class="nav-link text-white">Manage Program</a></li>
          <li class="nav-item"><a href="#" class="nav-link text-white">Manage Program Report</a></li>
          <li class="nav-item"><a href="content/view" class="nav-link text-white">View Content</a></li>
          <li class="nav-item"><a href="#" class="nav-link text-white">Settings</a></li>
          <li class="nav-item"><a href="#" class="nav-link text-white">Help</a></li>
          <li class="nav-item"><a href="#" class="nav-link text-white">Logout</a></li>
        </ul>
      </div>
    </div>
    <!-- Main Content -->
    <div class="col-md-10">
      <div class="p-4">
        <h2>Video List</h2>
        <div class="mb-3">
          <input type="text" class="form-control" placeholder="Search your video here..." />
        </div>
        <div class="row">
  <!-- Loop through content list -->
  <c:forEach var="content" items="${contentList}">
    <div class="col-md-4 mb-4">
      <div class="card">
        <img src="https://via.placeholder.com/320x180" class="card-img-top" alt="Video Thumbnail">
        <div class="card-body">
          <h5 class="card-title">${content.contentTitle}</h5>
          <p class="card-text">${content.contentDescription}</p>
          <a href="/TVPSSMS/content/view/${content.contentID}" class="btn btn-primary btn-sm" target="_blank">View</a>
        </div>
      </div>
    </div>
  </c:forEach>
</div>
        
      </div>
    </div>
  </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
