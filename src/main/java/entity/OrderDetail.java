package entity;

import java.io.Serializable;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString

@Table(name = "OrderDetail")
public class OrderDetail {
	 private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "orderDetailID")
	    private String orderDetailID;
	    
	    
	    @Column(name = "Image")
	    private String image;
	    
	    //Relationship
	    @ManyToOne(targetEntity = Order.class, fetch = FetchType.EAGER)
		@JoinColumn(name = "orderID", referencedColumnName = "orderID", nullable = false, insertable = true, updatable = false)
		@JsonIgnore
		@ToString.Exclude
		private Order order;
	    
	    @ManyToOne(targetEntity = Technician.class, fetch = FetchType.EAGER)
		@JoinColumn(name = "technicianID", referencedColumnName = "technicianID", nullable = false, insertable = true, updatable = false)
		@JsonIgnore
		@ToString.Exclude
		private Technician techinician;
	    
	    @ManyToOne(targetEntity = Service.class, fetch = FetchType.EAGER)
		@JoinColumn(name = "serviceID", referencedColumnName = "serviceID", nullable = false, insertable = true, updatable = false)
		@JsonIgnore
		@ToString.Exclude
		private Service service;
}
