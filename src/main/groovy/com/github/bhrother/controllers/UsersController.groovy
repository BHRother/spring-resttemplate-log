package com.github.bhrother.controllers

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UsersController {

  @GetMapping(value = ["/", ""], produces = [MediaType.APPLICATION_JSON_VALUE])
  Object getUser() {
    return [
        firstName: "Bruno",
        lastName: "Rother",
        version: "0.0.1"
    ]
  }
}
