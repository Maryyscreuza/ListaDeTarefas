package listadetarefas;

import java.util.ArrayList;

public abstract class Lista {

		// atributos
	
		protected String nome;
		protected ArrayList<Tarefa> tarefas;

		
		//gets sets

		public String getNome() {
			return nome;

		}

		public void setNome(String nome) {
			this.nome = nome;

		}

		public ArrayList <Tarefa> getTarefas() {
			return tarefas;

		}

		public void setTarefa (ArrayList <Tarefa> tarefas) {
			this.tarefas = tarefas;

		}
		

}

