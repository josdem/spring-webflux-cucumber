package com.jos.dem.springboot.cucumber.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Data;

@AllArgsConstructor
@ToString
@NoArgsConstructor
@Data
public class Person {

  private String nickname;
  private String email;

}
