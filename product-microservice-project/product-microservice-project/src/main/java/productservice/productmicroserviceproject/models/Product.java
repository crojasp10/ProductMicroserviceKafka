package productservice.productmicroserviceproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private long productId;
    private String code;
    private Double price;
    private String name;
    private Integer stock;
    private String description;
    private boolean available;
    private Category category;




}
