package set.ordenacao;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {

    private Set<Aluno> alunos;

    public GerenciadorAlunos(){
        alunos = new HashSet<>();
    }

    public void adicionarAluno(String nome, long matricula, double media){
        alunos.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(long matricula){
        Aluno alunoARemover = null;
        if (!alunos.isEmpty()){
            for (Aluno aluno : alunos){
                if (aluno.getMatricula() == matricula){
                    alunoARemover = aluno;
                    break;
                }
            }
            alunos.remove(alunoARemover);
        }
    }

    public Set<Aluno> exibirAlunosPorNome(){
        Set<Aluno> alunosPorNome = new TreeSet<>(new ComparatorPorNome());
        if (!alunos.isEmpty()){
            alunosPorNome.addAll(alunos);
            return alunosPorNome;
        }
        throw new RuntimeException("Lista vazia");
    }

    public Set<Aluno> exibirAlunosPorNota(){
        Set<Aluno> alunosPorNota = new TreeSet<>(new ComparatorPorNota());
        if (!alunos.isEmpty()){
            alunosPorNota.addAll(alunos);
            return alunosPorNota;
        }
        throw new RuntimeException("Lista vazia");
    }

    public void exibirAlunos(){
        System.out.println(alunos);
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();
        gerenciadorAlunos.adicionarAluno("Aluno 1", 2L, 1.59);
        gerenciadorAlunos.adicionarAluno("Caluno 2", 3L, 5);
        gerenciadorAlunos.adicionarAluno("Baluno 3", 4L, 2);

        gerenciadorAlunos.exibirAlunos();

        System.out.println("Ordenar alunos por nome = " + gerenciadorAlunos.exibirAlunosPorNome());

        System.out.println("Ordenar por media = " + gerenciadorAlunos.exibirAlunosPorNota());

        gerenciadorAlunos.removerAluno(3L);

        gerenciadorAlunos.exibirAlunos();
    }
}
