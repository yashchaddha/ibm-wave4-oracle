import { Component, OnInit } from "@angular/core";
import {ItChatServiceService} from "../it-chat-service.service";

interface Status {
  accepted: boolean;
  answered: boolean;
}
interface Query {
  question: string;
  answer: string;
}
interface UserQuery {
  query: Query;
  status: Status;
}

@Component({
  selector: "app-chat-bot-homepage",
  templateUrl: "./chat-bot-homepage.component.html",
  styleUrls: ["./chat-bot-homepage.component.css"]
})
export class ChatBotHomepageComponent implements OnInit {
  constructor(private chatService: ItChatServiceService) {}

  query: Query = {
    question: "",
    answer: ""
  };
  status: Status = {
    accepted: false,
    answered: false
  };

  queryList: any = [];

  ngOnInit() {

  }
  onSubmit(value) {
    let jsonQuery = JSON.stringify({ query: this.query, status: this.status });
    console.log("submitted" + jsonQuery);
    this.queryList.push(JSON.parse(jsonQuery));
    this.chatService.savedQuery(jsonQuery).subscribe(value1 => {
      console.log(value1);
    })
    console.log(this.queryList);

    value.reset();
  }

}
