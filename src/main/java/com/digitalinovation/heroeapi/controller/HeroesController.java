package com.digitalinovation.heroeapi.controller;


import com.digitalinovation.heroeapi.document.Heroes;
import com.digitalinovation.heroeapi.repository.HeroesRepository;
import com.digitalinovation.heroeapi.service.HeroeService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.digitalinovation.heroeapi.constants.HeroesConstant.HEROES_ENDPOINT_LOCAL;

@RestController
@Slf4j
public class HeroesController {
	@Autowired
    private HeroeService heroeService;
	
    private static final org.slf4j.Logger loggi = org.slf4j.LoggerFactory.getLogger(HeroesController.class);

//
//    public HeroesController(HeroeService heroeServicey) {
//        this.heroeService = heroeService;
//    }

    @GetMapping(HEROES_ENDPOINT_LOCAL)
    public Flux<Heroes> getAllHeroes(){
        loggi.info("Recuperando todos os Heróis");
        return heroeService.findAll();
    }
    @GetMapping(HEROES_ENDPOINT_LOCAL+"/id")
    public Mono<ResponseEntity<Heroes>>findById(@PathVariable String id){
        loggi.info("Buscando o Herói com id {}", id);
        return heroeService.findById(id)
                .map((item)-> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mono<Heroes> criarHero(@RequestBody Heroes heroe){
        loggi.info("Criando um novo Herói");
        return heroeService.save(heroe);
    }

    @DeleteMapping(HEROES_ENDPOINT_LOCAL+"/id")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Mono<HttpStatus> deleteById(@PathVariable String id){
        heroeService.deleteByIdHero(id);
        loggi.info("Deletando Heroi de ID {}", id);
        return Mono.just(HttpStatus.NO_CONTENT);
    }
}
