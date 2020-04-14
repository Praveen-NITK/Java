package BillShare;

import java.util.ArrayList;
public class Group extends UserGroup{    
    public Group(String groupId, String groupName){
        groupMembers=new ArrayList<>();
        id=groupId;
        name=groupName;
    }

    //Registers new member to the group
    public void registerToGroup(Participant person){
        groupMembers.add(person);
    }
    
    //UnRegister member from group
    public void unRegisterFromGroup(Participant person){
        if(groupMembers.contains(person))
            groupMembers.remove(person);
    }

}