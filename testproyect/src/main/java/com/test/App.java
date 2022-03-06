package com.test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InvalidFormatException
    {
        int[] sizeN={100,500,1000,5000,8000,9000,10000,11000,20000,50000};
        
        //1 for nano, any other number for millis
        Array.getTimeFileAndOutput(sizeN,1);
    }
}
