package com.unihack.unihackbe.utils;

import com.unihack.unihackbe.entity.Avatar;
import com.unihack.unihackbe.entity.dto.AvatarDto;
import org.bson.types.ObjectId;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class GeneralMapper {

    @Named("objectIdToString")
    public String objectIdToString(ObjectId objectId) {
        return objectId.toString();
    }

    @Named("stringToObjectId")
    public ObjectId stringToObjectId(String stringObjectId) {
        if (stringObjectId == null || stringObjectId.length() == 0) {
            return null;
        }
        return new ObjectId(stringObjectId);
    }

    @Named("integerToString")
    public String intToString(Integer number) {
        return Integer.toString(number);
    }

    @Named("stringToInteger")
    public Integer stringToInt(String number) {
        return Integer.getInteger(number);
    }

    @Named("floatToString")
    public String floatToString(Float number) {
        return Float.toString(number);
    }

    @Named("stringToFloat")
    public Float stringToFloat(String number) {
        return Float.parseFloat(number);
    }


    /*Mapper functions for Avatar.class */
    @Mapping(source = "id", target = "id", qualifiedByName = "objectIdToString")
    @Mapping(source = "age", target = "age", qualifiedByName = "floatToString")
    @Mapping(source = "popularity", target = "popularity", qualifiedByName = "floatToString")
    public abstract AvatarDto entityToDto(Avatar avatarEntity);

    @Mapping(source = "id", target = "id", qualifiedByName = "stringToObjectId")
    @Mapping(source = "age", target = "age", qualifiedByName = "stringToFloat")
    @Mapping(source = "popularity", target = "popularity", qualifiedByName = "stringToFloat")
    public abstract Avatar dtoToEntity(AvatarDto avatarDto);

}
