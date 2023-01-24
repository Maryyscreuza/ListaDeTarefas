package controller;

import listadetarefas.Usuario;

import javax.swing.JComboBox;

import listadetarefas.Educação;
import listadetarefas.Pessoal;
import listadetarefas.Tarefa;
import listadetarefas.Trabalho;

import view.TelaOpcao;
import view.PessoalTela;
import view.EducacaoTela;
import view.TrabalhoTela;

public class CadastroUsuarioController {

	public static Usuario usuario;
	public static Tarefa tarefas;
	public int i;
	public Pessoal pessoal;
	
	public void cadastrarUsuario(String email, String nome) {
		
		usuario = new Usuario(email, nome);
		System.out.println(usuario.getNome() + " - " + usuario.getEmail());
		new TelaOpcao();
	}
	
public void cadastrarPessoal(String nome, String local, Boolean Tipo) {
		
		Pessoal pessoal = new Pessoal (nome, local, Tipo);
		usuario.cadastrarPessoal(pessoal);
		new PessoalTela();
		
	}
	
public void cadastrarEducação (String nome, String campus, Boolean Tipo, Boolean Participantes) {
		
		Educação educacao = new Educação (nome, campus, Tipo, Participantes);
		usuario.cadastrarEducação(educacao);
		new EducacaoTela();
		
	}

public void cadastrarTrabalho(String nome, String destinatario, Boolean Tipo) {
		Trabalho trabalho = new Trabalho (nome, destinatario, Tipo);
		usuario.cadastrarTrabalho(trabalho);
		new TrabalhoTela();
	
}

	
}