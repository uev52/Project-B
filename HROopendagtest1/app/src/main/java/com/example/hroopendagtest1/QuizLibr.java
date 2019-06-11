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
            "Do you want to work in IT?",
            "Are you interested in software or hardware?"

    };

    public String camdchoices [][] ={
            {"Sevven", "Rivver", "Winter"},
            {"19", "20", "21"},
            {"2", "3", "4"},
            {"Hans & Lida", "Huub & Gerda", "Henk & Anita"},
            {},
            {}
    };

    public String camdAnswers[] = {"Sevven","20","4","Hans & Lida"};
    public String camdSecondAnswers[] = {"Rivver","19","3","Huub & Gerda"};


    public String CommunicatieQuestions [] = {
            "How long does this Study Program take?",
            "During which year do you take an internship?",
            "Would you like to study abroad?",
            "Would you like taking an internship during your study?",
            "Do you want to work in IT?",
            "Are you interested in software or hardware?"

    };

    public String Communicatiechoices [][] ={
            {"Sevven", "Rivver", "Winter"},
            {"19", "20", "21"},
            {"2", "3", "4"},
            {"Hans & Lida", "Huub & Gerda", "Henk & Anita"},
            {},
            {}
    };

    public String CommunicatieAnswers[] = {"Sevven","20","4","Hans & Lida"};
    public String CommunicatieSecondAnswers[] = {"Rivver","19","3","Huub & Gerda"};

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
