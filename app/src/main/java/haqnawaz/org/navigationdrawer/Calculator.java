package haqnawaz.org.navigationdrawer;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class Calculator extends AppCompatActivity {

    private EditText display;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display=findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((getString(R.string.display).equals(display.getText().toString()))||("Error".equals(display.getText().toString()))){
                    display.setText("");
                }
            }
        });
    }

    private void updateText(String strToAdd){
        String oldStr=display.getText().toString();
        int cursorPos=display.getSelectionStart();
        String leftStr=oldStr.substring(0,cursorPos);
        String rightStr=oldStr.substring(cursorPos);
        if((getString(R.string.display).equals(display.getText().toString()))||("Error".equals(display.getText().toString()))){
            display.setText(strToAdd);
            display.setSelection(cursorPos+1);
        }
        else {
            display.setText(String.format("%s%s%s",leftStr,strToAdd,rightStr));
        }
        display.setSelection(cursorPos+1);
    }

    public void btnZero(View view){
        updateText("0");
    }

    public void btnOne(View view){
        updateText("1");
    }

    public void btnTwo(View view){
        updateText("2");
    }

    public void btnThree(View view){
        updateText("3");
    }

    public void btnFour(View view){
        updateText("4");
    }
    public void btnFive(View view){
        updateText("5");
    }

    public void btnSix(View view){
        updateText("6");
    }

    public void btnSeven(View view){
        updateText("7");
    }

    public void btnEight(View view){
        updateText("8");
    }

    public void btnNine(View view){
        updateText("9");
    }

    public void btnClear(View view){
        display.setText("");
    }

    public void btnExponent(View view){
        updateText("^");
    }

    public void btnDot(View view){
        updateText(".");
    }

    public void btnMultiply(View view){
        updateText("×");
    }

    public void btnDivide(View view){
        updateText("÷");
    }

    public void btnMinus(View view){
        updateText("-");
    }

    public void btnPlus(View view){
        updateText("+");
    }

    public void btnParentheses(View view){
        int cursorPos=display.getSelectionStart();
        int openParen=0;
        int closeParen=0;
        int textLn=display.getText().length();
        for(int i=0;i<cursorPos;i++){
            if(display.getText().toString().substring(i,i+1).equals("(")){
                openParen+=1;
            }
            if(display.getText().toString().substring(i,i+1).equals(")")){
                closeParen+=1;
            }
        }

        if(openParen==closeParen || display.getText().toString().substring(textLn-1,textLn).equals("(")){
            updateText("(");
        }
        else if(closeParen < openParen && !display.getText().toString().substring(textLn-1,textLn).equals("(")){
            updateText(")");
        }
        display.setSelection(cursorPos+1);
    }

    public void btnBackspace(View view){
        int cursorPos=display.getSelectionStart();
        int textLn=display.getText().length();
        if(cursorPos !=0 && textLn !=0){
            SpannableStringBuilder selection=(SpannableStringBuilder)display.getText();
            selection.replace(cursorPos-1,cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }


    public void btnPlusMinus(View view){
        updateText("-");

    }
    public void btnEqual(View view){
        String userExp=display.getText().toString();
        userExp=userExp.replaceAll("÷","/");
        userExp=userExp.replaceAll("×","*");
        String res="";

        Context rhino = Context.enter();

        rhino.setOptimizationLevel(-1);
        try {
            Scriptable scriptable = rhino.initStandardObjects();
            res = rhino.evaluateString(scriptable,userExp, "javascript", 1, null).toString();
            display.setText(res);
            display.setSelection(res.length());

        } catch (Exception e) {
            //res = "Error";
            display.setText("Error");
            display.setSelection(res.length());

        }


        //Expression exp=new Expression(userExp);
        //String result=String.valueOf(exp.calculate());
    }


}