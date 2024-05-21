package com.cotizador.entity.repository;

import com.cotizador.entity.model.DeadLine;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface DeadLineRepository extends MongoRepository<DeadLine, String> {
}
