import { Component, OnInit, QueryList } from "@angular/core";

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
  constructor() {}

  query: Query = {
    question: "",
    answer: ""
  };
  status: Status = {
    accepted: false,
    answered: false
  };

  queryList: any = [];

  ngOnInit() {}
  onSubmit(value) {
    let jsonQuery = JSON.stringify({ query: this.query, status: this.status });
    console.log("submitted" + jsonQuery);
    this.queryList.push(JSON.parse(jsonQuery));
    console.log(this.queryList);
    value.reset();
  }
}
