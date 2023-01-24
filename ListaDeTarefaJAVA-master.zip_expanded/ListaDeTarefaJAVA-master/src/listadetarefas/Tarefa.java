package listadetarefas;

public abstract class Tarefa {
	
	private String titulo;
	private boolean status;


	public Tarefa(String titulo, boolean status){
		this.titulo = titulo;
		this.status = status;

	}

	//gets sets

	public String getTitulo() {
		return titulo;

	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;

	}

	public boolean getStatus(){
		return status;

	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	

}
