package block.guess.my.bean;

public class AboutMeBean {

    private int category;
    private int resId;
    private String name;
    private String url;

    public AboutMeBean(int category, int resId, String name, String url) {
        this.category = category;
        this.resId = resId;
        this.name = name;
        this.url = url;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
