package com.example.administrator.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

    ImageView mImage;
    AlertDialog.Builder builder;//简单对话框
    RadioButton btn_student;
    RadioButton btn_teacher;
    Button login;
    Button regist;
    Button button_now;
    RadioGroup radiogroup;
    TextInputEditText inputStudent, inputPassword;
    EditText editStudent, editPassword;
    String str1, str2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initial();
        mImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                builder.setTitle("上传头像");
                builder.setItems(new String[]{"拍摄","从相册选择"},new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (i==0)
                            Toast.makeText(MainActivity.this, "您选择了[拍摄]", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this, "您选择了[从相册选择]", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i ){
                            Toast.makeText(MainActivity.this, "您选择了[取消]",Toast.LENGTH_SHORT).show();
                        };
                        });

                builder.create();
                builder.show();
            }
        });

        btn_student.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Snackbar.make(view,"您选择了[学生]", Snackbar.LENGTH_SHORT)
                        .setAction("确定", new View.OnClickListener(){
                            @Override
                            public void onClick(View view){
                                Toast.makeText(MainActivity.this,"Snackbar的确定按钮被点击了",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });

        btn_teacher.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Snackbar.make(view,"您选择了[教师]", Snackbar.LENGTH_SHORT)
                        .setAction("确定", new View.OnClickListener(){
                            @Override
                            public void onClick(View view){
                                Toast.makeText(MainActivity.this,"Snackbar的确定按钮被点击了",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group,int checkID){
                selectRadioBtn();
            }
        });

        regist.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (button_now == btn_student)
                    Snackbar.make(view,"学生注册功能尚未启", Snackbar.LENGTH_SHORT)
                            .setAction("确定", new View.OnClickListener(){
                                @Override
                                public void onClick(View view){}
                            })
                            .show();
                else
                    Toast.makeText(MainActivity.this,"教职工注册功能尚未启用",Toast.LENGTH_SHORT)
                         .show();
//                    Snackbar.make(view,"教师注册功能尚未启", Snackbar.LENGTH_SHORT)
//                            .setAction("确定", new View.OnClickListener(){
//                                @Override
//                                public void onClick(View view){}
//                            })
//                            .show();
            }
        });

//        login.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                str1 = editStudent.getText().toString();
//                str2 = editPassword.getText().toString();
////                if (str1.equals("")){
////                    inputStudent.setError("学号不能为空");
////                }
////                else if (str2.equals("")){
////                    inputPassword.setError("密码不能为空");
////                }
////                else if (str1.equals("123456") && str2.equals("6666")){
////                    Snackbar.make(view, "登陆成功", Snackbar.LENGTH_SHORT)
////                            .setAction("确定", new View.OnClickListener(){
////                                @Override
////                                public void onClick(View view){}
////                            })
////                            .show();
////                    inputStudent.setError(null);
////                    inputPassword.setError(null);
////                }
////                else {
////                    Snackbar.make(view, "学号或密码错误", Snackbar.LENGTH_SHORT)
////                            .setAction("确定", new View.OnClickListener(){
////                                @Override
////                                public void onClick(View view) {
////                                }
////                            })
////                            .show();
////                    inputStudent.setError(null);
////                    inputPassword.setError(null);
////                }
//            }
//        });


    }

    private void selectRadioBtn(){
        button_now = (RadioButton) findViewById(radiogroup.getCheckedRadioButtonId());
//                    selectText = button_now.getT
    }

    void initial()
    {
        mImage = (ImageView) findViewById(R.id.SYSUimage);
        btn_student = (RadioButton) findViewById(R.id.chooseStudent);
        btn_teacher = (RadioButton) findViewById(R.id.chooseTeacher);
        login = (Button) findViewById(R.id.login);
        regist = (Button) findViewById(R.id.regist);
        radiogroup = (RadioGroup) findViewById(R.id.group);
        inputStudent = (TextInputEditText) findViewById(R.id.inputStudent);
        inputPassword = (TextInputEditText) findViewById(R.id.inputPassword);
        editStudent = (EditText) findViewById(R.id.editStudent);
        editPassword = (EditText) findViewById(R.id.editPassword);

        builder = new AlertDialog.Builder(MainActivity.this);

    }
}
