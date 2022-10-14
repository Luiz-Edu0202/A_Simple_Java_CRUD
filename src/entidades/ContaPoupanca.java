package entidades;

public class ContaPoupanca extends Conta 
{
    private double taxaBonus;

    public ContaPoupanca(int numeroAgencia, long numeroConta, Correntista correntista, double taxaBonus) 
    {
        super(numeroAgencia, numeroConta,correntista);
        this.taxaBonus = taxaBonus;
    }
    public void debitar(double valor)
    {
        setSaldo(getSaldo() - valor);
    }
    public void creditar(double valor)
    {
        setSaldo(getSaldo() + valor + taxaBonus);
    }
    
}
