package top.ourfor.game.tankwar;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.ourfor.game.tankwar.ui.GameFrame;

import javax.annotation.PostConstruct;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class Application {

	private final GameFrame gameFrame;

	@PostConstruct
	public void init() {
	    log.info("程序启动中");
		gameFrame.start();
	}

	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");
		SpringApplication.run(Application.class,args);
	}

}
