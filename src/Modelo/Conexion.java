package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    
    Conexion(){
        
    }
    public static Connection con = null;

    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        
        if(con == null){
            
            try{
                
                String conexionUrl = "jdbc:sqlserver://localhost:1433;"
                + "database=Pokemon;" 
                + "user=sa;"
                + "password=1234;"
                + "loginTimeout=30;";
                
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection(conexionUrl);
                System.out.println("Entro al if");
                
            }catch(ClassNotFoundException | SQLException e){
                System.out.println(e);
            }
        }

        return con;
        
    }
    
    public static void CloseConnection() throws Exception{
        try{
            
            if(con != null){
                con.close();
            }
            
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }

}