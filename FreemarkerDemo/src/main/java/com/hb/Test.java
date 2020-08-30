package com.hb;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hb
 * @create 2020-08-05 10:33
 */
public class Test {

    public static void main(String[] args) throws Exception {
        //第一步：创建一个 Configuration 对象，直接 new 一个对象。构造方法的参数就是 freemarker的版本号。
        Configuration configuration = new Configuration(Configuration.getVersion());
        //设置模板所在目录
        configuration.setDirectoryForTemplateLoading(new File(".\\src\\main\\resources"));
        //设置字符集
        configuration.setDefaultEncoding("utf-8");
        //加载模板
        Template template = configuration.getTemplate("test.ftl");
        //创建数据模型
        Map map = new HashMap();
        map.put("name","学员");
        map.put("message","欢迎来学习！");
        //创建Writer对象
        FileWriter out = new FileWriter(new File(".\\src\\main\\resources\\", "demo.html"));
        //输出
        template.process(map,out);
        System.out.println("生成成功");
        //关闭输出流
        out.close();
    }
}
