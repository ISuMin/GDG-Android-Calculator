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
// Вроде всё работает, почти все пожелания учтены.
// Извиняюсь за лишние комментарии.

public class Calculator extends AppCompatActivity {

    //    Объявление переменных
    private Button dec_btn;
    private Button hex_btn;
    private Button oct_btn;
    private Button bin_btn;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    private Button btn_zero;
    private Button btn_one;
    private Button btn_two;
    private Button btn_three;
    private Button btn_four;
    private Button btn_five;
    private Button btn_six;
    private Button btn_seven;
    private Button btn_eight;
    private Button btn_nine;
    private Button btn_plus;
    private Button btn_minus;
    private Button btn_multiply;
    private Button btn_divide;
    private Button btn_equals;
    private Button btn_reset;
    private ImageButton btn_back;
    private Button btn_a;
    private Button btn_b;
    private Button btn_c;
    private Button btn_d;
    private Button btn_e;
    private Button btn_f;

    private int num = 0;

    private int operator = 1;
    // 0 = ничего
    // 1 = сложение
    // 2 = вычитание
    // 3 = умножение
    // 4 = деление

    private boolean ready_to_clear = false;
    private boolean has_changed = false;

    boolean dec_check = false;
    boolean hex_check = false;
    boolean oct_check = false;
    boolean bin_check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        init_controls();
        reset();
        dec();
    }

    //    Обработка нажатий
    private void init_controls() {

        //
        dec_btn = (Button) findViewById(R.id.dec_btn);
        hex_btn = (Button) findViewById(R.id.hex_btn);
        oct_btn = (Button) findViewById(R.id.oct_btn);
        bin_btn = (Button) findViewById(R.id.bin_btn);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        text4 = (TextView) findViewById(R.id.text4);
        btn_zero = (Button) findViewById(R.id.btn_zero);
        btn_one = (Button) findViewById(R.id.btn_one);
        btn_two = (Button) findViewById(R.id.btn_two);
        btn_three = (Button) findViewById(R.id.btn_three);
        btn_four = (Button) findViewById(R.id.btn_four);
        btn_five = (Button) findViewById(R.id.btn_five);
        btn_six = (Button) findViewById(R.id.btn_six);
        btn_seven = (Button) findViewById(R.id.btn_seven);
        btn_eight = (Button) findViewById(R.id.btn_eight);
        btn_nine = (Button) findViewById(R.id.btn_nine);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_multiply = (Button) findViewById(R.id.btn_multiply);
        btn_divide = (Button) findViewById(R.id.btn_divide);
        btn_equals = (Button) findViewById(R.id.btn_equals);
        btn_reset = (Button) findViewById(R.id.btn_reset);
        btn_back = (ImageButton) findViewById(R.id.btn_back);
        btn_a = (Button) findViewById(R.id.btn_a);
        btn_b = (Button) findViewById(R.id.btn_b);
        btn_c = (Button) findViewById(R.id.btn_c);
        btn_d = (Button) findViewById(R.id.btn_d);
        btn_e = (Button) findViewById(R.id.btn_e);
        btn_f = (Button) findViewById(R.id.btn_f);

        //        Вызов цифр
        btn_zero.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(0);
            }
        });
        btn_one.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(1);
            }
        });
        btn_two.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(2);
            }
        });
        btn_three.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(3);
            }
        });
        btn_four.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(4);
            }
        });
        btn_five.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(5);
            }
        });
        btn_six.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(6);
            }
        });
        btn_seven.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(7);
            }
        });
        btn_eight.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(8);
            }
        });
        btn_nine.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(9);
            }
        });
        btn_a.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(10);
            }
        });
        btn_b.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(11);
            }
        });
        btn_c.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(12);
            }
        });
        btn_d.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(13);
            }
        });
        btn_e.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(14);
            }
        });
        btn_f.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleNumber(15);
            }
        });

        //        Вызов опереторов
        btn_plus.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleEquals(1);
            }
        });
        btn_minus.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleEquals(2);
            }
        });
        btn_multiply.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleEquals(3);
            }
        });
        btn_divide.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleEquals(4);
            }
        });
        btn_equals.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleEquals(0);
            }
        });

        //        Вызов функций сброс и стирание
        btn_reset.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                reset();
            }
        });
        btn_back.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                handleBackspace();
            }
        });

        //        Выбор системы счисления
        dec_btn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                dec();
            }
        });
        hex_btn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                hex();
            }
        });
        oct_btn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                oct();
            }
        });
        bin_btn.setOnClickListener(new Button.OnClickListener() {
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

        if (has_changed) {
            switch (operator) {
                case 1:
                    if (dec_check) {
                        num = num + num1;
                        txt = Integer.toString(num);
                        handleVisionDec(txt);
                    }
                    if (hex_check) {
                        num = num + num2;
                        txt = Integer.toHexString(num);
                        handleVisionHex(txt);
                    }
                    if (oct_check) {
                        num = num + num3;
                        txt = Integer.toOctalString(num);
                        handleVisionOct(txt);
                    }
                    if (bin_check) {
                        num = num + num4;
                        txt = Integer.toBinaryString(num);
                        handleVisionBin(txt);
                    }
                    break;
                case 2:
                    if (dec_check) {
                        num = num - num1;
                        txt = Integer.toString(num);
                        handleVisionDec(txt);
                    }
                    if (hex_check) {
                        num = num - num2;
                        txt = Integer.toHexString(num);
                        handleVisionHex(txt);
                    }
                    if (oct_check) {
                        num = num - num3;
                        txt = Integer.toOctalString(num);
                        handleVisionOct(txt);
                    }
                    if (bin_check) {
                        num = num - num4;
                        txt = Integer.toBinaryString(num);
                        handleVisionBin(txt);
                    }
                    break;
                case 3:
                    if (dec_check) {
                        num = num * num1;
                        txt = Integer.toString(num);
                        handleVisionDec(txt);
                    }
                    if (hex_check) {
                        num = num * num2;
                        txt = Integer.toHexString(num);
                        handleVisionHex(txt);
                    }
                    if (oct_check) {
                        num = num * num3;
                        txt = Integer.toOctalString(num);
                        handleVisionOct(txt);
                    }
                    if (bin_check) {
                        num = num * num4;
                        txt = Integer.toBinaryString(num);
                        handleVisionBin(txt);
                    }
                    break;
                case 4:
                    if (dec_check) {
                        if (num1 != 0) {
                            num = num / num1;
                            txt = Integer.toString(num);
                            handleVisionDec(txt);
                        } else {
                            text1.setText(R.string.non_zero);
                        }
                    }
                    if (hex_check) {
                        if (num2 != 0) {
                            num = num / num2;
                            txt = Integer.toHexString(num);
                            handleVisionHex(txt);
                        } else {
                            text2.setText(R.string.non_zero);
                        }
                    }
                    if (oct_check) {
                        if (num3 != 0) {
                            num = num / num3;
                            txt = Integer.toOctalString(num);
                            handleVisionOct(txt);
                        } else {
                            text3.setText(R.string.non_zero);
                        }
                    }
                    if (bin_check) {
                        if (num4 != 0) {
                            num = num / num4;
                            txt = Integer.toBinaryString(num);
                            handleVisionBin(txt);
                        } else {
                            text4.setText(R.string.non_zero);
                        }
                    }
                    break;
            }

            ready_to_clear = true;
            has_changed = false;
        }

        operator = newOperator;
    }

    //    Вывод числа на экран
    private void handleNumber(int num) {
        if (operator == 0)
            reset();

        if (dec_check) {

            String txt = text1.getText().toString();
            if (ready_to_clear) {
                txt = "";
                ready_to_clear = false;
            } else if (txt.equals("0"))
                txt = "";
            txt = txt + Integer.toString(num);
            handleVisionDec(txt);

        } else if (hex_check) {

            String txt = text2.getText().toString();
            if (ready_to_clear) {
                txt = "";
                ready_to_clear = false;
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

        } else if (oct_check) {

            String txt = text3.getText().toString();
            if (ready_to_clear) {
                txt = "";
                ready_to_clear = false;
            } else if (txt.equals("0"))
                txt = "";
            txt = txt + Integer.toString(num);
            handleVisionOct(txt);

        } else if (bin_check) {

            String txt = text4.getText().toString();
            if (ready_to_clear) {
                txt = "";
                ready_to_clear = false;
            } else if (txt.equals("0"))
                txt = "";
            txt = txt + Integer.toString((int) num);
            handleVisionBin(txt);
        }

        has_changed = true;
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
        if (!ready_to_clear) {
            if (dec_check) {
                String txt = text1.getText().toString();
                output(txt);
            } else if (hex_check) {
                String txt = text2.getText().toString();
                output(txt);
            } else if (oct_check) {
                String txt = text3.getText().toString();
                output(txt);
            } else if (bin_check) {
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

            if (dec_check) {
                handleVisionDec(txt);
            } else if (hex_check) {
                handleVisionHex(txt);
            } else if (oct_check) {
                handleVisionOct(txt);
            } else if (bin_check) {
                handleVisionBin(txt);
            }
        }
    }

    //    Сброс
    private void reset() {
        num = 0;
        text1.setText("0");
        text2.setText("0");
        text3.setText("0");
        text4.setText("0");
        operator = 1;
        ready_to_clear = false;
        has_changed = false;
    }

    //    Блокирование кнопок не включёнынх в 10-чную систему
    public void dec() {
        dec_btn.setBackgroundColor(0x206C6C6C);
        hex_btn.setBackgroundColor(0x00FFFFFF);
        oct_btn.setBackgroundColor(0x00FFFFFF);
        bin_btn.setBackgroundColor(0x00FFFFFF);
        btn_two.setEnabled(true);
        btn_three.setEnabled(true);
        btn_four.setEnabled(true);
        btn_five.setEnabled(true);
        btn_six.setEnabled(true);
        btn_seven.setEnabled(true);
        btn_eight.setEnabled(true);
        btn_nine.setEnabled(true);
        btn_a.setEnabled(false);
        btn_b.setEnabled(false);
        btn_c.setEnabled(false);
        btn_d.setEnabled(false);
        btn_e.setEnabled(false);
        btn_f.setEnabled(false);
        dec_check = true;
        hex_check = false;
        oct_check = false;
        bin_check = false;
        reset();
    }

    //    Блокирование кнопок не включёнынх в 16-чную систему
    public void hex() {
        dec_btn.setBackgroundColor(0x00FFFFFF);
        hex_btn.setBackgroundColor(0x206C6C6C);
        oct_btn.setBackgroundColor(0x00FFFFFF);
        bin_btn.setBackgroundColor(0x00FFFFFF);
        btn_two.setEnabled(true);
        btn_three.setEnabled(true);
        btn_four.setEnabled(true);
        btn_five.setEnabled(true);
        btn_six.setEnabled(true);
        btn_seven.setEnabled(true);
        btn_eight.setEnabled(true);
        btn_nine.setEnabled(true);
        btn_a.setEnabled(true);
        btn_b.setEnabled(true);
        btn_c.setEnabled(true);
        btn_d.setEnabled(true);
        btn_e.setEnabled(true);
        btn_f.setEnabled(true);
        dec_check = false;
        hex_check = true;
        oct_check = false;
        bin_check = false;
        reset();
    }

    //    Блокирование кнопок не включёнынх в 8-чную систему
    public void oct() {
        dec_btn.setBackgroundColor(0x00FFFFFF);
        hex_btn.setBackgroundColor(0x00FFFFFF);
        oct_btn.setBackgroundColor(0x206C6C6C);
        bin_btn.setBackgroundColor(0x00FFFFFF);
        btn_two.setEnabled(true);
        btn_three.setEnabled(true);
        btn_four.setEnabled(true);
        btn_five.setEnabled(true);
        btn_six.setEnabled(true);
        btn_seven.setEnabled(true);
        btn_eight.setEnabled(false);
        btn_nine.setEnabled(false);
        btn_a.setEnabled(false);
        btn_b.setEnabled(false);
        btn_c.setEnabled(false);
        btn_d.setEnabled(false);
        btn_e.setEnabled(false);
        btn_f.setEnabled(false);
        dec_check = false;
        hex_check = false;
        oct_check = true;
        bin_check = false;
        reset();
    }

    //    Блокирование кнопок не включёнынх в 2-чную систему
    public void bin() {
        dec_btn.setBackgroundColor(0x00FFFFFF);
        hex_btn.setBackgroundColor(0x00FFFFFF);
        oct_btn.setBackgroundColor(0x00FFFFFF);
        bin_btn.setBackgroundColor(0x206C6C6C);
        btn_two.setEnabled(false);
        btn_three.setEnabled(false);
        btn_four.setEnabled(false);
        btn_five.setEnabled(false);
        btn_six.setEnabled(false);
        btn_seven.setEnabled(false);
        btn_eight.setEnabled(false);
        btn_nine.setEnabled(false);
        btn_a.setEnabled(false);
        btn_b.setEnabled(false);
        btn_c.setEnabled(false);
        btn_d.setEnabled(false);
        btn_e.setEnabled(false);
        btn_f.setEnabled(false);
        dec_check = false;
        hex_check = false;
        oct_check = false;
        bin_check = true;
        reset();
    }
}
