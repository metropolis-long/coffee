package com.sky.coffee.tool.algorithm;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmNumber {
    public static void main(String[] args) {
        String[] ch = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        String[] radix = {"", "十", "百", "千", "万", "亿", "兆"};
        //万4。亿8。万亿12，兆16，万兆20，京24，万京28，垓32.
        String[] unit = {"万", "亿", "万", "兆"};
        List<String> chinese = new ArrayList();
        int flag = 1;
        Double d = new Double("10332500006000.00");
        String numstr = "10332500006000";
        System.out.println(numstr);
        flag = numstr.length() % 4 == 0 ? numstr.length() / 4 : numstr.length() / 4 + 1;
        String[] numbers = new String[flag];
        int all_num_len = numstr.length();
        int first = all_num_len % 4;
        int yu = first;
        for (int i = 0; i < flag; i++) {
            //不能整除4，第一段数的处理
            if (first > 0 ) {
                numbers[0] = numstr.substring(0, first);
                first =-1;
                System.out.println(numbers[i]);
                continue;
            }else if (first==0){
                numbers[0] = numstr.substring(0, 4);
                first =-1;
                System.out.println(numbers[i]);
                continue;
            }
            int begin;
            int end;
            if(yu>0){
                begin = (i - 1) * 4 + yu;
                end = (i) * 4 + yu;
            }else{
                begin = (i) * 4 + yu;
                end = (i + 1) * 4 + yu;
            }
            numbers[i] = numstr.substring(begin, end);
            System.out.println(numbers[i]);
        }
        System.out.println("=================================");
        for (int k = 0; k < numbers.length; k++) {
            String org = numbers[k];
            StringBuffer buffer = new StringBuffer();
            if(org.contains("0")){
                char[] chs = org.toCharArray();
                // 0100 1001 0001 0000 0101 1010 1110 1000 1100 101 110 100
                if (org.equals("0000")){
                    chinese.add(ch[0]);
                    continue;
                }
                // 1000 1010 1100 1110\110 100
                if (org.endsWith("0")){
                    if (chs.length==4){
                        if (chs[1]=='0'&&chs[2]=='0'&&chs[3]=='0'){
                            chinese.add(ch[getInt(chs[0])]+radix[3]);
                            continue;
                        }
                        if (chs[1]=='0'&&chs[3]=='0'){
                            chinese.add(ch[getInt(chs[0])]+radix[3]+"零"+ch[getInt(chs[2])]+"十");
                            continue;
                        }
                        if (chs[2]=='0'&&chs[3]=='0'){
                            chinese.add(ch[getInt(chs[0])]+radix[3]+ch[getInt(chs[1])]+"百");
                            continue;
                        }
                        if (chs[3]=='0'){
                            chinese.add(ch[getInt(chs[0])]+radix[3]+ch[getInt(chs[1])]+radix[2]+ch[getInt(chs[2])]+"十");
                            continue;
                        }
                    }else if (chs.length==3){
                        //110 100
                        if (chs[2]=='0'){
                            chinese.add(ch[getInt(chs[0])]+radix[2]+ch[getInt(chs[2])]+"十");
                            continue;
                        }
                        if (chs[2]=='0'&&chs[1]=='0'){
                            chinese.add(ch[getInt(chs[0])]+radix[2]);
                            continue;
                        }
                    }else{
                        chinese.add(ch[getInt(chs[0])]+radix[1]);
                        continue;
                    }
                }
                //处理 1001 1011 0111 0011 0001 0101 101
                if (chs[0]!='0'&&chs[1]=='0'&&chs[2]=='0'&&chs.length==4){
                    //1001
                    chinese.add(ch[getInt(chs[0])]+radix[3]+"零"+ch[getInt(chs[3])]);
                    continue;
                }else if (chs[0]!='0'&&chs[1]=='0'&&chs[2]!='0'&&chs.length==4){
                    //1011
                    chinese.add(ch[getInt(chs[0])]+radix[3]+"零"+ch[getInt(chs[2])]+"十"+ch[getInt(chs[3])]);
                    continue;
                }else if (chs[0]!='0'&&chs[1]!='0'&&chs[2]=='0'&&chs.length==4){
                    //1101
                    chinese.add(ch[getInt(chs[0])]+radix[3]+ch[getInt(chs[1])]+"百"+"零"+ch[getInt(chs[3])]);
                    continue;
                }else if (chs[0]=='0'&&chs[1]=='1'&&chs[2]=='0'&&chs.length==4) {
                    //0101
                    chinese.add("零" + ch[getInt(chs[1])] + radix[2] + "零" + ch[getInt(chs[3])]);
                    continue;
                }else if (chs[0]=='0'&&chs[1]!='0'&&chs[2]!='0'&&chs.length==4){
                    //0111
                    chinese.add("零"+ch[getInt(chs[1])]+radix[2]+ch[getInt(chs[2])]+radix[1]+ch[getInt(chs[3])]);
                    continue;
                }else if (chs[0]=='0'&&chs[1]=='0'&&chs[2]=='0'&&chs.length==4){
                    //0001
                    chinese.add("零"+ch[getInt(chs[3])]);
                    continue;
                }else if (chs[0]=='0'&&chs[1]=='0'&&chs[2]!='0'&&chs.length==4){
                    //0011
                    chinese.add("零"+ch[getInt(chs[2])]+"十"+ch[getInt(chs[3])]);
                    continue;
                }else if (chs[1]=='0'&&chs.length==3){
                    chinese.add(ch[getInt(chs[0])]+radix[2]+"零"+ch[getInt(chs[2])]);
                    continue;
                }
            }else {
                int member = Integer.parseInt(org);
                int len2 = org.length();
                for (int m = 0; m < len2; m++) {
                    int every = member % 10;
                    int leave = member / 10;
                    member = leave;
                    buffer.append(radix[m] + ch[every]);
                }
            }
            chinese.add(buffer.reverse().toString());
        }
        chinese.stream().forEach(s -> {
            System.out.print(s+" ");
        });
        System.out.println();
        StringBuffer all = new StringBuffer();
        //10        //3320        //0000        //0101        //1000
        //万4。亿8。万亿12，兆16，万兆20，京24，万京28，垓32.
        //一十京三千三百二十万零一百零一万一千
        //一十京三千三百二十万零一百零一万一千
        for (int index = 0; index<flag; index++) {
            String word = chinese.get(index);
            //大四位的零不读
            if (word.equals("零")){
                continue;
            }
            if (index ==flag-1){
                all.append(word);
            }else {
                String  small ="";
                //判断下一个4位是不是零，是则追加单位
                if (index!=flag-1 && chinese.get(index+1).equals("零")&&index%2!=1){
                    small=unit[flag-index-2]+unit[flag-index-1];
                }else {
                    small = unit[flag-index-2];
                }
                 all.append(word + small);
            }
        }
        System.out.println(all);
    }
    public static int getInt(char c){
        return Integer.parseInt(String.valueOf(c));
    }
}
