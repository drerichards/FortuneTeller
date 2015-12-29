package com.andrerichards.andre.fortuneteller;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by Andre on 11/16/2015.
 */
public class ValidateEditTextEntry implements TextToSpeech.OnInitListener {
    private TextToSpeech textToSpeech;
    private MainActivity mainActivity;
    private String fortuneOutput;
    protected String keyword;
    private Context context;
    private final String VALID_KEYWORD_WHO = "who",
            VALID_KEYWORD_WHAT = "what",
            VALID_KEYWORD_WHERE = "where",
            VALID_KEYWORD_WHY = "why",
            VALID_KEYWORD_HOW = "how",
            VALID_KEYWORD_WHEN = "when",
            VALID_KEYWORD_WILL = "will";

    public ValidateEditTextEntry(MainActivity mainActivity, Context context) {
        this.mainActivity = mainActivity;
        this.context = context;
    }

    public void textToSpeechFortune(String spokenText) {

        textToSpeech = new TextToSpeech(context,this);
        textToSpeech.setLanguage(Locale.US);
        textToSpeech.setPitch((float) 2);

        String lowerCase = spokenText.toLowerCase();
        if (lowerCase.contains(VALID_KEYWORD_WHO)) {
            keyword = VALID_KEYWORD_WHO;
            fortuneOutput = new FortuneOutputArrays(keyword).fortuneAnswerOutput;
        } else if (lowerCase.contains(VALID_KEYWORD_WHAT)) {
            keyword = VALID_KEYWORD_WHAT;
            fortuneOutput = new FortuneOutputArrays(keyword).fortuneAnswerOutput;
        } else if (lowerCase.contains(VALID_KEYWORD_WHERE)) {
            keyword = VALID_KEYWORD_WHERE;
            fortuneOutput = new FortuneOutputArrays(keyword).fortuneAnswerOutput;
        } else if (lowerCase.contains(VALID_KEYWORD_WHY)) {
            keyword = VALID_KEYWORD_WHY;
            fortuneOutput = new FortuneOutputArrays(keyword).fortuneAnswerOutput;
        } else if (lowerCase.contains(VALID_KEYWORD_HOW)) {
            keyword = VALID_KEYWORD_HOW;
            fortuneOutput = new FortuneOutputArrays(keyword).fortuneAnswerOutput;
        } else if (lowerCase.contains(VALID_KEYWORD_WHEN)) {
            keyword = VALID_KEYWORD_WHEN;
            fortuneOutput = new FortuneOutputArrays(keyword).fortuneAnswerOutput;
        } else if (lowerCase.contains(VALID_KEYWORD_WILL)) {
            keyword = VALID_KEYWORD_WILL;
            fortuneOutput = new FortuneOutputArrays(keyword).fortuneAnswerOutput;
        } else {
            if (lowerCase.equals("stop")) {
                mainActivity.finish();
            }
            else fortuneOutput = "Can't you read? Ask a question beginning with who, what, where, when, why, how, or will. I'm literally shaking my head right now.";}
    }

    public void editTextValidate(String usersQuestion, AlertDialog.Builder builder) {

        String lowerCase = usersQuestion.toLowerCase();
        if (lowerCase.contains(VALID_KEYWORD_WHO)) {
            keyword = VALID_KEYWORD_WHO;
            createDialogForFortuneEval(builder);
        } else if (lowerCase.contains(VALID_KEYWORD_WHAT)) {
            keyword = VALID_KEYWORD_WHAT;
            createDialogForFortuneEval(builder);
        } else if (lowerCase.contains(VALID_KEYWORD_WHERE)) {
            keyword = VALID_KEYWORD_WHERE;
            createDialogForFortuneEval(builder);
        } else if (lowerCase.contains(VALID_KEYWORD_WHY)) {
            keyword = VALID_KEYWORD_WHY;
            createDialogForFortuneEval(builder);
        } else if (lowerCase.contains(VALID_KEYWORD_HOW)) {
            keyword = VALID_KEYWORD_HOW;
            createDialogForFortuneEval(builder);
        } else if (lowerCase.contains(VALID_KEYWORD_WHEN)) {
            keyword = VALID_KEYWORD_WHEN;
            createDialogForFortuneEval(builder);
        } else if (lowerCase.contains(VALID_KEYWORD_WILL)) {
            keyword = VALID_KEYWORD_WILL;
            createDialogForFortuneEval(builder);
        } else {
            if (lowerCase.equals("stop") || lowerCase.contains("stop ")) {
                mainActivity.finish();
            } else {
                // create Alert Window
                builder.setTitle(R.string.invalid_title);
                builder.setMessage(R.string.invalid_message);
                // create Back app click option on Alert
                builder.setPositiveButton(R.string.go_back_button_text,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                // back to app
                                Toast.makeText(context,
                                        R.string.toast_back_text, Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        });
                // create Exit app click option on Alert
                builder.setNegativeButton(R.string.exit_app_text,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                // exit the app
                                mainActivity.finish();
                            }
                        });
                builder.create();
                builder.show();
            }
        }
    }
    // activated upon an acceptable entry
    public void createDialogForFortuneEval(AlertDialog.Builder builder) {
        fortuneOutput = new FortuneOutputArrays(keyword).fortuneAnswerOutput;
        // create Alert Window
        builder.setTitle(R.string.fortune_title_text);
        builder.setMessage(fortuneOutput);
        // create Play Again? button on Alert
        builder.setNeutralButton(R.string.ask_again_text, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                // back to app
                dialog.dismiss();
            }
        });
        builder.create();
        builder.show();
    }

    @Override
    public void onInit(int status) {
        if(status == TextToSpeech.SUCCESS){
            Log.d("flow", "success");

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                textToSpeech.speak(fortuneOutput, TextToSpeech.QUEUE_FLUSH, null, null);
            } else {
                textToSpeech.speak(fortuneOutput, TextToSpeech.QUEUE_ADD, null);
            }

        }
    }
}