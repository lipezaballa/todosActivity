import { Component, EventEmitter, Input, Output } from "@angular/core";
import { Todo } from "../todo.service";

@Component({
    selector: "app-todo-item",
    template: `
        <div class="wrapper" (click)="onRemove()">
            <div class="task-indicator">
                {{ item.task }}
            </div>
            <div class="priority-indicator" [style.background-color]="color">
                {{ item.priority }}
            </div>
        </div>
    `,
    styleUrls: ["todo-item.component.scss"],
})
export class TodoItemComponent {
    @Input() item!: Todo;
    @Output() remove = new EventEmitter<Todo>();

    get color() {
        switch (this.item.priority) {
            case 1:
                return "green";
            case 2:
                return "yellow";
            case 3:
                return "red";
        }
    }

    onRemove() {
        this.remove.emit(this.item);
    }
}
