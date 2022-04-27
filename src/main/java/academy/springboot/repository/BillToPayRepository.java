package academy.springboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import academy.springboot.domain.BillToPay;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BillToPayRepository extends CrudRepository<BillToPay, UUID> { }