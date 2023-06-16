package org.practice.BillShare;

import java.util.List;

public abstract class UserGroup{
    public String id;
    public String name;
    public List<Participant> groupMembers;

    abstract void registerToGroup(Participant person);
    abstract void unRegisterFromGroup(Participant person);

    
}
