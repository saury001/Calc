package calc.divya.com.calculatot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private String currentOp;
    private float firstNum,secondNum,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display=(TextView)findViewById(R.id.display);
    }

    public void onDigitPressed(View view){

        Button btn=(Button)view;
        if(display.getText().toString().equals("0"))
            display.setText(btn.getText());
        else
            display.append(btn.getText());


    }
    public void onOpPressed(View view){
        Button btn=(Button)view;
        currentOp=btn.getText().toString();
        try {
            firstNum = Integer.parseInt(display.getText().toString());
        }
        catch(Exception e){

        }
        display.setText("");
    }
    public void clearDisplay(View v){
        display.setText("0");
    }

    public void calculate(View v){
        try {
            secondNum = Integer.parseInt(display.getText().toString());
        }
        catch(Exception e){

        }
        switch (currentOp){
            case "+" : result=firstNum+secondNum;
                break;
            case "-" : result=firstNum-secondNum;
                break;
            case "*" : result=firstNum*secondNum;
                break;
            case "/" :
                try{
                    result=firstNum/secondNum;
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"You are supposed to use common sense!",Toast.LENGTH_SHORT).show();
                }
                break;
        }
        display.setText(result+"");
    }

}
