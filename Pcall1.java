import java.sql.*;
public class Pcall{
	public static void main(String args[]){
		Connection con;
		CallableStatement cst;
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","tnrao");
			cst = con.prepareCall("{call p_add2()}");
			cst.execute();
			System.out.println("Record Inserted...");
			con.close();
			cst.close();
		} 
		catch(Exception e){
			System.out.println(e);
		}
	}
}
/*CREATE PROCEDURE p_add2()
BEGIN
INSERT INTO emp2 (id, name, desig, city) VALUES (idx, namex, desigx, cityx);
END //
DELIMITER ;*/
