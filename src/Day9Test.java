import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Day9Test {
    @BeforeAll
    static void foo(){ //runs before all of the tests (Setting things up)
        System.out.println("foo");
    }

    @BeforeEach
    void bar(){ //runs before each resetting variables etc. for next test.
        System.out.println("bar");
    }

    @Test
     void loadDataTest() throws Exception {
        Day9 tester = new Day9(1);
        List<Long> data = tester.loadData("inputs/day9Test.txt");

        assertEquals(new ArrayList<>(Arrays.asList(13L, 21L)), data, "Should read file contents");
    }

    @Test
    void encryptionWeaknessTest() {
        Day9 tester = new Day9(2);
        List<Long> data = new ArrayList<>(Arrays.asList(1L,2L,3L,7L));
        long weakness = tester.encryptionWeakness(data);

        assertEquals(7L, weakness, "Should find encryption weakness successfully ");
    }
}

