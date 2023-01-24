package listadetarefas;

public class Educação extends Lista {
	
	private String campus;
	private Boolean Tipo;
	private Boolean Participantes;
	
	public Educação(String nome, String campus, Boolean Tipo, Boolean Participantes){
		this.nome = nome;
		this.campus = campus;
		this.Tipo = Tipo;
		this.Participantes = Participantes;
	
	}

	//gets sets
	
	public String getCampus() {
		return campus;
	}
	
	public void setCampus(String campus) {
		this.campus = campus;
	}

}
