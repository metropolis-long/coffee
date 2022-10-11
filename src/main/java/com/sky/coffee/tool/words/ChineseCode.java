package com.sky.coffee.tool.words;


import com.github.stuxuhai.jpinyin.ChineseHelper;
import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

import java.io.UnsupportedEncodingException;
import java.util.Random;



public class ChineseCode {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String wds = createChineseWords(i);
            System.out.println("第：" + (i + 1) + "  个词："+wds);
        }
        System.out.println(createChineseWords(null));
    }

    public static String CreateChinese() {
        Random random = new Random();
        String[] rBase = {"0", "1", "2", "3", "4", "5", "6", "7", "8",
                "9", "a", "b", "c", "d", "e", "f"};
        // 生成第1位的区码
        int r1 = random.nextInt(3) + 11; //生成11到14之间的随机数
        String str_r1 = rBase[r1];
        // 生成第2位的区码
        int r2;
        if (r1 == 13) {
            r2 = random.nextInt(7); //生成0到7之间的随机数
        } else {
            r2 = random.nextInt(16); //生成0到16之间的随机数
        }
        String str_r2 = rBase[r2];
        // 生成第1位的位码
        int r3 = random.nextInt(6) + 10; //生成10到16之间的随机数
        String str_r3 = rBase[r3];
        // 生成第2位的位码
        int r4;
        if (r3 == 10) {
            r4 = random.nextInt(15) + 1; //生成1到16之间的随机数
        } else if (r3 == 15) {
            r4 = random.nextInt(15); //生成0到15之间的随机数
        } else {
            r4 = random.nextInt(16); //生成0到16之间的随机数
        }
        String str_r4 = rBase[r4];

        // 将生成机内码转换为汉字
        byte[] bytes = new byte[2];
        //将生成的区码保存到字节数组的第1个元素中
        String str_r12 = str_r1 + str_r2;
        int tempLow = Integer.parseInt(str_r12, 16);
        bytes[0] = (byte) tempLow;
        //将生成的位码保存到字节数组的第2个元素中
        String str_r34 = str_r3 + str_r4;
        int tempHigh = Integer.parseInt(str_r34, 16);
        bytes[1] = (byte) tempHigh;

        String ctmp = null;
        try {
            ctmp = new String(bytes, "gb2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            return ctmp;
        }
    }
    public static String createChineseWords(Integer wordLength){
        if (wordLength==null||wordLength<=0){
            Random random = new Random();
            wordLength=random.nextInt(5);
        }
        StringBuffer buffer = new StringBuffer();
        for(;wordLength>0;wordLength--){
            String word=CreateChinese();
            if (word==null)continue;
            buffer.append(word);
        }
        return buffer.toString();
    }


    public static void CreatChineseCode() throws UnsupportedEncodingException, PinyinException {
        Random random = new Random();
        String[] rBase = {"0", "1", "2", "3", "4", "5", "6", "7", "8",
                "9", "a", "b", "c", "d", "e", "f"};
        // 生成第1位的区码
        int r1 = random.nextInt(3) + 11; //生成11到14之间的随机数
        String str_r1 = rBase[r1];
        // 生成第2位的区码
        int r2;
        if (r1 == 13) {
            r2 = random.nextInt(7); //生成0到7之间的随机数
        } else {
            r2 = random.nextInt(16); //生成0到16之间的随机数
        }
        String str_r2 = rBase[r2];
        // 生成第1位的位码
        int r3 = random.nextInt(6) + 10; //生成10到16之间的随机数
        String str_r3 = rBase[r3];
        // 生成第2位的位码
        int r4;
        if (r3 == 10) {
            r4 = random.nextInt(15) + 1; //生成1到16之间的随机数
        } else if (r3 == 15) {
            r4 = random.nextInt(15); //生成0到15之间的随机数
        } else {
            r4 = random.nextInt(16); //生成0到16之间的随机数
        }
        String str_r4 = rBase[r4];
        System.out.println("区码+位码=" + str_r1 + str_r2 + str_r3 + str_r4);

        // 将生成机内码转换为汉字
        byte[] bytes = new byte[2];
        //将生成的区码保存到字节数组的第1个元素中
        String str_r12 = str_r1 + str_r2;
        int tempLow = Integer.parseInt(str_r12, 16);
        bytes[0] = (byte) tempLow;
        //将生成的位码保存到字节数组的第2个元素中
        String str_r34 = str_r3 + str_r4;
        int tempHigh = Integer.parseInt(str_r34, 16);
        bytes[1] = (byte) tempHigh;
        String ctmp = new String(bytes, "gb2312"); //根据字节数组生成汉字
        System.out.println("生成汉字:" + ctmp);

        //String s="中国的首都是北京";
        String s = "";
        s = ctmp;
        char[] c = ctmp.toCharArray();
        //带音标   zhōng,guó,de,shǒu,dū,shì,běi,jīng
        System.out.println(PinyinHelper.convertToPinyinString(s, ",", PinyinFormat.WITH_TONE_MARK));
        //用数字代替音标   zhong1,guo2,de5,shou3,du1,shi4,bei3,jing1
        System.out.println(PinyinHelper.convertToPinyinString(s, ",", PinyinFormat.WITH_TONE_NUMBER));

        //不带音标  zhong,guo,de,shou,du,shi,bei,jing

        System.out.println(PinyinHelper.convertToPinyinString(s, ",", PinyinFormat.WITHOUT_TONE));


        System.out.println(PinyinHelper.getShortPinyin(s));//输出拼音首字母  zgdsdsbj


        //System.out.println("是否是多音字："+PinyinHelper.hasMultiPinyin('好'));//判断多音字   true

        //判断多音字   true
        System.out.println("是否是多音字：" + (PinyinHelper.hasMultiPinyin(c[0]) == false ? "不是" : "是"));


        //System.out.println(ChineseHelper.convertToSimplifiedChinese("東"));//繁体字转简体字  东


        //System.out.println( ChineseHelper.convertToTraditionalChinese("东"));//简体字转繁体字  東
        //System.out.println(ChineseHelper.isTraditionalChinese('哈'));//判断是否为繁体字   false


        System.out.println("是否是繁体字：" + ((ChineseHelper.isTraditionalChinese(c[0]) == false) ? "不是" : "是"));//判断是否为繁体字   false
    }
}
