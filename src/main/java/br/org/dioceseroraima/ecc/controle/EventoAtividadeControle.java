/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.dioceseroraima.ecc.controle;

import br.org.dioceseroraima.ecc.modelo.EventoAtividade;
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
public class EventoAtividadeControle extends AbstractControle{
     @PersistenceContext
    private EntityManager entityManager;

    public void salvar(EventoAtividade entity) throws Exception {
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

    public void remove(EventoAtividade entity) throws Exception {
        try {
            EventoAtividade aux = entityManager.find(EventoAtividade.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public EventoAtividade pegaEventoAtividadeId(Integer id) throws Exception {
        try {
            EventoAtividade aux = entityManager.find(EventoAtividade.class, id);
            return aux;
        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }

    public List<EventoAtividade> findAll() throws Exception {
        try {
            List<EventoAtividade> listaEventoAtividade = new ArrayList<>();
            String sql = "select * from evento_atividade";
            listaEventoAtividade = executaSqlNativo(sql, EventoAtividade.class, entityManager);
            return listaEventoAtividade;

        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }
}
