/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.mycompany.eventmanager.Model.EventManager;


/**
 *
 * @author alex
 */
public class TestingClass {
    public static void main(String[] args) {
        testP2R3Exception();
    }
    //   System.out.println("isValid - dd/MM/yyyy with 20130925 = " + DateFormat.isValidFormat("dd/MM/yyyy", "20130925"));
    //    System.out.println("isValid - dd/MM/yyyy with 25/09/2013 = " + DateFormat.isValidFormat("dd/MM/yyyy", "25/09/2013"));
    //   System.out.println("isValid - dd/MM/yyyy with 25/09/2013 12:13:50 = " + DateFormat.isValidFormat("dd/MM/yyyy", "25/09/2013  12:13:50"));

    /*
    EventManager.addEvent("Birthday Party", "12/1/22", "Amsterdam");
    EventManager.addItem(1000, "Intro");
    EventManager.addItem(1230, "Champagne");
    EventManager.addUser("Vasile", "Rows", "09876");
    EventManager.associateUserWithEvent("Vasile", EventManager.getEvents().get(0));
    EventManager.addEvent("Summer Trip to Barcelona", "12/1/22", "Heathrow T5");
    EventManager.addItem(1200, "Airport");
    EventManager.addItem(1500, "TouchDown");
    EventManager.addUser("Ali", "baba", "09876987");
    EventManager.associateUserWithEvent("Vasile", EventManager.getEvents().get(1));
    ArrayList<Event> events = EventManager.getEvents();
*/
    public static void testP2R2EventContains(){
        printResults("testP2R2EventContains");
        EventManager.addEvent("Party at n10", "12/12/22", "London");
         if (EventManager.getEvents().get(0).getTitle().contains("Party at n10")){
            System.out.println("Result>>>> Pass");
        } else{
            System.out.println("Result>>>> Fail");
        }
    }
    public static void testP2R2EventAddedTwice(){
        int expectedSize = 1;
        EventManager.addEvent("Party at n10", "12/12/22", "London");
        EventManager.addEvent("Party at n10", "12/12/22", "London");
        if (EventManager.getEvents().size() == expectedSize){
            System.out.println("Result>>>> Pass");
        } else{
            System.out.println("Result>>>> Fail");
        }
    }
    public static void testP2R2EventSizeIncreses(){
        int expectedSize = 2;
        EventManager.addEvent("Party at n10", "12/12/22", "London");
        EventManager.addEvent("Party at n10", "12/12/22", "London");
        if (EventManager.getEvents().size() == expectedSize){
            System.out.println("Result>>>> Pass");
        } else{
            System.out.println("Result>>>> Fail");
        }
    }
    public static void testP2R3RemoveEvent(){
        EventManager.addEvent("Party at n10", "12/12/22", "London");
        EventManager.deleteEvent(EventManager.findIndex("Party at n10"));
        if (EventManager.getEvents().size() == 0){
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }


    public static void testP2R3CorrectSize(){
        EventManager.addEvent("Party at n10", "12/12/22", "London");
        EventManager.addEvent("Party at Club", "12/12/22", "Amsterdam");
        EventManager.addEvent("Party at IBIZA", "12/12/22", "Ibiza");
        EventManager.deleteEvent(EventManager.findIndex("Party at n10"));
        if (EventManager.getEvents().size() == 2){
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }
      public static void testP2R3Exception(){
        EventManager.addEvent("Party at n10", "12/12/22", "London");
        EventManager.addEvent("Party at Club", "12/12/22", "Amsterdam");
        EventManager.addEvent("Party at IBIZA", "12/12/22", "Ibiza");
        EventManager.deleteEvent(EventManager.findIndex("Party at n10"));
        if (EventManager.getEvents().get(2).getTitle().contains("Something")){
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public static void printResults(String test){
        System.out.println("Test :" + test);
    }
}
