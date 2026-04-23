package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DBConnection {
	

	public static Connection getConnection() {
	    try {
	        Class.forName("org.mariadb.jdbc.Driver");

	        return DriverManager.getConnection(
	            "jdbc:mariadb://localhost:3306/e_commerce",
	            "root",
	            ""
	        );

	    } catch (Exception e) {
	        throw new RuntimeException("Database connection failed!", e);
	    }
	}
    
    public void InsertUser(String username, String password) throws IOException{
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection conn = DBConnection.getConnection();
			String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            int rows = ps.executeUpdate();
            System.out.println("Inserted successful");
            
			
		}catch(Exception e) {
            System.out.println("Inserted Error");
			
		}
    }
    public boolean LoginUser(String username, String password) throws IOException{
    	try {    		
    	Class.forName("org.mariadb.jdbc.Driver");
    	Connection conn = DBConnection.getConnection();
    	String sql = "SELECT * FROM users WHERE username=? AND password=?";
    	PreparedStatement ps = conn.prepareStatement(sql);
    	ps.setString(1, username);
    	ps.setString(2, password);
    	ps.executeQuery();
    	return true;
    	}catch(Exception E) {
    		System.out.print(E);
    		return false;
    		
    	}
    }
    
    public boolean InsertOrder(String itemName, String category, String quantity, String price, String purchaseDate, String supplier) throws IOException{
    	try {
    		Class.forName("org.mariadb.jdbc.Driver");
    		Connection conn = DBConnection.getConnection();
    		String sql = "INSERT INTO purchases(item_name, category, quantity, price, purchase_date, supplier)VALUES (?, ?, ?, ?, ?, ?)";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setString(1, itemName);
    		ps.setString(2, category);
    		ps.setString(3, quantity);
    		ps.setString(4, price);
    		ps.setString(5, purchaseDate);
    		ps.setString(6, supplier);
    		int row = ps.executeUpdate();
    		if(row > 0) { 
    			System.out.print("Inserted successfull");
    		}
    		return true;
    	}catch(Exception E) {
    		return false;
    	}
    }
    public List<Purchase> getPurchased() {
        List<Purchase> list = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM purchases");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Purchase p = new Purchase();

                p.setItemId(rs.getInt("item_id"));
                p.setItemName(rs.getString("item_name"));
                p.setCategory(rs.getString("category"));
                p.setQuantity(rs.getInt("quantity"));
                p.setPrice(rs.getDouble("price"));
                p.setPurchaseDate(rs.getDate("purchase_date"));
                p.setSupplier(rs.getString("supplier"));

                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
   public boolean DeletePurchase(int id) throws IOException {
	   try {
		   Class.forName("org.mariadb.jdbc.Driver");
		   Connection conn = DBConnection.getConnection();
		   String sql="DELETE FROM purchases WHERE item_id=?";
		   PreparedStatement ps = conn.prepareStatement(sql); 
		   ps.setInt(1, id);
		   int row = ps.executeUpdate();
		   return true;
	   }catch(Exception E) {
		   return false;
	   }
   }
   
   public boolean UpdatePurchase(String itemName, String category, String quantity, String price, String purchaseDate, String supplier, int id) throws IOException {
	   try {
		   Class.forName("org.mariadb.jdbc.Driver");
		   Connection conn = DBConnection.getConnection();
		   String sql =  "UPDATE purchases SET item_name=?, category=?, quantity=?, price=?, purchase_date=?, supplier=? WHERE item_id=?";;
		   PreparedStatement ps = conn.prepareStatement(sql);
   		ps.setString(1, itemName);
   		ps.setString(2, category);
   		ps.setString(3, quantity);
   		ps.setString(4, price);
   		ps.setString(5, purchaseDate);
   		ps.setString(6, supplier);
   		ps.setInt(7, id);
   		int row = ps.executeUpdate();
		   return true;
	   }catch(Exception E) {
		   return false;
	   }
   }

   public PurchaseWithId getPurchaseWithId(int id) throws IOException{
	   PurchaseWithId purchase = null;
	   try {
		   Class.forName("org.mariadb.jdbc.Driver");
		   Connection conn = DBConnection.getConnection();
		   String sql = "SELECT * FROM purchases WHERE item_id=?";
		   PreparedStatement ps = conn.prepareStatement(sql);
		   ps.setInt(1, id);
		  ResultSet rs =  ps.executeQuery();
		  if(rs.next()) {
			  purchase  = new PurchaseWithId();
			  purchase.setItemId(rs.getInt("item_id"));
			  purchase.setItemName(rs.getString("item_name"));
			  purchase.setCategory(rs.getString("category"));
			  purchase.setQuantity(rs.getInt("quantity"));
			  purchase.setPrice(rs.getDouble("price"));
			  purchase.setPurchaseDate(rs.getDate("purchase_date"));
			  purchase.setSupplier(rs.getString("supplier"));
			  
		  }
		   return purchase;
	   }catch(Exception E) {
		   return purchase;
	   }
   }
}