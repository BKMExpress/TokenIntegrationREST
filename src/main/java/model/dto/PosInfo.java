package model.dto;

public class PosInfo {

    private String userId;

    private String password;

    private String url;

    private String extra;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "PosInfo{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", url='" + url + '\'' +
                ", extra='" + extra + '\'' +
                '}';
    }
}
