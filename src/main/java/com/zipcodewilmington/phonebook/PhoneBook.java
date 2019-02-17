package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook { // Class signature

    private String name; // Instance variable
    private ArrayList<String> listNumbers; // Instance variable

    //TreeMap<String, ArrayList<String>> directory; // Instance Object
    TreeMap<String, ArrayList> directory; // Instance Object

    public String removeFirstLastStrings( String str ){
        return str.substring(1,str.length()-1);
    }


    public PhoneBook(){
        this.directory = new TreeMap<String, ArrayList>();
    }

    // Adds an entry to the composite associate data type
    public void add(String name, String number) { // Method signature (SETTER)
        this.listNumbers = new ArrayList<String>();
        if (directory.size() > 0 ){
            if( !directory.containsKey(name) ){
                listNumbers.add(number);
                directory.put(name,listNumbers);
            }
            else{
                if (!directory.get(name).contains(number)){
                    listNumbers.add( removeFirstLastStrings( String.valueOf(directory.get(name)) )) ;
                    listNumbers.add( number );
                    directory.put(name,listNumbers);
                }
                else {

                }
            }
        }
        else {
            listNumbers.add(number);
            directory.put(name,listNumbers);
        }
    }

    // Removes an entry to the composite associate data type
    public void remove(String name){ // Method signature (SETTER)
        if(directory.size() > 0){
            directory.remove(name);
        }
    }

    // Returns a phone number for the respective input name
    public String lookup(String name){ // Method signature (GETTER)
        if(directory.size() > 0){
            return removeFirstLastStrings(directory.get(name).toString());
        }
        return null;
    }

    // Returns a name for the respective input phoneNumber
    public String reverseLookup(String number){ // Method signature (GETTER)
        if(directory.size() > 0){
            for ( Map.Entry s: directory.entrySet() ) {
                if( ((ArrayList<String>)s.getValue()).contains(number) ){
                    return s.getKey().toString();
                }
            }
        }
      return null;
    }

    // Print a human-readable list of all entries (names and phone numbers) in alphabetical order.
    public String display(){ // Method signature (GETTER)
        String container = "";
        for ( Map.Entry s : directory.entrySet() ) {
            container += s.getKey() + " " + removeFirstLastStrings(s.getValue().toString()) + "\n";
        }
        return container.substring(0,container.length()-1);
    }

    public ArrayList<String> flattenCollection( Collection collection ){
        ArrayList<String> container = new ArrayList<String>();
        for (int i = 0; i < collection.size(); i++) {
            ArrayList<String> xx = (ArrayList<String>)collection.toArray()[i];
            for (int j = 0; j < xx.size(); j++) {
                container.add( xx.get(j) );
            }
        }
        return container;
    }

    public static void main(String[] args) {
    }

}
