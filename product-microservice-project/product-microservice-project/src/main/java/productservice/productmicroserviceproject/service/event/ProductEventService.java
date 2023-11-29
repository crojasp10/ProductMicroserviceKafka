package productservice.productmicroserviceproject.service.event;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import productservice.productmicroserviceproject.events.EventType;
import productservice.productmicroserviceproject.events.ProductCreatedEvent;
import productservice.productmicroserviceproject.events.Event;
import productservice.productmicroserviceproject.models.Product;

import java.util.Date;
import java.util.UUID;

@Component
public class ProductEventService {

        @Autowired
        private KafkaTemplate<String, Event<?>> producer;

        @Value("${topic.product.name:productos2}")
        private String topicCustomer;

        public void publish(Product producto) {

            ProductCreatedEvent created = new ProductCreatedEvent();
            created.setData(producto);
            created.setId(UUID.randomUUID().toString());
            created.setType(EventType.CREATED);
            created.setDate(new Date());

            this.producer.send(topicCustomer, created);

            System.out.println("product published" + producto);
        }

    }





