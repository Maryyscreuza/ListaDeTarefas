package listadetarefas;

import java.util.ArrayList;

public class Usuario {
	
	// atributos
	
	private String email;
	private String nome;
	private ArrayList<Pessoal> listaPessoal;
	private ArrayList<Educação> listaEducação;
	private ArrayList<Trabalho> listaTrabalho;
	
	//construtor
	
	public Usuario (String email, String nome){
		this.email = email;
		this.nome = nome;
		this.listaPessoal = new ArrayList<>();
		this.listaEducação = new ArrayList<>();
		this.listaTrabalho = new ArrayList<>();
	}
	
	//metodos
	
	public void cadastrarPessoal(Pessoal listaPessoalC){
		listaPessoal.add(listaPessoalC);
	}
	
	public void excluirPessoal(Pessoal listaPessoalR) {
		listaPessoal.remove(listaPessoalR);
	}
	
	public void cadastrarEducação(Educação listaEducaçãoC){
		listaEducação.add(listaEducaçãoC);
	}
	
	public void excluirEducação(Educação listaEducaçãoR) {
		listaEducação.remove(listaEducaçãoR);
	}
	
	public void cadastrarTrabalho(Trabalho listaTrabalhoC){
		listaTrabalho.add(listaTrabalhoC);
	}
	
	public void excluirTrabalho(Trabalho listaTrabalhoR) {
		listaTrabalho.remove(listaTrabalhoR);
	}
	
	// gets e sets
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ArrayList<Pessoal> getPessoal() {
		return listaPessoal;
	}

	public void setPessoal(ArrayList<Pessoal>  listaPessoal) {
		this.listaPessoal =  listaPessoal;
	}
	
	public ArrayList<Educação> getEducação() {
		return listaEducação;
	}

	public void setEducação(ArrayList<Educação>  listaEducação) {
		this.listaEducação =  listaEducação;
	}
	
	public ArrayList<Trabalho> getTrabalho() {
		return listaTrabalho;
	}

	public void setTrabalho(ArrayList<Trabalho>  listaTrabalho) {
		this.listaTrabalho =  listaTrabalho;
	}
	
}
