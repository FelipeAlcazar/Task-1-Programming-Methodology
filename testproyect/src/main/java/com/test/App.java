package com.test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/*********************************************************************
*
* Class Name: App
* Author/s name:
* Release/Creation date:
* Class description: In this class we execute de program
*
**********************************************************************
*/

public class App 
{
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
        
        //1 for nano, any other number for millis
        Array.getTimeFileAndOutput(sizeN,1);
    }
}
