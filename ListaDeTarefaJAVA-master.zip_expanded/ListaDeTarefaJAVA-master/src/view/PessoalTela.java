package view;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import controller.CadastroUsuarioController;
import listadetarefas.Usuario;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PessoalTela extends JFrame implements ActionListener {
	
	DefaultListModel model = new DefaultListModel();
	
	
	private JTextField Nome;
	private JTextField Local;
	private JComboBox<String>  Tipo = new JComboBox<>() ;
	protected Usuario usuario;
	
	public PessoalTela() {
		super("Pessoal");
		

		Font fonte = new Font("Serif", Font.PLAIN, 20);
		JLabel label = new JLabel("Pessoal");
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
		
		JLabel AdicionarLocal = new JLabel("Adicionar Local:");
		AdicionarLocal.setForeground(Color.WHITE);
		AdicionarLocal.setFont(fonte2);
		AdicionarLocal.setBounds(650, 50, 220, 34);
		
		JTextField Local = new JTextField("", 15);
		Local.setBounds(650, 80, 270, 34);
		
		JLabel Tipo1 = new JLabel("Tipo:");
		Tipo1.setForeground(Color.WHITE);
		Tipo1.setFont(fonte2);
		Tipo1.setBounds(480, 120, 220, 34);
		
		JComboBox<String> Tipo = new JComboBox();
		Tipo.setBounds(480, 150, 220, 34);
		Tipo.addItem("Saúde");
		Tipo.addItem("Estetica");
		Tipo.addItem("Gerais");
		
		c.add(label);
		c.add(AdicionarNome);
		c.add(Nome);
		c.add(AdicionarLocal);
		c.add(Local);
		c.add(Tipo);
		c.add(Tipo1);
		
		String[] Listas = {};
		JList lista = new JList<>(Listas);
		lista.setBounds(50,250,750,300);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		c.add(lista);
		
		JButton botaoAdicionar = new JButton("ADICIONAR");
		botaoAdicionar.setBounds(520, 200, 150, 23);
		botaoAdicionar.setBackground(new Color(128, 128, 255));
		botaoAdicionar.setForeground(new Color(255, 255, 255));
		botaoAdicionar.addActionListener(
				(ActionListener) new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						model.addElement(Nome.getText() + " - " + Local.getText() + " - " + Tipo.getSelectedItem()); 
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

		c.add(botaoAdicionar);
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
		String local = Local.getText();
		
		String tip = Tipo.getSelectedItem().toString(); 
		
		Boolean Tipo;
		
		if (tip == "saude") {
			Tipo = true;
		}else {
			Tipo = false;
		}
		
		CadastroUsuarioController cadastroUsuarioController = new CadastroUsuarioController();
		cadastroUsuarioController.cadastrarPessoal(nome, local, Tipo);
		
		this.setVisible(false);
		JOptionPane.showMessageDialog(null, "Lista cadastrada com sucesso!");
			
	}

	public static void main(String[] args) {
		new PessoalTela();
	}

}