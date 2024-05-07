package list.operacoesbasicas.listatarefas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {

    private List<Tarefa> tarefas = new ArrayList<>();

    public void adicionarTarefa(String decricao){
        Tarefa tarefa = new Tarefa();
        tarefa.setDescricao(decricao);

        tarefas.add(tarefa);
    }

    public void removerTarefa(String descricao){
        List<Tarefa> tarefasRemocao = new ArrayList<>();
        for(Tarefa tarefa : tarefas){
            if(tarefa.getDescricao().equalsIgnoreCase(descricao)){
                tarefasRemocao.add(tarefa);
            }
        }
        tarefas.removeAll(tarefasRemocao);
    }

    public int obterNumeroTotalTarefas(){
        return tarefas.size();
    }

    public void obterDescricoesTarefas(){
        System.out.println(tarefas);
    }

    public static void main(String[] args){
        ListaTarefa listaTarefa = new ListaTarefa();
        System.out.println("O número de total de elementos na lista é: " + listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.adicionarTarefa("Tarefa 1");
        listaTarefa.adicionarTarefa("Tarefa 1");
        listaTarefa.adicionarTarefa("Tarefa 2");
        System.out.println("O número de total de elementos na lista é: " + listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.removerTarefa("Tarefa 1");
        System.out.println("O número de total de elementos na lista é: " + listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.obterDescricoesTarefas();
    }

}
