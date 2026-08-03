import SockJS from "sockjs-client/dist/sockjs";
import { Client } from "@stomp/stompjs";

let client = null;

export const connectWebSocket = (onMessage) => {
  const socket = new SockJS("http://localhost:8080/ws");

  client = new Client({
    webSocketFactory: () => socket,
    reconnectDelay: 5000,

    onConnect: () => {
      console.log("WebSocket Connected");

      client.subscribe("/topic/logs", (message) => {
        const log = JSON.parse(message.body);
        onMessage(log);
      });
    },

    onStompError: (frame) => {
      console.error(frame);
    },
  });

  client.activate();
};

export const disconnectWebSocket = () => {
  if (client) {
    client.deactivate();
  }
};