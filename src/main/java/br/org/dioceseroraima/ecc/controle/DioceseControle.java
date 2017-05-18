/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.dioceseroraima.ecc.controle;

import br.org.dioceseroraima.ecc.modelo.Diocese;
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
public class DioceseControle extends AbstractControle {
     @PersistenceContext
    private EntityManager entityManager;

    public void salvar(Diocese entity) throws Exception {
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

    public void remove(Diocese entity) throws Exception {
        try {
            Diocese aux = entityManager.find(Diocese.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public Diocese pegaDioceseId(Integer id) throws Exception {
        try {
            Diocese aux = entityManager.find(Diocese.class, id);
            return aux;
        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }

    public List<Diocese> findAll() throws Exception {
        try {
            List<Diocese> listaDiocese = new ArrayList<>();
            String sql = "select * from diocese";
            listaDiocese = executaSqlNativo(sql, Diocese.class, entityManager);
            return listaDiocese;

        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }
}
