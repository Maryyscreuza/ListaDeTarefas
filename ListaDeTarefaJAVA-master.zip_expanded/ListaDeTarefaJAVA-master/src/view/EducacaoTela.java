package view;

import controller.*;
import listadetarefas.Usuario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class EducacaoTela extends JFrame implements ActionListener{
	
	DefaultListModel model = new DefaultListModel();
	
	
	private JTextField Nome;
	private JTextField Campus;
	private JComboBox<String>  Tipo = new JComboBox<>() ;
	private JComboBox<String>  Participantes = new JComboBox<>() ;
	protected Usuario usuario;
	
	public EducacaoTela() {
	super("Educação");

	
	Font fonte = new Font("Serif", Font.PLAIN, 20);
	JLabel label = new JLabel("Educação");
	label.setFont(fonte);
	label.setForeground(Color.WHITE);
	label.setBounds(550, 0, 125, 40);
	
	Container c = getContentPane();
	c.setLayout(null);
	Font fonte2 = new Font("Serif", Font.PLAIN, 18);
	
	JLabel AdicionarNome = new JLabel("Adicionar Nome:");
	AdicionarNome.setForeground(Color.WHITE);
	AdicionarNome.setFont(fonte2);
	AdicionarNome.setBounds(200, 50, 220, 34);
	
	JTextField Nome = new JTextField("", 15);
	Nome.setBounds(200, 80, 347, 34);
	
	JLabel AdicionarCampus = new JLabel("Adicionar Campus:");
	AdicionarCampus.setForeground(Color.WHITE);
	AdicionarCampus.setFont(fonte2);
	AdicionarCampus.setBounds(650, 50, 220, 34);
	
	JTextField Campus = new JTextField("", 15);
	Campus.setBounds(650, 80, 347, 34);
	
	JLabel Tipo1 = new JLabel("Tipo:");
	Tipo1.setForeground(Color.WHITE);
	Tipo1.setFont(fonte2);
	Tipo1.setBounds(200, 120, 220, 34);	
	
	JLabel Participantes1 = new JLabel("Participantes:");
	Participantes1.setForeground(Color.WHITE);
	Participantes1.setFont(fonte2);
	Participantes1.setBounds(650, 120, 220, 34);	
	
	JComboBox<String> Tipo = new JComboBox();
	Tipo.setBounds(200, 150, 220, 34);
	Tipo.addItem("Prova");
	Tipo.addItem("Trabalho");
	
	JComboBox<String> Participantes = new JComboBox();
	Participantes.setBounds(650, 150, 220, 34);
	Participantes.addItem("Solo");
	Participantes.addItem("Grupo");
	
	c.add(label);
	c.add(AdicionarNome);
	c.add(Nome);
	c.add(AdicionarCampus);
	c.add(Campus);
	c.add(Participantes1);
	c.add(Participantes);
	c.add(Tipo1);
	c.add(Tipo);
	
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
					model.addElement(Nome.getText() + " - " + Campus.getText() + " - " + Tipo.getSelectedItem()
					+ " - " + Participantes.getSelectedItem()); 
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
	public void actionPerformed(ActionEvent e) {
		
	String nome = Nome.getText();
	String campus = Campus.getText();
	String tip = Tipo.getSelectedItem().toString(); 
	
	Boolean Tipo;
	
	if (tip == "prova") {
		Tipo = true;
	}else {
		Tipo = false;
	}
	
	Boolean Participantes;
	
	if (tip == "solo") {
		Participantes = true;
	}else {
		Participantes = false;
	}
	
	CadastroUsuarioController cadastroUsuarioController = new CadastroUsuarioController();
	cadastroUsuarioController.cadastrarEducação(nome, campus, Tipo, Participantes);
	
	this.setVisible(false);
	JOptionPane.showMessageDialog(null, "Lista cadastrada com sucesso!");
		
	}


	public static void main(String[] args) {
		new EducacaoTela();

}


}
