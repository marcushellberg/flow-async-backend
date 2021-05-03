package com.example.application.views.helloworld;

import com.example.application.backend.BackendService;
import com.example.application.views.main.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainView.class)
@CssImport("./views/helloworld/hello-world-view.css")
public class HelloWorldView extends HorizontalLayout {
  private BackendService service;

  private TextField nameField = new TextField("Your name");
  private Button button = new Button("Say hello", e -> save());

  public HelloWorldView(BackendService service) {
    this.service = service;
    addClassName("hello-world-view");

    add(nameField, button);
    setAlignItems(Alignment.BASELINE);
  }

  private void save() {
    service.save(nameField.getValue());
    showNotification();
    nameField.clear();
  }

  private void showNotification() {
    var notification = new Notification("Saved!");
    notification.setPosition(Position.MIDDLE);
    notification.setDuration(3000);
    notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
    notification.open();
  }

}
