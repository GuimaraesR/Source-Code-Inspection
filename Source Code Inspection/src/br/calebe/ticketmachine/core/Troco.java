package br.calebe.ticketmachine.core;

import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
class Troco {

    protected PapelMoeda[] papeisMoeda;

    public Troco(int valor) {
        papeisMoeda = new PapelMoeda[6]; //Correção tamanho do vetor
        int count = 0;
        
        while (valor >= 100) {
            valor = valor - 100;
            count++;
        }
        papeisMoeda[5] = new PapelMoeda(100, count);
        count = 0;
        
        while (valor >= 50) {
            valor = valor - 50;
            count++;
        }
        papeisMoeda[4] = new PapelMoeda(50, count);
        count = 0;
        
        while (valor >= 20) {
            valor = valor - 20;
            count++;
        }
        papeisMoeda[3] = new PapelMoeda(20, count);
        count = 0;
        
        while (valor >= 10 ) {
            valor =  valor - 10;
            count++;
        }
        papeisMoeda[2] = new PapelMoeda(10, count);
        count = 0;
        
        while (valor >= 5) {
            valor = valor-  5;
            count++;
        }
        papeisMoeda[1] = new PapelMoeda(5, count);
        count = 0;
        
        while (valor >= 2) {
             valor = valor -  2;
            count++;
        }
        papeisMoeda[0] = new PapelMoeda(2, count);
    }
    // Correção da função getTroco
    public Iterator<PapelMoeda> getIterator() {
        return new TrocoIterator(this.papeisMoeda);
    }

    class TrocoIterator implements Iterator<PapelMoeda> {

        protected PapelMoeda[] troco;
    	int posicao = 0;

        public TrocoIterator(PapelMoeda[] troco) {
            this.troco = troco;
        }

        @Override
        public boolean hasNext() {
    		if (posicao >= troco.length || troco[posicao] == null) {
    			return false;
    		} else {
    			return true;
			}
        }

        @Override
        public PapelMoeda next() {

        	PapelMoeda nota = troco[posicao];
    		posicao++;
    		return nota;
        }

        @Override
        public void remove() {
            next();
        }
    }
}
