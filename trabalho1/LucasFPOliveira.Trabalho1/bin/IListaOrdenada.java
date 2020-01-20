
public interface IListaOrdenada<T> {

	// Insere o item e na lista
	public boolean inserir(T e);
	
	// Remove o item e da lista 
	public T remover(T e);
	
	// Retorna o item na posi��o p da lista
	// O primeiro item da lista est� na posi��o ZERO
	public T getItem(int p);
	
	// Retorna a quantidade de itens na lista
	public int quantidade();
	
	// Verifica se a lista est� vazia
	public boolean estaVazia();
	
	// Remove todos os itens da lista
	public void removerTodos();
	
	
}
