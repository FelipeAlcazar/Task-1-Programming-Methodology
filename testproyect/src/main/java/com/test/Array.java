package com.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.*;

/*********************************************************************
*
* Class Name: Array
* Author/s name:
* Release/Creation date:
* Class description: In this class we have the entire program, what we do is take the size that the other 
* class passes us and create three different arrays, one random, one in descending order and the other in ascending order.
* We calculate the time it takes to do a series of processes and transfer the data in an excel.
**********************************************************************
*/

public class Array {
    static Row row;
    static Map<Long, Object[]> data= new TreeMap<Long, Object[]>();
    static int excelrow=1;
    
    /*********************************************************************
    * Method name: getWorkBook
    *
    * Description of the Method: This method introduces new values in the file WorkBook.xlsx .
    *
    * Return value: WorkbookFactory.create(inp), we create a new file input.
    *
    * Required Files: We use a file call WorkBook.xlsx
    *
    * Checked Exceptions, we use two exceptions:
    * IOException: When there is an error in input or output.
    * InvalidFormatException:  is used when the underlying problem appears to be that of bad 
    * formatting of a value to deserialize.
    *********************************************************************/

    public static Workbook getWorkBook() throws InvalidFormatException, IOException{
        InputStream inp = new FileInputStream("WorkBook.xlsx");
        return WorkbookFactory.create(inp);
    }
    /*********************************************************************
    *
    * Method name: keyboardArray
    *
    * Description of the Method: In this method we create a one-dimensional array with input of the keyboard.
    *
    * Calling arguments: Int size, we introduce the size of the array we want to create.
    *
    * Return value: int[] vector, we return the one-dimensional array that we created.
    *
    *********************************************************************/
    public static int[] keyboardArray(int size){
        int[] vector=new int[size];
        for(int i=0;i<vector.length;i++){
            vector[i]=leer.entero();
        }

        return vector;
    }

    /*********************************************************************
    *
    * Method name: fileArray
    *
    * Description of the Method: This method read a file and convert the values to an rray .
    *
    * Calling arguments: String fileName, its the file that we are going to read.
    *
    * Return value: toIntArray(integers), we convert the integers into an array.
    *
    * Required Files: We need the file the program is goint to read.
    *
    * IOException: When there is an error in input or output.
    *
    *********************************************************************/
    
    public static int[] fileArray(String fileName){
        Path filePath = Paths.get(fileName);
        Scanner scanner;
        List<Integer> integers = new ArrayList<>();

        try {
            scanner = new Scanner(filePath);
            
            while (scanner.hasNext()) {
                if (scanner.hasNextInt())
                    integers.add(scanner.nextInt()); 
                else
                    scanner.next();
            }
        } catch (IOException e) {
            System.out.println("File not Found. Check the fileName");
        }

        return toIntArray(integers);
    }
    
 
    /*********************************************************************
    *
    * Method name: randomArray
    *
    * Description of the Method: In this method we create an array with random numbers.
    *
    * Calling arguments: int size, it is the size of the array we are going to create
    * int ls, it is the maximum value that a number can take in the array.
    *
    * Return value: int[], vector, we return a one-dimensional array.
    *
    *********************************************************************/

    public static int[] randomArray(int size, int ls){
        int[] vector=new int[size];

        for(int i=0;i<vector.length;i++){
            vector[i]=(int) ((Math.random()*(ls-0))+0);
        }

        return vector;
    }
    
    /*********************************************************************
    *
    * Method name: insertionSort.
    *
    * Description of the Method: Values from the unsorted part are picked and placed at the correct position in the sorted part.
    *
    * Calling arguments: int[], vector, we call a one-dimensional array.
    *
    * Return value: int[] vector, an ordered vector.
    *
    *********************************************************************/
    
    
    public static int[] insertionSort(int[] vector){
        int val, position, n;
        n=vector.length;
        for(int i=1;i<n;i++){
            val=vector[i];
            position=i;

            while(position>0 && vector[position-1] > val){
                vector[position]=vector[position-1];
                position--;
            }

            vector[position]=val;
        }

        return vector;
    }

    
    /*********************************************************************
    *
    * Method name: selectionSort.
    *
    * Description of the Method: It is a comparison algorithm in which the vector is divided into two parts.
    *
    * Calling arguments: int[], vector, we call a one-dimensional array.
    *
    * Return value: int[] vector, an ordered vector.
    *
    *********************************************************************/
    
    public static int[] selectionSort(int[] vector){
        int aux, idx_min;
        int n=vector.length;

        for(int i=0;i<n-1;i++){
            idx_min=i;
            for(int j=i+1;j<n;j++){
                if(vector[j]<vector[idx_min]) idx_min=j;
            }
            aux=vector[i];
            vector[i]=vector[idx_min];
            vector[idx_min]=aux;
        }

        return vector;
    }

    /*********************************************************************
    *
    * Method name: bubbleSort.
    *
    * Description of the Method: It is a method that repeatedly swapp the adjacent elements if they are in wrong order.
    *
    * Calling arguments: int[], vector, we call a one-dimensional array.
    *
    * Return value: int[] vector, an ordered vector.
    *
    *********************************************************************/
    
    
    public static int[] bubbleSort(int[] vector){
        int aux;
        int n=vector.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<(n-1-i);j++){
                if(vector[j]>vector[j+1]){
                    aux=vector[j];
                    vector[j]=vector[j+1];
                    vector[j+1]=aux;
                }
            }
        }

        return vector;
    }

    /*********************************************************************
    *
    * Method name: toArrayList.
    *
    * Description of the Method: Convert one-dimensional array to a list.
    *
    * Calling arguments: int[], vector, we call a one-dimensional array.
    *
    * Return value: ArrayList list1, it's a list with the numbers of the array.
    *
    *********************************************************************/
    
    public static List<Integer> toArrayList(int[] vector){
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        for(int i : vector) list1.add(i);  

        return list1;
    }
    
    /*********************************************************************
    *
    * Method name: toIntArray.
    *
    * Description of the Method: Convert a list to a one-dimensional array.
    *
    * Calling arguments: List<Integer> integers, we call a list.
    *
    * Return value: int[], ret, it's an array.
    *
    *********************************************************************/
    
    public static int[] toIntArray(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

    /*********************************************************************
    *
    * Method name: copy.
    *
    * Description of the Method: Generate a copy of a one-dimensional array.
    *
    * Calling arguments: int[], vector, it's a one-dimensional array.
    *
    *********************************************************************/
    
    public static void copy(int[] vector){
    	int [] vector2=Arrays.copyOf(vector, vector.length);
    }

    /*********************************************************************
    *
    * Method name: equal.
    *
    * Description of the Method: Check if an array is equal to another.
    *
    * Calling arguments: int[], vector1, we call a one-dimensional array.
    *                    int[], vector2, we call a one-dimensional array.
    *
    * Return value: boolean equal, if it's true the vectors are equal and if it's false they aren't equal.
    *
    *********************************************************************/
    
    public static Boolean equal(int[] vector1, int[] vector2){
        boolean equal=true;
        if(vector1.length!=vector2.length) equal=false;

        for(int i=0;i<vector1.length-1;i++){
            if(vector1[i]!=vector2[i]){
                equal=false;
                break;
            }
        }

        return equal;
    }

    /*********************************************************************
    *
    * Method name: display.
    *
    * Description of the Method: Print the array.
    *
    * Calling arguments: int[], vector, it's a one-dimensional array.
    *
    *********************************************************************/
    
    public static void display(int[] vector1){
        for(int i=0;i<vector1.length;i++) System.out.print(vector1[i]+" ");
    }

    
    
    public static void generateFile(int N, int ls, String fileName){
    	try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileName),true));
            int [] vector=randomArray(N, ls);
            for(int i=0;i<vector.length;i++){
            	writer.write(Integer.toString(vector[i]));
            	writer.newLine();
            }
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static int[] toDecreasingOrder(int[] vector){
        ArrayList<Integer> list1 =new ArrayList<Integer>(Array.toArrayList(vector));
        Collections.sort(list1, Collections.reverseOrder());
        return Array.toIntArray(list1);
    }

    public static int[] toAscendingOrder(int[] vector){
        Arrays.sort(vector);
        return vector;
    }
    
    public static void checkTimeAscendingNano(int[] vector, int i){
        long nano;
        Array.toAscendingOrder(vector);
        System.out.print(i+" |  "+"AO |");
        nano=System.nanoTime();
        Array.bubbleSort(vector);
        long bubbleTime=System.nanoTime()-nano;
        System.out.print(bubbleTime+"ns |");

        Array.toAscendingOrder(vector);
        nano=System.nanoTime();
        Array.insertionSort(vector);
        long insertionTime=System.nanoTime()-nano;
        System.out.print(insertionTime+"ns |");

        Array.toAscendingOrder(vector);
        nano=System.nanoTime();
        Array.selectionSort(vector);
        long selectionTime=System.nanoTime()-nano;
        System.out.println(selectionTime+"ns |");
        addRow(bubbleTime,insertionTime,selectionTime);
    }

    public static void checkTimeDescendingNano(int[] vector,int i){
        long nano;
        Array.toDecreasingOrder(vector);
        System.out.print(i+" |  "+"DO |");
        nano=System.nanoTime();
        Array.bubbleSort(vector);
        long bubbleTime=System.nanoTime()-nano;
        System.out.print(bubbleTime+"ns |");

        Array.toDecreasingOrder(vector);
        nano=System.nanoTime();
        Array.insertionSort(vector);
        long insertionTime=System.nanoTime()-nano;
        System.out.print(insertionTime+"ns |");

        Array.toDecreasingOrder(vector);
        nano=System.nanoTime();
        Array.selectionSort(vector);
        long selectionTime=System.nanoTime()-nano;
        System.out.println(selectionTime+"ns |");
        addRow(bubbleTime,insertionTime,selectionTime);
    }

    public static void checkTimeRandomNano(int[] vector,int i){
        long nano;
        Array.randomArray(vector.length,vector.length);
        System.out.print(i+" |  "+"NO |");
        nano=System.nanoTime();
        Array.bubbleSort(vector);
        long bubbleTime=System.nanoTime()-nano;
        System.out.print(bubbleTime+"ns |");

        Array.randomArray(vector.length,vector.length);
        nano=System.nanoTime();
        Array.insertionSort(vector);
        long insertionTime=System.nanoTime()-nano;
        System.out.print(insertionTime+"ns |");

        Array.randomArray(vector.length,vector.length);
        nano=System.nanoTime();
        Array.selectionSort(vector);
        long selectionTime=System.nanoTime()-nano;
        System.out.println(selectionTime+"ns |");
        addRow(bubbleTime,insertionTime,selectionTime);
    }
    
    public static void checkTimeAscendingMillis(int[] vector, int i){
        long millis;
        Array.toAscendingOrder(vector);
        System.out.print(i+" |  "+"AO |");
        millis=System.currentTimeMillis();
        Array.bubbleSort(vector);
        long bubbleTime=System.currentTimeMillis()-millis;
        System.out.print(bubbleTime+"millis |");

        Array.toAscendingOrder(vector);
        millis=System.currentTimeMillis();
        Array.insertionSort(vector);
        long insertionTime=System.currentTimeMillis()-millis;
        System.out.print(insertionTime+"millis |");

        Array.toAscendingOrder(vector);
        millis=System.currentTimeMillis();
        Array.selectionSort(vector);
        long selectionTime=System.currentTimeMillis()-millis;
        System.out.println(selectionTime+"millis |");
        addRow(bubbleTime,insertionTime,selectionTime);
    }

    public static void checkTimeDescendingMillis(int[] vector,int i){
        long millis;
        Array.toDecreasingOrder(vector);
        System.out.print(i+" |  "+"DO |");
        millis=System.currentTimeMillis();
        Array.bubbleSort(vector);
        long bubbleTime=System.currentTimeMillis()-millis;
        System.out.print(bubbleTime+"millis |");

        Array.toDecreasingOrder(vector);
        millis=System.currentTimeMillis();
        Array.insertionSort(vector);
        long insertionTime=System.currentTimeMillis()-millis;
        System.out.print(insertionTime+"millis |");

        Array.toDecreasingOrder(vector);
        millis=System.currentTimeMillis();
        Array.selectionSort(vector);
        long selectionTime=System.currentTimeMillis()-millis;
        System.out.println(selectionTime+"millis |");
        addRow(bubbleTime,insertionTime,selectionTime);
    }

    public static void checkTimeRandomMillis(int[] vector,int i){
        long millis;
        Array.randomArray(vector.length,vector.length);
        System.out.print(i+" |  "+"NO |");
        millis=System.currentTimeMillis();
        Array.bubbleSort(vector);
        long bubbleTime=System.currentTimeMillis()-millis;
        System.out.print(bubbleTime+"millis |");

        Array.randomArray(vector.length,vector.length);
        millis=System.currentTimeMillis();
        Array.insertionSort(vector);
        long insertionTime=System.currentTimeMillis()-millis;
        System.out.print(insertionTime+"millis |");

        Array.randomArray(vector.length,vector.length);
        millis=System.currentTimeMillis();
        Array.selectionSort(vector);
        long selectionTime=System.currentTimeMillis()-millis;
        System.out.println(selectionTime+"millis |");
        addRow(bubbleTime,insertionTime,selectionTime);
    }

    public static void addRow(long bubbleTime, long directInsertionTime, long directSelectionTime){
        data.put(Long.valueOf(excelrow),new Object[] { bubbleTime, directInsertionTime, directSelectionTime });
        excelrow++;
    }

    public static void checkFullTimeMillis(int[] vector,int i) throws InvalidFormatException, IOException{
        Array.checkTimeAscendingMillis(vector,i);
        Array.checkTimeDescendingMillis(vector,i);
        Array.checkTimeRandomMillis(vector,i);
        generateFile();
    }

    public static void checkFullTimeNano(int[] vector,int i) throws IOException, InvalidFormatException{
        Array.checkTimeAscendingNano(vector,i);
        Array.checkTimeDescendingNano(vector,i);
        Array.checkTimeRandomNano(vector,i);
        generateFile();
    }

    public static void generateFile() throws IOException, InvalidFormatException{
        Workbook wb=getWorkBook();
        Sheet sheet=wb.getSheetAt(0);

        Set<Long> keyid = data.keySet();
        int rowid = 1;
  
        for (Long key : keyid) {
  
            row = sheet.getRow(rowid++);
            Object[] objectArr = data.get(key);
            int cellid = 2;
  
            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((Long)obj);
            }
        }
        FileOutputStream out = new FileOutputStream(new File("WorkBook.xlsx"));
        wb.write(out);
        out.close();
    }

    public static void getTimeFileAndOutput(int[] vector, int type) throws IOException, InvalidFormatException{

        for(int i=0;i<vector.length;i++){
            int[] vector2=Array.randomArray(vector[i], vector[i]);

            if(type==1) 
                Array.checkFullTimeNano(vector2,vector[i]);
            else 
                Array.checkFullTimeMillis(vector2,vector[i]);
        }
    }
}
