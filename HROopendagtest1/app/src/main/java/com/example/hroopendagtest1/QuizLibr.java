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
            "Hoe heten mijn ouders?"

    };

    public String Infochoices [][] ={
            {"Sevven", "Rivver", "Winter"},
            {"19", "20", "21"},
            {"2", "3", "4"},
            {"Hans & Lida", "Huub & Gerda", "Henk & Anita"},
    };

    public String cmgtQuestions [] = {
            "Wat is mijn broers naam?",
            "Hoe oud is mijn broer?",
            "Hoeveel broers?",
            "Hoe ouders?"

    };
    public String cmgtchoices [][] ={
            {"Sevven", "Rivver", "Winter"},
            {"19", "20", "21"},
            {"2", "3", "4"},
            {"Hans & Lida", "Huub & Gerda", "Henk & Anita"},
    };

    public String TechInfoQuestions [] = {
            "How long does this Study Program take?",
            "During which year do you take an internship?",
            "How many hours ",
            "Hoe heten mijn ouders?"

    };

    public String TechInfochoices [][] ={
            {"Sevven", "Rivver", "Winter"},
            {"19", "20", "21"},
            {"2", "3", "4"},
            {"Hans & Lida", "Huub & Gerda", "Henk & Anita"},
    };
    public String camdQuestions [] = {
            "How long does this Study Program take?",
            "During which year do you take an internship?",
            "How many hours ",
            "Hoe heten mijn ouders?"

    };

    public String camdchoices [][] ={
            {"Sevven", "Rivver", "Winter"},
            {"19", "20", "21"},
            {"2", "3", "4"},
            {"Hans & Lida", "Huub & Gerda", "Henk & Anita"},
    };
    public String CommunicatieQuestions [] = {
            "How long does this Study Program take?",
            "During which year do you take an internship?",
            "How many hours ",
            "Hoe heten mijn ouders?"

    };

    public String Communicatiechoices [][] ={
            {"Sevven", "Rivver", "Winter"},
            {"19", "20", "21"},
            {"2", "3", "4"},
            {"Hans & Lida", "Huub & Gerda", "Henk & Anita"},
    };

    public String InfoAnswers [] = {"4 years","3rd year","28","Python","60"};
    public String InfoSecondAnswers [] = {"5 years","4th year","24","Python & Java", "48"};

    public String cmgtAnswers[] = {"Sevven","20","4","Hans & Lida"};
    public String cmgtSecondAnswers[] = {"Rivver","19","3","Huub & Gerda"};

    public String TechInfoAnswers[] = {"Sevven","20","4","Hans & Lida"};
    public String TechInfoSecondAnswers[] = {"Rivver","19","3","Huub & Gerda"};

    public String camdAnswers[] = {"Sevven","20","4","Hans & Lida"};
    public String camdSecondAnswers[] = {"Rivver","19","3","Huub & Gerda"};

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
