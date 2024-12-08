<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Crew Task</title>
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
        <h2>Manage Crew Task</h2>
        <div class="mb-3">
          <input type="text" class="form-control" placeholder="Search your task here..." />
        </div>
        <table class="table">
          <thead class="thead-light">
            <tr>
              <th>No.</th>
              <th>Task Name</th>
              <th>Crew Name</th>
              <th>Roles</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
          <tr>
          <td>1</td>
          <td>Edit Video for Program 1</td>
          <td>Ali bin Abu</td>
          <td>Multimedia</td>
                        <td class="table-action-buttons">
                            <button class="btn btn-sm btn-primary">Edit</button>
                            <button class="btn btn-sm btn-danger">Delete</button>
                        </td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>Publish Video Program 3 to Youtube</td>
                        <td>Arvindra</td>
                        <td>Multimedia</td>
                        <td class="table-action-buttons">
                            <button class="btn btn-sm btn-primary">Edit</button>
                            <button class="btn btn-sm btn-danger">Delete</button>
                        </td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>Plan Storyboard for Video Program 5</td>
                        <td>Aminah binti Samad</td>
                        <td>Art and Design</td>
                        <td class="table-action-buttons">
                            <button class="btn btn-sm btn-primary">Edit</button>
                            <button class="btn btn-sm btn-danger">Delete</button>
                        </td>
                    </tr>
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
