package br.com.rasmoo.restaurante.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.rasmoo.restaurante.entity.Ordem;
import br.com.rasmoo.restaurante.vo.ItensMaisvendidosDto;

public class OrdensDao {
	
	private EntityManager entityManager;

    public OrdensDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar (Ordem ordem){
        this.entityManager.persist(ordem);
        System.out.println("Entidade cadastrada: "+ordem);
    }
    
    public Ordem consultar(final Integer id) {
        return this.entityManager.find(Ordem.class, id);
    }

    public void atualizar(final Ordem ordem){
        this.entityManager.merge(ordem);
    }

    public void excluir(final Ordem ordem){
        this.entityManager.remove(ordem);
    }
    
    public List<Ordem> listarTodos(){
    	String sql = "SELECT c FROM Ordem c";
    	return this.entityManager.createQuery(sql, Ordem.class).getResultList();
    }

	public List<Ordem> consultarPorValor(final BigDecimal filtro){
        String jpql = "SELECT c FROM Ordem c WHERE c.valor = :valor";
        return this.entityManager.createQuery(jpql,Ordem.class).setParameter("valor",filtro).getResultList();
    }
	
	public List<ItensMaisvendidosDto> consultarItensMaisVendidos(){
		String jpql = "SELECT new br.com.rasmoo.restaurante.vo.ItensMaisvendidosDto(" +
                "c.nome, SUM(oc.quantidade)) FROM Ordem o " +
                "JOIN OrdensCardapio oc on o.id = oc.cardapio.id " +
                "JOIN oc.cardapio c " +
                "GROUP BY c.nome " +
                "ORDER BY SUM(oc.quantidade) DESC";
		return this.entityManager.createQuery(jpql,ItensMaisvendidosDto.class).getResultList();
	}
	

}
