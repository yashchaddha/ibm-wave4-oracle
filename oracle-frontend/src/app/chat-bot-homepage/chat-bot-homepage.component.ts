import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-chat-bot-homepage",
  templateUrl: "./chat-bot-homepage.component.html",
  styleUrls: ["./chat-bot-homepage.component.css"]
})
export class ChatBotHomepageComponent implements OnInit {
  constructor() {}
  query: string = "";

  ngOnInit() {}
  onSubmit(value) {
    console.log("submitted" + JSON.stringify(value));
  }
}
