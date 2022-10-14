package entidades;

public class ContaCorrente extends Conta
{
    private double tarifa;

    public ContaCorrente(int numeroAgencia, long numeroConta, Correntista correntista, double tarifa) 
    {
        super(numeroAgencia, numeroConta, correntista);
        this.tarifa = tarifa;
    }
    public void debitar(double valor)
    {
        setSaldo(getSaldo() - valor);
    }
    public void creditar(double valor)
    {
        setSaldo(getSaldo() + valor);
    }
   
    public double getTarifa() 
    {
        return tarifa;
    }
    public void setTarifa(double tarifa) 
    {
        this.tarifa = tarifa;
    }

    
}
