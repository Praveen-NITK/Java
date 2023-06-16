package org.practice.BillShare;
public class BillContributor extends BillParticipant{
    BillContributor(Participant p, double sA, double pA){
        person=p;
        shareAmount=sA;
        paidAmount=pA;
    }
}
