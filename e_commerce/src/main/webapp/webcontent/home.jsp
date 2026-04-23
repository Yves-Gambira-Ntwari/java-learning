<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.Purchase" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
 <style>
    body {
      margin: 0;
      font-family: Arial, sans-serif;
      background-color: #f5f5f5;
    }

    nav {
      background-color: #1e90ff;
      color: white;
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 10px 20px;
    }

    /* Logo */
    nav .logo {
      font-size: 1.5rem;
      font-weight: bold;
      text-decoration: none;
      color: white;
    }

    /* Menu links */
    nav ul {
      list-style: none;
      margin: 0;
      padding: 0;
      display: flex;
    }

    nav ul li {
      margin-left: 20px;
    }

    nav ul li a {
      text-decoration: none;
      color: white;
      padding: 6px 10px;
      transition: background 0.3s, color 0.3s;
    }

    nav ul li a:hover {
      background-color: #1565c0;
      border-radius: 4px;
    }

    /* Mobile menu button */
    .menu-toggle {
      display: none;
      flex-direction: column;
      cursor: pointer;
    }

    .menu-toggle div {
      width: 25px;
      height: 3px;
      background-color: white;
      margin: 4px 0;
    }

    /* Mobile responsive */
    @media (max-width: 768px) {
      nav ul {
        display: none;
        flex-direction: column;
        width: 100%;
      }

      nav ul li {
        margin: 0;
      }

      nav ul li a {
        display: block;
        padding: 10px;
      }

      .menu-toggle {
        display: flex;
      }
    }

    /* Show mobile menu when active */
    nav ul.active {
      display: flex;
    }

    /* Page content */
    .content {
      max-width: 900px;
      margin: 20px auto;
      padding: 0 20px;
    }

    .content h1 {
      color: #333;
    }

    .content p {
      color: #555;
    }
     table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
      background-color: #fff;
      box-shadow: 0 2px 5px rgba(0,0,0,0.1);
    }
    th, td {
      padding: 12px 10px;
      text-align: left;
      border-bottom: 1px solid #ddd;
    }
    th {
      background-color: #1e90ff;
      color: white;
    }
    tr:hover {
      background-color: #f1f1f1;
    }
       .btn {
      padding: 5px 10px;
      border: none;
      border-radius: 4px;
      color: white;
      cursor: pointer;
      margin-right: 5px;
    }
    .btn-delete {
      background-color: #e74c3c;
    }
    .btn-delete:hover {
      background-color: #c0392b;
    }
    .btn-update {
      background-color: #3498db;
    }
    .btn-update:hover {
      background-color: #2980b9;
    }
  </style>
</head>
<body>

<nav>
  <a href="home" class="logo">MyShop</a>
  <div class="menu-toggle" id="menu-toggle">
    <div></div>
    <div></div>
    <div></div>
  </div>
  <ul id="nav-links">
    <li><a href="home">Home</a></li>
    <li><a href="orders">Orders</a></li>
    <li><a href="logout">Logout</a></li>
  </ul>
</nav>

<!-- Page content -->
<div class="content">
<%
	String username = (String) session.getAttribute("username");
if(username == null){
	response.sendRedirect("/e_commerce/login");
}
%>

<h1>Welcome Mr/Miss <%= username %></h1>

<h1>Purchased Items</h1>

<table>
  <thead>
    <tr>
      <th>Item ID</th>
      <th>Item Name</th>
      <th>Category</th>
      <th>Quantity</th>
      <th>Price per Unit ($)</th>
      <th>Purchase Date</th>
      <th>Supplier</th>
      <th>Actions</th>
    </tr>
  </thead>
  <tbody>
  <%! int n; %>
  <%
	List<Purchase> list = (List<Purchase>) request.getAttribute("purchaseList");
	for(Purchase p: list){
		n++;
		
%>

    <tr>
    <td><%=n %></td>
      <td><%= p.getItemName() %></td>
      <td><%= p.getCategory() %></td>
      <td><%= p.getQuantity() %></td>
      <td><%= p.getPrice() %></td>
      <td><%= p.getPurchaseDate() %></td>
      <td><%= p.getSupplier() %></td>
      <td>
      <a href="/e_commerce/delete?id=<%= p.getItemId() %>">
      <button class="btn btn-delete">Delete</button>
      </a>
      <a href="update?id=<%= p.getItemId() %>">
      <button class="btn btn-update">Edit</button>
      </a>
      </td>
    </tr>
<% } %>
  </tbody>
</table>
</div>


</body>
</html>