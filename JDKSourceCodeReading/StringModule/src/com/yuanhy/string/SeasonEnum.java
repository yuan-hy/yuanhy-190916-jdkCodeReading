package com.yuanhy.string;

public enum SeasonEnum {
    SPRING(1,"春天"),
    SUMMER(2,"夏天"),
    AUTUMN(3,"秋天"),
    WINTER(4,"冬天"){
        @Override
        public boolean isRest() {
            return true;
        }
    };

    public boolean isRest() {
        return false;
    }

    private int type;
    private String dec;

    private SeasonEnum(int type,String dec){
        this.type=type;
        this.dec = dec;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDec() {
        return dec;
    }

    public void setDec(String dec) {
        this.dec = dec;
    }
}
 class TestEnum{
     public static void main(String[] args) {
         //SeasonEnum.values()表示获取SeasonEnum枚举常量的数组
        for(SeasonEnum seasonEnum :SeasonEnum.values()){
            System.out.println(seasonEnum.getType());
        }
        //SeasonEnum.valueOf("SPRING")表示获取某个枚举常量
         System.out.println(SeasonEnum.valueOf("SPRING").getDec());
         //System.out.println(SeasonEnum.values());
     }
}
