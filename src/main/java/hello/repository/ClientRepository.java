package hello.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hello.entity.ClientEntity;



@Repository
public interface ClientRepository extends CrudRepository<ClientEntity, Long> {

}