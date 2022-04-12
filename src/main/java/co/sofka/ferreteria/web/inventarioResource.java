package co.sofka.ferreteria.web;


import co.sofka.ferreteria.domain.*;
import co.sofka.ferreteria.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin("*")
public class inventarioResource {

    @Autowired
    private IproductoService iproductoService;

    @GetMapping("/producto/{id}")
    private Mono<producto> findProductoById(@PathVariable("id") String id) {
        return this.iproductoService.findById(id);

    }

    @GetMapping(value = "/producto")
    private Flux<producto> findAllProducto() {
        System.out.println("dentro getmapping");
        return this.iproductoService.findAll();
    }
    @PostMapping("/producto")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<producto> saveProducto(@RequestBody producto pDTO) {
        return this.iproductoService.save(pDTO);
    }
    @DeleteMapping("/producto/{id}")
    private Mono<producto> deleteControl(@PathVariable("id") String id) {
        return this.iproductoService.delete(id);

    }




}
