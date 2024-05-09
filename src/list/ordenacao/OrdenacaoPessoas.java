package list.ordenacao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoas {

    private List<Pessoa> pessoas;

    public OrdenacaoPessoas(){
        pessoas = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altra){
        pessoas.add(new Pessoa(nome, idade, altra));
    }

    public List<Pessoa> ordenarPorIdade(){
        List<Pessoa> listaPessoasCopia = new ArrayList<>(pessoas);
        if (!pessoas.isEmpty()){
            Collections.sort(listaPessoasCopia);
            return listaPessoasCopia;
        }
        return listaPessoasCopia;
    }

    public List<Pessoa> ordenarPorAltura(){
        List<Pessoa> listaPessoasCopia = new ArrayList<>(pessoas);
        if (!pessoas.isEmpty()){
            Collections.sort(listaPessoasCopia, new OrdenacaoAltura());
            return listaPessoasCopia;
        }
        return listaPessoasCopia;
    }

    public static void main(String[] args) {
        OrdenacaoPessoas ordenacaoPessoas = new OrdenacaoPessoas();

        ordenacaoPessoas.adicionarPessoa("Pessoa 2", 14, 1.62);
        ordenacaoPessoas.adicionarPessoa("Pessoa 3", 20, 1.81);
        ordenacaoPessoas.adicionarPessoa("Pessoa 1", 10, 1.50);

        System.out.println("Lista original = " + ordenacaoPessoas.pessoas);
        System.out.println("Ordenação por idade = " + ordenacaoPessoas.ordenarPorIdade());
        System.out.println("Ordenação por altura = " + ordenacaoPessoas.ordenarPorAltura());
    }
}
