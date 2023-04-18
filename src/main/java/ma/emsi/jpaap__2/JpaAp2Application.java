package ma.emsi.jpaap__2;

import ma.emsi.jpaap__2.entities.Patient;
import ma.emsi.jpaap__2.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaAp2Application implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaAp2Application.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i <100 ; i++) {
           patientRepository.save(
                   new Patient(null,"hafsae",new Date(),Math.random()>0.5?true:false,(int)(Math.random()*100)));
        }

        Page<Patient> patients = patientRepository.findAll(PageRequest.of(0,10  ));
        System.out.println("total page :"+patients.getTotalPages());
        System.out.println(" total element"+patients.getTotalElements());
        System.out.println("total numero"+patients.getNumber());
        List<Patient> content = patients.getContent();
        Page<Patient> byMalade = patientRepository.findByMalade(true, PageRequest.of(0,4));
        List<Patient> patientList=patientRepository.chercherPatients("%a",40);
        byMalade.forEach(p->{
            System.out.println("========================================");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getDatenaissance());
            System.out.println(p.getScore());
        });
        System.out.println("---------------");
        Patient patient = patientRepository.findById(1L).orElse(null);
        if (patient!=null)
        {
            System.out.println(patient.getNom());
            System.out.println(patient.isMalade());
        }
      //  else
        //{
          //  System.out.println("hello mr");
        //}
        patient.setScore(870);    //modifier
        patientRepository.save(patient);
        //patientRepository.deleteById(1L);
    }
    
}
