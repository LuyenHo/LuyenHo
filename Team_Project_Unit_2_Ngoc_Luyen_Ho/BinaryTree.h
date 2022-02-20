#ifndef _BINARY_TREE
#define _BINARY_TREE

#include "BinaryNode.h"
#include <stack>

class BinaryTree
{
protected:
    BinaryNode* rootPtr;        // ptr to root node
    int count;                            // number of nodes in tree
    std::stack<GymMember> backupData;

public:
    // "admin" functions
    BinaryTree() {rootPtr = 0; count = 0;}
    BinaryTree(const BinaryTree & tree){ }
    virtual ~BinaryTree() { destroyTree(rootPtr); }
   
    // common functions for all binary trees
    bool isEmpty() const    {return count == 0;}
    int getCount() const {return count;}
    void clear()            {destroyTree(rootPtr); rootPtr = 0; count = 0;}
    void inOrder(void visit(GymMember &)) const  {_inorder(visit, rootPtr);}
    void printTree(void visit(GymMember &, int)) const{_printTree(visit, rootPtr, 1);}
    // abstract functions to be implemented by derived class
    virtual bool insert(const GymMember &newData) = 0;
    virtual bool remove(const string item, GymMember &itemDeleted) = 0;
    virtual bool undo( GymMember &newData) = 0;
    virtual bool searchId(const string &target, GymMember & returnedItem) const = 0;
    virtual bool searchName(const string &target, GymMember & returnedItem) const = 0;

private:
    // delete all nodes from the tree
    void destroyTree(BinaryNode* nodePtr);

    // internal traverse
    void _inorder(void visit(GymMember &), BinaryNode* nodePtr) const;
    void _printTree(void visit(GymMember &, int), BinaryNode* nodePtr, int level) const;
   
};

//Destroy the entire tree
void BinaryTree::destroyTree(BinaryNode* nodePtr)
{
    if(nodePtr != nullptr)
    {
        destroyTree(nodePtr->getLeftPtr());
        destroyTree(nodePtr->getRightPtr());
        //cout << "DEBUG - Destructor: Now deleting " << nodePtr->getItem().getName() << endl;
        delete nodePtr;
    }
}

//Inorder Traversal
void BinaryTree::_inorder(void visit(GymMember &), BinaryNode* nodePtr) const
{
    if (nodePtr != nullptr)
    {
        GymMember item = nodePtr->getItem();
        _inorder(visit, nodePtr->getLeftPtr());
        visit(item);
        _inorder(visit, nodePtr->getRightPtr());
    }
}

//Prints tree as an indented list
void BinaryTree::_printTree(void visit(GymMember &, int), BinaryNode* nodePtr, int level) const
{
     if (nodePtr != nullptr)
   {
      GymMember item = nodePtr->getItem();
      visit(item, level);
      _printTree(visit, nodePtr->getRightPtr(), level + 1);
      _printTree(visit, nodePtr->getLeftPtr(), level + 1);
   }
}


#endif

