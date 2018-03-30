package com.jos.dem.springboot.cucumber.service;

import java.util.stream.Stream;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.jos.dem.springboot.cucumber.model.Person;

public class PersonService {

  Flux<Person> getAll(){
    return Stream.of("josdem", "tgrip", "edzero")
    .map(nickname -> new Person(nickname, nickname + "@email.com"));    
  }

  Mono<Person> getByNickname(String nickname){
    return new Person(nickname, nickname + "@email.com");
  }

}