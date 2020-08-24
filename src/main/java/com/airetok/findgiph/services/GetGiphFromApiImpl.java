package com.airetok.findgiph.services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.airetok.findgiph.entity.Giph;

@Component("getGiph")
public class GetGiphFromApiImpl implements GetGiphFromApi {
	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public List<Giph> getGiphs(String url) {
		List<Giph>giphs = new ArrayList<Giph>();
		List<String> urls = new ArrayList<String>();
		List<String> titles = new ArrayList<String>();
		List<String> types = new ArrayList<String>();
		List<String> rates = new ArrayList<String>();
		@SuppressWarnings("unchecked")
		Map<String,Object>map = restTemplate.getForObject(url, LinkedHashMap.class);
		for(Map.Entry<String, Object> pair : map.entrySet()) {
			if(pair.getKey().equals("data")) {
				@SuppressWarnings("unchecked")
				List<LinkedHashMap<String,Object>>list = ( List< LinkedHashMap <String,Object> > )pair.getValue();
				for(int i = 0; i < list.size(); i++) {
					LinkedHashMap<String,Object> map2 = (LinkedHashMap<String, Object>) list.get(i);
					for(Map.Entry<String, Object> pair2 : map2.entrySet()) {
						System.out.println(pair2.getKey());
						if(pair2.getKey().equals("title")) {
							titles.add((String) pair2.getValue());
						}
						if(pair2.getKey().equals("rating")) {
							rates.add((String) pair2.getValue());
						}
						if(pair2.getKey().equals("type")) {
							types.add((String) pair2.getValue());
						}

						if(pair2.getKey().equals("images")) {
							@SuppressWarnings("unchecked")
							LinkedHashMap<String,Object> map3 = (LinkedHashMap<String, Object>) pair2.getValue();
							for(Map.Entry<String, Object> pair3 : map3.entrySet()) {
								if(pair3.getKey().equals("original")) {
									@SuppressWarnings("unchecked")
									LinkedHashMap<String,Object> map4 = (LinkedHashMap<String, Object>) pair3.getValue();
									for(Map.Entry<String, Object> pair4 : map4.entrySet()) {
										if(pair4.getKey().equals("url")) {
											urls.add((String) pair4.getValue());
										}
									}
									}


								}
							}
							}


						}
					}

				}
		
		for (int i = 0; i < titles.size(); i++) {
			System.out.println(titles.get(i));
		}
		for (int i = 0; i < urls.size(); i++) {
			System.out.println(urls.get(i));
		}
		System.out.println(titles.size());
		System.out.println(urls.size());
		System.out.println(types.size());
		System.out.println(rates.size());
		for(int i = 0; i < urls.size(); i++) {
			giphs.add(new Giph(types.get(i),titles.get(i),urls.get(i),rates.get(i)));
		}
		return giphs;
	}

	@Override
	public Giph getRandomGiph(String url) {
		String type = null;
		String title = null;
		String rating = null;
		String gif_url = null;
		@SuppressWarnings("unchecked")
		Map<String,Object>map = restTemplate.getForObject(url, LinkedHashMap.class);
		for(Map.Entry<String, Object> pair : map.entrySet()) {
			if(pair.getKey().equals("data")) {
				@SuppressWarnings("unchecked")
				LinkedHashMap<String,Object> map2 = (LinkedHashMap<String, Object>) pair.getValue();
				for(Map.Entry<String, Object> pair2 : map2.entrySet()) {
					if(pair2.getKey().equals("type")) {
						type = (String) pair2.getValue();
					}
					if(pair2.getKey().equals("title")) {
						title = (String) pair2.getValue();
					}
					if(pair2.getKey().equals("rating")) {
						rating = (String) pair2.getValue();
					}
					if(pair2.getKey().equals("image_original_url")) {
						gif_url = (String) pair2.getValue();
					}
				}

			}
		}
		Giph giph = new Giph(type,title,gif_url,rating);
		
		return giph;
	}
	
	

	
	

	
	

}
