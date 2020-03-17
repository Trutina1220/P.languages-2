package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class MethodArray {
    public static int[] inputArrayAditive(int lenght) {
        int[] myNum = new int[lenght];
        Scanner myobj = new Scanner(System.in);
        boolean flag = false;
        int number;


        for (int i = 0; i < lenght; i++) {
            System.out.println("Enter number " + (i + 1) + " : ");
            number = myobj.nextInt();

            for (int element : myNum) {
                if (element == number) {
                    flag = true;
                }
            }


            if (number < 0 || flag == true) {

                System.out.println("Please enter a non negative number and a unique number");
                break;
            } else {
                myNum[i] = number;
            }


        }
        return myNum;
    }



    public static void aditive(int lenght ) {


        int[] inputArray = inputArrayAditive(lenght);
        int[] myNum = Arrays.copyOf(inputArray,lenght+1) ;
        int highest = 0;
        int secondHighest = 0;
        int additive = 0;

        for (int i = 0; i < myNum.length; i++) {
            if (myNum[i] > highest) {
                highest = myNum[i];
            }


        }

        for (int i = 0; i < myNum.length; i++) {
            if (myNum[i] != highest) {
                if (myNum[i] > secondHighest) {
                    secondHighest = myNum[i];
                }
            }
        }

        for (int i = 0; i < myNum.length; i++) {
            if (secondHighest + myNum[i] == highest) {
                additive = myNum[i];
            }
        }


        for (int i = 0; i < myNum.length; i++) {
            if (myNum[i] == highest) {
                for (int j = myNum.length - 1; j > i + 1; j--) {
                    myNum[j] = myNum[j - 1];
                }

                myNum[i] = secondHighest;
                myNum[i + 1] = additive;
            }
        }

        for (int i = 0; i < myNum.length; i++) {
            System.out.print(myNum[i] + " , ");
        }

    }


    public static int[] inputArray(int lenght) {
        int[] myNum = new int[lenght];
        Scanner myobj = new Scanner(System.in);

        for (int i = 0; i < lenght; i++) {
            System.out.println("Enter number " + (i + 1) + " : ");
            myNum[i] = myobj.nextInt();
        }
        return myNum;
    }

    public static void shifting(int lenght) {
        int[] myNum = inputArray(lenght);
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter ROT: ");
        int rOT = scan.nextInt();


        for (int a = 0; a <rOT;a++) {

            int lastNumber = myNum[myNum.length - 1];

            for (int i = myNum.length - 1; i > 0; i--) {
                myNum[i] = myNum[i - 1];
            }

            myNum[0] = lastNumber;
//
        }
        for (int i = 0 ;i < myNum.length;i++)
        {
            System.out.print(myNum[i]+" , ");
        }

    }

    public static int[][][] inputMatrix(int lenght)
    {
        Scanner scan  = new Scanner(System.in);
        int number;
        int matrix [][][]  = new int[lenght][1][lenght];
        for (int i = 0 ; i <lenght ; i++ )
        {
            for (int j = 0 ; j<1;j++)
            {
                for (int k = 0 ; k < lenght;k++)
                {
//                     for checking position
//                     System.out.println(i+" "+j+ " "+k);

                    System.out.println("Enter a number : ");
                    number = scan.nextInt();
                    matrix[i][j][k]= number;

                }
            }
        }
        return matrix;


    }

    public static void symmetricMatrix()
    {
        int matrix [][][] = inputMatrix(3);
        if (matrix[0][0][1]==matrix[1][0][0] && matrix[0][0][2] == matrix[2][0][0] && matrix[1][0][2]==matrix[2][0][1])
        {
            System.out.println("Squared Matrix!!!");;
        }
        else
        {
            System.out.println("This is not a square matrix");
        }
    }


    public static void generateSquare(int n)
    {
        int[][] magicSquare = new int[n][n];

        // Initialize position for 1
        int i = n/2;
        int j = n-1;

        // One by one put all values in magic square
        for (int num=1; num <= n*n; )
        {
            if (i==-1 && j==n) //3rd condition
//                if the value of i is equal to -1 and j is equal to i , modify the j = n-2 and set the i into 0
            {
                j = n-2;
                i = 0;
            }
            else
            {
                //1st condition helper if next number
                // goes to out of square's right side
//                when moving to the right side , if its out of bound , it will automatically goes to the 0 column
                if (j == n)
                    j = 0;

                //1st condition helper if next number is
                // goes to out of square's upper side
//                if its going up , and out of bound , it will automaticlly set the row into 0 , basiclly wrapping it

                if (i < 0)
                    i=n-1;
            }

            //2nd condition
//            if theres already a number in the first condition , from that placed number , go left 2 times , and
//            go down 1 times
            if (magicSquare[i][j] != 0)
            {
                j -= 2;
                i++;
                continue;
            }
            else
                //set number

                magicSquare[i][j] = num++;

            //1st condition
//            condition on making the square , from the first number , go up once , then go to the right once
            j++;  i--;
        }

        // print magic square
        System.out.println("The Magic Square for "+n+":");
        System.out.println("Sum of each row or column "+n*(n*n+1)/2+":");
        for(i=0; i<n; i++)
        {
            for(j=0; j<n; j++)
                System.out.print(magicSquare[i][j]+" ");
            System.out.println();
        }
    }




}
