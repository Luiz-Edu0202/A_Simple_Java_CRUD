package repositorios;

import entidades.Correntista;

public class RepositorioCorrentista 
{
    private Correntista[] listaCorrentistas;
    private int tamanhoAtual;
    
    public RepositorioCorrentista() 
    {
        this.listaCorrentistas = new Correntista[200];
        this.tamanhoAtual = -1;
    }

    public void incluir(Correntista correntista)
    {
        tamanhoAtual ++;
        listaCorrentistas[tamanhoAtual] = correntista;
    }

    public Correntista buscar(long cpf)
    {
        for(Correntista correntista : listaCorrentistas)
        {
            if(correntista != null && correntista.getCpf() == cpf)
            {
                return correntista;
            }
        }
        return null;
    }

    public Correntista[] consultarTodos()
    {
        Correntista[] listaPreenchida = new Correntista[tamanhoAtual + 1];
        for(int i = 0; i < listaPreenchida.length; i++)
        {
            listaPreenchida[i] = listaCorrentistas[i];
        }
        return listaPreenchida;
    }
}
