package org.example.simplejpa.Cat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cat")
public class CatController {

    CatService catService;
    @Autowired
    public CatController(CatService catService){
        this.catService=catService;
    }

    @GetMapping
    public ResponseEntity<List<Cat>> getCats(){
        return new ResponseEntity<>(catService.getCats(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cat> getCatById(@PathVariable Long id){
        return new ResponseEntity<>(catService.getCatById(id),HttpStatus.OK);
    }

    @GetMapping("/belowAge/{age}")
    public ResponseEntity<List<Cat>> getCatsBelowAge(@PathVariable int age) {
        return ResponseEntity.ok(catService.getCatsBelowAge(age));
    }

    @PostMapping
    public ResponseEntity<Cat> createCat(@RequestBody Cat cat){
        return new ResponseEntity<>(catService.addCat(cat),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCatById(@PathVariable Long id){
        catService.deleteCatById(id);
        return new ResponseEntity<>("Your cat is deleted",HttpStatus.OK);
    }
}
