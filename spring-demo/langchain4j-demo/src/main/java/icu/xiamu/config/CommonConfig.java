package icu.xiamu.config;

import dev.langchain4j.data.document.Document;

import dev.langchain4j.data.document.loader.ClassPathDocumentLoader;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CommonConfig {
    @Autowired
    private OpenAiChatModel model;

    @Autowired
    private ChatMemoryStore redisChatMemoryStore;
    // @Bean
    // public ConsultantService consultantService() {
    //     ConsultantService cs = AiServices.builder(ConsultantService.class)
    //             .chatModel(model)
    //             // 设置对话时使用的模型对象
    //             .build();
    //     return cs;
    // }

    @Bean
    public ChatMemory chatMemory() {
        return MessageWindowChatMemory.builder()
                .maxMessages(20)
                //最大保存的会话记录数量
                .build();
    }

    @Bean
    public ChatMemoryProvider chatMemoryProvider() {
        ChatMemoryProvider chatMemoryProvider = new ChatMemoryProvider() {
            @Override
            public ChatMemory get(Object memoryId) {
                return MessageWindowChatMemory.builder()
                        .id(memoryId)//id值
                        .maxMessages(20)//最大会话记录数量
                        .chatMemoryStore(redisChatMemoryStore)
                        .build();
            }
        };
        return chatMemoryProvider;
    }

    @Bean
    public EmbeddingStore store(){
        //1.加载文档进内存
        // List<Document> documents = ClassPathDocumentLoader.loadDocuments("content");
        // List<Document> documents = ClassPathDocumentLoader.loadDocuments("content");
        List<Document> documents = FileSystemDocumentLoader.loadDocuments("D:\\xiamu\\workspace\\interview\\spring-demo\\langchain4j-demo\\src\\main\\resources\\content");
        //2.构建向量数据库操作对象  操作的是内存版本的向量数据库
        InMemoryEmbeddingStore store = new InMemoryEmbeddingStore();
        //3.构建一个EmbeddingStoreIngestor对象,完成文本数据切割,向量化, 存储
        EmbeddingStoreIngestor ingestor = EmbeddingStoreIngestor.builder()
                .embeddingStore(store)
                .build();
        ingestor.ingest(documents);
        return store;
    }

    @Bean
    public ContentRetriever contentRetriever(EmbeddingStore store){
        return EmbeddingStoreContentRetriever.builder()
                .embeddingStore(store)//设置向量数据库操作对象
                .minScore(0.5)//设置最小分数
                .maxResults(3)//设置最大片段数量
                .build();
    }
}