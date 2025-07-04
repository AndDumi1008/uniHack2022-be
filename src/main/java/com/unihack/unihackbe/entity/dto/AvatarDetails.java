package com.unihack.unihackbe.entity.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AvatarDetails extends AvatarDto {

    private String shortBio;
    private String bigUrl;
    private String age;
    private String sleepTime;
}
