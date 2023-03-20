package com.zenika.vhr.example.presentation;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/example")
public class ExampleController {

    public ExampleController() {

    }
    @GetMapping(value = "/poke")
    public ResponseEntity<Void> pokeBdd() {
        return ResponseEntity.ok("poke").status(HttpStatus.OK).build();
    }
}
