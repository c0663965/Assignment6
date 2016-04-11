/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package message;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ApplicationScoped;

/**
 *
 * @author Kihoon Lee 
 */
@ApplicationScoped
public class MessageController {

    List<Message> list = new ArrayList<>();
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        
    list.add(new Message(1,"Java","Kihoon","preparing for the exam",sdf.parse("2013-09-18 01:34:09")));
    list.add(new Message(2,"JQuery","Gagan","finishing the project",sdf.parse("2015-03-25 11:34:09")));
    list.add(new Message(3,"PL/SQL","Smith","getting a co-op",sdf.parse("2016-04-10 12:24:34")));
    
    public MessageController() throws ParseException{
        
      
    } 
    
    public List<Message> getList() {
        return list;
    }
    
    public Message getMessageById(int id){
        for(int i=0;i<list.size();i++)
            if(list.get(i).getId()==id)
                return list.get(i);
            
        return null;
    }
    
    public void addNewMessage(Message message){
           list.add(message);
    }
    
    public List<Message> getMessageFromTo(Date from, Date to) throws ParseException{
        
        List<Message> byDate = new ArrayList<>();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        Date date;
        
        for(int i=0;i<list.size();i++)       
        {
            
            date=sdf.parse(list.get(i).getSenttime());
            
            if(from.after(date)&&date.before(to))
                byDate.add(list.get(i));
        }    
        
        return byDate;
    }
    
    
    public void deleteMessage(int id){
        for(int i=0;i<list.size();i++)
            if(list.get(i).getId()==id)
                list.remove(id);
    }
    
    @Override
    public String toString()
    {
        String str="[";
        
        for (int i=0;i<list.size();i++)
            str+=list.get(i).toString()+",\n";
        
        return str.substring(0,str.length()-2)+"]";
    }
}