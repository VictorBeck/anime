// package connection;

// import com.zaxxer.hikari.HikariConfig;
// import com.zaxxer.hikari.HikariDataSource;
// import java.sql.Connection;
// import java.sql.SQLException;

// public class Conexao {

// 	private static final HikariDataSource dataSource;
	
// 		static {
		
// 			HikariConfig config = new HikariConfig();
			
// 			// informa o servidor, a porta e o BD
// 	        config.setJdbcUrl("jdbc:mysql://localhost:3306/agenda");
// 	        config.setUsername("root");
// 	        config.setPassword("");
// 	        config.setMaximumPoolSize(10); // max de conexoes
// 	        config.setMinimumIdle(2); // min de conexoes ociosas			
	        
// 	     // instanciacao do obj que administra o pool
// 	        dataSource = new HikariDataSource(config);
// 	        }
		
// 		// ao instanciar um objeto de conexao (con) a classe Conexao e carregada automaticamente
// 	    // Connection: representa uma conexao com BD
		
		
// 		public static Connection getConnection() throws SQLException {
// 			return dataSource.getConnection();
// 		}
		
// 		public satic void fecharPool() {
// 			if (dataSource != null && !dataSource.isClosed()) {
// 				dataSource.close();
// 			}
// 		}
// }

package connection;
public class Conexao {
    public static void main(String[] args) {
     import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;
        hikariCP hikariCP = new hikariCP();
    }
}