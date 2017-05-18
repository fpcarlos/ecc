/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.dioceseroraima.ecc.controle;

import br.org.dioceseroraima.ecc.modelo.Funcao;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author fpcarlos
 */
@Stateless
public class FuncaoControle extends AbstractControle{
     @PersistenceContext
    private EntityManager entityManager;

    public void salvar(Funcao entity) throws Exception {
        try {
            if (entity.getId() != null && entity.getId() > 0) {
                entityManager.merge(entity);
            } else {
                entityManager.persist(entity);
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public void remove(Funcao entity) throws Exception {
        try {
            Funcao aux = entityManager.find(Funcao.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public Funcao pegaFuncaoId(Integer id) throws Exception {
        try {
            Funcao aux = entityManager.find(Funcao.class, id);
            return aux;
        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }

    public List<Funcao> findAll() throws Exception {
        try {
            List<Funcao> listaFuncao = new ArrayList<>();
            String sql = "select * from funcao";
            listaFuncao = executaSqlNativo(sql, Funcao.class, entityManager);
            return listaFuncao;

        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }
}
