package spring;

import java.io.Serializable;

public class ServiceProperty implements Serializable {

    public ServiceProperty(String header) {
        this.header = header;
        this.fairyOcrmEnabled = false;
    }

    private String header;

    private Boolean fairyOcrmEnabled;

    private String fairyOcrmUrl;

    private String realWsUrl;

    private String fairyResponceXml;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Boolean getFairyOcrmEnabled() {
        return fairyOcrmEnabled;
    }

    public void setFairyOcrmEnabled(Boolean fairyOcrmEnabled) {
        this.fairyOcrmEnabled = fairyOcrmEnabled;
    }

    public String getFairyOcrmUrl() {
        return fairyOcrmUrl;
    }

    public void setFairyOcrmUrl(String fairyOcrmUrl) {
        this.fairyOcrmUrl = fairyOcrmUrl;
    }

    public String getRealWsUrl() {
        return realWsUrl;
    }

    public void setRealWsUrl(String realWsUrl) {
        this.realWsUrl = realWsUrl;
    }

    public String getFairyResponceXml() {
        return fairyResponceXml;
    }

    public void setFairyResponceXml(String fairyResponceXml) {
        this.fairyResponceXml = fairyResponceXml;
    }

    @Override
    public String toString() {

        return "[" + header + "]" + "\r\n" +
                "isFairyOcrmEnabled=" + fairyOcrmEnabled + "\r\n" +
                "fairyOcrmUrl=" + fairyOcrmUrl != null ? fairyOcrmUrl : "..." + "\r\n" +
                "realWsUrl=" + realWsUrl != null ? realWsUrl : "..." + "\r\n" +
                "fairyResponceXml='" + fairyResponceXml != null ? fairyResponceXml : "..." + "\r\n";
    }
}
