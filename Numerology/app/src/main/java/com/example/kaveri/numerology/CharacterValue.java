package com.example.kaveri.numerology;

/**
 * Created by KAVERI on 7/30/2017.
 */
public class CharacterValue {
    Character character;
    int value;

    public CharacterValue(Character character, int value) {
        this.character = character;
        this.value = value;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CharacterValue{" +
                "character=" + character +
                ", value=" + value +
                '}';
    }
}
