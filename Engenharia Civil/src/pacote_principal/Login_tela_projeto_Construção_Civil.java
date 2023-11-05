package pacote_principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import banco_de_dados.Conexao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SpringLayout;

public class Login_tela_projeto_Construção_Civil extends JFrame {

	private JPanel contentPane;
	private JTextField caixaUsuario;
	private JTextField caixaSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_tela_projeto_Construção_Civil frame = new Login_tela_projeto_Construção_Civil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login_tela_projeto_Construção_Civil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(528, 451, 105, 23);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
			}
		});
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Clique abaixo!");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(535, 426, 105, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Não se cadastrou?");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(528, 401, 121, 14);
		contentPane.add(lblNewLabel_2);
		contentPane.add(btnCadastrar);
		
		JLabel labelLogin = new JLabel("Login");
		labelLogin.setBounds(439, 31, 354, 95);
		labelLogin.setIcon(new ImageIcon("C:\\Users\\aluno.areias\\Downloads\\pacote_imagens\\usuarios.png"));
		labelLogin.setFont(new Font("Tahoma", Font.PLAIN, 22));
		labelLogin.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(labelLogin);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(481, 175, 55, 33);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel);
		
		caixaUsuario = new JTextField();
		caixaUsuario.setBounds(528, 182, 187, 20);
		contentPane.add(caixaUsuario);
		caixaUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setBounds(481, 239, 46, 33);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(535, 360, 100, 30);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario, senha;
				
				usuario = caixaUsuario.getText();
				senha = caixaSenha.getText();
				
				//Passo 1 = Comando SQL 
				String sql = "insert into tb_construção (usuario, senha) values"
				+ "(?, ?)";
				
				//Passo 2 - Preparar conexão
				Conexao novaConexao = new Conexao();
				Connection conectar = novaConexao.getConexao();
				PreparedStatement preparar = null;
				ResultSet resultados = null;
				
				//Passo 3 - Tentar executar o SQL
				try {
					preparar = conectar.prepareStatement(sql);
					//Substituir as interrogações
					preparar.setString(1, usuario);
					preparar.setString(2, senha);
					
					
					JOptionPane.showMessageDialog(null, "Bem-Vindo(a)!");
					
					
				}catch(Exception erro) {
					JOptionPane.showMessageDialog(null, "Usuario ou senha incorreto");
					System.out.println(erro.getMessage());
				}
				
				dispose();
				try {
				Login_tela_projeto_Construção_Civil t1= new Login_tela_projeto_Construção_Civil();
					t1.setVisible(true);
					t1.setLocationRelativeTo(null);
				} catch (Exception e1) {
				
				
			}
		}});
		contentPane.add(btnEntrar);
		
		
		
		caixaSenha = new JTextField();
		caixaSenha.setBounds(528, 246, 187, 20);
		contentPane.add(caixaSenha);
		caixaSenha.setColumns(10);
		
		JLabel labelHM = new JLabel("");
		labelHM.setBounds(15, 70, 432, 326);
		labelHM.setIcon(new ImageIcon(Login_tela_projeto_Construção_Civil.class.getResource("/pacote_imagens/home_office.png")));
		contentPane.add(labelHM);
		
		JLabel labelImagem = new JLabel("");
		labelImagem.setBounds(0, 0, 845, 541);
		labelImagem.setHorizontalAlignment(SwingConstants.CENTER);
		labelImagem.setIcon(new ImageIcon("C:\\Users\\aluno.areias\\Downloads\\construcao_civil.jpg"));
		contentPane.add(labelImagem);
		
		
	}
}
