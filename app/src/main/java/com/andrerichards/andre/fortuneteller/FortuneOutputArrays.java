package com.andrerichards.andre.fortuneteller;

/**
 * Created by Andre on 12/12/2015.
 */
public class FortuneOutputArrays {

    private static String [] answer;
    private static int random;
    protected String fortuneAnswerOutput;

    public FortuneOutputArrays(String keyword){
        switch (keyword) {
            case "who":
                fortuneAnswerOutput = who();
                break;
            case "what":
                fortuneAnswerOutput = what();
                break;
            case "where":
                fortuneAnswerOutput = where();
                break;
            case "why":
                fortuneAnswerOutput = why();
                break;
            case "how":
                fortuneAnswerOutput = how();
                break;
            case "when":
                fortuneAnswerOutput = when();
                break;
            case "will":
                fortuneAnswerOutput = will();
                break;
            default:
                fortuneAnswerOutput = "Outlook Unclear";
        }
    }

    public static String who(){
        answer = new String[8];
        answer[0] = "The next person you see";
        answer[1] = "Someone very close to you";
        answer[2] = "Your best friend";
        answer[3] = "The person's name starts with an 'S'";
        answer[4] = "Hmm...the person's dead actually";
        answer[5] = "No one I care to mention";
        answer[6] = "Dumb question ask another";
        answer[7] = "That answer is gonna cost you";
        random = (int) (Math.random() * 8);//randomizes location of array index
        return answer[random];
    }

    public static String where() {
        answer = new String[8];
        answer[0] = "Somewhere over the rainbow";
        answer[1] = "Right under your nose";
        answer[2] = "Where you least expect it";
        answer[3] = "Someplace sunny";
        answer[4] = "Hell. Go there";
        answer[5] = "Try looking at the bottom of the ocean";
        answer[6] = "Wrong app. This ain't Google Maps";
        answer[7] = "I checked your mom's house last night; I've determined it's not there";
        random = (int) (Math.random() * 8);
        return answer[random];
    }

    public static String what() {
        answer = new String[8];
        answer[0] = "The answer you seek is within";
        answer[1] = "Look to the signs around you";
        answer[2] = "What is meant to be will be";
        answer[3] = "We both know you already know the answer to that";
        answer[4] = "Now what if I told you, I don't know nor care?";
        answer[5] = "You won't like the answer";
        answer[6] = "I'm going to assume that was a practice question";
        answer[7] = "I'm on break";
        random = (int) (Math.random() * 8);
        return answer[random];
    }

    public static String why() {
        answer = new String[8];
        answer[0] = "All things happen for a reason";
        answer[1] = "Because everything in life is a miracle";
        answer[2] = "Some things in life are best left unknown";
        answer[3] = "It's one of life's great and beautiful mysteries";
        answer[4] = "Shhh! It's a secret...";
        answer[5] = "Hold as I re-direct you to Google";
        answer[6] = "If I explained it, would you really understand? No";
        answer[7] = "Not in the mood...ask me later";
        random = (int) (Math.random() * 8);
        return answer[random];
    }

    public static String how() {
        answer = new String[8];
        answer[0] = "Take it one step at a time";
        answer[1] = "Start with a positive outlook";
        answer[2] = "Just do it!";
        answer[3] = "I'd say pretty well";
        answer[4] = "Please leave your message at the sound of the beep. Voicemail Full";
        answer[5] = "My psychic powers activate with money";
        answer[6] = "So you can't answer that yourself?";
        answer[7] = "I don't give enough fucks to answer";
        random = (int) (Math.random() * 8);
        return answer[random];
    }

    public static String when() {
        answer = new String[8];
        answer[0] = "Only when the time is right";
        answer[1] = "The time is now!";
        answer[2] = "Much sooner than you think";
        answer[3] = "Within the week";
        answer[4] = "That time has come and gone";
        answer[5] = "I don't think that was a serious question";
        answer[6] = "Ask me again yesterday";
        answer[7] = "Wait - sorry, repeat the question";
        random = (int) (Math.random() * 8);
        return answer[random];
    }

    public static String will() {
        answer = new String[8];
        answer[0] = "All signs point in your favor";
        answer[1] = "You will if you believe";
        answer[2] = "Yes, but will you be ready when it happens?";
        answer[3] = "It's damn near inevitable";
        answer[4] = "Only if I do first";
        answer[5] = "It's always about you I guess";
        answer[6] = "HA! Hell no! Da fuck?";
        answer[7] = "Yea bro. I'm gonna give it a no";
        random = (int) (Math.random() * 8);
        return answer[random];
    }
}