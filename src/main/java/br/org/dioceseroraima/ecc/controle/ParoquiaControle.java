/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.dioceseroraima.ecc.controle;

import br.org.dioceseroraima.ecc.modelo.Paroquia;
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
public class ParoquiaControle extends AbstractControle{
     @PersistenceContext
    private EntityManager entityManager;

    public void salvar(Paroquia entity) throws Exception {
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

    public void remove(Paroquia entity) throws Exception {
        try {
            Paroquia aux = entityManager.find(Paroquia.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public Paroquia pegaParoquiaId(Integer id) throws Exception {
        try {
            Paroquia aux = entityManager.find(Paroquia.class, id);
            return aux;
        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }

    public List<Paroquia> findAll() throws Exception {
        try {
            List<Paroquia> listaParoquia = new ArrayList<>();
            String sql = "select * from paroquia";
            listaParoquia = executaSqlNativo(sql, Paroquia.class, entityManager);
            return listaParoquia;

        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }
}
