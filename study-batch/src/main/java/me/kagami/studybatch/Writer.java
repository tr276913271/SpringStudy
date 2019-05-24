package me.kagami.studybatch;


import java.util.List;

import org.springframework.batch.item.ItemWriter;
//把转为大写的字符串输出到控制台
public class Writer implements ItemWriter<String> {

    @Override
    public void write(List<? extends String> messages) throws Exception {
        System.out.println("----write----");
        for (String msg : messages) {
            System.out.println("Writing the data " + msg);
        }
    }

}