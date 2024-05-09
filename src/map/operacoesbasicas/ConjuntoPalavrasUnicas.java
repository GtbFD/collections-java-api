package map.operacoesbasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {

    private Set<String> palavras;

    public ConjuntoPalavrasUnicas(){
        palavras = new HashSet<>();
    }

    public void adicionarPalavra(String palavra){
        palavras.add(palavra);
    }

    public void removerPalavra(String palavra){
        String palavraARemover = null;
        if (!palavras.isEmpty()){
            for (String palavraAtual : palavras){
                if (palavraAtual.equals(palavra)){
                    palavraARemover = palavra;
                    break;
                }
            }
        }
        palavras.remove(palavraARemover);
    }

    public boolean verificarPalavra(String palavra){
        if (!palavras.isEmpty()){
            for (String palavraAtual : palavras){
                if (palavraAtual.equals(palavra)){
                    return true;
                }
            }
        }
        return false;
    }

    public Set<String> exibirPalavrasUnicas(){
        return palavras;
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();

        conjuntoPalavrasUnicas.adicionarPalavra("Nome 1");
        conjuntoPalavrasUnicas.adicionarPalavra("Nome 1");
        conjuntoPalavrasUnicas.adicionarPalavra("Nome 2");
        conjuntoPalavrasUnicas.adicionarPalavra("Nome 3");

        System.out.println("Palavras = " + conjuntoPalavrasUnicas.exibirPalavrasUnicas());

        System.out.println("Tem a palavra, Nome 1 na lita? = " + conjuntoPalavrasUnicas.verificarPalavra("Nome 1"));

        conjuntoPalavrasUnicas.removerPalavra("Nome 1");

        System.out.println("Palavras = " + conjuntoPalavrasUnicas.exibirPalavrasUnicas());

    }
}
