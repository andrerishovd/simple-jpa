package org.example.simplejpa.Owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {
    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable long id){
        return new ResponseEntity<>(ownerService.getOwnerById(id), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Owner>> getOwners(){
        return new ResponseEntity<>(ownerService.getOwners(),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Owner> createOwner(@RequestBody Owner owner){
        return new ResponseEntity<>(ownerService.saveOwner(owner),HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOwnerById(@PathVariable long id){
        ownerService.deleteOwnerById(id);
        return new ResponseEntity<>("your shit is gone", HttpStatus.OK);
    }
}
