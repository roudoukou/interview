package icu.xiamu;

import com.alibaba.fastjson2.JSON;
import icu.xiamu.entity.AIGuideCard;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ReadJson {
    @Test
    public void test1() {
        List<AIGuideCard> list = new ArrayList<>();
        InputStream resourceAsStream = ReadJson.class.getClassLoader().getResourceAsStream("ai_guide_card.json");
        try {
            if (null != resourceAsStream) {
                String result = IOUtils.toString(resourceAsStream, StandardCharsets.UTF_8);
                list = JSON.parseArray(result, AIGuideCard.class);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        list.forEach(System.out::println);
    }
}
