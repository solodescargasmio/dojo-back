package co.sofka.ferreteria.repository;

import co.sofka.ferreteria.domain.producto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IproductoRepository extends ReactiveMongoRepository<producto,String> {
    Flux<producto> findAll();

    Mono<producto> findById(String id);
}
