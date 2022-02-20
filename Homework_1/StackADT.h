/*~*~*
   Stack template
*~*/

#ifndef STACK_ADT
#define STACK_ADT

template <class T>
class Stack
{
private:
    // Structure for the stack nodes
    struct StackNode
    {
      T value;          // Value in the node
      StackNode *next;  // Pointer to next node
    };

    StackNode *top;     // Pointer to the stack top
    int length;

public:
    // Constructor
    Stack(){ top = NULL; length = 0; }
    // Destructor
    ~Stack();
    // Stack operations:
    // push()
    bool push(T);
    // pop()
    T pop();
    // peek()
    T peek() {return top->value; }
    // isEmpty()
    bool isEmpty() {if (length == 0) return true;
                        else return false;}
    // getLength()
    int getLength() {return length; }
};


/*~*~*
  Member function push inserts the argument onto
  the stack.
*~**/
template <class T>
bool Stack<T>::push(T item)
{
   StackNode *newNode; // Pointer to a new node

   // Allocate a new node and store num there.
   newNode = new StackNode;
   if (!newNode)
       return false;
   newNode->value = item;

   // Update links and counter
   newNode->next = top;
   top = newNode;
   length++;

   return true;
}


/*~*~*
  Member function pop deletes the value at the top
  of the stack and returns it.
  Assume stack is not empty.
*~**/
template <class T>
T Stack<T>::pop()
{
   StackNode *currNode;

   // Position nodePtr at the top of the stack.
   currNode = top;

   //Update links and counter
   T val = currNode->value;
   top = top->next;
   delete currNode;;
   length--;
   return val;
}
/**~*~*
   Destructor
*~**/
template <class T>
Stack<T>::~Stack()
{
   StackNode *currNode;

   // Position nodePtr at the top of the stack.
   currNode = top;

   // Traverse the list deleting each node.
   while (currNode)
   {
      StackNode *temp = currNode;
      currNode = currNode->next;
      delete temp;
      temp = NULL;
   }
}
#endif
