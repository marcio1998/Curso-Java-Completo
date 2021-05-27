package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		/*
		 * Statement st = null; ResultSet rs = null;
		 */
		
		PreparedStatement ps = null;

		try {
			conn = DB.getConnection();
			/*
			 * st = conn.createStatement();//instanciar objeto do tipo Statement rs =
			 * st.executeQuery("SELECT * FROM department");//rs recebe o resulta do
			 * Statement que é um objeto para executar SQL. while(rs.next()) {
			 * System.out.println(rs.getInt("Id") + ", " + rs.getString("Name")); }
			 */
			// ADICIONAR DADOS
			ps = conn.prepareStatement("INSERT INTO seller" + "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
					+ "VALUES" + "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS); // interrogação quer dizer que o valor vai ser adicionado
			ps.setString(1, "Carl Purple");// adicionando dados
			ps.setString(2, "carl@gmail.com");
			ps.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
			ps.setDouble(4, 3000.00);
			ps.setInt(5, 4);
			int rowsAffected = ps.executeUpdate(); // realizar a atualização
			if(rowsAffected > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				while(rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! ID = " + id);
				}
			}else {
				System.out.println("No rows affected.");
			} 
			ps = conn.prepareStatement("INSERT INTO department (Name) values ('D1'), ('D2')", Statement.RETURN_GENERATED_KEYS);
			rowsAffected = ps.executeUpdate(); // realizar a atualização
			if(rowsAffected > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				while(rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! ID = " + id);
				}
				DB.closeResultSet(rs);
			}else {
				System.out.println("No rows affected.");
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			/*
			 * DB.closeResultSet(rs); DB.closeStatement(st);
			 */
			DB.closeStatement(ps);
			DB.closeConnection();

		}
	}
}
