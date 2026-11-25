package padroescomportamentais.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ExtratoIterator implements Iterator<Transacao> {

    private Extrato extrato;
    private int posicao = 0;

    public ExtratoIterator(Extrato extrato) {
        this.extrato = extrato;
    }

    @Override
    public boolean hasNext() {
        return posicao < extrato.getQuantidade();
    }

    @Override
    public Transacao next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Não há mais transações no extrato");
        }
        return extrato.getTransacao(posicao++);
    }
}
