package com.Hileb.ofstream.ofstream;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataManager {
    public List<IDataOfstream> ALL=new ArrayList<>();
    public HashMap<String, List<IDataOfstream>> MAP=new HashMap<>();
    public final String TYPE;

    public DataManager(String typeIn){
        TYPE=typeIn;
    }
    public void register(String modid,IDataOfstream dataOfstream){
        ALL.add(dataOfstream);
        if (MAP.containsKey(modid)){
            MAP.get(modid).add(dataOfstream);
        }
        else {
            ArrayList<IDataOfstream> list=new ArrayList<>();
            list.add(dataOfstream);
            MAP.put(modid,list);
        }
    }
    public OfstreamRegisterObject getRegisterObject(){
        return new OfstreamRegisterObject(MAP,TYPE);
    }

    public void clear(){
        ALL.clear();
        MAP.clear();
    }
}
