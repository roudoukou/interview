package icu.xiamu.entity;

public class AIGuideCard {
    private String name;
    private String memo;
    private String icon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "AIGuideCard{" +
                "name='" + name + '\'' +
                ", memo='" + memo + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
