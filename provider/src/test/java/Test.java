import java.util.*;

/**
 * Created by admin on 2018-05-29.
 */
public class Test{
    public static void main(String arg[]){
        /*for(int i= 0 ; i<10 ; i++){
            if(i==5){
                try{
                    tt();
                }catch (Exception e){
                    //continue;
                    e.printStackTrace();
                }

            }
            System.out.println(i);
        }*/

        //System.out.println("19".contains("19"));

        /*Map resMap = new HashMap();
        resMap.put("RES_STATE","3");

        System.out.println(resMap.toString());
        if(resMap.get("RES_STATE")!=null&&(resMap.get("RES_STATE").toString().equals("1")|| resMap.get("RES_STATE").toString().equals("3"))) {//校验状态
            System.out.println("ok");
        }*/
        //String  character = "123123$%^&*(!@#$%^&*()()_+edfsdfgjhsk???？？？？";
        //String after = character.replaceAll("[^(a-zA-Z0-9)]", "");
        //System.out.println(after);
        List keyInsIdList = new ArrayList<>();

        keyInsIdList.add("1");

        String tsr = "GSM_APPLY_STOP";
        String str [] = tsr.split(",");
        keyInsIdList.addAll(Arrays.asList(str));
        System.out.println(keyInsIdList.size());

        System.out.println(keyInsIdList.contains("GSM_INDIV_STOP_OPEN"));
    }

    public static void tt() {
        int i = 1 / 0 ;
    }
}
