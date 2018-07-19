import { Component, OnInit } from '@angular/core';

import { RegisterService } from './../../services/register.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  constructor( private registerService: RegisterService) { }

  ngOnInit() {
  }

}
