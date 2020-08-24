package com.airetok.findgiph.services;

import java.util.List;

import com.airetok.findgiph.entity.Giph;

public interface GetGiphFromApi {
List<Giph> getGiphs(String url);
Giph getRandomGiph(String url);
}
