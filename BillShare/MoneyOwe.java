package BillShare;
public class MoneyOwe{
    String billName;
    String oweTo;
    String owedBy;
    double oweAmount;
    String groupName;

    MoneyOwe(String to, String by, double a, String g, String b){
        oweTo=to;
        owedBy=by;
        oweAmount=a;
        groupName=g;
        billName=b;
    }
}