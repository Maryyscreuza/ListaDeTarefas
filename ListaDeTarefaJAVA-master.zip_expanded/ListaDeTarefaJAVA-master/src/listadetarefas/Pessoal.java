package listadetarefas;

public class Pessoal extends Lista {
	
	private String local;
	private Boolean tipo;

	public Pessoal(String nome, String local, Boolean tipo){
		this.nome = nome;
		this.local = local;
		this.tipo = tipo;
	}

	//gets sets

	public String getLocal() {
		return local;
	}
	
	public void setLocal(String local) {
		this.local = local;
	}

}