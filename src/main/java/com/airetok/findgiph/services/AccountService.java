package com.airetok.findgiph.services;

import java.util.Map;

import com.airetok.findgiph.entity.AddGifInput;
import com.airetok.findgiph.entity.UserGif;

public interface AccountService {
Map<Integer, String> getUrlsFromDb(UserGif userGif);
UserGif addGifToUser(UserGif userGif,AddGifInput addGifInput);
UserGif deleteGifFromUser(UserGif userGif,Integer url);
UserGif deleteAllGifsFromUser(UserGif userGif);
}
