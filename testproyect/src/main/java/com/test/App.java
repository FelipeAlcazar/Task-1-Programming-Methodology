package com.test;

import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/*********************************************************************
*
* Class Name: App
* Author/s name: Felipe Alcázar and Elena Megía.
* Class description: In this class we execute de program
*
**********************************************************************
*/

public class App 
{
 final static Scanner sc = new Scanner(System.in);
 /*********************************************************************
*
* Method name: main
*
* Description of the Method: In this method we inicializa the program and call the method
* getTimeFileAndOutput with which we are going to create the excel.
*
* Checked Exceptions, we use two exceptions:
* IOException: When there is an error in input or output.
* InvalidFormatException:  is used when the underlying problem appears to be that of bad 
* formatting of a value to deserialize.
*
*********************************************************************/
    
    public static void main( String[] args ) throws IOException, InvalidFormatException
    {
        int[] sizeN={100,500,1000,5000,8000,9000,10000,11000,20000,50000}; //It is one-dimensional array with the values of the sizes of the arrays of the program.
        System.out.println("Welcome to the program.");
        System.out.println("Choose the measure of time you want: 1 for nano, 2 for mili.");
        int number=chooseTime();
        //1 for nano, any other number for millis
        Array.getTimeFileAndOutput(sizeN,number);
    }
 
  /*********************************************************************
*
* Method name: chooseTime
*
* Description of the Method: In this method we ask if you want the time in nano or mili.
*
* Return value: int, number, number=1 -> nano number=2->mili
*
*********************************************************************/
  public static int chooseTime(){
        int number=0;
        
        number=sc.nextInt();
        while (number != 1 && number != 2) {
            System.out.print("Introduce a number between 1 and 2");
            number = sc.nextInt();
            }
            return number;
    }
 
}
