import { Component, OnInit } from '@angular/core';

import { RegisterService } from './../../services/register.service';
import { RegistroEntity } from '../../model/registroEntity.model';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  private registers: Array<RegistroEntity>;
  constructor( private registerService: RegisterService) { }

  ngOnInit() {
    this.loadRegisters();
  }

  private loadRegisters(): void {
    this.registerService.getRegisters().subscribe(res => {
      this.registers = res;
    });
  }
}
