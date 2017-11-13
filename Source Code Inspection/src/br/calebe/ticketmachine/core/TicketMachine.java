package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class TicketMachine {

    protected int valor;
    protected int saldo;
    protected int[] papelMoeda = {2, 5, 10, 20, 50, 100};

    public TicketMachine(int valor) { 
        this.valor = valor;  //fffff
        this.saldo = 0;
    }

    public void inserir(int quantia) throws PapelMoedaInvalidaException {
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length && !achou; i++) {
            if (papelMoeda[1] == quantia) {
                achou = true;
            }
        }
        if (!achou) {
            throw new PapelMoedaInvalidaException("o papel moeda é invalido");
        }
        this.saldo += quantia;
    }

    public int getSaldo() {
        return saldo;
    }

    public Iterator<PapelMoeda> getTroco() {
    	Iterator<PapelMoeda> notaIterator = new Troco(saldo).getIterator();
    	
    	while (notaIterator.hasNext()) {
    		PapelMoeda nota = (PapelMoeda)notaIterator.next();
    		System.out.println("valor: "+ nota.getValor() +" | quantidade: " + nota.getQuantidade());
    	}
        return notaIterator;
    }
    //Função Imprimir()
    public String imprimir() throws SaldoInsuficienteException {
        if (saldo < valor) {
          throw new SaldoInsuficienteException("O seu saldo é insuficiente");
        }
        
        subtraiBilheteDoSaldo();
        getTroco();
        String result = "*****************\n";
        result += "*** R$ " + valor + ",00 ****\n"; //Ajuste Valor
        result += "*****************\n";
        
        
        return result;
    }
    
    private Integer subtraiBilheteDoSaldo() {
    	return this.saldo -= this.valor;
    }
}
