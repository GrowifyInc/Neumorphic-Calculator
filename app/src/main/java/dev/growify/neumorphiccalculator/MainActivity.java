package dev.growify.neumorphiccalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.TextViewCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout mActivityMainLayout;
    private ImageView mDarkToggle, mImgModeInd1, mImgModeInd2;
    private ImageView mInputField;
    private TextView mTextIndicator;
    SharedPreferences sharedPreferences;
    private TextView mEqTextView, mInputFieldTextView, mTempText;
    private View mInputFieldDivider;
    private static final char ADDITION = '+', SUBTRACTION = '-', MULTITPLICATION = '*', DIVISION = '/';
    private char CURRENT_ACTION;
    DecimalFormat decimalFormat = new DecimalFormat("#.##########");
    private double valueOne = Double.NaN, valueTwo;
    private ImageView mbuttonOne, mbuttonTwo, mbuttonThree, mbuttonDiv, mbuttonFour, mbuttonFive, mbuttonSix, mbuttonMul, mbuttonSeven, mbuttonEight, mbuttonNine, mbuttonSub, mbuttonZero, mbuttonDot, mbuttonEq, mbuttonAdd, mbuttonC, mbuttonCE, mbuttonback, mButtonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("isAppDarkEnabled", MODE_PRIVATE);
        if (sharedPreferences.getBoolean("isDarkEnabled", true))
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        setContentView(R.layout.activity_main);

        mActivityMainLayout = findViewById(R.id.activityMainLayout);
        mDarkToggle = findViewById(R.id.dark_toggle);
        mInputField = findViewById(R.id.input_field);
        mTextIndicator = findViewById(R.id.textIndicator);
        mImgModeInd1 = findViewById(R.id.imgModeInd1);
        mImgModeInd2 = findViewById(R.id.imgModeInd2);
        mbuttonOne = findViewById(R.id.button_one);
        mbuttonTwo = findViewById(R.id.button_two);
        mbuttonThree = findViewById(R.id.button_three);
        mbuttonDiv = findViewById(R.id.button_div);
        mbuttonFour = findViewById(R.id.button_four);
        mbuttonFive = findViewById(R.id.button_five);
        mbuttonSix = findViewById(R.id.button_six);
        mbuttonMul = findViewById(R.id.button_mul);
        mbuttonSeven = findViewById(R.id.button_seven);
        mbuttonEight = findViewById(R.id.button_eight);
        mbuttonNine = findViewById(R.id.button_nine);
        mbuttonSub = findViewById(R.id.button_sub);
        mbuttonZero = findViewById(R.id.button_zero);
        mbuttonDot = findViewById(R.id.button_dot);
        mbuttonEq = findViewById(R.id.button_eq);
        mbuttonAdd = findViewById(R.id.button_add);
        mEqTextView = findViewById(R.id.eqTextView);
        mInputFieldDivider = findViewById(R.id.input_field_divider);
        mInputFieldTextView = findViewById(R.id.input_field_textView);
        mTempText = findViewById(R.id.tempText);
        mbuttonC = findViewById(R.id.button_c);
        mbuttonCE = findViewById(R.id.button_ce);
        mbuttonback = findViewById(R.id.button_back);
        mButtonInfo = findViewById(R.id.buttonInfo);

        mButtonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ViewGroup viewGroup = findViewById(android.R.id.content);
                final View aboutView = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_about_app_activity, viewGroup, false);
                ExtendedFloatingActionButton mAboutClose = aboutView.findViewById(R.id.aboutClose);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(aboutView);
                final AlertDialog alertDialog = builder.create();
                alertDialog.show();
                mAboutClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
            }
        });

        mbuttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (mInputFieldTextView.getText().toString().equals("0"))
               {
                   mInputFieldTextView.setText("1");
               }
               else
               {
                   mInputFieldTextView.setText(mInputFieldTextView.getText().toString()+"1");
               }
            }
        });
        mbuttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInputFieldTextView.getText().toString().equals("0"))
                {
                    mInputFieldTextView.setText("2");
                }
                else
                {
                    mInputFieldTextView.setText(mInputFieldTextView.getText().toString()+"2");
                }
            }
        });
        mbuttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInputFieldTextView.getText().toString().equals("0"))
                {
                    mInputFieldTextView.setText("3");
                }
                else
                {
                    mInputFieldTextView.setText(mInputFieldTextView.getText().toString()+"3");
                }
            }
        });
        mbuttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInputFieldTextView.getText().toString().equals("0"))
                {
                    mInputFieldTextView.setText("4");
                }
                else
                {
                    mInputFieldTextView.setText(mInputFieldTextView.getText().toString()+"4");
                }
            }
        });
        mbuttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInputFieldTextView.getText().toString().equals("0"))
                {
                    mInputFieldTextView.setText("5");
                }
                else
                {
                    mInputFieldTextView.setText(mInputFieldTextView.getText().toString()+"5");
                }
            }
        });
        mbuttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInputFieldTextView.getText().toString().equals("0"))
                {
                    mInputFieldTextView.setText("6");
                }
                else
                {
                    mInputFieldTextView.setText(mInputFieldTextView.getText().toString()+"6");
                }
            }
        });
        mbuttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInputFieldTextView.getText().toString().equals("0"))
                {
                    mInputFieldTextView.setText("7");
                }
                else
                {
                    mInputFieldTextView.setText(mInputFieldTextView.getText().toString()+"7");
                }
            }
        });
        mbuttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInputFieldTextView.getText().toString().equals("0"))
                {
                    mInputFieldTextView.setText("8");
                }
                else
                {
                    mInputFieldTextView.setText(mInputFieldTextView.getText().toString()+"8");
                }
            }
        });
        mbuttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInputFieldTextView.getText().toString().equals("0"))
                {
                    mInputFieldTextView.setText("9");
                }
                else
                {
                    mInputFieldTextView.setText(mInputFieldTextView.getText().toString()+"9");
                }
            }
        });
        mbuttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInputFieldTextView.getText().toString().equals("0"))
                {
                    mInputFieldTextView.setText("0");
                }
                else
                {
                    mInputFieldTextView.setText(mInputFieldTextView.getText().toString()+"0");
                }
            }
        });
        mbuttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String current = mInputFieldTextView.getText().toString();
                if (current.length()>1)
                {
                    current = current.substring(0, current.length() - 1);
                    mInputFieldTextView.setText(current);
                }
                else if (current.length()<=1)
                {
                    mInputFieldTextView.setText("0");
                }
                else
                {
                    mInputFieldTextView.setText("0");
                }
            }
        });

        mbuttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInputFieldTextView.setText(mInputFieldTextView.getText().toString()+".");
            }
        });

        mbuttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInputFieldTextView.setText("0");
            }
        });

        mbuttonCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = 0;
                valueTwo = 0;
                mInputFieldTextView.setText("0");
                mTempText.setText(null);
            }
        });

        mbuttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                CURRENT_ACTION = ADDITION;
                mTempText.setText(decimalFormat.format(valueOne)+"+");
                mInputFieldTextView.setText(null);
            }
        });

        mbuttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                CURRENT_ACTION = SUBTRACTION;
                mTempText.setText(decimalFormat.format(valueOne)+"-");
                mInputFieldTextView.setText(null);
            }
        });

        mbuttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                CURRENT_ACTION = MULTITPLICATION;
                mTempText.setText(decimalFormat.format(valueOne)+"x");
                mInputFieldTextView.setText(null);
            }
        });

        mbuttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                CURRENT_ACTION = DIVISION;
                mTempText.setText(decimalFormat.format(valueOne)+"+");
                mInputFieldTextView.setText(null);
            }
        });

        mbuttonEq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computeCalculation();
                mTempText.setText(mTempText.getText().toString() + decimalFormat.format(valueTwo)+"=");
                mInputFieldTextView.setText(decimalFormat.format(valueOne));
                valueOne = Double.NaN;
                CURRENT_ACTION = '0';
            }
        });


        mDarkToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_NO)
                {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    sharedPreferences.edit().putBoolean("isDarkEnabled", true).apply();
                }
                else
                {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    sharedPreferences.edit().putBoolean("isDarkEnabled", false).apply();
                }
                recreate();
            }
        });
    }
    protected void onStart()
    {
        super.onStart();
        if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES)
        {
            mActivityMainLayout.setBackgroundColor(getResources().getColor(R.color.darkMaterialBackground));
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.darkStatus));
            mDarkToggle.setImageDrawable(getResources().getDrawable(R.drawable.dark_toggle_dark));
            mInputField.setImageDrawable(getResources().getDrawable(R.drawable.dark_input_field));
            mImgModeInd2.setImageDrawable(getResources().getDrawable(R.drawable.baseline_wb_moon_24));
            mImgModeInd1.setImageDrawable(getResources().getDrawable(R.drawable.baseline_wb_moon_24_white));

            mbuttonOne.setImageDrawable(getResources().getDrawable(R.drawable.button_normal_dark));
            mbuttonTwo.setImageDrawable(getResources().getDrawable(R.drawable.button_normal_dark));
            mbuttonThree.setImageDrawable(getResources().getDrawable(R.drawable.button_normal_dark));
            mbuttonDiv.setImageDrawable(getResources().getDrawable(R.drawable.button_normal_dark));
            mbuttonFour.setImageDrawable(getResources().getDrawable(R.drawable.button_normal_dark));
            mbuttonFive.setImageDrawable(getResources().getDrawable(R.drawable.button_normal_dark));
            mbuttonSix.setImageDrawable(getResources().getDrawable(R.drawable.button_normal_dark));
            mbuttonMul.setImageDrawable(getResources().getDrawable(R.drawable.button_normal_dark));
            mbuttonSeven.setImageDrawable(getResources().getDrawable(R.drawable.button_normal_dark));
            mbuttonEight.setImageDrawable(getResources().getDrawable(R.drawable.button_normal_dark));
            mbuttonNine.setImageDrawable(getResources().getDrawable(R.drawable.button_normal_dark));
            mbuttonSub.setImageDrawable(getResources().getDrawable(R.drawable.button_normal_dark));
            mbuttonZero.setImageDrawable(getResources().getDrawable(R.drawable.button_normal_dark));
            mbuttonDot.setImageDrawable(getResources().getDrawable(R.drawable.button_normal_dark));
            mbuttonEq.setImageDrawable(getResources().getDrawable(R.drawable.button_eq_dark));
            mbuttonAdd.setImageDrawable(getResources().getDrawable(R.drawable.button_normal_dark));
            mbuttonC.setImageDrawable(getResources().getDrawable(R.drawable.button_normal_dark));
            mbuttonCE.setImageDrawable(getResources().getDrawable(R.drawable.button_normal_dark));
            mbuttonback.setImageDrawable(getResources().getDrawable(R.drawable.button_normal_dark));

            mEqTextView.setTextColor(getResources().getColor(R.color.darkMaterialBackground));
            mInputFieldDivider.setBackgroundColor(getResources().getColor(R.color.darkDivier));
            mTextIndicator.setText("Night Mode");
            mInputFieldTextView.setTextColor(getResources().getColor(android.R.color.darker_gray));
        }
        else
        {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorAccent));
            mImgModeInd2.setImageDrawable(getResources().getDrawable(R.drawable.baseline_wb_sunny_24));
            mImgModeInd1.setImageDrawable(getResources().getDrawable(R.drawable.baseline_wb_sunny_24_white));
            mTextIndicator.setText("Day Mode");
        }
        TextViewCompat.setAutoSizeTextTypeWithDefaults(mInputFieldTextView, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);
    }
    private void computeCalculation()
    {
        if(!Double.isNaN(valueOne))
        {
            valueTwo = Double.parseDouble(mInputFieldTextView.getText().toString());
            mInputFieldTextView.setText(null);

            if (CURRENT_ACTION == ADDITION)
            {
                valueOne = this.valueOne + valueTwo;
            }
            else if (CURRENT_ACTION == SUBTRACTION)
            {
                valueOne = this.valueOne - valueTwo;
            }
            else if (CURRENT_ACTION == MULTITPLICATION)
            {
                valueOne = this.valueOne * valueTwo;
            }
            else if (CURRENT_ACTION == DIVISION)
            {
                valueOne = this.valueOne / valueTwo;
            }
        }
        else
        {
            try {
                valueOne = Double.parseDouble(mInputFieldTextView.getText().toString());
            }
            catch (Exception e){}
        }
    }
}
