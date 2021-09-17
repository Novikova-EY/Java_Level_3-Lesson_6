package ru.gb.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.gb.task.task6.ArrayToModify;

public class ArrayToModifyTest {
    private Integer[] array = new Integer[]{};
    private ArrayToModify arrayToModify;

    @BeforeEach
    public void init() {
        arrayToModify = new ArrayToModify(array);
    }

    @Test
    public void testToDoArray() {
        Assertions.assertAll(
                () -> {
                    Assertions.assertArrayEquals(
                            new Integer[]{12},
                            arrayToModify.toDoArray(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}));
                },
                () -> {
                    Assertions.assertArrayEquals(
                            new Integer[]{4, 5},
                            arrayToModify.toDoArray(new Integer[]{0, 1, 2, 3, 4, 5}));
                },
                () -> {
                    Assertions.assertArrayEquals(
                            new Integer[]{8, 9, 10},
                            arrayToModify.toDoArray(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
                }
        );
    }

    @Test
    public void testCheckSmallArray() {
        Assertions.assertAll(
                () -> {
                    Assertions.assertTrue(arrayToModify.checkSmallArray(new Integer[]{0, 1, 2}));
                },
                () -> {
                    Assertions.assertTrue(arrayToModify.checkSmallArray(new Integer[]{3, 4}));
                },
                () -> {
                    Assertions.assertTrue(arrayToModify.checkSmallArray(new Integer[]{1}));
                }
        );
    }

    @Test
    public void testCheckNullArray() {
        Assertions.assertTrue(arrayToModify.checkNullArray(new Integer[0]));
    }

    @Test
    public void testToCheckArray() {
        Assertions.assertAll(
                () -> {
                    Assertions.assertEquals(true, arrayToModify.toCheckArray(new Integer[]{1, 1, 1, 4, 4, 1, 4, 4}));
                },
                () -> {
                    Assertions.assertEquals(true, arrayToModify.toCheckArray(new Integer[]{1, 1, 1, 1, 1, 1, 1, 4}));
                },
                () -> {
                    Assertions.assertEquals(true, arrayToModify.toCheckArray(new Integer[]{1, 4, 4, 4, 4, 4, 4, 4}));
                },
                () -> {
                    Assertions.assertEquals(false, arrayToModify.toCheckArray(new Integer[]{1, 1, 1, 1, 1, 1, 1, 1}));
                },
                () -> {
                    Assertions.assertEquals(false, arrayToModify.toCheckArray(new Integer[]{4, 4, 4, 4}));
                },
                () -> {
                    Assertions.assertEquals(false, arrayToModify.toCheckArray(new Integer[]{1, 1, 1, 4, 4, 1, 4, 3}));
                }
        );
    }
}