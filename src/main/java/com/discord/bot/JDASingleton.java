package com.discord.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class JDASingleton {
    private static JDA INSTANCE;

    private JDASingleton() {

    }

    synchronized public static JDA getInstance(){

        if (INSTANCE == null) {
            try {
                JDABuilder jdaBuilder = JDABuilder.createDefault("NzYyNzUwODYxODg5NjM0Mzc1.X3ttGA.GCZatpGvs4xBxqZ13f9qAXGglD8");
                INSTANCE = jdaBuilder.build();
            } catch (LoginException exception) {
                exception.printStackTrace();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] argh){
        JDASingleton.getInstance();
    }
}
