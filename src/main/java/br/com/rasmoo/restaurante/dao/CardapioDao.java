package br.com.rasmoo.restaurante.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.rasmoo.restaurante.entity.Cardapio;

public class CardapioDao {
	
	private EntityManager entityManager;

    public CardapioDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar (Cardapio cardapio){
        this.entityManager.persist(cardapio);
        System.out.println("Entidade cadastrada: "+cardapio);
    }
    
    public Cardapio consultar(final Integer id) {
        return this.entityManager.find(Cardapio.class, id);
    }

    public void atualizar(final Cardapio cardapio){
        this.entityManager.merge(cardapio);
    }

    public void excluir(final Cardapio cardapio){
        this.entityManager.remove(cardapio);
    }
    
    public List<Cardapio> listarTodos(){
    	String sql = "SELECT c FROM Cardapio c";
    	return this.entityManager.createQuery(sql, Cardapio.class).getResultList();
    }

	public List<Cardapio> consultarPorValor(final BigDecimal filtro){
        String jpql = "SELECT c FROM Cardapio c WHERE c.valor = :valor";
        return this.entityManager.createQuery(jpql,Cardapio.class).setParameter("valor",filtro).getResultList();
    }
	

}
