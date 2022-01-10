module client.app.ui.main {
    requires org.json;
    requires java.desktop;
    requires client.app.data.main;
    exports com.ui.component;
    exports com.ui.component.subcomponent;
    exports com.ui.component.dialog;
}