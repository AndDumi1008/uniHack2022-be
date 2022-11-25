package com.unihack.unihackbe.service;

import com.unihack.unihackbe.entity.Avatar;
import com.unihack.unihackbe.repository.AvatarRepository;
import com.unihack.unihackbe.utils.GeneralMapper;
import org.springframework.stereotype.Service;

import java.lang.reflect.GenericArrayType;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvatarServiceImpl implements AvatarService{

    private final AvatarRepository avatarRepository;
//    private final GeneralMapper generalMapper;

    public AvatarServiceImpl(AvatarRepository avatarRepository) {
        this.avatarRepository = avatarRepository;
//        this.generalMapper = generalMapper;
    }

    @Override
    public List<String> getAvatars() {
        return avatarRepository.findAll().stream().map(Avatar::getName).collect(Collectors.toList());
    }
}
