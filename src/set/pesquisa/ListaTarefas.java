package set.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {

    private Set<Tarefa> tarefas;

    public ListaTarefas(){
        tarefas = new HashSet<>();
    }

    public void adicionarTarefa(String descricao){
        tarefas.add(new Tarefa(descricao, false));
    }

    public void removerTarefa(String descricao){
        Tarefa tarefaARemover = null;
        if (!tarefas.isEmpty()){
            for (Tarefa tarefa : tarefas){
                if (tarefa.getDescricao().equals(descricao)){
                    tarefaARemover = tarefa;
                    break;
                }
            }
            tarefas.remove(tarefaARemover);
        }
    }

    public void exibirTarefas(){
        System.out.println(tarefas);
    }

    public int contarTarefas(){
        return tarefas.size();
    }

    public Set<Tarefa> obterTarefasConcluidas(){
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        if (!tarefas.isEmpty()){
            for (Tarefa tarefa : tarefas){
                if (tarefa.isConcluido()){
                    tarefasConcluidas.add(tarefa);
                }
            }
        }
        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes(){
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        if (!tarefas.isEmpty()){
            for (Tarefa tarefa : tarefas){
                if (!tarefa.isConcluido()){
                    tarefasConcluidas.add(tarefa);
                }
            }
        }
        return tarefasConcluidas;
    }

    public void marcarTarefaConcluida(String descricao){
        if (!tarefas.isEmpty()){
            for (Tarefa tarefa : tarefas){
                if (tarefa.getDescricao().equalsIgnoreCase(descricao)){
                    tarefa.setConcluido(true);
                    break;
                }
            }
        }
    }

    public void marcarTarefaPendente(String descricao){
        if (!tarefas.isEmpty()){
            for (Tarefa tarefa : tarefas){
                if (tarefa.getDescricao().equalsIgnoreCase(descricao)){
                    tarefa.setConcluido(false);
                    break;
                }
            }
        }
    }

    public void limparListaTarefas(){
        tarefas.clear();
    }

    public static void main(String[] args) {
        // Criando uma instância da classe ListaTarefas
        ListaTarefas listaTarefas = new ListaTarefas();

        // Adicionando tarefas à lista
        listaTarefas.adicionarTarefa("Estudar Java");
        listaTarefas.adicionarTarefa("Fazer exercícios físicos");
        listaTarefas.adicionarTarefa("Organizar a mesa de trabalho");
        listaTarefas.adicionarTarefa("Ler livro");
        listaTarefas.adicionarTarefa("Preparar apresentação");

        // Exibindo as tarefas na lista
        listaTarefas.exibirTarefas();

        // Removendo uma tarefa
        listaTarefas.removerTarefa("Fazer exercícios físicos");
        listaTarefas.exibirTarefas();

        // Contando o número de tarefas na lista
        System.out.println("Total de tarefas na lista: " + listaTarefas.contarTarefas());

        // Obtendo tarefas pendentes
        System.out.println(listaTarefas.obterTarefasPendentes());

        // Marcando tarefas como concluídas
        listaTarefas.marcarTarefaConcluida("Ler livro");
        listaTarefas.marcarTarefaConcluida("Estudar Java");

        // Obtendo tarefas concluídas
        System.out.println(listaTarefas.obterTarefasConcluidas());

        // Marcando tarefas como pendentes
        listaTarefas.marcarTarefaPendente("Estudar Java");
        listaTarefas.exibirTarefas();

        // Limpando a lista de tarefas
        listaTarefas.limparListaTarefas();
        listaTarefas.exibirTarefas();
    }
}
