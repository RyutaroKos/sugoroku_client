module client.app.netcom.main {
    requires jakarta.websocket;
    requires org.json;
    requires client.app.data.main;
    exports com.netcom.websocket;
}