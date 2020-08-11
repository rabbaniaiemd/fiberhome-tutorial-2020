package com.fiberhome.socket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketChatConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/websocketApp").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {

		registry.setApplicationDestinationPrefixes("/app");
		/**
		 * enabling simple broker
		 */
		registry.enableSimpleBroker("/topic");

		/**
		 * enabling remote broker like RabbitMq: Precondition --> Rabbitque will be proper configure / uncomment and check
		 */

		/*registry.enableStompBrokerRelay("/topic","/queue").setRelayPort(61613).setClientLogin("guest")
				.setClientPasscode("guest");*/

	}
}
