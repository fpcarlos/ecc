/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.dioceseroraima.ecc.controle;

import br.org.dioceseroraima.ecc.modelo.Atividade;
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
public class AtividadeControle extends AbstractControle{
 @PersistenceContext
    private EntityManager entityManager;

    public void salvar(Atividade entity) throws Exception {
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

    public void remove(Atividade entity) throws Exception {
        try {
            Atividade aux = entityManager.find(Atividade.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public Atividade pegaAtividadeId(Integer id) throws Exception {
        try {
            Atividade aux = entityManager.find(Atividade.class, id);
            return aux;
        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }

    public List<Atividade> findAll() throws Exception {
        try {
            List<Atividade> listaAtividade = new ArrayList<>();
            String sql = "select * from atividade";
            listaAtividade = executaSqlNativo(sql, Atividade.class, entityManager);
            return listaAtividade;

        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }    
}
