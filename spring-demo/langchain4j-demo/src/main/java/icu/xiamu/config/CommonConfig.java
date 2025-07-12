package icu.xiamu.config;

import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {
    @Autowired
    private OpenAiChatModel model;
    // @Bean
    // public ConsultantService consultantService() {
    //     ConsultantService cs = AiServices.builder(ConsultantService.class)
    //             .chatModel(model)
    //             // 设置对话时使用的模型对象
    //             .build();
    //     return cs;
    // }
}