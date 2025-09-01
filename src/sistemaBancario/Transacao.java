package sistemaBancario;

import java.time.LocalDateTime;

public class Transacao {
    // Atributos
    private String tipo;
    private double valor;
    private LocalDateTime data;
    private int contaOrigem;
    private int contaDestino;

    public Transacao(String tipo, double valor, int contaOrigem, int contaDestino) {
        this.tipo = tipo;
        this.valor = valor;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
    }


}
