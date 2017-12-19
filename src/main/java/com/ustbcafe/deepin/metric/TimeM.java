package com.ustbcafe.deepin.metric;

/**
 * Created by wangjin18 on 2017/12/13.
 */
public  class TimeM implements TimePerformance{
    private String theme;
    private Long start;
    private Long middle;
    public TimeM(String theme){
        this.theme=theme;
    }
    @Override
    public boolean start() {
        this.start=System.currentTimeMillis();
        this.middle=this.start;
        System.out.println(theme+" start:");
        return true;
    }

    @Override
    public boolean tic(String subTheme) {
        Long cur=System.currentTimeMillis();
        Long el=cur-this.middle;
        this.middle=cur;
        System.out.println(theme+" processed "+(subTheme!=null?subTheme:"")+" "+el+" ms");
        return true;
    }

    @Override
    public boolean stop() {
        tic(null);
        System.out.println(theme + " finished,takes total " + (middle-start) + " ms");
        return true;
    }
}
