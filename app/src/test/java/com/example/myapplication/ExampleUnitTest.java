package com.example.myapplication;

import org.junit.Test;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void Test01addition_isCorrect() {
        String data = "2+2";
        String expected = "4.0";
        Context context = Context.enter();
        context.setOptimizationLevel(-1);
        Scriptable scriptable = context.initStandardObjects();
        String actual = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
        assertEquals(expected,actual);
    }

    @Test
    public void Test02multiplication_isCorrect() {
        String data = "2*3";
        String expected = "6.0";
        Context context = Context.enter();
        context.setOptimizationLevel(-1);
        Scriptable scriptable = context.initStandardObjects();
        String actual = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
        assertEquals(expected,actual);
    }

    @Test
    public void Test03multiplication_And_Addition_isCorrect() {
        String data = "2*3+2";
        String expected = "8.0";
        Context context = Context.enter();
        context.setOptimizationLevel(-1);
        Scriptable scriptable = context.initStandardObjects();
        String actual = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
        assertEquals(expected,actual);
    }

    @Test
    public void Test04subtraction_isCorrect() {
        String data = "3-2";
        String expected = "1.0";
        Context context = Context.enter();
        context.setOptimizationLevel(-1);
        Scriptable scriptable = context.initStandardObjects();
        String actual = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
        assertEquals(expected,actual);
    }

    @Test
    public void Test05negativeSubtraction_isCorrect() {
        String data = "2-3";
        String expected = "-1.0";
        Context context = Context.enter();
        context.setOptimizationLevel(-1);
        Scriptable scriptable = context.initStandardObjects();
        String actual = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
        assertEquals(expected,actual);
    }

    @Test
    public void Test06negativeSubtraction_isCorrect() {
        String data = "-2-3";
        String expected = "-5.0";
        Context context = Context.enter();
        context.setOptimizationLevel(-1);
        Scriptable scriptable = context.initStandardObjects();
        String actual = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
        assertEquals(expected,actual);
    }

    @Test
    public void Test07division_isCorrect() {
        String data = "6/3";
        String expected = "2.0";
        Context context = Context.enter();
        context.setOptimizationLevel(-1);
        Scriptable scriptable = context.initStandardObjects();
        String actual = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
        assertEquals(expected,actual);
    }

    @Test
    public void Test08calculation_isCorrect() {
        String data = "6/3+8-12*3-21+14/9";
        String expected = "-45.4";
        Context context = Context.enter();
        context.setOptimizationLevel(-1);
        Scriptable scriptable = context.initStandardObjects();
        String actual = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
        assertEquals(expected,actual);
    }

    @Test
    public void Test09zeroes_isCorrect() {
        String data = "0+0";
        String expected = "0.0";
        Context context = Context.enter();
        context.setOptimizationLevel(-1);
        Scriptable scriptable = context.initStandardObjects();
        String actual = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
        assertEquals(expected,actual);
    }

    @Test
    public void Test10null_isCorrect() {
        String data = null;
        String expected = "0";
        Context context = Context.enter();
        context.setOptimizationLevel(-1);
        Scriptable scriptable = context.initStandardObjects();
        String actual = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
        assertEquals(expected,actual);
    }//test fails because of library used to perform calculations
}