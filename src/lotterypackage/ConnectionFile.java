package lotterypackage;
import java.sql.Connection;
import java.sql.DriverManager;

	public class ConnectionFile
	{

			static Connection con;
			static Connection doConnect()
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lotteryproject","root","bce");
					return con;
				
				
					
					
				} catch (Exception e) {
					System.out.println(e);
					
					e.printStackTrace();
				}
				return null;
			}

		}

