package simple_insert;

import java.sql.*;
import java.util.*;

public class MoviesDB {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		choice();
	}
	
static void choice() {
	System.out.println("WELCOME TO MOVIE DATABASE\nIN THIS WE HAVE 5 CHOICES");
	System.out.println("1.View Database\n2.Insert Database");
	System.out.println("3.Update Database\n4.Delete Database\n5.EXIT");
	System.out.println("Enter choice:");
	int ch=sc.nextInt();
	switch(ch) {	
	case 1:
		ViewDatabase();
		break;
	case 2:
		InsertDatabase();
		break;
	case 3:
		UpdateDatabase();
		break;
	case 4:
		DeleteDatabase();
		break;	
	case 5:
		System.out.println("EXIT");
		break;
	default:
		System.out.println("Please Enter Correct Choice");
	}
}


static void InsertDatabase() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/moviesdb","root","");
		
		System.out.print("Enter id: ");
		int id=sc.nextInt();
		System.out.print("Enter MovieName: ");
		String movieName=sc.next();
		System.out.print("Enter ActorName: ");
		String actor=sc.next();
		System.out.print("Enter ActressName: ");
		String actress=sc.next();
		System.out.println();   
		
		String res="INSERT INTO movies(id,moviename,actor,actress) VALUES ('"+id+"', '"+movieName+"', '"+actor+"', '"+actress+"')";
		Statement stmt=con.createStatement();
		stmt.executeUpdate(res);
		System.out.println("----------------------------------");
		System.out.println("id:"+id+" "+"movie:"+movieName+" "+"actor:"+actor+" "+"actress:"+actress+" Inserted Successfully"); 
		System.out.println("----------------------------------");
		System.out.println("IF YOU WANT TO CONTINUE?(1/0)");
		int cont=sc.nextInt();
        if(cont==1) { 
        	choice();
        }
        else {
        	System.out.println("Exit");
        } 
	}
	catch(Exception e) {
		System.out.println(e);
	}	
}


static void UpdateDatabase() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/moviesdb","root","");
		
		System.out.println("Overall Database:");
		String res1="SELECT * from movies";
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(res1);
		System.out.println("-----------------------------------------------------------------");
        System.out.println("ID" + "\t\t" + "MovieName" + "\t\t" + "Actor" + "\t\t" + "Actress");
        System.out.println("-----------------------------------------------------------------");
		
		while (rs.next()) {
			int id1 = rs.getInt("id");
            String moviename = rs.getString("moviename");
            String actor = rs.getString("actor");
            String actress = rs.getString("actress");
            System.out.println(id1 + "\t\t" + moviename + "\t\t" + actor + "\t\t" + actress);
        }
		
		System.out.println("which column want to update:\n1.Movie Name\n2.Actor\n3.Actress");
		int ch=sc.nextInt();
		if(ch==1) {
			System.out.print("UPDATE MOVIENAME \n");
			System.out.println("Enter id(which id of moviename update):");
			int id=sc.nextInt();
			System.out.println("Enter moviename:");
			String movieName=sc.next();
			
			String res="UPDATE movies SET moviename='"+movieName+"' where id='"+id+"'";
			Statement stmt1=con.createStatement();
			stmt1.executeUpdate(res);
			System.out.println("----------------------------------");
			System.out.println("movie:"+movieName+" updated Successfully"); 
			System.out.println("----------------------------------");
			System.out.println("IF YOU WANT TO CONTINUE?(1-goto update DB/0-got0 choices)");
			int cont=sc.nextInt();
	        if(cont==1) {
	        	UpdateDatabase();
	        }
	        else {
	        	System.out.println("Exit");
	        } 
		}
		else if(ch==2) {
			System.out.print("UPDATE ACTORNAME \n");
			System.out.println("Enter id(which id of actorname update):");
			int id=sc.nextInt();
			System.out.println("Enter actorname:");
			String actor=sc.next();
			
			String res="UPDATE movies SET actor='"+actor+"' where id='"+id+"'";
			Statement stmt1=con.createStatement();
			stmt1.executeUpdate(res);
			System.out.println("----------------------------------");
			System.out.println("actorname:"+actor+" updated Successfully"); 
			System.out.println("----------------------------------");
			System.out.println("IF YOU WANT TO CONTINUE?(1-goto update DB/0-got0 choices)");
			int cont=sc.nextInt();
	        if(cont==1) {
	        	UpdateDatabase();
	        }
	        else {
	        	System.out.println("Exit");
	        } 
		}
		else if(ch==3) {
			System.out.print("UPDATE ACTRESSNAME \n");
			System.out.println("Enter id(which id of actressname update):");
			int id=sc.nextInt();
			System.out.println("Enter actressname:");
			String actress=sc.next();
			
			String res="UPDATE movies SET actress='"+actress+"' where id='"+id+"'";
			Statement stmt1=con.createStatement();
			stmt1.executeUpdate(res);
			System.out.println("----------------------------------");
			System.out.println("Actressname:"+actress+" updated Successfully"); 
			System.out.println("----------------------------------");
			System.out.println("IF YOU WANT TO CONTINUE?(1-goto update DB/0-got0 choices)");
			int cont=sc.nextInt();
	        if(cont==1) {
	        	UpdateDatabase();
	        }
	        else {
	        	choice();
	        }
	     }
		else {
        	System.out.println("Invalid");
        }
	}	
	catch(Exception e) {
		System.out.println(e);
	}	
}

private static void DeleteDatabase() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/moviesdb","root","");
		
		System.out.println("Overall Database:");
		String res1="SELECT * from movies";
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(res1);
		System.out.println("-----------------------------------------------------------------");
        System.out.println("ID" + "\t\t" + "MovieName" + "\t\t" + "Actor" + "\t\t" + "Actress");
        System.out.println("-----------------------------------------------------------------");
		
		while (rs.next()) {
			int id1 = rs.getInt("id");
            String moviename = rs.getString("moviename");
            String actor = rs.getString("actor");
            String actress = rs.getString("actress");
            System.out.println(id1 + "\t\t" + moviename + "\t\t" + actor + "\t\t" + actress);
        }
		System.out.print("Enter id: ");
		int id=sc.nextInt();
		
		String res="DELETE from movies where id='"+id+"' ";
		Statement stmt1=con.createStatement();
		stmt1.executeUpdate(res);
		System.out.println("----------------------------------");
		System.out.println("Deleted Successfully of id='"+id+"' "); 
		System.out.println("----------------------------------");
		System.out.println("IF YOU WANT TO CONTINUE?(1/0)");
		int cont=sc.nextInt();
        if(cont==1) { 
        	choice();
        }
        else {
        	System.out.println("Exit");
        } 
	} 
    catch(Exception e) {
    	System.out.println(e);
    }
}

private static void ViewDatabase() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/moviesdb","root","");
	
		String res="SELECT * from movies";
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(res);
		System.out.println("-----------------------------------------------------------------");
        System.out.println("ID" + "\t\t" + "MovieName" + "\t\t" + "Actor" + "\t\t" + "Actress");
        System.out.println("-----------------------------------------------------------------");
		
		while (rs.next()) {
			int id1 = rs.getInt("id");
            String moviename = rs.getString("moviename");
            String actor = rs.getString("actor");
            String actress = rs.getString("actress");
            System.out.println(id1 + "\t\t" + moviename + "\t\t" + actor + "\t\t" + actress);
        }
		
		System.out.println("IF YOU WANT TO CONTINUE?(1/0)");
		int cont=sc.nextInt();
        if(cont==1) { 
        	choice();
        }
        else {
        	System.out.println("Exit");
        } 
	} 
    catch(Exception e) {
    	System.out.println(e);
    }
}

}
