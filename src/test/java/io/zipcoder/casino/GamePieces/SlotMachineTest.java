package io.zipcoder.casino.GamePieces;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SlotMachineTest {

    @Test
    public void randNum() {
        Integer actual = SlotMachine.randNum();
        Assert.assertTrue(actual <= 9 && actual >= 0);
    }

    @Test
    public void createMachine() {
        SlotMachine slotMachine = new SlotMachine();

        Integer[][] machine = slotMachine.createMachine();
        for (int i = 0; i < machine.length; i++) {
            for (int j = 0; j < machine.length; j++) {
                Assert.assertTrue((machine[i][j] >= 0) && (machine[i][j] <= 9));
            }
        }
    }

    @Test
    public void printSlots() {
    }
}