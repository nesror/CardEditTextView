package cn.yzapp.cardedittextview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.text.InputType;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;

/**
 * @author: nestor
 * time: 1/22 022-13:58.
 * email: nestor@yzapp.cn
 * desc: 每4位增加一个空格
 */
public class CardEditTextView extends EditText implements View.OnClickListener {

    private float mHintSize;
    private float mTextSize;
    private CharSequence mHint;

    public CardEditTextView(Context context) {
        super(context);
        setEditText();
    }

    public CardEditTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setAttrs(context, attrs);
        setEditText();
    }

    public CardEditTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setAttrs(context, attrs);
        setEditText();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CardEditTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setAttrs(context, attrs);
        setEditText();
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        if (focused) hideHintAndGravity2Left();
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
    }

    @Override
    public void onClick(View view) {
        if (TextUtils.isEmpty(getText())) hideHintAndGravity2Left();
    }

    private void setAttrs(Context context, AttributeSet attrs) {
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CardEditTextView_CardEditTextView,
                0, 0);
        try {
            mHintSize = a.getDimension(R.styleable.CardEditTextView_CardEditTextView_CardEditTextView_hintSize, 0);
            mTextSize = a.getDimension(R.styleable.CardEditTextView_CardEditTextView_CardEditTextView_textSize, 0);
        } finally {
            a.recycle();
        }
    }

    protected void setEditText() {
        mHint = getHint();
        setInputType(InputType.TYPE_CLASS_NUMBER);
        addTextChangedListener(new CardWatcher(this, mHintSize, mTextSize));
        setOnClickListener(this);
    }

    /**
     * 隐藏Hint并文字居左
     */
    public void hideHintAndGravity2Left() {
        setHint("");
        setGravity(Gravity.START);
        setCursorVisible(true);
    }

    /**
     * 显示Hint并文字居中
     */
    public void ShowHintAndGravity2Center() {
        setHint(mHint);
        setGravity(Gravity.CENTER);
        setCursorVisible(false);
    }

    /**
     * 设置显示hint时的字体大小
     *
     * @param size dx
     */
    public void setHintSize(float size) {
        mHintSize = size;
        setTextSize(size);
    }

    /**
     * 设置显示内容时的字体大小
     *
     * @param size dx
     */
    public void setNumSize(float size) {
        mTextSize = size;
    }
}
