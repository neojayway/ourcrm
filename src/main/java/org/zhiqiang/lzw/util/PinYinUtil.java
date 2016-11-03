package org.zhiqiang.lzw.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 汉语文字转换拼音帮助类
 * @author Administrator
 *
 */
public class PinYinUtil {

	
	/**   
     * 汉字转换为汉语拼音首字母，英文字符不变   
     * @param chines 汉字   
     * @return 拼音
     */ 
	public static String converterToFirstSpell(String chinese) throws Exception{
		String pinyinName = "";
		//转化成字符
		char[] nameChar = chinese.toCharArray();
		//汉语拼音格式输出类   
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		
		//输出设置,大小写,音标方式等   
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);       
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        
        for (int i = 0; i < nameChar.length; i++) {
			//如果是中文
        	if(nameChar[i]>128){
        		pinyinName+=PinyinHelper.toHanyuPinyinStringArray
        			(nameChar[i], defaultFormat)[0].charAt(0);
        	}else{
        		//是英文就直接拼接
        		pinyinName+=nameChar[i];
        	}
		}
		return pinyinName;
	}
	
    /**   
     * 汉字转换位汉语拼音，英文字符不变   
     * @param chines 汉字   
     * @return 拼音   
     */  
	public static String converterToSpell(String chinese){
		String pinyinName = "";
		char[] nameChar = chinese.toCharArray(); 
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();       
        defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);       
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);  
        for (int i = 0; i < nameChar.length; i++) {       
            if (nameChar[i] > 128) {       
                try {       
                     pinyinName += PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0];       
                 } catch (BadHanyuPinyinOutputFormatCombination e) {       
                     e.printStackTrace();       
                 }       
             }else{       
                 pinyinName += nameChar[i];       
             }       
         }       
        return pinyinName; 
	}
	
}
