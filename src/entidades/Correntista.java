package entidades;

public class Correntista 
{
    private long cpf;
    private String nome;
    
    public Correntista(long cpf, String nome) 
    {
        this.cpf = cpf;
        this.nome = nome;
    }

    public long getCpf() 
    {
        return cpf;
    }
    public void setCpf(long cpf) 
    {
        this.cpf = cpf;
    }
    public String getNome() 
    {
        return nome;
    }
    public void setNome(String nome) 
    {
        this.nome = nome;
    }

}
