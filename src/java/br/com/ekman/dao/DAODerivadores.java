/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ekman.dao;

import br.com.ekman.modelo.Derivadores;
import br.com.ekman.modelo.Teste;
import java.util.Date;

/**
 *
 * @author Igor
 */
public interface DAODerivadores {
    
    void salvarDerivadores(Derivadores myDerivadores) throws Exception;
    
    Date selecionarMaiorData() throws Exception;
    
}
