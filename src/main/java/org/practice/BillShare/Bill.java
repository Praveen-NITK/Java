package BillShare;
import java.util.ArrayList;
import java.util.List;

public class Bill {
    String desc;
    double totalBillAmount;
    Group belongToGroup;
    List<BillParticipant> paidBy;
    List<BillParticipant> contribution;


    Bill(String billName, Group group, double billAmt){
        desc=billName;
        belongToGroup=group;
        totalBillAmount=billAmt;
        paidBy = new ArrayList<>();
        contribution= new ArrayList<>();
    }
    
    // public List<BillPayer> getBillPayer() {
    //     return paidByParticipants;
    // }

    public void addBillPayers(Participant payer, double share){
        paidBy.add(new BillPayer(payer,0, share));        
    }
    public void addBillContributors(Participant payer, double share){
        contribution.add(new BillPayer(payer, share,0));        
    }

    public void calculateBillDivision()
    {
        double equalShareAmount=totalBillAmount/this.belongToGroup.groupMembers.size();
        Participant maxPayerForThisBill=null;
        for(BillParticipant billpayer: paidBy){
            if(billpayer.shareAmount-equalShareAmount>0)
                maxPayerForThisBill=billpayer.person;            
        }

        for(BillParticipant billContributor: contribution){
            double balanceAmount=billContributor.shareAmount-equalShareAmount;
            for (Participant p : this.belongToGroup.groupMembers) {  
                if(p==billContributor.person)
                    p.totalBalance+=balanceAmount;
                else
                    p.totalBalance-=equalShareAmount; 
                if(p!=maxPayerForThisBill && maxPayerForThisBill!=null){                              
                    maxPayerForThisBill.owedMoney.add(new MoneyOwe("", p.personName, balanceAmount,this.belongToGroup.name, this.desc));
                }                
            }
        }
               

        //calculateBillDivision(p);
    }

    // public void calculateBillDivision(Participant payer){        
    //     double equalShareAmount=totalBillAmount/this.belongToGroup.groupMembers.size();
    //     for (Participant p : this.belongToGroup.groupMembers) {
    //         if(p!=payer){
    //             p.totalBalance-=equalShareAmount;
    //         }
    //         else{                
    //             p.totalBalance+=equalShareAmount*(this.belongToGroup.groupMembers.size()-1)+equalShareAmount;
    //         }
    //     }
    // }
}