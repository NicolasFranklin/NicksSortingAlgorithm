import java.io.*;
/**
 * @(#)NickSortingRoutineEx.java
 *
 * NickSortingRoutineEx application
 *
 * @author 
 * @version 1.00 2015/11/20
 */
 
public class NickSortingRoutineEx 
{
	
    public static void main(String[] args) throws Exception
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Needed to get input from user
    	
    	System.out.print(" Enter the number of data points: ");
    	int length=Integer.parseInt(br.readLine());
    	
		int[] array = new int [length];
    	
    	for (int i=0; i<array.length; i++)
    	{
    		System.out.print("Enter value: ");
    		array[i]=Integer.parseInt(br.readLine());
    	}
    	
   		boolean loopAgain;
    	
		do
		{
    	
    		loopAgain=false;
    	
	    	for (int i=0; i<array.length-1; i++)
	    	{
	    		
	    		if(array[i]>array[i+1])
	    		{
	    			
	    			int temp = array[i];
	    			array[i]=array[i+1];
	    			array[i+1]=temp;
	    			
	    			loopAgain=true;
	
	    		}
				System.out.print(array[i]+" ");
	    	}
	    	
	    	System.out.println(array[length-1]);
	    	
	    	//new line
	    	System.out.println("\n");
	    	
    	}while(loopAgain);
    	
    	
    	
	System.out.println("	Statistical Information:   ");
	System.out.println(" ------------------------------------------------ ");
	
	//MEAN
	double sum = 0.000;
  	for (int i=0; i < array.length; i++)
    	sum = sum + array[i];
    double avg = sum/array.length;	
	
	System.out.println(" Arithmetic Mean: "+avg);
	
	double median = 0.0;
	
	//if odd
	if (length%2==0)  median = (double)  (array[length/2] + array[length/2-1]) / 2;
	else median = array[length/2];	
	
	System.out.println(" Median:	"+median);	
	
	int count2 = 0;
    int count1 = 0;
    int a1 = 0;
    int mode = 0;
    int[] modeArray = new int [20];
    int index = 0;

    for (int i = 0; i < array.length; i++)
    {
		//a1 = array at index
        a1 = array[i];
        //count is reset
        count1 = 0;    
		
		
        for (int j = i + 1; j < array.length; j++)
        {
        	//if array at index1 = array at index 2, count++
        	//index2 runs through the array and count goes up every time the same number is found
            if (a1 == array[j]) count1++;
        }

        if (count1 > count2)
        {
				//index off array that is the current mode        	
                mode = a1;
                //modeArray[index]=a1;
                //index++;
                //count 2 is a placeholder for the amount of times the number is counted
                count2 = count1;
        }
		
		//if there are 2 values that occur the same times
        else if(count1 == count2)
        {
        	
        	//modeArray[index]=a1;
        	//index++;
        	//returns the higher int
            mode = Math.max(mode, a1);
        }
    }
	
	if (count2 == 0)
		System.out.println(" Mode:			NO MODE");
	else if (count2 != 0)
		System.out.println(" Mode:			"+mode);
		
/*    else if (count2 != 0)
	{
		System.out.print(" MODE: ");
		
		for (int i = 0; i < modeArray.length; i++)
    	{
    	
	    	int prevNum = 0;
	    	int curNum = 0;
	    	
	    	curNum = modeArray[i];
	    	
	    	if (curNum != prevNum)	
				System.out.print(modeArray[i]+" ");
				
			//System.out.println("Cur:" + curNum + "rev: " +prevNum);	
				
			prevNum = curNum;
    	}	
	}
		System.out.println("");
*/	

	double point = 0.000;
	for (int i=0; i < array.length; i++)
    	point = point + ((array[i]-avg)*(array[i]-avg));
    	
    double standDev = Math.sqrt(point/(length-1));
	
	System.out.println(" Standard Deviation: "+standDev);
    	
    } 
    
}
