package com.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
public class TilesConfig {

	@Bean
	public TilesConfigurer tilesConfigurer() {
		final TilesConfigurer conf = new TilesConfigurer();
		// xml 설정파일의 경로를 지정해준다.
		conf.setDefinitions("/WEB-INF/tiles/tiles.xml");
		// refresh 가능 여부
		conf.setCheckRefresh(true);
		return conf;
	}

	@Bean
	public TilesViewResolver tilesViewResolver() {
		final TilesViewResolver res = new TilesViewResolver();
		res.setViewClass(TilesView.class);
		return res;
	}
}