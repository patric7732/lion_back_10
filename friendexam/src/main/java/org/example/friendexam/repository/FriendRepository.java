package org.example.friendexam.repository;

import org.example.friendexam.domain.Friend;
import org.springframework.data.repository.CrudRepository;

public interface FriendRepository extends CrudRepository<Friend,Long> {
}
