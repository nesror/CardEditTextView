package cn.yzapp.cardedittextview;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
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
    private float mHintSize;
    private float mNumSize;

    public CardWatcher(EditText EditText, float hintSize, float numSize) {
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
            if (mHintSize != 0) mEditText.setTextSize(TypedValue.COMPLEX_UNIT_PX, mHintSize);
        } else {
            if (mNumSize != 0) mEditText.setTextSize(TypedValue.COMPLEX_UNIT_PX, mNumSize);
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
        int selection = Math.min(mEditText.getSelectionStart(), mEditText.getSelectionEnd()) + (newText.length() - text.toString().length());

        if (mNewText == null || !newText.equals(mNewText)) {
            mNewText = newText;
            mEditText.setText(newText);
            mEditText.setSelection(selection);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
