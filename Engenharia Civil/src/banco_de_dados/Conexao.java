package banco_de_dados;

	import java.sql.Connection;
	import java.sql.DriverManager;

	public class Conexao {
		private String banco = "bd_construção";
		private int porta = 3306;
		private String usuario = "root";
		private String senha = "root";
		private String maquina = "localhost";
		private Connection conectar;
		
		public Conexao() {
			try {
				String url = "jdbc:mysql://"+maquina+":"+porta+"/"+banco;
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				conectar = DriverManager.getConnection(url, usuario, senha);
				System.out.println("Banco de Dados conectado com sucesso!");		
				
			}catch(Exception erro) {
				System.err.println("Falha ao conectar ao Banco Dados!");
				System.err.println(erro.getMessage());
			}
			
		}//fim do construtor
		
		public Connection getConexao() {
			return this.conectar;
		}//fim do getConexao()
		
		public void finalizarConexao() {
			try {
				conectar.close();
			}catch(Exception erro) {
				System.err.println("Falha ao encerrar a conexão!");
				System.err.println(erro.getMessage());
			}
		}//fim do finalizarConexao()
		

}
