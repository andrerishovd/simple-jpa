package org.example.simplejpa.Profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    private final ProfileRepo repo;

    @Autowired
    public ProfileService(ProfileRepo repo) {
        this.repo = repo;
    }

    public List<Profile> getProfiles() {
        return repo.findAll();
    }

    public Profile getProfileById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Profile saveProfile(Profile profile) {
        return repo.save(profile);
    }

    public void deleteProfile(Long id) {
        repo.deleteById(id);
    }
}
