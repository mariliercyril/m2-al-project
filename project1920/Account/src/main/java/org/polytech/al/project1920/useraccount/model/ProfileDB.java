package org.polytech.al.project1920.useraccount.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileDB extends MongoRepository<Profile, String> {
}