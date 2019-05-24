package me.kagami.studybatch;

import org.springframework.batch.item.ItemProcessor;
//将字符串转为大写
public class Processor implements ItemProcessor<String, String> {

    @Override
    public String process(String data) throws Exception {
        System.out.println("----process----");
        return data.toUpperCase();
    }

}
