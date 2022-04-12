package co.sofka.ferreteria.service;

import co.sofka.ferreteria.domain.producto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IproductoService {
    Flux<producto> findAll();
    Mono<producto> findById(String id);
    Mono<producto> save(producto pDTO);
    Mono<producto> delete(String id);
    Mono<producto> update(String id,producto pDTO);
}
