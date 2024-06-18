package bg.softuni.eventsschedulingcaches.chache;

import bg.softuni.eventsschedulingcaches.schaduling.CronScheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private Logger LOGGER= LoggerFactory.getLogger(CronScheduled.class);

    @Cacheable("students")
    public List<StudentDto> getAllStudents(){

        LOGGER.info("Inside getAllStudents");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        LOGGER.info("Returning result from getAllStudents");

        return List.of( new StudentDto("Pesho",32),
        new StudentDto("Ani",22));
    }


    @CachePut("students")

    public List<StudentDto> updateStudents(){

        LOGGER.info("Inside updateStudents");

        return List.of( new StudentDto("Gosho",11),
                new StudentDto("Milena",12));
    }


    @Cacheable(value = "students", key="#name")
    public StudentDto getStudentByName(String name) {
        LOGGER.info("GET STUDENT {}", name);
        return new StudentDto(name, null);
    }
}
