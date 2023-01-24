package listadetarefas;

public class Trabalho extends Lista {
	
	private String destinatario;
	private Boolean Tipo;
	
	public Trabalho(String nome, String destinatario2, Boolean Tipo) {
		this.nome = nome;
		this.destinatario = destinatario;
		this.Tipo = Tipo;	
	}

	//gets sets
	
	public String getDestinatario() {
		return destinatario;
	}
	
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	
}