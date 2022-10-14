package entidades;

public abstract class Conta 
{
    private int numeroAgencia;
    private long numeroConta;
    private double saldo;
    private Correntista correntista;

    public abstract void debitar(double valor);
    public abstract void creditar(double valor);
    
    

    public Conta(int numeroAgencia, long numeroConta, Correntista correntista) 
    {
        this.correntista = correntista;
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
    }

    public int getNumeroAgencia() 
    {
        return numeroAgencia;
    }
    public void setNumeroAgencia(int numeroAgencia)
     {
        this.numeroAgencia = numeroAgencia;
    }
    public long getNumeroConta() 
    {
        return numeroConta;
    }
    public void setNumeroConta(long numeroConta) 
    {
        this.numeroConta = numeroConta;
    }
    public double getSaldo() 
    {
        return saldo;
    }
    public void setSaldo(double saldo)
    {
        this.saldo = saldo;
    }
    public void setCorrentista(Correntista correntista) {
        this.correntista = correntista;
    }
    
    
}