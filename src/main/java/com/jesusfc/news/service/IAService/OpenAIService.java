package com.jesusfc.news.service.IAService;
import com.jesusfc.news.model.openApi.Answer;
import com.jesusfc.news.model.openApi.Question;
import org.springframework.ai.chat.prompt.Prompt;


/**
 * Author Jesús Fdez. Caraballo
 * jfcaraballo@gmail.com
 * Created on may - 2024
 */
public interface OpenAIService {

    String getForNewTitle(String question);

    String getForNewsResume(String news);

    String getAnswer(Prompt prompt);

    Answer getAnswer(Question question);

}
