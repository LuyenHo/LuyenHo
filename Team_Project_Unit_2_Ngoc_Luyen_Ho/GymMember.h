//Written by Ngoc Luyen Ho
//IDE: XCode

#pragma once //Loads header only once

#include <string>

using std::string;

class GymMember{
private:
    string id;
    string name;
    string dateRegistered;
    string membershipType;
    int visitNumbers;
    string contactInformation;
public:
    //Constructors
    GymMember() {
        id = "";
        name = "";
        dateRegistered = "";
        membershipType = "";
        visitNumbers = -1;
        contactInformation = "";
    };

    GymMember(string par_id, string nm, string dtrg, string mbstp, int vstnm, string cntinfo) {
        id = par_id;
        name = nm;
        dateRegistered = dtrg;
        membershipType = mbstp;
        visitNumbers = vstnm;
        contactInformation = cntinfo;
    };

    //Getters
    string getId() const { return id; };
    string getName() const  {return name; };
    string getDateRegistered() const { return dateRegistered; };
    string getMembershipType() const { return membershipType; };
    int getVisitNumbers() const { return visitNumbers; };
    string getContactInformation() const { return contactInformation; };

    //Setters
    void setId( string par_id) { id = par_id; };
    void setName( string nm) { name = nm; };
    void setDateRegistered( string dtrg) { dateRegistered = dtrg; };
    void setMembershipType( string mbstp) { membershipType = mbstp; };
    void setVisitNumbers (int vstnm) { visitNumbers = vstnm; };
    void setContactInformation( string cntinfo) { contactInformation = cntinfo; };
    
};
