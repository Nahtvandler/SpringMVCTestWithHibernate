package spring;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonDTO {

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "content")
    private String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
