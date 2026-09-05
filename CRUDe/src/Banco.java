import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Banco {
   
    public Connection connectio() {

          Connection connection = null;
         try{
         connection = DriverManager.getConnection("jbd:sqllite:bd_teste");
        } catch(SQLException e){
            System.err.print(e.getMessage());
        }
        return connection; 
    }

   public void insert( String nome, int largura, int altura, int profundidade, String descricao, String obs){
    Connection connection =   this.connectio();
    try{
         Statement statemant = connection.createStatement();
         statemant.setQueryTimeout(30);

         statemant.executeUpdate("INSERT INT produtos VALUES('nome','largura','altura','profundidade','obs','discricao') ");
        
        } catch(SQLException e ){

            System.err.print(e.getMessage());
        }

    }

   public void deleta(){


    
   }


}
