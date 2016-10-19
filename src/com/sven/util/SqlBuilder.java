package com.sven.util;


import java.util.List;

/**
 * 
 * @author sven
 * 2016年5月17日
 * 
 */
public class SqlBuilder {
	/**
	 * 拼接list为String,以方便sql 的 in 条件
	 * @author sven 2016年6月16日
	 * @param list
	 * @return
	 */
    public static String sqlIn(List<String> list){
        StringBuilder sb = new StringBuilder();
        if(list != null && list.size()>0){
            for(int i=0,len=list.size();i<len;i++){
                sb.append("'"+ list.get(i) + "'");
                if(i < len-1){
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }
   /**
    * 判断是否为数字
    * @param str
    * @return true or false
    */
    public static boolean isNumeric(String str){
    	  for (int i = str.length();--i>=0;){   
    	   if (!Character.isDigit(str.charAt(i))){
    	    return false;
    	   }
    	  }
    	  return true;
    	 }
    
    /**
     * 判断是否为汉字
     * @param str
     * @return true or false
     */
    public static boolean isChinese(String str){
        char[] chars=str.toCharArray(); 
        boolean isGB2312=false; 
        for(int i=0;i<chars.length;i++){
                    byte[] bytes=(""+chars[i]).getBytes(); 
                    if(bytes.length==2){ 
                        int[] ints=new int[2]; 
                        ints[0]=bytes[0]& 0xff; 
                        ints[1]=bytes[1]& 0xff; 
                        if(ints[0]>=0x81 && ints[0]<=0xFE &&  
                        		ints[1]>=0x40 && ints[1]<=0xFE){ 
                                    isGB2312=true; 
                                    break; 
                        } 
                    } 
        } 
        return isGB2312; 
    }
    

    
}
