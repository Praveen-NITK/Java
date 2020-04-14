package BillShare;
public class BillPayer extends BillParticipant{
    BillPayer(Participant p, double sA, double pA){
        person=p;
        shareAmount=sA;
        paidAmount=pA;
    }
}