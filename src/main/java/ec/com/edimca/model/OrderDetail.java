package ec.com.edimca.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EDIM_ORDER_DETAIL")
public class OrderDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORD_DET_ID_PR", columnDefinition = "NUMERIC (10,0)")
	private Long id;

	private Integer cuantity;
	private BigDecimal subTotal;
	private Date date;

	@ManyToOne
	@JoinColumn(name = "PRO_ID_FK")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "ORD_ID_FK")
	private Order order;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCuantity() {
		return cuantity;
	}

	public void setCuantity(Integer cuantity) {
		this.cuantity = cuantity;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void calcularTotal() {

		this.subTotal = product.getPrice().multiply(new BigDecimal(cuantity));
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
