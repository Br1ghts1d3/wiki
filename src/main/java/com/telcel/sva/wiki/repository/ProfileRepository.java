package com.telcel.sva.wiki.repository;

import com.telcel.sva.wiki.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository <Profile, Long> {
}
