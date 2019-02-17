package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    @Test
    public void addTest(){
        // Given
        String name = "Zebra";
        String phoneNumber = "111-222-3333";
        String expected = name;
        PhoneBook phoneBook = new PhoneBook();
        // When
        phoneBook.add(name,phoneNumber);
        String actual = phoneBook.reverseLookup(phoneNumber);

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void removeTest(){
        // Given
        String name = "Zebra";
        String phoneNumber = "111-222-3333";
        String expected = null;
        PhoneBook phoneBook = new PhoneBook();
        // When
        phoneBook.remove(name);
        String actual1 = phoneBook.lookup(name);
        String actual2 = phoneBook.lookup(phoneNumber);

        //Then
        Assert.assertEquals(expected,actual1);
        Assert.assertEquals(expected,actual2);
    }

    @Test
    public  void lookupTest(){
        // Given
        String name = "Zebra";
        String phoneNumber = "111-222-3333";
        String expected = phoneNumber;
        PhoneBook phoneBook = new PhoneBook();
        // When
        phoneBook.add(name,phoneNumber);
        String actual = phoneBook.lookup(name);

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void reverseLookupTest(){
        // Given
        String name = "Zebra";
        String phoneNumber = "111-222-3333";
        String expected = name;

        // When
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(name,phoneNumber);

        String actual = phoneBook.reverseLookup( phoneNumber );
        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void diplayTest(){
        // Given
        String name1 = "Dog";
        String phoneNumber1 = "222-444-4444";
        String name2 = "Zebra";
        String phoneNumber2 = "111-222-3333";
        String expected = name1 + " " + phoneNumber1 + "\n" +
                          name2 + " " + phoneNumber2;
        // When
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(name1, phoneNumber1);
        phoneBook.add(name2, phoneNumber2);

        String actual = phoneBook.display();

        Assert.assertEquals(expected,actual);
    }
}
