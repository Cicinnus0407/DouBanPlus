package com.cicinnus.doubanplus.utils;

import com.cicinnus.doubanplus.base.IteratorObj;

import java.util.Iterator;

/**
 * Created by Cicinnus
 * on 2017/11/26.
 */

public class StringUtils {


    /**
     * 从迭代器中将所有的数据拼接成字符串
     * @param args 拼接间隔符
     * @return 拼接的字符串
     */
    public static String getStringFromIterator(Iterator<? extends IteratorObj> iterator, String args){
        StringBuilder builder = new StringBuilder();
        while (iterator.hasNext()){
            builder.append(iterator.next().getIteratorString()).append(args);
        }
        if (builder.length()>args.length()) {
            builder.delete(builder.length()-args.length(),builder.length());
        }
        return builder.toString();
    }


}
