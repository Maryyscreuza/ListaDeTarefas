package view;

import controller.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class TrabalhoTela extends JFrame implements ActionListener {
	
	DefaultListModel model = new DefaultListModel();
	
	private JTextField Nome;
	private JTextField Destinatario;
	JComboBox<String> Tipo = new JComboBox<>();
	
	public TrabalhoTela() {
		super("Trabalho");

		Font fonte = new Font("Serif", Font.PLAIN, 20);
		JLabel label = new JLabel("Trabalho");
		label.setFont(fonte);
		label.setForeground(Color.WHITE);
		label.setBounds(550, 0, 125, 40);
		
		Container c = getContentPane();
		c.setLayout(null);
		Font fonte2 = new Font("Serif", Font.PLAIN, 18);
		
		JLabel AdicionarNome = new JLabel("Adicionar Nome:");
		AdicionarNome.setForeground(Color.WHITE);
		AdicionarNome.setFont(fonte2);
		AdicionarNome.setBounds(250, 50, 220, 34);
		
		JTextField Nome = new JTextField("", 15);
		Nome.setBounds(250, 80, 270, 34);
		
		JLabel AdicionarDestinatario = new JLabel("Adicionar Destinatário:");
		AdicionarDestinatario.setForeground(Color.WHITE);
		AdicionarDestinatario.setFont(fonte2);
		AdicionarDestinatario.setBounds(650, 50, 220, 34);
		
		JTextField Destinatario = new JTextField("", 15);
		Destinatario.setBounds(650, 80, 270, 34);
		
		JLabel Tipo1 = new JLabel("Tipo:");
		Tipo1.setForeground(Color.WHITE);
		Tipo1.setFont(fonte2);
		Tipo1.setBounds(480, 120, 220, 34);
		
		JComboBox<String> Tipo = new JComboBox();
		Tipo.setBounds(480, 150, 220, 34);
		Tipo.addItem("A Distância");
		Tipo.addItem("Presencial");
		
		c.add(label);
		c.add(AdicionarNome);
		c.add(Nome);
		c.add(AdicionarDestinatario);
		c.add(Destinatario);
		c.add(Tipo1);
		c.add(Tipo);
		
		String[] Listas = {};
		JList lista = new JList<>(Listas);
		lista.setBounds(50,250,750,300);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		c.add(lista);
		
		JButton botao = new JButton("ADICIONAR");
		botao.setLocation(50,50);
		botao.setBounds(520, 200, 150, 23);
		botao.setBackground(new Color(128, 128, 255));
		botao.setForeground(new Color(255, 255, 255));
		botao.addActionListener(
		(ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.addElement(Nome.getText() + " - " + Destinatario.getText() + " - " + Tipo.getSelectedItem()); 
				lista.setModel(model);
			}
		}
	);
		
		JButton botaoAbrir = new JButton("ABRIR");
		botaoAbrir.setBounds(900, 250, 150, 40);
		botaoAbrir.setBackground(new Color(128, 128, 255));
		botaoAbrir.setForeground(new Color(255, 255, 255));
		botaoAbrir.addActionListener(
				(ActionListener) new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new TarefaPessoalTela();
						dispose();
					}
				}
			);
		
		JButton botaoEditar = new JButton("EDITAR");
		botaoEditar.setBounds(900, 335, 150, 40);
		botaoEditar.setBackground(new Color(128, 128, 255));
		botaoEditar.setForeground(new Color(255, 255, 255));
		botaoEditar.addActionListener(
				(ActionListener) new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						model.clear(); 
						lista.setModel(model);
					
					}
				}
			);
		
		
		JButton botaoExcluir = new JButton("EXCLUIR");
		botaoExcluir.setBounds(900, 420, 150, 40);
		botaoExcluir.setBackground(new Color(128, 128, 255));
		botaoExcluir.setForeground(new Color(255, 255, 255));
		botaoExcluir.addActionListener(
				(ActionListener) new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						model.remove(lista.getSelectedIndex());
						lista.setModel(model);
						
					}
				}
			);
		JButton botaoVoltar = new JButton("VOLTAR");
		botaoVoltar.setBounds(900, 505, 150, 40);
		botaoVoltar.setBackground(new Color(128, 128, 255));
		botaoVoltar.setForeground(new Color(255, 255, 255));
		botaoVoltar.addActionListener(
				(ActionListener) new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new TelaOpcao();
						dispose();
					}
				}
			);
		
		c.add(botao);
		c.add(botaoAbrir);
		c.add(botaoEditar);
		c.add(botaoExcluir);
		c.add(botaoVoltar);
		
		c.setBackground(new Color(0, 0, 121));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200,700);
		setVisible(true);
		setResizable(false);
		
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String nome = Nome.getText();
		String destinatario = Destinatario.getText();
		
	String tip = Tipo.getSelectedItem().toString(); 
		
		Boolean Tipo;
		
		if (tip == "A Distancia") {
			Tipo = true;
		}else {
			Tipo = false;
		}
		
		CadastroUsuarioController cadastroUsuarioController = new CadastroUsuarioController();
		cadastroUsuarioController.cadastrarTrabalho(nome, destinatario, Tipo);
		
		this.setVisible(false);
		JOptionPane.showMessageDialog(null, "Lista cadastrada com sucesso!");
			
	}



	public static void main(String[] args) {
		new TrabalhoTela();
	}


}
