package ziemansoft.ziemapp.testapp.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Responce {
    @SerializedName("imageassets")
    @Expose
    private List<String> imageassets = null;
    @SerializedName("getBannerContent")
    @Expose
    private boolean getBannerContent;
    @SerializedName("urlToDisplay")
    @Expose
    private String urlToDisplay;

    public List<String> getImageassets() {
        return imageassets;
    }

    public void setImageassets(List<String> imageassets) {
        this.imageassets = imageassets;
    }

    public boolean isGetBannerContent() {
        return getBannerContent;
    }

    public void setGetBannerContent(boolean getBannerContent) {
        this.getBannerContent = getBannerContent;
    }

    public String getUrlToDisplay() {
        return urlToDisplay;
    }

    public void setUrlToDisplay(String urlToDisplay) {
        this.urlToDisplay = urlToDisplay;
    }

}
