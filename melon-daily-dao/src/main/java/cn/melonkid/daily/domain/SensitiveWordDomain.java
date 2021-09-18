package cn.melonkid.daily.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 敏感词
 *
 * @author imelonkid
 * @date 2021/09/17 21:34
 **/
public class SensitiveWordDomain {

    private int id;

    private String word;

    private String msg;

    private String conclusion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("word", word).append("msg", msg)
            .append("conclusion", conclusion).toString();
    }
}
