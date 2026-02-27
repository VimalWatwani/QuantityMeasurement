package org.quantity.management.channels;

import java.util.List;
import java.util.Map;

public class StarSports implements IChannel<ChannelType> {


    @Override
    public void addToListOfChannels(Map<ChannelType, List<IChannel>> t) {
        t.get(ChannelType.SPORTS).add(this);
//        t.put(ChannelType.SPORTS,)
    }

    @Override
    public List<IChannel> getListOfChannels(ChannelType channelType) {
        return List.of();
    }

    @Override
    public void sendNotification() {

    }
}
