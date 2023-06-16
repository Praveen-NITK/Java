package org.practice.phonePe;


import phonePe.enums.InstrumentType;

import java.util.List;

public class Merchant {
    private long mid;
    private String name;
    private List<InstrumentType> preferredInstrumentTypes;

    public Merchant(long mid, String name, List<InstrumentType> preferredInstrumentTypes) {
        this.mid = mid;
        this.name = name;
        this.preferredInstrumentTypes = preferredInstrumentTypes;
    }

    public long getMid() {
        return mid;
    }

    public void setMid(long mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<InstrumentType> getPreferredInstrumentTypes() {
        return preferredInstrumentTypes;
    }

    public void setPreferredInstrumentTypes(List<InstrumentType> preferredInstrumentTypes) {
        this.preferredInstrumentTypes = preferredInstrumentTypes;
    }

}
