package br.com.rasmoo.restaurante.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.rasmoo.restaurante.entity.Cardapio;
import br.com.rasmoo.restaurante.entity.Cliente;

public class ClienteDao {
	
	private EntityManager entityManager;

    public ClienteDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar (Cliente cliente){
        this.entityManager.persist(cliente);
        System.out.println("Entidade cadastrada: "+cliente);
    }
    
    public Cliente consultar(final Integer id) {
        return this.entityManager.find(Cliente.class, id);
    }

    public void atualizar(final Cliente cliente){
        this.entityManager.merge(cliente);
    }

    public void excluir(final Cliente cliente){
        this.entityManager.remove(cliente);
    }
    
    public List<Cliente> listarTodos(){
    	String sql = "SELECT c FROM Cliente c";
    	return this.entityManager.createQuery(sql, Cliente.class).getResultList();
    }

	public List<Cliente> consultarPorValor(final BigDecimal filtro){
        String jpql = "SELECT c FROM Cliente c WHERE c.valor = :valor";
        return this.entityManager.createQuery(jpql,Cliente.class).setParameter("valor",filtro).getResultList();
    }
	
	public List<Cliente> consultarPorNome(final String nome) {
        String jpql = "SELECT c FROM Cliente c WHERE LOWER(c.nome) LIKE LOWER(:nome)";
        return this.entityManager.createQuery(jpql,Cliente.class).setParameter("nome", "%"+nome+"%")
                .getResultList();
    }
	

}
