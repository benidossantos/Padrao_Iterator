package padroescomportamentais.iterator;

import java.util.ArrayList;
import java.util.List;

public class Correntista {

    private String nome;
    private Extrato extrato;

    public Correntista(String nome, Extrato extrato) {
        this.nome = nome;
        this.extrato = extrato;
    }

    public double calcularSaldo() {
        double saldo = 0;
        for (Transacao transacao : extrato) {
            saldo += transacao.getValor();
        }
        return saldo;
    }

    public List<String> listarTransacoes() {
        List<String> saida = new ArrayList<>();
        for (Transacao transacao : extrato) {
            saida.add(transacao.getDescricao() + ": " + transacao.getValor());
        }
        return saida;
    }

    public String getNome() {
        return nome;
    }
}
