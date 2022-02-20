#ifndef _BINARY_SEARCH_TREE
#define _BINARY_SEARCH_TREE

#include "BinaryTree.h"

class BinarySearchTree : public BinaryTree
{
public:
    // insert a node at the correct location
    bool insert(const GymMember &item);
    // remove a node if found
    bool remove(const string item, GymMember &itemDeleted);
    // undo the deleted node
    bool undo(GymMember &itemReturn);
    // find a target node
    bool searchId(const string &target, GymMember &returnedItem) const;
    bool searchName(const string &target, GymMember &returnedItem) const;


private:
    // internal insert node: insert newNode in nodePtr subtree
    BinaryNode* _insert(BinaryNode* nodePtr, BinaryNode* newNode);

    // search for target node
    BinaryNode* _searchId(BinaryNode* treePtr, const string &target) const;
    BinaryNode* _searchName(BinaryNode* treePtr, const string &target) const;

    // internal remove node: locate and delete target node under nodePtr subtree
    BinaryNode* _remove(BinaryNode* nodePtr, const string target, bool & success);
    BinaryNode* minValueNode(BinaryNode* nodePtr);
};


///////////////////////// public function definitions ///////////////////////////
//Wrapper for _insert - Inserting items within a tree
bool BinarySearchTree::insert(const GymMember & newEntry)
{
    BinaryNode* newNodePtr = new BinaryNode(newEntry);
    this->rootPtr = _insert(this->rootPtr, newNodePtr);
    return true;
}

//Wrapper for _search
// - it calls the private _search function that returns a Node pointer or NULL
// - if found, it copies data from that node and sends it back to the caller
//   via the output parameter, and returns true, otherwise it returns false.
bool BinarySearchTree::searchId(const string& id, GymMember & returnedItem) const
{
    BinaryNode* IdFound;
    IdFound = _searchId(this->rootPtr, id);
    if (IdFound != nullptr) {
        returnedItem = IdFound->getItem();
        return true;
    }
    else
        return false;
}
bool BinarySearchTree::searchName(const string& name, GymMember & returnedItem) const
{
    BinaryNode* NameFound;
    NameFound = _searchName(this->rootPtr, name);
    if (NameFound != nullptr){
        returnedItem = NameFound->getItem();
        return true;
    }
    else
        return false;
}

//Wrapper for _remove
// - it calls the private _remove function that returns a Node pointer or NULL
// - if found, it remove item from the tree
bool BinarySearchTree::remove(const string item, GymMember &itemDeleted)
{
    bool isSuccessful = false;
    this->rootPtr = _remove(this->rootPtr, item, isSuccessful);
    itemDeleted = backupData.top();
    return isSuccessful;
}

bool BinarySearchTree::undo(GymMember &itemReturn)
{
    bool isSuccessful = false;
    if(backupData.empty()) return isSuccessful;
    else {
        itemReturn = backupData.top();
        backupData.pop();
        if (insert(itemReturn)) isSuccessful = true;
    }
    return isSuccessful;
}

//////////////////////////// private functions ////////////////////////////////////////////

//Implementation of the insert operation
BinaryNode* BinarySearchTree::_insert(BinaryNode* nodePtr, BinaryNode* newNodePtr)
{
    BinaryNode* pWalk = nodePtr, *parent = nullptr;
    if( !nodePtr) {// == NULL
        nodePtr = newNodePtr;
        return nodePtr;
    }
    else {
        while(pWalk) {// != NULL
            parent = pWalk;
            if (pWalk->getItem().getId() > newNodePtr->getItem().getId())
                pWalk = pWalk->getLeftPtr();
            else
                pWalk = pWalk->getRightPtr();
        }
        if (parent->getItem().getId() > newNodePtr->getItem().getId())
            parent->setLeftPtr(newNodePtr);
        else
            parent->setRightPtr(newNodePtr);
    }
    return nodePtr;
}

//Implementation for the search operation by id
// - return NULL if target not found, otherwise
// - returns a pointer to the node that matched the target
BinaryNode* BinarySearchTree::_searchId(BinaryNode* nodePtr, const string &target) const
{
    BinaryNode* found = nullptr;
    BinaryNode* pWalk = nodePtr;
    while (pWalk != nullptr && found == nullptr)
    {
        if (pWalk->getItem().getId() > target) {
            pWalk = pWalk->getLeftPtr();
        }
        else if (pWalk->getItem().getId() < target)
        {
            pWalk = pWalk->getRightPtr();
        }
        else {
            found = pWalk;
        }
    }
    return found;
}

//Implementation for the search operation by id
// - return NULL if target not found, otherwise
// - returns a pointer to the node that matched the target
BinaryNode* BinarySearchTree::_searchName(BinaryNode* nodePtr, const string &target) const
{
    if (nodePtr == nullptr)
            return nullptr;
     
    if (nodePtr->getItem().getName() == target)
        return nodePtr;
     
        /* then recur on left sutree */
    BinaryNode* res1 = _searchName(nodePtr->getLeftPtr(), target);
        // node found, no need to look further
        if(res1) return res1;
     
        /* node is not found in left,
        so recur on right subtree */
    BinaryNode* res2 = _searchName(nodePtr->getRightPtr(), target);
     
        return res2;
}


//Implementation for the remove operation
// - return NULL if target not found, otherwise
// - delete the node that matched the target
BinaryNode* BinarySearchTree::_remove(BinaryNode* nodePtr, const string target, bool & success)
{
    // base case
    if (nodePtr == nullptr){
        success = false;
        return nodePtr;
    }

    // If the target to be deleted is
    // smaller than the nodePtr's
    // item, then it lies in left subtree
    if (nodePtr->getItem().getId() > target)
        nodePtr->setLeftPtr(_remove(nodePtr->getLeftPtr(), target, success));

    // If the target to be deleted is
    // greater than the nodePtr's
    // item, then it lies in right subtree
    else if (nodePtr->getItem().getId() < target)
        nodePtr->setRightPtr(_remove(nodePtr->getRightPtr(), target, success));

    // if target is same as nodePtr's item, then This is the node
    // to be deleted
    else {
        // node with only one child or no child
        if (nodePtr->getLeftPtr() == nullptr) {
            BinaryNode* temp = nodePtr->getRightPtr();
            backupData.push(nodePtr->getItem());
            free(nodePtr);
            success = true;
            return temp;
        }
        else if (nodePtr->getRightPtr() == nullptr) {
            BinaryNode* temp = nodePtr->getLeftPtr();
            backupData.push(nodePtr->getItem());
            free(nodePtr);
            success = true;
            return temp;
        }

        // node with two children: Get the inorder successor
        // (smallest in the right subtree)
        BinaryNode* temp = minValueNode(nodePtr->getRightPtr());

        // Copy the inorder successor's content to this node
        nodePtr->setItem(temp->getItem());

        // Delete the inorder successor
        nodePtr->setRightPtr(_remove(nodePtr->getRightPtr(), temp->getItem().getId(), success));
    }
    return nodePtr;
}

/* Given a non-empty binary search tree, return the node
with minimum key value found in that tree. Note that the
entire tree does not need to be searched. */
BinaryNode* BinarySearchTree::minValueNode(BinaryNode* nodePtr)
{
    BinaryNode* current = nodePtr;

    /* loop down to find the leftmost leaf */
    while (current && current->getLeftPtr() != nullptr)
        current = current->getLeftPtr();

    return current;
}


#endif
