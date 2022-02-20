// Implementation file for the College class
// Written By: A. Student
// Changed By: Ngoc Luyen Ho
// IDE: Xcode


#include <iostream>
#include <iomanip>
#include <string>

#include "College.h"

using namespace std;

//**************************************************
// Constructor
//**************************************************
College::College()
{
    rank = -1;
    code = "";
    name = "";
    cost = -1;
}

//**************************************************
// Overloaded Constructor
//**************************************************
College::College(int rk, string cd, string nm, int ct)
{
    rank = rk;
    code = cd;
    name = nm;
    cost = ct;
}

//***********************************************************
// Displays the values of the College object member variables
// on one line (horizontal display)
//***********************************************************
ostream& operator<<(ostream& os, const College& College)
{
    cout << left;
    cout << " " << setw(4) << College.getCode() << "  ";
    cout << " " << setw(2) << College.getRank() << "  ";
    cout << " " << setw(27)<< College.getName() << "  ";
    cout << right;
    cout << " " << setw(7) << College.getCost() << " ";
    cout << left << endl;
    return os;
}

//***********************************************************
// Displays the values of the College object member variables
// one per line (vertical display)
//***********************************************************
void College::vDisplay() const
{
    cout << "              Rank: " << rank << endl;
    cout << "       School Name: " << name << endl;
    cout << "Cost of Attendance: $" << cost << endl;
}

