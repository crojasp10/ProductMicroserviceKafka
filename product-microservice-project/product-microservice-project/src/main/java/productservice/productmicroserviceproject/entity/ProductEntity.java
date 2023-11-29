package productservice.productmicroserviceproject.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    private String code;

    private Double price;

    private Double cost;

    private String name;

    private Integer stock;

    private String description;

    private boolean available;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;




}
