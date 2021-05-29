package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import db.DbIntegrityException;

public class Program {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;

		Statement st = null;
		ResultSet rs = null;

		PreparedStatement ps = null;

		try {
			conn = DB.getConnection();

			st = conn.createStatement();// instanciar objeto do tipo Statement rs =
			st.executeQuery("SELECT * FROM department");// rs recebe o resulta do
			// Statement que é um objeto para executar SQL.
			while (rs.next()) {
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
			}

			// ADICIONAR DADOS
			ps = conn.prepareStatement("INSERT INTO seller" + "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
					+ "VALUES" + "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS); // interrogação quer dizer que o
																						// valor vai ser adicionado
			ps.setString(1, "Carl Purple");// adicionando dados
			ps.setString(2, "carl@gmail.com");
			ps.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
			ps.setDouble(4, 3000.00);
			ps.setInt(5, 4);
			int rowsAffected = ps.executeUpdate(); // realizar a atualização
			if (rowsAffected > 0) {
				rs = ps.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! ID = " + id);
				}
			} else {
				System.out.println("No rows affected.");
			}
			ps = conn.prepareStatement("INSERT INTO department (Name) values ('D1'), ('D2')",
					Statement.RETURN_GENERATED_KEYS);
			rowsAffected = ps.executeUpdate(); // realizar a atualização
			if (rowsAffected > 0) {
				rs = ps.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! ID = " + id);
				}
				DB.closeResultSet(rs);
			} else {
				System.out.println("No rows affected.");
			}

			// Atualizar Dados.
			ps = conn.prepareStatement("UPDATE seller SET BaseSalary = BaseSalary + ? WHERE DepartmentId = ?");
			ps.setDouble(1, 200.00);
			ps.setInt(2, 2);
			rowsAffected = ps.executeUpdate();
			System.out.println("Done! Rows affected: " + rowsAffected);

			// deletar dadods
			ps = conn.prepareStatement("DELETE FROM department WHERE Id = ?");
			ps.setInt(1, 5);
			rowsAffected = ps.executeUpdate();
			System.out.println("Rows Affected: " + rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbIntegrityException(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {

			DB.closeResultSet(rs);
			DB.closeStatement(st);

			DB.closeStatement(ps);
			DB.closeConnection();

		}
	}
}
