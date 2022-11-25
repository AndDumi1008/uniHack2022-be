package com.unihack.unihackbe.entity;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Document("avatar")
@Data
@Builder
public class AvatarEntity {

    @Id
    private ObjectId id;

    @NotBlank
    private String name;

    @NotNull
    private LocalDate birthDate;

    private String level;

    private String shortBio;

    @NotNull
    private String wakeUpTime;

    @NotNull
    private String sleepTime;

    private String bigUrl;
    private String smallUrl;

//    private String networth;

}
