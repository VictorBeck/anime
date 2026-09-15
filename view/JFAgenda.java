// package view;

// import java.awt.EventQueue;
// import javax.swing.JFrame;
// import javax.swing.JPanel;
// import javax.swing.border.EmptyBorder;
// import javax.swing.JLabel;
// import javax.swing.JOptionPane;
// import javax.swing.SwingConstants;
// import javax.swing.Timer;
// import javax.swing.border.LineBorder;
// import java.awt.Color;
// import java.awt.Dimension;
// import java.awt.Font;
// import java.awt.Toolkit;
// import javax.swing.border.MatteBorder;
// import javax.swing.border.TitledBorder;
// import controller.AgendaDados;
// import model.Agenda;
// import javax.swing.JTextField;
// import javax.swing.JComboBox;
// import javax.swing.JFileChooser;
// import javax.imageio.ImageIO;
// import javax.swing.ImageIcon;
// import javax.swing.JButton;
// import java.awt.event.ActionListener;
// import java.awt.image.BufferedImage;
// import java.io.ByteArrayInputStream;
// import java.io.File;
// import java.io.InputStream;
// import java.time.LocalDate;
// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;
// import java.time.format.TextStyle;
// import java.util.Locale;
// import java.awt.event.ActionEvent;

// public class JFAgenda extends JFrame {

	
// 	private static final long serialVersionUID = 1L;
	
	
	
// 	private JPanel contentPane;
// 	private JTextField tfNome;
// 	private JTextField tfEndereco;
// 	private JTextField tfCidade;
// 	private JComboBox cbEstado;
// 	private JTextField tfCelular;
// 	private JTextField tfIdade;
// 	private JLabel lblFoto;
// 	private JTextField tfId;
// 	private JButton btnNovo;
// 	private JButton btnSalvar;
// 	private JButton btnLimpar;
// 	private JButton btnImagem;
// 	private JButton btnEditar;
// 	private JButton btnExcluir;
// 	private JButton btnPesquisar;
// 	private JButton btnSair;
// 	private JButton btnProximo;
// 	private JButton btnAnterior;
// 	private JButton btnPesquisarNome;
// 	private JLabel lblData;
	
// 	private Agenda objAgenda;
// 	private AgendaDados DAO;
// 	int acao = 1;
	
// 	int numero = 0;
// 	int lastId = 0;
	
// 	int id = 0;
// 	int totalRegistros = 23;
	
// 	String diaSemana = "";
// 	String mes = "";
	
// 	public static void main(String[] args) {
// 		EventQueue.invokeLater(new Runnable() {
// 			public void run() {
// 				try {
// 					JFAgenda frame = new JFAgenda();
// 					Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
// 					frame.setLocation((tela.width - frame.getSize().width) / 2,
// 							(tela.height - frame.getSize().height) / 2);
// 					frame.setVisible(true);
// 				} catch (Exception e) {
// 					e.printStackTrace();
// 				}
// 			}
// 		});
// 	}

	
	
// 	public JFAgenda() {
		
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// 		DAO = new AgendaDados(); // TEM QUE INSTANCIAR O OBJETO AQUI, SE NAO FICA NULL QUANDO FOR SALVAR
// 		dia();
// 		iniciarRelogio();
		
// 		setResizable(false);
// 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 		setBounds(580, 0, 900, 707);
// 		contentPane = new JPanel();
// 		contentPane.setBackground(new Color(255, 255, 255));
// 		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

// 		setContentPane(contentPane);
// 		contentPane.setLayout(null);
		
// 		JLabel lblTitulo = new JLabel("Agenda Eletronica");
// 		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 36));
// 		lblTitulo.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
// 		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
// 		lblTitulo.setBounds(122, 11, 331, 79);
// 		lblTitulo.setOpaque(true); // DEIXA O LABEL OPACO ANTES DE COLOCAR A COR
// 		//	lblTitulo.setBackground(Color.gray);
// 		Color cor = new Color(135,206,255);
// 		lblTitulo.setBackground(cor);
// 		//	lblTitulo.setForeground(cor); // cor da fonte
// 		contentPane.add(lblTitulo);
		
// 		JLabel lblNewLabel_1 = new JLabel("New label");
// 		lblNewLabel_1.setBounds(934, 18, 153, 258);
// 		contentPane.add(lblNewLabel_1);
		
// 		JPanel panel = new JPanel();
// 		panel.setBackground(new Color(255, 255, 255));
// 		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 128)));
// 		panel.setBounds(586, 108, 287, 380);
// 		contentPane.add(panel);
// 		panel.setLayout(null);
		
// 		lblFoto = new JLabel("");
// 		lblFoto.setBounds(10, 11, 267, 350);
// 		panel.add(lblFoto);
		
// 		JPanel panel_1 = new JPanel();
// 		panel_1.setBackground(new Color(255, 255, 255));
// 		panel_1.setLayout(null);
// 		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 128), 2, true), "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 140, 0)));
// 		panel_1.setBounds(10, 101, 568, 387);
// 		contentPane.add(panel_1);
		
// 		JLabel lblNewLabel_3 = new JLabel("Nome:");
// 		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
// 		lblNewLabel_3.setBounds(15, 26, 61, 26);
// 		panel_1.add(lblNewLabel_3);
		
// 		tfNome = new JTextField();
// 		tfNome.setHorizontalAlignment(SwingConstants.LEFT);
// 		tfNome.setFont(new Font("Tahoma", Font.PLAIN, 22));
// 		tfNome.setBounds(10, 51, 548, 45);
// 		panel_1.add(tfNome);
// 		tfNome.setColumns(10);
		
// 		JLabel lblNewLabel_3_1 = new JLabel("Endereço");
// 		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
// 		lblNewLabel_3_1.setBounds(15, 103, 75, 26);
// 		panel_1.add(lblNewLabel_3_1);
		
// 		tfEndereco = new JTextField();
// 		tfEndereco.setFont(new Font("Dialog", Font.PLAIN, 22));
// 		tfEndereco.setColumns(10);
// 		tfEndereco.setBounds(10, 131, 548, 45);
// 		panel_1.add(tfEndereco);
		
// 		tfCidade = new JTextField();
// 		tfCidade.setFont(new Font("Dialog", Font.PLAIN, 22));
// 		tfCidade.setColumns(10);
// 		tfCidade.setBounds(10, 221, 451, 45);
// 		panel_1.add(tfCidade);
		
// 		JLabel lblNewLabel_3_1_1 = new JLabel("Cidade:");
// 		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
// 		lblNewLabel_3_1_1.setBounds(15, 184, 75, 26);
// 		panel_1.add(lblNewLabel_3_1_1);
		
// 		JLabel lblNewLabel_3_1_1_1 = new JLabel("Estado:");
// 		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
// 		lblNewLabel_3_1_1_1.setBounds(491, 187, 67, 26);
// 		panel_1.add(lblNewLabel_3_1_1_1);
		
// 		cbEstado = new JComboBox();
// 		cbEstado.setEditable(true);
// 		cbEstado.setBackground(new Color(255, 255, 255));
// 		cbEstado.setFont(new Font("Dialog", Font.PLAIN, 22));
// 		cbEstado.addItem("SP");
// 		cbEstado.addItem("PE");
// 		cbEstado.addItem("BA");
// 		cbEstado.addItem("AL");
// 		cbEstado.addItem("MG");
// 		cbEstado.addItem("RN");
// 		cbEstado.setSelectedItem(""); 
// 		cbEstado.setBounds(477, 221, 81, 45);
// 		panel_1.add(cbEstado);
		
// 		JLabel lblNewLabel_3_1_2 = new JLabel("Celular:");
// 		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
// 		lblNewLabel_3_1_2.setBounds(15, 277, 75, 17);
// 		panel_1.add(lblNewLabel_3_1_2);
		
// 		JLabel lblNewLabel_3_1_2_1 = new JLabel("Idade:");
// 		lblNewLabel_3_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
// 		lblNewLabel_3_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
// 		lblNewLabel_3_1_2_1.setBounds(402, 277, 156, 26);
// 		panel_1.add(lblNewLabel_3_1_2_1);
		
// 		tfCelular = new JTextField();
// 		tfCelular.setFont(new Font("Dialog", Font.PLAIN, 22));
// 		tfCelular.setColumns(10);
// 		tfCelular.setBounds(10, 302, 370, 45);
// 		panel_1.add(tfCelular);
		
// 		tfIdade = new JTextField();
// 		tfIdade.setFont(new Font("Dialog", Font.PLAIN, 22));
// 		tfIdade.setHorizontalAlignment(SwingConstants.CENTER);
// 		tfIdade.setColumns(10);
// 		tfIdade.setBounds(402, 302, 156, 45);
// 		panel_1.add(tfIdade);
		
		
// 		JPanel panel_2 = new JPanel();
// 		panel_2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 128)));
// 		panel_2.setBackground(Color.WHITE);
// 		panel_2.setBounds(10, 491, 863, 159);
// 		contentPane.add(panel_2);
// 		panel_2.setLayout(null);
		
// 		btnNovo = new JButton("Novo");
// 		btnNovo.addActionListener(new ActionListener() {
// 			public void actionPerformed(ActionEvent e) {
// 				limparCampos();
// 			//	habilitar();
// 				btnSalvar.setEnabled(true);
// 				btnImagem.setEnabled(true);
				
// 				tfNome.requestFocus();
// 				acao = 1;
// 			}
// 		});
// 		btnNovo.setFont(new Font("Times New Roman", Font.PLAIN, 26));
// 		btnNovo.setBounds(43, 24, 121, 49);
// 		panel_2.add(btnNovo);
		
// 		btnSalvar = new JButton("Salvar");
// 		btnSalvar.addActionListener(new ActionListener() {
// 			public void actionPerformed(ActionEvent e) {
// 				btnLimpar.setEnabled(true);
// 				tfId.setEnabled(true);
				

// 				try {
// 				//	desabilitar();
// 					// getIcon() pega o ícone associado ao label e converte p/String caminho de onde vem a imagem
// 					// não pega o caminho no disco
// 					String caminho = lblFoto.getIcon().toString(); 
// 					if (validarCampos()) { // verifica se os campos estao preenchidos
// 						if (acao == 1) {
// 							if (preencherObjeto()) { // verifica se o objeto esta preenchido
// 								if (DAO.salvar(objAgenda, caminho)) { // se o objAgenda estiver preenchido e o método incluir retornar true, o registro foi salvo 
// 									JOptionPane.showMessageDialog(contentPane, "Salvo com sucesso!"); 
// 								}
// 							} else {
// 								JOptionPane.showMessageDialog(null, "Registro não foi salvo");
// 							} // fim validarCampos
// 						}
	
						
// 						if (acao == 2) { 
// 							if (preencherObjetoEditar()) { // verifica se o objeto esta preenchido
// 								if (DAO.editar(objAgenda, caminho)) { // se o obj DAO, usando o metodo editar e o objeto
// 																	// objAgenda, estiver preenchido, retornar true
// 									JOptionPane.showMessageDialog(contentPane, "Editado com sucesso"); 
// 									limparCampos(); //
// 								}
// 							} else {
// 								JOptionPane.showMessageDialog(null, "Não foi possível editar o registro");
// 							}
// 						}
							
// 						limparCampos();
// 					}
// 				} catch (Exception erro) {
// 					JOptionPane.showMessageDialog(null, "ERROOOO: " + erro.getMessage());
// 				} 
// 			} // fim do método
// 		});
// 		btnSalvar.setFont(new Font("Times New Roman", Font.PLAIN, 26));
// 		btnSalvar.setBounds(207, 24, 121, 49);
// 		panel_2.add(btnSalvar);
		
// 		btnLimpar = new JButton("Limpar");
// 		btnLimpar.addActionListener(new ActionListener() {
// 			public void actionPerformed(ActionEvent e) {
// 				limparCampos();
// 			}
// 		});
// 		btnLimpar.setFont(new Font("Times New Roman", Font.PLAIN, 26));
// 		btnLimpar.setBounds(371, 24, 121, 49);
// 		panel_2.add(btnLimpar);
		
// 		btnImagem = new JButton("<html>Selecionar<p>Imagem<html>");
// 		btnImagem.addActionListener(new ActionListener() {
			
// 			public void actionPerformed(ActionEvent e) {
// 				try {
// 					JFileChooser file = new JFileChooser(); // abre a tela de pesquisa do arquivo
// 					file.setCurrentDirectory(new File("C:/Users/matheus.souza840/rodolfo/agenda_eletronica_2c/imagens")); // indica o diretorio a ser aberto
// 					file.setDialogTitle("Escolha a imagem:"); // exibe uma msg na parte superior da janela
// 					file.showOpenDialog(contentPane); // metodo showOpenDialog: abre arquivos salvos no computador. openSave: salvar
// 					// metodo getSelectFile(): recupera um arquivo selecionado pelo JFileChooser 
// 					lblFoto.setIcon(new ImageIcon(file.getSelectedFile().getPath())); // pega a img, converte para
// 																						// ImageIcon e coloca no label
// 				} catch (Exception err) {
// 					JOptionPane.showMessageDialog(null, "Nao foi possivel carregar a imagem " + err);
// 				}
				
// 			}
// 		});
// 		btnImagem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
// 		btnImagem.setBounds(535, 24, 121, 49);
// 		panel_2.add(btnImagem);
		
// 		btnEditar = new JButton("Editar");
// 		btnEditar.addActionListener(new ActionListener() {
// 			public void actionPerformed(ActionEvent e) {
// 			//	habilitar();
// 				btnSalvar.setEnabled(true);
// 				btnImagem.setEnabled(true);
// 				acao = 2;
// 			}
// 		});
// 		btnEditar.setFont(new Font("Times New Roman", Font.PLAIN, 26));
// 		btnEditar.setBounds(43, 85, 121, 49);
// 		panel_2.add(btnEditar);
		
// 		btnExcluir = new JButton("Excluir");
// 		btnExcluir.addActionListener(new ActionListener() {
// 			public void actionPerformed(ActionEvent e) {
// 				try { 
// 					if (tfId.getText().equals("")) { 
// 						JOptionPane.showMessageDialog(null, "Preencha o campo ID");
// 					} else {
// 						int resposta = JOptionPane.showConfirmDialog(contentPane, "Deseja excluir o registro?", "Excluir", JOptionPane.YES_NO_OPTION);
// 						if (resposta != 0) {
// 							JOptionPane.showMessageDialog(null, "Exclusão Cancelada");
// 						} else if (DAO.excluir(Integer.parseInt(tfId.getText()))) {
// 							JOptionPane.showMessageDialog(null, "Registro excluido com sucesso");
// 							limparCampos();
// 						} else {
// 							JOptionPane.showMessageDialog(null, "Nao foi possível excluir o registro");
// 						}
// 					} 
// 				} catch (Exception erro) {
// 					JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
// 				}
				
				
				
// 			} 
// 		});
// 		btnExcluir.setFont(new Font("Times New Roman", Font.PLAIN, 26));
// 		btnExcluir.setBounds(207, 85, 121, 49);
// 		panel_2.add(btnExcluir);
		
// 		btnPesquisar = new JButton("<html><center>Pesquisar <br>Id</center><html>");
		
		
// 		btnPesquisar.addActionListener(new ActionListener() {
// 			public void actionPerformed(ActionEvent e) {
// 				btnProximo.setEnabled(true);
// 				btnAnterior.setEnabled(true);
// 				btnEditar.setEnabled(true);
// 				btnExcluir.setEnabled(true);
// 				try {
// 					if (tfId.getText().equals("")) {
// 						JOptionPane.showMessageDialog(null, "Preenha o campo Id");
// 						tfId.requestFocus();
// 					} else {
// 						objAgenda = DAO.pesquisar(Integer.parseInt(tfId.getText())); // pega o conteudo da cx para pesquisa
// 					}
// 					if (objAgenda == null) {
// 						JOptionPane.showMessageDialog(null, "Não foi possível encontrar o registro número " + numero);
// 						limparCampos();
// 						btnProximo.setEnabled(false);
// 						tfId.requestFocus();
// 					} else {
// 						InputStream input = new ByteArrayInputStream(objAgenda.getFoto()); // InputStream leitura de arq,
// 																						// entrada
// 						// ImageIO eh uma classe utilizada para carregar uma img
// 						BufferedImage imagem = ImageIO.read(input); // BufferedImage classe para manipulacao de imagens,
// 																	// carrega uma img da memo
// 						// carrega a img e converte para o tipo BufferedImage que eh o tipo que o Java entende
						
// 						lblFoto.setIcon(new ImageIcon(imagem.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), java.awt.Image.SCALE_SMOOTH)));
// 						tfNome.setText(objAgenda.getNome());
// 						tfEndereco.setText(objAgenda.getEndereco());
// 						tfCidade.setText(objAgenda.getCidade());
// 						cbEstado.setSelectedItem(objAgenda.getEstado());
// 						tfCelular.setText(objAgenda.getCelular());
// 						tfIdade.setText(String.valueOf(objAgenda.getIdade()));
// 					}

// 				} catch (Exception erro) {
// 					JOptionPane.showMessageDialog(null, "Erro " + erro.getMessage());
// 					limparCampos();
// 				}	
				
// 			} // fim
			
			
// 		});
		
		
// 		btnPesquisar.setFont(new Font("Times New Roman", Font.PLAIN, 22));
// 		btnPesquisar.setBounds(535, 85, 121, 49);
// 		panel_2.add(btnPesquisar);
		
// 		btnSair = new JButton("Sair");
// 		btnSair.addActionListener(new ActionListener() {
// 			public void actionPerformed(ActionEvent e) {
// 				int resposta = JOptionPane.showConfirmDialog(contentPane, "Deseja Encerrar o Programa?", "SAIR", JOptionPane.YES_NO_OPTION);
// 				if(resposta == 0) {
// 					System.exit(0);
// 				}
				
// 			}
// 		});
// 		btnSair.setFont(new Font("Times New Roman", Font.PLAIN, 30));
// 		btnSair.setBounds(685, 24, 135, 109);
// 		panel_2.add(btnSair);
		
// 		btnPesquisarNome = new JButton("<html>Pesquisar <br>Nome<html>");
// 		btnPesquisarNome.setFont(new Font("Times New Roman", Font.PLAIN, 20));
// 		btnPesquisarNome.addActionListener(new ActionListener() {
// 			public void actionPerformed(ActionEvent e) {
// 				try {
// 					if (tfNome.getText().equals("")) {
// 						JOptionPane.showMessageDialog(null, "Preenha o campo Nome");
// 						tfNome.requestFocus();
// 					} else {
// 						objAgenda = DAO.pesquisarNome(tfNome.getText()); // pega o conteudo da cx para pesquisa
// 					}
// 					if (objAgenda == null) {
// 						JOptionPane.showMessageDialog(null, "Não foi possível encontrar o registro nome");
// 						limparCampos();
// 						btnProximo.setEnabled(false);
// 						tfId.requestFocus();
// 					} else {
// 						InputStream input = new ByteArrayInputStream(objAgenda.getFoto()); // InputStream leitura de arq,
// 																						// entrada
// 						// ImageIO eh uma classe utilizada para carregar uma img
// 						BufferedImage imagem = ImageIO.read(input); // BufferedImage classe para manipulacao de imagens,
// 																	// carrega uma img da memo
// 						// carrega a img e converte para o tipo BufferedImage que eh o tipo que o Java entende
						
// 						lblFoto.setIcon(new ImageIcon(imagem.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), java.awt.Image.SCALE_SMOOTH)));
// 						tfNome.setText(objAgenda.getNome());
// 						tfEndereco.setText(objAgenda.getEndereco());
// 						tfCidade.setText(objAgenda.getCidade());
// 						cbEstado.setSelectedItem(objAgenda.getEstado());
// 						tfCelular.setText(objAgenda.getCelular());
// 						tfIdade.setText(String.valueOf(objAgenda.getIdade()));
// 						tfId.setText(String.valueOf(objAgenda.getId()));
						
// 						btnAnterior.setEnabled(true);
// 						btnProximo.setEnabled(false);
// 					}

// 				} catch (Exception erro) {
// 					JOptionPane.showMessageDialog(null, "Erro " + erro.getMessage());
// 					limparCampos();
// 				}					
				
// 			} // final do método
// 		});
// 		btnPesquisarNome.setBounds(371, 85, 121, 49);
// 		panel_2.add(btnPesquisarNome);
		
// 		tfId = new JTextField();
// 		tfId.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
// 		tfId.setFont(new Font("Tahoma", Font.PLAIN, 28));
// 		tfId.setHorizontalAlignment(SwingConstants.CENTER);
// 		tfId.setBounds(10, 11, 110, 79);
// 		tfId.setBackground(cor); // Definir a cor do textField
// 		contentPane.add(tfId);
// 		tfId.setColumns(10);
		
// 		btnProximo = new JButton("Próximo");
// 		btnProximo.setFont(new Font("Tahoma", Font.PLAIN, 18));
// 		btnProximo.setBounds(756, 11, 103, 78);
// 		contentPane.add(btnProximo);
		
// 		btnAnterior = new JButton("Anterior");
// 		btnAnterior.addActionListener(new ActionListener() {
// 			public void actionPerformed(ActionEvent e) {
// 			//	int lastId = 0;
// 				try {
// 					lastId = DAO.getLastRecordId();
// 				} catch (Exception e1) {
// 					e1.printStackTrace();
// 				}
				
// 				if(tfId.getText().equalsIgnoreCase("")){
// 					JOptionPane.showMessageDialog(null, "Preenha o campo Id");
// 					tfId.requestFocus();
// 				} else if(numero > 1 && numero <= lastId) { 
// 					numero = Integer.parseInt(tfId.getText());
// 					numero--;
// 					tfId.setText(String.valueOf(numero));
// 					btnPesquisar.doClick();
// 				} else {
// 					JOptionPane.showMessageDialog(contentPane, "Primeiro Registro Encontrado");
// 				}
// 			} // final do método
// 		});
// 		btnAnterior.setFont(new Font("Tahoma", Font.PLAIN, 18));
// 		btnAnterior.setBounds(643, 11, 103, 79);
// 		contentPane.add(btnAnterior);
		
// 		lblData = new JLabel("");
// 		lblData.setBorder(new LineBorder(new Color(0, 0, 128), 2));
// 		lblData.setHorizontalAlignment(SwingConstants.CENTER);
// 		lblData.setFont(new Font("Tahoma", Font.PLAIN, 18));
// 		lblData.setBounds(456, 11, 183, 79);
// 		lblData.setOpaque(true);
// 		lblData.setBackground(cor); // Definir a cor do label
// 		contentPane.add(lblData);
		
// 		btnProximo.addActionListener(new ActionListener() {
// 			public void actionPerformed(ActionEvent e) {

// 				try {
// 					exibir(1);
// 				} catch (Exception e1) {
// 					e1.printStackTrace();
// 				}
				
				
				
// 			}
// 		});
		
		
// 	}
	
	
// 	public boolean preencherObjeto() { // metodo que verifica se o objeto esta preenchido
// 		objAgenda = new Agenda();

// 		objAgenda.setNome(tfNome.getText()); 
// 		objAgenda.setEndereco(tfEndereco.getText());
// 		objAgenda.setCidade(tfCidade.getText());
// 		objAgenda.setEstado(cbEstado.getSelectedItem().toString());
// 		objAgenda.setCelular(tfCelular.getText());
// 		objAgenda.setIdade(Integer.parseInt(tfIdade.getText()));

// 		return true;
// 	}
	
// 	public boolean preencherObjetoEditar() {
// 		objAgenda = new Agenda();

// 		byte[] img = objAgenda.getFoto();

// 		objAgenda.setFoto(img);
// 		objAgenda.setId(Integer.parseInt(tfId.getText())); // get e set modifica o que esta antes do ponto
// 		objAgenda.setNome(tfNome.getText()); // pegar o conteudo da cx texto e coloca no metodo setNome
// 		objAgenda.setEndereco(tfEndereco.getText()); // preenche o objAgenda
// 		objAgenda.setCidade(tfCidade.getText()); 
// 		objAgenda.setEstado(cbEstado.getSelectedItem().toString());
// 		objAgenda.setCelular(tfCelular.getText());
// 		objAgenda.setIdade(Integer.parseInt(tfIdade.getText())); 

// 		// esta enviando como parametro ao objeto as informacoes 
// 		return true;
// 	}
	

// 	public void exibir(int acao) throws Exception {
// 	    numero = Integer.parseInt(tfId.getText());
// 	    try {
// 	        objAgenda = DAO.navegar(numero, acao);

// 	        InputStream input = new ByteArrayInputStream(objAgenda.getFoto()); // InputStream leitura de arq, entrada

// 	        // ImageIO eh uma classe utilizada para me carregar uma img
// 	        BufferedImage imagem = ImageIO.read(input); // BufferedImage classe para manipulacao de imagens, carrega uma img da memo

// 	        // carrega a img e converte para o tipo BufferedImage que eh o tipo que o Java entende
// 	        lblFoto.setIcon(new ImageIcon(imagem.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), java.awt.Image.SCALE_DEFAULT)));
// 	        tfNome.setText(objAgenda.getNome());
// 	        tfEndereco.setText(objAgenda.getEndereco());
// 	        tfCidade.setText(objAgenda.getCidade());
// 	        cbEstado.setSelectedItem(objAgenda.getEstado());
// 	        tfCelular.setText(objAgenda.getCelular());
// 	        tfIdade.setText(String.valueOf(objAgenda.getIdade()));
// 	        tfId.setText(String.valueOf(objAgenda.getId()));
// 	        //System.out.println("ID: " + objAgenda.getId() + "Nome: " + objAgenda.getNome());
// 	    } catch (Exception erro) {
// 	        JOptionPane.showMessageDialog(contentPane, "Final dos Registros!");
// 	        limparCampos();
// 	    }
// 	}
		
// 	public boolean validarCampos() {
// 		if (tfNome.getText().equals("")) {
// 			JOptionPane.showMessageDialog(null, "Preencha o campo Nome");
// 			tfNome.requestFocus();
// 			return false;
// 		}

// 		if (tfEndereco.getText().equals("")) {
// 			JOptionPane.showMessageDialog(null, "Preencha o campo Endereço");
// 			tfEndereco.requestFocus();
// 			return false;
// 		}

// 		if (tfCidade.getText().equals("")) {
// 			JOptionPane.showMessageDialog(null, "Preencha o campo Cidade");
// 			tfCidade.requestFocus();
// 			return false;
// 		}

// 		if (tfCelular.getText().equals("")) {
// 			JOptionPane.showMessageDialog(null, "Preencha o campo Celular");
// 			tfCelular.requestFocus();
// 			return false;
// 		}
		
// 		if(tfIdade.getText().equals("")) {
// 			JOptionPane.showMessageDialog(null, "Preencha o campo Idade");
// 			tfIdade.requestFocus();
// 			return false;
// 		}
		
// 		if(cbEstado.getSelectedItem().toString().equalsIgnoreCase("")) {
// 			JOptionPane.showMessageDialog(null, "Selecione o Estado");
// 			cbEstado.requestFocus();
// 			return false;
// 		}
		
// 		return true;
// 	}

// 	public void limparCampos() {
// 		tfId.setText(null);
// 		tfNome.setText(null);
// 		tfEndereco.setText(null);
// 		tfCelular.setText(null);
// 		tfCidade.setText(null);
// 		tfIdade.setText(null);
// 		cbEstado.setSelectedItem("");
// 		lblFoto.setIcon(null);
// 		tfId.requestFocus();
// 	}



// 	public void iniciarRelogio() {
// 		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy - HH:mm:ss"); // hh=12h  HH=24h  Usar MM maiusculos
// 	//	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/mm/yy");
// 		Timer timer = new Timer(1000, e -> {
// 		lblData.setText("<html><center>" + diaSemana + "<br><html>" + LocalDateTime.now().format(formato));
// 		});
		
// 		timer.start();
// 	}
	
	
	
	
// 	public void dia() {
// 		// Obtem a data atual do sistema
//         LocalDate hoje = LocalDate.now();

//         // Define o idioma para português do Brasil
//         //  Locale brasil = new Locale("pt", "BR"); DEPRECIADO
//         Locale brasil = Locale.of("pt", "BR");
      
//         // Pega o dia da semana por extenso
//         diaSemana = hoje.getDayOfWeek().getDisplayName(TextStyle.FULL, brasil);
        
//         // Pega o mês por extenso
//         mes = hoje.getMonth().getDisplayName(TextStyle.FULL, brasil);
//     }
// }