package com.discord.bot;

import com.discord.bot.listener.ServerListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class JDASingleton {
    private static JDA INSTANCE;

    private JDASingleton() {

    }

    synchronized public static JDA getInstance(){

        if (INSTANCE == null) {
            try {
                JDABuilder jdaBuilder = JDABuilder.createDefault("");
                INSTANCE = jdaBuilder.build().awaitReady();
            } catch (LoginException | InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] argh){
        JDA jda = JDASingleton.getInstance();
        jda.getPresence().setActivity(Activity.watching("How to basic"));
        jda.addEventListener(new ServerListener());

    }
}
