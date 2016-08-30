package org.bk.dieter.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * Created by redi on 03.04.2016.
 */
@Entity
@Getter
@Setter
@ToString
public class Product {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int calories;
    private int carbohydrates;
    private int fats;
    private int proteins;
    private LocalDateTime createdAt;
}
