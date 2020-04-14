package BillShare;

import java.util.ArrayList;
import java.util.List;

public class Participant {
    String participantId;
    String personName;
    double totalBalance;
    List<MoneyOwe> owedMoney;    
    
    Participant(String id, String name){
        participantId=id;
        personName=name;
        owedMoney= new ArrayList<>();
    }

    public double getParticipantsTotalBalace(){
        return totalBalance;
    }

}
