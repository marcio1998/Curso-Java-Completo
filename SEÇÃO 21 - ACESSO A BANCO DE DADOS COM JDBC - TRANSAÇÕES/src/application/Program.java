package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program {
	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		try {
			conn = DB.getConnection();
			//inicio de transação. protegendo o bloco. - por causa do erro gerado não executa nenhum comando sql, só funciona se os dois rodarem.
			conn.setAutoCommit(false);
			st = conn.createStatement();
			int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090.00 WHERE DepartmentID = 1");
			/*int x = 1;
			if(x <2) {
				throw new SQLException("Fake Error");
			}*/
			int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090.00 WHERE DepartmentID = 2");
			conn.commit();
			System.out.println("Rows1: " + rows1);
			System.out.println("Rows2: " + rows2);
		}catch(SQLException e) {
			try {
				conn.rollback();//voltar no innicio
				throw new DbException("Transaction rolled back! Cause by: " + e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Error trying to roll back! Cause by: " + e.getMessage());
			}
		}
	}
}
