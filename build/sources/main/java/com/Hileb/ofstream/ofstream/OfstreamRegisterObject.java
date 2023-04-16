package com.Hileb.ofstream.ofstream;

import java.util.HashMap;
import java.util.List;

public class OfstreamRegisterObject {
    public final HashMap<String, List<IDataOfstream>> ofstreamHashMap;
    public final String item;
    public OfstreamRegisterObject(HashMap<String,List<IDataOfstream>> ofstreamHashMapIn ,String  itemIn){
        ofstreamHashMap=ofstreamHashMapIn;
        item=itemIn;
    }
}
