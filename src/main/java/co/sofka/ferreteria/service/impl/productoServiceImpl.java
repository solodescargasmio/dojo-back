package co.sofka.ferreteria.service.impl;

import co.sofka.ferreteria.domain.producto;
import co.sofka.ferreteria.repository.IproductoRepository;
import co.sofka.ferreteria.service.IproductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class productoServiceImpl implements IproductoService{
    @Autowired
    private IproductoRepository iproductoRepository;

    @Override
    public Flux<producto> findAll() {
        System.out.println("dentro getmapping");
        return this.iproductoRepository.findAll();
    }

    @Override
    public Mono<producto> findById(String id) {
        return this.iproductoRepository.findById(id);
    }

    @Override
    public Mono<producto> save(producto pDTO) {
        return this.iproductoRepository.save(pDTO);
    }

    @Override
    public Mono<producto> delete(String id) {
        return this.iproductoRepository.findById(id)
                .flatMap(p->this.iproductoRepository.deleteById(id).thenReturn(p));
    }

    @Override
    public Mono<producto> update(String id, producto pDTO) {
        return this.iproductoRepository.findById(id)
                .flatMap(p->{
                    p.setId(id);
                    p.setNombre(pDTO.getNombre());
                    p.setPrecio(pDTO.getPrecio());
                    return save(p);
                }).switchIfEmpty(Mono.empty());
    }
}
