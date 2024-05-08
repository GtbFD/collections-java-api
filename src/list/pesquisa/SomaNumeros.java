package list.pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {

    private List<Integer> numeros;

    public SomaNumeros(){
        this.numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        numeros.add(numero);
    }

    public int calcularSoma(){
        int soma = 0;
        for (Integer numero : numeros){
            soma += numero;
        }
        return soma;
    }

    public int encontrarMaiorNumero(){
        int maiorNumero = 0;
        if (!numeros.isEmpty()) {
            maiorNumero = numeros.get(0);

            for (Integer numero : numeros) {
                if (numero > maiorNumero) {
                    maiorNumero = numero;
                }
            }
        }else{
            System.out.println("Lista vazia!");
        }
        return maiorNumero;
    }

    public int encontrarMenorNumero(){
        int menorNumero = encontrarMaiorNumero();

        if (!numeros.isEmpty()) {
            for (Integer numero : numeros) {
                if (numero < menorNumero) {
                    menorNumero = numero;
                }
            }
        }else{
            System.out.println("Lista vazia!");
        }
        return menorNumero;
    }

    public void exibirNumeros(){
        System.out.println(numeros);
    }

    public static void main(String[] args) {
        SomaNumeros somaNumeros = new SomaNumeros();

        System.out.println("Encontrar maior número em uma lista vazia!");
        somaNumeros.encontrarMaiorNumero();

        System.out.println("Encontrar menor número em uma lista vazia!");
        somaNumeros.encontrarMenorNumero();

        System.out.println("Números adicionados");
        somaNumeros.adicionarNumero(10);
        somaNumeros.adicionarNumero(0);
        somaNumeros.adicionarNumero(80);
        somaNumeros.adicionarNumero(14);

        somaNumeros.exibirNumeros();
        System.out.println("Maior número = " + somaNumeros.encontrarMaiorNumero());
        System.out.println("Menor número = " + somaNumeros.encontrarMenorNumero());
        System.out.println("Soma dos números = " + somaNumeros.calcularSoma());
    }
}
