package com.hash.endpoint.main.repo;

import com.hash.endpoint.main.model.PasswordEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RepositoryRestController
public interface PasswordsRepo extends JpaRepository<PasswordEntity, Long>{

    //Optional<PasswordEntity> findAllByHashType(String hashType);

    Page<PasswordEntity> findAllByHashType(String hashType, Pageable pageable);
}
