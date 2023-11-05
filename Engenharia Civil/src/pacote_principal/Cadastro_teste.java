package pacote_principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import banco_de_dados.Conexao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Cadastro_teste extends JFrame {

	private JPanel contentPane;
	private JTextField caixaNome;
	private JTextField caixaSolicitacao;
	private JTextField caixaInicio;
	private JButton btnCadastrar;
	private JLabel lblNewLabel_4;
	private JTextField caixaTermino;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_teste frame = new Cadastro_teste();
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
	public Cadastro_teste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastro");
		lblNewLabel.setBounds(176, 11, 80, 25);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("nome_projeto");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(37, 78, 80, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("data_solicitação");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(37, 114, 123, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("data_inicio");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(37, 139, 80, 14);
		contentPane.add(lblNewLabel_3);

		caixaNome = new JTextField();
		caixaNome.setBounds(123, 76, 86, 20);
		contentPane.add(caixaNome);
		caixaNome.setColumns(10);

		caixaSolicitacao = new JTextField();
		caixaSolicitacao.setBounds(170, 112, 86, 20);
		contentPane.add(caixaSolicitacao);
		caixaSolicitacao.setColumns(10);

		caixaInicio = new JTextField();
		caixaInicio.setBounds(101, 137, 86, 20);
		contentPane.add(caixaInicio);
		caixaInicio.setColumns(10);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome_projeto, data_solicitação, data_inicio, data_termino;

				nome_projeto = caixaNome.getText();
				data_solicitação = caixaSolicitacao.getText();
				data_inicio = caixaInicio.getText();
				data_termino = caixaInicio.getText();

				// Passo 1 = Comando SQL
				String sql = "insert into  tb_projetos ( nome_projeto, data_solicitação, data_inicio,data_termino) values" + "(?, ?, ?, ? )";

				Conexao novaConexao = new Conexao();
				Connection conectar = novaConexao.getConexao();
				PreparedStatement preparar = null;
				ResultSet resultados = null;

				try {
					preparar = conectar.prepareStatement(sql);
					// Substituir as interrogações

					preparar.setString(1, nome_projeto);
					preparar.setString(2, data_solicitação);
					preparar.setString(3, data_inicio);
					preparar.setString(4, data_termino);
					preparar.execute();
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "Falha ao cadastrar");
					System.out.println(erro.getMessage());

					dispose();
					try {
						Cadastro_teste t1 = new Cadastro_teste();
						t1.setVisible(true);
						t1.setLocationRelativeTo(null);
					} catch (Exception e1) {

					}
				}
				
				
			}
		});
		btnCadastrar.setBounds(62, 201, 89, 23);
		contentPane.add(btnCadastrar);
		
		lblNewLabel_4 = new JLabel("data_termino");
		lblNewLabel_4.setBounds(30, 165, 86, 14);
		contentPane.add(lblNewLabel_4);
		
		caixaTermino = new JTextField();
		caixaTermino.setBounds(111, 164, 86, 20);
		contentPane.add(caixaTermino);
		caixaTermino.setColumns(10);


	}

}
