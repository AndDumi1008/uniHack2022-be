package com.unihack.unihackbe.entity;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("avatar")
@Data
@Builder
public class Avatar {

    @Id
    private ObjectId id;

    private String name;
    private Integer age;
    private Float popularity;

//    private byte[] image;
//    private ObjectId idSchedule;
//    private ObjectId id?
//    private ObjectId id?

}
