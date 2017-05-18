/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.dioceseroraima.ecc.controle;

import br.org.dioceseroraima.ecc.modelo.Evento;
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
public class EventoControle extends AbstractControle{
     @PersistenceContext
    private EntityManager entityManager;

    public void salvar(Evento entity) throws Exception {
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

    public void remove(Evento entity) throws Exception {
        try {
            Evento aux = entityManager.find(Evento.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public Evento pegaEventoId(Integer id) throws Exception {
        try {
            Evento aux = entityManager.find(Evento.class, id);
            return aux;
        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }

    public List<Evento> findAll() throws Exception {
        try {
            List<Evento> listaEvento = new ArrayList<>();
            String sql = "select * from evento";
            listaEvento = executaSqlNativo(sql, Evento.class, entityManager);
            return listaEvento;

        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }
}
