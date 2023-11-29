package productservice.productmicroserviceproject.events;


import lombok.Data;
import lombok.EqualsAndHashCode;
import productservice.productmicroserviceproject.models.Product;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductCreatedEvent extends  Event<Product> {








}
