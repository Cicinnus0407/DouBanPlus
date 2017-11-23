package com.cicinnus.doubanplus.view.draw_view;

/**
 * @author Cicinnus
 *         on 2017/11/22.
 */

public class MathUtils {
    public static float constrain(float min, float max, float value) {
        //在范围内返回value
        if(value>=min&&value<=max){
            return value;
        }else {
            //不在范围内返回两个极值
            if(value<min){
                return min;
            }else if(value>max){
                return max;
            }else return value;
        }
    }
}
