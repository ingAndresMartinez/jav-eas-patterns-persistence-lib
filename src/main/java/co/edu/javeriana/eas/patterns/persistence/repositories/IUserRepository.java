package co.edu.javeriana.eas.patterns.persistence.repositories;

import co.edu.javeriana.eas.patterns.persistence.entities.ProfileEntity;
import co.edu.javeriana.eas.patterns.persistence.entities.UserEntity;
import co.edu.javeriana.eas.patterns.persistence.entities.UserStatusEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends CrudRepository<UserEntity, Integer> {

    List<UserEntity> findByProfile(ProfileEntity profile);

    Optional<UserEntity> findByUserCodeAndPassword(String userCode, String password);

    List<UserEntity> findByStatus(UserStatusEntity status);

    @Modifying
    @Transactional
    @Query(value = "update usuario set id_estado =:status where id_usuario =:id", nativeQuery = true)
    void updateStatus(@Param("status") int status, @Param("id") int id);

}