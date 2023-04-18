package ma.emsi.jpaap__2.repositories;

import ma.emsi.jpaap__2.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    public List<Patient> findByMalade(boolean m);      //select * from Patient where Patient==m
    Page<Patient> findByMalade(boolean m, PageRequest pageable);        //les persnnes qui sont malade ou non avec les pages
    List<Patient> findByMaladeAndScoreLessThan(boolean m , int score);    //toutes les personnes qui sont malade ou pas et inferieur a 40 f score

    List<Patient> findByMaladeIsTrueAndAndScoreLessThan(int score);    //touts les malade pure et le score inférieur a 40 f score
    List<Patient> findByDatenaissanceBetweenAndMaladeIsTrueOrNomLike(Date d1 , Date d2,String mc);
    @Query("select p from Patient p where p.nom  like :x and  p.score<:y")
   // List<Patient> chercherPatiens(@Param("x") Date d1, @Param("y") Date d2, @Param("p") String nom);   //d1==x  d2==y nom==z
    List<Patient> chercherPatients(@Param("x")String nom,@Param("y") int scoreMin);
}
