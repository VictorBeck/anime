// 	package controller;
	
// 	import java.io.File;
// 	import java.io.FileInputStream;
// 	import java.io.InputStream;
// 	import java.sql.ResultSet;
	
// 	import com.mysql.jdbc.PreparedStatement;

// import connection.Conexao;

// // import com.mysql.jdbc.PreparedStatement;
// 	//import java.sql.PreparedStatement;
// 	import java.io.File;
// 	import java.io.FileInputStream;
// 	import java.io.InputStream;
// 	//import java.sql.PreparedStatement;
// 	//import java.sql.ResultSet;
// 	import model.Agenda;
// 	import view.JFAgenda;
	
	
// 	public class AgendaDados {
	
// 		 static Conexao con; 
// 		 JFAgenda agenda; 
// 		 InputStream fis; // InputStream: classe para ler entrada de dados 
	
		 
// 		 /*PreparedStatement(Declaracao Preparada): um interface que padroniza as consultas SQL, ex:
// 			 * SELECT * FROM alunos WHERE nome = ?, onde o que muda eh sempre o dado
// 			 * A linha de consulta, neste caso, esta guardada na String SQL
// 			 * O SQL fica mais rapido: otimiza os dados e envia os dados em binario ao inves de texto
// 			 * Não eh preciso se preocupar com a formatacao dos dados. Se usar: aspas, caracteres especiais, quebras de linha etc...
// 			 * na pesquisa, pode gerar erro, O PreparedStatement impede estes erros.
// 			 * PreparedStatemet permite colocar os valores no lugar do ponto de ?
// 			 */ 
// 		public boolean salvar(Agenda objAgenda, String caminho) throws Exception{  
// 			con = new Conexao();
// 			InputStream fis = null;
// 			fis = new FileInputStream(caminho); // FileInputStream: leitor de arquivos, eh obrigatorio passar o nome, caminho do arquivo no construtor
// 			// fis salva a imagem (bytes)
			
// 			String SQL = "INSERT INTO contatos1(foto, nome, endereco, cidade, estado, celular, idade) VALUES(?, ?, ?, ?, ?, ?, ?)";
	
// 			// objeto PrepStat  recebe o objeto conexao que chama o metodo getConexao que utiliza o PrespStat com a String SQL contendo os comandos
// 			// 									     faz a conexão com o BD - Prepara o comando SQL a ser executado
// 			PreparedStatement ps = (PreparedStatement) this.con.getConexao().prepareStatement(SQL);
			
// 			/* usando o obj ps para enviar dados ao BD. Tem que ser na ordem
// 			/ setBinaryStream: é utilizado quando queremos enviar para o banco um fluxo de dados binários.
// 			  Util para arquivos como: imagens, PDFs, documentos, arquivos em geral. */ 
			
// 			ps.setBinaryStream(1, fis);  //  coloca o conteúdo em binário enviado por fis na 1 ? da instrução sql
// 			ps.setString(2, objAgenda.getNome()); // coloca o nome na segunda ? da instrução sql
// 			ps.setString(3, objAgenda.getEndereco());
// 			ps.setString(4, objAgenda.getCidade());
// 			ps.setString(5, objAgenda.getEstado());
// 			ps.setString(6, objAgenda.getCelular());
// 			ps.setDouble(7, objAgenda.getIdade());
			
			
// 			// executeUpdate(): retorna a quantidade de linhas afetadas no BD
// 			if(ps.executeUpdate() > 0){
// 				return true;
// 			}else{
// 				return false;
// 			}
// 		}
		
		
// 		public boolean editar(Agenda objAgenda, String caminho)throws Exception {
// 			con = new Conexao();
// 			InputStream fis = null;
// 			fis = new FileInputStream(caminho);
// 			String SQL = "UPDATE contatos1 SET foto = ?, nome = ?, endereco = ?, cidade = ?, estado = ?, celular = ?, idade = ? WHERE contatos1.id = ?";
// 			PreparedStatement ps = (PreparedStatement) this.con.getConexao().prepareStatement(SQL);
			
// 			ps.setBinaryStream(1, fis);
// 			ps.setString(2, objAgenda.getNome()); 
// 			ps.setString(3, objAgenda.getEndereco());
// 			ps.setString(4, objAgenda.getCidade());
// 			ps.setString(5, objAgenda.getEstado());
// 			ps.setString(6, objAgenda.getCelular());
// 			ps.setInt(7, objAgenda.getIdade());
// 			ps.setInt(8, objAgenda.getId());
			
// 			if(ps.executeUpdate() > 0){  
// 				//ps.close(); // fecha o BD
// 				//con.conexao.close(); // desconectar
// 				return true;
// 			}else {
// 				//ps.close();
// 				//con.conexao.close();
// 				return false;
// 			}
// 		}
		
		
// 		public Agenda pesquisar(int ID) throws Exception {  // metodo vai retornar um objeto de dvd e recebe como parametro um int que eh o id
// 			con = new Conexao();
// 			Agenda objAgenda = null; 
// 			String SQL = "SELECT * FROM contatos1 WHERE id = ?";
			               
			
			
// 			try{
// 			 		PreparedStatement ps = (PreparedStatement) con.getConexao().prepareStatement(SQL);
// 					ps.setInt(1, ID);
// 					// executeQuery é usado com select
// 					ResultSet rs = ps.executeQuery(); // faz a pesquisa, pega as informações e guarda no objeto rs
// 					//ResultSet (Conjunto de resultados): eh uma interface utilizada para guardar dados vindos de um banco de dados.
// 					// Basicamente, ela guarda o resultado de uma pesquisa numa estrutura de dados que pode ser percorrida, de forma que
// 					// voce possa ler os dados do banco. Eh preciso usar em conjunto com PreparedStatement e Connection
// 					// executeQuery(): faz a pesquisa e captura as informacoes
					
					
// 					while(rs.next()){ // enquanto achar um registro, percorre o ResultSet
// 						objAgenda = new Agenda();  // objAgenda = retorno
// 						objAgenda.setFoto(rs.getBytes("foto")); // passa as informacoes capturadas pelo rs e coloca no objeto. Var nome = ao bd em minuscula
// 						objAgenda.setNome(rs.getString("nome"));
// 						objAgenda.setEndereco(rs.getString("endereco"));
// 						objAgenda.setCidade(rs.getString("cidade"));
// 						objAgenda.setEstado(rs.getString("estado"));
// 						objAgenda.setCelular(rs.getString("celular"));
// 						objAgenda.setIdade(rs.getInt("idade"));
// 					}
// 			}catch(Exception e){
// 				e.printStackTrace();
// 				objAgenda = null;
// 			}
// 			return objAgenda; // retorna o objeto preenchido caso encontre. se nao encontrar retorna nulo
			
// 	}
	
			
// 		public boolean excluir(int ID) throws Exception{
// 			con = new Conexao();
// 			String SQL = "delete from contatos1 where id = ?";
			
// 			PreparedStatement ps = (PreparedStatement) con.getConexao().prepareStatement(SQL);
// 			ps.setInt(1, ID);
			
// 			if(ps.executeUpdate() > 0){
// 				return true;
// 			}else{
// 				return false;
// 			}
// 		}
		
// 	//	public Agenda navegar(int ID, int acao) throws Exception {
// 	//
// 	//	    String SQL = "";
// 	//	    Agenda objAgenda = null;
// 	//
// 	//	    if (acao == 1) {
// 	//	        SQL = "SELECT * FROM contatos1 WHERE id > ? ORDER BY id LIMIT 1";
// 	//	    } else if (acao == 2) {
// 	//	        SQL = "SELECT * FROM contatos1 WHERE id < ? ORDER BY id DESC LIMIT 1";
// 	//	    }
// 	//
// 	//	    try {
// 	//
// 	//	        PreparedStatement ps = (PreparedStatement) con.getConexao().prepareStatement(SQL);
// 	//	        ps.setInt(1, ID);
// 	//	        ResultSet rs = ps.executeQuery();
// 	//
// 	//	        if (rs.next()) {
// 	//	            objAgenda = new Agenda();
// 	//	            objAgenda.setFoto(rs.getBytes("foto"));
// 	//	            objAgenda.setNome(rs.getString("nome"));
// 	//	            objAgenda.setEndereco(rs.getString("endereco"));
// 	//	            objAgenda.setCidade(rs.getString("cidade"));
// 	//	            objAgenda.setEstado(rs.getString("estado"));
// 	//	            objAgenda.setCelular(rs.getString("celular"));
// 	//	            objAgenda.setIdade(rs.getInt("idade"));
// 	//	            objAgenda.setId(rs.getInt("Id"));
// 	//	        }
// 	//	    } catch (Exception e) {
// 	//	        e.printStackTrace();
// 	//	    }
// 	//
// 	//	    return objAgenda; }
// 	//	
// 	//	
		
// 		public Agenda navegar(int ID, int acao) throws Exception{
// 		    String SQL = "";
// 		    Agenda objAgenda = null;
	
// 		    if(acao == 1) {
// 		        SQL = "SELECT * FROM contatos1 WHERE id > ? ORDER BY id LIMIT 1";
// 		    } else if(acao == 2) {
// 		        SQL = "SELECT * FROM contatos1 WHERE id < ? ORDER BY id DESC LIMIT 1";
// 		    }
	
// 		    try (Connection con = Conexao.getConnection();
// 		         PreparedStatement ps = con.prepareStatement(SQL)){
// 		        ps.setInt(1, ID);
// 		        ResultSet rs = ps.executeQuery(); // faz a pesquisa, pega as informações e guarda no objeto rs
	
// 		        if(rs.next()) {
// 		            objAgenda = new Agenda(); // objAgenda = retorno
// 		            objAgenda.setFoto(rs.getBytes("foto")); // passa as informacoes capturadas pelo rs e coloca no objeto. Var nome = ao bd
// 		            objAgenda.setNome(rs.getString("nome"));
// 		            objAgenda.setEndereco(rs.getString("endereco"));
// 		            objAgenda.setCidade(rs.getString("cidade"));
// 		            objAgenda.setEstado(rs.getString("estado"));
// 		            objAgenda.setCelular(rs.getString("celular"));
// 		            objAgenda.setIdade(rs.getInt("idade"));
// 		            objAgenda.setId(rs.getInt("Id"));
// 		        }
// 		    }
// 		}
		
		
		
		
		
		
		
		
		
		
		
// 		 public int getLastRecordId() throws Exception {
// 			int lastId = -1;
// 			con = new Conexao();
// 			// As lastId = dá um nome ao resultado, ele será chamado de lastId
// 			String sql = "SELECT MAX(id) AS lastId FROM contatos1"; // verifica o maior valor no campo Id
// 			PreparedStatement ps = (PreparedStatement) con.getConexao().prepareStatement(sql);
// 	        ResultSet rs = ps.executeQuery();  // executa o Select e armazena o resultado em rs
// 			try {
// 				// rs = ps.executeQuery(sql); // executa o Select e armazena o resultado em rs
	
// 	            if (rs.next()) { // se existir um prox. registro, move o rs para ele
// 	                lastId = rs.getInt("lastId"); // pega o ultimo registro e armazena na var
// 	            }
	
// 	        } catch (Exception e) {
// 	            e.printStackTrace();
// 	        } 
	
// 	        return lastId; // Retorna o último ID encontrado
// 		 } 
		 
		 
		 
// 		 public Agenda pesquisarNome(String nome) throws Exception {  // metodo vai retornar um objeto de dvd e recebe como parametro um int que eh o id
// 				con = new Conexao();
// 				Agenda objAgenda = null; 
// 			//	String SQL = "SELECT * FROM contatos1 WHERE nome = ?";
// 				String SQL = "SELECT * FROM contatos1 WHERE nome LIKE ?"; 
				               
				
				
// 				try{
// 				 		PreparedStatement ps = (PreparedStatement) con.getConexao().prepareStatement(SQL);
// 				 		ps.setString(1,nome + "%");
// 						// executeQuery é usado com select
// 						ResultSet rs = ps.executeQuery(); // faz a pesquisa, pega as informações e guarda no objeto rs
// 						//ResultSet (Conjunto de resultados): eh uma interface utilizada para guardar dados vindos de um banco de dados.
// 						// Basicamente, ela guarda o resultado de uma pesquisa numa estrutura de dados que pode ser percorrida, de forma que
// 						// voce possa ler os dados do banco. Eh preciso usar em conjunto com PreparedStatement e Connection
// 						// executeQuery(): faz a pesquisa e captura as informacoes
						
						
// 						while(rs.next()){ // enquanto achar um registro, percorre o ResultSet
// 							objAgenda = new Agenda();  // objAgenda = retorno
// 							objAgenda.setFoto(rs.getBytes("foto")); // passa as informacoes capturadas pelo rs e coloca no objeto. Var nome = ao bd em minuscula
// 							objAgenda.setNome(rs.getString("nome"));
// 							objAgenda.setEndereco(rs.getString("endereco"));
// 							objAgenda.setCidade(rs.getString("cidade"));
// 							objAgenda.setEstado(rs.getString("estado"));
// 							objAgenda.setCelular(rs.getString("celular"));
// 							objAgenda.setIdade(rs.getInt("idade"));
// 							objAgenda.setId(rs.getInt("Id"));
// 						}
// 				}catch(Exception e){
// 					e.printStackTrace();
// 					objAgenda = null;
// 				}
// 				return objAgenda; // retorna o objeto preenchido caso encontre. se nao encontrar retorna nulo
				
// 		}
		 
		 
		 
		 
		 
		 
		 
		 
		
		
		
// 	}
