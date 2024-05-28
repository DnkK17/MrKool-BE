package entity;

import java.io.Serializable;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
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

@Table(name = "Order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private int orderID;

    @Column(name = "Date")
    private String date;

    @Column(name = "Time")
    private String time;

    @Column(name = "Title")
    private String title;

    @Column(name = "Detail")
    private String detail;

    @Column(name = "Address")
    private String address;
    
    //Relationship
    @OneToMany(targetEntity = OrderDetail.class, mappedBy = "order")
   	@JsonIgnore
   	@ToString.Exclude
   	private Collection<OrderDetail>orderDetailList;
    
    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "userID", referencedColumnName = "userID", nullable = false, insertable = true, updatable = false)
	@JsonIgnore
	@ToString.Exclude
	private Customer customer;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "requestID", referencedColumnName = "requestID",nullable = false)
    private Request request;
    
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "transactionID", referencedColumnName = "transactionID", nullable = false, insertable = true, updatable = false)
	@JsonIgnore
	@ToString.Exclude
	private Transaction transaction;
    
}