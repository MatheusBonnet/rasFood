package br.com.rasmoo.restaurante.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ordens_cardapio")
public class OrdensCardapio {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@ManyToOne
	private Ordem ordem;
	
	@ManyToOne
	private Cardapio cardapio;
	
	private BigDecimal valor;
	
	private Integer quantidade;
	
	public OrdensCardapio() {
		// TODO Auto-generated constructor stub
	}

	public OrdensCardapio(Ordem ordem, Cardapio cardapio, Integer quantidade) {
		this.ordem = ordem;
		this.cardapio = cardapio;
		this.quantidade = quantidade;
		this.valor = cardapio.getValor();
	}

	public Ordem getOrdem() {
		return ordem;
	}

	public void setOrdem(Ordem ordem) {
		this.ordem = ordem;
	}

	public Cardapio getCardapio() {
		return cardapio;
	}

	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "OrdensCardapio [id=" + id + ", cardapio=" + cardapio + ", valor=" + valor
				+ ", quantidade=" + quantidade + "]";
	}
	
	
	
}
