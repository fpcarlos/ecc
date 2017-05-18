/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.dioceseroraima.ecc.controle;

import br.org.dioceseroraima.ecc.modelo.Pessoa;
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
public class PessoaControle extends AbstractControle{
 @PersistenceContext
    private EntityManager entityManager;

    public void salvar(Pessoa entity) throws Exception {
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

    public void remove(Pessoa entity) throws Exception {
        try {
            Pessoa aux = entityManager.find(Pessoa.class, entity.getId());
            entityManager.remove(aux);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    public Pessoa pegaPessoaId(Integer id) throws Exception {
        try {
            Pessoa aux = entityManager.find(Pessoa.class, id);
            return aux;
        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }

    public List<Pessoa> findAll() throws Exception {
        try {
            List<Pessoa> listaPessoa = new ArrayList<>();
            String sql = "select * from pessoa";
            listaPessoa = executaSqlNativo(sql, Pessoa.class, entityManager);
            return listaPessoa;

        } catch (RuntimeException re) {
            throw new Exception(" Erro" + re.getMessage());
        } catch (Exception e) {
            throw new Exception(" Erro" + e.getMessage());
        }

    }    
}
