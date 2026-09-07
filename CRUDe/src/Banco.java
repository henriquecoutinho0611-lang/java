import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Banco {

    public Connection connectio() {

          Connection connection = null;
         try{
         connection = DriverManager.getConnection("jdbc:sqlite:bd_teste");
        } catch(SQLException e){
            System.err.print(e.getMessage());
        }
        return connection; 
    }



  public void insert(String nome, int largura, int altura, int profundidade,
                   String descricao, String obs) {

    Connection connection = this.connectio();

    try {

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);

        statement.executeUpdate("""
            CREATE TABLE IF NOT EXISTS produtos (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nome TEXT NOT NULL,
                largura INTEGER NOT NULL,
                altura INTEGER NOT NULL,
                profundidade INTEGER NOT NULL,
                descricao TEXT,
                obs TEXT
            )
        """);

        String sql = """
            INSERT INTO produtos
            (nome, largura, altura, profundidade, descricao, obs)
            VALUES (?, ?, ?, ?, ?, ?)
        """;

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, nome);
        preparedStatement.setInt(2, largura);
        preparedStatement.setInt(3, altura);
        preparedStatement.setInt(4, profundidade);
        preparedStatement.setString(5, descricao);
        preparedStatement.setString(6, obs);

        preparedStatement.executeUpdate();

    } catch (SQLException e) {

        System.err.println(e.getMessage());
    }
}

 public void lista(){

      Connection connection = this.connectio();

      try{

          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);

          ResultSet resultado = statement.executeQuery("SELECT * FROM produtos");

          while (resultado.next()){
              System.out.println("------------------------------------------------");
              System.out.println("id:"+ resultado.getInt("id"));
              System.out.println("Nome:"+ resultado.getString("nome"));
              System.out.println("altura:"+ resultado.getInt("altura"));
              System.out.println("largura:"+ resultado.getInt("largura"));
              System.out.println("Profundidade:"+ resultado.getInt("profundidade"));
              System.out.println("obs:"+ resultado.getInt("obs"));
              System.out.println("descricao:"+ resultado.getInt("descricao"));
               System.out.println("------------------------------------------------");
          }




          } catch (SQLException e) {
          throw new RuntimeException(e);
      }

  }

}



