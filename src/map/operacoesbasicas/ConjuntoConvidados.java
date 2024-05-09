package map.operacoesbasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {

    private Set<Convidado> convidados;

    public ConjuntoConvidados(){
        convidados = new HashSet<Convidado>();
    }

    public void adicionarConvidado(String nome, int codigoConvite){
        convidados.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidadoPorCodigoConvite(int codigoConvite){
        Convidado convidadoARemover = null;
        if (!convidados.isEmpty()) {
            for (Convidado convidado : convidados) {
                if (convidado.getCodigoConvite() == codigoConvite) {
                    convidadoARemover = convidado;
                    break;
                }
            }
            convidados.remove(convidadoARemover);
        }
    }

    public int contarConvidados(){
        return convidados.size();
    }

    public Set<Convidado> exibirConvidados(){
        return convidados;
    }

    public static void main(String[] args) {
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();

        conjuntoConvidados.adicionarConvidado("Nome 1", 1);
        conjuntoConvidados.adicionarConvidado("Nome 1", 2);
        conjuntoConvidados.adicionarConvidado("Nome 3", 3);
        conjuntoConvidados.adicionarConvidado("Nome 4", 4);

        System.out.println("Lista de convidados = " + conjuntoConvidados.exibirConvidados());
        System.out.println("Quantidade de convidados = " + conjuntoConvidados.contarConvidados());

        conjuntoConvidados.removerConvidadoPorCodigoConvite(3);
        System.out.println("Lista de convidados = " + conjuntoConvidados.exibirConvidados());
        System.out.println("Quantidade de convidados = " + conjuntoConvidados.contarConvidados());

    }
}
