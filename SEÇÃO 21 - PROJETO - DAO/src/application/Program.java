package application;

import java.sql.Connection;
import java.sql.SQLException;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DB.getConnection();
		}finally {
			DB.closeConnection();
		}

	}

}
