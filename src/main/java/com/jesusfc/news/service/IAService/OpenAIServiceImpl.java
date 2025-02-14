package com.jesusfc.news.service.IAService;

import com.jesusfc.news.model.openApi.Answer;
import com.jesusfc.news.model.openApi.Question;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiAudioSpeechModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.stereotype.Service;


/**
 * Author Jesús Fdez. Caraballo
 * jfcaraballo@gmail.com
 * Created on may - 2024
 */

@Service
public class OpenAIServiceImpl implements OpenAIService {

    private final ChatClient chatClient;

    public OpenAIServiceImpl(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @Override
    public String getAnswer(String question) {
        PromptTemplate promptTemplate = new PromptTemplate(question);
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
