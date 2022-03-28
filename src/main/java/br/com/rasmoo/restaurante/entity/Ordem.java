package br.com.rasmoo.restaurante.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ordens")
public class Ordem {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private BigDecimal valorTotal = BigDecimal.ZERO;
	
	private LocalDateTime dataDeCriacao = LocalDateTime.now();
	
	@ManyToOne
	private Cliente cliente;
	
	
//	@JoinTable(
//			name="ordens_cardapio",
//			joinColumns = @JoinColumn(name = "ordens_id"),
//			inverseJoinColumns = @JoinColumn(name = "cardapio_id")
//			)
	@OneToMany(mappedBy = "ordem", cascade = CascadeType.ALL)
	private List<OrdensCardapio> ordensCardapios = new ArrayList<OrdensCardapio>();

	public Ordem( Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Ordem() {
		// TODO Auto-generated constructor stub
	}
	
	public void addOrdensCardapio(OrdensCardapio ordensCardapio) {
		ordensCardapio.setOrdem(this);
		this.ordensCardapios.add(ordensCardapio);
		this.valorTotal = valorTotal.add(ordensCardapio.getValor()
				.multiply(BigDecimal.valueOf(ordensCardapio.getQuantidade())));
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDateTime getDataDeCriacao() {
		return dataDeCriacao;
	}

	public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<OrdensCardapio> getOrdensCardapios() {
		return ordensCardapios;
	}

	public void setOrdensCardapios(List<OrdensCardapio> ordensCardapios) {
		this.ordensCardapios = ordensCardapios;
	}

	@Override
	public String toString() {
		return "Ordem [id=" + id + ", valorTotal=" + valorTotal + ", dataDeCriacao=" + dataDeCriacao + ", cliente="
				+ cliente + ", ordensCardapios=" + ordensCardapios + "]";
	}

	
	

}
