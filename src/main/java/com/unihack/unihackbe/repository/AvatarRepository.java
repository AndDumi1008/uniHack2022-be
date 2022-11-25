package com.unihack.unihackbe.repository;


import com.unihack.unihackbe.entity.Avatar;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvatarRepository extends MongoRepository<Avatar, ObjectId> {
}
