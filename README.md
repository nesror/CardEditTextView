CardEditTextView
========
一个cardId输入的EditText,每4位增加一个空格，可以分别设置hint和number的字体大小，自动对齐控制
<img src="img\Screenshot_1.png" width="300" height="550"/>
<img src="img\Screenshot_2.png" width="300" height="550"/>

Add CardEditTextView to your project
----------------------------

Gradle:
```
   compile 'cn.yzapp.cardedittextview:cardedittextview:1.0.0@aar'
```

Maven:
```
<dependency>
   <groupId>cn.yzapp.cardedittextview</groupId>
   <artifactId>cardedittextview</artifactId>
   <version>1.0.0</version>
   <type>aar</type>
</dependency>
```
[ ![Download](https://api.bintray.com/packages/nesror/maven/CardEditTextView/images/download.svg) ](https://bintray.com/artifact/download/nesror/maven/cn/yzapp/cardedittextview/cardedittextview/1.0.0/cardedittextview-1.0.0.aar)

Use
----------------------------
````
<cn.yzapp.cardedittextview.CardEditTextView
        xmlns:cardedit="http://schemas.android.com/apk/res-auto"
        android:id="@+id/et_ccode"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"
        android:gravity="center"
        android:hint="输入卡号"
        android:imeOptions="actionDone"
        android:maxLength="19"
        android:padding="10dp"
        android:privateImeOptions="验证"
        android:textColor="#fb6d86"
        android:textColorHint="#fda8b7"
        cardedit:CardEditTextView_hintSize="18"
        cardedit:CardEditTextView_textSize="26"/>
````

 * hideHintAndGravity2Left()
  * 隐藏Hint并文字居左 默认获得焦点和点击时触发
 * ShowHintAndGravity2Center()
  *  显示Hint并文字居中 需要时手动调用
 * setHintSize(int size)
  *  设置显示hint时的字体大小（也可以在布局文件里设置）
 * setNumSize(int size)
  *  设置显示内容时的字体大小（也可以在布局文件里设置）

Release History
------------------------
[CHANGELOG](CHANGELOG.md)
