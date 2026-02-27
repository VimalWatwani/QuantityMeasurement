package org.quantity.management.channels;

import java.util.List;
import java.util.Map;

public interface IChannel<T> {

    public void addToListOfChannels(Map<T,List<IChannel>> t);

    public List<IChannel> getListOfChannels(T t);

    public void sendNotification();
}
