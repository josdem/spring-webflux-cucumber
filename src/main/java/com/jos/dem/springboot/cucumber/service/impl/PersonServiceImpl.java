package com.jos.dem.springboot.cucumber.service.impl;

import java.util.Arrays;

import com.jos.dem.springboot.cucumber.model.Person;
import com.jos.dem.springboot.cucumber.service.PersonService;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonServiceImpl implements PersonService {

  public Flux<Person> getAll(){
    return Flux.fromIterable(
      Arrays.asList(
        new Person("josdem", "joseluis.delacruz@gmail.com"), 
        new Person("tgrip", "tgrip@email.com"), 
        new Person("edzero", "edzero@email.com"),
        new Person("skuarch", "skuarch@email.com"),
        new Person("jeduan", "jeduan@email.com")
      )
    );    
  }

  public Mono<Person> getByNickname(String nickname){
    return Mono.just(new Person(nickname, nickname + "@email.com"));
  }

}