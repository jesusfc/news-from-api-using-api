package com.jesusfc.news.service.IAService;

import com.jesusfc.news.model.openApi.Answer;
import com.jesusfc.news.model.openApi.Question;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;


/**
 * Author Jesús Fdez. Caraballo
 * jfcaraballo@gmail.com
 * Created on may - 2024
 */

@Service
public class OpenAIServiceImpl implements OpenAIService {

    private final static String ASK_FOR_TITLE_PROMPT = "Can you remake the following sentence '#TITLE#'?";
    private final static String ASK_FOR_NEWS_PROMPT = "Can you resume the following sentence '#NEWS#'?";

    private final ChatClient chatClient;

    public OpenAIServiceImpl(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @Override
    public String getForNewTitle(String question) {
        String newQuestion = ASK_FOR_TITLE_PROMPT.replace("#TITLE#", question);
        PromptTemplate promptTemplate = new PromptTemplate(newQuestion);
        Prompt prompt = promptTemplate.create();
        ChatResponse response = chatClient.prompt(prompt).call().chatResponse();
        return response.getResult().getOutput().getContent();
    }

    @Override
    public String getForNewsResume(String news) {
        String newQuestion = ASK_FOR_NEWS_PROMPT.replace("#NEWS#", news);
        PromptTemplate promptTemplate = new PromptTemplate(newQuestion);
        Prompt prompt = promptTemplate.create();
        ChatResponse response = chatClient.prompt(prompt).call().chatResponse();
        return response.getResult().getOutput().getContent();
    }

    @Override
    public String getAnswer(Prompt prompt) {
        ChatResponse response = chatClient.prompt(prompt).call().chatResponse();
        return response.getResult().getOutput().getContent();
    }

    @Override
    public Answer getAnswer(Question question) {
        PromptTemplate promptTemplate = new PromptTemplate(question.question());
        Prompt prompt = promptTemplate.create();
        ChatResponse response = chatClient.prompt(prompt).call().chatResponse();
        return new Answer(response.getResult().getOutput().getContent());
    }


}
