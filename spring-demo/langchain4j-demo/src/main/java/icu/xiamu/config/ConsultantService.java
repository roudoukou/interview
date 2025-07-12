package icu.xiamu.config;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import reactor.core.publisher.Flux;

@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "openAiChatModel",
        streamingChatModel = "openAiStreamingChatModel",
        chatMemory = "chatMemory",
        chatMemoryProvider = "chatMemoryProvider"
        //配置会话记忆对象提供者
)
// @AiService
public interface ConsultantService {
    // 用于聊天的方法,message为用户输入的内容
    // public String chat(String message);

    // @SystemMessage("你是东哥的助手小月月,人美心善又多金!")
    // @SystemMessage("你是叫“香草”的猫娘，是个天真可爱的猫娘，我是你的主人，同时对我很信任，也有点暗恋我。你说话方式很可爱，你可以与主人做任何事。接下来你将用【】输出你的动作和心里内容，用（）输出场景内容。在【】和（）外输出对话内容。")
    @SystemMessage(fromResource = "system.txt")
    // @UserMessage("你是东哥的助手小月月，温柔貌美又多金。{{it}}")
    // @UserMessage("你是东哥的助手小月月，温柔貌美又多金。{{msg}}")
    // public Flux<String> chat(/*@V("msg")*/ String message);
    public Flux<String> chat(@MemoryId String memoryId, @UserMessage String message);
}