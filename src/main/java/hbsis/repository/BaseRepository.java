package hbsis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import hbsis.entity.BaseEntity;

public interface BaseRepository<Entity extends BaseEntity> extends MongoRepository<Entity, String> {
}
