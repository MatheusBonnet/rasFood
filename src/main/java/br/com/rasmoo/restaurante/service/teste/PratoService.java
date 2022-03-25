package br.com.rasmoo.restaurante.service.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.dao.CategoriaDao;
import br.com.rasmoo.restaurante.entity.Cardapio;
import br.com.rasmoo.restaurante.entity.Categoria;
import br.com.rasmoo.restaurante.util.CargaDeDados;
import br.com.rasmoo.restaurante.util.JPAUtil;

public class PratoService {
	public static void main(String[] args) {
		
		EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        entityManager.getTransaction().begin();
        CargaDeDados.cadastarCategorias(entityManager);
        CargaDeDados.cadastrarProdutosCardapio(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);
        System.out.println("Lista de produtos por valor: "+ cardapioDao.consultarPorValor(BigDecimal.valueOf(59.00)));
        entityManager.close();
	
		
	}
	
}
