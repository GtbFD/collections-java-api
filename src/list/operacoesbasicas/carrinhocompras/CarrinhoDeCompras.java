package list.operacoesbasicas.carrinhocompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> itens;

    public CarrinhoDeCompras(){
        itens = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        itens.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome){
        List<Item> itensParaRemover = new ArrayList<>();
        for(Item item : itens){
            if (item.getNome().equalsIgnoreCase(nome)){
                itensParaRemover.add(item);
            }
        }
        itens.removeAll(itensParaRemover);
    }

    public void calcularValorTotal(){
        double total = 0.0;
        for(Item item : itens){
            total += (item.getPreco() * item.getQuantidade());
        }
        System.out.println("Total R$ " + total);
    }

    public void exibirItens(){
        System.out.println(itens);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
        carrinhoDeCompras.calcularValorTotal();

        carrinhoDeCompras.adicionarItem("Cuscuz", 1.5, 2);
        carrinhoDeCompras.adicionarItem("Arroz", 5, 10);
        carrinhoDeCompras.calcularValorTotal();
        carrinhoDeCompras.exibirItens();

        carrinhoDeCompras.removerItem("Cuscuz");
        carrinhoDeCompras.calcularValorTotal();
        carrinhoDeCompras.exibirItens();
    }
}
