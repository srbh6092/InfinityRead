package com.noobdevs.infinityread.Model;

public class ModelChatCard {
    String userNameChat , userLatestMessageChat ;
    int userPicChat ;

    public ModelChatCard(String userNameChat, String userLatestMessageChat, int userPicChat) {
        this.userNameChat = userNameChat;
        this.userLatestMessageChat = userLatestMessageChat;
        this.userPicChat = userPicChat;
    }

    public String getUserNameChat() {
        return userNameChat;
    }

    public void setUserNameChat(String userNameChat) {
        this.userNameChat = userNameChat;
    }

    public String getUserLatestMessageChat() {
        return userLatestMessageChat;
    }

    public void setUserLatestMessageChat(String userLatestMessageChat) {
        this.userLatestMessageChat = userLatestMessageChat;
    }

    public int getUserPicChat() {
        return userPicChat;
    }

    public void setUserPicChat(int userPicChat) {
        this.userPicChat = userPicChat;
    }
}
