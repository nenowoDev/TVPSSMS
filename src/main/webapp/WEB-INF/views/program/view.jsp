<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Program Plans</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      font-family: Arial, sans-serif;
    }
    .sidebar {
      background-color: #2E4D9D;
      color: white;
      min-height: 100vh;
    }
    .sidebar a {
      color: white;
      text-decoration: none;
      padding: 10px 15px;
      display: block;
      border-radius: 5px;
    }
    .sidebar a:hover {
      background-color: #405FBF;
    }
    .header {
      background-color: #F4F4F9;
      padding: 15px;
      border-bottom: 1px solid #DDD;
    }
    .header .date {
      font-size: 14px;
      color: gray;
    }
    .main-content {
      background-color: #F9FAFD;
      padding: 20px;
    }
    .main-content h2 {
      color: #333;
    }
    .btn-edit {
      background-color: #007BFF;
      color: white;
      border: none;
    }
    .btn-delete {
      background-color: #DC3545;
      color: white;
      border: none;
    }
    .btn-add {
      background-color: #007BFF;
      color: white;
      border: none;
    }
  </style>
</head>
<body>
  <div class="container-fluid">
    <div class="row">
      <!-- Sidebar -->
      <nav class="col-md-2 sidebar p-3">
        <div class="text-center mb-3">
          <img src="teacher-avatar.png" alt="Teacher Avatar" class="rounded-circle mb-2" width="80">
          <h5>Teacher</h5>
          <p>teacher@moe-dl.edu.my</p>
        </div>
        <a href="#">Home</a>
        <a href="#">Manage Studio</a>
        <a href="#">Crew Registration List</a>
        <a href="#">Manage Crew Task</a>
        <a href="#" class="bg-light text-dark">Manage Program</a>
        <a href="#">Manage Program Report</a>
        <a href="#">View Content</a>
        <a href="#">Settings</a>
        <a href="#">Help</a>
        <a href="#">Logout</a>
      </nav>

      <!-- Main Content -->
      <div class="col-md-10">
        <!-- Header -->
        <div class="header d-flex justify-content-between align-items-center">
          <h3>Program Plans</h3>
          <div class="d-flex align-items-center">
            <span class="date">Tuesday, 20/08/2023</span>
          </div>
        </div>

        <!-- Content -->
        <div class="main-content">
          <a href="addProgram.jsp" class="btn btn-add mb-3">Add Program</a>
          <table class="table table-bordered bg-white">
            <thead class="table-light">
              <tr>
                <th>SN</th>
                <th>Program Name</th>
                <th>Date</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              <!-- Dynamic Rows -->
              <c:forEach var="program" items="${programList}">
                <tr>
                  <td>${program.id}</td>
                  <td>${program.name}</td>
                  <td>${program.date}</td>
                  <td>
                    <a href="editProgram.jsp?id=${program.id}" class="btn btn-sm btn-edit">Edit</a>
                    <a href="deleteProgram?id=${program.id}" class="btn btn-sm btn-delete">Delete</a>
                  </td>
                </tr>
              </c:forEach>
              <!-- If no data -->
              <c:if test="${empty programList}">
                <tr>
                  <td colspan="4" class="text-center">No programs found</td>
                </tr>
              </c:if>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
