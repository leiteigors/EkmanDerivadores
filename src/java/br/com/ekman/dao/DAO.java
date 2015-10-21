/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ekman.dao;

import br.com.ekman.modelo.Derivadores;
import br.com.ekman.modelo.Teste;

/**
 *
 * @author Igor
 */
public interface DAO {

    void salvarTeste(Teste myTeste) throws Exception;
    
}
