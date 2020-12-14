package ua.edu.ucu;

import ua.edu.ucu.stream.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author andrii
 */
public class StreamAppTest {
    
    private IntStream intStream;

    @Before
    public void init() {
        int[] intArr = {-1, 0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);
    }
    
    @Test
    public void testStreamOperations() {
        System.out.println("streamOperations");
        int expResult = 42;
        int result = StreamApp.streamOperations(intStream);
        assertEquals(expResult, result);
    }

    @Test
    public void testStreamToArray() {
        System.out.println("streamToArray");
        int[] expResult = {-1, 0, 1, 2, 3};
        int[] result = StreamApp.streamToArray(intStream);
        assertArrayEquals(expResult, result);        
    }

    @Test
    public void testStreamForEach() {
        System.out.println("streamForEach");
        String expResult = "-10123";
        String result = StreamApp.streamForEach(intStream);
        assertEquals(expResult, result);        
    }

    @Test
    public void testStreamMin() {
        int[] intArr = {10, -1, 0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);
        System.out.println("streamMin");
        int expResult = -1;
        int result = intStream.min();
        assertEquals(expResult, result);
    }

    @Test
    public void testStreamMax() {
        System.out.println("streamMax");
        int expResult = 3;
        int result = intStream.max();
        assertEquals(expResult, result);
    }

    @Test
    public void testStreamAverage() {
        System.out.println("streamAverage");
        Double expResult = 1.0;
        Double result = intStream.average();
        assertEquals(expResult, result);
    }

    @Test
    public void testStreamCount() {
        System.out.println("streamCount");
        int expResult = 5;
        long result = intStream.count();
        assertEquals(expResult, result);
    }

    @Test
    public void testStreamSum() {
        System.out.println("streamSum");
        int expResult = 5;
        int result = intStream.sum();
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testStreamCheckEmpty() {
        System.out.println("streamCheckEmpty");
        int[] intArr = {};
        intStream = AsIntStream.of(intArr);
        intStream.sum();
    }
}
