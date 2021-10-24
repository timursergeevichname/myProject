package wtomod.base;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Audio;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.Voice;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;

public class TimeBot extends TelegramLongPollingBot {

    private ArrayList<User> users= new ArrayList();


    @Override
    public String getBotUsername() {
        return "null";
    }

    @Override
    public String getBotToken() {
        return "1282448471:AAEI7vJnLBytywumVlIUTKJOd9m9YlrJSvk";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage()){
            System.out.println(update);

            Integer updateId = update.getUpdateId();
            org.telegram.telegrambots.meta.api.objects.User from = update.getMessage().getFrom();

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(update.getMessage().getChatId().toString());
            sendMessage.setText(String.format("User name %s", from.getFirstName())); //text comment

            try {
                for (int i = 0; i < 1000; i++) {

                    sendMessage.setText(String.valueOf(i));
                    execute(sendMessage);
                }

            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }
    }

}

class User {

    private String name;
    private int chatId;

    public User(String name, int chatId) {
        this.name = name;
        this.chatId = chatId;
    }

    public String getName() {
        return name;
    }

    public int getChatId() {
        return chatId;
    }
}
