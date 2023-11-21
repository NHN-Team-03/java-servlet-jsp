package com.nhnacademy.jsp.beans;

import java.io.Serializable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HtmlBeautifier implements Serializable {

    public HtmlBeautifier() {
    }

    private String html;

    public String getHtml() {
        return Jsoup.parse(html).html();
    }

    public void setHtml(String html) {
        this.html = html;
    }

    @Override
    public String toString() {
        return "HtmlBeautifier{" +
                "html='" + html + '\'' +
                '}';
    }
}
