package com.unihack.unihackbe.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class AvatarDto {

    private String id;

    private String name;
    private String level;

    private String smallUrl;
}
