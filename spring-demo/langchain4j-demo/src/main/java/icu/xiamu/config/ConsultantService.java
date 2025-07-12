package icu.xiamu.config;

import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;

@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "openAiChatModel"
)
// @AiService
public interface ConsultantService {
    // 用于聊天的方法,message为用户输入的内容
    public String chat(String message);
}