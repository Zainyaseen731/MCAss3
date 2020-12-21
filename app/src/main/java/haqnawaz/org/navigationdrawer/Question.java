package haqnawaz.org.navigationdrawer;

public class Question {
    public String myQuestion[]={
            "Capital of Pakistan ?",
            "Capital of Punjab ?",
            "Capital of Sindh",
            "Capital od Blochistan",
            "Capital of KPK",
            "2+3*5",
            "6(5-1)",
            "How many province in pakistan ?",
            "Bigest province of pakistan by land ?",
            "Bigest province of pakistan by papulation ?"

    };

    private String myChoices [][]={
            {"Punjab","Sindh","Islamabad","KPK"},
            {"Lahore","Karachi","Peshawar","Quetta"},
            {"Lahore","Karachi","Peshawar","Quetta"},
            {"Lahore","Karachi","Peshawar","Quetta"},
            {"Lahore","Karachi","Peshawar","Quetta"},
            {"17","25","8","12"},
            {"24","45","9","12"},
            {"4","3","5","6"},
            {"Punjab","Sindh","Blochistan","KPK"},
            {"Punjab","Sindh","Blochistan","KPK"},

    };

    private String myAnswers[]={"Islamabad","Lahore","Karachi","Quetta","Peshawar","17","24","4","Blochistan","Punjab"};

    public String getQuestion(int a){
        String Question=myQuestion[a];
        return Question;
    }

    public String getChoices1(int a){
        String choice = myChoices[a][0];
        return choice;
    }
    public String getChoices2(int a){
        String choice = myChoices[a][1];
        return choice;
    }
    public String getChoices3(int a){
        String choice = myChoices[a][2];
        return choice;
    }
    public String getChoices4(int a){
        String choice = myChoices[a][3];
        return choice;
    }

    public String getCorrectChoice(int a){
        String answer=myAnswers[a];
        return answer;
    }
}
