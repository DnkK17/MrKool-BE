package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

@Table(name = "Transaction")
public class Transaction implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transactionID")
	private long transactionID;
	
	@Column(name = "amount", nullable = false, insertable = true, updatable = false)
	private long amount;
	
	@Column(name = "date", nullable = false, insertable = true, updatable = false)
	private Date date;
	
	//Relationship
	@ManyToOne(targetEntity = Wallet.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "walletID", referencedColumnName = "walletID", nullable = false, insertable = true, updatable = false)
	@JsonIgnore
	@ToString.Exclude
	private Wallet wallet;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderID", referencedColumnName = "orderID", nullable = false, insertable = true, updatable = false)
	@JsonIgnore
	@ToString.Exclude
	private Order order;
}
