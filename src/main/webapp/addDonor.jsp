<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, com.spring.donation.Donor" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Donor Management</title>
<style>
    body { font-family: Arial, sans-serif; margin: 20px; }
    h2 { color: #2c3e50; }
    table { border-collapse: collapse; width: 100%; margin-top: 20px; }
    table, th, td { border: 1px solid #ddd; padding: 10px; }
    th { background-color: #2c3e50; color: white; }
    form { margin-bottom: 20px; }
    input, button { padding: 8px; margin: 5px; }
</style>
</head>
<body>

<h2>Donor Management</h2>

<!-- Add Donor Form -->
<h3>Add Donor</h3>
<form action="AddDonorServlet" method="post">
    Name: <input type="text" name="name" required>
    Email: <input type="email" name="email" required>
    Phone: <input type="text" name="phone" required>
    Donation Amount: <input type="number" name="amount" required>
    <button type="submit">Add Donor</button>
</form>

<!-- Update Donor Form -->
<h3>Update Donor</h3>
<form action="UpdateDonorServlet" method="post">
    Donor ID: <input type="number" name="id" required>
    New Name: <input type="text" name="name">
    New Email: <input type="email" name="email">
    New Phone: <input type="text" name="phone">
    New Donation Amount: <input type="number" name="amount">
    <button type="submit">Update Donor</button>
</form>

<!-- Delete Donor Form -->
<h3>Delete Donor</h3>
<form action="DeleteDonorServlet" method="post">
    Donor ID: <input type="number" name="id" required>
    <button type="submit">Delete Donor</button>
</form>

<!-- Display All Donors -->
<h3>All Donors</h3>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Donation Amount</th>
    </tr>
    <%
        List<Donor> donors = (List<Donor>) request.getAttribute("donorList");
        if(donors != null) {
            for(Donor d : donors) {
    %>
    <tr>
        <td><%= d.getId() %></td>
        <td><%= d.getName() %></td>
        <td><%= d.getEmail() %></td>
        <td><%= d.getPhone() %></td>
        <td><%= d.getDonation_type() %></td>
        <td><%= d.getAmount_of_items() %></td>
    </tr>
    <%
            }
        } else {
    %>
    <tr><td colspan="6">No donors found</td></tr>
    <% } %>
</table>

</body>
</html>
