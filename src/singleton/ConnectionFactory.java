package singleton;

import java.sql.*;

public class ConnectionFactory {
	
	private static ConnectionFactory instance = new ConnectionFactory();
	
	public static final String URL = "jdbc:mysql://localhost:3306/world";
	public static final String USER = "root";
	public static final String PASSWORD = "Tpg@1234";
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

	private ConnectionFactory(){
		try{
			Class.forName(DRIVER_CLASS);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private Connection createConnection(){
		Connection connection = null;
		try{
			connection = DriverManager.getConnection(URL,USER,PASSWORD);
		}catch(Exception e){
			System.out.println("unable to connect to the database");
		}
		return connection;
	}

	//double checked locking
	public static ConnectionFactory getInstance(){
		if(instance==null){
			synchronized(Connection.class){
				if(instance==null){
					instance = new ConnectionFactory();
				}
			}
		}
		return instance;
	}
	 
	public Connection getConnection(){
		/*
		if(instance==null){
			 synchronized (Connection.class) {
				 if(instance==null){
					 instance = new ConnectionFactory();
				 }
			 }
		}
		*/
		//return instance.createConnection();
		return ConnectionFactory.getInstance().createConnection();
	}
	
	/*---------------commented codes below-------------------------------------------------------*/
	/*
	//for insertion into database
	public int insert(String username, String password) throws SQLException  {  
        
		Connection con =null;  
        PreparedStatement ps=null;  
          
        int Counter=0;  
          
        try {  
                con = ConnectionFactory.getConnection();  
                ps = con.prepareStatement("insert into user(username,password) values(?,?)");  
                ps.setString(1,username);  
                ps.setString(2,password);  
                Counter = ps.executeUpdate();  
                  
        } catch (Exception e) { 
        	e.printStackTrace(); 
        } finally{  
              if (ps!=null){  
                ps.close();  
            }if(con!=null){  
                con.close();  
            }   
        }  
        
       return Counter;  
    }  

	//to view the data from the database        
	public  void view() throws SQLException  {  
		Connection con = null;  
	    PreparedStatement ps = null;  
	    ResultSet rs = null;          
	          try {  
	        	  	con = ConnectionFactory.getConnection();  
	                ps = con.prepareStatement("select * from user");  
	                //ps.setString(1, name);  
	                rs = ps.executeQuery();  
	                while (rs.next()) {  
	                	System.out.println("Name= "+rs.getString(2)+"\t"+"Password= "+rs.getString(3));       
	                }  
	          } 
	          catch (Exception e) { 
	        	  System.out.println(e);
	          }  
	          finally{  
	              if(rs!=null){  
	                  rs.close();  
	              }if (ps!=null){  
	                ps.close();  
	            }if(con!=null){  
	                con.close();  
	            }   
	          }  
	}  
  
	// to update the password for the given username  
	public int update(String name, String password) throws SQLException  {  
	        Connection c=null;  
	        PreparedStatement ps=null;  
	          
	        int Counter=0;  
	        try {  
	                c = ConnectionFactory.getConnection();  
	                ps = c.prepareStatement("update user set password=? where username='"+name+"' ");  
	                ps.setString(1,password);  
	                Counter = ps.executeUpdate();  
	        } catch (Exception e) {  
	        	e.printStackTrace(); 
	        } finally{         
	            if (ps!=null){  
	                ps.close();  
	            }
	            if(c!=null){  
	                c.close();  
	            }   
	         }  
	       return Counter;  
	    }  
	      
	//to delete the data from the database   
	   public int delete(String username) throws SQLException{  
	        Connection c = null;  
	        PreparedStatement ps = null;  
	        int Counter=0;  
	        try {  
	        	c = ConnectionFactory.getConnection();  
	            ps = c.prepareStatement("delete from user where username='"+username+"' ");  
	            Counter = ps.executeUpdate();  
	        } catch (Exception e) { 
	        	e.printStackTrace(); 
	        }finally{  
	        	if (ps!=null){  
	        		ps.close();  
	        	}
	        	if(c!=null){  
	               c.close();  
	        	}   
	        }	  
	       return Counter;  
	    }
	    */
	/*-------------------------------------commented codes------------------------------------------------*/
	
}

