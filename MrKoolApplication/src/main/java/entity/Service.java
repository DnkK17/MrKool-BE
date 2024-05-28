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

@Table(name = "Service")
public class Service implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ServiceID")
    private int serviceID;

    @Column(name = "Title")
    private String title;

    @Column(name = "Date")
    private String date;

    @Column(name = "Price")
    private double price;

    @Column(name = "Description")
    private String description;
    
    //Relationship
    @OneToMany(targetEntity = OrderDetail.class, mappedBy = "orderDetail")
   	@ToString.Exclude
   	private Collection<OrderDetail>orderDetailList;
    
    @ManyToOne(targetEntity = Model.class, fetch = FetchType.EAGER)
  	@JoinColumn(name = "modelID", referencedColumnName = "modelID", nullable = false, insertable = true, updatable = false)
  	@JsonIgnore
  	@ToString.Exclude
  	private Model model;
}
