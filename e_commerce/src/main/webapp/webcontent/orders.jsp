<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

    h1 {
      color: #333;
    }

    form {
      background-color: #fff;
      padding: 20px;
      max-width: 600px;
      box-shadow: 0 2px 5px rgba(0,0,0,0.1);
      border-radius: 6px;
    }

    label {
      display: block;
      margin-top: 15px;
      font-weight: bold;
    }

    input, select {
      width: 100%;
      padding: 8px 10px;
      margin-top: 5px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    button {
      margin-top: 20px;
      padding: 10px 15px;
      border: none;
      border-radius: 4px;
      background-color: #1e90ff;
      color: white;
      font-size: 16px;
      cursor: pointer;
    }

    button:hover {
      background-color: #1565c0;
    }
    
  </style>
</head>
<body>

<!-- Navbar -->
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
<%
	String username = (String) session.getAttribute("username");
if(username == null){
	response.sendRedirect("/e_commerce/login");
}
%>
<div class="content">

<h1>Add Purchased Item</h1>

<form action="orders" method="POST">

  <label for="itemName">Item Name</label>
  <input type="text" id="itemName" name="itemName" required>

  <label for="category">Category</label>
  <select id="category" name="category" required>
    <option value="">--Select Category--</option>
    <option value="Electronics">Electronics</option>
    <option value="Furniture">Furniture</option>
    <option value="Stationery">Stationery</option>
    <option value="Appliances">Appliances</option>
    <option value="Misc">Misc</option>
  </select>

  <label for="quantity">Quantity</label>
  <input type="number" id="quantity" name="quantity" min="1" required>

  <label for="price">Price per Unit ($)</label>
  <input type="number" id="price" name="price" min="0" step="0.01" required>

  <label for="purchaseDate">Purchase Date</label>
  <input type="date" id="purchaseDate" name="purchaseDate" required>

  <label for="supplier">Supplier</label>
  <input type="text" id="supplier" name="supplier" required>

  <button type="submit">Add Item</button>
</form>

</body>
</html>