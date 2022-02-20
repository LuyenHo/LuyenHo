/*~*~*
CIS 22C
Project: Stack ADT

Written by: Ngoc Luyen Ho
IDE: Xcode
*~*/

#include <fstream>
#include <iostream>
#include <string>
#include <cstdlib>
#include <ctime>

using namespace std;

#include "StackADT.h"

void printInfo();
void showTimeStamp();

int main()
{
    string filenames[] = {"numbers1.txt", "numbers2.txt", "numbers3.txt", ""};
    
    printInfo();
    for (int i = 0; filenames[i] != ""; i++)
    {
           // call a function to process the input file using a stack
         cout << endl;
        Stack<int> s;
        int value;
        ifstream inFile;
        inFile.open(filenames[i]);
        if (!inFile) {
            cout << "Input file: " << filenames[i] << " not found!\n";
            exit(EXIT_FAILURE);
        }
        else {
            cout << "Input File: " << filenames[i] << endl;
            while (inFile >> value){
                if(value > 1) s.push(value);
                else if (value == 1 && s.getLength() != 0) cout << "Top: " << s.peek() << endl;
                else if (value == 1 && s.getLength() == 0) cout << "Top: Empty\n";
                else if (value == 0) {
                    cout << "Count: " << s.getLength() << endl;
                }
                else if (s.getLength() < abs(value)) cout << "Error\n";
                else {
                    cout << "Stack: ";
                    for(int i = 0; i < abs(value); i++)
                    cout << s.pop() << " ";
                    cout << endl;
                }
            }
        }
        inFile.close();
        cout << "Stack: ";
        while (!s.isEmpty()){
                cout << s.pop() << " ";
                }
        cout << endl;
    }
    //showTimeStamp();
    return 0;
}

/*~*~*~*~*~*~
This function displays the project's title
*~*/
void printInfo()
{
    cout << " ~*~ Project: Stack ADT ~*~ " << endl;
}

/*~*~*~*~*~*~
   This function displays the current date and time
*~*/
void showTimeStamp()
{
    time_t timeval = time(0);
    char *chtime = ctime(&timeval);
    cout << "\n" << chtime << endl;
}

/*~*~*~*~*~*~ Save the output below
 ~*~ Project: Stack ADT ~*~

Input File: numbers1.txt
Top: 30
Count: 4
Stack: 50 40
Stack: 25 15 30
Stack: 70 60 20 10

Input File: numbers2.txt
Top: Empty
Count: 0
Error
Top: 40
Count: 3
Stack: 50 90 40 10 40 30
Stack: 20

Input File: numbers3.txt
Count: 4
Top: 45
Count: 4
Top: 65
Count: 7
Top: 75
Count: 7
Error
Count: 7
Top: 75
Count: 7
Stack: 75 65 55 45 35
Count: 9
Top: 90
Count: 9
Stack: 90 80 70
Stack: 54 43 33 23 13
Count: 6
Top: 60
Count: 6
Count: 24
Top: 99
Stack: 99 89 79 69 59 49
Count: 18
Top: 39
Count: 22
Error
Count: 24
Stack: 64 54 44 34 24 14 39 29 19 97 87 77 67 57 47 7 27 17 60 50 40 10 25 15
Program ended with exit code: 0
 
*~*/
