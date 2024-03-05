import org.example.Student;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StudentTest {
    private List<Student> mahasiswa;

    @BeforeAll
    public void initClass() {mahasiswa = new ArrayList<>();}

    @BeforeEach
    public void initMethod() {
        Student orang1 = new Student("Saya", 21);
        Student orang2 = new Student("Kamu", 23);
        Student orang3 = new Student("Dia", 20);
        mahasiswa.add(orang1);
        mahasiswa.add(orang2);
        mahasiswa.add(orang3);
    }

    @AfterEach
    public void cleanMethod() {
        System.out.println("Running Student Test - After Each");
        mahasiswa.clear();
    }

    @AfterAll
    public void cleanClass() {System.out.println("Running Student Test - After All");}

    @Test
    public void testDataCreation() {
        Assertions.assertFalse(mahasiswa.isEmpty());
    }

    @Test
    public void testStudentEnrollment() {
        mahasiswa.get(0).enrollCourse("PPPL");
        mahasiswa.get(0).enrollCourse("PAD2");
        mahasiswa.get(0).enrollCourse("PSAIT");
        mahasiswa.get(0).enrollCourse("PADM");
        mahasiswa.get(1).enrollCourse("PPPL");
        mahasiswa.get(1).enrollCourse("PAD2");
        mahasiswa.get(1).enrollCourse("PADM");
        mahasiswa.get(2).enrollCourse("PSAIT");

        Assertions.assertEquals(4, mahasiswa.get(0).getEnrolledCourses().size(), "Seharusnya 4");
        Assertions.assertEquals(3, mahasiswa.get(1).getEnrolledCourses().size(), "Seharusnya 3");
        Assertions.assertEquals(1, mahasiswa.get(2).getEnrolledCourses().size(),"Seharusnya 1");
    }

    @Test
    public void testStudentGrade() {
        mahasiswa.get(0).enrollCourse("PADM");
        mahasiswa.get(0).setGrade("PADM", "A");
        mahasiswa.get(1).enrollCourse("PSAIT");
        mahasiswa.get(1).setGrade("PSAIT", "B");
        mahasiswa.get(2).enrollCourse("PPPL");
        mahasiswa.get(2).setGrade("PPPL", "C");

        Assertions.assertEquals("A", mahasiswa.get(0).getGrade("PADM"), "Seharusnya C");
        Assertions.assertEquals("B", mahasiswa.get(1).getGrade("PSAIT"), "Seharusnya C");
        Assertions.assertEquals("C", mahasiswa.get(2).getGrade("PPPL"), "Seharusnya C");
    }

    @Test
    public void testGetName() {
        Assertions.assertEquals("Saya", mahasiswa.get(0).getName());
        Assertions.assertEquals("Kamu", mahasiswa.get(1).getName());
        Assertions.assertEquals("Dia", mahasiswa.get(2).getName());
    }

    @Test
    public void testGetAge() {
        Assertions.assertEquals(21, mahasiswa.get(0).getAge());
        Assertions.assertEquals(23, mahasiswa.get(1).getAge());
        Assertions.assertEquals(20, mahasiswa.get(2).getAge());
    }
}
