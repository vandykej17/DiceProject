package osu.cse1223;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Project10Test extends Project10 {

    @org.junit.jupiter.api.Test
    void isFiveOfAKind() {
        ArrayList<Integer> dice1 = new ArrayList<Integer>(Arrays.asList(
                0,0,0,0,0,0,5,0,0,0
        ));
        ArrayList<Integer> dice2 = new ArrayList<Integer>(Arrays.asList(
                0,0,0,5,0,0,0,0,0,0
        ));
        ArrayList<Integer> dice3 = new ArrayList<Integer>(Arrays.asList(
                0,0,4,0,1,0,0,0,0,0
        ));
        assertTrue(isFiveOfAKind(dice1));
        assertTrue(isFiveOfAKind(dice2));
        assertFalse(isFiveOfAKind(dice3));
    }

    @org.junit.jupiter.api.Test
    void isFourOfAKind() {
        ArrayList<Integer> dice1 = new ArrayList<Integer>(Arrays.asList(
                0,0,0,0,0,0,5,0,0,0
        ));
        ArrayList<Integer> dice2 = new ArrayList<Integer>(Arrays.asList(
                1,0,0,0,0,0,0,0,0,4
        ));
        ArrayList<Integer> dice3 = new ArrayList<Integer>(Arrays.asList(
                0,0,4,0,1,0,0,0,0,0
        ));
        ArrayList<Integer> dice4 = new ArrayList<Integer>(Arrays.asList(
                0,0,3,0,2,0,0,0,0,0
        ));
        assertFalse(isFourOfAKind(dice1));
        assertTrue(isFourOfAKind(dice2));
        assertTrue(isFourOfAKind(dice3));
        assertFalse(isFourOfAKind(dice4));
    }

    @org.junit.jupiter.api.Test
    void hasThreeOfAKind() {
        ArrayList<Integer> dice1 = new ArrayList<Integer>(Arrays.asList(
                0,0,0,0,0,0,5,0,0,0
        ));
        ArrayList<Integer> dice2 = new ArrayList<Integer>(Arrays.asList(
                1,0,0,0,0,2,0,0,0,2
        ));
        ArrayList<Integer> dice3 = new ArrayList<Integer>(Arrays.asList(
                0,0,3,0,1,0,0,0,0,1
        ));
        ArrayList<Integer> dice4 = new ArrayList<Integer>(Arrays.asList(
                0,0,3,0,2,0,0,0,0,0
        ));
        assertFalse(hasThreeOfAKind(dice1));
        assertFalse(hasThreeOfAKind(dice2));
        assertTrue(hasThreeOfAKind(dice3));
        assertTrue(hasThreeOfAKind(dice4));
    }

    @org.junit.jupiter.api.Test
    void hasPair() {
        ArrayList<Integer> dice1 = new ArrayList<Integer>(Arrays.asList(
                0,0,2,0,0,0,0,0,2,1
        ));
        ArrayList<Integer> dice2 = new ArrayList<Integer>(Arrays.asList(
                1,0,0,0,0,0,0,0,0,4
        ));
        ArrayList<Integer> dice3 = new ArrayList<Integer>(Arrays.asList(
                1,0,1,0,1,0,1,0,1,0
        ));
        ArrayList<Integer> dice4 = new ArrayList<Integer>(Arrays.asList(
                0,0,3,0,2,0,0,0,0,0
        ));
        assertTrue(hasPair(dice1));
        assertFalse(hasPair(dice2));
        assertFalse(hasPair(dice3));
        assertTrue(hasPair(dice4));
    }

    @org.junit.jupiter.api.Test
    void hasTwoPair() {
        ArrayList<Integer> dice1 = new ArrayList<Integer>(Arrays.asList(
                0,0,2,0,0,0,3,0,0,0
        ));
        ArrayList<Integer> dice2 = new ArrayList<Integer>(Arrays.asList(
                2,0,0,0,1,0,0,0,0,2
        ));
        ArrayList<Integer> dice3 = new ArrayList<Integer>(Arrays.asList(
                0,0,2,0,1,0,0,0,2,0
        ));
        ArrayList<Integer> dice4 = new ArrayList<Integer>(Arrays.asList(
                0,0,1,0,2,0,0,1,0,1
        ));
        assertFalse(hasTwoPair(dice1));
        assertTrue(hasTwoPair(dice2));
        assertTrue(hasTwoPair(dice3));
        assertFalse(hasTwoPair(dice4));
    }

    @org.junit.jupiter.api.Test
    void isStraight() {
        ArrayList<Integer> dice1 = new ArrayList<Integer>(Arrays.asList(
                0,0,2,0,0,0,3,0,0,0
        ));
        ArrayList<Integer> dice2 = new ArrayList<Integer>(Arrays.asList(
                1,0,1,1,1,1,0,0,0,0
        ));
        ArrayList<Integer> dice3 = new ArrayList<Integer>(Arrays.asList(
                0,0,1,1,1,1,1,0,0,0
        ));
        ArrayList<Integer> dice4 = new ArrayList<Integer>(Arrays.asList(
                0,0,0,0,0,0,0,1,2,2
        ));
        assertFalse(isStraight(dice1));
        assertFalse(isStraight(dice2));
        assertTrue(isStraight(dice3));
        assertFalse(isStraight(dice4));
    }
}