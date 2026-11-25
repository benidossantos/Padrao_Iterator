package padroescomportamentais.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Extrato implements Iterable<Transacao> {

    private List<Transacao> transacoes = new ArrayList<>();

    public void addTransacao(Transacao transacao) {
        this.transacoes.add(transacao);
    }

    public int getQuantidade() {
        return transacoes.size();
    }

    public Transacao getTransacao(int indice) {
        return transacoes.get(indice);
    }

    @Override
    public Iterator<Transacao> iterator() {
        return new ExtratoIterator(this);
    }
}
