import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Fila<E> {

	private Celula<E> frente;
	private Celula<E> tras;
	
	Fila() {
		Celula<E> sentinela = new Celula<E>();
		frente = tras = sentinela;
	}
	
	public boolean vazia() {
		
		return (frente == tras);
	}
	
	public void enfileirar(E item) {
		
		Celula<E> novaCelula = new Celula<E>(item);
		
		tras.setProximo(novaCelula);
		tras = tras.getProximo();
	}
	
	public E desenfileirar() {
		
		E item = null;
		Celula<E> primeiro;
		
		item = consultarPrimeiro();
		
		primeiro = frente.getProximo();
		frente.setProximo(primeiro.getProximo());
		
		primeiro.setProximo(null);
			
		// Caso o item desenfileirado seja também o último da fila.
		if (primeiro == tras)
			tras = frente;
		
		return item;
	}
	
	public E consultarPrimeiro() {

		if (vazia()) {
			throw new NoSuchElementException("Nao há nenhum item na fila!");
		}

		return frente.getProximo().getItem();

	}
	
	public void imprimir() {
		
		Celula<E> aux;
		
		if (vazia())
			System.out.println("A fila está vazia!");
		else {
			aux = this.frente.getProximo();
			while (aux != null) {
				System.out.println(aux.getItem());
				aux = aux.getProximo();
			}
		} 	
	}
	
    /*implemente na classe da sua Fila um método genérico (ou específico para o teste) capaz de iterar sobre
    os elementos e contar quantas ocorrências de um determinado caractere existem na lista atual.  */
    public int numeroDeOcorrencias(E item){
        int cont=0;
        Celula<E> temp = frente;
        if (vazia()) {
			throw new NoSuchElementException("Nao há nenhum item na lista!");
		}
        while(temp != tras){
			if(temp.getItem().equals(item)){
				cont++;
			}
            temp = temp.getProximo(); 
        }
        if(temp.getItem().equals(item)){//conta o ultimo elemento se for igual
			cont++;
		} 
        return cont;
    }

    /*Implemente, na classe Fila do código-base fornecido, o método Fila<E> extrairLote(int numItens). Esse
    método deve desenfileirar os primeiros K elementos (definidos por numItens) da fila atual, respeitando a ordem de
    chegada, e retornar esses elementos estruturados em uma nova Fila flexível. Caso a fila original possua menos de K
    itens, o método deve extrair apenas os itens disponíveis, esvaziando a fila de origem */
    public Fila<E> extrairLote(int numItens){
        if (numItens < 0) {
			throw new IllegalArgumentException("O número de itens não pode ser negativo.");
		}
        if (vazia()) {
			throw new NoSuchElementException("Nao há nenhum item na lista!");
		}
		Fila<E> filinha = new Fila<>();
        for(int i = 0; i < numItens; i ++){
            if(vazia()){
                return filinha;
            }
            E item = this.desenfileirar();
            filinha.enfileirar(item);
        }
        return filinha;
    }
}