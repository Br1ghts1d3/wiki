package com.telcel.sva.wiki.repository;

import com.telcel.sva.wiki.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {

    List<Service> findAll();
    Service findServiceByOwner(String owner);
}
