package org.example.simplejpa.Cat;

import org.example.simplejpa.Owner.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {
    private final CatRepo catRepo;
    private final OwnerService ownerService;


    @Autowired //get me the cat service, in spring go out and look for a object of cat service, if no it will create one,
    public CatService(CatRepo catRepo, OwnerService ownerService){
        this.catRepo = catRepo;
        this.ownerService = ownerService;
    }
    public List<Cat> getCats(){
        return catRepo.findAll();
    }

    public List<Cat> getCatsBelowAge(int age) {
        return catRepo.findCatsByAgeBefore(age);
    }

    public Cat getCatById(long id){
        return catRepo.findById(id).orElse(null); //returns a optional, meaning its not the same thing. we can use or else.
    }
    public Cat addCat(Cat cat){
        return catRepo.save(cat);
    }
    public void deleteCatById(long id){
        catRepo.deleteById(id);
    }
    public Cat updateCat(Cat cat){
        return catRepo.save(cat);
    }
}
