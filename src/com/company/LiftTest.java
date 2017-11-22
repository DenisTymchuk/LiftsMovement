package com.company;

import com.company.Lift;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Oksa on 21.11.2017.
 */
public class LiftTest {
    @DataProvider(name = "test1")
    public static Object[][] primeNumbers() {
        ArrayList<Lift> lifts1 = new ArrayList<>();
        lifts1.add(new Lift(5,9,1,0));
        lifts1.add(new Lift(2,1,2,0));
        lifts1.add(new Lift(7,1,3,4));

        ArrayList<Lift> lifts2 = new ArrayList<>();
        lifts2.add(new Lift(2,4,1,0));
        lifts2.add(new Lift(9,5,2,0));

        ArrayList<Lift> lifts3 = new ArrayList<>();
        lifts3.add(new Lift(2,8,1,0));
        lifts3.add(new Lift(4,4,2,0));
        lifts3.add(new Lift(6,1,3,0));

        return new Object[][] {
                {3, Lift.searchLift(lifts1,6,"DOWN")},
                {2, Lift.searchLift(lifts2, 11, "UP")},
                {1, Lift.searchLift(lifts3, 7, "DOWN")}
        };
    }

    @Test(dataProvider = "test1")
    public void testSearchLift(int expected, int result) {
        assertEquals(expected, result);
    }
}