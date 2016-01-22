package cn.yzapp.cardedittextview.Util;

import android.text.InputFilter;
import android.widget.EditText;

import java.lang.reflect.Field;

/**
 * @author: nestor
 * @time: 1/22 022-13:58.
 * @email: nestor@yzapp.cn
 * @desc:
 */
public class ViewUtil {
    /**
     * 得到EditText最大长度
     * @param view EditText
     * @return 最大长度
     */
    public static int getMaxLength(EditText view) {
        int length = 0;
        try {
            InputFilter[] inputFilters = view.getFilters();
            for (InputFilter filter : inputFilters) {
                Class<?> c = filter.getClass();
                if (c.getName().equals("android.text.InputFilter$LengthFilter")) {
                    Field[] f = c.getDeclaredFields();
                    for (Field field : f) {
                        if (field.getName().equals("mMax")) {
                            field.setAccessible(true);
                            length = (Integer) field.get(filter);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return length;
    }
}
