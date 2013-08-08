package org.hymer.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 * 
 */
public class BatchTest {
	public static void main(String[] args) {
		BatchTest app = new BatchTest();
		int count = 120000;
		List<Connection> conns = app.initConns(1);

		System.out.println("begin test...");
		long begin = System.currentTimeMillis();

//		app.insertBatch(conns.get(0), count); // count=12000:11706ms 11096ms 11959ms 10327ms 11062ms
//		app.insertOneByOne(conns.get(0), count); // count=12000:12956ms 12969ms 10986ms 9955ms

//		app.insertBatch(conns.get(0), count); // count=120000:95297ms 119776ms
//		app.insertOneByOne(conns.get(0), count); // count=120000:100942ms 141726ms
		long end = System.currentTimeMillis();
		System.out.println("total use:" + (end - begin) + "ms");
		app.closeConns(conns);
		System.out.println("end test...");

	}

	void insertOneByOne(Connection conn, int count) {
		String sql = "insert into user (name, age) values (?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			for (int j = 0; j < count; j++) {
				pstmt.setString(1, "user" + j);
				pstmt.setInt(2, j);
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	void insertBatch(Connection conn, int count) {
		String sql = "insert into user (name, age) values (?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < count; i++) {
				pstmt.setString(1, "user" + i);
				pstmt.setInt(2, i);
				pstmt.addBatch();
			}
			pstmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	List<Connection> initConns(int count) {
		List<Connection> conns = new ArrayList<Connection>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			for (int i = 0; i < count; i++) {
				Connection conn = DriverManager
						.getConnection(
								"jdbc:mysql://192.168.92.140:3306/t_test?useUnicode=true&characterEncoding=UTF-8",
								"root", "root");
				conns.add(conn);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conns;
	}

	void closeConns(List<Connection> conns) {
		try {
			for (Connection conn : conns) {
				if (conn != null) {
					conn.close();
				}
			}
		} catch (Exception e) {

		}
	}

}
