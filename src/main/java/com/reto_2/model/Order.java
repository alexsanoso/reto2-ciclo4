package com.reto_2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

@Document(collection = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {

        public static String PENDING = "Pendiente";  //Es constante porque tiene el atributo static y debe ser publica
        public static String APROVED = "Aprobada";
        public static String REJECTED = "Rechazada";

        @Id
        private Integer id;
        private Date registerDay;
        private String status;
        private User salesMan;
        private Map<Integer, Clone> products;
        private Map<String, Integer> quantities;

}
