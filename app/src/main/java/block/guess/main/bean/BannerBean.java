package block.guess.main.bean;

public class BannerBean {

    /**
     * id : 1
     * url : http://o79wtqtvy.bkt.clouddn.com/avatar/bg_img_banner.png
     * href :
     * locale : zh
     * category : 2
     * created_at : 20180824115049
     * updated_at : 20180824115056
     */

    private int id;
    private String url;
    private String href;
    private String locale;
    private int category;
    private long created_at;
    private long updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }

    public long getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(long updated_at) {
        this.updated_at = updated_at;
    }
}
