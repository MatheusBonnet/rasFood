package br.com.rasmoo.restaurante.service.teste;

import javax.persistence.EntityManager;

import br.com.rasmoo.restaurante.dao.CardapioDao;
import br.com.rasmoo.restaurante.dao.ClienteDao;
import br.com.rasmoo.restaurante.dao.OrdensDao;
import br.com.rasmoo.restaurante.entity.Cliente;
import br.com.rasmoo.restaurante.entity.Endereco;
import br.com.rasmoo.restaurante.entity.Ordem;
import br.com.rasmoo.restaurante.entity.OrdensCardapio;
import br.com.rasmoo.restaurante.util.CargaDeDados;
import br.com.rasmoo.restaurante.util.JPAUtil;

public class OrdemService {

	public static void main(String[] args) {
		EntityManager entityManager = JPAUtil.getEntityManagerRasFood();
        entityManager.getTransaction().begin();
        CargaDeDados.cadastarCategorias(entityManager);
        CargaDeDados.cadastrarProdutosCardapio(entityManager);
        
        CardapioDao cardapioDao = new CardapioDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        OrdensDao ordensDao = new OrdensDao(entityManager);
        
        Endereco endereco = new Endereco("000000000","sem teto","apto 1001","Sao Paulo","SP");
        Cliente matheus = new Cliente("11111111111", "Matheus");
        matheus.addEndereco(endereco);
        Ordem ordem1 = new Ordem(matheus);
        ordem1.addOrdensCardapio(new OrdensCardapio(ordem1, cardapioDao.consultar(1), 2));
        clienteDao.cadastrar(matheus); 
        ordensDao.cadastrar(ordem1);
        entityManager.getTransaction().commit();
        
        System.out.println(ordensDao.consultarItensMaisVendidos());
	}

}
