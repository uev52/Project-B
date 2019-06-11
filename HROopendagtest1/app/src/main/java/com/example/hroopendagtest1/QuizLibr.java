package com.example.hroopendagtest1;

public class QuizLibr {
    String chosenProgram;
    String []studyProgram;
    String [][] questionChoices;
    String[] questionAnswers;
    String [] questionSecondAnswers;

    public String InfoQuestions [] = {
            "How long does this Study Program take?",
            "During which year do you take an internship?",
            "How many hours quals one ECT?",
            "Which of the following is a programming language?",
            "How many Projects will be done during your first year?",
            "How many ECT's do you need to get your BSA at the end of your first year?",
            "Do you like working at a desk?"
    };

    public String Infochoices [][] ={
            {"2 years", "5 years", "4 years"},
            {"2nd year", "3rd year", "5th year"},
            {"28", "18", "30"},
            {"C+", "Z-", "C-"},
            {"1", "2", "4"},
            {"42", "48", "60"},
            {"Yes", "No", "I don't mind"}
    };
    public String InfoAnswers [] = {"4 years","3rd year","28","C+","2","48","Yes"};
    public String InfoSecondAnswers [] = {"5 years","2nd year","30","C-","4","60", "I don't mind"};

    public String cmgtQuestions [] = {
            "How long does this Study Program take?",
            "How many Projects will be done during your first year?",
            "During which year do you take an internship?",
            "How many hours quals one ECT?",
            "Do you like working at a desk?",
            "Do you want to be a full fletched programmer or a specialist?"



    };
    public String cmgtchoices [][] ={
            {"2 years", "5 years", "4 years"},
            {"2", "3", "4"},
            {"5th year", "3rd year", "4th year"},
            {"28", "18", "30"},
            {"Yes", "No", "I don't mind"},
            {"Full fletched", "specialist", "I don't know yet"}
    };

    public String cmgtAnswers[] = {"4 years","2","3rd year","28","Yes", "Full fletched"};
    public String cmgtSecondAnswers[] = {"5 years","4","4th year","30","I don't mind","I don't know yet"};

    public String TechInfoQuestions [] = {
            "How long does this Study Program take?",
            "During which year do you take an internship?",
            "Would you like to study abroad?",
            "Would you like taking an internship during your study?",
            "Do you want to work in IT?",
            "Are you interested in software or hardware?"

    };

    public String TechInfochoices [][] ={
            {"2 years", "5 years", "4 years"},
            {"5th year", "3rd year", "4th year"},
            {"I would love to", "Possibly, not sure yet", "I'd rather not"},
            {"I'd rather not","I would love to", "It could be interesting"},
            {"Yes", "No", "I think so"},
            {"Software", "Hardware", "Combination of both"}
    };

    public String TechInfoAnswers[] = {"4 years","3rd year","I would love to","I would love to","Yes","Combination of both"};
    public String TechInfoSecondAnswers[] = {"5 years","4th year","Possibly, not sure yet","It could be interesting","I think so","Hardware"};

    public String camdQuestions [] = {
            "During which year do you take an internship?",
            "Would you like to study abroad?",
            "How long does this Study Program take?",
            "Would you like taking an internship during your study?",
            "Do you want to have a lot of selfstudy hours?",
            "Are you comfortable with confronting other people about your product?"

    };

    public String camdchoices [][] ={
            {"2nd year", "4th year", "3rd year"},
            {"I would love to", "Possibly, not sure yet", "I'd rather not"},
            {"2 years", "5 years", "4 years"},
            {"I'd rather not","I would love to", "It could be interesting"},
            {"I want to study more at school", "I don't care where I study", "I love working at home"},
            {"I would love to", "Possibly, not sure yet", "I'd rather not"}
    };

    public String camdAnswers[] = {"3rd year","I would love to","4 years","I would love to","I love working at home","I would love to"};
    public String camdSecondAnswers[] = {"4th year","Possibly, not sure yet","5 years","It could be interesting","I don't care where I study","I would love to"};


    public String CommunicatieQuestions [] = {
            "How long does this Study Program take?",
            "Would you like taking a look inside a company?",
            "Do you want to commit to better other peoples lives?",
            "How long does you internship take?",
            "Would you like taking an internship during your study?",
            "Do you want to work with people?"
    };

    public String Communicatiechoices [][] ={
            {"2 years", "5 years", "4 years"},
            {"I would love to", "Possibly, not sure yet", "I'd rather not"},
            {"I really do", "Sounds fun", "Nah, I just care about myself"},
            {"3 months", "10 weeks", "5 months"},
            {"I'd rather not","I would love to", "It could be interesting"},
            {"I would really like that", "Possibly, not sure yet", "I'd rather not"}
    };
    public String CommunicatieAnswers[] = {"4 years","I would love to","I really do","5 months","I would love to","I would really like that"};
    public String CommunicatieSecondAnswers[] = {"5 years","Possibly, not sure yet","Sounds fun","3 months","It could be interesting","Possibly, not sure yet"};

    public void detemineStudy(){
        switch (chosenProgram){
            case "Informatica":
                studyProgram = InfoQuestions;
                questionChoices=Infochoices;
                questionAnswers=InfoAnswers;
                questionSecondAnswers = InfoSecondAnswers;
                break;
            case "cmgt":
                studyProgram = cmgtQuestions;
                questionChoices = cmgtchoices;
                questionAnswers = cmgtAnswers;
                questionSecondAnswers=cmgtSecondAnswers;
                break;
            case "Technische Informatica":
                studyProgram = TechInfoQuestions;
                questionChoices = TechInfochoices;
                questionAnswers = TechInfoAnswers;
                questionSecondAnswers=TechInfoSecondAnswers;
                break;
            case "camd":
                studyProgram = camdQuestions;
                questionChoices = camdchoices;
                questionAnswers = camdAnswers;
                questionSecondAnswers=camdSecondAnswers;
                break;
            case "Communicatie":
                studyProgram = CommunicatieQuestions;
                questionChoices = Communicatiechoices;
                questionAnswers = CommunicatieAnswers;
                questionSecondAnswers=CommunicatieSecondAnswers;
                break;
        }
    }
    public String getQuestion(int a){
        String question = studyProgram[a];
        return question;
    }

    public String getChoice1 (int a) {
        String choice1 = questionChoices[a][0];
        return choice1;
    }
    public String getChoice2 (int a) {
        String choice2 = questionChoices[a][1];
        return choice2;
    }

    public String getChoice3 (int a) {
        String choice3 = questionChoices[a][2];
        return choice3;
    }

    public String bestAnswer(int a){
        String correctAnswer = questionAnswers[a];
        return correctAnswer;
    }
    public String secondAnswers(int a){
        String secondAnswer = questionSecondAnswers[a];
        return secondAnswer;}

}
