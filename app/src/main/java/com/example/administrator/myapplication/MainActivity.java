package com.example.administrator.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {
    //与XML中id对应的变量声明
    ImageView mImage;
    RadioButton btn_student;
    RadioButton btn_teacher;
    Button login;
    Button regist;
    Button button_now;
    RadioGroup radiogroup;
    EditText editStudent, editPassword;
    TextInputLayout inputStudent;
    TextInputLayout inputPassword;
    //.java代码中使用到的变量
    String str1, str2;
    AlertDialog.Builder builder;//简单对话框


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
                        }
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
                else if (button_now == btn_teacher)
                    Toast.makeText(MainActivity.this,"教职工注册功能尚未启用",Toast.LENGTH_SHORT)
                         .show();
            }
        });

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                str1 = editStudent.getText().toString();
                str2 = editPassword.getText().toString();
                if (str1.equals(""))
                {
                    inputStudent.setError("学号不能为空");
                    inputPassword.setError(null);
                }
                else
                if (str2.equals(""))
                {
                    inputStudent.setError(null);
                    inputPassword.setError("密码不能为空");
                }
                else
                {
                    inputStudent.setError(null);
                    inputPassword.setError(null);
                    if (str1.equals("123456") && str2.equals("6666"))
                        Snackbar.make(view, "登陆成功", Snackbar.LENGTH_SHORT)
                                .setAction("确定", new View.OnClickListener(){
                                    @Override
                                    public void onClick(View view){}
                                })
                                .show();
                    else
                        Snackbar.make(view, "学号或密码错误", Snackbar.LENGTH_SHORT)
                                .setAction("确定", new View.OnClickListener(){
                                    @Override
                                    public void onClick(View view) {
                                    }
                                })
                                .show();
                }
            }
        });

        editStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editStudent.setFocusable(true);//设置输入框可聚集
                editStudent.setFocusableInTouchMode(true);//设置触摸聚焦
                editStudent.requestFocus();//请求焦点
                editStudent.findFocus();//获取焦点
            }
        });

        editPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPassword.setFocusable(true);//设置输入框可聚集
                editPassword.setFocusableInTouchMode(true);//设置触摸聚焦
                editPassword.requestFocus();//请求焦点
                editPassword.findFocus();//获取焦点
            }
        });


    }

    private void selectRadioBtn(){
        button_now = (RadioButton) findViewById(radiogroup.getCheckedRadioButtonId());
    }

    void initial()
    {
        mImage = (ImageView) findViewById(R.id.SYSUimage);
        btn_student = (RadioButton) findViewById(R.id.chooseStudent);
        btn_teacher = (RadioButton) findViewById(R.id.chooseTeacher);
        login = (Button) findViewById(R.id.login);
        regist = (Button) findViewById(R.id.regist);
        radiogroup = (RadioGroup) findViewById(R.id.group);
        inputStudent = (TextInputLayout) findViewById(R.id.inputStudent);
        inputPassword = (TextInputLayout) findViewById(R.id.inputPassword);
        editStudent = (EditText) findViewById(R.id.editStudent);
        editPassword = (EditText) findViewById(R.id.editPassword);
        builder = new AlertDialog.Builder(MainActivity.this);//简单对话框实例
        button_now = (RadioButton) findViewById(R.id.chooseStudent);//用于获取当前被选择的单选项
    }
}
