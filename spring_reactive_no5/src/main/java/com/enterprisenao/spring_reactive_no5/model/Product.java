package com.enterprisenao.spring_reactive_no5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product")
public class Product {

    private @Id String id;
    private String name;
    private long price;
    @Field(targetType = FieldType.OBJECT_ID)
    private String catId;
    private boolean status;


}
