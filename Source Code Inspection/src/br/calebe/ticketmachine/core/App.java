/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;

/**
 *
 * @author Roger
 */
public class App {
   public static void main(String[] args) {
        TicketMachine atm = new TicketMachine(5);
        
        System.out.println("saldo = " + atm.getSaldo());
        int valorInserido = 100;
        
        try {
            atm.inserir(valorInserido);
        } catch (PapelMoedaInvalidaException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            System.out.println(atm.imprimir());
        } catch (SaldoInsuficienteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println("saldo após o depósito de {"+valorInserido+"} = " + atm.getSaldo());
        
        
    }
}
