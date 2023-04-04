package myy803.springboot.sb_tutorial_3_thymeleaf.dao;

import myy803.springboot.sb_tutorial_3_thymeleaf.entity.Thesis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThesisDAO extends JpaRepository<Thesis, Integer> {

    public Thesis findById(int theId);

}
