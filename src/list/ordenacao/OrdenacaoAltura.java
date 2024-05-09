package list.ordenacao;

import java.util.Comparator;

public class OrdenacaoAltura implements Comparator<Pessoa> {

    @Override
    public int compare(Pessoa primeiraPessoa, Pessoa segundaPessoa) {
        return Double.compare(primeiraPessoa.getAltura(), segundaPessoa.getAltura());
    }
}
