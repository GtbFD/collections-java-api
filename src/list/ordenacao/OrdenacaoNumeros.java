package list.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {

    private List<Integer> listaInteiros;

    public OrdenacaoNumeros(){
        listaInteiros = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        listaInteiros.add(numero);
    }

    public List<Integer> ordenarAscendente(){
        List<Integer> listaInteirosCopia = new ArrayList<>(listaInteiros);
        if (!listaInteiros.isEmpty()){
            Collections.sort(listaInteirosCopia);
            return listaInteirosCopia;
        }
        return listaInteirosCopia;
    }

    public List<Integer> ordenarDescendente(){
        List<Integer> listaInteirosCopia = new ArrayList<>(listaInteiros);
        if (!listaInteiros.isEmpty()){
            Collections.sort(listaInteirosCopia);
            Collections.reverse(listaInteirosCopia);
            return listaInteirosCopia;
        }
        return listaInteirosCopia;
    }

    public static void main(String[] args) {
        OrdenacaoNumeros ordenacaoNumeros = new OrdenacaoNumeros();

        ordenacaoNumeros.adicionarNumero(70);
        ordenacaoNumeros.adicionarNumero(30);
        ordenacaoNumeros.adicionarNumero(14);
        ordenacaoNumeros.adicionarNumero(37);
        ordenacaoNumeros.adicionarNumero(21);

        System.out.println("Lista original = " + ordenacaoNumeros.listaInteiros);

        System.out.println("Lista ordenada crescente = " + ordenacaoNumeros.ordenarAscendente());
        System.out.println("Lista ordenada decrescente = " + ordenacaoNumeros.ordenarDescendente());
    }
}
