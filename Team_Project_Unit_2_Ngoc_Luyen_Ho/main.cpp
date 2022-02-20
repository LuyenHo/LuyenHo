#include "BinarySearchTree.h"  // BST ADT
#include "GymMember.h"
#include <iostream>
#include <iomanip>
#include <fstream>
#include <string>
#include <cctype>
//#include<bits/stdc++.h>

using namespace std;

void buildList(const string &filename, BinarySearchTree &list);
void display(GymMember &);
void testDrive(BinarySearchTree &);

// BST manipulation
void bstInsert(BinarySearchTree &);
void bstSearchId(BinarySearchTree &);
void bstSearchName(BinarySearchTree &);
void bstRemove(BinarySearchTree &);
void bstUndo(BinarySearchTree &);

int main()
{
    string filename;
    BinarySearchTree bst;

    cout << "What is the input file's name? ";
    cin >> filename;
     buildList(filename, bst);

    char option;
    cout << "Display Inorder [Y/N]? ";
    cin >> option;
    if (option == 'y' || option == 'Y')
    {
        cout << endl << "Inorder: " << endl;
        bst.inOrder(display);
        cout << endl;
    }
    testDrive(bst);
    
    cout << "Display Inorder BST after test\n";
    bst.inOrder(display);
    cout << endl;

    return 0;
}

/*****************************************************************************
 This function reads data about colleges from a file and inserts them
 into a sorted linked list. The list is sorted in ascending order by code
 *****************************************************************************/
void buildList(const string &filename, BinarySearchTree &list)
{
    ifstream fin(filename);
    //cout << "Reading data from \"" << filename << "\"";

    if(!fin)
    {
        cout << "Error opening the input file: \""<< filename << "\"" << endl;
        exit(EXIT_FAILURE);
    }

    //Variables for GymMember
    string id, name, dateRegistered, membershipType, contactInformation;
    int visitNumbers;

    //Fill the table
    while (getline(fin, id, ',')){
        fin.ignore(); //To ignore the space
        getline(fin, name, ',');

        fin.ignore(); //To ignore the space
        getline(fin, dateRegistered, ',');

        fin.ignore(); //To ignore the space
        getline(fin, membershipType, ',');

        fin.ignore(); //To ignore the space
        fin >> visitNumbers;

        fin.ignore(); //To ignore the space
        fin >> contactInformation;

        fin.ignore(); //To ignore the space

        GymMember aGymMember(id, name, dateRegistered, membershipType, visitNumbers, contactInformation);

        list.insert(aGymMember);
    }

    fin.close();
}

/*
 horizontal display: all items on one line
*/
void display (GymMember &item)
{
    cout << " " << item.getId() << "  " << item.getName() << endl;
}

//test function
void testDrive(BinarySearchTree &bst){
    char usrIn;
    bool demoOff = false;

    cout << "DEMO MODE" << endl;

    while (!demoOff){
        cout << "Which function would you like to test?\n";
        cout << "Insert - I, Remove - R, Search by ID - P, Search by Name - S, Unde - U, Quit - Q\n";
        
        cin >> usrIn;
        
        switch(toupper(usrIn)){
            case 'I':{
                bstInsert(bst);
                break;
            }
            case 'R':{
                bstRemove(bst);
                break;
            }
            case 'P':{
                bstSearchId(bst);
                break;
            }
            case 'S':{
                bstSearchName(bst);
                break;
            }
            case 'U':{
                bstUndo(bst);
                break;
            }
            case 'Q':{
                cout << "Demo Off\n";
                demoOff = true;
                break;
            }
            default:{
                cout << "Invalid input\n";
                break;
            }
        }
    }
}

void bstInsert(BinarySearchTree &bst){
    
    //Variables for GymMember
    string id, name, dateRegistered, membershipType, contactInformation;
    int visitNumbers;

    cout << "Please Enter name: ";
    cin.ignore();
    getline(cin, name);

    //No duplicates
    GymMember returnName;
    if (bst.searchName(name, returnName)){
        cout << endl << "Duplicate key: " << name << " - rejected! " << endl;
    }
    else{
        cout << "Please Enter Id: ";
        cin >> id;
        cout << "Please Enter Date Registered: ";
        cin >> dateRegistered;
        cout << "Please Enter Membership Type: ";
        cin >> membershipType;
        cout << "Please Enter Number of Visits: ";
        cin >> visitNumbers;
        cout << "Please Enter Contact Information: ";
        cin >> contactInformation;

        GymMember aGymMember(id, name, dateRegistered, membershipType, visitNumbers, contactInformation);
        bst.insert(aGymMember);

        cout << aGymMember.getName() << " has been added\n";
    }
}

void bstSearchId(BinarySearchTree &bst){
    string id;
    cout << "Please Enter the ID of the member: ";
    cin >> id;
    
    GymMember returnItem;
    if (bst.searchId(id, returnItem)) {
        cout << "Item was Found!" << endl;
        display(returnItem);
        cout << endl;
    }
    else
    {
        cout << "Item was not found!" << endl;
    }
}

void bstSearchName(BinarySearchTree &bst){
    string Name;
    cout << "Please Enter the name of the member: ";
    cin.ignore();
    getline(cin, Name);
    
    GymMember returnItem;
    if (bst.searchName(Name, returnItem)) {
        cout << "Item was Found!" << endl;
        display(returnItem);
        cout << endl;
    }
    else
    {
        cout << "Item was not found!" << endl;
    }
}

void bstRemove(BinarySearchTree &bst){
    string id;
    cout << "Please Enter ID of the member: ";
    cin.ignore();
    getline(cin, id);
    
    GymMember itemDeleted;
    if (bst.remove(id, itemDeleted))
        cout  << "Delete! " << itemDeleted.getId() << ", " << itemDeleted.getName() << endl;
    else
        cout << "Member with ID " << id << " not found!" << endl;
}

void bstUndo(BinarySearchTree &bst){
    GymMember itemReturn;
    if (bst.undo(itemReturn))
        cout << "Undo delete of " << itemReturn.getName() << endl;
    else cout << "Don't have any deleted data!\n";
}
