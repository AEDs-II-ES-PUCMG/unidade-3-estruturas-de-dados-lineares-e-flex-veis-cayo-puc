import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Random;
import java.time.Duration;

public class BuscaAleatoria<T> implements IBuscador<T> {

    private long comparacoes;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private T[] dados;
    private Comparator<T> comparador;

    public BuscaAleatoria(T[] dados, Comparator<T> comparador){
        this.dados = dados;
        this.comparador = comparador;
    }
    
    @Override
    public long getComparacoes() {
        return comparacoes;
    }

    @Override
    public double getTempo() {
        if(inicio==null)
            throw new IllegalStateException("Não foi feita nenhuma busca.");
        
        return Duration.between(inicio, fim).toNanos();
    }

    @Override
    public T buscar(T dado) {
        comparacoes = 0;
        boolean[] visitados = new boolean[dados.length];
        int tentativas = 0;
        Random random = new Random();
        inicio = LocalDateTime.now();
        while(tentativas < dados.length){
            int posicao = random.nextInt(dados.length);
            if(!visitados[posicao]){
                visitados[posicao] = true;
                comparacoes++;
                tentativas++;
                if (comparador.compare(dados[posicao], dado) == 0) {
                    fim = LocalDateTime.now();
                    return dados[posicao];
                }
            }
        }
        fim = LocalDateTime.now();
        return null;
    }

}
