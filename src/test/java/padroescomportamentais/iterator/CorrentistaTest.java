package padroescomportamentais.iterator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class CorrentistaTest {

    private Extrato criarExtrato() {
        Extrato extrato = new Extrato();
        extrato.addTransacao(new Transacao("Depósito", 1000.0));
        extrato.addTransacao(new Transacao("Saque", -200.0));
        extrato.addTransacao(new Transacao("PIX recebido", 150.0));
        return extrato;
    }

    @Test
    void deveCalcularSaldoPercorrendoExtrato() {
        Correntista correntista = new Correntista("Maria", criarExtrato());
        assertEquals(950.0, correntista.calcularSaldo());
    }

    @Test
    void deveListarTransacoesNaOrdem() {
        Correntista correntista = new Correntista("Maria", criarExtrato());
        assertEquals(Arrays.asList("Depósito: 1000.0", "Saque: -200.0", "PIX recebido: 150.0"),
                correntista.listarTransacoes());
    }

    @Test
    void deveRetornarSaldoZeroParaExtratoVazio() {
        Correntista correntista = new Correntista("João", new Extrato());
        assertEquals(0.0, correntista.calcularSaldo());
    }

    @Test
    void devePercorrerComIterator() {
        Iterator<Transacao> iterator = criarExtrato().iterator();
        assertTrue(iterator.hasNext());
        assertEquals("Depósito", iterator.next().getDescricao());
        assertEquals("Saque", iterator.next().getDescricao());
        assertEquals("PIX recebido", iterator.next().getDescricao());
        assertFalse(iterator.hasNext());
    }

    @Test
    void deveRetornarExcecaoAoPassarDoFim() {
        Iterator<Transacao> iterator = new Extrato().iterator();
        try {
            iterator.next();
            fail();
        } catch (NoSuchElementException e) {
            assertEquals("Não há mais transações no extrato", e.getMessage());
        }
    }

    @Test
    void deveCriarIteratorsIndependentes() {
        Extrato extrato = criarExtrato();
        Iterator<Transacao> it1 = extrato.iterator();
        Iterator<Transacao> it2 = extrato.iterator();
        it1.next();
        it1.next();
        assertEquals("Depósito", it2.next().getDescricao());
    }
}
