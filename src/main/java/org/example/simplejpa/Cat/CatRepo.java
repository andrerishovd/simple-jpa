package org.example.simplejpa.Cat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepo extends JpaRepository<Cat,Long> { // this is the jpa repositroy interface which is now gonna manage Cat.
    List<Cat> findCatsByAgeBefore(int age);
}
