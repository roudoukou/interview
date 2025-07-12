package icu.xiamu;

import dev.langchain4j.model.openai.OpenAiChatModel;

/**
 * @author roudoukou
 * @date 2025/7/12
 */
public class App {
    public static void main(String[] args) {

        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                //url参考百炼平台API文档
                .apiKey(System.getenv("API-KEY"))
                //获取环境变量API-KEY使用
                .modelName("qwen-plus")
                //设置模型名称
                .logRequests(true)
                // //设置打印请求日志
                .logResponses(true)
                //设置打印响应日志
                .build();

        //3.调用chat方法,交互
        String result = model.chat("黄磊帅不帅?");
        System.out.println(result);
    }
}
