package com.discord.bot.listener;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class ServerListener extends ListenerAdapter {

    public ServerListener() {

    }

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] argh = event.getMessage().getContentRaw().split("\n");

        for (String line : argh) {
            //TODO: filter by channel name
            if(line.contains("!newTicket")) {
                sendMessageInChannel(event);
                sendPrivateMessage(event);
            }
        }
    }

    private void sendMessageInChannel(GuildMessageReceivedEvent event) {
        event.getChannel().sendMessage(getEmbedMessage().build()).queue();
    }

    @NotNull
    private EmbedBuilder getEmbedMessage() {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Uch scho Spasti");
        embedBuilder.setColor(Color.YELLOW);
        embedBuilder.setDescription("Ey dau Nassgekämmten. Wat wills dau dann hei?");
        return embedBuilder;
    }

    private void sendPrivateMessage(GuildMessageReceivedEvent event) {
        event.getAuthor().openPrivateChannel().queue((channel -> {
            channel.sendMessage("Ey dau Nassgekämmten. Wat wills dau dann hei?").queue();
        }));
    }


}
