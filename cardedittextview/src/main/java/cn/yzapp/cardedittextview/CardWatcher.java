package cn.yzapp.cardedittextview;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import cn.yzapp.cardedittextview.Util.ViewUtil;

/**
 * @author: nestor
 * time: 1/22 022-13:58.
 * email: nestor@yzapp.cn
 * desc:
 */
public class CardWatcher implements TextWatcher {
    private String mNewText;
    private EditText mEditText;
    private int mHintSize;
    private int mNumSize;

    public CardWatcher(EditText EditText) {
        mEditText = EditText;
    }

    public CardWatcher(EditText EditText, int hintSize, int numSize) {
        mEditText = EditText;
        mHintSize = hintSize;
        mNumSize = numSize;
    }

    @Override
    public void beforeTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {

    }

    @Override
    public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        if (text.length() == 0) {
            //mEditText.setCursorVisible(false);
            //mEditText.setHint(mHint);
            //mEditText.setGravity(Gravity.CENTER);
            if (mHintSize != 0) mEditText.setTextSize(mHintSize);
        } else {
            //mEditText.setCursorVisible(true);
            //mEditText.setGravity(Gravity.START);
            if (mNumSize != 0) mEditText.setTextSize(mNumSize);
        }

        String newText = "";
        String temp = text.toString();
        temp = temp.replace(" ", "");
        //每4位增加一个空格
        for (int i = 0; i < temp.length(); i++) {
            newText = newText + temp.subSequence(i, i + 1);
            if ((i + 1) % 4 == 0 && newText.length() < ViewUtil.getMaxLength(mEditText)) {
                newText = newText + " ";
            }
        }

        if (mNewText == null || !newText.equals(mNewText)) {
            mNewText = newText;
            mEditText.setText(newText);
            mEditText.setSelection(newText.length());
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
