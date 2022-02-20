// Name: Ngoc Luyen Ho
// IDE: Xcode


#ifndef _BINARY_NODE
#define _BINARY_NODE

#include "GymMember.h"

class BinaryNode
{
private:
    GymMember item;         // Data portion
    BinaryNode* leftPtr;        // Pointer to left child
    BinaryNode* rightPtr;        // Pointer to right child

public:
    // constructors
    BinaryNode(const GymMember & anItem)    {item = anItem; leftPtr = 0; rightPtr = 0;}
    BinaryNode(const GymMember & anItem,
               BinaryNode* left,
               BinaryNode* right) {item = anItem; leftPtr = left; rightPtr = right;}
    // setters
    void setItem(const GymMember & anItem) {item = anItem;}
    void setLeftPtr(BinaryNode* left) {leftPtr = left;}
    void setRightPtr(BinaryNode* right) {rightPtr = right;}
    
    // getters
    GymMember getItem() const     {return item;}
    BinaryNode* getLeftPtr() const  {return leftPtr;}
    BinaryNode* getRightPtr() const {return rightPtr;}

    // other functions
    bool isLeaf() const {return (leftPtr == 0 && rightPtr == 0);}
    
};

#endif
