/**
 * 
 */
package designPattern;

/**
 * 旨在说明Builder(构造者)模式
 * @author echoplex_x email:wangting-xy@360.cn
 * @date 2016年4月6日
 */
public class 营养物质 {
    private final int 分量;
    private final int 每份含量;
    private final int 卡路里;
    private final int 脂肪;
    private final int 钠;
    private final int 碳水化合物;
    
    public static class Builder{
        private final int 分量;
        private final int 每份含量;
        
        private int 卡路里;
        private int 脂肪;
        private int 钠;
        private int 碳水化合物;
        
        public Builder(int 分量, int 每份含量){
            this.分量 = 分量;
            this.每份含量 = 每份含量;
        }
        
        public Builder 卡路里(int var){
            卡路里 = var;
            return this;
        }
        
        public Builder 脂肪(int var){
            脂肪 = var;
            return this;
        }
        
        public Builder 钠(int var){
            钠 = var;
            return this;
        }
        
        public Builder 碳水化合物(int var){
            碳水化合物 = var;
            return this;
        }
        
        public 营养物质 build(){
            return new 营养物质(this);
        }
    }
    
    private 营养物质(Builder builder){
        this.分量 = builder.分量;
        this.每份含量 = builder.每份含量;
        this.卡路里 = builder.卡路里;
        this.脂肪 = builder.脂肪;
        this.钠 = builder.钠;
        this.碳水化合物 = builder.碳水化合物;
    }

}
