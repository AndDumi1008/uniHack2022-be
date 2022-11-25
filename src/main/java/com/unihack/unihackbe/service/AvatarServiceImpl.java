package com.unihack.unihackbe.service;

import com.unihack.unihackbe.entity.AvatarEntity;
import com.unihack.unihackbe.entity.dto.AvatarDetails;
import com.unihack.unihackbe.entity.dto.AvatarSummary;
import com.unihack.unihackbe.repository.AvatarRepository;
import com.unihack.unihackbe.utils.GeneralMapper;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AvatarServiceImpl implements AvatarService {

    private final AvatarRepository avatarRepository;
    private final GeneralMapper generalMapper;


//    False error on generalMapper
    public AvatarServiceImpl(AvatarRepository avatarRepository, GeneralMapper generalMapper) {
        this.avatarRepository = avatarRepository;
        this.generalMapper = generalMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AvatarDetails save(AvatarDetails avatarDetails) {
        AvatarEntity avatarEntity = avatarRepository.save(generalMapper.detailsToEntity(avatarDetails));
        AvatarDetails avatarReturn = generalMapper.entityToDetails(avatarEntity);

        return avatarReturn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<AvatarSummary> findAll() {
        return generalMapper.avatarEntityListToAvatarSummaryList(avatarRepository.findAll());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AvatarDetails update(AvatarDetails avatarDetails, String id, LocalDate birthdate) {
        try {
            ObjectId avatarId = generalMapper.stringToObjectId(id);
            AvatarEntity avatarEntity = avatarRepository.findById(avatarId).orElseThrow();
            avatarEntity.setName(avatarDetails.getName());
            avatarEntity.setLevel(avatarDetails.getLevel());
            avatarEntity.setBirthDate(birthdate);
            avatarEntity.setBigUrl(avatarDetails.getBigUrl());
            avatarEntity.setSmallUrl(avatarEntity.getSmallUrl());

            AvatarEntity updateAvatar = avatarRepository.save(avatarEntity);

            return generalMapper.entityToDetails(updateAvatar);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The avatar was not found.", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(String id) {
        try {
            ObjectId avatarId = generalMapper.stringToObjectId(id);
            avatarRepository.findById(avatarId).orElseThrow();
            avatarRepository.deleteById(avatarId);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The avatar was not found.", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AvatarDetails getAvatarById(String id) {
        try {
            ObjectId avatarObjectId = generalMapper.stringToObjectId(id);
            AvatarEntity avatarEntity = avatarRepository.findById(avatarObjectId).orElseThrow();

            return generalMapper.entityToDetails(avatarEntity);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The avatar was not found.", e);
        }
    }
}
