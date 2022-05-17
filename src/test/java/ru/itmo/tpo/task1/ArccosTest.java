package ru.itmo.tpo.task1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static java.lang.Double.NaN;
import static java.lang.Math.abs;
import static java.lang.Math.acos;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArccosTest {
    private static final TaylorArccos arccos = new TaylorArccos(30);
    private static final TaylorArccos arccosSmallN = new TaylorArccos(2);
    private static final TaylorArccos arccosBigN = new TaylorArccos(200);

    private static boolean almostEquals(double x, double y) {
        return abs(x - y) <= 0.1;
    }

    @ParameterizedTest(name = "value = {0}")
    @ValueSource(doubles = {
            -1.00001,
            2.2345432,
            7.45664522, NaN
    })
    void testWithInacceptableRangePoints(double value) {
        assertThrows(ArgOutOfBorderException.class, () -> arccos.arccos(value));
    }

    @ParameterizedTest(name = "value = {0}")
    @ValueSource(doubles = {
            -0.9999,
            -0.951,
            -0.45,
            -0.10,
            0.0007549,
            0.17231,
            0.32424,
            0.7582,
            0.9999
    })
    void testWithAcceptableRangePoints(double value) throws SmallNException, BigNException, ArgOutOfBorderException {
        assertTrue(almostEquals(acos(value), arccos.arccos(value)));
    }

    @ParameterizedTest(name = "value = {0}")
    @ValueSource(doubles = {
            -1.00000,
            0.00000,
            1.00000,
    })
    void testWithCriticalPoints(double value) throws SmallNException, BigNException, ArgOutOfBorderException {
        assertTrue(almostEquals(acos(value), arccos.arccos(value)));

    }

    @ParameterizedTest(name = "value = {0}")
    @ValueSource(doubles = {
            -1.00000,
            0.00000,
            1.00000,
    })
    void testWithSmallN(double value) {
        assertThrows(SmallNException.class, () -> arccosSmallN.arccos(value));
    }

    @ParameterizedTest(name = "value = {0}")
    @ValueSource(doubles = {
            -1.00000,
            0.00000,
            1.00000,
    })
    void testWithBigN(double value) {
        assertThrows(BigNException.class, () -> arccosBigN.arccos(value));
    }
}