package map.operacoesbasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {

    Map<String, String> dicionario;

    public Dicionario(){
        dicionario = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao){
        dicionario.put(palavra, definicao);
    }

    public void removerPalavra(String palavra){
        if (!dicionario.isEmpty()) {
            dicionario.remove(palavra);
        }else {
            throw new RuntimeException("Dicionário vazio!");
        }
    }

    public void exibirPalavras(){
        if (!dicionario.isEmpty()) {
            System.out.println(dicionario);
        }else {
            throw new RuntimeException("Dicionário vazio!");
        }
    }

    public void pesquisarPorPalavra(String palavra){
        if (!dicionario.isEmpty()) {
            System.out.println(dicionario.get(palavra));
        }else {
            throw new RuntimeException("Dicionário vazio!");
        }
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        dicionario.adicionarPalavra("Carro", "Nenhum significado!");
        dicionario.adicionarPalavra("Bicicleta", "Nenhum significado!");
        dicionario.adicionarPalavra("Moto", "Nenhum significado!");

        dicionario.exibirPalavras();

        dicionario.removerPalavra("Bicicleta");
        dicionario.exibirPalavras();

        dicionario.pesquisarPorPalavra("Carro");
    }

}
