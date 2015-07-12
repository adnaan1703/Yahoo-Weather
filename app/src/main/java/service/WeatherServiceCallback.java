package service;

import data.Channel;

/**
 * Created by Kon El on 12-07-2015.
 */
public interface WeatherServiceCallback {
    void ServiceSuccess(Channel channel);
    void ServiceFailure(Exception exception);
}
