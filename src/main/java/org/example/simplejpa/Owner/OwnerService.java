package org.example.simplejpa.Owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    private final OwnerRepo repo;

    @Autowired
    public OwnerService(OwnerRepo repo) {
        this.repo = repo;
    }

    public List<Owner> getOwners(){
        return repo.findAll();
    }

    public Owner getOwnerById(long id) {
        return repo.findById(id).orElse(null);
    }

    public Owner saveOwner(Owner owner) {
        return repo.save(owner);
    }

    public void deleteOwnerById(long id) {
        repo.deleteById(id);
    }
}
