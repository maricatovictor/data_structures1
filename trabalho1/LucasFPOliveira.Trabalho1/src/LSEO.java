
public class LSEO<T extends Comparable<T>> implements IListaOrdenada<T> {

	private No head;  // referência para o primeiro nó
	private int qtdItens; // número de nós da lista

	private class No{
		public T item;  // Item armazenado no nó
		public No prox;  // referência para o próximo no

		public No(T item) {
			this.item = item;
			this.prox = null;
		}
	}


	@Override
	public boolean inserir(T e) {
		No no, ant, aux;
		//T item;
		try {
			no = new No(e);
		}
		catch(OutOfMemoryError ex) {
			return false;
		}

		if(qtdItens == 0) {
			head = no;
		}

		else {
			aux = head;

			// Percorre a lista (Só ocorre quando qtdItens é maior ou igual a 2)
			while(aux.prox != null) {
				aux = aux.prox;
				ant = head;
				if(no.item.compareTo(ant.item) < 0) {
					no.prox = ant;
					head = no;
				}
				else if(no.item.compareTo(aux.item) < 0) {		
					no.prox = aux;
					ant.prox = no;		
				}
				else {
					aux.prox = no;
					
					// NÃO ESTOU CONSEGUINDO PERCORRER CORRETAMENTE.
					// ESSE WHILE PERMITE A SITUAÇÃO: 1 -> 2 -> 6 , E SE EU
					// QUISER INSERIR O 8, FICARÁ 1 -> 2 -> 8 -> 6
					
					// O PROBLEMA: as variaveis de armazenamento dos nós da lista
					// devem ir caminhando conforme o vetor cresce, e não, ficar 
					// voltando para o head, por exemplo.
					
					// Ainda não sei resolver o problema!
				}
			}	

			// COMO EVITAR DO CÓDIGO SAIR DO WHILE E NÃO ENTRAR NO IF ABAIXO ???
			
			// qtdItens = 1
			if(aux.prox == null) {
				if(aux.item.compareTo(no.item) < 0) {
					aux.prox = no;
				}
				else if(aux.item.compareTo(no.item) > 0) {
					no.prox = aux;
					head = no;
				}
			}
		}

		qtdItens++;
		return true;	
	}


	@Override
	public T remover(T e) {

	}


	@Override
	public T getItem(int p) {
		//Verifica se a posição p é válida
		if(p < 0 || p > qtdItens-1) {
			return null;
		}

		return localizarNo(p).item;
	}


	@Override
	public int quantidade() {
		return qtdItens;
	}


	@Override
	public boolean estaVazia() {
		return head == null;
	}


	@Override
	public void removerTodos() {
		No aux;

		while(head != null) {
			aux = head;
			head = head.prox;
			aux.item  = null;
			aux.prox = null;
		}

		qtdItens = 0;
	}


	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();

		buffer.append("[");

		if (head != null) {
			No aux = head;

			while (aux.prox != null) {
				buffer.append(aux.item);
				buffer.append(", ");
				aux = aux.prox;
			}

			buffer.append(aux.item);
		}

		buffer.append("]");

		return buffer.toString();
	}


	private No localizarNo(int p) {
		No aux = head;

		while (p > 0) {
			aux = aux.prox;
			p--;
		}

		return aux;
	}

}
