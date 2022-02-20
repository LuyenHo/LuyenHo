//
//  QueueADT.h
//  Homework_2
//
//  Created by luyenhoo on 10/4/20.
//

#ifndef QueueADT_h
#define QueueADT_h

using namespace std;

template <class T>
class Queue_str
{
private:
   // Structure for the stack nodes
   struct QueueNode {
       T value;        // Value in the node
       QueueNode *next;     // Pointer to next node
   };

   QueueNode *front;          // Pointer to the first node
   QueueNode *rear;           // Pointer to the last node
   int length;                // Number of nodes in the queue

public:
    Queue_str(){ front = rear = NULL; length = 0; }    //Constructor
    ~Queue_str();                                    // Destructor

      // Queue operations
      bool isEmpty() {if (length == 0) return true;
                        else return false;}
      bool push(T);
      T pop();
      T peek() {return front->value; }
      T peekRear() {return rear->value;}
      int getLength() {return length; }
   };


/*~*~*
  Member function push inserts the argument onto
  the queue.
*~**/
template <class T>
bool  Queue_str<T>::push(T item)
{
   QueueNode *newNode; // Pointer to a new node

   // Allocate a new node and store num there.
   newNode = new QueueNode;
   if (!newNode)
       return false;
   newNode->value = item;
   newNode->next = NULL;
   
   // Update links and counter
   if (!front) // front is NULL: empty queue
       front = newNode;
   else
       rear->next = newNode;
       
   rear = newNode;
   length++;

   return true;
}


/**~*~*
  Member function dequeue deletes the value at the front
  of the queue and returns it.
  Assume queue has at least one node
*~**/
template <class T>
T Queue_str<T>::pop()
{
   /* Write your code here */
   QueueNode *currNode;

   // Position nodePtr at the top of the stack.
   currNode = front;

   //Update links and counter
   T item = currNode->value;
   front = front->next;
   delete currNode;
   length--;
   return item;
}

/**~*~*
   Destructor
*~**/
template <class T>
Queue_str<T>::~Queue_str()
{
    QueueNode *currNode;

   // Position nodePtr at the top of the stack.
   currNode = front;

   // Traverse the list deleting each node.
   while (currNode)
   {
      QueueNode *temp = currNode;
      currNode = currNode->next;
      delete temp;
      temp = NULL;
   }
}

#endif
