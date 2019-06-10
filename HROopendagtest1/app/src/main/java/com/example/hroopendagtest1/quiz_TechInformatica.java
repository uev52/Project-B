package com.example.hroopendagtest1;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class quiz_TechInformatica extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private QuizLibr quizLibr = new QuizLibr();
    private Button buttonChoice1;
    private Button buttonChoice2;
    private Button buttonChoice3;
    private TextView questionsView;
    private String questionBestAnswer;
    private String questionSecondAnswer;
    private  String questionThirdAnswer;
    private int questionNumber = 0;
    private int score =0;
    private TextView quizScore;
    private Button nextBtn;
    private Button prevBtn;
    private Boolean choice1Selected = false;
    private Boolean choice2Selected = false;
    private Boolean choice3Selected = false;
    private int addedScore = 0;
    int [] pointsPerQuestion = new int[quizLibr.TechInfoQuestions.length+1];
    int[] selectedAnswers = new int[quizLibr.TechInfoQuestions.length+1];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz__cmgt);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        questionsView = findViewById(R.id.questionsView);
        buttonChoice1 = findViewById(R.id.answer1);
        buttonChoice2 = findViewById(R.id.answer2);
        buttonChoice3 = findViewById(R.id.answer3);
        nextBtn = findViewById(R.id.nextBtn);
        prevBtn = findViewById(R.id.prevBtn);
        quizScore = findViewById(R.id.scoreView);
        quizLibr.chosenProgram="Technische Informatica";
        quizLibr.detemineStudy();



        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionNumber!= quizLibr.TechInfoQuestions.length){
                    questionNumber = questionNumber+1;
                    updatePoints();
                    updateQuestion();
                    colorChoices();
                    activeBtn();
                    colorBtn();
                    System.out.println(quizLibr.InfoQuestions.length);
                    System.out.println(questionNumber);}
                else{
                    updatePoints();
                    updateQuestion();
                }
            }
        });
        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deductPoints();
                if (questionNumber != 0){
                    questionNumber= questionNumber-1;
                    updateQuestion();
                    colorChoices();
                    activeBtn();
                    colorBtn();
                }
                quizScore.setText(Integer.toString(score));
            }
        });

        buttonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!choice1Selected){
                    buttonChoice1.setBackgroundColor(getResources().getColor(R.color.selectedBlue));
                    choice1Selected = true;
                    activeBtn();
                    colorBtn();
                    if (choice2Selected){
                        choice2Selected = false;
                        buttonChoice2.setBackgroundColor(getResources().getColor(R.color.HRO_mainColor));
                    }
                    else if (choice3Selected){
                        choice3Selected = false;
                        buttonChoice3.setBackgroundColor(getResources().getColor(R.color.HRO_mainColor));
                    }
                    else{
                        return;
                    }
                }
                else{
                    buttonChoice1.setBackgroundColor(getResources().getColor(R.color.HRO_mainColor));
                    choice1Selected =false;
                }
                activeBtn();
                colorBtn();

            }
        });

        buttonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!choice2Selected){
                    buttonChoice2.setBackgroundColor(getResources().getColor(R.color.selectedBlue));
                    choice2Selected = true;
                    activeBtn();
                    colorBtn();
                    if (choice1Selected){
                        choice1Selected = false;
                        buttonChoice1.setBackgroundColor(getResources().getColor(R.color.HRO_mainColor));
                    }
                    else if (choice3Selected){
                        choice3Selected = false;
                        buttonChoice3.setBackgroundColor(getResources().getColor(R.color.HRO_mainColor));
                    }
                    else{
                        return;
                    }
                }
                else{
                    buttonChoice2.setBackgroundColor(getResources().getColor(R.color.HRO_mainColor));
                    choice2Selected =false;
                }
                activeBtn();
                colorBtn();
            }
        });
        buttonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!choice3Selected){
                    buttonChoice3.setBackgroundColor(getResources().getColor(R.color.selectedBlue));
                    choice3Selected = true;
                    activeBtn();
                    colorBtn();
                    if (choice2Selected){
                        choice2Selected = false;
                        buttonChoice2.setBackgroundColor(getResources().getColor(R.color.HRO_mainColor));
                    }
                    else if (choice1Selected){
                        choice1Selected = false;
                        buttonChoice1.setBackgroundColor(getResources().getColor(R.color.HRO_mainColor));
                    }
                    else{
                        return;
                    }
                }
                else{
                    buttonChoice3.setBackgroundColor(getResources().getColor(R.color.HRO_mainColor));
                    choice3Selected =false;
                }
                activeBtn();
                colorBtn();
            }
        });
        updateQuestion();
        colorBtn();
        colorPrevBtn();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        startActivity(AppUtil.changeScreen(item.getItemId(), getBaseContext()));

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void updateQuestion(){
        resetButtons();
        colorPrevBtn();

        if (questionNumber == quizLibr.TechInfoQuestions.length){
            buttonChoice1.setVisibility(View.GONE);
            buttonChoice2.setVisibility(View.GONE);
            buttonChoice3.setVisibility(View.GONE);
            nextBtn.setVisibility(View.GONE);
            prevBtn.setVisibility(View.GONE);
            quizScore.setText("Score:  "+Integer.toString(score));

            if (score<=10){
                questionsView.setText("Maybe you should consider learning more about this study program!");
            }
            else if (score>10 && score<17){
                questionsView.setText("Nice! You did pretty good");
            }
            else{
                questionsView.setText("Wow you did fantastic! You really did your research!");
            }






        }
        else {
            questionsView.setText(quizLibr.getQuestion(questionNumber));
            buttonChoice1.setText(quizLibr.getChoice1(questionNumber));
            buttonChoice2.setText(quizLibr.getChoice2(questionNumber));
            buttonChoice3.setText(quizLibr.getChoice3(questionNumber));
            questionBestAnswer = quizLibr.bestAnswer(questionNumber);
            questionSecondAnswer = quizLibr.secondAnswers((questionNumber));
            quizScore.setText(Integer.toString(score));

        }

    }

    private void resetButtons(){
        buttonChoice1.setBackgroundColor(getResources().getColor(R.color.HRO_mainColor));
        buttonChoice2.setBackgroundColor(getResources().getColor(R.color.HRO_mainColor));
        buttonChoice3.setBackgroundColor(getResources().getColor(R.color.HRO_mainColor));
        choice1Selected = false;
        choice2Selected = false;
        choice3Selected = false;
        activeBtn();
        colorBtn();
    }

    private void activeBtn(){
        if (choice1Selected || choice2Selected || choice3Selected){
            nextBtn.setEnabled(true);
        }
        else{
            nextBtn.setEnabled(false);
        }
        if (questionNumber == 0){
            prevBtn.setEnabled(false);
        }
        else{
            prevBtn.setEnabled(true);
        }
    }
    private  void colorBtn(){
        if (nextBtn.isEnabled()){
            nextBtn.setBackgroundColor(getResources().getColor(R.color.HRO_mainColor));
        }
        else{
            nextBtn.setBackgroundColor(getResources().getColor(R.color.HRO_grey));
        }
    }
    private void colorPrevBtn(){
        if (prevBtn.isEnabled()){
            prevBtn.setBackgroundColor(getResources().getColor(R.color.HRO_mainColor));
        }
        else{
            prevBtn.setBackgroundColor(getResources().getColor(R.color.HRO_grey));
        }
    }
    private void updatePoints(){
        if (choice1Selected){
            selectedAnswers[questionNumber] = 1;
            if (buttonChoice1.getText() == questionBestAnswer){
                score+=5;
                addedScore = 5;
            }
            else if (buttonChoice1.getText() == questionSecondAnswer){
                score+=3;
                addedScore = 3;

            }
            else{
                score+=0;
                addedScore = 0;
            }
        }
        else if (choice2Selected){
            selectedAnswers[questionNumber] = 2;
            if (buttonChoice2.getText() == questionBestAnswer){
                score+=5;
                addedScore = 5;

            }
            else if (buttonChoice2.getText() == questionSecondAnswer){
                score+=3;
                addedScore = 3;
            }
            else{
                score+=0;
                addedScore = 0;
            }
        }
        else{
            selectedAnswers[questionNumber] = 3;
            if (buttonChoice3.getText() == questionBestAnswer){
                score+=5;
                addedScore = 5;

            }
            else if (buttonChoice3.getText() == questionSecondAnswer){
                score+=3;
                addedScore = 3;

            }
            else{
                score+=0;
                addedScore = 0;
            }
        }
        pointsPerQuestion[questionNumber] = addedScore;
    }

    private void deductPoints(){
        score = score - pointsPerQuestion[questionNumber];
    }
    private void colorChoices(){
        setSelected();
        if (choice1Selected){
            buttonChoice1.setBackgroundColor(getResources().getColor(R.color.selectedBlue));
            buttonChoice2.setBackgroundColor(getResources().getColor(R.color.HRO_mainColor));
            buttonChoice3.setBackgroundColor(getResources().getColor(R.color.HRO_mainColor));
        }
        else if (choice2Selected){
            buttonChoice2.setBackgroundColor(getResources().getColor(R.color.selectedBlue));
            buttonChoice1.setBackgroundColor(getResources().getColor(R.color.HRO_mainColor));
            buttonChoice3.setBackgroundColor(getResources().getColor(R.color.HRO_mainColor));
        }
        else if (choice3Selected){
            buttonChoice3.setBackgroundColor(getResources().getColor(R.color.selectedBlue));
            buttonChoice2.setBackgroundColor(getResources().getColor(R.color.HRO_mainColor));
            buttonChoice1.setBackgroundColor(getResources().getColor(R.color.HRO_mainColor));
        }
    }
    private void setSelected(){
        if (questionNumber!= quizLibr.TechInfoQuestions.length){
            if (selectedAnswers[questionNumber+1] ==1){
                choice1Selected = true;
                choice2Selected = false;
                choice3Selected = false;
        }
            if (selectedAnswers[questionNumber+1] ==2){
                choice2Selected = true;
                choice3Selected = false;
                choice1Selected = false;
        }
            if (selectedAnswers[questionNumber+1] ==3){
                choice3Selected = true;
                choice2Selected = false;
                choice1Selected = false;
        }}
    }



}
