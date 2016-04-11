/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package message;


import java.text.SimpleDateFormat;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author Kihoon, Lee
 */

public class Message {
    
    private int id;
    private String title;
    private String contents;
    private String author;
    private Date senttime;

    public Message(){
    }

    public Message(int id, String title, String contents, String autor, Date senttime) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.author = autor;
        this.senttime=senttime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getAutor() {
        return author;
    }

    public void setAutor(String autor) {
        this.author = autor;
    }
    
    public String getSenttime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(senttime);
    }

    public void setSenttime(Date senttime) {
        this.senttime = senttime;
    }
    
    @Override
    public String toString(){

       JsonObject json = Json.createObjectBuilder()
                                .add("id",id)
                                .add("title", title)
                                .add("contents", contents)
                                .add("author",author)
                                .add("senttime",getSenttime()).build();
        return json.toString();
    }
}

