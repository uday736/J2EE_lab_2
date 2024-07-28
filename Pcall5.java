import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Pcall5 {
    public static void main(String[] args) {
    	  
        
        Scanner sc = new Scanner(System.in);
        
        Pcall5 obj = new Pcall5();
        
        while (true) {
            System.out.println("Click 1 To Insert Record...");
            System.out.println("Click 2 To Update Record...");
            System.out.println("Click 3 To Delete Record...");
            System.out.println("Click 4 To View Record...");
            System.out.println("Click 5 To Exit");
            
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    obj.doInsert();
                    break;
                case 2:
                    obj.doUpdate();
                    break;
                case 3:
                    obj.doDelete();
                    break;
                case 4:
                    obj.doView();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }

    public void doInsert() {
        Scanner sc = new Scanner(System.in);
        Connection con = null;
        PreparedStatement pst = null;
        //ResultSet rs = null;
		         try{
		         		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","tnrao");
		         		
			            String sql = "insert into emp2 values(?,?,?,?)";
			            
			            System.out.print("Enter The Id:");
			            int idx = sc.nextInt();
			            
			            System.out.println("Enter The Name:");
			            String namex = sc.nextLine();
			            
			            System.out.print("Enter The Designation:");
			            String desigx = sc.nextLine();
			            
			            System.out.print("Enter The City:");
                		String cityx = sc.nextLine();
                		
			            pst = con.prepareStatement(sql);
			            
			            pst.setInt(1,idx);
			            pst.setString(2,namex);
			            pst.setString(3,desigx);
			            pst.setString(4,cityx);
			            pst.executeUpdate();
			            System.out.println("Record Inserted...");
			            
			            con.close();
			            pst.close();
		        } 
		        catch(Exception e){
			       System.out.println(e);
		        }
    }

    public void doUpdate() {
        Scanner sc = new Scanner(System.in);
        Connection con = null;
        PreparedStatement pst = null;
        //ResultSet rs = null;
		         try{
			            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","tnrao");
			            
			            String sql = "update emp2 set name = ? where id = ?";
			            
			            System.out.println("Enter Id:");
			            int idx = sc.nextInt();
			            
			            System.out.println("Enter Name:");
			            String val = sc.nextLine();
			            
			            pst = con.prepareStatement(sql);
			            
			            pst.setInt(2,idx);
			            pst.setString(1,val);
			            
			            System.out.println("Record Updated...");
			            con.close();
			            pst.close();
		        } 
		        catch(Exception e){
			       System.out.println(e);
		        }
    }

    public void doDelete() {
        Scanner sc = new Scanner(System.in);
        Connection con = null;
        PreparedStatement pst = null;
        //ResultSet rs = null;
		         try{
			            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","tnrao");
			            String sql = "delete from emp2 where id = ?";
			            int idx = sc.nextInt();
			            
			            
			            System.out.print("Enter The Id:");
			            pst.setInt(1,idx);
			            pst = con.prepareStatement(sql);
			            System.out.println("Record Deleted...");
			            con.close();
			            pst.close();
		        } 
		        catch(Exception e){
			       System.out.println(e);
		        }
    }

    public void doView() {
        Scanner sc = new Scanner(System.in);
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
		         try{
			            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","tnrao");
			            String sql = "select * from emp2 where id = ?";
			            int idx = sc.nextInt();
			            pst = con.prepareStatement(sql);
			            pst.setInt(1,idx);
			            rs = pst.executeQuery();
			            while(rs.next()){
			                int id = rs.getInt("id");
				String name = rs.getString("name");
				String desig = rs.getString("desig");
				String city = rs.getString("city");
				
				System.out.println("Id:" + id);
				System.out.println("Name:" + name);
				System.out.println("Designation:" + desig);
				System.out.println("City:" + city);
			            }
			            con.close();
			            pst.close();
		        } 
		        catch(Exception e){
			       System.out.println(e);
		        }
        
    }
    }
               

               
