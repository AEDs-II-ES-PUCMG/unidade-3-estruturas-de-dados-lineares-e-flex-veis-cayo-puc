public class No<K, V> {

	private K chave;       // chave identificadora do item armazenado no nodo da árvore.
	private V item;        // contém os dados do item armazenado no nodo da árvore.
	private No<K, V> direita;    // referência ao nodo armazenado, na árvore, à direita do nó em questão.
	private No<K, V> esquerda;   // referência ao nodo armazenado, na árvore, à esquerda do nó em questão.
	private int altura;

	public No(K chave, V item) {
		setChave(chave);
		setItem(item);
	    setDireita(null);
	    setEsquerda(null);
	    altura = 0;
	}

	public V getItem() {
		return item;
	}

	public void setItem(V item) {
		this.item = item;
	}

	public K getChave() {
		return chave;
	}

	public void setChave(K chave) {
		this.chave = chave;
	}

	public No<K, V> getDireita() {
		return direita;
	}

	public void setDireita(No<K, V> direita) {
		this.direita = direita;
	}

	public No<K, V> getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(No<K, V> esquerda) {
		this.esquerda = esquerda;
	}

	private int getAltura(No<K, V> no) {

		if (no != null)
			return no.getAltura();
		else
			return -1;
	}

	public int getAltura() {
		return this.altura;
	}

	/**
	 * Método responsável por recalcular e atualizar a altura deste nó,
	 * com base na altura de seus descendentes.
	 *
	 * A altura de um nó corresponde a 1 mais a maior altura entre suas sub-árvores
	 * esquerda e direita. Lembre-se de que a altura de uma sub-árvore vazia (nó nulo)
	 * é -1, e por isso o método auxiliar "getAltura(No<K, V> no)" já trata esse caso,
	 * retornando -1 quando o nó recebido por parâmetro é null.
	 *
	 * Esse método deve ser chamado sempre que a estrutura da árvore for alterada
	 * (inserções, remoções e rotações), para manter a altura armazenada em "altura"
	 * consistente com a nova organização dos nós.
	 */
	public void setAltura() {

		int alturaEsquerda, alturaDireita;

		alturaEsquerda = getAltura(esquerda);
		alturaDireita = getAltura(direita);

		// TODO: Implementar
		// Calcule a altura deste nó como sendo 1 mais a maior altura entre
		// "alturaEsquerda" e "alturaDireita", e atribua o resultado ao atributo "altura".
	}

	/**
	 * Método responsável por calcular o fator de balanceamento deste nó.
	 *
	 * O fator de balanceamento de um nó é a diferença entre a altura de sua
	 * sub-árvore esquerda e a altura de sua sub-árvore direita.
	 *
	 * Esse valor é utilizado pela árvore AVL para identificar se um nó está
	 * desbalanceado:
	 *  - fator de balanceamento igual a  2: o nó está desbalanceado à esquerda;
	 *  - fator de balanceamento igual a -2: o nó está desbalanceado à direita;
	 *  - fator de balanceamento entre -1 e 1: o nó está balanceado.
	 *
	 * @return a diferença entre a altura da sub-árvore esquerda e a altura da sub-árvore direita deste nó.
	 */
	public int getFatorBalanceamento() {

		int alturaEsquerda, alturaDireita;

		alturaEsquerda = getAltura(esquerda);
		alturaDireita = getAltura(direita);

		// TODO: Implementar
		// Retorne a diferença entre "alturaEsquerda" e "alturaDireita".
		throw new UnsupportedOperationException("TODO: Implementar o método getFatorBalanceamento");
	}
}
