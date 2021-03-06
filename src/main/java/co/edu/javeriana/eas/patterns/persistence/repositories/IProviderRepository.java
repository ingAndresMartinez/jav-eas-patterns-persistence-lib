package co.edu.javeriana.eas.patterns.persistence.repositories;

import co.edu.javeriana.eas.patterns.persistence.entities.CategoryEntity;
import co.edu.javeriana.eas.patterns.persistence.entities.ProviderEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IProviderRepository extends CrudRepository<ProviderEntity, Integer> {

    Optional<ProviderEntity> findByIdentificationTypeAndIdentificationNumber(int identificationType, String identificationNumber);

    List<ProviderEntity> findByCategory(CategoryEntity category);

}