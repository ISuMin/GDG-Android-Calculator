package com.example.nanog.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

// 4/23/2016...
// Hi!
// Спохватился в последний день и ничего толком не успел.
// Работает 10-чный с переводом в остальные системы счисления и двоичный, но тут уже без перевода.
// До этого на Java не писал ни разу. Использовал стек HTML, CSS, JS, Apache Cordova.//

// 4/26/2016...
// It's alive!!!
// За час сделал то над чем раньше тупил половину суток.
// Как я рад.
// Всё работает, почти все пожелания учтены.
// Извиняюсь за лишние комментарии.

public class Calculator extends AppCompatActivity {

    //    Объявление переменных
    private Button DEC_Btn;
    private Button HEX_Btn;
    private Button OCT_Btn;
    private Button BIN_Btn;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    private Button btnZero;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnSeven;
    private Button btnEight;
    private Button btnNine;
    private Button btnPlus;
    private Button btnMinus;
    private Button btnMultiply;
    private Button btnDivide;
    private Button btnEquals;
    private Button btnReset;
    private ImageButton btnBack;
    private Button btnA;
    private Button btnB;
    private Button btnC;
    private Button btnD;
    private Button btnE;
    private Button btnF;

    private int num = 0;

    private int operator = 1;
    // 0 = ничего
    // 1 = сложение
    // 2 = вычитание
    // 3 = умножение
    // 4 = деление

    private boolean readyToClear = false;
    private boolean hasChanged = false;

    boolean decCheck = false;
    boolean hexCheck = false;
    boolean octCheck = false;
    boolean binCheck = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        initControls();
        reset();
        dec();
    }

    //    Обработка нажатий
    private void initControls() {

        //
        DEC_Btn = (Button) findViewById(R.id.DEC_Btn);
        HEX_Btn = (Button) findViewById(R.id.HEX_Btn);
        OCT_Btn = (Button) findViewById(R.id.OCT_Btn);
        BIN_Btn = (Button) findViewById(R.id.BIN_Btn);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        text4 = (TextView) findViewById(R.id.text4);
        btnZero = (Button) findViewById(R.id.btnZero);
        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnThree = (Button) findViewById(R.id.btnThree);
        btnFour = (Button) findViewById(R.id.btnFour);
        btnFive = (Button) findViewById(R.id.btnFive);
        btnSix = (Button) findViewById(R.id.btnSix);
        btnSeven = (Button) findViewById(R.id.btnSeven);
        btnEight = (Button) findViewById(R.id.btnEight);
        btnNine = (Button) findViewById(R.id.btnNine);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        btnEquals = (Button) findViewById(R.id.btnEquals);
        btnReset = (Button) findViewById(R.id.btnReset);
        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnA = (Button) findViewById(R.id.btnA);
        btnB = (Button) findViewById(R.id.btnB);
        btnC = (Button) findViewById(R.id.btnC);
        btnD = (Button) findViewById(R.id.btnD);
        btnE = (Button) findViewById(R.id.btnE);
        btnF = (Button) findViewById(R.id.btnF);

        //        Вызов цифр
        btnZero.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(0);
            }
        });
        btnOne.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(1);
            }
        });
        btnTwo.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(2);
            }
        });
        btnThree.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(3);
            }
        });
        btnFour.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(4);
            }
        });
        btnFive.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(5);
            }
        });
        btnSix.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(6);
            }
        });
        btnSeven.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(7);
            }
        });
        btnEight.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(8);
            }
        });
        btnNine.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(9);
            }
        });
        btnA.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(10);
            }
        });
        btnB.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(11);
            }
        });
        btnC.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(12);
            }
        });
        btnD.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(13);
            }
        });
        btnE.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(14);
            }
        });
        btnF.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(15);
            }
        });

        //        Вызов опереторов
        btnPlus.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleEquals(1);
            }
        });
        btnMinus.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleEquals(2);
            }
        });
        btnMultiply.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleEquals(3);
            }
        });
        btnDivide.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleEquals(4);
            }
        });
        btnEquals.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleEquals(0);
            }
        });

        //        Вызов функций сброс и стирание
        btnReset.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                reset();
            }
        });
        btnBack.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleBackspace();
            }
        });

        //        Выбор системы счисления
        DEC_Btn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                dec();
            }
        });
        HEX_Btn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                hex();
            }
        });
        OCT_Btn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                oct();
            }
        });
        BIN_Btn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                bin();
            }
        });
    }

    //    Обработка функций
    private void handleEquals(int newOperator) {

        String txt;
        int num1 = Integer.parseInt(text1.getText().toString());
        int num2 = Integer.parseInt(text2.getText().toString(), 16);
        int num3 = Integer.parseInt(text3.getText().toString(), 8);
        int num4 = Integer.parseInt(text4.getText().toString(), 2);

        if (hasChanged) {
            switch (operator) {
                case 1:
                    if (decCheck) {
                        num = num + num1;
                        txt = Integer.toString(num);
                        handleVisionDec(txt);
                    }
                    if (hexCheck) {
                        num = num + num2;
                        txt = Integer.toHexString(num);
                        handleVisionHex(txt);
                    }
                    if (octCheck) {
                        num = num + num3;
                        txt = Integer.toOctalString(num);
                        handleVisionOct(txt);
                    }
                    if (binCheck) {
                        num = num + num4;
                        txt = Integer.toBinaryString(num);
                        handleVisionBin(txt);
                    }
                    break;
                case 2:
                    if (decCheck) {
                        num = num - num1;
                        txt = Integer.toString(num);
                        handleVisionDec(txt);
                    }
                    if (hexCheck) {
                        num = num - num2;
                        txt = Integer.toHexString(num);
                        handleVisionHex(txt);
                    }
                    if (octCheck) {
                        num = num - num3;
                        txt = Integer.toOctalString(num);
                        handleVisionOct(txt);
                    }
                    if (binCheck) {
                        num = num - num4;
                        txt = Integer.toBinaryString(num);
                        handleVisionBin(txt);
                    }
                    break;
                case 3:
                    if (decCheck) {
                        num = num * num1;
                        txt = Integer.toString(num);
                        handleVisionDec(txt);
                    }
                    if (hexCheck) {
                        num = num * num2;
                        txt = Integer.toHexString(num);
                        handleVisionHex(txt);
                    }
                    if (octCheck) {
                        num = num * num3;
                        txt = Integer.toOctalString(num);
                        handleVisionOct(txt);
                    }
                    if (binCheck) {
                        num = num * num4;
                        txt = Integer.toBinaryString(num);
                        handleVisionBin(txt);
                    }
                    break;
                case 4:
                    if (decCheck) {
                        if (num1!=0) {
                            num = num / num1;
                            txt = Integer.toString(num);
                            handleVisionDec(txt);
                        } else {
                            text1.setText(R.string.non_zero);
                        }
                    }
                    if (hexCheck) {
                        if (num2!=0) {
                            num = num / num2;
                            txt = Integer.toHexString(num);
                            handleVisionHex(txt);
                        } else {
                            text2.setText(R.string.non_zero);
                        }
                    }
                    if (octCheck) {
                        if (num3!=0) {
                            num = num / num3;
                            txt = Integer.toOctalString(num);
                            handleVisionOct(txt);
                        } else {
                            text3.setText(R.string.non_zero);
                        }
                    }
                    if (binCheck) {
                        if (num4!=0) {
                            num = num / num4;
                            txt = Integer.toBinaryString(num);
                            handleVisionBin(txt);
                        } else {
                            text4.setText(R.string.non_zero);
                        }
                    }
                    break;
            }

            readyToClear = true;
            hasChanged = false;
        }

        operator = newOperator;
    }

    //    Вывод числа на экран
    private void handleNumber(int num) {
        if (operator == 0)
            reset();

        if (decCheck) {

            String txt = text1.getText().toString();
            if (readyToClear) {
                txt = "";
                readyToClear = false;
            } else if (txt.equals("0"))
                txt = "";
            txt = txt + Integer.toString(num);
            handleVisionDec(txt);

        } else if (hexCheck) {

            String txt = text2.getText().toString();
            if (readyToClear) {
                txt = "";
                readyToClear = false;
            } else if (txt.equals("0"))
                txt = "";
            String hex = Integer.toString(num);
            switch (num){
                case 10:
                    hex = "A";
                    break;
                case 11:
                    hex = "B";
                    break;
                case 12:
                    hex = "C";
                    break;
                case 13:
                    hex = "D";
                    break;
                case 14:
                    hex = "E";
                    break;
                case 15:
                    hex = "F";
                    break;
            }
            txt = txt + hex;
            handleVisionHex(txt);

        } else if (octCheck) {

            String txt = text3.getText().toString();
            if (readyToClear) {
                txt = "";
                readyToClear = false;
            } else if (txt.equals("0"))
                txt = "";
            txt = txt + Integer.toString(num);
            handleVisionOct(txt);

        } else if (binCheck) {

            String txt = text4.getText().toString();
            if (readyToClear) {
                txt = "";
                readyToClear = false;
            } else if (txt.equals("0"))
                txt = "";
            txt = txt + Integer.toString((int) num);
            handleVisionBin(txt);
        }

        hasChanged = true;
    }

    private void handleVisionDec(String txt) {
        // DEC
        text1.setText(txt);
        // HEX
        text2.setText(Integer.toHexString(Integer.parseInt(text1.getText().toString())));
        // OCT
        text3.setText(Integer.toOctalString(Integer.parseInt(text1.getText().toString())));
        // BIN
        text4.setText(Integer.toBinaryString(Integer.parseInt(text1.getText().toString())));
    }

    private void handleVisionHex(String txt) {
        // HEX
        text2.setText(txt);
        // DEC
        text1.setText(Integer.toString(Integer.parseInt(text2.getText().toString(), 16)));
        // OCT
        text3.setText(Integer.toOctalString(Integer.parseInt(text2.getText().toString(), 16)));
        // BIN
        text4.setText(Integer.toBinaryString(Integer.parseInt(text2.getText().toString(), 16)));
    }

    private void handleVisionOct(String txt) {
        // OCT
        text3.setText(txt);
        // DEC
        text1.setText(Integer.toString(Integer.parseInt(text3.getText().toString(), 8)));
        // HEX
        text2.setText(Integer.toHexString(Integer.parseInt(text3.getText().toString(), 8)));
        // BIN
        text4.setText(Integer.toBinaryString(Integer.parseInt(text3.getText().toString(), 8)));
    }

    private void handleVisionBin(String txt) {
        // BIN
        text4.setText(txt);
        // DEC
        text1.setText(Integer.toString(Integer.parseInt(text4.getText().toString(), 2)));
        // HEX
        text2.setText(Integer.toHexString(Integer.parseInt(text4.getText().toString(), 2)));
        // OCT
        text3.setText(Integer.toOctalString(Integer.parseInt(text4.getText().toString(), 2)));
    }

    ///////////////////////////////////////////////

    //    Стирание последнего символа
    private void handleBackspace() {
        if (!readyToClear) {
            if (decCheck) {
                String txt = text1.getText().toString();
                output(txt);
            } else if (hexCheck) {
                String txt = text2.getText().toString();
                output(txt);
            } else if (octCheck) {
                String txt = text3.getText().toString();
                output(txt);
            } else if (binCheck) {
                String txt = text4.getText().toString();
                output(txt);
            }
        }
    }
    private void output(String txt) {
        if (txt.length() > 0) {
            txt = txt.substring(0, txt.length() - 1);
            if (txt.equals(""))
                txt = "0";

            if (decCheck) {
                handleVisionDec(txt);
            } else if (hexCheck) {
                handleVisionHex(txt);
            } else if (octCheck) {
                handleVisionOct(txt);
            } else if (binCheck) {
                handleVisionBin(txt);
            }
        }
    }

    //    Сброс
    private void reset() {
        num = 0;
        text1.setText("");
        text2.setText("");
        text3.setText("");
        text4.setText("");
        operator = 1;
        readyToClear = false;
        hasChanged = false;
    }

    //    Блокирование кнопок не включёнынх в 10-чную систему
    public void dec() {
        DEC_Btn.setBackgroundColor(0x206C6C6C);
        HEX_Btn.setBackgroundColor(0x00FFFFFF);
        OCT_Btn.setBackgroundColor(0x00FFFFFF);
        BIN_Btn.setBackgroundColor(0x00FFFFFF);
        btnTwo.setEnabled(true);
        btnThree.setEnabled(true);
        btnFour.setEnabled(true);
        btnFive.setEnabled(true);
        btnSix.setEnabled(true);
        btnSeven.setEnabled(true);
        btnEight.setEnabled(true);
        btnNine.setEnabled(true);
        btnBack.setEnabled(true);
        btnA.setEnabled(false);
        btnB.setEnabled(false);
        btnC.setEnabled(false);
        btnD.setEnabled(false);
        btnE.setEnabled(false);
        btnF.setEnabled(false);
        decCheck = true;
        hexCheck = false;
        octCheck = false;
        binCheck = false;
        reset();
    }

    //    Блокирование кнопок не включёнынх в 16-чную систему
    public void hex() {
        DEC_Btn.setBackgroundColor(0x00FFFFFF);
        HEX_Btn.setBackgroundColor(0x206C6C6C);
        OCT_Btn.setBackgroundColor(0x00FFFFFF);
        BIN_Btn.setBackgroundColor(0x00FFFFFF);
        btnTwo.setEnabled(true);
        btnThree.setEnabled(true);
        btnFour.setEnabled(true);
        btnFive.setEnabled(true);
        btnSix.setEnabled(true);
        btnSeven.setEnabled(true);
        btnEight.setEnabled(true);
        btnNine.setEnabled(true);
        btnA.setEnabled(true);
        btnB.setEnabled(true);
        btnC.setEnabled(true);
        btnD.setEnabled(true);
        btnE.setEnabled(true);
        btnF.setEnabled(true);
        decCheck = false;
        hexCheck = true;
        octCheck = false;
        binCheck = false;
        reset();
    }

    //    Блокирование кнопок не включёнынх в 8-чную систему
    public void oct() {
        DEC_Btn.setBackgroundColor(0x00FFFFFF);
        HEX_Btn.setBackgroundColor(0x00FFFFFF);
        OCT_Btn.setBackgroundColor(0x206C6C6C);
        BIN_Btn.setBackgroundColor(0x00FFFFFF);
        btnTwo.setEnabled(true);
        btnThree.setEnabled(true);
        btnFour.setEnabled(true);
        btnFive.setEnabled(true);
        btnSix.setEnabled(true);
        btnSeven.setEnabled(true);
        btnEight.setEnabled(false);
        btnNine.setEnabled(false);
        btnA.setEnabled(false);
        btnB.setEnabled(false);
        btnC.setEnabled(false);
        btnD.setEnabled(false);
        btnE.setEnabled(false);
        btnF.setEnabled(false);
        decCheck = false;
        hexCheck = false;
        octCheck = true;
        binCheck = false;
        reset();
    }

    //    Блокирование кнопок не включёнынх в 2-чную систему
    public void bin() {
        DEC_Btn.setBackgroundColor(0x00FFFFFF);
        HEX_Btn.setBackgroundColor(0x00FFFFFF);
        OCT_Btn.setBackgroundColor(0x00FFFFFF);
        BIN_Btn.setBackgroundColor(0x206C6C6C);
        btnTwo.setEnabled(false);
        btnThree.setEnabled(false);
        btnFour.setEnabled(false);
        btnFive.setEnabled(false);
        btnSix.setEnabled(false);
        btnSeven.setEnabled(false);
        btnEight.setEnabled(false);
        btnNine.setEnabled(false);
        btnA.setEnabled(false);
        btnB.setEnabled(false);
        btnC.setEnabled(false);
        btnD.setEnabled(false);
        btnE.setEnabled(false);
        btnF.setEnabled(false);
        decCheck = false;
        hexCheck = false;
        octCheck = false;
        binCheck = true;
        reset();
    }
}
