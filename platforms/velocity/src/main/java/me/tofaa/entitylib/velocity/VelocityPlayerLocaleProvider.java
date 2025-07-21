package me.tofaa.entitylib.velocity;

import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import me.tofaa.entitylib.UserLocaleProvider;
import java.util.Locale;
import java.util.UUID;

public class VelocityPlayerLocaleProvider implements UserLocaleProvider {
    private final ProxyServer proxyServer;

    public VelocityPlayerLocaleProvider(final ProxyServer proxyServer) {
        this.proxyServer = proxyServer;
    }

    @Override
    public Locale locale(final UUID user) {
        return proxyServer.getPlayer(user).map(Player::getEffectiveLocale).orElse(Locale.US);
    }
}
