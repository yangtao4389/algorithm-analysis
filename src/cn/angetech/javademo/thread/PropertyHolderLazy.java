package cn.angetech.javademo.thread;

import java.util.Properties;
/*
*
* 实现  线程安全的 配置文件加载器
*
* */
public class PropertyHolderLazy {
    private volatile static Properties prop = null;  //todo

    public static Properties getProps() throws Exception{
        if(prop == null){
            // 考虑线程安全的单例
            synchronized (PropertyHolderLazy.class){
                if(prop == null){
                    prop = new Properties();  // todo 这里初始化，可能还是会造成线程再次
                    prop.load(PropertyHolderLazy.class.getResourceAsStream("**.properties"));  // 该文件放置resources下面
                }
            }
        }
        return null;
    }

}
