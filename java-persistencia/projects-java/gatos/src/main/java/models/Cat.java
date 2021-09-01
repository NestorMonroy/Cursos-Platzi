package models;

public class Cat {
    private String id;
    private String url;
    private String width;
    private String height;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return Integer.parseInt(width);
    }

    public void setWidth(String width) {
        this.width = width;
    }


    public int getHeight() {
        return Integer.parseInt(height);
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
