package com.example.urlservice.repository;


import com.example.urlservice.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {
    Optional<Url> findByAlias(String alias);

    Boolean existsByAlias(String alias);
}
