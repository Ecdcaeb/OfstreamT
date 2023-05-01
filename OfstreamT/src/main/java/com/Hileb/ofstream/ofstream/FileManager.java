package com.Hileb.ofstream.ofstream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.Hileb.ofstream.OfstreamCore;
import com.Hileb.ofstream.ofstream.lang.LangHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.PotionItem;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FileManager {
    public static List<OfstreamRegisterObject> REGISTER=new ArrayList<>();

    public static void register(OfstreamRegisterObject ofstreamRegisterObject){
        REGISTER.add(ofstreamRegisterObject);
    }

    public static void ofstream(){
        REGISTER.clear();

        MinecraftForge.EVENT_BUS.post(new OfstreamEvent.Register());
//        MinecraftForge.EVENT_BUS.post(new OfstreamEvent.EnUs(LangHelper.getI18n(LangHelper.EN_US)));
//        MinecraftForge.EVENT_BUS.post(new OfstreamEvent.ZhCn(LangHelper.getI18n(LangHelper.ZH_CN)));

        for (OfstreamRegisterObject objects: REGISTER) {
            String dataId=objects.item;
            for(String modId:objects.ofstreamHashMap.keySet()) {
                List<IDataOfstream> datas = objects.ofstreamHashMap.get(modId);

                try {
                    outForFile(modId, dataId, datas);

                    if (Minecraft.getInstance().player != null) {
                        Minecraft.getInstance().player.sendMessage(new StringTextComponent("Ofstream "+dataId+" successfully!").mergeStyle(TextFormatting.GREEN),(UUID)null);
                    }
                } catch (IOException e) {
                    OfstreamCore.LOGGER.error(e);
                }
            }
        }
    }
    public static void outForFile(String modid, String item, List<IDataOfstream> datas) throws IOException {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();

        File export = new File(Minecraft.getInstance().gameDir, String.format("export"+File.separator+modid+"_"+item+".json", modid.replaceAll("[^A-Za-z0-9()\\[\\]]", "")));
        if (!export.getParentFile().exists()) export.getParentFile().mkdirs();
        if (!export.exists()) export.createNewFile();
        PrintWriter pw = new PrintWriter(export, "UTF-8");

        pw.println(gson.toJson(getObjByList(datas)));


        pw.close();
    }
    public static Object[] getObjByList(List<IDataOfstream> dataOfstreams){
        List<Object> list=new ArrayList();
        for(IDataOfstream dataOfstream:dataOfstreams){
            list.add(dataOfstream.returnObj());
        }
        return list.toArray();
    }
}
