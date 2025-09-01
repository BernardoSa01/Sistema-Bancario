package sistemaBancario;

import java.util.ArrayList;
import java.util.List;

public class Conta {
    // Atributos
    private int numeroConta;
    private Cliente titular;
    private double saldo;
    private List<Transacao> extrato;

    // Construtor

    public Conta(int numeroConta, Cliente titular, double saldo) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldo;
        this.extrato = new ArrayList<>(); // Inicializando a lista
    }

    // Getters e Setters
    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numeroConta=" + numeroConta +
                ", titular=" + titular +
                ", saldo=" + saldo +
                '}';
    }

    // Métodos
    public void depositar (double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo!");
        }
        saldo += valor;
        extrato.add(new Transacao("Depósito", valor, numeroConta, numeroConta));
    }

    public void sacar (double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo!");
        }
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente para o saque solicitado.");
        }
        saldo -= valor;
        extrato.add(new Transacao("Saque", valor, numeroConta, numeroConta));
    }

    public void transferir (double valor, Conta destino) {
        if (destino == null) {
            throw new IllegalArgumentException("Conta destino inválida!");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo!");
        }
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente!");
        }
        saldo -= valor;
        destino.saldo += valor;
        extrato.add(new Transacao("Transferência enviada", valor, numeroConta, destino.numeroConta));
        destino.extrato.add(new Transacao("Transferência recebida", valor, numeroConta, destino.numeroConta));
    }


}


