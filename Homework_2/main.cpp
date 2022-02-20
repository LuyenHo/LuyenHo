#include <iostream>
#include <string>

#include "QueueADT.h"


using namespace std;

int main() {

    Queue_str<string> queName;
    string name;
    Queue_str<double> queUnits;
    double units;
    
    cin >> name;
    if (name != "#") {
        while(name != "#") {
            queName.push(name);
            cin >> name;
            }
        cout << queName.getLength() << " " << queUnits.getLength() << endl;
        while(queUnits.getLength() < queName.getLength()) {
            cin >> units;
            queUnits.push(units);
            }
        string queNameFont = queName.peek();
        double queUnitsRear = queUnits.peekRear();
        int length = queUnits.getLength();
        for (int i = 0; i < length; i++) {
            cout << queName.pop() << " " << queUnits.pop() << endl;
        }
        cout << queNameFont << endl;
        cout << queUnitsRear << endl;
    }
    else cout << "Empty Queue!\n";

    return 0;
}
