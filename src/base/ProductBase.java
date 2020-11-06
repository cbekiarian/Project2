package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import base.*;

public class ProductBase {
	
	public int registerProduct(Product product)throws ClassNotFoundException {
		
		String INSERT_USERS_SQL = "INSERT INTO product" +
		"(BarCode, Name, Color , Description)VALUES" + 
		"(?,?,?,?);";
		
		int result = 0;
		
		Class.forName("com.mysql.jdbc.Driver");

		
		if (result == 0 ) {
			
			try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb","root","12345");

			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
			preparedStatement.setInt(1,product.getBarcode());
			preparedStatement.setString(2,product.getName());
			preparedStatement.setString(3, product.getColor());
			preparedStatement.setString(4,product.getDescription());
		
			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();
	
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			
			return result;
		}
		else {
			
			return result;
		}
		
	
	}
	
}