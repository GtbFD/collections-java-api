package map.pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {

    private Map<String, Integer> palavras;

    public ContagemPalavras(){
        palavras = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem){
        palavras.put(palavra, contagem);
    }

    public void removerPalavra(String palavra){
        if (!palavras.isEmpty()){
            palavras.remove(palavra);
        }else{
            throw new RuntimeException("Lista vazia!");
        }
    }

    public int exibirContagemPalavras(){
        int contagem = 0;
        if (!palavras.isEmpty()){
            for (Integer quantidade : palavras.values()){
                contagem += quantidade;
            }
            return contagem;
        }else{
            throw new RuntimeException("Lista vazia!");
        }
    }

    public String encontrarPalavraMaisFrequente(){
        String palavraFrequente = null;
        int frequencia = 0;
        if (!palavras.isEmpty()){
            for(Map.Entry<String, Integer> palavra : palavras.entrySet()){
                if (palavra.getValue() >= frequencia){
                    frequencia = palavra.getValue();
                    palavraFrequente = palavra.getKey();
                }
            }
            return palavraFrequente;
        }else{
            throw new RuntimeException("Lista vazia!");
        }
    }

    public static void main(String[] args) {
        ContagemPalavras contagemPalavras = new ContagemPalavras();
        contagemPalavras.adicionarPalavra("Carro", 10);
        contagemPalavras.adicionarPalavra("Moto", 2);
        contagemPalavras.adicionarPalavra("Pipa", 11);


        System.out.println(contagemPalavras.encontrarPalavraMaisFrequente());
        System.out.println(contagemPalavras.exibirContagemPalavras());

        contagemPalavras.removerPalavra("Pipa");
        System.out.println(contagemPalavras.encontrarPalavraMaisFrequente());
    }
}
