package BillShare;
public class BillShareApplication{
    public static void main(String[] args) {
        Participant person1= new Participant("person1@xyz.com","person1");
        Participant person2= new Participant("person2@xyz.com","person2");
        Participant person3= new Participant("person3@xyz.com","person3");

        Group group1= new Group("Group1", "Group1");
        Group group2= new Group("Group2", "Group2");

        group1.registerToGroup(person1);
        group1.registerToGroup(person2);

        group2.registerToGroup(person2);
        group2.registerToGroup(person3);

        //BillContributor billCon=new BillContributor(billId, p, amount)

        Bill bill1= new Bill("Bill1", group1, 300);
        Bill bill2= new Bill("Bill2", group1, 500);
        Bill bill3= new Bill("Bill3", group2, 100);
        Bill bill4= new Bill("Bill4", group2, 300);

        bill1.addBillPayers(person1,300);
        bill1.addBillContributors(person1, 100);
        bill1.addBillContributors(person2, 200);


        bill2.addBillPayers(person2,500);
        bill2.addBillContributors(person1, 250);
        bill2.addBillContributors(person2, 250);

        bill3.addBillPayers(person3,100);
        bill3.addBillContributors(person2, 10);
        bill3.addBillContributors(person3, 90);

        bill4.addBillPayers(person3,100);
        bill4.addBillPayers(person2,200);
        bill4.addBillContributors(person2, 150);
        bill4.addBillContributors(person3, 150);

        bill1.calculateBillDivision();
        bill2.calculateBillDivision();
        bill3.calculateBillDivision();
        bill4.calculateBillDivision();
     
        System.out.println("Person wise details: ");
        getPersonWiseBalance(person1);
        System.out.println("----------");
        getPersonWiseBalance(person2);
        System.out.println("----------");
        getPersonWiseBalance(person3);
        // System.out.println("Overall for person 1: "+getPersonWiseBalance(person1));
        // System.out.println("Overall for person 2: "+getPersonWiseBalance(person2));
        // System.out.println("Overall for person 3: "+getPersonWiseBalance(person3));

        System.out.println();

        // System.out.println("Group wise details: ");
        // getGroupWiseBalance(group1);
        // getGroupWiseBalance(group2);
        
    }
    public static double getPersonWiseBalance(Participant p){
        //return p.getParticipantsTotalBalace();
        double toPayAmount=0;
        double toGetAmount=0;
        for (MoneyOwe owe : p.owedMoney) {
            if(owe.oweTo!=""){
                toPayAmount+=owe.oweAmount;
                System.out.println(p.personName+" owe "+ owe.oweAmount+" money to "+owe.oweTo+" for "+owe.billName+" in "+owe.groupName);
            }
            else if(owe.owedBy!=""){
                toGetAmount+=owe.oweAmount;
                System.out.println(owe.owedBy+" owe "+ owe.oweAmount+" money to "+p.personName+" for "+owe.billName+" in "+owe.groupName);
                //System.out.println(p.personName+" owed amount "+ owe.oweAmount+" by "+owe.owedBy+" for "+owe.billName+" in "+owe.groupName);
            }
        }
        p.totalBalance= toGetAmount-toPayAmount;
        return p.totalBalance;
    }

    public static void getGroupWiseBalance(Group g){
        for (Participant p : g.groupMembers) {
            System.out.println(p.personName+" in "+g.name+" : "+p.totalBalance);
        }
    }

}