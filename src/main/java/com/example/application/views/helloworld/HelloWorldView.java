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
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "hello", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("Hello World")
@CssImport("./views/helloworld/hello-world-view.css")
public class HelloWorldView extends HorizontalLayout {

  private TextField nameField = new TextField("Your name");
  private Button sayHello = new Button("Say hello");
  private BackendService service;

  public HelloWorldView(BackendService service) {
    this.service = service;
    addClassName("hello-world-view");

    add(nameField, sayHello);
    setVerticalComponentAlignment(Alignment.END, nameField, sayHello);

    sayHello.addClickListener(e -> save());
  }

  private void save() {
    var name = nameField.getValue();
    service.save(name);

    System.out.println("Saved: " + name);

    var notification = new Notification("Saved: " + name);
    notification.setPosition(Position.MIDDLE);
    notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
    notification.open();

    nameField.clear();
  }

}
