package com.github.bhrother.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping("/")
class IndexController {

  @Value('${users.url}')
  String userUrl

  @Autowired
  RestTemplate restTemplate

  @GetMapping
  Object home() {
    restTemplate.getForObject(userUrl, Object)
  }
}
