import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StudentGradeTest {

    private final StudentGrade studentGrade =
            new StudentGrade();

    @Test
    void testGradeA() {
        assertEquals("A",
                studentGrade.calculateGrade(85));
    }

    @Test
    void testGradeB() {
        assertEquals("B",
                studentGrade.calculateGrade(75));
    }

    @Test
    void testGradeC() {
        assertEquals("C",
                studentGrade.calculateGrade(65));
    }

    @Test
    void testGradeD() {
        assertEquals("D",
                studentGrade.calculateGrade(55));
    }

    @Test
    void testGradeE() {
        assertEquals("E",
                studentGrade.calculateGrade(40));
    }

    @Test
    void testScoreTidakValid() {
        assertThrows(
                IllegalArgumentException.class,
                () -> studentGrade.calculateGrade(-1)
        );
    }

    @Test
    void testLulus() {
        assertTrue(studentGrade.isPassed(70));
    }

    @Test
    void testBatasMinimalLulus() {
        assertTrue(studentGrade.isPassed(60));
    }

    @Test
    void testTidakLulus() {
        assertFalse(studentGrade.isPassed(59));
    }

    @Test
    void testScoreTidakValidPadaIsPassed() {
        assertThrows(
                IllegalArgumentException.class,
                () -> studentGrade.isPassed(101)
        );
    }
}