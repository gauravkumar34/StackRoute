import { Component, OnInit } from '@angular/core';
import {TodoService }from 'src/app/services/todo.service'
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  
  constructor(private services : TodoService) { }
  
  ngOnInit(): void {
    this.GetTodoItem();
    this.getTrash();
  }
  public trashDatas: any;
  public todoItems: any;
  public titleItem: string='';
  public taskItem: string='';
  GetTodoItem() {
    this.services.GetItems().subscribe(data => {
      this.todoItems = data;
    })
  }

  AddToItem() {
    let item = {
      title : this.titleItem,
      task: this.taskItem
    }
    
    if(this.titleItem.length ===0 || this.taskItem.length ===0){
      this.GetTodoItem();
    }else{
      
      this.services.AddItem(item).subscribe(data => {
        this.GetTodoItem();
        this.titleItem = '',
        this.taskItem =''
      })
    }

  }
  DeleteItem(item:any) {
    this.services.DeleteItem(item.id).subscribe(data =>{
      this.GetTodoItem();
      this.getTrash();
    } )
  }
  AddTrash(item:any) {
    let item1 = {
      title:item.title,
      task: item.task
    }
    this.services.AddItemTrash(item1).subscribe(data => {
      this.GetTodoItem();
    }) 
  }
  updateTask(item: any) {
    item.title = item.title 
    item.task = item.task
    this.services.updateItem(item.id,item).subscribe(data => {
      console.log(data)
      this.GetTodoItem();
    })
  }

  editTodo(item :any) {
    item.editing = true;
  }
  doneEdit(item :any) {
    item.editing = false
  }

  getTrash() {
    this.services.getAllTrashData().subscribe(data => {
      this.trashDatas =data;
    })
  }
  PermanentDeleteItem(item:any) {
    this.services.DeleteFromTrash(item.id).subscribe(data => {
      this.getTrash();
    })
  }

  restoreData(item: any) {
    let item1 = {
      title:item.title,
      task:item.task
    }
    this.services.AddItem(item1).subscribe(data => {
      console.log(data)
      this.GetTodoItem();
    })
  }
}
