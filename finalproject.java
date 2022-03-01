package tw.kekai.jdbc;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import tw.kekai.jdbc.model.Numbers;



public class finalproject {
	
	
	public static void main(String[] args) throws Exception {

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		String acc, pwd;
		Scanner data = new Scanner(System.in);
		
		System.out.println("請輸入帳號：");
		acc = data.nextLine();
		System.out.println("請輸入密碼：");
		pwd = data.nextLine();
		
		if(acc != null && pwd != null ) {
		String urlStr = "jdbc:sqlserver://localhost:1433;databaseName=KekaiBB;user=" + acc + ";password=" + pwd;
	    Connection conn = DriverManager.getConnection(urlStr);

		boolean status = !conn.isClosed();
		System.out.println("SQL Server Connection ststus:" + status);

		statistics();
		
		Statement state = conn.createStatement();
		String sqlstr1 = "Select * From finally";
		ResultSet rs = state.executeQuery(sqlstr1);
		
		while (rs.next()) {
			System.out.println( rs.getInt(1)+ "  time  " +rs.getInt(2) + " " + rs.getInt(3) + " " + rs.getInt(4) + " "
					+ rs.getInt(5) + " " + rs.getInt(6)+ " "+rs.getInt(7) );
		}

		rs.close();
		state.close();
		conn.close();
	}
	}
	public static void statistics() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("請輸入所需資料組數：");
		int num1;
		num1 = scanner.nextInt();	
		System.out.println("Original Data:");
		System.out.println("---------------------------------");
		long[] a;
		long[] a2;
		int[] b;
		long ac;
		b = new int[43];
		int y;
		int z, w, big;
		a = new long[43];
		a2 = new long[43];
		for(int p = 0; p<num1;p++) {
		for (long n = 0; n <= 100000; n++) {
			int t = (int) (Math.random() * 42 + 1);
			a[t] = a[t] + 1;
		}
		for (int t = 1; t < 43; t++) {
			b[t] = t;
			a2[t] = a[t];
			System.out.println(+t + "  " + a[t]);
		}
		}
		
		System.out.println("---------------------------------");
		System.out.println("Store results");
		System.out.println("---------------------------------");

		z = a.length - 1;
		while (z != 0) {
			w = 0;
			for (int x = 1; x < a.length - 1; x++) {
				if (a2[x] < a2[x + 1]) {
					y = b[x];
					b[x] = b[x + 1];
					b[x + 1] = y;

					ac = a2[x];
					a2[x] = a2[x + 1];
					a2[x + 1] = ac;
					w = x;

				}
				z = w;

			}
		}
		

		Numbers num = new Numbers();
		num.setNo_1(b[1]);
		num.setNo_2(b[2]);
		num.setNo_3(b[3]);
		num.setNo_4(b[4]);
		num.setNo_5(b[5]);
		num.setNo_6(b[6]);
		try {
			register(num);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void register(Numbers num) throws Exception {
		String sql = "INSERT INTO finally (no_1 , no_2 , no_3 ,no_4,no_5,no_6) VALUES (?,?,?,?,?,?)";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String sqlstr = "jdbc:sqlserver://localhost:1433;databaseName=KekaiBB";
		Connection conn = DriverManager.getConnection(sqlstr,"watcher","P@ssw0rd");

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num.getNo_1());
			pstmt.setInt(2, num.getNo_2());
			pstmt.setInt(3, num.getNo_3());
			pstmt.setInt(4, num.getNo_4());
			pstmt.setInt(5, num.getNo_5());
			pstmt.setInt(6, num.getNo_6());

			pstmt.executeUpdate();

		} catch (java.sql.SQLException e) {
		} finally {
			conn.close();
		}
	}

}