package br.com.rasmoo.restaurante.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.rasmoo.restaurante.entity.Cardapio;
import br.com.rasmoo.restaurante.entity.Categoria;

public class CategoriaDao {
	
	private EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar (Categoria categoria){
        this.entityManager.persist(categoria);
        System.out.println("Entidade cadastrada: "+categoria);
    }
    
    public Cardapio consultar(final Integer id) {
        return this.entityManager.find(Cardapio.class, id);
    }

    public void atualizar(final Categoria categoria){
        this.entityManager.merge(categoria);
    }

    public void excluir(final Categoria categoria){
        this.entityManager.remove(categoria);
    }

	public List<Categoria> consultarTodos() {
		String sql = "SELECT c FROM Categoria c";
    	return this.entityManager.createQuery(sql, Categoria.class).getResultList();
	}

}
